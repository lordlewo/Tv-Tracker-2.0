package hu.webtown.liferay.portlet.tvtracker.tvtadmin.action.test;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.BaseActionCommand;

import hu.webtown.liferay.portlet.model.TvShow;
import hu.webtown.liferay.portlet.service.TvShowLocalServiceUtil;
import hu.webtown.liferay.portlet.tvtracker.util.CustomCalendarUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public class TestAddTvShowActionCommand extends BaseActionCommand {
	
	private static final Log _logger = LogFactoryUtil.getLog(TestAddTvShowActionCommand.class);

	@Override
	protected void doProcessCommand(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws PortalException, SystemException {
		
		ServiceContext serviceContext = ServiceContextFactory.
				getInstance(TvShow.class.getName(), portletRequest);
		
		addGameOfThrones(serviceContext);
		addMrRobot(serviceContext);
		addSherlock(serviceContext);
	}
	
	protected void addGameOfThrones(ServiceContext serviceContext) 
			throws PortalException, SystemException {
		
		long userId = serviceContext.getUserId();
		long groupId = serviceContext.getScopeGroupId();
		Locale locale = serviceContext.getLocale();
		TimeZone timeZone = serviceContext.getTimeZone();
		
		String tvShowTitle = "Game of Thrones";
		Calendar cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2011, 4, 18);
		Date tvShowPremierDate = cal.getTime();
		String tvShowDescription = 
				"Seven noble families fight for control of the mythical land of Westeros. "
				+ "Friction between the houses leads to full-scale war. "
				+ "All while a very ancient evil awakens in the farthest north. "
				+ "Amidst the war, a neglected military order of misfits, the Night's Watch, "
				+ "is all that stands between the realms of men and the icy horrors beyond.";
		String tvShowImageUrl = "cucc";
		
		TvShowLocalServiceUtil.addTvShow(
				userId, groupId, 
				tvShowTitle, tvShowPremierDate, 
				tvShowDescription, 
				tvShowImageUrl, "cucc", "cucc", "cucc", 
				serviceContext);
	}
	
	protected void addMrRobot(ServiceContext serviceContext) 
			throws PortalException, SystemException {
		
		long userId = serviceContext.getUserId();
		long groupId = serviceContext.getScopeGroupId();
		Locale locale = serviceContext.getLocale();
		TimeZone timeZone = serviceContext.getTimeZone();
		
		String tvShowTitle = "Mr Robot";
		Calendar cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2015, 6, 24);
		Date tvShowPremierDate = cal.getTime();
		String tvShowDescription = 
				"The show follows Elliot, who is a cyber-security tech by day and vigilante hacker by night. "
				+ "He has used his hacking skills for justice and to protect those he cares about, "
				+ "but has problems connecting to people in the real world due to social anxiety. "
				+ "He strongly believes that the world is being ruled by the 1% of the 1% and, that using money and debt, "
				+ "they have enslaved mankind and he wishes desperately to change this. "
				+ "He is recruited by the head of a highly secret hacking group to take down the corporation,"
				+ " he is being paid to protect with the hope of erasing 70% of all the debt in the world. "
				+ "He has had delusions in the past and sees a therapist who tries to help him and takes medication for it, "
				+ "but in the end he is unsure what is real and what is not, and so are we as we experience everything from his perspective.";
		String tvShowImageUrl = "cucc";
		
		TvShowLocalServiceUtil.addTvShow(
				userId, groupId, 
				tvShowTitle, tvShowPremierDate, 
				tvShowDescription, 
				tvShowImageUrl, "cucc", "cucc", "cucc", 
				serviceContext);
	}
	
	protected void addSherlock(ServiceContext serviceContext) 
			throws PortalException, SystemException {
		
		long userId = serviceContext.getUserId();
		long groupId = serviceContext.getScopeGroupId();
		Locale locale = serviceContext.getLocale();
		TimeZone timeZone = serviceContext.getTimeZone();
		
		String tvShowTitle = "Sherlock";
		Calendar cal = CustomCalendarUtil.getCalendar(locale, timeZone);
		cal.set(2010, 7, 25);
		Date tvShowPremierDate = cal.getTime();
		String tvShowDescription = 
				"Sherlock is a British television crime drama,"
				+ " that presents a contemporary adaptation of Sir Arthur Conan Doyle's Sherlock Holmes detective stories. "
				+ "Created by Steven Moffat and Mark Gatiss, "
				+ "it stars Benedict Cumberbatch as Sherlock Holmes and Martin Freeman as Doctor John Watson.";
		String tvShowImageUrl = "cucc";
		
		TvShowLocalServiceUtil.addTvShow(
				userId, groupId, 
				tvShowTitle, tvShowPremierDate, 
				tvShowDescription, 
				tvShowImageUrl, "cucc", "cucc", "cucc", 
				serviceContext);
	}
}
