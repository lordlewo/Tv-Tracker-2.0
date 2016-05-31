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
 * Provides a wrapper for {@link EpisodeService}.
 *
 * @author czeni
 * @see EpisodeService
 * @generated
 */
public class EpisodeServiceWrapper implements EpisodeService,
	ServiceWrapper<EpisodeService> {
	public EpisodeServiceWrapper(EpisodeService episodeService) {
		_episodeService = episodeService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _episodeService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_episodeService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _episodeService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public hu.webtown.liferay.portlet.model.Episode addEpisode(long userId,
		long groupId, long seasonId, java.lang.String episodeTitle,
		java.util.Date episodeAirDate, int episodeNumber,
		java.lang.String episodeDescription, java.lang.String episodeImageUrl,
		java.lang.String episodeImageUuid, java.lang.String episodeImageTitle,
		java.lang.String episodeImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _episodeService.addEpisode(userId, groupId, seasonId,
			episodeTitle, episodeAirDate, episodeNumber, episodeDescription,
			episodeImageUrl, episodeImageUuid, episodeImageTitle,
			episodeImageVersion, serviceContext);
	}

	@Override
	public hu.webtown.liferay.portlet.model.Episode updateEpisode(long userId,
		long groupId, long seasonId, long episodeId,
		java.lang.String episodeTitle, java.util.Date episodeAirDate,
		int episodeNumber, java.lang.String episodeDescription,
		java.lang.String episodeImageUrl, java.lang.String episodeImageUuid,
		java.lang.String episodeImageTitle,
		java.lang.String episodeImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _episodeService.updateEpisode(userId, groupId, seasonId,
			episodeId, episodeTitle, episodeAirDate, episodeNumber,
			episodeDescription, episodeImageUrl, episodeImageUuid,
			episodeImageTitle, episodeImageVersion, serviceContext);
	}

	@Override
	public hu.webtown.liferay.portlet.model.Episode deleteEpisode(
		long groupId, long episodeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _episodeService.deleteEpisode(groupId, episodeId, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EpisodeService getWrappedEpisodeService() {
		return _episodeService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEpisodeService(EpisodeService episodeService) {
		_episodeService = episodeService;
	}

	@Override
	public EpisodeService getWrappedService() {
		return _episodeService;
	}

	@Override
	public void setWrappedService(EpisodeService episodeService) {
		_episodeService = episodeService;
	}

	private EpisodeService _episodeService;
}