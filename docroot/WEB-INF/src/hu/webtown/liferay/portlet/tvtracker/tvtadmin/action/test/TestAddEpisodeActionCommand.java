package hu.webtown.liferay.portlet.tvtracker.tvtadmin.action.test;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.BaseActionCommand;

import hu.webtown.liferay.portlet.model.Episode;
import hu.webtown.liferay.portlet.model.Season;
import hu.webtown.liferay.portlet.model.TvShow;
import hu.webtown.liferay.portlet.service.EpisodeLocalServiceUtil;
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

public class TestAddEpisodeActionCommand extends BaseActionCommand {
	
	private static final Log _logger = LogFactoryUtil.getLog(TestAddEpisodeActionCommand.class);

	@Override
	protected void doProcessCommand(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws SystemException, PortalException {

		ServiceContext serviceContext = ServiceContextFactory.
				getInstance(Episode.class.getName(), portletRequest);
		
		long groupId = serviceContext.getScopeGroupId();
		
		int tvShowsCount = TvShowLocalServiceUtil.getTvShowsCount(groupId);
		
		if(tvShowsCount > 0){
			
			List<TvShow> tvShows = TvShowLocalServiceUtil.getTvShows(groupId);
			TvShow got = tvShows.get(0);
			long tvShowId = got.getTvShowId();
			
			int seasonCount = SeasonLocalServiceUtil.getSeasonsCount(groupId, tvShowId);
			
			if(seasonCount > 0){
				addGameOfThronesSeasonOneEpisodes(serviceContext);
			}
		}
	}
	
	protected void addGameOfThronesSeasonOneEpisodes(ServiceContext serviceContext) 
			throws SystemException, PortalException {
		
		long userId = serviceContext.getUserId();
		long groupId = serviceContext.getScopeGroupId();		
		Locale locale = serviceContext.getLocale();
		TimeZone timeZone = serviceContext.getTimeZone();
		
		List<Season> seasons = SeasonLocalServiceUtil.getSeasons(groupId);
		
		long seasonId = seasons.get(0).getSeasonId();
		String episodeTitle = "Winter Is Coming";
		Calendar cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2011, 4, 18);
		Date episodeAirDate = cal.getTime();
		int episodeNumber = 1;
		String episodeDescription = 
				"Ned Stark, Lord of Winterfell learns that his mentor, "
				+ "Jon Arryn, has died and that King Robert is on his way north to offer Ned Arryn’s position as the King’s Hand. "
				+ "Across the Narrow Sea in Pentos, "
				+ "Viserys Targaryen plans to wed his sister Daenerys to the nomadic Dothraki warrior leader, "
				+ "Khal Drogo to forge an alliance to take the throne.";
		String episodeImageUrl = "cucc";
		String episodeImageUuid = "cucc";
		String episodeImageTitle = "cucc";
		String episodeImageVersion = "cucc";
		
		EpisodeLocalServiceUtil.addEpisode(
				userId, groupId, seasonId,
				episodeTitle, episodeAirDate, 
				episodeNumber, episodeDescription, 
				episodeImageUrl, episodeImageUuid, 
				episodeImageTitle, episodeImageVersion, 
				serviceContext);
		
		/********************************************************************************************************************************/
		/********************************************************************************************************************************/
		
		seasonId = seasons.get(0).getSeasonId();
		episodeTitle = "The Kingsroad";
		cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2011, 4, 25);
		episodeAirDate = cal.getTime();
		episodeNumber = 2;
		episodeDescription = 
				"Having agreed to become the King’s Hand, Ned leaves Winterfell with daughters Sansa and Arya, "
				+ "while Catelyn stays behind in Winterfell. Jon Snow heads north to join the brotherhood of the Night’s Watch. "
				+ "Tyrion decides to forego the trip south with his family, instead joining Jon in the entourage heading to the Wall. "
				+ "Viserys bides his time in hopes of winning back the throne, "
				+ "while Daenerys focuses her attention on learning how to please her new husband, Drogo.";
		episodeImageUrl = "cucc";
		episodeImageUuid = "cucc";
		episodeImageTitle = "cucc";
		episodeImageVersion = "cucc";
		
		EpisodeLocalServiceUtil.addEpisode(
				userId, groupId, seasonId,
				episodeTitle, episodeAirDate, 
				episodeNumber, episodeDescription, 
				episodeImageUrl, episodeImageUuid, 
				episodeImageTitle, episodeImageVersion, 
				serviceContext);
		
		/********************************************************************************************************************************/
		/********************************************************************************************************************************/
		
		seasonId = seasons.get(0).getSeasonId();
		episodeTitle = "Lord Snow";
		cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2011, 5, 2);
		episodeAirDate = cal.getTime();
		episodeNumber = 3;
		episodeDescription = 
				"Arriving at King’s Landing, Ned is shocked to learn of the Crown’s profligacy from his new advisors. "
				+ "At Castle Black, Jon Snow impresses Tyrion at the expense of greener recruits. "
				+ "Suspecting the Lannisters had a hand in Bran’s fall, Catelyn covertly follows her husband to King’s Landing, "
				+ "where she is intercepted by Petyr Baelish, a.k.a. “Littlefinger,” a shrewd longtime ally and brothel owner. "
				+ "Cersei and Jaime ponder the implications of Bran’s recovery; Arya studies swordsmanship. On the road to Vaes Dothrak, "
				+ "Daenerys finds herself at odds with Viserys.";
		episodeImageUrl = "cucc";
		episodeImageUuid = "cucc";
		episodeImageTitle = "cucc";
		episodeImageVersion = "cucc";
		
		EpisodeLocalServiceUtil.addEpisode(
				userId, groupId, seasonId,
				episodeTitle, episodeAirDate, 
				episodeNumber, episodeDescription, 
				episodeImageUrl, episodeImageUuid, 
				episodeImageTitle, episodeImageVersion, 
				serviceContext);
		
		/********************************************************************************************************************************/
		/********************************************************************************************************************************/
		
		seasonId = seasons.get(0).getSeasonId();
		episodeTitle = "Cripples, Bastards, and Broken Things";
		cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2011, 5, 9);
		episodeAirDate = cal.getTime();
		episodeNumber = 4;
		episodeDescription = 
				"Ned looks for clues to the death of his predecessor, "
				+ "and uncovers one of King Robert’s bastards. "
				+ "Robert and his guests witness a tournament honoring Ned. "
				+ "Jon takes measures to protect Sam from further abuse at Castle Black; "
				+ "a frustrated Viserys clashes with Daenerys in Vaes Dothrak; Sansa imagines her future as a queen, "
				+ "while Arya envisions a far different future. Catelyn rallies her husband’s allies to make a point, "
				+ "while Tyrion finds himself caught in the wrong place at the wrong time.";
		episodeImageUrl = "cucc";
		episodeImageUuid = "cucc";
		episodeImageTitle = "cucc";
		episodeImageVersion = "cucc";
		
		EpisodeLocalServiceUtil.addEpisode(
				userId, groupId, seasonId,
				episodeTitle, episodeAirDate, 
				episodeNumber, episodeDescription, 
				episodeImageUrl, episodeImageUuid, 
				episodeImageTitle, episodeImageVersion, 
				serviceContext);
		
		/********************************************************************************************************************************/
		/********************************************************************************************************************************/
		
		seasonId = seasons.get(0).getSeasonId();
		episodeTitle = "The Wolf and the Lion";
		cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2011, 5, 16);
		episodeAirDate = cal.getTime();
		episodeNumber = 5;
		episodeDescription = 
				"Incensed over news of Daenerys’ alliance with the Dothrakis, "
				+ "Robert orders a preemptive strike on the Targaryens that drives a wedge in his relationship with Ned. "
				+ "A captive Tyrion helps Catelyn, but receives a cold reception at the Eyrie from her sister, Jon Arryn’s widow Lysa. "
				+ "Sansa is charmed by the dashing Ser Loras Tyrell, a.k.a. the Knight of Flowers. Arya overhears a plot against her father.";
		episodeImageUrl = "cucc";
		episodeImageUuid = "cucc";
		episodeImageTitle = "cucc";
		episodeImageVersion = "cucc";
		
		EpisodeLocalServiceUtil.addEpisode(
				userId, groupId, seasonId,
				episodeTitle, episodeAirDate, 
				episodeNumber, episodeDescription, 
				episodeImageUrl, episodeImageUuid, 
				episodeImageTitle, episodeImageVersion, 
				serviceContext);
		
		/********************************************************************************************************************************/
		/********************************************************************************************************************************/
		
		seasonId = seasons.get(0).getSeasonId();
		episodeTitle = "A Golden Crown";
		cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2011, 5,23);
		episodeAirDate = cal.getTime();
		episodeNumber = 6;
		episodeDescription = 
				"Reinstated as the Hand, "
				+ "Ned sits for the King while Robert is on a hunt. "
				+ "Ned issues a decree that could have long-term consequences throughout the Seven Kingdoms. "
				+ "At the Eyrie, Tyrion confesses to his \"crimes,\" and demands that Lysa give him a trial by combat. "
				+ "Joffrey apologizes to Sansa. Viserys receives his final payment for Daenerys from Drogo.";
		episodeImageUrl = "cucc";
		episodeImageUuid = "cucc";
		episodeImageTitle = "cucc";
		episodeImageVersion = "cucc";
		
		EpisodeLocalServiceUtil.addEpisode(
				userId, groupId, seasonId,
				episodeTitle, episodeAirDate, 
				episodeNumber, episodeDescription, 
				episodeImageUrl, episodeImageUuid, 
				episodeImageTitle, episodeImageVersion, 
				serviceContext);
		
		/********************************************************************************************************************************/
		/********************************************************************************************************************************/
		
		seasonId = seasons.get(0).getSeasonId();
		episodeTitle = "You Win or You Die";
		cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2011, 5, 30);
		episodeAirDate = cal.getTime();
		episodeNumber = 7;
		episodeDescription = 
				"Explaining that the future of the Lannisters is at stake, "
				+ "Tywin presses Jaime to “be the man you were meant to be” as they prepare for battle. "
				+ "Ned confronts Cersei about the secrets that killed Jon Arryn. "
				+ "With the fate of the missing Benjen very much on his mind, Jon takes his Night’s Watch vows, "
				+ "though not with the assignment he coveted. After Ser Jorah saves Daenerys from treachery, "
				+ "an enraged Drogo vows to lead the Dothraki where they’ve never gone before. "
				+ "An injured Robert takes pains to ensure an orderly transition at King’s Landing.";
		episodeImageUrl = "cucc";
		episodeImageUuid = "cucc";
		episodeImageTitle = "cucc";
		episodeImageVersion = "cucc";
		
		EpisodeLocalServiceUtil.addEpisode(
				userId, groupId, seasonId,
				episodeTitle, episodeAirDate, 
				episodeNumber, episodeDescription, 
				episodeImageUrl, episodeImageUuid, 
				episodeImageTitle, episodeImageVersion, 
				serviceContext);
		
		/********************************************************************************************************************************/
		/********************************************************************************************************************************/
		
		seasonId = seasons.get(0).getSeasonId();
		episodeTitle = "The Pointy End";
		cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2011, 6, 6);
		episodeAirDate = cal.getTime();
		episodeNumber = 8;
		episodeDescription = 
				"In the aftermath of Ned's capture, "
				+ "Syrio and Arya face off against Lannister guards, "
				+ "while Cersei manipulates Sansa to her own ends. "
				+ "Robb rallies his father's northern allies against Tywin Lannister and heads south to war. "
				+ "Tyrion forms an uneasy alliance with the hill tribes and reunites with his father. "
				+ "Jon lashes out at Ser Alliser Thorne and battles a mysterious attacker from beyond the Wall. "
				+ "Dany is forced to reconcile her desire to conquer Westeros with Drogo's savagery after the Dothraki raid a peaceful village.";
		episodeImageUrl = "cucc";
		episodeImageUuid = "cucc";
		episodeImageTitle = "cucc";
		episodeImageVersion = "cucc";
		
		EpisodeLocalServiceUtil.addEpisode(
				userId, groupId, seasonId,
				episodeTitle, episodeAirDate, 
				episodeNumber, episodeDescription, 
				episodeImageUrl, episodeImageUuid, 
				episodeImageTitle, episodeImageVersion, 
				serviceContext);
		
		/********************************************************************************************************************************/
		/********************************************************************************************************************************/
		
		seasonId = seasons.get(0).getSeasonId();
		episodeTitle = "Baelor";
		cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2011, 6, 13);
		episodeAirDate = cal.getTime();
		episodeNumber = 9;
		episodeDescription = 
				"With Sansa's life in danger, "
				+ "Ned makes a fateful decision. "
				+ "Catelyn brokers an unsavory deal with the slippery Walder Frey. "
				+ "Tyrion acquires a mistress and is forced by his father to fight on the front lines. "
				+ "Robb wins his first major victory and captures a prized prisoner. "
				+ "Jon is rewarded for his valor and discovers a dark secret about Maester Aemon. "
				+ "As Drogo's wound festers, Dany defies her bloodrider Qotho and puts her trust in the enslaved witch Mirri Maz Duur.";
		episodeImageUrl = "cucc";
		episodeImageUuid = "cucc";
		episodeImageTitle = "cucc";
		episodeImageVersion = "cucc";
		
		EpisodeLocalServiceUtil.addEpisode(
				userId, groupId, seasonId,
				episodeTitle, episodeAirDate, 
				episodeNumber, episodeDescription, 
				episodeImageUrl, episodeImageUuid, 
				episodeImageTitle, episodeImageVersion, 
				serviceContext);
		
		/********************************************************************************************************************************/
		/********************************************************************************************************************************/
		
		seasonId = seasons.get(0).getSeasonId();
		episodeTitle = "Fire and Blood";
		cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2011, 6, 20);
		episodeAirDate = cal.getTime();
		episodeNumber = 10;
		episodeDescription = 
				"As tragic news spreads across the Seven Kingdoms, "
				+ "Bran and Rickon share a prophetic dream, Catelyn interrogates Jamie about her son's fall, "
				+ "and Robb's destiny is forever changed. After a surprising decision by his father, Tyrion heads south. "
				+ "Arya assumes a new identity in an attempt to escape King's Landing, and Sansa is terrorized by Joffrey. At the Wall, "
				+ "Jon is forced to choose between the Night's Watch and the family he left behind. "
				+ "Across the sea, Dany pays a terrible price for her love, but finds new hope.";
		episodeImageUrl = "cucc";
		episodeImageUuid = "cucc";
		episodeImageTitle = "cucc";
		episodeImageVersion = "cucc";
		
		EpisodeLocalServiceUtil.addEpisode(
				userId, groupId, seasonId,
				episodeTitle, episodeAirDate, 
				episodeNumber, episodeDescription, 
				episodeImageUrl, episodeImageUuid, 
				episodeImageTitle, episodeImageVersion, 
				serviceContext);
	}
}
