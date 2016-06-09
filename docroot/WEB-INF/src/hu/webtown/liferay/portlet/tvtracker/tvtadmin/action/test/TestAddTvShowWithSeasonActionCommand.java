package hu.webtown.liferay.portlet.tvtracker.tvtadmin.action.test;

import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.BaseActionCommand;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import hu.webtown.liferay.portlet.model.Season;
import hu.webtown.liferay.portlet.model.TvShow;
import hu.webtown.liferay.portlet.model.impl.SeasonImpl;
import hu.webtown.liferay.portlet.model.impl.TvShowImpl;
import hu.webtown.liferay.portlet.service.TvShowLocalServiceUtil;
import hu.webtown.liferay.portlet.tvtracker.util.CustomCalendarUtil;
import hu.webtown.liferay.portlet.tvtracker.util.CustomWebKeys;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public class TestAddTvShowWithSeasonActionCommand extends BaseActionCommand {

	@Override
	protected void doProcessCommand(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws Exception {
		
		ServiceContext serviceContextForTvShow = ServiceContextFactory.
				getInstance(TvShow.class.getName(), portletRequest);
		
		ServiceContext serviceContextForSeason = ServiceContextFactory.
				getInstance(Season.class.getName(), portletRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(CustomWebKeys.THEME_DISPLAY);
		
		long userId = themeDisplay.getUserId();
		long groupId = themeDisplay.getScopeGroupId();
		Locale locale = themeDisplay.getLocale();
		TimeZone timeZone = themeDisplay.getTimeZone();
		
		String tvShowTitle = "blabla";
		Calendar cal1 = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal1.set(2011, 11, 11);
		Date tvShowPremierDate = cal1.getTime();
		String tvShowDescription = "blablabla";
		String tvShowImageUrl = "cucc";
		String tvShowImageUuid = "cucc";
		String tvShowImageTitle = "cucc";
		String tvShowImageVersion = "cucc";
		
		TvShow tvShow = new TvShowImpl();
		tvShow.setTvShowTitle(tvShowTitle);
		tvShow.setTvShowPremierDate(tvShowPremierDate);
		tvShow.setTvShowDescription(tvShowDescription);
		tvShow.setTvShowImageUuid(tvShowImageUuid);
		tvShow.setTvShowImageUrl(tvShowImageUrl);
		tvShow.setTvShowImageTitle(tvShowImageTitle);
		tvShow.setTvShowImageVersion(tvShowImageVersion);
		
		
		String seasonTitle = "ühmühm";
		Calendar cal2 = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal2.set(2011, 11, 11);
		Date seasonPremierDate = cal2.getTime();
		int seasonNumber = 1;
		String seasonDescription = "ühmühmühm";
		String seasonImageUrl = "cucc";
		String seasonImageUuid = "cucc";
		String seasonImageTitle = "cucc";
		String seasonImageVersion = "cucc";
		
		Season season = new SeasonImpl();
		season.setSeasonTitle(seasonTitle);
		season.setSeasonPremierDate(seasonPremierDate);
		season.setSeasonNumber(seasonNumber);
		season.setSeasonDescription(seasonDescription);
		season.setSeasonImageUrl(seasonImageUrl);
		season.setSeasonImageUuid(seasonImageUuid);
		season.setSeasonImageTitle(seasonImageTitle);
		season.setSeasonImageVersion(seasonImageVersion);
		
		List<Season> seasons = new ArrayList<Season>();
		seasons.add(season);
		
		@SuppressWarnings("unchecked")
		List<List<? extends PersistedModel>> res = TvShowLocalServiceUtil.addTvShowWithSeason(
				userId, groupId, 
				tvShow, seasons, 
				serviceContextForTvShow, 
				serviceContextForSeason);
		
		System.out.println(((TvShow)res.get(0).get(0)).getTvShowTitle());
		System.out.println(((Season)res.get(1).get(0)).getSeasonTitle());
	}

}
