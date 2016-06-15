package hu.webtown.liferay.portlet.tvtracker.tvtpublic.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.theme.ThemeDisplay;

import hu.webtown.liferay.portlet.model.constant.DateRangeType;
import hu.webtown.liferay.portlet.tvtracker.util.CustomWebKeys;

import java.util.Calendar;

import javax.portlet.PortletRequest;

public class TvTrackerPublicDisplayTerms extends DisplayTerms {
	
	public static final String GROUP_ID = "groupId";
	public static final String TVSHOW_TITLE = "tvShowTitle";
	public static final String TVSHOW_DESCRIPTION = "tvShowDescription";
	
	public static final String DATE_RANGE_TYPE = "dateRangeType";
    public static final String END_DATE_YEAR = "endDateYear";
    public static final String START_DATE_YEAR = "startDateYear";

	private long groupId;
	private String tvShowTitle;
	private String tvShowDescription;
	
	private int dateRangeType;
    private int endDateYear;
    private int startDateYear;
    private int yearRangeEnd;
    private int yearRangeStart;
	
	public TvTrackerPublicDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(CustomWebKeys.THEME_DISPLAY);
		
		tvShowTitle = ParamUtil.getString(portletRequest, TvTrackerPublicDisplayTerms.TVSHOW_TITLE);
		tvShowDescription = ParamUtil.getString(portletRequest, TvTrackerPublicDisplayTerms.TVSHOW_DESCRIPTION);
		groupId = setGroupId(portletRequest);
		
		Calendar today = CalendarFactoryUtil
				.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());

		dateRangeType = ParamUtil.getInteger(
				portletRequest, TvTrackerPublicDisplayTerms.DATE_RANGE_TYPE, DateRangeType.ANYTIME.getKey());
		endDateYear = ParamUtil.getInteger(
				portletRequest, TvTrackerPublicDisplayTerms.END_DATE_YEAR, today.get(Calendar.YEAR));
		startDateYear = ParamUtil.getInteger(
				portletRequest, TvTrackerPublicDisplayTerms.START_DATE_YEAR, today.get(Calendar.YEAR));

		yearRangeEnd = today.get(Calendar.YEAR) + 5;
		yearRangeStart = today.get(Calendar.YEAR) - 50;
	}

    public long setGroupId(PortletRequest portletRequest) {

        groupId = ParamUtil.getLong(portletRequest, GROUP_ID);

        if (groupId == 0) {

            ThemeDisplay themeDisplay =
                (ThemeDisplay) portletRequest.getAttribute(CustomWebKeys.THEME_DISPLAY);

            groupId = themeDisplay.getScopeGroupId();
        }

        return groupId;
    }

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getTvShowTitle() {
		return tvShowTitle;
	}

	public void setTvShowTitle(String tvShowTitle) {
		this.tvShowTitle = tvShowTitle;
	}

	public String getTvShowDescription() {
		return tvShowDescription;
	}

	public void setTvShowDescription(String tvShowDescription) {
		this.tvShowDescription = tvShowDescription;
	}

	public int getDateRangeType() {
		return dateRangeType;
	}

	public void setDateRangeType(int dateRangeType) {
		this.dateRangeType = dateRangeType;
	}

	public int getEndDateYear() {
		return endDateYear;
	}

	public void setEndDateYear(int endDateYear) {
		this.endDateYear = endDateYear;
	}

	public int getStartDateYear() {
		return startDateYear;
	}

	public void setStartDateYear(int startDateYear) {
		this.startDateYear = startDateYear;
	}

	public int getYearRangeEnd() {
		return yearRangeEnd;
	}

	public void setYearRangeEnd(int yearRangeEnd) {
		this.yearRangeEnd = yearRangeEnd;
	}

	public int getYearRangeStart() {
		return yearRangeStart;
	}

	public void setYearRangeStart(int yearRangeStart) {
		this.yearRangeStart = yearRangeStart;
	}
}
