package hu.webtown.liferay.portlet.tvtracker.util;

import com.liferay.portal.kernel.util.OrderByComparator;

import hu.webtown.liferay.portlet.util.comparator.EpisodeAirDateComparator;
import hu.webtown.liferay.portlet.util.comparator.EpisodeTitleComparator;
import hu.webtown.liferay.portlet.util.comparator.TvShowPremierDateComparator;
import hu.webtown.liferay.portlet.util.comparator.TvShowTitleComparator;

public class TvTrackerUtil {

	private TvTrackerUtil() {}
	
	public static OrderByComparator getTvShowOrderByComparator(String orderByCol, String orderByType){
		
		boolean orderByAsc= false;
		
		if(orderByType.equalsIgnoreCase("asc")){
			orderByAsc = true;
		}
		
		OrderByComparator orderByComparator = null;
		
		if(orderByCol.equalsIgnoreCase("tvShowTitle")){
			orderByComparator = new TvShowTitleComparator(orderByAsc);
		} else if (orderByCol.equalsIgnoreCase("tvShowPremierYear")) {
			orderByComparator = new TvShowPremierDateComparator(orderByAsc);
		} else if (orderByCol.equalsIgnoreCase("tvShowPremierDate")) {
			orderByComparator = new TvShowPremierDateComparator(orderByAsc);
		}
		
		return orderByComparator;
	}
	
	public static OrderByComparator getEpisodeOrderByComparator(String orderByCol, String orderByType){
		
		boolean orderByAsc= false;
		
		if(orderByType.equalsIgnoreCase("asc")){
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
		
		if(orderByCol.equalsIgnoreCase("episodeTitle")){
			orderByComparator = new EpisodeTitleComparator(orderByAsc);
		} else if (orderByCol.equalsIgnoreCase("episodeAirDate")) {
			orderByComparator = new EpisodeAirDateComparator(orderByAsc);
		}
		
		return orderByComparator;
	}
}
