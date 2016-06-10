package hu.webtown.liferay.portlet.tvtracker.tvtadmin.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.BaseActionCommand;

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
import hu.webtown.liferay.portlet.model.Season;
import hu.webtown.liferay.portlet.model.TvShow;
import hu.webtown.liferay.portlet.model.impl.SeasonImpl;
import hu.webtown.liferay.portlet.model.impl.TvShowImpl;
import hu.webtown.liferay.portlet.service.TvShowLocalServiceUtil;
import hu.webtown.liferay.portlet.tvtracker.util.CustomCalendarUtil;
import hu.webtown.liferay.portlet.tvtracker.util.CustomWebKeys;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public class EditTvShowWithSeasonActionCommand extends BaseActionCommand{

	private static final Log _logger = LogFactoryUtil.getLog(EditTvShowWithSeasonActionCommand.class);
	
	
	@Override
	@SuppressWarnings("unchecked")
	protected void doProcessCommand(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws PortletException {
		
		try{
			
			List<List<? extends PersistedModel>> returnedModels = updateTvShowWithseason(portletRequest, portletResponse);
			
			TvShow updatedTvShow = (TvShow) returnedModels.get(0).get(0);
			List<Season> updatedSeasons = (List<Season>) returnedModels.get(1);
			List<Season> createdSeasons = (List<Season>) returnedModels.get(2);
			List<Season> deletedSeasons = (List<Season>) returnedModels.get(3);
			
			String redirectWhenSuccess = ParamUtil.getString(portletRequest, "redirectWhenSuccess");
			
			if (Validator.isNotNull(redirectWhenSuccess)) {

                PortalUtil.getHttpServletResponse(portletResponse).sendRedirect(redirectWhenSuccess);
            } else {

                ((ActionResponse) portletResponse).setRenderParameter("mvcPath", "/html/portlet/tvtracker/tvtadmin/tvshow/view.jsp");
            }
			
			SessionMessages.add(portletRequest, "update-tvshow-with-season-successful");
			
			if (_logger.isDebugEnabled()) {
				
				long tvShowId = updatedTvShow.getTvShowId();
				String tvShowTitle = updatedTvShow.getTvShowTitle();
				
				_logger.debug("TvShow: (id: " + tvShowId + ", title: " + tvShowTitle + ") updating was successful!");
				
				for (Season updatedSeason : updatedSeasons) {
					long seasonId = updatedSeason.getSeasonId();
					String seasonTitle = updatedSeason.getSeasonTitle();
					
					_logger.debug("Season: (id: " + seasonId + ", title: " + seasonTitle + ") updating was successful!");
				}
				
				for (Season createdSeason : createdSeasons) {
					long seasonId = createdSeason.getSeasonId();
					String seasonTitle = createdSeason.getSeasonTitle();
					
					_logger.debug("Season: (id: " + seasonId + ", title: " + seasonTitle + ") creating was successful!");
				}
				
				for (Season deletedSeason : deletedSeasons) {
					long seasonId = deletedSeason.getSeasonId();
					String seasonTitle = deletedSeason.getSeasonTitle();
					
					_logger.debug("Season: (id: " + seasonId + ", title: " + seasonTitle + ") deleting was successful!");
				}
			}
			
		} catch (Exception exception) {
			
			if (_logger.isErrorEnabled()){
				_logger.error(exception.getMessage(), exception);
			}
			
			if (exception instanceof PrincipalException) {
				
				SessionErrors.add(portletRequest, exception.getClass().getName());
				
			} else if (
						exception instanceof TvShowDescriptionException || 
						exception instanceof TvShowImageException ||
						exception instanceof TvShowPremierDateException ||
						exception instanceof TvShowTitleException || 
						exception instanceof NoSuchTvShowException || 
						exception instanceof SeasonDescriptionException || 
						exception instanceof SeasonImageException ||
						exception instanceof SeasonNumberException ||
						exception instanceof SeasonPremierDateException || 
						exception instanceof SeasonTitleException ||
						exception instanceof NoSuchSeasonException ) { 
				
				SessionErrors.add(portletRequest, exception.getClass().getName());
				
				// TODO
				((ActionResponse) portletResponse).setRenderParameter("mvcPath", "/html/portlet/tvtracker/tvtadmin/tvshow/edit.jsp");
				
			} else {
				
				throw new PortletException(exception);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	protected List<List<? extends PersistedModel>> updateTvShowWithseason(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws Exception {
		
		ServiceContext serviceContextForTvShow = ServiceContextFactory
				.getInstance(TvShow.class.getName(), portletRequest);
		
		ServiceContext serviceContextForSeason = ServiceContextFactory
				.getInstance(Season.class.getName(), portletRequest);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(CustomWebKeys.THEME_DISPLAY);
		
		long userId = themeDisplay.getUserId();
		long groupId = themeDisplay.getScopeGroupId();
		
		Locale locale = themeDisplay.getLocale();
		TimeZone timeZone = themeDisplay.getTimeZone();
		Calendar calendar = CustomCalendarUtil.getCalendar(locale, timeZone);
		
		/*********************************************************************************************/
		/*******/// Tv Show ///***********************************************************************/
		/*********************************************************************************************/
		
		int tvShowPremierDateDay = ParamUtil.getInteger(portletRequest, "tvShowPremierDateDay");
		int tvShowPremierDateMonth = ParamUtil.getInteger(portletRequest, "tvShowPremierDateMonth");
		int tvShowPremierDateYear = ParamUtil.getInteger(portletRequest, "tvShowPremierDateYear");
		
		calendar.set(tvShowPremierDateYear, tvShowPremierDateMonth, tvShowPremierDateDay);
		
		Date tvShowPremierDate = calendar.getTime();
		String tvShowTitle = ParamUtil.getString(portletRequest, "tvShowTitle");
		String tvShowDescription = ParamUtil.getString(portletRequest, "tvShowDescription");
		
		String tvShowImageUrl = ParamUtil.getString(portletRequest, "tvShowImageUrl");
		String tvShowImageUuid = ParamUtil.getString(portletRequest, "tvShowImageUuid");
		String tvShowImageTitle = ParamUtil.getString(portletRequest, "tvShowImageTitle");
		String tvShowImageVersion = ParamUtil.getString(portletRequest, "tvShowImageVersion");
		
		long tvShowId = ParamUtil.getLong(portletRequest, "tvShowId");
		
		TvShow tvShow = new TvShowImpl();
		tvShow.setTvShowId(tvShowId);
		tvShow.setTvShowTitle(tvShowTitle);
		tvShow.setTvShowPremierDate(tvShowPremierDate);
		tvShow.setTvShowDescription(tvShowDescription);
		tvShow.setTvShowImageUuid(tvShowImageUuid);
		tvShow.setTvShowImageUrl(tvShowImageUrl);
		tvShow.setTvShowImageTitle(tvShowImageTitle);
		tvShow.setTvShowImageVersion(tvShowImageVersion);
		
		/*********************************************************************************************/
		/*******/// Seasons ///***********************************************************************/
		/*********************************************************************************************/
		
		int[] rowIndexes = ParamUtil.getIntegerValues(portletRequest, "rowIndexes");
		
		List<Season> seasons = new ArrayList<Season>();
		
		for(int i = 0; i < rowIndexes.length; i++){
			
			int rowIndex = rowIndexes[i];
			
			calendar.clear();
			
			int seasonPremierDateDay = ParamUtil.getInteger(portletRequest, "seasonPremierDateDay" + rowIndex);
			int seasonPremierDateMonth = ParamUtil.getInteger(portletRequest, "seasonPremierDateMonth" + rowIndex);
			int seasonPremierDateYear = ParamUtil.getInteger(portletRequest, "seasonPremierDateYear" + rowIndex);
			
			calendar.set(seasonPremierDateYear, seasonPremierDateMonth, seasonPremierDateDay);
			
			Date seasonPremierDate = calendar.getTime();
			String seasonTitle = ParamUtil.getString(portletRequest, "seasonTitle" + rowIndex);
			int seasonNumber = ParamUtil.getInteger(portletRequest, "seasonNumber" + rowIndex);
			String seasonDescription = ParamUtil.getString(portletRequest, "seasonDescription" + rowIndex);
			
			String seasonImageUrl = ParamUtil.getString(portletRequest, "seasonImageUrl" + rowIndex);
			String seasonImageUuid = ParamUtil.getString(portletRequest, "seasonImageUuid" + rowIndex);
			String seasonImageTitle = ParamUtil.getString(portletRequest, "seasonImageTitle" + rowIndex);
			String seasonImageVersion = ParamUtil.getString(portletRequest, "seasonImageVersion" + rowIndex);
			
			long seasonId = ParamUtil.getLong(portletRequest, "seasonId" + rowIndex, 0);

			Season season = new SeasonImpl();
			season.setSeasonId(seasonId);
			season.setTvShowId(tvShowId);
			season.setSeasonTitle(seasonTitle);
			season.setSeasonPremierDate(seasonPremierDate);
			season.setSeasonNumber(seasonNumber);
			season.setSeasonDescription(seasonDescription);
			season.setSeasonImageUrl(seasonImageUrl);
			season.setSeasonImageUuid(seasonImageUuid);
			season.setSeasonImageTitle(seasonImageTitle);
			season.setSeasonImageVersion(seasonImageVersion);
			
			seasons.add(season);
		}
		
		List<List<? extends PersistedModel>> returnedModels = 
				(List<List<? extends PersistedModel>>) TvShowLocalServiceUtil
					.updateTvShowWithSeason(
							userId, groupId, 
							tvShow, seasons, 
							serviceContextForTvShow, 
							serviceContextForSeason);
		
		return returnedModels;
	}
}