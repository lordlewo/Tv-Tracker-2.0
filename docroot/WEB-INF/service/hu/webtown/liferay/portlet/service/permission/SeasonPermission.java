package hu.webtown.liferay.portlet.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import hu.webtown.liferay.portlet.model.Season;
import hu.webtown.liferay.portlet.service.SeasonLocalServiceUtil;

public class SeasonPermission {

	public static final String RESOURCE_NAME = Season.class.getName();

	public SeasonPermission() {}
	
	/***************************************************************************/
	/********** Check **********************************************************/
	/***************************************************************************/
	
	public static void check(PermissionChecker permissionChecker, Season season, String actionId) 
			throws PortalException,	SystemException {

		// using the helper method for checking the permissions

		boolean hasPermission = SeasonPermission.contains(
				permissionChecker,
				season, 
				actionId);

		if (!hasPermission) {
			throw new PrincipalException();
		}
	}
	
	public static void check(PermissionChecker permissionChecker, long seasonId, String actionId) 
			throws PortalException,	SystemException {

		// using the helper method for checking the permissions

		boolean hasPermission = SeasonPermission.contains(
				permissionChecker,
				seasonId, 
				actionId);

		if (!hasPermission) {
			throw new PrincipalException();
		}
	}
	
	public static void check(PermissionChecker permissionChecker, long groupId, long seasonId, String actionId) 
			throws PortalException,	SystemException {

		// using the helper method for checking the permissions

		boolean hasPermission = SeasonPermission.contains(
				permissionChecker,
				groupId, 
				seasonId, 
				actionId);

		if (!hasPermission) {
			throw new PrincipalException();
		}
	}
	
	/***************************************************************************/
	/********** Contains *******************************************************/
	/***************************************************************************/
	
	public static boolean contains(PermissionChecker permissionChecker, Season season, String actionId) 
			throws PortalException,	SystemException {

		// unbox and prepare some nessesery parameters

		long companyId = season.getCompanyId();
		long groupId = season.getGroupId();
		long userId = season.getUserId();
		long seasonId = season.getSeasonId();
		
		// decide, if exist the apropriate owner permission for the action against the
		// particular entity instance
				
		boolean hasOwnerPermission = permissionChecker.hasOwnerPermission(
				companyId, 
				SeasonPermission.RESOURCE_NAME, 
				seasonId, 
				userId, 
				actionId);

		// decide, if exist the apropriate permission for the action against the
		// particular entity instance

		boolean hasPermission = permissionChecker.hasPermission(
				groupId,
				SeasonPermission.RESOURCE_NAME, 
				seasonId, 
				actionId);

		return hasOwnerPermission || hasPermission;
	}

	public static boolean contains(PermissionChecker permissionChecker, long seasonId, String actionId) 
			throws PortalException,	SystemException {

		// retrieve the appropriate entity instance from the database

		Season season = SeasonLocalServiceUtil.getSeason(seasonId);

		return contains(permissionChecker, season, actionId);
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, long seasonId, String actionId) 
			throws PortalException,	SystemException {

		// retrieve the appropriate entity instance from the database

		Season season = SeasonLocalServiceUtil.getSeason(groupId, seasonId);
		
		return contains(permissionChecker, season, actionId);
	}

}
