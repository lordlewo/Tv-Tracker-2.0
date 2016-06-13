package hu.webtown.liferay.portlet.tvtracker.tvtpublic.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.theme.ThemeDisplay;

import java.util.Calendar;

import hu.webtown.liferay.portlet.model.constant.DateRangeType;
import hu.webtown.liferay.portlet.tvtracker.util.CustomWebKeys;

import javax.portlet.PortletRequest;

public class TvTrackerPublicDisplayTerms extends DisplayTerms {
	
	public static final String GROUP_ID = "groupId";
	public static final String TVSHOW_ID = "tvShowId";
	public static final String TVSHOW_TITLE = "tvShowTitle";
	public static final String TVSHOW_PREMIER_YEAR = "tvShowPremierYear";
	public static final String TVSHOW_PREMIER_MONTH = "tvShowPremierMonth";
	public static final String TVSHOW_PREMIER_DAY = "tvShowPremierDay";
	public static final String TVSHOW_DESCRIPTION = "tvShowDescription";
	public static final String TVSHOW_SEASON_COUNT = "tvShowSeasonCount";
	
	public static final String DATE_RANGE_TYPE = "dateRangeType";
    public static final String END_DATE_DAY = "endDateDay";
    public static final String END_DATE_MONTH = "endDateMonth";
    public static final String END_DATE_YEAR = "endDateYear";
    public static final String START_DATE_DAY = "startDateDay";
    public static final String START_DATE_MONTH = "startDateMonth";
    public static final String START_DATE_YEAR = "startDateYear";

	private long groupId;
	private long tvShowId;
	private String tvShowTitle;
	private int tvShowPremierYear;
	private int tvShowPremierMonth;
	private int tvShowPremierDay;
	private String tvShowDescription;
	private int tvShowSeasonCount;
	
	private int dateRangeType;
    private int endDateDay;
    private int endDateMonth;
    private int endDateYear;
    private int startDateDay;
    private int startDateMonth;
    private int startDateYear;
    private int firstDayOfWeek;
    private int yearRangeEnd;
    private int yearRangeStart;
	
	public TvTrackerPublicDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(CustomWebKeys.THEME_DISPLAY);
		
		tvShowId = ParamUtil.getLong(portletRequest, TvTrackerPublicDisplayTerms.TVSHOW_ID);
		tvShowTitle = ParamUtil.getString(portletRequest, TvTrackerPublicDisplayTerms.TVSHOW_TITLE);
		tvShowPremierYear = ParamUtil.getInteger(portletRequest, TvTrackerPublicDisplayTerms.TVSHOW_PREMIER_YEAR);
		tvShowPremierMonth = ParamUtil.getInteger(portletRequest, TvTrackerPublicDisplayTerms.TVSHOW_PREMIER_MONTH);
		tvShowPremierDay = ParamUtil.getInteger(portletRequest, TvTrackerPublicDisplayTerms.TVSHOW_PREMIER_DAY);
		tvShowDescription = ParamUtil.getString(portletRequest, TvTrackerPublicDisplayTerms.TVSHOW_DESCRIPTION);
		tvShowSeasonCount = ParamUtil.getInteger(portletRequest, TvTrackerPublicDisplayTerms.TVSHOW_SEASON_COUNT);
		groupId = setGroupId(portletRequest);
		
		Calendar today = CalendarFactoryUtil
				.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());

		Calendar calendar = CalendarFactoryUtil
				.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
		calendar.add(Calendar.MONTH, -1);

		dateRangeType = ParamUtil
				.getInteger(portletRequest, TvTrackerPublicDisplayTerms.DATE_RANGE_TYPE, DateRangeType.ANYTIME.getKey());
		
		endDateDay = ParamUtil
				.getInteger(portletRequest, TvTrackerPublicDisplayTerms.END_DATE_DAY, today.get(Calendar.DATE));    
		endDateMonth =ParamUtil
				.getInteger(portletRequest, TvTrackerPublicDisplayTerms.END_DATE_MONTH, today.get(Calendar.MONTH));
		endDateYear = ParamUtil
				.getInteger(portletRequest, TvTrackerPublicDisplayTerms.END_DATE_YEAR, today.get(Calendar.YEAR));
		startDateDay = ParamUtil
				.getInteger(portletRequest, TvTrackerPublicDisplayTerms.START_DATE_DAY, calendar.get(Calendar.DATE));
		startDateMonth = ParamUtil
				.getInteger(portletRequest, TvTrackerPublicDisplayTerms.START_DATE_MONTH, calendar.get(Calendar.MONTH));
		startDateYear = ParamUtil
				.getInteger(portletRequest, TvTrackerPublicDisplayTerms.START_DATE_YEAR, calendar.get(Calendar.YEAR));
		
		firstDayOfWeek = today.getFirstDayOfWeek() - 1;
		yearRangeEnd = today.get(Calendar.YEAR);
		yearRangeStart = today.get(Calendar.YEAR) - 100;
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

	public long getTvShowId() {
		return tvShowId;
	}

	public void setTvShowId(long tvShowId) {
		this.tvShowId = tvShowId;
	}

	public String getTvShowTitle() {
		return tvShowTitle;
	}

	public void setTvShowTitle(String tvShowTitle) {
		this.tvShowTitle = tvShowTitle;
	}

	public int getTvShowPremierYear() {
		return tvShowPremierYear;
	}

	public void setTvShowPremierYear(int tvShowPremierYear) {
		this.tvShowPremierYear = tvShowPremierYear;
	}

	public int getTvShowPremierMonth() {
		return tvShowPremierMonth;
	}

	public void setTvShowPremierMonth(int tvShowPremierMonth) {
		this.tvShowPremierMonth = tvShowPremierMonth;
	}

	public int getTvShowPremierDay() {
		return tvShowPremierDay;
	}

	public void setTvShowPremierDay(int tvShowPremierDay) {
		this.tvShowPremierDay = tvShowPremierDay;
	}

	public String getTvShowDescription() {
		return tvShowDescription;
	}

	public void setTvShowDescription(String tvShowDescription) {
		this.tvShowDescription = tvShowDescription;
	}

	public int getTvShowSeasonCount() {
		return tvShowSeasonCount;
	}

	public void setTvShowSeasonCount(int tvShowSeasonCount) {
		this.tvShowSeasonCount = tvShowSeasonCount;
	}

	public int getDateRangeType() {
		return dateRangeType;
	}

	public void setDateRangeType(int dateRangeType) {
		this.dateRangeType = dateRangeType;
	}

	public int getEndDateDay() {
		return endDateDay;
	}

	public void setEndDateDay(int endDateDay) {
		this.endDateDay = endDateDay;
	}

	public int getEndDateMonth() {
		return endDateMonth;
	}

	public void setEndDateMonth(int endDateMonth) {
		this.endDateMonth = endDateMonth;
	}

	public int getEndDateYear() {
		return endDateYear;
	}

	public void setEndDateYear(int endDateYear) {
		this.endDateYear = endDateYear;
	}

	public int getStartDateDay() {
		return startDateDay;
	}

	public void setStartDateDay(int startDateDay) {
		this.startDateDay = startDateDay;
	}

	public int getStartDateMonth() {
		return startDateMonth;
	}

	public void setStartDateMonth(int startDateMonth) {
		this.startDateMonth = startDateMonth;
	}

	public int getStartDateYear() {
		return startDateYear;
	}

	public void setStartDateYear(int startDateYear) {
		this.startDateYear = startDateYear;
	}

	public int getFirstDayOfWeek() {
		return firstDayOfWeek;
	}

	public void setFirstDayOfWeek(int firstDayOfWeek) {
		this.firstDayOfWeek = firstDayOfWeek;
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
