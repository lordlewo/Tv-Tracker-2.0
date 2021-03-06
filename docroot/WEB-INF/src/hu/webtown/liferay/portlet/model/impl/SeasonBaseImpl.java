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

import com.liferay.portal.kernel.exception.SystemException;

import hu.webtown.liferay.portlet.model.Season;
import hu.webtown.liferay.portlet.service.SeasonLocalServiceUtil;

/**
 * The extended model base implementation for the Season service. Represents a row in the &quot;TvT_Season&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SeasonImpl}.
 * </p>
 *
 * @author czeni
 * @see SeasonImpl
 * @see hu.webtown.liferay.portlet.model.Season
 * @generated
 */
public abstract class SeasonBaseImpl extends SeasonModelImpl implements Season {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a season model instance should use the {@link Season} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SeasonLocalServiceUtil.addSeason(this);
		}
		else {
			SeasonLocalServiceUtil.updateSeason(this);
		}
	}
}