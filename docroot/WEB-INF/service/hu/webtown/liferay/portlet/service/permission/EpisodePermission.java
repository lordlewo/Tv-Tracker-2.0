package hu.webtown.liferay.portlet.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import hu.webtown.liferay.portlet.model.Episode;
import hu.webtown.liferay.portlet.service.EpisodeLocalServiceUtil;

public class EpisodePermission {

	public static final String RESOURCE_NAME = Episode.class.getName();

	public EpisodePermission() {}

	/***************************************************************************/
	/********** Check **********************************************************/
	/***************************************************************************/
	
	public static void check(PermissionChecker permissionChecker, Episode episode, String actionId) 
			throws PortalException, SystemException {

		// using the helper method for checking the permissions

		boolean hasPermission = EpisodePermission.contains(
				permissionChecker,
				episode, 
				actionId);

		if (!hasPermission) {
			throw new PrincipalException();
		}
	}
	
	public static void check(PermissionChecker permissionChecker, long episodeId, String actionId) 
			throws PortalException, SystemException {

		// using the helper method for checking the permissions

		boolean hasPermission = EpisodePermission.contains(
				permissionChecker,
				episodeId, 
				actionId);

		if (!hasPermission) {
			throw new PrincipalException();
		}
	}
	
	public static void check(PermissionChecker permissionChecker, long groupId, long episodeId, String actionId) 
			throws PortalException, SystemException {

		// using the helper method for checking the permissions

		boolean hasPermission = EpisodePermission.contains(
				permissionChecker,
				groupId,
				episodeId, 
				actionId);

		if (!hasPermission) {
			throw new PrincipalException();
		}
	}

	/***************************************************************************/
	/********** Contains *******************************************************/
	/***************************************************************************/
	
	public static boolean contains(PermissionChecker permissionChecker, Episode episode, String actionId) 
			throws PortalException,	SystemException {

		// unbox and prepare some nessesery parameters

		long companyId = episode.getCompanyId();
		long groupId = episode.getGroupId();
		long userId = episode.getUserId();
		long episodeId = episode.getEpisodeId();
		
		// decide, if exist the apropriate owner permission for the action against the
		// particular entity instance
				
		boolean hasOwnerPermission = permissionChecker.hasOwnerPermission(
				companyId, 
				EpisodePermission.RESOURCE_NAME, 
				episodeId, 
				userId, 
				actionId);

		// decide, if exist the apropriate permission for the action against the
		// particular entity instance

		boolean hasPermission = permissionChecker.hasPermission(
				groupId,
				EpisodePermission.RESOURCE_NAME, 
				episodeId, 
				actionId);

		return hasOwnerPermission || hasPermission;
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long episodeId, String actionId) 
			throws PortalException,	SystemException {

		// retrieve the appropriate entity instance from the database

		Episode episode = EpisodeLocalServiceUtil.getEpisode(episodeId);

		return contains(permissionChecker, episode, actionId);
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, long episodeId, String actionId) 
			throws PortalException,	SystemException {

		// retrieve the appropriate entity instance from the database

		Episode episode = EpisodeLocalServiceUtil.getEpisode(groupId, episodeId);
		
		return contains(permissionChecker, episode, actionId);
	}

}
