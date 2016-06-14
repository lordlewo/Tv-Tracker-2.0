package hu.webtown.liferay.portlet.tvtracker.tvtadmin.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.BaseActionCommand;

import hu.webtown.liferay.portlet.EpisodeAirDateException;
import hu.webtown.liferay.portlet.EpisodeDescriptionException;
import hu.webtown.liferay.portlet.EpisodeImageException;
import hu.webtown.liferay.portlet.EpisodeNumberException;
import hu.webtown.liferay.portlet.EpisodeTitleException;
import hu.webtown.liferay.portlet.NoSuchEpisodeException;
import hu.webtown.liferay.portlet.model.Episode;
import hu.webtown.liferay.portlet.service.EpisodeLocalServiceUtil;
import hu.webtown.liferay.portlet.tvtracker.util.CustomCalendarUtil;
import hu.webtown.liferay.portlet.tvtracker.util.CustomWebKeys;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public class EditEpisodeActionCommand extends BaseActionCommand {
	
	private Log _logger = LogFactoryUtil.getLog(EditEpisodeActionCommand.class);
	

	@Override
	protected void doProcessCommand(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws PortletException {
		
		try{
		
			Episode updatedEpisode = editEpisode(portletRequest, portletResponse);
			
			String redirectWhenSuccess = ParamUtil.getString(portletRequest, "redirectWhenSuccess");
			
			if (Validator.isNotNull(redirectWhenSuccess)) {

                PortalUtil.getHttpServletResponse(portletResponse).sendRedirect(redirectWhenSuccess);
            } else {

                ((ActionResponse) portletResponse).setRenderParameter("mvcPath", "/html/portlet/tvtracker/tvtadmin/episode/view.jsp");
            }
			
			SessionMessages.add(portletRequest, "update-episode-successful");

			if (_logger.isDebugEnabled()) {
				
				long episodeId = updatedEpisode.getEpisodeId();
				String episodeTitle = updatedEpisode.getEpisodeTitle();
				
				_logger.debug("Episode: (id: " + episodeId + ", title: " + episodeTitle + ") updating was successful!");
			}
		
		} catch (Exception exception) {
			
			if (_logger.isErrorEnabled()){
				_logger.error(exception.getMessage(), exception);
			}
			
			if (exception instanceof PrincipalException) {
				
				SessionErrors.add(portletRequest, exception.getClass().getName());
				
			} else if (
						exception instanceof EpisodeAirDateException || 
						exception instanceof EpisodeDescriptionException ||
						exception instanceof EpisodeImageException ||
						exception instanceof EpisodeNumberException || 
						exception instanceof EpisodeTitleException ||
						exception instanceof NoSuchEpisodeException ) {
				
				SessionErrors.add(portletRequest, exception.getClass().getName());
				
				// TODO
				((ActionResponse) portletResponse).setRenderParameter("mvcPath", "/html/portlet/tvtracker/tvtadmin/episode/edit.jsp");
				
			} else {
				
				throw new PortletException(exception);
			}
		}
	}
	
	protected Episode editEpisode(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws Exception {
		
		ServiceContext serviceContext = ServiceContextFactory
				.getInstance(Episode.class.getName(), portletRequest);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(CustomWebKeys.THEME_DISPLAY);
		
		long userId = themeDisplay.getUserId();
		long groupId = themeDisplay.getScopeGroupId();
		
		Locale locale = themeDisplay.getLocale();
		TimeZone timeZone = themeDisplay.getTimeZone();
		Calendar calendar = CustomCalendarUtil.getCalendar(locale, timeZone);
		
		int episodeAirDateDay = ParamUtil.getInteger(portletRequest, "episodeAirDateDay");
		int episodeAirDateMonth = ParamUtil.getInteger(portletRequest, "episodeAirDateMonth");
		int episodeAirDateYear = ParamUtil.getInteger(portletRequest, "episodeAirDateYear");
		
		int episodeAirDateMinute = ParamUtil.getInteger(portletRequest, "episodeAirDateMinute"); 
		int episodeAirDateHour = ParamUtil.getInteger(portletRequest, "episodeAirDateHour");
		int episodeAirDateAmPm = ParamUtil.getInteger(portletRequest, "episodeAirDateAmPm");
		
		calendar.set(episodeAirDateYear, episodeAirDateMonth, 
				episodeAirDateDay, episodeAirDateHour, episodeAirDateMinute);
		calendar.set(Calendar.AM_PM, episodeAirDateAmPm);
		
		Date episodeAirDate = calendar.getTime();
		String episodeTitle = ParamUtil.getString(portletRequest, "episodeTitle");
		int episodeNumber = ParamUtil.getInteger(portletRequest, "episodeNumber");
		String episodeDescription = ParamUtil.getString(portletRequest, "episodeDescription");
		
		String episodeImageUrl = ParamUtil.getString(portletRequest, "episodeImageUrl");
		String episodeImageUuid = ParamUtil.getString(portletRequest, "episodeImageUuid");
		String episodeImageTitle = ParamUtil.getString(portletRequest, "episodeImageTitle");
		String episodeImageVersion = ParamUtil.getString(portletRequest, "episodeImageVersion");
		
		long episodeId = ParamUtil.getLong(portletRequest, "episodeId");
		long seasonId = ParamUtil.getLong(portletRequest, "seasonId");
		
		Episode updatedEpisode = 
				EpisodeLocalServiceUtil.updateEpisode(
				userId, groupId, seasonId, episodeId, 
				episodeTitle, episodeAirDate, 
				episodeNumber, episodeDescription, 
				episodeImageUrl, episodeImageUuid, 
				episodeImageTitle, episodeImageVersion, 
				serviceContext);
		
		return updatedEpisode;
	}
}
