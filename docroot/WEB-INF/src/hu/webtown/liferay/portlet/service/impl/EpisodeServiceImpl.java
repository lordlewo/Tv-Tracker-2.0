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
import hu.webtown.liferay.portlet.service.EpisodeLocalService;
import hu.webtown.liferay.portlet.service.base.EpisodeServiceBaseImpl;
import hu.webtown.liferay.portlet.service.permission.CustomActionKeys;
import hu.webtown.liferay.portlet.service.permission.EpisodePermission;
import hu.webtown.liferay.portlet.service.permission.TvTrackerModelPermission;

import java.util.Date;

/**
 * The implementation of the episode remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.webtown.liferay.portlet.service.EpisodeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author czeni
 * @see hu.webtown.liferay.portlet.service.base.EpisodeServiceBaseImpl
 * @see hu.webtown.liferay.portlet.service.EpisodeServiceUtil
 */
public class EpisodeServiceImpl extends EpisodeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link hu.webtown.liferay.portlet.service.EpisodeServiceUtil} to access the episode remote service.
	 */
	
	/***************************************************************************/
	/********** BLL - CREATE Entity ********************************************/
	/***************************************************************************/
	
	public Episode addEpisode(
			long userId, long groupId, long seasonId, 
			String episodeTitle, Date episodeAirDate, 
			int episodeNumber, String episodeDescription, 
			String episodeImageUrl, String episodeImageUuid, 
			String episodeImageTitle, String episodeImageVersion, 
			ServiceContext serviceContext) throws PortalException, SystemException {
		
		TvTrackerModelPermission.check(getPermissionChecker(), groupId, CustomActionKeys.ADD_EPISODE);
		
		return episodeLocalService.addEpisode(
				userId, groupId, seasonId, 
				episodeTitle, episodeAirDate, 
				episodeNumber, episodeDescription, 
				episodeImageUrl, episodeImageUuid, 
				episodeImageTitle, episodeImageVersion, 
				serviceContext);
	}
	
	/***************************************************************************/
	/********** BLL - DELETE Entity ********************************************/
	/***************************************************************************/
	
	public Episode deleteEpisode(long groupId, long episodeId, ServiceContext serviceContext) 
			throws PortalException, SystemException { 
		
		EpisodePermission.check(getPermissionChecker(), groupId, episodeId, CustomActionKeys.DELETE);
		
		return episodeLocalService.deleteEpisode(groupId, episodeId, serviceContext);
	}
	
	/***************************************************************************/
	/********** BLL - UPDATE Entity ********************************************/
	/***************************************************************************/
	
	public Episode updateEpisode(
			long userId, long groupId, 
			long seasonId, long episodeId,
			String episodeTitle, Date episodeAirDate, 
			int episodeNumber, String episodeDescription, 
			String episodeImageUrl, String episodeImageUuid, 
			String episodeImageTitle, String episodeImageVersion, 
			ServiceContext serviceContext) throws PortalException, SystemException {
		
		EpisodePermission.check(getPermissionChecker(), groupId, episodeId, CustomActionKeys.UPDATE);
		
		return episodeLocalService.updateEpisode(
				userId, groupId, 
				seasonId, episodeId, 
				episodeTitle, episodeAirDate, 
				episodeNumber, episodeDescription, 
				episodeImageUrl, episodeImageUuid, 
				episodeImageTitle, episodeImageVersion, 
				serviceContext);
	}
}