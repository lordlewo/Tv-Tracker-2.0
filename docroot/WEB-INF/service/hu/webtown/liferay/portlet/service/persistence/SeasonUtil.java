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

import hu.webtown.liferay.portlet.model.Season;

import java.util.List;

/**
 * The persistence utility for the season service. This utility wraps {@link SeasonPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author czeni
 * @see SeasonPersistence
 * @see SeasonPersistenceImpl
 * @generated
 */
public class SeasonUtil {
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
	public static void clearCache(Season season) {
		getPersistence().clearCache(season);
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
	public static List<Season> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Season> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Season> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Season update(Season season) throws SystemException {
		return getPersistence().update(season);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Season update(Season season, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(season, serviceContext);
	}

	/**
	* Returns all the seasons where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the seasons where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of seasons
	* @param end the upper bound of the range of seasons (not inclusive)
	* @return the range of matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the seasons where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of seasons
	* @param end the upper bound of the range of seasons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first season in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first season in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching season, or <code>null</code> if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last season in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last season in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching season, or <code>null</code> if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the seasons before and after the current season in the ordered set where uuid = &#63;.
	*
	* @param seasonId the primary key of the current season
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a season with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season[] findByUuid_PrevAndNext(
		long seasonId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence()
				   .findByUuid_PrevAndNext(seasonId, uuid, orderByComparator);
	}

	/**
	* Removes all the seasons where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of seasons where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the season where uuid = &#63; and groupId = &#63; or throws a {@link hu.webtown.liferay.portlet.NoSuchSeasonException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the season where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching season, or <code>null</code> if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the season where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching season, or <code>null</code> if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the season where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the season that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of seasons where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the seasons where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the seasons where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of seasons
	* @param end the upper bound of the range of seasons (not inclusive)
	* @return the range of matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the seasons where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of seasons
	* @param end the upper bound of the range of seasons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first season in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first season in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching season, or <code>null</code> if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last season in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last season in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching season, or <code>null</code> if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the seasons before and after the current season in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param seasonId the primary key of the current season
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a season with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season[] findByUuid_C_PrevAndNext(
		long seasonId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(seasonId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the seasons where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of seasons where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the seasons where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the seasons where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of seasons
	* @param end the upper bound of the range of seasons (not inclusive)
	* @return the range of matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the seasons where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of seasons
	* @param end the upper bound of the range of seasons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first season in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first season in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching season, or <code>null</code> if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last season in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last season in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching season, or <code>null</code> if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the seasons before and after the current season in the ordered set where groupId = &#63;.
	*
	* @param seasonId the primary key of the current season
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a season with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season[] findByGroupId_PrevAndNext(
		long seasonId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(seasonId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the seasons that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching seasons that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the seasons that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of seasons
	* @param end the upper bound of the range of seasons (not inclusive)
	* @return the range of matching seasons that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the seasons that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of seasons
	* @param end the upper bound of the range of seasons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching seasons that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the seasons before and after the current season in the ordered set of seasons that the user has permission to view where groupId = &#63;.
	*
	* @param seasonId the primary key of the current season
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a season with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season[] filterFindByGroupId_PrevAndNext(
		long seasonId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(seasonId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the seasons where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of seasons where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of seasons that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching seasons that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns all the seasons where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the seasons where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of seasons
	* @param end the upper bound of the range of seasons (not inclusive)
	* @return the range of matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the seasons where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of seasons
	* @param end the upper bound of the range of seasons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first season in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first season in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching season, or <code>null</code> if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last season in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last season in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching season, or <code>null</code> if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the seasons before and after the current season in the ordered set where companyId = &#63;.
	*
	* @param seasonId the primary key of the current season
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a season with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season[] findByCompanyId_PrevAndNext(
		long seasonId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(seasonId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the seasons where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of seasons where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns all the seasons where groupId = &#63; and tvShowId = &#63;.
	*
	* @param groupId the group ID
	* @param tvShowId the tv show ID
	* @return the matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> findByG_T(
		long groupId, long tvShowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_T(groupId, tvShowId);
	}

	/**
	* Returns a range of all the seasons where groupId = &#63; and tvShowId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param tvShowId the tv show ID
	* @param start the lower bound of the range of seasons
	* @param end the upper bound of the range of seasons (not inclusive)
	* @return the range of matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> findByG_T(
		long groupId, long tvShowId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_T(groupId, tvShowId, start, end);
	}

	/**
	* Returns an ordered range of all the seasons where groupId = &#63; and tvShowId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param tvShowId the tv show ID
	* @param start the lower bound of the range of seasons
	* @param end the upper bound of the range of seasons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> findByG_T(
		long groupId, long tvShowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_T(groupId, tvShowId, start, end, orderByComparator);
	}

	/**
	* Returns the first season in the ordered set where groupId = &#63; and tvShowId = &#63;.
	*
	* @param groupId the group ID
	* @param tvShowId the tv show ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season findByG_T_First(
		long groupId, long tvShowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence()
				   .findByG_T_First(groupId, tvShowId, orderByComparator);
	}

	/**
	* Returns the first season in the ordered set where groupId = &#63; and tvShowId = &#63;.
	*
	* @param groupId the group ID
	* @param tvShowId the tv show ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching season, or <code>null</code> if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season fetchByG_T_First(
		long groupId, long tvShowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_T_First(groupId, tvShowId, orderByComparator);
	}

	/**
	* Returns the last season in the ordered set where groupId = &#63; and tvShowId = &#63;.
	*
	* @param groupId the group ID
	* @param tvShowId the tv show ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season findByG_T_Last(
		long groupId, long tvShowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence()
				   .findByG_T_Last(groupId, tvShowId, orderByComparator);
	}

	/**
	* Returns the last season in the ordered set where groupId = &#63; and tvShowId = &#63;.
	*
	* @param groupId the group ID
	* @param tvShowId the tv show ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching season, or <code>null</code> if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season fetchByG_T_Last(
		long groupId, long tvShowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_T_Last(groupId, tvShowId, orderByComparator);
	}

	/**
	* Returns the seasons before and after the current season in the ordered set where groupId = &#63; and tvShowId = &#63;.
	*
	* @param seasonId the primary key of the current season
	* @param groupId the group ID
	* @param tvShowId the tv show ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a season with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season[] findByG_T_PrevAndNext(
		long seasonId, long groupId, long tvShowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence()
				   .findByG_T_PrevAndNext(seasonId, groupId, tvShowId,
			orderByComparator);
	}

	/**
	* Returns all the seasons that the user has permission to view where groupId = &#63; and tvShowId = &#63;.
	*
	* @param groupId the group ID
	* @param tvShowId the tv show ID
	* @return the matching seasons that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> filterFindByG_T(
		long groupId, long tvShowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_T(groupId, tvShowId);
	}

	/**
	* Returns a range of all the seasons that the user has permission to view where groupId = &#63; and tvShowId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param tvShowId the tv show ID
	* @param start the lower bound of the range of seasons
	* @param end the upper bound of the range of seasons (not inclusive)
	* @return the range of matching seasons that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> filterFindByG_T(
		long groupId, long tvShowId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_T(groupId, tvShowId, start, end);
	}

	/**
	* Returns an ordered range of all the seasons that the user has permissions to view where groupId = &#63; and tvShowId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param tvShowId the tv show ID
	* @param start the lower bound of the range of seasons
	* @param end the upper bound of the range of seasons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching seasons that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> filterFindByG_T(
		long groupId, long tvShowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_T(groupId, tvShowId, start, end,
			orderByComparator);
	}

	/**
	* Returns the seasons before and after the current season in the ordered set of seasons that the user has permission to view where groupId = &#63; and tvShowId = &#63;.
	*
	* @param seasonId the primary key of the current season
	* @param groupId the group ID
	* @param tvShowId the tv show ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a season with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season[] filterFindByG_T_PrevAndNext(
		long seasonId, long groupId, long tvShowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence()
				   .filterFindByG_T_PrevAndNext(seasonId, groupId, tvShowId,
			orderByComparator);
	}

	/**
	* Removes all the seasons where groupId = &#63; and tvShowId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param tvShowId the tv show ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_T(long groupId, long tvShowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_T(groupId, tvShowId);
	}

	/**
	* Returns the number of seasons where groupId = &#63; and tvShowId = &#63;.
	*
	* @param groupId the group ID
	* @param tvShowId the tv show ID
	* @return the number of matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_T(long groupId, long tvShowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_T(groupId, tvShowId);
	}

	/**
	* Returns the number of seasons that the user has permission to view where groupId = &#63; and tvShowId = &#63;.
	*
	* @param groupId the group ID
	* @param tvShowId the tv show ID
	* @return the number of matching seasons that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_T(long groupId, long tvShowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_T(groupId, tvShowId);
	}

	/**
	* Returns the season where groupId = &#63; and seasonId = &#63; or throws a {@link hu.webtown.liferay.portlet.NoSuchSeasonException} if it could not be found.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the matching season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season findByG_S(
		long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence().findByG_S(groupId, seasonId);
	}

	/**
	* Returns the season where groupId = &#63; and seasonId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the matching season, or <code>null</code> if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season fetchByG_S(
		long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_S(groupId, seasonId);
	}

	/**
	* Returns the season where groupId = &#63; and seasonId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching season, or <code>null</code> if a matching season could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season fetchByG_S(
		long groupId, long seasonId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_S(groupId, seasonId, retrieveFromCache);
	}

	/**
	* Removes the season where groupId = &#63; and seasonId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the season that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season removeByG_S(
		long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence().removeByG_S(groupId, seasonId);
	}

	/**
	* Returns the number of seasons where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the number of matching seasons
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_S(long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_S(groupId, seasonId);
	}

	/**
	* Caches the season in the entity cache if it is enabled.
	*
	* @param season the season
	*/
	public static void cacheResult(
		hu.webtown.liferay.portlet.model.Season season) {
		getPersistence().cacheResult(season);
	}

	/**
	* Caches the seasons in the entity cache if it is enabled.
	*
	* @param seasons the seasons
	*/
	public static void cacheResult(
		java.util.List<hu.webtown.liferay.portlet.model.Season> seasons) {
		getPersistence().cacheResult(seasons);
	}

	/**
	* Creates a new season with the primary key. Does not add the season to the database.
	*
	* @param seasonId the primary key for the new season
	* @return the new season
	*/
	public static hu.webtown.liferay.portlet.model.Season create(long seasonId) {
		return getPersistence().create(seasonId);
	}

	/**
	* Removes the season with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param seasonId the primary key of the season
	* @return the season that was removed
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a season with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season remove(long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence().remove(seasonId);
	}

	public static hu.webtown.liferay.portlet.model.Season updateImpl(
		hu.webtown.liferay.portlet.model.Season season)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(season);
	}

	/**
	* Returns the season with the primary key or throws a {@link hu.webtown.liferay.portlet.NoSuchSeasonException} if it could not be found.
	*
	* @param seasonId the primary key of the season
	* @return the season
	* @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a season with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season findByPrimaryKey(
		long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.portlet.NoSuchSeasonException {
		return getPersistence().findByPrimaryKey(seasonId);
	}

	/**
	* Returns the season with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param seasonId the primary key of the season
	* @return the season, or <code>null</code> if a season with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.portlet.model.Season fetchByPrimaryKey(
		long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(seasonId);
	}

	/**
	* Returns all the seasons.
	*
	* @return the seasons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the seasons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of seasons
	* @param end the upper bound of the range of seasons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of seasons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.portlet.model.Season> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the seasons from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of seasons.
	*
	* @return the number of seasons
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SeasonPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SeasonPersistence)PortletBeanLocatorUtil.locate(hu.webtown.liferay.portlet.service.ClpSerializer.getServletContextName(),
					SeasonPersistence.class.getName());

			ReferenceRegistry.registerReference(SeasonUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SeasonPersistence persistence) {
	}

	private static SeasonPersistence _persistence;
}