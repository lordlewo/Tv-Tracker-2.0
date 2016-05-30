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

package hu.webtown.liferay.portlet.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import hu.webtown.liferay.portlet.model.Episode;
import hu.webtown.liferay.portlet.service.EpisodeLocalServiceUtil;

/**
 * @author czeni
 * @generated
 */
public abstract class EpisodeActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public EpisodeActionableDynamicQuery() throws SystemException {
		setBaseLocalService(EpisodeLocalServiceUtil.getService());
		setClass(Episode.class);

		setClassLoader(hu.webtown.liferay.portlet.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("episodeId");
	}
}