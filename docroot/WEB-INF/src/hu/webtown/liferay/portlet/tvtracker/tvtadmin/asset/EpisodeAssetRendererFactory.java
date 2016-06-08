package hu.webtown.liferay.portlet.tvtracker.tvtadmin.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import hu.webtown.liferay.portlet.model.Episode;
import hu.webtown.liferay.portlet.service.EpisodeLocalServiceUtil;
import hu.webtown.liferay.portlet.service.permission.CustomActionKeys;
import hu.webtown.liferay.portlet.service.permission.EpisodePermission;
import hu.webtown.liferay.portlet.service.permission.TvTrackerModelPermission;
import hu.webtown.liferay.portlet.tvtracker.util.CustomPortletKeys;
import hu.webtown.liferay.portlet.tvtracker.util.CustomWebKeys;

public class EpisodeAssetRendererFactory extends BaseAssetRendererFactory {

	private static final String CLASS_NAME = Episode.class.getName();
	private static final String TYPE = "episode";
	private static final boolean LINKABLE = true;
	
	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type) throws PortalException, SystemException {
		
		Episode episode = EpisodeLocalServiceUtil.getEpisode(classPK);
		
		EpisodeAssetRenderer episodeAssetRenderer = new EpisodeAssetRenderer(episode);
		episodeAssetRenderer.setAssetRendererType(type);
		
		return episodeAssetRenderer;
	}
	
	@Override
	public AssetRenderer getAssetRenderer(long groupId, String urlTitle)
			throws PortalException, SystemException {
		
		// TODO
		return super.getAssetRenderer(groupId, urlTitle);
	}

	@Override
	public String getClassName() {
		return EpisodeAssetRendererFactory.CLASS_NAME;
	}

	@Override
	public String getType() {
		return EpisodeAssetRendererFactory.TYPE;
	}
	
	@Override
	public boolean isLinkable() {
		return EpisodeAssetRendererFactory.LINKABLE;
	}
	
	@Override
	public PortletURL getURLAdd(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse)
			throws PortalException, SystemException {

		// TODO
		HttpServletRequest request = liferayPortletRequest.getHttpServletRequest();

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(CustomWebKeys.THEME_DISPLAY);
		
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
		long groupId = themeDisplay.getScopeGroupId();
		
		if (!TvTrackerModelPermission.contains(permissionChecker, groupId, CustomActionKeys.ADD_EPISODE)) {
			return null;
		}
		
		long plid = getControlPanelPlid(themeDisplay);
		
		PortletURL portletURL =PortletURLFactoryUtil.create(
				request, 
                CustomPortletKeys.TVTRACKER_TVSHOW_ADMIN,
                plid, 
                PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcPath", "/html/portlet/tvtracker/tvtadmin/episode/edit.jsp");

        return portletURL;
	}
	
	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, long classPK, String actionId) throws Exception {
		return EpisodePermission.contains(permissionChecker, classPK, actionId);
	}
	
    @Override
    protected String getIconPath(ThemeDisplay themeDisplay) {
        return themeDisplay.getPathThemeImages() + "/common/history.png";
    }
}
