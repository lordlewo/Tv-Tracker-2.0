package hu.webtown.liferay.portlet.tvtracker.tvtadmin.action.test;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.BaseActionCommand;

import hu.webtown.liferay.portlet.model.Season;
import hu.webtown.liferay.portlet.model.TvShow;
import hu.webtown.liferay.portlet.service.SeasonLocalServiceUtil;
import hu.webtown.liferay.portlet.service.TvShowLocalServiceUtil;
import hu.webtown.liferay.portlet.tvtracker.util.CustomCalendarUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public class TestAddSeasonActionCommand extends BaseActionCommand {

	private static final Log _logger = LogFactoryUtil.getLog(TestAddSeasonActionCommand.class);
	
	@Override
	protected void doProcessCommand(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.
				getInstance(Season.class.getName(), portletRequest);
		
		long groupId = serviceContext.getScopeGroupId();
		
		int tvShowsCount = TvShowLocalServiceUtil.getTvShowsCount(groupId);
		
		if(tvShowsCount > 0){
			addGameOfThronesSeasons(serviceContext);
			addMrRobotSeasons(serviceContext);
			addSherlockSeasons(serviceContext);
		}
	}
	
	protected void addGameOfThronesSeasons(ServiceContext serviceContext) 
			throws PortalException, SystemException {
		
		long userId = serviceContext.getUserId();
		long groupId = serviceContext.getScopeGroupId();		
		Locale locale = serviceContext.getLocale();
		TimeZone timeZone = serviceContext.getTimeZone();
		
		List<TvShow> tvShows = TvShowLocalServiceUtil.getTvShows(groupId);
		
		long tvShowId = tvShows.get(0).getTvShowId();
		String seasonTitle = "Season 1";
		Calendar cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2011, 4, 18);
		Date seasonPremierDate = cal.getTime();
		int seasonNumber = 1;
		String seasonDescription = 
				"The first season of the epic fantasy television drama series Game of Thrones premiered on HBO on April 17, 2011, "
				+ "and concluded on June 19, 2011, airing on Sunday at 9:00 pm in the United States. "
				+ "It consisted of 10 episodes, each running approximately 55 minutes in length. "
				+ "Game of Thrones is based on the novel A Game of Thrones, "
				+ "the first entry in A Song of Ice and Fire series by George R. R. Martin. The story takes place in a fictional world, "
				+ "primarily upon a continent called Westeros. The noble House Stark, "
				+ "led by Lord Eddard \"Ned\" Stark is drawn into schemes against King Robert Baratheon,"
				+ " when the Hand of the King Jon Arryn dies mysteriously.";
		String seasonImageUrl = "cucc";
		String seasonImageUuid = "cucc";
		String seasonImageTitle = "cucc";
		String seasonImageVersion = "cucc";

		SeasonLocalServiceUtil.addSeason(
				userId, groupId, tvShowId, 
				seasonTitle, seasonPremierDate, 
				seasonNumber, seasonDescription, 
				seasonImageUrl, seasonImageUuid, 
				seasonImageTitle, seasonImageVersion, 
				serviceContext);

		/********************************************************************************************************************************/
		/********************************************************************************************************************************/
		
		tvShowId = tvShows.get(0).getTvShowId();
		seasonTitle = "Season 2";
		cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2012, 4, 2);
		seasonPremierDate = cal.getTime();
		seasonNumber = 2;
		seasonDescription = 
				"The second season of the epic fantasy drama television series Game of Thrones premiered in the United States on HBO "
				+ "on April 1, 2012, and concluded on June 3, 2012. Like the first season, it consists of ten episodes. "
				+ "It mostly covers the events of A Clash of Kings, the second book of the A Song of Ice and Fire novels by George R. R. Martin, "
				+ "of which the series is an adaptation.";
		seasonImageUrl = "cucc";
		seasonImageUuid = "cucc";
		seasonImageTitle = "cucc";
		seasonImageVersion = "cucc";
		
		SeasonLocalServiceUtil.addSeason(
				userId, groupId, tvShowId, 
				seasonTitle, seasonPremierDate, 
				seasonNumber, seasonDescription, 
				seasonImageUrl, seasonImageUuid, 
				seasonImageTitle, seasonImageVersion, 
				serviceContext);
		
		/********************************************************************************************************************************/
		/********************************************************************************************************************************/
		
		tvShowId = tvShows.get(0).getTvShowId();
		seasonTitle = "Season 3";
		cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2013, 4, 1);
		seasonPremierDate = cal.getTime();
		seasonNumber = 3;
		seasonDescription = 
				"The third season of the epic fantasy drama television series Game of Thrones premiered on March 31, 2013 on HBO. "
				+ "HBO renewed the series for a third season on April 10, 2012, nine days after the second season's premiere. "
				+ "Production began in July 2012. Like the other seasons, the third season consists of ten episodes. "
				+ "It is based roughly on the first half of A Storm of Swords of which the series is an adaptation.";
		seasonImageUrl = "cucc";
		seasonImageUuid = "cucc";
		seasonImageTitle = "cucc";
		seasonImageVersion = "cucc";
		
		SeasonLocalServiceUtil.addSeason(
				userId, groupId, tvShowId, 
				seasonTitle, seasonPremierDate, 
				seasonNumber, seasonDescription, 
				seasonImageUrl, seasonImageUuid, 
				seasonImageTitle, seasonImageVersion, 
				serviceContext);
		
		/********************************************************************************************************************************/
		/********************************************************************************************************************************/
		
		tvShowId = tvShows.get(0).getTvShowId();
		seasonTitle = "Season 4";
		cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2014, 4, 7);
		seasonPremierDate = cal.getTime();
		seasonNumber = 4;
		seasonDescription = 
				"The War of the Five Kings is drawing to a close, "
				+ "but new intrigues and plots are in motion, "
				+ "and the surviving factions must contend with enemies not only outside their ranks, but within.";	
		seasonImageUrl = "cucc";
		seasonImageUuid = "cucc";
		seasonImageTitle = "cucc";
		seasonImageVersion = "cucc";
		
		SeasonLocalServiceUtil.addSeason(
				userId, groupId, tvShowId, 
				seasonTitle, seasonPremierDate, 
				seasonNumber, seasonDescription, 
				seasonImageUrl, seasonImageUuid, 
				seasonImageTitle, seasonImageVersion, 
				serviceContext);
		
		/********************************************************************************************************************************/
		/********************************************************************************************************************************/
		
		tvShowId = tvShows.get(0).getTvShowId();
		seasonTitle = "Season 5";
		cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2015, 4, 13);
		seasonPremierDate = cal.getTime();
		seasonNumber = 5;
		seasonDescription = 
				"The War of the Five Kings, once thought to be drawing to a close, "
				+ "is instead entering a new and more chaotic phase. "
				+ "Westeros is on the brink of collapse, and many are seizing what they can while the realm implodes, "
				+ "like a corpse making a feast for crows.";
		seasonImageUrl = "cucc";
		seasonImageUuid = "cucc";
		seasonImageTitle = "cucc";
		seasonImageVersion = "cucc";
		
		SeasonLocalServiceUtil.addSeason(
				userId, groupId, tvShowId, 
				seasonTitle, seasonPremierDate, 
				seasonNumber, seasonDescription, 
				seasonImageUrl, seasonImageUuid, 
				seasonImageTitle, seasonImageVersion, 
				serviceContext);
		
		/********************************************************************************************************************************/
		/********************************************************************************************************************************/
		
		tvShowId = tvShows.get(0).getTvShowId();
		seasonTitle = "Season 6";
		cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2016, 4, 25);
		seasonPremierDate = cal.getTime();
		seasonNumber = 6;
		seasonDescription = 
				"Seven noble families fight for control of the mythical land of Westeros. "
				+ "Friction between the houses leads to full-scale war. "
				+ "All while a very ancient evil awakens in the farthest north. "
				+ "Amidst the war, a neglected military order of misfits, the Night's Watch, "
				+ "is all that stands between the realms of men and the icy horrors beyond.";
		seasonImageUrl = "cucc";
		seasonImageUuid = "cucc";
		seasonImageTitle = "cucc";
		seasonImageVersion = "cucc";
		
		SeasonLocalServiceUtil.addSeason(
				userId, groupId, tvShowId, 
				seasonTitle, seasonPremierDate, 
				seasonNumber, seasonDescription, 
				seasonImageUrl, seasonImageUuid, 
				seasonImageTitle, seasonImageVersion, 
				serviceContext);
		
	}
	
	protected void addMrRobotSeasons(ServiceContext serviceContext) 
			throws PortalException, SystemException {

		long userId = serviceContext.getUserId();
		long groupId = serviceContext.getScopeGroupId();		
		Locale locale = serviceContext.getLocale();
		TimeZone timeZone = serviceContext.getTimeZone();
		
		List<TvShow> tvShows = TvShowLocalServiceUtil.getTvShows(groupId);
		
		long tvShowId = tvShows.get(1).getTvShowId();
		String seasonTitle = "Season 1";
		Calendar cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2015, 6, 25);
		Date seasonPremierDate = cal.getTime();
		int seasonNumber = 1;
		String seasonDescription = 
				"The show follows Elliot, who is a cyber-security tech by day and vigilante hacker by night. "
				+ "He has used his hacking skills for justice and to protect those he cares about, "
				+ "but has problems connecting to people in the real world due to social anxiety. "
				+ "He strongly believes that the world is being ruled by the 1% of the 1% and, that using money and debt, "
				+ "they have enslaved mankind and he wishes desperately to change this. "
				+ "He is recruited by the head of a highly secret hacking group to take down the";
		String seasonImageUrl = "cucc";
		String seasonImageUuid = "cucc";
		String seasonImageTitle = "cucc";
		String seasonImageVersion = "cucc";
		
		SeasonLocalServiceUtil.addSeason(
				userId, groupId, tvShowId, 
				seasonTitle, seasonPremierDate, 
				seasonNumber, seasonDescription, 
				seasonImageUrl, seasonImageUuid, 
				seasonImageTitle, seasonImageVersion, 
				serviceContext);
		
		/********************************************************************************************************************************/
		/********************************************************************************************************************************/
		
		tvShowId = tvShows.get(1).getTvShowId();
		seasonTitle = "Season 2";
		cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2015, 6, 25);
		seasonPremierDate = cal.getTime();
		seasonNumber = 2;
		seasonDescription = "The show follows Elliot, who is a cyber-security tech by day and vigilante hacker by night. "
				+ "He has used his hacking skills for justice and to protect those he cares about, "
				+ "but has problems connecting to people in the real world due to social anxiety. "
				+ "He strongly believes that the world is being ruled by the 1% of the 1% and, that using money and debt, "
				+ "they have enslaved mankind and he wishes desperately to change this. "
				+ "He is recruited by the head of a highly secret hacking group to take down the";
		seasonImageUrl = "cucc";
		seasonImageUuid = "cucc";
		seasonImageTitle = "cucc";
		seasonImageVersion = "cucc";
		
		SeasonLocalServiceUtil.addSeason(
				userId, groupId, tvShowId, 
				seasonTitle, seasonPremierDate, 
				seasonNumber, seasonDescription, 
				seasonImageUrl, seasonImageUuid, 
				seasonImageTitle, seasonImageVersion, 
				serviceContext);
	}
	
	protected void addSherlockSeasons(ServiceContext serviceContext) 
			throws PortalException, SystemException {
		
		long userId = serviceContext.getUserId();
		long groupId = serviceContext.getScopeGroupId();		
		Locale locale = serviceContext.getLocale();
		TimeZone timeZone = serviceContext.getTimeZone();
		
		List<TvShow> tvShows = TvShowLocalServiceUtil.getTvShows(groupId);
		
		long tvShowId = tvShows.get(2).getTvShowId();
		String seasonTitle = "Season 1";
		Calendar cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2010, 7, 25);
		Date seasonPremierDate = cal.getTime();
		int seasonNumber = 1;
		String seasonDescription = 
				"Sherlock is a British television crime drama, "
				+ "that presents a contemporary adaptation of Sir Arthur Conan Doyle's Sherlock Holmes detective stories. "
				+ "Created by Steven Moffat and Mark Gatiss, "
				+ "it stars Benedict Cumberbatch as Sherlock Holmes and Martin Freeman as Doctor John Watson.";
		String seasonImageUrl = "cucc";
		String seasonImageUuid = "cucc";
		String seasonImageTitle = "cucc";
		String seasonImageVersion = "cucc";
		
		SeasonLocalServiceUtil.addSeason(
				userId, groupId, tvShowId, 
				seasonTitle, seasonPremierDate, 
				seasonNumber, seasonDescription, 
				seasonImageUrl, seasonImageUuid, 
				seasonImageTitle, seasonImageVersion, 
				serviceContext);
		
		/********************************************************************************************************************************/
		/********************************************************************************************************************************/
		
		tvShowId = tvShows.get(2).getTvShowId();
		seasonTitle = "Season 2";
		cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2012, 1, 1);
		seasonPremierDate = cal.getTime();
		seasonNumber = 2;
		seasonDescription = 
				"Sherlock is a British television crime drama, "
				+ "that presents a contemporary adaptation of Sir Arthur Conan Doyle's Sherlock Holmes detective stories. "
				+ "Created by Steven Moffat and Mark Gatiss, "
				+ "it stars Benedict Cumberbatch as Sherlock Holmes and Martin Freeman as Doctor John Watson.";
		seasonImageUrl = "cucc";
		seasonImageUuid = "cucc";
		seasonImageTitle = "cucc";
		seasonImageVersion = "cucc";
		
		SeasonLocalServiceUtil.addSeason(
				userId, groupId, tvShowId, 
				seasonTitle, seasonPremierDate, 
				seasonNumber, seasonDescription, 
				seasonImageUrl, seasonImageUuid, 
				seasonImageTitle, seasonImageVersion, 
				serviceContext);
	}
}
