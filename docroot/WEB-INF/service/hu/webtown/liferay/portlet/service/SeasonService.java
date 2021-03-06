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
 * Provides the remote service interface for Season. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author czeni
 * @see SeasonServiceUtil
 * @see hu.webtown.liferay.portlet.service.base.SeasonServiceBaseImpl
 * @see hu.webtown.liferay.portlet.service.impl.SeasonServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SeasonService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SeasonServiceUtil} to access the season remote service. Add custom service methods to {@link hu.webtown.liferay.portlet.service.impl.SeasonServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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

	public hu.webtown.liferay.portlet.model.Season addSeason(long userId,
		long groupId, long tvShowId, java.lang.String seasonTitle,
		java.util.Date seasonPremierDate, int seasonNumber,
		java.lang.String seasonDescription, java.lang.String seasonImageUrl,
		java.lang.String seasonImageUuid, java.lang.String seasonImageTitle,
		java.lang.String seasonImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public hu.webtown.liferay.portlet.model.Season deleteSeason(long groupId,
		long seasonId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public hu.webtown.liferay.portlet.model.Season updateSeason(long userId,
		long groupId, long tvShowId, long seasonId,
		java.lang.String seasonTitle, java.util.Date seasonPremierDate,
		int seasonNumber, java.lang.String seasonDescription,
		java.lang.String seasonImageUrl, java.lang.String seasonImageUuid,
		java.lang.String seasonImageTitle, java.lang.String seasonImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}