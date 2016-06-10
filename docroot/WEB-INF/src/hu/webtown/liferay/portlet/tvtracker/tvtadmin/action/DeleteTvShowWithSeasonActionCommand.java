package hu.webtown.liferay.portlet.tvtracker.tvtadmin.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.BaseActionCommand;

import hu.webtown.liferay.portlet.NoSuchSeasonException;
import hu.webtown.liferay.portlet.NoSuchTvShowException;
import hu.webtown.liferay.portlet.model.Season;
import hu.webtown.liferay.portlet.model.TvShow;
import hu.webtown.liferay.portlet.service.TvShowLocalServiceUtil;
import hu.webtown.liferay.portlet.tvtracker.util.CustomWebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public class DeleteTvShowWithSeasonActionCommand extends BaseActionCommand{

	private static final Log _logger = LogFactoryUtil.getLog(DeleteTvShowWithSeasonActionCommand.class);
	
	
	@Override
	@SuppressWarnings("unchecked")
	protected void doProcessCommand(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws PortletException {
		
		try{
			
			List<List<? extends PersistedModel>> returnedModels = deleteTvShowWithSeason(portletRequest, portletResponse);

			TvShow deletedTvShow = (TvShow) returnedModels.get(0).get(0);
			List<Season> deletedSeasons = (List<Season>) returnedModels.get(1);
			
			SessionMessages.add(portletRequest, "delete-tvshow-with-season-successful");
			
			if (_logger.isDebugEnabled()) {
				
				long tvShowId = deletedTvShow.getTvShowId();
				String tvShowTitle = deletedTvShow.getTvShowTitle();
				
				_logger.debug("TvShow: (id: " + tvShowId + ", title: " + tvShowTitle + ") deleting was successful!");
				
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
				
			} else if (exception instanceof NoSuchTvShowException || exception instanceof NoSuchSeasonException ) { 
				
				SessionErrors.add(portletRequest, exception.getClass().getName());
				
			} else {
				
				throw new PortletException(exception);
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected List<List<? extends PersistedModel>> deleteTvShowWithSeason(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws Exception {
		
		ServiceContext serviceContext = ServiceContextFactory
				.getInstance(TvShow.class.getName(), portletRequest);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(CustomWebKeys.THEME_DISPLAY);
		
		long groupId = themeDisplay.getScopeGroupId();
		
		long tvShowId = ParamUtil.getLong(portletRequest, "tvShowId");
		
		List<List<? extends PersistedModel>> returnedModels = 
				(List<List<? extends PersistedModel>>) TvShowLocalServiceUtil
					.deleteTvShowWithSeason(groupId, tvShowId, serviceContext);
		
		return returnedModels;
	}
}
