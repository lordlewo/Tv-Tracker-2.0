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
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Season. This utility wraps
 * {@link hu.webtown.liferay.portlet.service.impl.SeasonLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author czeni
 * @see SeasonLocalService
 * @see hu.webtown.liferay.portlet.service.base.SeasonLocalServiceBaseImpl
 * @see hu.webtown.liferay.portlet.service.impl.SeasonLocalServiceImpl
 * @generated
 */
public class SeasonLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.webtown.liferay.portlet.service.impl.SeasonLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the season to the database. Also notifies the appropriate model listeners.
	*
	* @param season the season
	* @return the season that was added
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season addSeason(
		hu.webtown.liferay.portlet.model.Season season)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSeason(season);
	}

	/**
	* Creates a new season with the primary key. Does not add the season to the database.
	*
	* @param seasonId the primary key for the new season
	* @return the new season
	*/
	public static hu.webtown.liferay.portlet.model.Season createSeason(
		long seasonId) {
		return getService().createSeason(seasonId);
	}

	/**
	* Deletes the season with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param seasonId the primary key of the season
	* @return the season that was removed
	* @throws PortalException if a season with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season deleteSeason(
		long seasonId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSeason(seasonId);
	}

	/**
	* Deletes the season from the database. Also notifies the appropriate model listeners.
	*
	* @param season the season
	* @return the season that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season deleteSeason(
		hu.webtown.liferay.portlet.model.Season season)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSeason(season);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static hu.webtown.liferay.portlet.model.Season fetchSeason(
		long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSeason(seasonId);
	}

	/**
	* Returns the season with the matching UUID and company.
	*
	* @param uuid the season's UUID
	* @param companyId the primary key of the company
	* @return the matching season, or <code>null</code> if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season fetchSeasonByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSeasonByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the season matching the UUID and group.
	*
	* @param uuid the season's UUID
	* @param groupId the primary key of the group
	* @return the matching season, or <code>null</code> if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season fetchSeasonByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSeasonByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the season with the primary key.
	*
	* @param seasonId the primary key of the season
	* @return the season
	* @throws PortalException if a season with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season getSeason(
		long seasonId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeason(seasonId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the season with the matching UUID and company.
	*
	* @param uuid the season's UUID
	* @param companyId the primary key of the company
	* @return the matching season
	* @throws PortalException if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season getSeasonByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeasonByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the season matching the UUID and group.
	*
	* @param uuid the season's UUID
	* @param groupId the primary key of the group
	* @return the matching season
	* @throws PortalException if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season getSeasonByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeasonByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the seasons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of seasons
	* @param end the upper bound of the range of seasons (not inclusive)
	* @return the range of seasons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> getSeasons(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeasons(start, end);
	}

	/**
	* Returns the number of seasons.
	*
	* @return the number of seasons
	* @throws SystemException if a system exception occurred
	*/
	public static int getSeasonsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeasonsCount();
	}

	/**
	* Updates the season in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param season the season
	* @return the season that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season updateSeason(
		hu.webtown.liferay.portlet.model.Season season)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSeason(season);
	}

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

	public static hu.webtown.liferay.portlet.model.Season getSeason(
		long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeason(groupId, seasonId);
	}

	public static java.util.List<hu.webtown.liferay.portlet.model.Season> getSeasons(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeasons(groupId);
	}

	public static java.util.List<hu.webtown.liferay.portlet.model.Season> getSeasons(
		long groupId, long tvShowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeasons(groupId, tvShowId);
	}

	public static java.util.List<hu.webtown.liferay.portlet.model.Season> getSeasons(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeasons(groupId, start, end);
	}

	public static java.util.List<hu.webtown.liferay.portlet.model.Season> getSeasons(
		long groupId, long tvShowId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeasons(groupId, tvShowId, start, end);
	}

	public static java.util.List<hu.webtown.liferay.portlet.model.Season> getSeasons(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeasons(groupId, orderByComparator);
	}

	public static java.util.List<hu.webtown.liferay.portlet.model.Season> getSeasons(
		long groupId, long tvShowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeasons(groupId, tvShowId, orderByComparator);
	}

	public static java.util.List<hu.webtown.liferay.portlet.model.Season> getSeasons(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeasons(groupId, start, end, orderByComparator);
	}

	public static java.util.List<hu.webtown.liferay.portlet.model.Season> getSeasons(
		long groupId, long tvShowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSeasons(groupId, tvShowId, start, end, orderByComparator);
	}

	public static int getSeasonsCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeasonsCount(groupId);
	}

	public static int getSeasonsCount(long groupId, long tvShowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeasonsCount(groupId, tvShowId);
	}

	public static hu.webtown.liferay.portlet.model.Season addSeason(
		long userId, long groupId, long tvShowId, java.lang.String seasonTitle,
		java.util.Date seasonPremierDate, int seasonNumber,
		java.lang.String seasonDescription, java.lang.String seasonImageUrl,
		java.lang.String seasonImageUuid, java.lang.String seasonImageTitle,
		java.lang.String seasonImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSeason(userId, groupId, tvShowId, seasonTitle,
			seasonPremierDate, seasonNumber, seasonDescription, seasonImageUrl,
			seasonImageUuid, seasonImageTitle, seasonImageVersion,
			serviceContext);
	}

	public static hu.webtown.liferay.portlet.model.Season updateSeason(
		long userId, long groupId, long tvShowId, long seasonId,
		java.lang.String seasonTitle, java.util.Date seasonPremierDate,
		int seasonNumber, java.lang.String seasonDescription,
		java.lang.String seasonImageUrl, java.lang.String seasonImageUuid,
		java.lang.String seasonImageTitle, java.lang.String seasonImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSeason(userId, groupId, tvShowId, seasonId,
			seasonTitle, seasonPremierDate, seasonNumber, seasonDescription,
			seasonImageUrl, seasonImageUuid, seasonImageTitle,
			seasonImageVersion, serviceContext);
	}

	public static hu.webtown.liferay.portlet.model.Season deleteSeason(
		long seasonId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSeason(seasonId, serviceContext);
	}

	public static hu.webtown.liferay.portlet.model.Season deleteSeason(
		long groupId, long seasonId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSeason(groupId, seasonId, serviceContext);
	}

	public static hu.webtown.liferay.portlet.model.Season deleteSeason(
		hu.webtown.liferay.portlet.model.Season season,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSeason(season, serviceContext);
	}

	public static void addSeasonResources(
		hu.webtown.liferay.portlet.model.Season season,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addSeasonResources(season, addGroupPermissions, addGuestPermissions);
	}

	public static void addSeasonModelResources(
		hu.webtown.liferay.portlet.model.Season season,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addSeasonModelResources(season, groupPermissions, guestPermissions);
	}

	public static void updateSeasonResources(
		hu.webtown.liferay.portlet.model.Season season,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateSeasonResources(season, groupPermissions, guestPermissions);
	}

	public static void updateSeasonModelResources(
		hu.webtown.liferay.portlet.model.Season season,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updateSeasonModelResources(season, serviceContext);
	}

	public static void updateSeasonAsset(long userId,
		hu.webtown.liferay.portlet.model.Season season,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateSeasonAsset(userId, season, assetCategoryIds, assetTagNames,
			assetLinkEntryIds);
	}

	public static void clearService() {
		_service = null;
	}

	public static SeasonLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SeasonLocalService.class.getName());

			if (invokableLocalService instanceof SeasonLocalService) {
				_service = (SeasonLocalService)invokableLocalService;
			}
			else {
				_service = new SeasonLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SeasonLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SeasonLocalService service) {
	}

	private static SeasonLocalService _service;
}