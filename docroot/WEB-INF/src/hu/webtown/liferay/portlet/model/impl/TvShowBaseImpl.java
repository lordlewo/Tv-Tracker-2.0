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

import hu.webtown.liferay.portlet.model.TvShow;
import hu.webtown.liferay.portlet.service.TvShowLocalServiceUtil;

/**
 * The extended model base implementation for the TvShow service. Represents a row in the &quot;TvT_TvShow&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TvShowImpl}.
 * </p>
 *
 * @author czeni
 * @see TvShowImpl
 * @see hu.webtown.liferay.portlet.model.TvShow
 * @generated
 */
public abstract class TvShowBaseImpl extends TvShowModelImpl implements TvShow {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tv show model instance should use the {@link TvShow} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TvShowLocalServiceUtil.addTvShow(this);
		}
		else {
			TvShowLocalServiceUtil.updateTvShow(this);
		}
	}
}