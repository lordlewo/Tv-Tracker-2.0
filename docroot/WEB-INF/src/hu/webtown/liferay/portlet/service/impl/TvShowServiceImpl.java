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

package hu.webtown.liferay.portlet.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import hu.webtown.liferay.portlet.model.Episode;
import hu.webtown.liferay.portlet.model.TvShow;
import hu.webtown.liferay.portlet.service.base.TvShowServiceBaseImpl;
import hu.webtown.liferay.portlet.service.permission.CustomActionKeys;
import hu.webtown.liferay.portlet.service.permission.TvShowPermission;
import hu.webtown.liferay.portlet.service.permission.TvTrackerModelPermission;

import java.util.Date;

/**
 * The implementation of the tv show remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.webtown.liferay.portlet.service.TvShowService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author czeni
 * @see hu.webtown.liferay.portlet.service.base.TvShowServiceBaseImpl
 * @see hu.webtown.liferay.portlet.service.TvShowServiceUtil
 */
public class TvShowServiceImpl extends TvShowServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link hu.webtown.liferay.portlet.service.TvShowServiceUtil} to access the tv show remote service.
	 */
	
	/***************************************************************************/
	/********** BLL - CREATE Entity ********************************************/
	/***************************************************************************/
	
	public TvShow addTvShow(
			long userId, long groupId,
			String tvShowTitle, Date tvShowPremierDate, 
			String tvShowDescription, 
			String tvShowImageUrl, String tvShowImageUuid, 
			String tvShowImageTitle, String tvShowImageVersion, 
			ServiceContext serviceContext) throws PortalException, SystemException {
		
		TvTrackerModelPermission.check(getPermissionChecker(), groupId, CustomActionKeys.ADD_TVSHOW);
		
		return tvShowLocalService.addTvShow(
				userId, groupId, 
				tvShowTitle, tvShowPremierDate, 
				tvShowDescription, 
				tvShowImageUrl, tvShowImageUuid, 
				tvShowImageTitle, tvShowImageVersion, 
				serviceContext);
	}
	
	/***************************************************************************/
	/********** BLL - DELETE Entity ********************************************/
	/***************************************************************************/
	
	public TvShow deleteTvShow(long groupId, long tvShowId,	ServiceContext serviceContext) throws PortalException, SystemException {
		
		TvShowPermission.check(getPermissionChecker(), groupId, tvShowId, CustomActionKeys.DELETE);
	
		return tvShowLocalService.deleteTvShow(groupId, tvShowId, serviceContext);
	}
	
	/***************************************************************************/
	/********** BLL - UPDATE Entity ********************************************/
	/***************************************************************************/
	
	public TvShow updateTvShow(
			long userId, long groupId, long tvShowId,
			String tvShowTitle, Date tvShowPremierDate, 
			String tvShowDescription, 
			String tvShowImageUrl, String tvShowImageUuid, 
			String tvShowImageTitle, String tvShowImageVersion, 
			ServiceContext serviceContext) throws PortalException, SystemException {
		
		TvShowPermission.check(getPermissionChecker(), groupId, tvShowId, CustomActionKeys.UPDATE);
		
		return tvShowLocalService.updateTvShow(
				userId, groupId, tvShowId, 
				tvShowTitle, tvShowPremierDate, 
				tvShowDescription, 
				tvShowImageUrl, tvShowImageUuid, 
				tvShowImageTitle, tvShowImageVersion, 
				serviceContext);
	}
}