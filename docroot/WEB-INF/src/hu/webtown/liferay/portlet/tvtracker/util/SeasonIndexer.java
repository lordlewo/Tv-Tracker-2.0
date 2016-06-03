package hu.webtown.liferay.portlet.tvtracker.util;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.PermissionChecker;

import hu.webtown.liferay.portlet.model.Season;
import hu.webtown.liferay.portlet.service.SeasonLocalServiceUtil;
import hu.webtown.liferay.portlet.service.permission.CustomActionKeys;
import hu.webtown.liferay.portlet.service.permission.SeasonPermission;
import hu.webtown.liferay.portlet.service.persistence.SeasonActionableDynamicQuery;

import java.util.Date;
import java.util.Locale;

import javax.portlet.PortletURL;

public class SeasonIndexer extends BaseIndexer{
	
	private static final String PORTLET_ID = CustomPortletKeys.TVTRACKER_TVSHOW_ADMIN;
	private static final String[] CLASS_NAMES = {Season.class.getName()};
	
	private static final Log _logger = LogFactoryUtil.getLog(SeasonIndexer.class);

	public SeasonIndexer() {
		setFilterSearch(true);
		setPermissionAware(true);
	}
	
	@Override
	public String[] getClassNames() {
		return SeasonIndexer.CLASS_NAMES.clone();
	}

	@Override
	public String getPortletId() {
		return SeasonIndexer.PORTLET_ID;
	}
	
	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName, long entryClassPK, String actionId) 
			throws Exception {
		
		return SeasonPermission.contains(
				permissionChecker, 
				entryClassPK, 
				CustomActionKeys.VIEW);
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		
		Season season = (Season) obj;
		
		long companyId = season.getCompanyId();
		long seasonId = season.getSeasonId();
		
		deleteDocument(companyId, seasonId);
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		
		Season season = (Season) obj;
		
		Document document = getBaseModelDocument(SeasonIndexer.PORTLET_ID, season);
		
		long classPK = season.getSeasonId();
		
		document.addUID(PORTLET_ID, classPK);
		
		long scopeGroupId = season.getGroupId();
		long groupId = getSiteGroupId(scopeGroupId);
		Date createDate = season.getCreateDate();
		Date modifiedDate = season.getModifiedDate();
		
		String seasonTitle = season.getSeasonTitle();
		Date seasonPremierDate = season.getSeasonPremierDate();
		String seasonDescription = season.getSeasonDescription();
		
		document.addKeyword(Field.GROUP_ID, groupId);
		document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);
		
		document.addDate(Field.CREATE_DATE, createDate);
		document.addDate(Field.MODIFIED_DATE, modifiedDate);
		
		document.addText(Field.TITLE, seasonTitle);
		document.addDate(Field.CONTENT, seasonPremierDate);
		document.addText(Field.DESCRIPTION, seasonDescription);
		
		return document;
	}

	@Override
	protected String doGetSortField(String orderByCol) {
		// 	TODO
		return super.doGetSortField(orderByCol);
	}
	
	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL) throws Exception {
		
		int maxContentLength = 200;

		Summary summary = createSummary(document, Field.TITLE, Field.CONTENT);
		
        if (Validator.isNull(summary.getTitle())) {

            summary.setTitle(document.get(Field.TITLE));
        }

        if (Validator.isNull(summary.getContent())) {

            String content = snippet;

            if (Validator.isNull(snippet)) {

                content = document.get(Field.CONTENT);

                if (Validator.isNull(content)) {

                    content = document.get(Field.DESCRIPTION);
                }
            }

            summary.setContent(content);
        }
		
		summary.setMaxContentLength(maxContentLength);
		
		return summary;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		
		Season season = (Season) obj;
		
		Document document = getDocument(season);
		
		String searchEngineId = getSearchEngineId();
		long companyId = season.getCompanyId();
		boolean commitImmediately = isCommitImmediately();
		
		SearchEngineUtil.updateDocument(searchEngineId, companyId, document, commitImmediately);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		
		Season season = SeasonLocalServiceUtil.getSeason(classPK);
		
		doReindex(season);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		
		long companyId = GetterUtil.getLong(ids[0]);
		
		reindexSeasons(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return SeasonIndexer.PORTLET_ID;
	}
	
	private void reindexSeasons(long companyId) throws SystemException, PortalException{
		
		String searchEngineId = getSearchEngineId();
		
		ActionableDynamicQuery actionableDynamicQuery = new SeasonActionableDynamicQuery() {
			
			@Override
			protected void performAction(Object object) throws PortalException, SystemException {
				
				Season season = (Season) object;
				
				Document document = getDocument(season);
				
				addDocument(document);
			}
		};
		
		actionableDynamicQuery.setCompanyId(companyId);
		actionableDynamicQuery.setSearchEngineId(searchEngineId);

		actionableDynamicQuery.performActions();
	}
}
