package hu.webtown.liferay.portlet.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import hu.webtown.liferay.portlet.model.TvShow;
import hu.webtown.liferay.portlet.service.TvShowLocalServiceUtil;

public class TvShowPermission {

	public static final String RESOURCE_NAME = TvShow.class.getName();

	public TvShowPermission() {}
	
	/***************************************************************************/
	/********** Check **********************************************************/
	/***************************************************************************/
	
	public static void check(PermissionChecker permissionChecker, TvShow tvShow, String actionId)
			throws PortalException, SystemException {

		// using the helper method for checking the permissions

		boolean hasPermission = TvShowPermission.contains(
				permissionChecker,
				tvShow, 
				actionId);

		if (!hasPermission) {
			throw new PrincipalException();
		}
	}
	
	public static void check(PermissionChecker permissionChecker, long tvShowId, String actionId)
			throws PortalException, SystemException {

		// using the helper method for checking the permissions

		boolean hasPermission = TvShowPermission.contains(
				permissionChecker,
				tvShowId, 
				actionId);

		if (!hasPermission) {
			throw new PrincipalException();
		}
	}
	
	public static void check(PermissionChecker permissionChecker, long groupId, long tvShowId, String actionId)
			throws PortalException, SystemException {

		// using the helper method for checking the permissions

		boolean hasPermission = TvShowPermission.contains(
				permissionChecker,
				groupId,
				tvShowId, 
				actionId);

		if (!hasPermission) {
			throw new PrincipalException();
		}
	}
	
	/***************************************************************************/
	/********** Contains *******************************************************/
	/***************************************************************************/
	
	public static boolean contains(PermissionChecker permissionChecker,	TvShow tvShow, String actionId)
			throws PortalException,	SystemException {

		// unbox and prepare some nessesery parameters

		long companyId = tvShow.getCompanyId();
		long groupId = tvShow.getGroupId();
		long userId = tvShow.getUserId();
		long tvShowId = tvShow.getTvShowId();
		
		// decide, if exist the appropriate owner permission for the action against the
		// particular entity instance
		
		boolean hasOwnerPermission = permissionChecker.hasOwnerPermission(
				companyId, 
				TvShowPermission.RESOURCE_NAME, 
				tvShowId, 
				userId, 
				actionId);

		// decide, if exist the appropriate permission for the action against the
		// particular entity instance

		boolean hasPermission = permissionChecker.hasPermission(
				groupId,
				TvShowPermission.RESOURCE_NAME, 
				tvShowId, 
				actionId);

		return hasOwnerPermission || hasPermission;
	}

	public static boolean contains(PermissionChecker permissionChecker,	long tvShowId, String actionId)
			throws PortalException,	SystemException {

		// retrieve the appropriate entity instance from the database

		TvShow tvShow = TvShowLocalServiceUtil.getTvShow(tvShowId);

		return contains(permissionChecker, tvShow, actionId);
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, long tvShowId, String actionId)
			throws PortalException,	SystemException {

		// retrieve the appropriate entity instance from the database

		TvShow tvShow = TvShowLocalServiceUtil.getTvShow(groupId, tvShowId);
		
		return contains(permissionChecker, tvShow, actionId);
	}

}
