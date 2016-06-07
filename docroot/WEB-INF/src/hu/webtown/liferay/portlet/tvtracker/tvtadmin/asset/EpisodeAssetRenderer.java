package hu.webtown.liferay.portlet.tvtracker.tvtadmin.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.model.Group;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

import hu.webtown.liferay.portlet.model.Episode;
import hu.webtown.liferay.portlet.model.Season;
import hu.webtown.liferay.portlet.service.SeasonLocalServiceUtil;
import hu.webtown.liferay.portlet.service.permission.CustomActionKeys;
import hu.webtown.liferay.portlet.service.permission.EpisodePermission;
import hu.webtown.liferay.portlet.tvtracker.util.CustomPortletKeys;
import hu.webtown.liferay.portlet.tvtracker.util.CustomWebKeys;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

public class EpisodeAssetRenderer extends BaseAssetRenderer {
	
	private static final Log _logger = LogFactoryUtil.getLog(EpisodeAssetRenderer.class);
	
	private Episode episode;
	
	public EpisodeAssetRenderer(Episode episode) {
		this.episode = episode;
	}

	public Episode getEpisode() {
		return episode;
	}

	@Override
	public String getClassName() {
		return Episode.class.getName();
	}

	@Override
	public long getClassPK() {
		return episode.getEpisodeId();
	}

	@Override
	public long getGroupId() {
		return episode.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return episode.getEpisodeDescription();
	}

	@Override
	public String getTitle(Locale locale) {
		return episode.getEpisodeDescription();
	}
	
	@Override
	public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse) 
			throws Exception {
    	
		// TODO
		long plid = getControlPanelPlid(liferayPortletRequest);
		String episodeId = String.valueOf(episode.getEpisodeId());
		
		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
				plid, 
				CustomPortletKeys.TVTRACKER_EPISODE_ADMIN, 
				PortletRequest.RENDER_PHASE);
		
		portletURL.setParameter("mvcPath", "/html/portlet/tvtracker/tvtadmin/episode/edit.jsp");
        portletURL.setParameter("episodeId", episodeId);
		
		return portletURL;
	}
	
	@Override
	public PortletURL getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) 
			throws Exception {
    	
		// TODO
		String episodeId = String.valueOf(episode.getEpisodeId());
		String seasonId = String.valueOf(episode.getSeasonId());
		
		Season season = SeasonLocalServiceUtil.getSeason(episode.getSeasonId());
		String tvShowId = String.valueOf(season.getTvShowId());
		
		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
				CustomPortletKeys.TVTRACKER_PUBLIC, 
				PortletRequest.RENDER_PHASE);
		
		portletURL.setParameter("mvcPath", "/html/portlet/tvtracker/tvtpublic/view.jsp");
		portletURL.setParameter("tvShowId", tvShowId);
		portletURL.setParameter("seasonId", seasonId);
		portletURL.setParameter("episodeId", episodeId);
		portletURL.setWindowState(windowState);
		
		return null;
	}
	
	@Override
	public String getURLViewInContext(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			String noSuchEntryRedirect) throws Exception {
    	
		// TODO
		ThemeDisplay themeDisplay = (ThemeDisplay) liferayPortletRequest.getAttribute(CustomWebKeys.THEME_DISPLAY);
		
		Group group = themeDisplay.getScopeGroup();
		
		if (group.getGroupId() != episode.getGroupId()) {
            group = GroupLocalServiceUtil.getGroup(episode.getGroupId());
        }

		return null;
	}
	
    @Override
    public String getUrlTitle() {
    	// TODO
        return null;
    }

	@Override
	public long getUserId() {
		return episode.getUserId();
	}

	@Override
	public String getUserName() {
		return episode.getUserName();
	}

	@Override
	public String getUuid() {
		return episode.getUuid();
	}
	
	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker)
			throws PortalException, SystemException {

		long episodeId = episode.getEpisodeId();
		
		return EpisodePermission.contains(permissionChecker, episodeId, CustomActionKeys.UPDATE);
	}
	
	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker)
			throws PortalException, SystemException {

		long episodeId = episode.getEpisodeId();
		
		return EpisodePermission.contains(permissionChecker, episodeId, CustomActionKeys.VIEW);
	}
	
	@Override
	public boolean isPrintable() {
		return true;
	}

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template) 
			throws Exception {

		if (template.equalsIgnoreCase(TEMPLATE_ABSTRACT) || template.equalsIgnoreCase(TEMPLATE_FULL_CONTENT)) {
	            
			renderRequest.setAttribute(CustomWebKeys.EPISODE, episode);
            
			return "/html/portlet/tvtracker/tvtadmin/asset/" + "episode_" + template + ".jsp";
			
        } else {
            return null;
        }
	}
	
    @Override
    protected String getIconPath(ThemeDisplay themeDisplay) {
        return themeDisplay.getPathThemeImages() + "/common/history.png";
    }
}
