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

package hu.webtown.liferay.portlet.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import hu.webtown.liferay.portlet.model.TvShow;

/**
 * The persistence interface for the tv show service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author czeni
 * @see TvShowPersistenceImpl
 * @see TvShowUtil
 * @generated
 */
public interface TvShowPersistence extends BasePersistence<TvShow> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TvShowUtil} to access the tv show persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tv shows where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching tv shows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tv shows where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.TvShowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tv shows
	* @param end the upper bound of the range of tv shows (not inclusive)
	* @return the range of matching tv shows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tv shows where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.TvShowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tv shows
	* @param end the upper bound of the range of tv shows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tv shows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tv show in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tv show
	* @throws hu.webtown.liferay.portlet.NoSuchTvShowException if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.TvShow findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchTvShowException;

	/**
	* Returns the first tv show in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tv show, or <code>null</code> if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.TvShow fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tv show in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tv show
	* @throws hu.webtown.liferay.portlet.NoSuchTvShowException if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.TvShow findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchTvShowException;

	/**
	* Returns the last tv show in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tv show, or <code>null</code> if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.TvShow fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tv shows before and after the current tv show in the ordered set where groupId = &#63;.
	*
	* @param tvShowId the primary key of the current tv show
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tv show
	* @throws hu.webtown.liferay.portlet.NoSuchTvShowException if a tv show with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.TvShow[] findByGroupId_PrevAndNext(
		long tvShowId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchTvShowException;

	/**
	* Removes all the tv shows where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tv shows where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching tv shows
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tv shows where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching tv shows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tv shows where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.TvShowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of tv shows
	* @param end the upper bound of the range of tv shows (not inclusive)
	* @return the range of matching tv shows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tv shows where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.TvShowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of tv shows
	* @param end the upper bound of the range of tv shows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tv shows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tv show in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tv show
	* @throws hu.webtown.liferay.portlet.NoSuchTvShowException if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.TvShow findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchTvShowException;

	/**
	* Returns the first tv show in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tv show, or <code>null</code> if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.TvShow fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tv show in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tv show
	* @throws hu.webtown.liferay.portlet.NoSuchTvShowException if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.TvShow findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchTvShowException;

	/**
	* Returns the last tv show in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tv show, or <code>null</code> if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.TvShow fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tv shows before and after the current tv show in the ordered set where companyId = &#63;.
	*
	* @param tvShowId the primary key of the current tv show
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tv show
	* @throws hu.webtown.liferay.portlet.NoSuchTvShowException if a tv show with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.TvShow[] findByCompanyId_PrevAndNext(
		long tvShowId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchTvShowException;

	/**
	* Removes all the tv shows where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tv shows where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching tv shows
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tv show where tvShowId = &#63; and groupId = &#63; or throws a {@link hu.webtown.liferay.portlet.NoSuchTvShowException} if it could not be found.
	*
	* @param tvShowId the tv show ID
	* @param groupId the group ID
	* @return the matching tv show
	* @throws hu.webtown.liferay.portlet.NoSuchTvShowException if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.TvShow findByG_T(long tvShowId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchTvShowException;

	/**
	* Returns the tv show where tvShowId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param tvShowId the tv show ID
	* @param groupId the group ID
	* @return the matching tv show, or <code>null</code> if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.TvShow fetchByG_T(long tvShowId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tv show where tvShowId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param tvShowId the tv show ID
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching tv show, or <code>null</code> if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.TvShow fetchByG_T(long tvShowId,
		long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the tv show where tvShowId = &#63; and groupId = &#63; from the database.
	*
	* @param tvShowId the tv show ID
	* @param groupId the group ID
	* @return the tv show that was removed
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.TvShow removeByG_T(long tvShowId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchTvShowException;

	/**
	* Returns the number of tv shows where tvShowId = &#63; and groupId = &#63;.
	*
	* @param tvShowId the tv show ID
	* @param groupId the group ID
	* @return the number of matching tv shows
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_T(long tvShowId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the tv show in the entity cache if it is enabled.
	*
	* @param tvShow the tv show
	*/
	public void cacheResult(hu.webtown.liferay.portlet.model.TvShow tvShow);

	/**
	* Caches the tv shows in the entity cache if it is enabled.
	*
	* @param tvShows the tv shows
	*/
	public void cacheResult(
		java.util.List<hu.webtown.liferay.portlet.model.TvShow> tvShows);

	/**
	* Creates a new tv show with the primary key. Does not add the tv show to the database.
	*
	* @param tvShowId the primary key for the new tv show
	* @return the new tv show
	*/
	public hu.webtown.liferay.portlet.model.TvShow create(long tvShowId);

	/**
	* Removes the tv show with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tvShowId the primary key of the tv show
	* @return the tv show that was removed
	* @throws hu.webtown.liferay.portlet.NoSuchTvShowException if a tv show with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.TvShow remove(long tvShowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchTvShowException;

	public hu.webtown.liferay.portlet.model.TvShow updateImpl(
		hu.webtown.liferay.portlet.model.TvShow tvShow)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tv show with the primary key or throws a {@link hu.webtown.liferay.portlet.NoSuchTvShowException} if it could not be found.
	*
	* @param tvShowId the primary key of the tv show
	* @return the tv show
	* @throws hu.webtown.liferay.portlet.NoSuchTvShowException if a tv show with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.TvShow findByPrimaryKey(
		long tvShowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchTvShowException;

	/**
	* Returns the tv show with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tvShowId the primary key of the tv show
	* @return the tv show, or <code>null</code> if a tv show with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.TvShow fetchByPrimaryKey(
		long tvShowId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tv shows.
	*
	* @return the tv shows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tv shows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.TvShowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tv shows
	* @param end the upper bound of the range of tv shows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tv shows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tv shows from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tv shows.
	*
	* @return the number of tv shows
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}