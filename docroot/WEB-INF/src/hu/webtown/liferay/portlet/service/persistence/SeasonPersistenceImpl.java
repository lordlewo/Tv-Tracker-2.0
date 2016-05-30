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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import hu.webtown.liferay.portlet.NoSuchSeasonException;
import hu.webtown.liferay.portlet.model.Season;
import hu.webtown.liferay.portlet.model.impl.SeasonImpl;
import hu.webtown.liferay.portlet.model.impl.SeasonModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the season service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author czeni
 * @see SeasonPersistence
 * @see SeasonUtil
 * @generated
 */
public class SeasonPersistenceImpl extends BasePersistenceImpl<Season>
	implements SeasonPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SeasonUtil} to access the season persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SeasonImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, SeasonImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, SeasonImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, SeasonImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, SeasonImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			SeasonModelImpl.GROUPID_COLUMN_BITMASK |
			SeasonModelImpl.SEASONNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the seasons where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching seasons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Season> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Season> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Season> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Season> list = (List<Season>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Season season : list) {
				if ((groupId != season.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SEASON_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SeasonModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Season>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Season>(list);
				}
				else {
					list = (List<Season>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Season findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSeasonException, SystemException {
		Season season = fetchByGroupId_First(groupId, orderByComparator);

		if (season != null) {
			return season;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSeasonException(msg.toString());
	}

	/**
	 * Returns the first season in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching season, or <code>null</code> if a matching season could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Season> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Season findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSeasonException, SystemException {
		Season season = fetchByGroupId_Last(groupId, orderByComparator);

		if (season != null) {
			return season;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSeasonException(msg.toString());
	}

	/**
	 * Returns the last season in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching season, or <code>null</code> if a matching season could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Season> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Season[] findByGroupId_PrevAndNext(long seasonId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSeasonException, SystemException {
		Season season = findByPrimaryKey(seasonId);

		Session session = null;

		try {
			session = openSession();

			Season[] array = new SeasonImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, season, groupId,
					orderByComparator, true);

			array[1] = season;

			array[2] = getByGroupId_PrevAndNext(session, season, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Season getByGroupId_PrevAndNext(Session session, Season season,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEASON_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SeasonModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(season);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Season> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the seasons where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Season season : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(season);
		}
	}

	/**
	 * Returns the number of seasons where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching seasons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEASON_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "season.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, SeasonImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, SeasonImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			SeasonModelImpl.COMPANYID_COLUMN_BITMASK |
			SeasonModelImpl.SEASONNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the seasons where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching seasons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Season> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Season> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
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
	@Override
	public List<Season> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<Season> list = (List<Season>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Season season : list) {
				if ((companyId != season.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SEASON_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SeasonModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Season>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Season>(list);
				}
				else {
					list = (List<Season>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Season findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSeasonException, SystemException {
		Season season = fetchByCompanyId_First(companyId, orderByComparator);

		if (season != null) {
			return season;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSeasonException(msg.toString());
	}

	/**
	 * Returns the first season in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching season, or <code>null</code> if a matching season could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Season> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Season findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSeasonException, SystemException {
		Season season = fetchByCompanyId_Last(companyId, orderByComparator);

		if (season != null) {
			return season;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSeasonException(msg.toString());
	}

	/**
	 * Returns the last season in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching season, or <code>null</code> if a matching season could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<Season> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Season[] findByCompanyId_PrevAndNext(long seasonId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSeasonException, SystemException {
		Season season = findByPrimaryKey(seasonId);

		Session session = null;

		try {
			session = openSession();

			Season[] array = new SeasonImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, season, companyId,
					orderByComparator, true);

			array[1] = season;

			array[2] = getByCompanyId_PrevAndNext(session, season, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Season getByCompanyId_PrevAndNext(Session session, Season season,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEASON_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SeasonModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(season);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Season> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the seasons where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Season season : findByCompanyId(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(season);
		}
	}

	/**
	 * Returns the number of seasons where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching seasons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyId(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEASON_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "season.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_T = new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, SeasonImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T = new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, SeasonImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_T",
			new String[] { Long.class.getName(), Long.class.getName() },
			SeasonModelImpl.GROUPID_COLUMN_BITMASK |
			SeasonModelImpl.TVSHOWID_COLUMN_BITMASK |
			SeasonModelImpl.SEASONNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_T = new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_T",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the seasons where groupId = &#63; and tvShowId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tvShowId the tv show ID
	 * @return the matching seasons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Season> findByG_T(long groupId, long tvShowId)
		throws SystemException {
		return findByG_T(groupId, tvShowId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Season> findByG_T(long groupId, long tvShowId, int start,
		int end) throws SystemException {
		return findByG_T(groupId, tvShowId, start, end, null);
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
	@Override
	public List<Season> findByG_T(long groupId, long tvShowId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T;
			finderArgs = new Object[] { groupId, tvShowId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_T;
			finderArgs = new Object[] {
					groupId, tvShowId,
					
					start, end, orderByComparator
				};
		}

		List<Season> list = (List<Season>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Season season : list) {
				if ((groupId != season.getGroupId()) ||
						(tvShowId != season.getTvShowId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SEASON_WHERE);

			query.append(_FINDER_COLUMN_G_T_GROUPID_2);

			query.append(_FINDER_COLUMN_G_T_TVSHOWID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SeasonModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(tvShowId);

				if (!pagination) {
					list = (List<Season>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Season>(list);
				}
				else {
					list = (List<Season>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Season findByG_T_First(long groupId, long tvShowId,
		OrderByComparator orderByComparator)
		throws NoSuchSeasonException, SystemException {
		Season season = fetchByG_T_First(groupId, tvShowId, orderByComparator);

		if (season != null) {
			return season;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", tvShowId=");
		msg.append(tvShowId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSeasonException(msg.toString());
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
	@Override
	public Season fetchByG_T_First(long groupId, long tvShowId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Season> list = findByG_T(groupId, tvShowId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Season findByG_T_Last(long groupId, long tvShowId,
		OrderByComparator orderByComparator)
		throws NoSuchSeasonException, SystemException {
		Season season = fetchByG_T_Last(groupId, tvShowId, orderByComparator);

		if (season != null) {
			return season;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", tvShowId=");
		msg.append(tvShowId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSeasonException(msg.toString());
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
	@Override
	public Season fetchByG_T_Last(long groupId, long tvShowId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_T(groupId, tvShowId);

		if (count == 0) {
			return null;
		}

		List<Season> list = findByG_T(groupId, tvShowId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Season[] findByG_T_PrevAndNext(long seasonId, long groupId,
		long tvShowId, OrderByComparator orderByComparator)
		throws NoSuchSeasonException, SystemException {
		Season season = findByPrimaryKey(seasonId);

		Session session = null;

		try {
			session = openSession();

			Season[] array = new SeasonImpl[3];

			array[0] = getByG_T_PrevAndNext(session, season, groupId, tvShowId,
					orderByComparator, true);

			array[1] = season;

			array[2] = getByG_T_PrevAndNext(session, season, groupId, tvShowId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Season getByG_T_PrevAndNext(Session session, Season season,
		long groupId, long tvShowId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEASON_WHERE);

		query.append(_FINDER_COLUMN_G_T_GROUPID_2);

		query.append(_FINDER_COLUMN_G_T_TVSHOWID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SeasonModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(tvShowId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(season);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Season> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the seasons where groupId = &#63; and tvShowId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param tvShowId the tv show ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_T(long groupId, long tvShowId)
		throws SystemException {
		for (Season season : findByG_T(groupId, tvShowId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(season);
		}
	}

	/**
	 * Returns the number of seasons where groupId = &#63; and tvShowId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tvShowId the tv show ID
	 * @return the number of matching seasons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_T(long groupId, long tvShowId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_T;

		Object[] finderArgs = new Object[] { groupId, tvShowId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SEASON_WHERE);

			query.append(_FINDER_COLUMN_G_T_GROUPID_2);

			query.append(_FINDER_COLUMN_G_T_TVSHOWID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(tvShowId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_T_GROUPID_2 = "season.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_T_TVSHOWID_2 = "season.tvShowId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_S = new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, SeasonImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_S",
			new String[] { Long.class.getName(), Long.class.getName() },
			SeasonModelImpl.GROUPID_COLUMN_BITMASK |
			SeasonModelImpl.SEASONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_S = new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the season where groupId = &#63; and seasonId = &#63; or throws a {@link hu.webtown.liferay.portlet.NoSuchSeasonException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @return the matching season
	 * @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a matching season could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season findByG_S(long groupId, long seasonId)
		throws NoSuchSeasonException, SystemException {
		Season season = fetchByG_S(groupId, seasonId);

		if (season == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", seasonId=");
			msg.append(seasonId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSeasonException(msg.toString());
		}

		return season;
	}

	/**
	 * Returns the season where groupId = &#63; and seasonId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @return the matching season, or <code>null</code> if a matching season could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season fetchByG_S(long groupId, long seasonId)
		throws SystemException {
		return fetchByG_S(groupId, seasonId, true);
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
	@Override
	public Season fetchByG_S(long groupId, long seasonId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, seasonId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_S,
					finderArgs, this);
		}

		if (result instanceof Season) {
			Season season = (Season)result;

			if ((groupId != season.getGroupId()) ||
					(seasonId != season.getSeasonId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SEASON_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_SEASONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(seasonId);

				List<Season> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_S,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SeasonPersistenceImpl.fetchByG_S(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Season season = list.get(0);

					result = season;

					cacheResult(season);

					if ((season.getGroupId() != groupId) ||
							(season.getSeasonId() != seasonId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_S,
							finderArgs, season);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_S,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Season)result;
		}
	}

	/**
	 * Removes the season where groupId = &#63; and seasonId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @return the season that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season removeByG_S(long groupId, long seasonId)
		throws NoSuchSeasonException, SystemException {
		Season season = findByG_S(groupId, seasonId);

		return remove(season);
	}

	/**
	 * Returns the number of seasons where groupId = &#63; and seasonId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @return the number of matching seasons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_S(long groupId, long seasonId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_S;

		Object[] finderArgs = new Object[] { groupId, seasonId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SEASON_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_SEASONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(seasonId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 = "season.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_S_SEASONID_2 = "season.seasonId = ?";

	public SeasonPersistenceImpl() {
		setModelClass(Season.class);
	}

	/**
	 * Caches the season in the entity cache if it is enabled.
	 *
	 * @param season the season
	 */
	@Override
	public void cacheResult(Season season) {
		EntityCacheUtil.putResult(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonImpl.class, season.getPrimaryKey(), season);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_S,
			new Object[] { season.getGroupId(), season.getSeasonId() }, season);

		season.resetOriginalValues();
	}

	/**
	 * Caches the seasons in the entity cache if it is enabled.
	 *
	 * @param seasons the seasons
	 */
	@Override
	public void cacheResult(List<Season> seasons) {
		for (Season season : seasons) {
			if (EntityCacheUtil.getResult(
						SeasonModelImpl.ENTITY_CACHE_ENABLED, SeasonImpl.class,
						season.getPrimaryKey()) == null) {
				cacheResult(season);
			}
			else {
				season.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all seasons.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SeasonImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SeasonImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the season.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Season season) {
		EntityCacheUtil.removeResult(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonImpl.class, season.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(season);
	}

	@Override
	public void clearCache(List<Season> seasons) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Season season : seasons) {
			EntityCacheUtil.removeResult(SeasonModelImpl.ENTITY_CACHE_ENABLED,
				SeasonImpl.class, season.getPrimaryKey());

			clearUniqueFindersCache(season);
		}
	}

	protected void cacheUniqueFindersCache(Season season) {
		if (season.isNew()) {
			Object[] args = new Object[] {
					season.getGroupId(), season.getSeasonId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_S, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_S, args, season);
		}
		else {
			SeasonModelImpl seasonModelImpl = (SeasonModelImpl)season;

			if ((seasonModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						season.getGroupId(), season.getSeasonId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_S, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_S, args, season);
			}
		}
	}

	protected void clearUniqueFindersCache(Season season) {
		SeasonModelImpl seasonModelImpl = (SeasonModelImpl)season;

		Object[] args = new Object[] { season.getGroupId(), season.getSeasonId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_S, args);

		if ((seasonModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_S.getColumnBitmask()) != 0) {
			args = new Object[] {
					seasonModelImpl.getOriginalGroupId(),
					seasonModelImpl.getOriginalSeasonId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_S, args);
		}
	}

	/**
	 * Creates a new season with the primary key. Does not add the season to the database.
	 *
	 * @param seasonId the primary key for the new season
	 * @return the new season
	 */
	@Override
	public Season create(long seasonId) {
		Season season = new SeasonImpl();

		season.setNew(true);
		season.setPrimaryKey(seasonId);

		return season;
	}

	/**
	 * Removes the season with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param seasonId the primary key of the season
	 * @return the season that was removed
	 * @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a season with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season remove(long seasonId)
		throws NoSuchSeasonException, SystemException {
		return remove((Serializable)seasonId);
	}

	/**
	 * Removes the season with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the season
	 * @return the season that was removed
	 * @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a season with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season remove(Serializable primaryKey)
		throws NoSuchSeasonException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Season season = (Season)session.get(SeasonImpl.class, primaryKey);

			if (season == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSeasonException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(season);
		}
		catch (NoSuchSeasonException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Season removeImpl(Season season) throws SystemException {
		season = toUnwrappedModel(season);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(season)) {
				season = (Season)session.get(SeasonImpl.class,
						season.getPrimaryKeyObj());
			}

			if (season != null) {
				session.delete(season);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (season != null) {
			clearCache(season);
		}

		return season;
	}

	@Override
	public Season updateImpl(hu.webtown.liferay.portlet.model.Season season)
		throws SystemException {
		season = toUnwrappedModel(season);

		boolean isNew = season.isNew();

		SeasonModelImpl seasonModelImpl = (SeasonModelImpl)season;

		Session session = null;

		try {
			session = openSession();

			if (season.isNew()) {
				session.save(season);

				season.setNew(false);
			}
			else {
				session.merge(season);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SeasonModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((seasonModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						seasonModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { seasonModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((seasonModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						seasonModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { seasonModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((seasonModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						seasonModelImpl.getOriginalGroupId(),
						seasonModelImpl.getOriginalTvShowId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T,
					args);

				args = new Object[] {
						seasonModelImpl.getGroupId(),
						seasonModelImpl.getTvShowId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T,
					args);
			}
		}

		EntityCacheUtil.putResult(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonImpl.class, season.getPrimaryKey(), season);

		clearUniqueFindersCache(season);
		cacheUniqueFindersCache(season);

		return season;
	}

	protected Season toUnwrappedModel(Season season) {
		if (season instanceof SeasonImpl) {
			return season;
		}

		SeasonImpl seasonImpl = new SeasonImpl();

		seasonImpl.setNew(season.isNew());
		seasonImpl.setPrimaryKey(season.getPrimaryKey());

		seasonImpl.setSeasonId(season.getSeasonId());
		seasonImpl.setGroupId(season.getGroupId());
		seasonImpl.setCompanyId(season.getCompanyId());
		seasonImpl.setUserId(season.getUserId());
		seasonImpl.setUserName(season.getUserName());
		seasonImpl.setCreateDate(season.getCreateDate());
		seasonImpl.setModifiedDate(season.getModifiedDate());
		seasonImpl.setSeasonTitle(season.getSeasonTitle());
		seasonImpl.setSeasonPremierDate(season.getSeasonPremierDate());
		seasonImpl.setSeasonNumber(season.getSeasonNumber());
		seasonImpl.setSeasonDescription(season.getSeasonDescription());
		seasonImpl.setSeasonImageUrl(season.getSeasonImageUrl());
		seasonImpl.setSeasonImageUuid(season.getSeasonImageUuid());
		seasonImpl.setSeasonImageTitle(season.getSeasonImageTitle());
		seasonImpl.setSesonImageVersion(season.getSesonImageVersion());
		seasonImpl.setTvShowId(season.getTvShowId());

		return seasonImpl;
	}

	/**
	 * Returns the season with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the season
	 * @return the season
	 * @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a season with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSeasonException, SystemException {
		Season season = fetchByPrimaryKey(primaryKey);

		if (season == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSeasonException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return season;
	}

	/**
	 * Returns the season with the primary key or throws a {@link hu.webtown.liferay.portlet.NoSuchSeasonException} if it could not be found.
	 *
	 * @param seasonId the primary key of the season
	 * @return the season
	 * @throws hu.webtown.liferay.portlet.NoSuchSeasonException if a season with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season findByPrimaryKey(long seasonId)
		throws NoSuchSeasonException, SystemException {
		return findByPrimaryKey((Serializable)seasonId);
	}

	/**
	 * Returns the season with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the season
	 * @return the season, or <code>null</code> if a season with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Season season = (Season)EntityCacheUtil.getResult(SeasonModelImpl.ENTITY_CACHE_ENABLED,
				SeasonImpl.class, primaryKey);

		if (season == _nullSeason) {
			return null;
		}

		if (season == null) {
			Session session = null;

			try {
				session = openSession();

				season = (Season)session.get(SeasonImpl.class, primaryKey);

				if (season != null) {
					cacheResult(season);
				}
				else {
					EntityCacheUtil.putResult(SeasonModelImpl.ENTITY_CACHE_ENABLED,
						SeasonImpl.class, primaryKey, _nullSeason);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SeasonModelImpl.ENTITY_CACHE_ENABLED,
					SeasonImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return season;
	}

	/**
	 * Returns the season with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param seasonId the primary key of the season
	 * @return the season, or <code>null</code> if a season with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season fetchByPrimaryKey(long seasonId) throws SystemException {
		return fetchByPrimaryKey((Serializable)seasonId);
	}

	/**
	 * Returns all the seasons.
	 *
	 * @return the seasons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Season> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Season> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Season> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Season> list = (List<Season>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SEASON);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEASON;

				if (pagination) {
					sql = sql.concat(SeasonModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Season>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Season>(list);
				}
				else {
					list = (List<Season>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the seasons from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Season season : findAll()) {
			remove(season);
		}
	}

	/**
	 * Returns the number of seasons.
	 *
	 * @return the number of seasons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SEASON);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the season persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.hu.webtown.liferay.portlet.model.Season")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Season>> listenersList = new ArrayList<ModelListener<Season>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Season>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SeasonImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SEASON = "SELECT season FROM Season season";
	private static final String _SQL_SELECT_SEASON_WHERE = "SELECT season FROM Season season WHERE ";
	private static final String _SQL_COUNT_SEASON = "SELECT COUNT(season) FROM Season season";
	private static final String _SQL_COUNT_SEASON_WHERE = "SELECT COUNT(season) FROM Season season WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "season.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Season exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Season exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SeasonPersistenceImpl.class);
	private static Season _nullSeason = new SeasonImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Season> toCacheModel() {
				return _nullSeasonCacheModel;
			}
		};

	private static CacheModel<Season> _nullSeasonCacheModel = new CacheModel<Season>() {
			@Override
			public Season toEntityModel() {
				return _nullSeason;
			}
		};
}