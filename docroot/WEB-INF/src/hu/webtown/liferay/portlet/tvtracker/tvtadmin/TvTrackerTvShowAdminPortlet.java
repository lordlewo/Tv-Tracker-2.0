package hu.webtown.liferay.portlet.tvtracker.tvtadmin;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.util.bridges.mvc.MVCPortlet;

import hu.webtown.liferay.portlet.NoSuchEpisodeException;
import hu.webtown.liferay.portlet.NoSuchSeasonException;
import hu.webtown.liferay.portlet.NoSuchTvShowException;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class TvTrackerTvShowAdminPortlet
 */
public class TvTrackerTvShowAdminPortlet extends MVCPortlet {
	
	private static Log _logger = LogFactoryUtil.getLog(TvTrackerTvShowAdminPortlet.class); 
	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {

		super.render(renderRequest, renderResponse);
	}
	
	@Override
	protected void doDispatch(RenderRequest renderRequest, RenderResponse renderResponse) 
			throws IOException, PortletException {

		if (
			SessionErrors.contains(renderRequest, NoSuchTvShowException.class.getName()) || 
			SessionErrors.contains(renderRequest, NoSuchSeasonException.class.getName()) || 
			SessionErrors.contains(renderRequest, NoSuchEpisodeException.class.getName()) || 
			SessionErrors.contains(renderRequest, PrincipalException.class.getName()) ) {
			
			include(templatePath + "error.jsp", renderRequest, renderResponse);
        } else {
        	super.doDispatch(renderRequest, renderResponse);
		}
	}

}
