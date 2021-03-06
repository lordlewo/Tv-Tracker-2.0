/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package hu.webtown.liferay.portlet.model.impl;

/**
 * The extended model implementation for the TvShow service. Represents a row in the &quot;TvT_TvShow&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.webtown.liferay.portlet.model.TvShow} interface.
 * </p>
 *
 * @author czeni
 */
public class TvShowImpl extends TvShowBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a tv show model instance should use the {@link hu.webtown.liferay.portlet.model.TvShow} interface instead.
	 */
	
	private int tvShowPremierYear;
	
	private int tvShowSeasonCount;
	
	public TvShowImpl() {
	}

	public int getTvShowPremierYear() {
		return tvShowPremierYear;
	}

	public void setTvShowPremierYear(int tvShowPremierYear) {
		this.tvShowPremierYear = tvShowPremierYear;
	}

	public int getTvShowSeasonCount() {
		return tvShowSeasonCount;
	}

	public void setTvShowSeasonCount(int tvShowSeasonCount) {
		this.tvShowSeasonCount = tvShowSeasonCount;
	}
	
	
}