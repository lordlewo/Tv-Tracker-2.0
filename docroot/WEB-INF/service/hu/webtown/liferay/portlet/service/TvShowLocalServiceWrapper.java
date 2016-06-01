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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TvShowLocalService}.
 *
 * @author czeni
 * @see TvShowLocalService
 * @generated
 */
public class TvShowLocalServiceWrapper implements TvShowLocalService,
	ServiceWrapper<TvShowLocalService> {
	public TvShowLocalServiceWrapper(TvShowLocalService tvShowLocalService) {
		_tvShowLocalService = tvShowLocalService;
	}

	/**
	* Adds the tv show to the database. Also notifies the appropriate model listeners.
	*
	* @param tvShow the tv show
	* @return the tv show that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.portlet.model.TvShow addTvShow(
		hu.webtown.liferay.portlet.model.TvShow tvShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.addTvShow(tvShow);
	}

	/**
	* Creates a new tv show with the primary key. Does not add the tv show to the database.
	*
	* @param tvShowId the primary key for the new tv show
	* @return the new tv show
	*/
	@Override
	public hu.webtown.liferay.portlet.model.TvShow createTvShow(long tvShowId) {
		return _tvShowLocalService.createTvShow(tvShowId);
	}

	/**
	* Deletes the tv show with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tvShowId the primary key of the tv show
	* @return the tv show that was removed
	* @throws PortalException if a tv show with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.portlet.model.TvShow deleteTvShow(long tvShowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.deleteTvShow(tvShowId);
	}

	/**
	* Deletes the tv show from the database. Also notifies the appropriate model listeners.
	*
	* @param tvShow the tv show
	* @return the tv show that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.portlet.model.TvShow deleteTvShow(
		hu.webtown.liferay.portlet.model.TvShow tvShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.deleteTvShow(tvShow);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tvShowLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.TvShowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.TvShowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public hu.webtown.liferay.portlet.model.TvShow fetchTvShow(long tvShowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.fetchTvShow(tvShowId);
	}

	/**
	* Returns the tv show with the matching UUID and company.
	*
	* @param uuid the tv show's UUID
	* @param companyId the primary key of the company
	* @return the matching tv show, or <code>null</code> if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.portlet.model.TvShow fetchTvShowByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.fetchTvShowByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the tv show matching the UUID and group.
	*
	* @param uuid the tv show's UUID
	* @param groupId the primary key of the group
	* @return the matching tv show, or <code>null</code> if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.portlet.model.TvShow fetchTvShowByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.fetchTvShowByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the tv show with the primary key.
	*
	* @param tvShowId the primary key of the tv show
	* @return the tv show
	* @throws PortalException if a tv show with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.portlet.model.TvShow getTvShow(long tvShowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShow(tvShowId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the tv show with the matching UUID and company.
	*
	* @param uuid the tv show's UUID
	* @param companyId the primary key of the company
	* @return the matching tv show
	* @throws PortalException if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.portlet.model.TvShow getTvShowByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShowByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the tv show matching the UUID and group.
	*
	* @param uuid the tv show's UUID
	* @param groupId the primary key of the group
	* @return the matching tv show
	* @throws PortalException if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.portlet.model.TvShow getTvShowByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShowByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the tv shows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.TvShowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tv shows
	* @param end the upper bound of the range of tv shows (not inclusive)
	* @return the range of tv shows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> getTvShows(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShows(start, end);
	}

	/**
	* Returns the number of tv shows.
	*
	* @return the number of tv shows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTvShowsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShowsCount();
	}

	/**
	* Updates the tv show in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tvShow the tv show
	* @return the tv show that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.portlet.model.TvShow updateTvShow(
		hu.webtown.liferay.portlet.model.TvShow tvShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.updateTvShow(tvShow);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tvShowLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tvShowLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tvShowLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public hu.webtown.liferay.portlet.model.TvShow getTvShow(long groupId,
		long tvShowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShow(groupId, tvShowId);
	}

	@Override
	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> getTvShows(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShows(groupId);
	}

	@Override
	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> getTvShows(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShows(groupId, start, end);
	}

	@Override
	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> getTvShows(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShows(groupId, orderByComparator);
	}

	@Override
	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> getTvShows(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShows(groupId, start, end,
			orderByComparator);
	}

	@Override
	public int getTvShowsCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShowsCount(groupId);
	}

	@Override
	public hu.webtown.liferay.portlet.model.TvShow addTvShow(long userId,
		long groupId, java.lang.String tvShowTitle,
		java.util.Date tvShowPremierDate, java.lang.String tvShowDescription,
		java.lang.String tvShowImageUrl, java.lang.String tvShowImageUuid,
		java.lang.String tvShowImageTitle, java.lang.String tvShowImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.addTvShow(userId, groupId, tvShowTitle,
			tvShowPremierDate, tvShowDescription, tvShowImageUrl,
			tvShowImageUuid, tvShowImageTitle, tvShowImageVersion,
			serviceContext);
	}

	@Override
	public hu.webtown.liferay.portlet.model.TvShow updateTvShow(long userId,
		long groupId, long tvShowId, java.lang.String tvShowTitle,
		java.util.Date tvShowPremierDate, java.lang.String tvShowDescription,
		java.lang.String tvShowImageUrl, java.lang.String tvShowImageUuid,
		java.lang.String tvShowImageTitle, java.lang.String tvShowImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.updateTvShow(userId, groupId, tvShowId,
			tvShowTitle, tvShowPremierDate, tvShowDescription, tvShowImageUrl,
			tvShowImageUuid, tvShowImageTitle, tvShowImageVersion,
			serviceContext);
	}

	@Override
	public hu.webtown.liferay.portlet.model.TvShow deleteTvShow(long tvShowId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.deleteTvShow(tvShowId, serviceContext);
	}

	@Override
	public hu.webtown.liferay.portlet.model.TvShow deleteTvShow(long groupId,
		long tvShowId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.deleteTvShow(groupId, tvShowId,
			serviceContext);
	}

	@Override
	public hu.webtown.liferay.portlet.model.TvShow deleteTvShow(
		hu.webtown.liferay.portlet.model.TvShow tvShow,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.deleteTvShow(tvShow, serviceContext);
	}

	@Override
	public void addTvShowResources(
		hu.webtown.liferay.portlet.model.TvShow tvShow,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tvShowLocalService.addTvShowResources(tvShow, addGroupPermissions,
			addGuestPermissions);
	}

	@Override
	public void addTvShowModelResources(
		hu.webtown.liferay.portlet.model.TvShow tvShow,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tvShowLocalService.addTvShowModelResources(tvShow, groupPermissions,
			guestPermissions);
	}

	@Override
	public void updateTvShowResources(
		hu.webtown.liferay.portlet.model.TvShow tvShow,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tvShowLocalService.updateTvShowResources(tvShow, groupPermissions,
			guestPermissions);
	}

	@Override
	public void updateTvShowModelResources(
		hu.webtown.liferay.portlet.model.TvShow tvShow,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tvShowLocalService.updateTvShowModelResources(tvShow, serviceContext);
	}

	@Override
	public void updateTvShowAsset(long userId,
		hu.webtown.liferay.portlet.model.TvShow tvShow,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tvShowLocalService.updateTvShowAsset(userId, tvShow, assetCategoryIds,
			assetTagNames, assetLinkEntryIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TvShowLocalService getWrappedTvShowLocalService() {
		return _tvShowLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTvShowLocalService(
		TvShowLocalService tvShowLocalService) {
		_tvShowLocalService = tvShowLocalService;
	}

	@Override
	public TvShowLocalService getWrappedService() {
		return _tvShowLocalService;
	}

	@Override
	public void setWrappedService(TvShowLocalService tvShowLocalService) {
		_tvShowLocalService = tvShowLocalService;
	}

	private TvShowLocalService _tvShowLocalService;
}