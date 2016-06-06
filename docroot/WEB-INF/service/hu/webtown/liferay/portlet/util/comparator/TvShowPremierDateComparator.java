package hu.webtown.liferay.portlet.util.comparator;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import hu.webtown.liferay.portlet.model.TvShow;

import java.util.Date;

public class TvShowPremierDateComparator extends OrderByComparator{	

	private static final long serialVersionUID = 7370941967324630815L;

	public static final String ORDER_BY_ASC = "TvShow.tvShowPremierDate ASC";
	public static final String ORDER_BY_DESC = "TvShow.tvShowPremierDate DESC";
	public static final String[] ORDER_BY_FIELDS = {"tvShowPremierDate"};
	
	private boolean ascending;
	
	public TvShowPremierDateComparator() {
		this(false);
	}

	public TvShowPremierDateComparator(boolean ascending) {
		this.ascending = ascending;
	}
	
	@Override
	public int compare(Object obj1, Object obj2) {
		
		TvShow tvShow1 = (TvShow) obj1;
		TvShow tvShow2 = (TvShow) obj2;
		
		Date tvShowPremierDate1 = tvShow1.getTvShowPremierDate();
		Date tvShowPremierDate2 = tvShow2.getTvShowPremierDate();
		
		int value = DateUtil.compareTo(tvShowPremierDate1, tvShowPremierDate2);
		
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
