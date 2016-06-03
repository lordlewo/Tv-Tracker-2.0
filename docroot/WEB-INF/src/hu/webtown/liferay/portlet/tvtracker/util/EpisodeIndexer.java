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

import hu.webtown.liferay.portlet.model.Episode;
import hu.webtown.liferay.portlet.service.EpisodeLocalServiceUtil;
import hu.webtown.liferay.portlet.service.permission.CustomActionKeys;
import hu.webtown.liferay.portlet.service.permission.EpisodePermission;
import hu.webtown.liferay.portlet.service.persistence.EpisodeActionableDynamicQuery;

import java.util.Date;
import java.util.Locale;

import javax.portlet.PortletURL;

public class EpisodeIndexer extends BaseIndexer{

	private static final String PORTLET_ID = CustomPortletKeys.TVTRACKER_EPISODE_ADMIN;
	private static final String[] CLASS_NAMES = {Episode.class.getName()};
	
	private static final Log _logger = LogFactoryUtil.getLog(EpisodeIndexer.class);
	
	public EpisodeIndexer() {
		setFilterSearch(true);
		setPermissionAware(true);
	}
	
	@Override
	public String[] getClassNames() {
		return EpisodeIndexer.CLASS_NAMES.clone();
	}

	@Override
	public String getPortletId() {
		return EpisodeIndexer.PORTLET_ID;
	}
	
	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName, long entryClassPK, String actionId) 
			throws Exception {
		
		return EpisodePermission.contains(
				permissionChecker, 
				entryClassPK, 
				CustomActionKeys.VIEW);
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		
		Episode episode = (Episode) obj;
		
		long companyId = episode.getCompanyId();
		long episodeId = episode.getEpisodeId();
		
		deleteDocument(companyId, episodeId);
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		
		Episode episode = (Episode) obj;
		
		Document document = getBaseModelDocument(EpisodeIndexer.PORTLET_ID, episode);
		
		long classPK = episode.getEpisodeId();

        document.addUID(PORTLET_ID, classPK);
        
		long scopeGroupId = episode.getGroupId();
		long groupId = getSiteGroupId(scopeGroupId);
		Date createDate = episode.getCreateDate();
		Date modifiedDate = episode.getModifiedDate();
		
		String episodeTitle = episode.getEpisodeTitle();
		Date episodeAirDate = episode.getEpisodeAirDate();
		String episodeDescription = episode.getEpisodeDescription();
		
		document.addKeyword(Field.GROUP_ID, groupId);
		document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);
		
		document.addDate(Field.CREATE_DATE, createDate);
		document.addDate(Field.MODIFIED_DATE, modifiedDate);
		
		document.addText(Field.TITLE, episodeTitle);
		document.addDate(Field.CONTENT, episodeAirDate);
		document.addText(Field.DESCRIPTION, episodeDescription);
		
		
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
		
		Episode episode = (Episode) obj;
		
		Document document = getDocument(episode);
		
		String searchEngineId = getSearchEngineId();
		long companyId = episode.getCompanyId();
		boolean commitImmediately = isCommitImmediately();
		
		SearchEngineUtil.updateDocument(searchEngineId, companyId, document, commitImmediately);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		
		Episode episode = EpisodeLocalServiceUtil.getEpisode(classPK);
		
		doReindex(episode);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		
		long companyId = GetterUtil.getLong(ids[0]);
		
		reindexEpisodes(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return EpisodeIndexer.PORTLET_ID;
	}
	
	private void reindexEpisodes(long companyId) throws SystemException, PortalException{
		
		String searchEngineId = getSearchEngineId();
		
		ActionableDynamicQuery actionableDynamicQuery = new EpisodeActionableDynamicQuery() {
			
			@Override
			protected void performAction(Object object) throws PortalException, SystemException {
				
				Episode episode = (Episode) object;
				
				Document document = getDocument(episode);
				
				addDocument(document);
			}
		};
		
		actionableDynamicQuery.setCompanyId(companyId);
		actionableDynamicQuery.setSearchEngineId(searchEngineId);

		actionableDynamicQuery.performActions();
	}
}
