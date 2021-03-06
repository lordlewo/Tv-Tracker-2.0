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
 * Provides the remote service utility for Season. This utility wraps
 * {@link hu.webtown.liferay.portlet.service.impl.SeasonServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author czeni
 * @see SeasonService
 * @see hu.webtown.liferay.portlet.service.base.SeasonServiceBaseImpl
 * @see hu.webtown.liferay.portlet.service.impl.SeasonServiceImpl
 * @generated
 */
public class SeasonServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.webtown.liferay.portlet.service.impl.SeasonServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static hu.webtown.liferay.portlet.model.Season addSeason(
		long userId, long groupId, long tvShowId, java.lang.String seasonTitle,
		java.util.Date seasonPremierDate, int seasonNumber,
		java.lang.String seasonDescription, java.lang.String seasonImageUrl,
		java.lang.String seasonImageUuid, java.lang.String seasonImageTitle,
		java.lang.String seasonImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSeason(userId, groupId, tvShowId, seasonTitle,
			seasonPremierDate, seasonNumber, seasonDescription, seasonImageUrl,
			seasonImageUuid, seasonImageTitle, seasonImageVersion,
			serviceContext);
	}

	public static hu.webtown.liferay.portlet.model.Season deleteSeason(
		long groupId, long seasonId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSeason(groupId, seasonId, serviceContext);
	}

	public static hu.webtown.liferay.portlet.model.Season updateSeason(
		long userId, long groupId, long tvShowId, long seasonId,
		java.lang.String seasonTitle, java.util.Date seasonPremierDate,
		int seasonNumber, java.lang.String seasonDescription,
		java.lang.String seasonImageUrl, java.lang.String seasonImageUuid,
		java.lang.String seasonImageTitle, java.lang.String seasonImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSeason(userId, groupId, tvShowId, seasonId,
			seasonTitle, seasonPremierDate, seasonNumber, seasonDescription,
			seasonImageUrl, seasonImageUuid, seasonImageTitle,
			seasonImageVersion, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static SeasonService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SeasonService.class.getName());

			if (invokableService instanceof SeasonService) {
				_service = (SeasonService)invokableService;
			}
			else {
				_service = new SeasonServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SeasonServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SeasonService service) {
	}

	private static SeasonService _service;
}