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

import hu.webtown.liferay.portlet.model.TvShow;
import hu.webtown.liferay.portlet.service.permission.CustomActionKeys;
import hu.webtown.liferay.portlet.service.permission.TvShowPermission;
import hu.webtown.liferay.portlet.tvtracker.util.CustomPortletKeys;
import hu.webtown.liferay.portlet.tvtracker.util.CustomWebKeys;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

public class TvShowAssetRenderer extends BaseAssetRenderer {
	
	private static final Log _logger = LogFactoryUtil.getLog(TvShowAssetRenderer.class);
	
	private static final boolean ISPRINTABLE = true;
	
	private TvShow tvShow;
	
	public TvShowAssetRenderer(TvShow tvShow) {
		this.tvShow = tvShow;
	}

	public TvShow getTvShow() {
		return tvShow;
	}

	@Override
	public String getClassName() {
		return TvShow.class.getName();
	}

	@Override
	public long getClassPK() {
		return tvShow.getTvShowId();
	}

	@Override
	public long getGroupId() {
		return tvShow.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return tvShow.getTvShowDescription();
	}

	@Override
	public String getTitle(Locale locale) {
		return tvShow.getTvShowTitle();
	}
	
	@Override
	public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse) 
			throws Exception {
		
    	// TODO
		long plid = getControlPanelPlid(liferayPortletRequest);
		String tvShowId = String.valueOf(tvShow.getTvShowId());
		
		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
				plid, 
				CustomPortletKeys.TVTRACKER_TVSHOW_ADMIN, 
				PortletRequest.RENDER_PHASE);
		
		portletURL.setParameter("mvcPath", "/html/portlet/tvtracker/tvtadmin/tvshow/edit.jsp");
        portletURL.setParameter("tvShowId", tvShowId);
		
		return portletURL;
	}
	
	@Override
	public PortletURL getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) 
			throws Exception {
    	
		// TODO
		String tvShowId = String.valueOf(tvShow.getTvShowId());
		
		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
				CustomPortletKeys.TVTRACKER_PUBLIC, 
				PortletRequest.RENDER_PHASE);
		
		portletURL.setParameter("mvcPath", "/html/portlet/tvtracker/tvtpublic/view.jsp");
		portletURL.setParameter("tvShowId", tvShowId);
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
		
		if (group.getGroupId() != tvShow.getGroupId()) {
            group = GroupLocalServiceUtil.getGroup(tvShow.getGroupId());
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
		return tvShow.getUserId();
	}

	@Override
	public String getUserName() {
		return tvShow.getUserName();
	}

	@Override
	public String getUuid() {
		return tvShow.getUuid();
	}
	
	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker)
			throws PortalException, SystemException {

		long tvShowId = tvShow.getTvShowId();
		
		return TvShowPermission.contains(permissionChecker, tvShowId, CustomActionKeys.UPDATE);
	}
	
	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker)
			throws PortalException, SystemException {

		long tvShowId = tvShow.getTvShowId();
		
		return TvShowPermission.contains(permissionChecker, tvShowId, CustomActionKeys.VIEW);
	}
	
	@Override
	public boolean isPrintable() {
		return TvShowAssetRenderer.ISPRINTABLE;
	}

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template) 
			throws Exception {

		if (template.equalsIgnoreCase(TEMPLATE_ABSTRACT) || template.equalsIgnoreCase(TEMPLATE_FULL_CONTENT)) {
	            
			renderRequest.setAttribute(CustomWebKeys.TVSHOW, tvShow);
            
			return "/html/portlet/tvtracker/tvtadmin/asset/" + "tvshow_" + template + ".jsp";
			
        } else {
            return null;
        }
	}
	
    @Override
    protected String getIconPath(ThemeDisplay themeDisplay) {
        return themeDisplay.getPathThemeImages() + "/common/history.png";
    }
}
