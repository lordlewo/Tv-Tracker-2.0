package hu.webtown.liferay.portlet.tvtracker.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.security.permission.PermissionChecker;

import hu.webtown.liferay.portlet.model.Episode;
import hu.webtown.liferay.portlet.service.permission.CustomActionKeys;
import hu.webtown.liferay.portlet.service.permission.EpisodePermission;

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
		
		Document document = getDocument(episode);
		boolean isCommitImmediately = isCommitImmediately();
		SearchEngineUtil.updateDocument(getSearchEngineId(), companyId, document, isCommitImmediately);
		
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
		
		String title = episode.getEpisodeTitle();
		Date airDate = episode.getEpisodeAirDate();
		String description = episode.getEpisodeDescription();
		
		document.addKeyword(Field.GROUP_ID, groupId);
		document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);
		
		document.addDate(Field.CREATE_DATE, createDate);
		document.addDate(Field.MODIFIED_DATE, modifiedDate);
		
		document.addText(Field.TITLE, title);
		document.addText(Field.DESCRIPTION, description);
		document.addDate(Field.CONTENT, airDate);
		
		
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		
		Episode episode = (Episode) obj;
		
		Document document = getDocument(episode);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		// TODO Auto-generated method stub
		return null;
	}
	
    protected String extractContent(Episode episode) {

        String content = episode.getEpisodeDescription();

        content = StringUtil.replace(content, "<![CDATA[", StringPool.BLANK);
        content = StringUtil.replace(content, "]]>", StringPool.BLANK);
        content = StringUtil.replace(content, "&amp;", "&");
        content = StringUtil.replace(content, "&lt;", "<");
        content = StringUtil.replace(content, "&gt;", ">");

        content = HtmlUtil.extractText(content);

        return content;
    }

}
