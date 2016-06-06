package hu.webtown.liferay.portlet.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;

import hu.webtown.liferay.portlet.model.Episode;

public class EpisodeTitleComparator extends OrderByComparator {

	private static final long serialVersionUID = 4901154922921322007L;

	public static final String ORDER_BY_ASC = "Episode.episodeTitle ASC";	
	public static final String ORDER_BY_DESC = "Episode.episodeTitle DESC";
	public static final String[] ORDER_BY_FIELDS = {"episodeTitle"};
	
	private boolean ascending;

	public EpisodeTitleComparator() {
		this(false);
	}
	
	public EpisodeTitleComparator(boolean ascending) {
		this.ascending = ascending;
	}
	
	@Override
	public int compare(Object obj1, Object obj2) {
		
		Episode episode1 = (Episode) obj1;
		Episode episode2 = (Episode) obj2;
		
		String episodeTitle1 = episode1.getEpisodeTitle();
		String episodeTitle2 = episode2.getEpisodeTitle();
		
		int value = episodeTitle1.compareToIgnoreCase(episodeTitle2);
		
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
