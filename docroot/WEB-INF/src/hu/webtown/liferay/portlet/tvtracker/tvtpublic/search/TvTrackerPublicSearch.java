package hu.webtown.liferay.portlet.tvtracker.tvtpublic.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import hu.webtown.liferay.portlet.model.TvShow;

public class TvTrackerPublicSearch extends SearchContainer<TvShow> {
	
	private static final Log _logger = LogFactoryUtil.getLog(TvTrackerPublicSearch.class);
	
	public static final String COVER = "Cover";
	public static final String TITLE = "Title";
	public static final String PREMIER_YEAR = "PremierYear";
	public static final String SEASONS_COUNT = "Seasons";
	public static final String DETAILS = "Details";
	
	public static List<String> headerNames = new ArrayList<String>();
    public static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
    public static final String EMPTY_RESULT_MSG = "no-tvshow-were-found";
    
	static {
		headerNames.add(TvTrackerPublicSearch.COVER);
		headerNames.add(TvTrackerPublicSearch.TITLE);
		headerNames.add(TvTrackerPublicSearch.PREMIER_YEAR);
		headerNames.add(TvTrackerPublicSearch.SEASONS_COUNT);
		headerNames.add(TvTrackerPublicSearch.DETAILS);
		
		orderableHeaders.put(TvTrackerPublicSearch.TITLE, TvTrackerPublicSearch.TITLE);
		orderableHeaders.put(TvTrackerPublicSearch.PREMIER_YEAR, TvTrackerPublicSearch.PREMIER_YEAR);
	}
	
	{
		
	}
	
	public TvTrackerPublicSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(
				portletRequest, 
				new TvTrackerPublicDisplayTerms(portletRequest), 
				new TvTrackerPublicSearchTerms(portletRequest), 
				SearchContainer.DEFAULT_CUR_PARAM, 
				SearchContainer.DEFAULT_DELTA, 
				iteratorURL, 
				headerNames, 
				TvTrackerPublicSearch.EMPTY_RESULT_MSG);
	}
	
}
