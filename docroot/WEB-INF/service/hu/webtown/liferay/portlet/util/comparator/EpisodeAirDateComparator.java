package hu.webtown.liferay.portlet.util.comparator;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import hu.webtown.liferay.portlet.model.Episode;

import java.util.Date;

public class EpisodeAirDateComparator extends OrderByComparator {

	private static final long serialVersionUID = 1017167540838368520L;
	
	public static final String ORDER_BY_ASC = "Episode.episodeAirDate ASC";	
	public static final String ORDER_BY_DESC = "Episode.episodeAirDate DESC";
	public static final String[] ORDER_BY_FIELDS = {"episodeAirDate"};

	private boolean ascending;
	
	public EpisodeAirDateComparator() {
		this(false);
	}

	public EpisodeAirDateComparator(boolean ascending) {
		this.ascending = ascending;
	}
	
	@Override
	public int compare(Object obj1, Object obj2) {
		
		Episode episode1 = (Episode) obj1;
		Episode episode2 = (Episode) obj2;
		
		Date episodeAirDate1 = episode1.getEpisodeAirDate();
		Date episodeAirDate2 = episode2.getEpisodeAirDate();
		
		int value = DateUtil.compareTo(episodeAirDate1, episodeAirDate2);
		
		return ascending ? value : -value;
	}
	
	@Override
	public String getOrderBy() {
		if (ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}
	
	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return ascending;
	}
}
