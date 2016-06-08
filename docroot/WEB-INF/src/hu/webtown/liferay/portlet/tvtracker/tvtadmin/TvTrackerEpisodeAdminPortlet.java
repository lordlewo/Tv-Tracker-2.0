package hu.webtown.liferay.portlet.tvtracker.tvtadmin;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.util.bridges.mvc.MVCPortlet;

import hu.webtown.liferay.portlet.EpisodeAirDateException;
import hu.webtown.liferay.portlet.EpisodeDescriptionException;
import hu.webtown.liferay.portlet.EpisodeImageException;
import hu.webtown.liferay.portlet.EpisodeNumberException;
import hu.webtown.liferay.portlet.EpisodeTitleException;
import hu.webtown.liferay.portlet.NoSuchEpisodeException;
import hu.webtown.liferay.portlet.NoSuchSeasonException;
import hu.webtown.liferay.portlet.NoSuchTvShowException;
import hu.webtown.liferay.portlet.SeasonDescriptionException;
import hu.webtown.liferay.portlet.SeasonImageException;
import hu.webtown.liferay.portlet.SeasonNumberException;
import hu.webtown.liferay.portlet.SeasonPremierDateException;
import hu.webtown.liferay.portlet.SeasonTitleException;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class TvTrackerEpisodeAdminPortlet
 */
public class TvTrackerEpisodeAdminPortlet extends MVCPortlet {
 
	private static Log _logger = LogFactoryUtil.getLog(TvTrackerEpisodeAdminPortlet.class); 
	
	
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
	
	@Override
	protected boolean isSessionErrorException(Throwable cause) {
		
		boolean result = false;
		
		if(isEpisodeException(cause) || cause instanceof PrincipalException ) {
			
			result = true;
		}
		
		return result;
	}
	
	protected boolean isEpisodeException(Throwable cause) {
		
		boolean result = false;
		
		if (
			cause instanceof EpisodeAirDateException || 
			cause instanceof EpisodeDescriptionException ||
			cause instanceof EpisodeImageException ||
			cause instanceof EpisodeNumberException || 
			cause instanceof EpisodeTitleException ||
			cause instanceof NoSuchEpisodeException ) {
			
			result = true;
		}
		
		return result;
	}
}
