package hu.webtown.liferay.portlet.tvtracker.tvtpublic.search;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.util.PortalUtil;

import hu.webtown.liferay.portlet.TvShowPremierDateException;
import hu.webtown.liferay.portlet.model.constant.DateRangeType;

import java.util.Date;
import java.util.TimeZone;

import javax.portlet.PortletRequest;

public class TvTrackerPublicSearchTerms extends TvTrackerPublicDisplayTerms {
	
	public TvTrackerPublicSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);

		String tvShowTitle = DAOParamUtil.getString(portletRequest, TvTrackerPublicDisplayTerms.TVSHOW_TITLE);
		String tvShowDescription = DAOParamUtil.getString(portletRequest, TvTrackerPublicDisplayTerms.TVSHOW_DESCRIPTION);
		int tvShowPremierDay = DAOParamUtil.getInteger(portletRequest, TvTrackerPublicDisplayTerms.TVSHOW_PREMIER_DAY);
		int tvShowPremierMonth = DAOParamUtil.getInteger(portletRequest, TvTrackerPublicDisplayTerms.TVSHOW_PREMIER_MONTH);
		int tvShowPremierYear = DAOParamUtil.getInteger(portletRequest, TvTrackerPublicDisplayTerms.TVSHOW_PREMIER_MONTH);
		
		setTvShowTitle(tvShowTitle);
		setTvShowDescription(tvShowDescription);
		setTvShowPremierDay(tvShowPremierDay);
		setTvShowPremierMonth(tvShowPremierMonth);
		setTvShowPremierYear(tvShowPremierYear);
	}
	
	public Date getEndDate(TimeZone timeZone) throws PortalException {
		
		int dateRangeType = getDateRangeType();
		
		if (dateRangeType == DateRangeType.ANYTIME.getKey() || dateRangeType == DateRangeType.DATE_FROM.getKey()){
			return null;
		}
		
		int endDateMonth = getEndDateMonth();
		int endDateDay = getEndDateDay() + 1;
		int endDateYear = getEndDateYear();
		
		return PortalUtil.getDate(endDateMonth, endDateDay, endDateYear, timeZone, TvShowPremierDateException.class);
	}
	
	public Date getStartDate(TimeZone timeZone) throws PortalException {
		
		int dateRangeType = getDateRangeType();
		
		if (dateRangeType == DateRangeType.ANYTIME.getKey() || dateRangeType == DateRangeType.DATE_TO.getKey()){
			return null;
		}
		
		int startDateMonth = getStartDateMonth();
		int startDateDay = getStartDateDay();
		int startDateYear = getStartDateYear();
		
		return PortalUtil.getDate(startDateMonth, startDateDay, startDateYear, timeZone, TvShowPremierDateException.class);
	}
}
