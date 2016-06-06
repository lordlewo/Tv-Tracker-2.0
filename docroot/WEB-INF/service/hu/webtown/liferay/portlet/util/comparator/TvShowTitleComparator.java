package hu.webtown.liferay.portlet.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;

import hu.webtown.liferay.portlet.model.TvShow;

public class TvShowTitleComparator extends OrderByComparator {	
	
	private static final long serialVersionUID = -2118000517250996079L;
	
	public static final String ORDER_BY_ASC = "TvShow.tvShowTitle ASC";
	public static final String ORDER_BY_DESC = "TvShow.tvShowTitle DESC";
	public static final String[] ORDER_BY_FIELDS = {"tvShowTitle"};
	
	private boolean ascending;
	
	public TvShowTitleComparator() {
		this(false);
	}

	public TvShowTitleComparator(boolean ascending) {
		this.ascending = ascending;
	}
	
	@Override
	public int compare(Object obj1, Object obj2) {
		
		TvShow tvShow1 = (TvShow) obj1;
		TvShow tvShow2 = (TvShow) obj2;
		
		String tvShowTitle1 = tvShow1.getTvShowTitle();
		String tvShowTitle2 = tvShow2.getTvShowTitle();
		
		int value = tvShowTitle1.compareToIgnoreCase(tvShowTitle2);
		
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
