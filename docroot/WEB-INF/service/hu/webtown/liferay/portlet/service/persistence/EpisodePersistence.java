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

import hu.webtown.liferay.portlet.model.Episode;

/**
 * The persistence interface for the episode service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author czeni
 * @see EpisodePersistenceImpl
 * @see EpisodeUtil
 * @generated
 */
public interface EpisodePersistence extends BasePersistence<Episode> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EpisodeUtil} to access the episode persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the episodes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the episodes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of episodes
	* @param end the upper bound of the range of episodes (not inclusive)
	* @return the range of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the episodes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of episodes
	* @param end the upper bound of the range of episodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first episode in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Returns the first episode in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last episode in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Returns the last episode in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the episodes before and after the current episode in the ordered set where uuid = &#63;.
	*
	* @param episodeId the primary key of the current episode
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode[] findByUuid_PrevAndNext(
		long episodeId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Removes all the episodes where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of episodes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the episode where uuid = &#63; and groupId = &#63; or throws a {@link hu.webtown.liferay.portlet.NoSuchEpisodeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Returns the episode where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the episode where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the episode where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the episode that was removed
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Returns the number of episodes where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the episodes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the episodes where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of episodes
	* @param end the upper bound of the range of episodes (not inclusive)
	* @return the range of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the episodes where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of episodes
	* @param end the upper bound of the range of episodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first episode in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Returns the first episode in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last episode in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Returns the last episode in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the episodes before and after the current episode in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param episodeId the primary key of the current episode
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode[] findByUuid_C_PrevAndNext(
		long episodeId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Removes all the episodes where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of episodes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the episodes where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the episodes where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of episodes
	* @param end the upper bound of the range of episodes (not inclusive)
	* @return the range of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the episodes where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of episodes
	* @param end the upper bound of the range of episodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first episode in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Returns the first episode in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last episode in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Returns the last episode in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the episodes before and after the current episode in the ordered set where groupId = &#63;.
	*
	* @param episodeId the primary key of the current episode
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode[] findByGroupId_PrevAndNext(
		long episodeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Returns all the episodes that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching episodes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the episodes that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of episodes
	* @param end the upper bound of the range of episodes (not inclusive)
	* @return the range of matching episodes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the episodes that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of episodes
	* @param end the upper bound of the range of episodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching episodes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the episodes before and after the current episode in the ordered set of episodes that the user has permission to view where groupId = &#63;.
	*
	* @param episodeId the primary key of the current episode
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode[] filterFindByGroupId_PrevAndNext(
		long episodeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Removes all the episodes where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of episodes where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of episodes that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching episodes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the episodes where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the episodes where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of episodes
	* @param end the upper bound of the range of episodes (not inclusive)
	* @return the range of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the episodes where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of episodes
	* @param end the upper bound of the range of episodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first episode in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Returns the first episode in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last episode in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Returns the last episode in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the episodes before and after the current episode in the ordered set where companyId = &#63;.
	*
	* @param episodeId the primary key of the current episode
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode[] findByCompanyId_PrevAndNext(
		long episodeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Removes all the episodes where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of episodes where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the episodes where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> findByG_S(
		long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the episodes where groupId = &#63; and seasonId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @param start the lower bound of the range of episodes
	* @param end the upper bound of the range of episodes (not inclusive)
	* @return the range of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> findByG_S(
		long groupId, long seasonId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the episodes where groupId = &#63; and seasonId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @param start the lower bound of the range of episodes
	* @param end the upper bound of the range of episodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> findByG_S(
		long groupId, long seasonId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first episode in the ordered set where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode findByG_S_First(
		long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Returns the first episode in the ordered set where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode fetchByG_S_First(
		long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last episode in the ordered set where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode findByG_S_Last(
		long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Returns the last episode in the ordered set where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode fetchByG_S_Last(
		long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the episodes before and after the current episode in the ordered set where groupId = &#63; and seasonId = &#63;.
	*
	* @param episodeId the primary key of the current episode
	* @param groupId the group ID
	* @param seasonId the season ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode[] findByG_S_PrevAndNext(
		long episodeId, long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Returns all the episodes that the user has permission to view where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the matching episodes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> filterFindByG_S(
		long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the episodes that the user has permission to view where groupId = &#63; and seasonId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @param start the lower bound of the range of episodes
	* @param end the upper bound of the range of episodes (not inclusive)
	* @return the range of matching episodes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> filterFindByG_S(
		long groupId, long seasonId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the episodes that the user has permissions to view where groupId = &#63; and seasonId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @param start the lower bound of the range of episodes
	* @param end the upper bound of the range of episodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching episodes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> filterFindByG_S(
		long groupId, long seasonId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the episodes before and after the current episode in the ordered set of episodes that the user has permission to view where groupId = &#63; and seasonId = &#63;.
	*
	* @param episodeId the primary key of the current episode
	* @param groupId the group ID
	* @param seasonId the season ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode[] filterFindByG_S_PrevAndNext(
		long episodeId, long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Removes all the episodes where groupId = &#63; and seasonId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_S(long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of episodes where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the number of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_S(long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of episodes that the user has permission to view where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the number of matching episodes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_S(long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the episode where groupId = &#63; and episodeId = &#63; or throws a {@link hu.webtown.liferay.portlet.NoSuchEpisodeException} if it could not be found.
	*
	* @param groupId the group ID
	* @param episodeId the episode ID
	* @return the matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode findByG_E(long groupId,
		long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Returns the episode where groupId = &#63; and episodeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param episodeId the episode ID
	* @return the matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode fetchByG_E(long groupId,
		long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the episode where groupId = &#63; and episodeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param episodeId the episode ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode fetchByG_E(long groupId,
		long episodeId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the episode where groupId = &#63; and episodeId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param episodeId the episode ID
	* @return the episode that was removed
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode removeByG_E(long groupId,
		long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Returns the number of episodes where groupId = &#63; and episodeId = &#63;.
	*
	* @param groupId the group ID
	* @param episodeId the episode ID
	* @return the number of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_E(long groupId, long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the episode in the entity cache if it is enabled.
	*
	* @param episode the episode
	*/
	public void cacheResult(hu.webtown.liferay.portlet.model.Episode episode);

	/**
	* Caches the episodes in the entity cache if it is enabled.
	*
	* @param episodes the episodes
	*/
	public void cacheResult(
		java.util.List<hu.webtown.liferay.portlet.model.Episode> episodes);

	/**
	* Creates a new episode with the primary key. Does not add the episode to the database.
	*
	* @param episodeId the primary key for the new episode
	* @return the new episode
	*/
	public hu.webtown.liferay.portlet.model.Episode create(long episodeId);

	/**
	* Removes the episode with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param episodeId the primary key of the episode
	* @return the episode that was removed
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode remove(long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	public hu.webtown.liferay.portlet.model.Episode updateImpl(
		hu.webtown.liferay.portlet.model.Episode episode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the episode with the primary key or throws a {@link hu.webtown.liferay.portlet.NoSuchEpisodeException} if it could not be found.
	*
	* @param episodeId the primary key of the episode
	* @return the episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode findByPrimaryKey(
		long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException;

	/**
	* Returns the episode with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param episodeId the primary key of the episode
	* @return the episode, or <code>null</code> if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.portlet.model.Episode fetchByPrimaryKey(
		long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the episodes.
	*
	* @return the episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the episodes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of episodes
	* @param end the upper bound of the range of episodes (not inclusive)
	* @return the range of episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the episodes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of episodes
	* @param end the upper bound of the range of episodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.portlet.model.Episode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the episodes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of episodes.
	*
	* @return the number of episodes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}