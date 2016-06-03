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

import hu.webtown.liferay.portlet.model.TvShow;
import hu.webtown.liferay.portlet.service.TvShowLocalServiceUtil;
import hu.webtown.liferay.portlet.service.permission.CustomActionKeys;
import hu.webtown.liferay.portlet.service.permission.TvShowPermission;
import hu.webtown.liferay.portlet.service.persistence.TvShowActionableDynamicQuery;

import java.util.Date;
import java.util.Locale;

import javax.portlet.PortletURL;

public class TvShowIndexer extends BaseIndexer{

	private static final String PORTLET_ID = CustomPortletKeys.TVTRACKER_TVSHOW_ADMIN;
	private static final String[] CLASS_NAMES = {TvShow.class.getName()};
	
	private static final Log _logger = LogFactoryUtil.getLog(TvShowIndexer.class);

	public TvShowIndexer() {
		setFilterSearch(true);
		setPermissionAware(true);
	}
	
	@Override
	public String[] getClassNames() {
		return TvShowIndexer.CLASS_NAMES.clone();
	}

	@Override
	public String getPortletId() {
		return TvShowIndexer.PORTLET_ID;
	}
	
	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName, long entryClassPK, String actionId) 
			throws Exception {
		
		return TvShowPermission.contains(
				permissionChecker, 
				entryClassPK, 
				CustomActionKeys.VIEW);
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		
		TvShow tvShow = (TvShow) obj;
		
		long companyId = tvShow.getCompanyId();
		long tvShowId = tvShow.getTvShowId();
		
		deleteDocument(companyId, tvShowId);
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		
		TvShow tvShow = (TvShow) obj;
		
		Document document = getBaseModelDocument(TvShowIndexer.PORTLET_ID, tvShow);
		
		long classPK = tvShow.getTvShowId();
		
		document.addUID(PORTLET_ID, classPK);
		
		long scopeGroupId = tvShow.getGroupId();
		long groupId = getSiteGroupId(scopeGroupId);
		Date createDate = tvShow.getCreateDate();
		Date modifiedDate = tvShow.getModifiedDate();
		
		String tvShowTitle = tvShow.getTvShowTitle();
		int tvShowPremierYear = tvShow.getTvShowPremierYear();
		Date tvShowPremierDate = tvShow.getTvShowPremierDate();
		String tvShownDescription = tvShow.getTvShowDescription();
		
		document.addKeyword(Field.GROUP_ID, groupId);
		document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);
		
		document.addDate(Field.CREATE_DATE, createDate);
		document.addDate(Field.MODIFIED_DATE, modifiedDate);
		
		document.addText(Field.TITLE, tvShowTitle);
		document.addNumber(Field.CONTENT, tvShowPremierYear);
		document.addDate("tvShowPremierDate", tvShowPremierDate);
		document.addText(Field.DESCRIPTION, tvShownDescription);
		
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
		
		TvShow tvShow = (TvShow) obj;
		
		Document document = getDocument(tvShow);
		
		String searchEngineId = getSearchEngineId();
		long companyId = tvShow.getCompanyId();
		boolean commitImmediately = isCommitImmediately();
		
		SearchEngineUtil.updateDocument(searchEngineId, companyId, document, commitImmediately);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		
		TvShow tvShow = TvShowLocalServiceUtil.getTvShow(classPK);
		
		doReindex(tvShow);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		
		long companyId = GetterUtil.getLong(ids[0]);
		
		reindexTvShows(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return TvShowIndexer.PORTLET_ID;
	}
	
	private void reindexTvShows(long companyId) throws SystemException, PortalException{
		
		String searchEngineId = getSearchEngineId();
		
		ActionableDynamicQuery actionableDynamicQuery = new TvShowActionableDynamicQuery() {
			
			@Override
			protected void performAction(Object object) throws PortalException, SystemException {
				
				TvShow tvShow = (TvShow) object;
				
				Document document = getDocument(tvShow);
				
				addDocument(document);
			}
		};
		
		actionableDynamicQuery.setCompanyId(companyId);
		actionableDynamicQuery.setSearchEngineId(searchEngineId);

		actionableDynamicQuery.performActions();
	}
}
