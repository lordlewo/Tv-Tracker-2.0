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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Episode. This utility wraps
 * {@link hu.webtown.liferay.portlet.service.impl.EpisodeServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author czeni
 * @see EpisodeService
 * @see hu.webtown.liferay.portlet.service.base.EpisodeServiceBaseImpl
 * @see hu.webtown.liferay.portlet.service.impl.EpisodeServiceImpl
 * @generated
 */
public class EpisodeServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.webtown.liferay.portlet.service.impl.EpisodeServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static hu.webtown.liferay.portlet.model.Episode addEpisode(
		long userId, long groupId, long seasonId,
		java.lang.String episodeTitle, java.util.Date episodeAirDate,
		int episodeNumber, java.lang.String episodeDescription,
		java.lang.String episodeImageUrl, java.lang.String episodeImageUuid,
		java.lang.String episodeImageTitle,
		java.lang.String episodeImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEpisode(userId, groupId, seasonId, episodeTitle,
			episodeAirDate, episodeNumber, episodeDescription, episodeImageUrl,
			episodeImageUuid, episodeImageTitle, episodeImageVersion,
			serviceContext);
	}

	public static hu.webtown.liferay.portlet.model.Episode deleteEpisode(
		long groupId, long episodeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEpisode(groupId, episodeId, serviceContext);
	}

	public static hu.webtown.liferay.portlet.model.Episode updateEpisode(
		long userId, long groupId, long seasonId, long episodeId,
		java.lang.String episodeTitle, java.util.Date episodeAirDate,
		int episodeNumber, java.lang.String episodeDescription,
		java.lang.String episodeImageUrl, java.lang.String episodeImageUuid,
		java.lang.String episodeImageTitle,
		java.lang.String episodeImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateEpisode(userId, groupId, seasonId, episodeId,
			episodeTitle, episodeAirDate, episodeNumber, episodeDescription,
			episodeImageUrl, episodeImageUuid, episodeImageTitle,
			episodeImageVersion, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static EpisodeService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EpisodeService.class.getName());

			if (invokableService instanceof EpisodeService) {
				_service = (EpisodeService)invokableService;
			}
			else {
				_service = new EpisodeServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(EpisodeServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EpisodeService service) {
	}

	private static EpisodeService _service;
}