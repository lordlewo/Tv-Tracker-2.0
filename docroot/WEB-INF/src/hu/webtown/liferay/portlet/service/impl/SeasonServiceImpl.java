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

import hu.webtown.liferay.portlet.model.Season;
import hu.webtown.liferay.portlet.service.base.SeasonServiceBaseImpl;
import hu.webtown.liferay.portlet.service.permission.CustomActionKeys;
import hu.webtown.liferay.portlet.service.permission.SeasonPermission;
import hu.webtown.liferay.portlet.service.permission.TvTrackerModelPermission;

import java.util.Date;

/**
 * The implementation of the season remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.webtown.liferay.portlet.service.SeasonService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author czeni
 * @see hu.webtown.liferay.portlet.service.base.SeasonServiceBaseImpl
 * @see hu.webtown.liferay.portlet.service.SeasonServiceUtil
 */
public class SeasonServiceImpl extends SeasonServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link hu.webtown.liferay.portlet.service.SeasonServiceUtil} to access the season remote service.
	 */
	
	/***************************************************************************/
	/********** BLL - CREATE Entity ********************************************/
	/***************************************************************************/
	
	public Season addSeason(
			long userId, long groupId, long tvShowId, 
			String seasonTitle, Date seasonPremierDate, 
			int seasonNumber, String seasonDescription, 
			String seasonImageUrl, String seasonImageUuid, 
			String seasonImageTitle, String seasonImageVersion, 
			ServiceContext serviceContext) throws PortalException, SystemException {
		
		TvTrackerModelPermission.check(getPermissionChecker(), groupId, CustomActionKeys.ADD_SEASON);
		
		return seasonLocalService.addSeason(
				userId, groupId, tvShowId, 
				seasonTitle, seasonPremierDate, 
				seasonNumber, seasonDescription, 
				seasonImageUrl, seasonImageUuid, 
				seasonImageTitle, seasonImageVersion, 
				serviceContext);
	}
	
	/***************************************************************************/
	/********** BLL - DELETE Entity ********************************************/
	/***************************************************************************/
	
	public Season deleteSeason(long groupId, long seasonId, ServiceContext serviceContext) 
			throws PortalException, SystemException { 
		
		SeasonPermission.check(getPermissionChecker(), groupId, seasonId, CustomActionKeys.DELETE);
		
		return seasonLocalService.deleteSeason(groupId, seasonId, serviceContext);
	}
	
	/***************************************************************************/
	/********** BLL - UPDATE Entity ********************************************/
	/***************************************************************************/
	
	public Season updateSeason(
			long userId, long groupId, 
			long tvShowId, long seasonId,
			String seasonTitle, Date seasonPremierDate, 
			int seasonNumber, String seasonDescription, 
			String seasonImageUrl, String seasonImageUuid, 
			String seasonImageTitle, String seasonImageVersion, 
			ServiceContext serviceContext) throws PortalException, SystemException {
		
		SeasonPermission.check(getPermissionChecker(), groupId, seasonId, CustomActionKeys.UPDATE);
		
		return seasonLocalService.updateSeason(
				userId, groupId, 
				tvShowId, seasonId, 
				seasonTitle, seasonPremierDate, 
				seasonNumber, seasonDescription, 
				seasonImageUrl, seasonImageUuid, 
				seasonImageTitle, seasonImageVersion, 
				serviceContext);
	}
}