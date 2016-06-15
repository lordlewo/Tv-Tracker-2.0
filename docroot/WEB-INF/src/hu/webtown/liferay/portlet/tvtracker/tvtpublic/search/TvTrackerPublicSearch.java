package hu.webtown.liferay.portlet.tvtracker.tvtpublic.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import hu.webtown.liferay.portlet.model.TvShow;
import hu.webtown.liferay.portlet.tvtracker.util.CustomPortletKeys;
import hu.webtown.liferay.portlet.tvtracker.util.PortletPropsKeys;
import hu.webtown.liferay.portlet.tvtracker.util.TvTrackerUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

public class TvTrackerPublicSearch extends SearchContainer<TvShow> {
	
	private static final Log _logger = LogFactoryUtil.getLog(TvTrackerPublicSearch.class);
	
	public static final String COVER = "Cover";
	public static final String TITLE = "Title";
	public static final String PREMIER_YEAR = "PremierYear";
	public static final String SEASONS_COUNT = "Seasons";
	
	public static List<String> headerNames = new ArrayList<String>();
    public static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
    public static final String EMPTY_RESULT_MSG = "no-tvshow-were-found";
    public static final int DELTA = 10;
    
	static {
		headerNames.add(TvTrackerPublicSearch.COVER);
		headerNames.add(TvTrackerPublicSearch.TITLE);
		headerNames.add(TvTrackerPublicSearch.PREMIER_YEAR);
		headerNames.add(TvTrackerPublicSearch.SEASONS_COUNT);
		
		orderableHeaders.put(TvTrackerPublicSearch.TITLE, TvTrackerPublicSearch.TITLE);
		orderableHeaders.put(TvTrackerPublicSearch.PREMIER_YEAR, TvTrackerPublicSearch.PREMIER_YEAR);
	}
	
	public TvTrackerPublicSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(
				portletRequest, 
				new TvTrackerPublicDisplayTerms(portletRequest), 
				new TvTrackerPublicSearchTerms(portletRequest), 
				SearchContainer.DEFAULT_CUR_PARAM, 
				//SearchContainer.DEFAULT_DELTA, 
				TvTrackerPublicSearch.DELTA,		
				iteratorURL, 
				headerNames, 
				TvTrackerPublicSearch.EMPTY_RESULT_MSG);
		
		TvTrackerPublicDisplayTerms displayTerms = (TvTrackerPublicDisplayTerms) getDisplayTerms();
		
		setParameter(
				iteratorURL, 
				TvTrackerPublicDisplayTerms.GROUP_ID, 
				String.valueOf(displayTerms.getGroupId()));
		
		setParameter(
				iteratorURL, 
				TvTrackerPublicDisplayTerms.TVSHOW_TITLE, 
				displayTerms.getTvShowTitle());
		
		setParameter(
				iteratorURL, 
				TvTrackerPublicDisplayTerms.TVSHOW_DESCRIPTION, 
				displayTerms.getTvShowDescription());
		
		setParameter(
				iteratorURL, 
				TvTrackerPublicDisplayTerms.END_DATE_YEAR, 
				String.valueOf(displayTerms.getEndDateYear()));
		
		setParameter(
				iteratorURL, 
				TvTrackerPublicDisplayTerms.START_DATE_YEAR, 
				String.valueOf(displayTerms.getEndDateYear()));
		
		try {
			
			PortalPreferences portalPreferences = 
					PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);
			
			String orderByCol = 
					ParamUtil.getString(portletRequest, getOrderByColParam());
            String orderByType = 
            		ParamUtil.getString(portletRequest, getOrderByTypeParam());
			
            if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
            	
            	portalPreferences.setValue(
            			CustomPortletKeys.TVTRACKER_PUBLIC, 
            			PortletPropsKeys.PUBLIC_SEARCH_ORDERBY_COL, 
            			orderByCol);
            	
            	portalPreferences.setValue(
            			CustomPortletKeys.TVTRACKER_PUBLIC, 
            			PortletPropsKeys.PUBLIC_SEARCH_ORDERBY_TYPE, 
            			orderByType);
            	
            } else {
            	
            	orderByCol = portalPreferences.getValue(
            			CustomPortletKeys.TVTRACKER_PUBLIC, 
            			PortletPropsKeys.PUBLIC_SEARCH_ORDERBY_COL, 
            			TvTrackerPublicSearch.TITLE);
            	
            	orderByType = portalPreferences.getValue(
            			CustomPortletKeys.TVTRACKER_PUBLIC, 
            			PortletPropsKeys.PUBLIC_SEARCH_ORDERBY_TYPE, 
            			"asc");
            
            }
            
            OrderByComparator orderByComparator = 
            		TvTrackerUtil.getTvShowOrderByComparator(orderByCol, orderByType);
            
            setOrderableHeaders(orderableHeaders);
            setOrderByCol(orderByCol);
            setOrderByType(orderByType);
            setOrderByComparator(orderByComparator);

		} catch (SystemException e) {
			_logger.equals(e);
		}
	}
	
    private static void setParameter(PortletURL portletURL, String name, String value) {
        if (Validator.isNotNull(value)) {
            portletURL.setParameter(name, value);
        }
    }
}
