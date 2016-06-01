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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for TvShow. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author czeni
 * @see TvShowServiceUtil
 * @see hu.webtown.liferay.portlet.service.base.TvShowServiceBaseImpl
 * @see hu.webtown.liferay.portlet.service.impl.TvShowServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TvShowService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TvShowServiceUtil} to access the tv show remote service. Add custom service methods to {@link hu.webtown.liferay.portlet.service.impl.TvShowServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public hu.webtown.liferay.portlet.model.TvShow addTvShow(long userId,
		long groupId, java.lang.String tvShowTitle,
		java.util.Date tvShowPremierDate, java.lang.String tvShowDescription,
		java.lang.String tvShowImageUrl, java.lang.String tvShowImageUuid,
		java.lang.String tvShowImageTitle, java.lang.String tvShowImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public hu.webtown.liferay.portlet.model.TvShow deleteTvShow(long groupId,
		long tvShowId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public hu.webtown.liferay.portlet.model.TvShow updateTvShow(long userId,
		long groupId, long tvShowId, java.lang.String tvShowTitle,
		java.util.Date tvShowPremierDate, java.lang.String tvShowDescription,
		java.lang.String tvShowImageUrl, java.lang.String tvShowImageUuid,
		java.lang.String tvShowImageTitle, java.lang.String tvShowImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}