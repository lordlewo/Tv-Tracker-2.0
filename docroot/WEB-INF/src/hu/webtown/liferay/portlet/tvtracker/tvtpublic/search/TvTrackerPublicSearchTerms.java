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
		
		Integer dateRangeType = DAOParamUtil.getInteger(portletRequest, TvTrackerPublicDisplayTerms.DATE_RANGE_TYPE);
		Integer endDateYear = DAOParamUtil.getInteger(portletRequest, TvTrackerPublicDisplayTerms.END_DATE_YEAR);
		Integer startDateYear = DAOParamUtil.getInteger(portletRequest, TvTrackerPublicDisplayTerms.START_DATE_YEAR);
		
		setTvShowTitle(tvShowTitle);
		setTvShowDescription(tvShowDescription);
		
		setDateRangeType(dateRangeType);
		setEndDateYear(endDateYear);
		setStartDateYear(startDateYear);
	}
}
