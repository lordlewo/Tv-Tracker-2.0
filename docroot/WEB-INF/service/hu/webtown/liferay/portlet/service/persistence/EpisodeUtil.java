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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import hu.webtown.liferay.portlet.model.Episode;

import java.util.List;

/**
 * The persistence utility for the episode service. This utility wraps {@link EpisodePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author czeni
 * @see EpisodePersistence
 * @see EpisodePersistenceImpl
 * @generated
 */
public class EpisodeUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Episode episode) {
		getPersistence().clearCache(episode);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Episode> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Episode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Episode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Episode update(Episode episode) throws SystemException {
		return getPersistence().update(episode);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Episode update(Episode episode, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(episode, serviceContext);
	}

	/**
	* Returns all the episodes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first episode in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first episode in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last episode in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last episode in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

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
	public static hu.webtown.liferay.portlet.model.Episode[] findByUuid_PrevAndNext(
		long episodeId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence()
				   .findByUuid_PrevAndNext(episodeId, uuid, orderByComparator);
	}

	/**
	* Removes all the episodes where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of episodes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the episode where uuid = &#63; and groupId = &#63; or throws a {@link hu.webtown.liferay.portlet.NoSuchEpisodeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the episode where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the episode where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the episode where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the episode that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of episodes where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the episodes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static hu.webtown.liferay.portlet.model.Episode findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first episode in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

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
	public static hu.webtown.liferay.portlet.model.Episode findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last episode in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static hu.webtown.liferay.portlet.model.Episode[] findByUuid_C_PrevAndNext(
		long episodeId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(episodeId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the episodes where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of episodes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the episodes where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first episode in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first episode in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last episode in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last episode in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

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
	public static hu.webtown.liferay.portlet.model.Episode[] findByGroupId_PrevAndNext(
		long episodeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(episodeId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the episodes that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching episodes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

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
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

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
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

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
	public static hu.webtown.liferay.portlet.model.Episode[] filterFindByGroupId_PrevAndNext(
		long episodeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(episodeId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the episodes where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of episodes where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of episodes that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching episodes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns all the episodes where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

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
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

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
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first episode in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first episode in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last episode in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last episode in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

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
	public static hu.webtown.liferay.portlet.model.Episode[] findByCompanyId_PrevAndNext(
		long episodeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(episodeId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the episodes where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of episodes where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns all the episodes where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> findByG_S(
		long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S(groupId, seasonId);
	}

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
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> findByG_S(
		long groupId, long seasonId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S(groupId, seasonId, start, end);
	}

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
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> findByG_S(
		long groupId, long seasonId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_S(groupId, seasonId, start, end, orderByComparator);
	}

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
	public static hu.webtown.liferay.portlet.model.Episode findByG_S_First(
		long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence()
				   .findByG_S_First(groupId, seasonId, orderByComparator);
	}

	/**
	* Returns the first episode in the ordered set where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode fetchByG_S_First(
		long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_S_First(groupId, seasonId, orderByComparator);
	}

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
	public static hu.webtown.liferay.portlet.model.Episode findByG_S_Last(
		long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence()
				   .findByG_S_Last(groupId, seasonId, orderByComparator);
	}

	/**
	* Returns the last episode in the ordered set where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode fetchByG_S_Last(
		long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_S_Last(groupId, seasonId, orderByComparator);
	}

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
	public static hu.webtown.liferay.portlet.model.Episode[] findByG_S_PrevAndNext(
		long episodeId, long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence()
				   .findByG_S_PrevAndNext(episodeId, groupId, seasonId,
			orderByComparator);
	}

	/**
	* Returns all the episodes that the user has permission to view where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the matching episodes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> filterFindByG_S(
		long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_S(groupId, seasonId);
	}

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
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> filterFindByG_S(
		long groupId, long seasonId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_S(groupId, seasonId, start, end);
	}

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
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> filterFindByG_S(
		long groupId, long seasonId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_S(groupId, seasonId, start, end,
			orderByComparator);
	}

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
	public static hu.webtown.liferay.portlet.model.Episode[] filterFindByG_S_PrevAndNext(
		long episodeId, long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence()
				   .filterFindByG_S_PrevAndNext(episodeId, groupId, seasonId,
			orderByComparator);
	}

	/**
	* Removes all the episodes where groupId = &#63; and seasonId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_S(long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_S(groupId, seasonId);
	}

	/**
	* Returns the number of episodes where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the number of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_S(long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_S(groupId, seasonId);
	}

	/**
	* Returns the number of episodes that the user has permission to view where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the number of matching episodes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_S(long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_S(groupId, seasonId);
	}

	/**
	* Returns the episode where groupId = &#63; and episodeId = &#63; or throws a {@link hu.webtown.liferay.portlet.NoSuchEpisodeException} if it could not be found.
	*
	* @param groupId the group ID
	* @param episodeId the episode ID
	* @return the matching episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode findByG_E(
		long groupId, long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence().findByG_E(groupId, episodeId);
	}

	/**
	* Returns the episode where groupId = &#63; and episodeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param episodeId the episode ID
	* @return the matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode fetchByG_E(
		long groupId, long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_E(groupId, episodeId);
	}

	/**
	* Returns the episode where groupId = &#63; and episodeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param episodeId the episode ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode fetchByG_E(
		long groupId, long episodeId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_E(groupId, episodeId, retrieveFromCache);
	}

	/**
	* Removes the episode where groupId = &#63; and episodeId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param episodeId the episode ID
	* @return the episode that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode removeByG_E(
		long groupId, long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence().removeByG_E(groupId, episodeId);
	}

	/**
	* Returns the number of episodes where groupId = &#63; and episodeId = &#63;.
	*
	* @param groupId the group ID
	* @param episodeId the episode ID
	* @return the number of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_E(long groupId, long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_E(groupId, episodeId);
	}

	/**
	* Caches the episode in the entity cache if it is enabled.
	*
	* @param episode the episode
	*/
	public static void cacheResult(
		hu.webtown.liferay.portlet.model.Episode episode) {
		getPersistence().cacheResult(episode);
	}

	/**
	* Caches the episodes in the entity cache if it is enabled.
	*
	* @param episodes the episodes
	*/
	public static void cacheResult(
		java.util.List<hu.webtown.liferay.portlet.model.Episode> episodes) {
		getPersistence().cacheResult(episodes);
	}

	/**
	* Creates a new episode with the primary key. Does not add the episode to the database.
	*
	* @param episodeId the primary key for the new episode
	* @return the new episode
	*/
	public static hu.webtown.liferay.portlet.model.Episode create(
		long episodeId) {
		return getPersistence().create(episodeId);
	}

	/**
	* Removes the episode with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param episodeId the primary key of the episode
	* @return the episode that was removed
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode remove(
		long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence().remove(episodeId);
	}

	public static hu.webtown.liferay.portlet.model.Episode updateImpl(
		hu.webtown.liferay.portlet.model.Episode episode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(episode);
	}

	/**
	* Returns the episode with the primary key or throws a {@link hu.webtown.liferay.portlet.NoSuchEpisodeException} if it could not be found.
	*
	* @param episodeId the primary key of the episode
	* @return the episode
	* @throws hu.webtown.liferay.portlet.NoSuchEpisodeException if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode findByPrimaryKey(
		long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchEpisodeException {
		return getPersistence().findByPrimaryKey(episodeId);
	}

	/**
	* Returns the episode with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param episodeId the primary key of the episode
	* @return the episode, or <code>null</code> if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Episode fetchByPrimaryKey(
		long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(episodeId);
	}

	/**
	* Returns all the episodes.
	*
	* @return the episodes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<hu.webtown.liferay.portlet.model.Episode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the episodes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of episodes.
	*
	* @return the number of episodes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EpisodePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EpisodePersistence)PortletBeanLocatorUtil.locate(hu.webtown.liferay.portlet.service.ClpSerializer.getServletContextName(),
					EpisodePersistence.class.getName());

			ReferenceRegistry.registerReference(EpisodeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EpisodePersistence persistence) {
	}

	private static EpisodePersistence _persistence;
}