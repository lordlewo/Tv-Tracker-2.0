package hu.webtown.liferay.portlet.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class TvTrackerModelPermission {

	public static final String RESOURCE_NAME = "hu.webtown.liferay.portlet.model";

	/***************************************************************************/
	/********** Check **********************************************************/
	/***************************************************************************/
	
	public static void check(PermissionChecker permissionChecker, long groupId,
			String actionId) throws PortalException {

		// using the helper method for checking the permissions

		boolean hasPermisson = TvTrackerModelPermission.contains(
				permissionChecker, groupId, actionId);

		if (!hasPermisson) {
			throw new PrincipalException();
		}
	}

	/***************************************************************************/
	/********** Contains *******************************************************/
	/***************************************************************************/
	
	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, String actionId) {

		// decide, if exist the appropriate permission against the action

		boolean hasPermission = permissionChecker.hasPermission(groupId,
				TvTrackerModelPermission.RESOURCE_NAME, groupId, actionId);

		return hasPermission;
	}
}
