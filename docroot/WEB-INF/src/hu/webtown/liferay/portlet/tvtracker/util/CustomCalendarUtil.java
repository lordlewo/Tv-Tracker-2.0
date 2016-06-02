package hu.webtown.liferay.portlet.tvtracker.util;

import com.liferay.portal.kernel.util.CalendarUtil;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class CustomCalendarUtil extends CalendarUtil{
	
	/**
	 * get an appropriate localizedand timezoned Calendar instance
	 * 
	 * @param locale
	 * @param timeZone
	 * @return Calendar
	 */
	public static final Calendar getCalendar(Locale locale, TimeZone timeZone){
		
		Calendar calendar = null;
		
		if (locale != null && timeZone != null){
		
			calendar = new GregorianCalendar(timeZone, locale);
		
		} else if (locale != null){
			
			calendar = new GregorianCalendar(locale);
		
		} else if (timeZone != null){
			
			calendar = new GregorianCalendar(timeZone);
			
		} else {
			
			calendar = new GregorianCalendar();
			
		}
	
		return calendar;
	}
}
