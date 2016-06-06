package hu.webtown.liferay.portlet.tvtracker.tvtadmin.action;

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

public class AddTvShowActionCommand extends BaseActionCommand{

	private static final Log _logger = LogFactoryUtil.getLog(AddTvShowActionCommand.class);

	@Override
	protected void doProcessCommand(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws PortalException, SystemException {
		
		ServiceContext serviceContext = ServiceContextFactory.
				getInstance(TvShow.class.getName(), portletRequest);
		
		long userId = serviceContext.getUserId();
		long groupid = serviceContext.getScopeGroupId();
		
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
				userId, groupid, 
				tvShowTitle, tvShowPremierDate, 
				tvShowDescription, 
				tvShowImageUrl, "cucc", "cucc", "cucc", 
				serviceContext);
	}
}
