package hu.webtown.liferay.portlet.tvtracker.tvtadmin.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.BaseActionCommand;

import hu.webtown.liferay.portlet.NoSuchEpisodeException;
import hu.webtown.liferay.portlet.model.Episode;
import hu.webtown.liferay.portlet.service.EpisodeLocalServiceUtil;
import hu.webtown.liferay.portlet.tvtracker.util.CustomWebKeys;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public class DeleteEpisodeActionCommand extends BaseActionCommand {
	
	private static final Log _logger = LogFactoryUtil.getLog(DeleteEpisodeActionCommand.class);  

	
	@Override
	protected void doProcessCommand(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws PortletException {

		try{
			
			Episode deletedEpisode = deleteEpisode(portletRequest, portletResponse);
			
			SessionMessages.add(portletRequest, "delete-episode-successful");
			
			if (_logger.isDebugEnabled()) {
				
				long episodeId = deletedEpisode.getEpisodeId();
				
				_logger.debug("Episode: (id: " + episodeId + ") deleting was successful!");
			}
			
		} catch (Exception exception) {
			
			if (_logger.isErrorEnabled()){
				_logger.error(exception.getMessage(), exception);
			}
			
			if (exception instanceof PrincipalException) {
				
				SessionErrors.add(portletRequest, exception.getClass().getName());
				
			} else if (exception instanceof NoSuchEpisodeException ) {
			
				SessionErrors.add(portletRequest, exception.getClass().getName());
			
			} else {
					
				throw new PortletException(exception);
			}
		}
	}
	
	protected Episode deleteEpisode(PortletRequest portletRequest, PortletResponse portletResponse) throws Exception {
		
		ServiceContext serviceContext = ServiceContextFactory
				.getInstance(Episode.class.getName(), portletRequest);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(CustomWebKeys.THEME_DISPLAY);
		
		long groupId = themeDisplay.getScopeGroupId();
		
		long episodeId = ParamUtil.getLong(portletRequest, "episodeId");
	
		Episode deletedEpisode = 
				EpisodeLocalServiceUtil
					.deleteEpisode(groupId, episodeId, serviceContext);
		
		return deletedEpisode;
	}
}
