package hu.webtown.liferay.portlet.tvtracker.tvtadmin;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.util.bridges.mvc.MVCPortlet;

import hu.webtown.liferay.portlet.NoSuchEpisodeException;
import hu.webtown.liferay.portlet.NoSuchSeasonException;
import hu.webtown.liferay.portlet.NoSuchTvShowException;
import hu.webtown.liferay.portlet.SeasonDescriptionException;
import hu.webtown.liferay.portlet.SeasonImageException;
import hu.webtown.liferay.portlet.SeasonNumberException;
import hu.webtown.liferay.portlet.SeasonPremierDateException;
import hu.webtown.liferay.portlet.SeasonTitleException;
import hu.webtown.liferay.portlet.TvShowDescriptionException;
import hu.webtown.liferay.portlet.TvShowImageException;
import hu.webtown.liferay.portlet.TvShowPremierDateException;
import hu.webtown.liferay.portlet.TvShowTitleException;

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
	
	@Override
	protected boolean isSessionErrorException(Throwable cause) {
		
		boolean result = false;
		
		if(isTvShowException(cause) || isSeasonException(cause) ||  cause instanceof PrincipalException ) {
			
			result = true;
		}
		
		return result;
	}
	
	protected boolean isTvShowException(Throwable cause){
		
		boolean result = false;
		
		if (
			cause instanceof TvShowDescriptionException || 
			cause instanceof TvShowImageException ||
			cause instanceof TvShowPremierDateException ||
			cause instanceof TvShowTitleException || 
			cause instanceof NoSuchTvShowException ) {
			
			result = true;
		}
		
		return result;
	}
	
	protected boolean isSeasonException(Throwable cause){
		
		boolean result = false;
		
		if (
			cause instanceof SeasonDescriptionException || 
			cause instanceof SeasonImageException ||
			cause instanceof SeasonNumberException ||
			cause instanceof SeasonPremierDateException || 
			cause instanceof SeasonTitleException ||
			cause instanceof NoSuchSeasonException ) {
			
			result = true;
		}
		
		return result;
	}
}
