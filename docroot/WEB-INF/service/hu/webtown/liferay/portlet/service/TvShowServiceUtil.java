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
 * Provides the remote service utility for TvShow. This utility wraps
 * {@link hu.webtown.liferay.portlet.service.impl.TvShowServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author czeni
 * @see TvShowService
 * @see hu.webtown.liferay.portlet.service.base.TvShowServiceBaseImpl
 * @see hu.webtown.liferay.portlet.service.impl.TvShowServiceImpl
 * @generated
 */
public class TvShowServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.webtown.liferay.portlet.service.impl.TvShowServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static hu.webtown.liferay.portlet.model.TvShow addTvShow(
		long userId, long groupId, java.lang.String tvShowTitle,
		java.util.Date tvShowPremierDate, java.lang.String tvShowDescription,
		java.lang.String tvShowImageUrl, java.lang.String tvShowImageUuid,
		java.lang.String tvShowImageTitle, java.lang.String tvShowImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTvShow(userId, groupId, tvShowTitle, tvShowPremierDate,
			tvShowDescription, tvShowImageUrl, tvShowImageUuid,
			tvShowImageTitle, tvShowImageVersion, serviceContext);
	}

	public static hu.webtown.liferay.portlet.model.TvShow deleteTvShow(
		long groupId, long tvShowId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTvShow(groupId, tvShowId, serviceContext);
	}

	public static hu.webtown.liferay.portlet.model.TvShow updateTvShow(
		long userId, long groupId, long tvShowId, java.lang.String tvShowTitle,
		java.util.Date tvShowPremierDate, java.lang.String tvShowDescription,
		java.lang.String tvShowImageUrl, java.lang.String tvShowImageUuid,
		java.lang.String tvShowImageTitle, java.lang.String tvShowImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateTvShow(userId, groupId, tvShowId, tvShowTitle,
			tvShowPremierDate, tvShowDescription, tvShowImageUrl,
			tvShowImageUuid, tvShowImageTitle, tvShowImageVersion,
			serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static TvShowService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TvShowService.class.getName());

			if (invokableService instanceof TvShowService) {
				_service = (TvShowService)invokableService;
			}
			else {
				_service = new TvShowServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(TvShowServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TvShowService service) {
	}

	private static TvShowService _service;
}