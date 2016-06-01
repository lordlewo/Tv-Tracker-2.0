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

package hu.webtown.liferay.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SeasonService}.
 *
 * @author czeni
 * @see SeasonService
 * @generated
 */
public class SeasonServiceWrapper implements SeasonService,
	ServiceWrapper<SeasonService> {
	public SeasonServiceWrapper(SeasonService seasonService) {
		_seasonService = seasonService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _seasonService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_seasonService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _seasonService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public hu.webtown.liferay.portlet.model.Season addSeason(long userId,
		long groupId, long tvShowId, java.lang.String seasonTitle,
		java.util.Date seasonPremierDate, int seasonNumber,
		java.lang.String seasonDescription, java.lang.String seasonImageUrl,
		java.lang.String seasonImageUuid, java.lang.String seasonImageTitle,
		java.lang.String seasonImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seasonService.addSeason(userId, groupId, tvShowId, seasonTitle,
			seasonPremierDate, seasonNumber, seasonDescription, seasonImageUrl,
			seasonImageUuid, seasonImageTitle, seasonImageVersion,
			serviceContext);
	}

	@Override
	public hu.webtown.liferay.portlet.model.Season deleteSeason(long groupId,
		long seasonId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seasonService.deleteSeason(groupId, seasonId, serviceContext);
	}

	@Override
	public hu.webtown.liferay.portlet.model.Season updateSeason(long userId,
		long groupId, long tvShowId, long seasonId,
		java.lang.String seasonTitle, java.util.Date seasonPremierDate,
		int seasonNumber, java.lang.String seasonDescription,
		java.lang.String seasonImageUrl, java.lang.String seasonImageUuid,
		java.lang.String seasonImageTitle, java.lang.String seasonImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seasonService.updateSeason(userId, groupId, tvShowId, seasonId,
			seasonTitle, seasonPremierDate, seasonNumber, seasonDescription,
			seasonImageUrl, seasonImageUuid, seasonImageTitle,
			seasonImageVersion, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SeasonService getWrappedSeasonService() {
		return _seasonService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSeasonService(SeasonService seasonService) {
		_seasonService = seasonService;
	}

	@Override
	public SeasonService getWrappedService() {
		return _seasonService;
	}

	@Override
	public void setWrappedService(SeasonService seasonService) {
		_seasonService = seasonService;
	}

	private SeasonService _seasonService;
}