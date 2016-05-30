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

import hu.webtown.liferay.portlet.NoSuchTvShowException;
import hu.webtown.liferay.portlet.model.TvShow;
import hu.webtown.liferay.portlet.model.impl.TvShowImpl;
import hu.webtown.liferay.portlet.model.impl.TvShowModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tv show service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author czeni
 * @see TvShowPersistence
 * @see TvShowUtil
 * @generated
 */
public class TvShowPersistenceImpl extends BasePersistenceImpl<TvShow>
	implements TvShowPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TvShowUtil} to access the tv show persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TvShowImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TvShowModelImpl.ENTITY_CACHE_ENABLED,
			TvShowModelImpl.FINDER_CACHE_ENABLED, TvShowImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TvShowModelImpl.ENTITY_CACHE_ENABLED,
			TvShowModelImpl.FINDER_CACHE_ENABLED, TvShowImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TvShowModelImpl.ENTITY_CACHE_ENABLED,
			TvShowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(TvShowModelImpl.ENTITY_CACHE_ENABLED,
			TvShowModelImpl.FINDER_CACHE_ENABLED, TvShowImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(TvShowModelImpl.ENTITY_CACHE_ENABLED,
			TvShowModelImpl.FINDER_CACHE_ENABLED, TvShowImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			TvShowModelImpl.GROUPID_COLUMN_BITMASK |
			TvShowModelImpl.TVSHOWTITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(TvShowModelImpl.ENTITY_CACHE_ENABLED,
			TvShowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tv shows where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching tv shows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TvShow> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<TvShow> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

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
	@Override
	public List<TvShow> findByGroupId(long groupId, int start, int end,
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

		List<TvShow> list = (List<TvShow>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TvShow tvShow : list) {
				if ((groupId != tvShow.getGroupId())) {
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

			query.append(_SQL_SELECT_TVSHOW_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TvShowModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<TvShow>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TvShow>(list);
				}
				else {
					list = (List<TvShow>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first tv show in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tv show
	 * @throws hu.webtown.liferay.portlet.NoSuchTvShowException if a matching tv show could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTvShowException, SystemException {
		TvShow tvShow = fetchByGroupId_First(groupId, orderByComparator);

		if (tvShow != null) {
			return tvShow;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTvShowException(msg.toString());
	}

	/**
	 * Returns the first tv show in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tv show, or <code>null</code> if a matching tv show could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TvShow> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tv show in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tv show
	 * @throws hu.webtown.liferay.portlet.NoSuchTvShowException if a matching tv show could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTvShowException, SystemException {
		TvShow tvShow = fetchByGroupId_Last(groupId, orderByComparator);

		if (tvShow != null) {
			return tvShow;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTvShowException(msg.toString());
	}

	/**
	 * Returns the last tv show in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tv show, or <code>null</code> if a matching tv show could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<TvShow> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public TvShow[] findByGroupId_PrevAndNext(long tvShowId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTvShowException, SystemException {
		TvShow tvShow = findByPrimaryKey(tvShowId);

		Session session = null;

		try {
			session = openSession();

			TvShow[] array = new TvShowImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, tvShow, groupId,
					orderByComparator, true);

			array[1] = tvShow;

			array[2] = getByGroupId_PrevAndNext(session, tvShow, groupId,
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

	protected TvShow getByGroupId_PrevAndNext(Session session, TvShow tvShow,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TVSHOW_WHERE);

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
			query.append(TvShowModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tvShow);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TvShow> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tv shows where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (TvShow tvShow : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(tvShow);
		}
	}

	/**
	 * Returns the number of tv shows where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching tv shows
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

			query.append(_SQL_COUNT_TVSHOW_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "tvShow.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(TvShowModelImpl.ENTITY_CACHE_ENABLED,
			TvShowModelImpl.FINDER_CACHE_ENABLED, TvShowImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(TvShowModelImpl.ENTITY_CACHE_ENABLED,
			TvShowModelImpl.FINDER_CACHE_ENABLED, TvShowImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			TvShowModelImpl.COMPANYID_COLUMN_BITMASK |
			TvShowModelImpl.TVSHOWTITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(TvShowModelImpl.ENTITY_CACHE_ENABLED,
			TvShowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tv shows where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching tv shows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TvShow> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<TvShow> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

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
	@Override
	public List<TvShow> findByCompanyId(long companyId, int start, int end,
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

		List<TvShow> list = (List<TvShow>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TvShow tvShow : list) {
				if ((companyId != tvShow.getCompanyId())) {
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

			query.append(_SQL_SELECT_TVSHOW_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TvShowModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<TvShow>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TvShow>(list);
				}
				else {
					list = (List<TvShow>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first tv show in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tv show
	 * @throws hu.webtown.liferay.portlet.NoSuchTvShowException if a matching tv show could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTvShowException, SystemException {
		TvShow tvShow = fetchByCompanyId_First(companyId, orderByComparator);

		if (tvShow != null) {
			return tvShow;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTvShowException(msg.toString());
	}

	/**
	 * Returns the first tv show in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tv show, or <code>null</code> if a matching tv show could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TvShow> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tv show in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tv show
	 * @throws hu.webtown.liferay.portlet.NoSuchTvShowException if a matching tv show could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTvShowException, SystemException {
		TvShow tvShow = fetchByCompanyId_Last(companyId, orderByComparator);

		if (tvShow != null) {
			return tvShow;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTvShowException(msg.toString());
	}

	/**
	 * Returns the last tv show in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tv show, or <code>null</code> if a matching tv show could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<TvShow> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public TvShow[] findByCompanyId_PrevAndNext(long tvShowId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTvShowException, SystemException {
		TvShow tvShow = findByPrimaryKey(tvShowId);

		Session session = null;

		try {
			session = openSession();

			TvShow[] array = new TvShowImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, tvShow, companyId,
					orderByComparator, true);

			array[1] = tvShow;

			array[2] = getByCompanyId_PrevAndNext(session, tvShow, companyId,
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

	protected TvShow getByCompanyId_PrevAndNext(Session session, TvShow tvShow,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TVSHOW_WHERE);

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
			query.append(TvShowModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tvShow);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TvShow> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tv shows where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (TvShow tvShow : findByCompanyId(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(tvShow);
		}
	}

	/**
	 * Returns the number of tv shows where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching tv shows
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

			query.append(_SQL_COUNT_TVSHOW_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "tvShow.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_T = new FinderPath(TvShowModelImpl.ENTITY_CACHE_ENABLED,
			TvShowModelImpl.FINDER_CACHE_ENABLED, TvShowImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_T",
			new String[] { Long.class.getName(), Long.class.getName() },
			TvShowModelImpl.TVSHOWID_COLUMN_BITMASK |
			TvShowModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_T = new FinderPath(TvShowModelImpl.ENTITY_CACHE_ENABLED,
			TvShowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_T",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the tv show where tvShowId = &#63; and groupId = &#63; or throws a {@link hu.webtown.liferay.portlet.NoSuchTvShowException} if it could not be found.
	 *
	 * @param tvShowId the tv show ID
	 * @param groupId the group ID
	 * @return the matching tv show
	 * @throws hu.webtown.liferay.portlet.NoSuchTvShowException if a matching tv show could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow findByG_T(long tvShowId, long groupId)
		throws NoSuchTvShowException, SystemException {
		TvShow tvShow = fetchByG_T(tvShowId, groupId);

		if (tvShow == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tvShowId=");
			msg.append(tvShowId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTvShowException(msg.toString());
		}

		return tvShow;
	}

	/**
	 * Returns the tv show where tvShowId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tvShowId the tv show ID
	 * @param groupId the group ID
	 * @return the matching tv show, or <code>null</code> if a matching tv show could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow fetchByG_T(long tvShowId, long groupId)
		throws SystemException {
		return fetchByG_T(tvShowId, groupId, true);
	}

	/**
	 * Returns the tv show where tvShowId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tvShowId the tv show ID
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching tv show, or <code>null</code> if a matching tv show could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow fetchByG_T(long tvShowId, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { tvShowId, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_T,
					finderArgs, this);
		}

		if (result instanceof TvShow) {
			TvShow tvShow = (TvShow)result;

			if ((tvShowId != tvShow.getTvShowId()) ||
					(groupId != tvShow.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TVSHOW_WHERE);

			query.append(_FINDER_COLUMN_G_T_TVSHOWID_2);

			query.append(_FINDER_COLUMN_G_T_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tvShowId);

				qPos.add(groupId);

				List<TvShow> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_T,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TvShowPersistenceImpl.fetchByG_T(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TvShow tvShow = list.get(0);

					result = tvShow;

					cacheResult(tvShow);

					if ((tvShow.getTvShowId() != tvShowId) ||
							(tvShow.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_T,
							finderArgs, tvShow);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_T,
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
			return (TvShow)result;
		}
	}

	/**
	 * Removes the tv show where tvShowId = &#63; and groupId = &#63; from the database.
	 *
	 * @param tvShowId the tv show ID
	 * @param groupId the group ID
	 * @return the tv show that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow removeByG_T(long tvShowId, long groupId)
		throws NoSuchTvShowException, SystemException {
		TvShow tvShow = findByG_T(tvShowId, groupId);

		return remove(tvShow);
	}

	/**
	 * Returns the number of tv shows where tvShowId = &#63; and groupId = &#63;.
	 *
	 * @param tvShowId the tv show ID
	 * @param groupId the group ID
	 * @return the number of matching tv shows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_T(long tvShowId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_T;

		Object[] finderArgs = new Object[] { tvShowId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TVSHOW_WHERE);

			query.append(_FINDER_COLUMN_G_T_TVSHOWID_2);

			query.append(_FINDER_COLUMN_G_T_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tvShowId);

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

	private static final String _FINDER_COLUMN_G_T_TVSHOWID_2 = "tvShow.tvShowId = ? AND ";
	private static final String _FINDER_COLUMN_G_T_GROUPID_2 = "tvShow.groupId = ?";

	public TvShowPersistenceImpl() {
		setModelClass(TvShow.class);
	}

	/**
	 * Caches the tv show in the entity cache if it is enabled.
	 *
	 * @param tvShow the tv show
	 */
	@Override
	public void cacheResult(TvShow tvShow) {
		EntityCacheUtil.putResult(TvShowModelImpl.ENTITY_CACHE_ENABLED,
			TvShowImpl.class, tvShow.getPrimaryKey(), tvShow);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_T,
			new Object[] { tvShow.getTvShowId(), tvShow.getGroupId() }, tvShow);

		tvShow.resetOriginalValues();
	}

	/**
	 * Caches the tv shows in the entity cache if it is enabled.
	 *
	 * @param tvShows the tv shows
	 */
	@Override
	public void cacheResult(List<TvShow> tvShows) {
		for (TvShow tvShow : tvShows) {
			if (EntityCacheUtil.getResult(
						TvShowModelImpl.ENTITY_CACHE_ENABLED, TvShowImpl.class,
						tvShow.getPrimaryKey()) == null) {
				cacheResult(tvShow);
			}
			else {
				tvShow.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tv shows.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TvShowImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TvShowImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tv show.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TvShow tvShow) {
		EntityCacheUtil.removeResult(TvShowModelImpl.ENTITY_CACHE_ENABLED,
			TvShowImpl.class, tvShow.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(tvShow);
	}

	@Override
	public void clearCache(List<TvShow> tvShows) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TvShow tvShow : tvShows) {
			EntityCacheUtil.removeResult(TvShowModelImpl.ENTITY_CACHE_ENABLED,
				TvShowImpl.class, tvShow.getPrimaryKey());

			clearUniqueFindersCache(tvShow);
		}
	}

	protected void cacheUniqueFindersCache(TvShow tvShow) {
		if (tvShow.isNew()) {
			Object[] args = new Object[] {
					tvShow.getTvShowId(), tvShow.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_T, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_T, args, tvShow);
		}
		else {
			TvShowModelImpl tvShowModelImpl = (TvShowModelImpl)tvShow;

			if ((tvShowModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tvShow.getTvShowId(), tvShow.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_T, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_T, args, tvShow);
			}
		}
	}

	protected void clearUniqueFindersCache(TvShow tvShow) {
		TvShowModelImpl tvShowModelImpl = (TvShowModelImpl)tvShow;

		Object[] args = new Object[] { tvShow.getTvShowId(), tvShow.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_T, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_T, args);

		if ((tvShowModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_T.getColumnBitmask()) != 0) {
			args = new Object[] {
					tvShowModelImpl.getOriginalTvShowId(),
					tvShowModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_T, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_T, args);
		}
	}

	/**
	 * Creates a new tv show with the primary key. Does not add the tv show to the database.
	 *
	 * @param tvShowId the primary key for the new tv show
	 * @return the new tv show
	 */
	@Override
	public TvShow create(long tvShowId) {
		TvShow tvShow = new TvShowImpl();

		tvShow.setNew(true);
		tvShow.setPrimaryKey(tvShowId);

		return tvShow;
	}

	/**
	 * Removes the tv show with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tvShowId the primary key of the tv show
	 * @return the tv show that was removed
	 * @throws hu.webtown.liferay.portlet.NoSuchTvShowException if a tv show with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow remove(long tvShowId)
		throws NoSuchTvShowException, SystemException {
		return remove((Serializable)tvShowId);
	}

	/**
	 * Removes the tv show with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tv show
	 * @return the tv show that was removed
	 * @throws hu.webtown.liferay.portlet.NoSuchTvShowException if a tv show with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow remove(Serializable primaryKey)
		throws NoSuchTvShowException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TvShow tvShow = (TvShow)session.get(TvShowImpl.class, primaryKey);

			if (tvShow == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTvShowException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tvShow);
		}
		catch (NoSuchTvShowException nsee) {
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
	protected TvShow removeImpl(TvShow tvShow) throws SystemException {
		tvShow = toUnwrappedModel(tvShow);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tvShow)) {
				tvShow = (TvShow)session.get(TvShowImpl.class,
						tvShow.getPrimaryKeyObj());
			}

			if (tvShow != null) {
				session.delete(tvShow);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tvShow != null) {
			clearCache(tvShow);
		}

		return tvShow;
	}

	@Override
	public TvShow updateImpl(hu.webtown.liferay.portlet.model.TvShow tvShow)
		throws SystemException {
		tvShow = toUnwrappedModel(tvShow);

		boolean isNew = tvShow.isNew();

		TvShowModelImpl tvShowModelImpl = (TvShowModelImpl)tvShow;

		Session session = null;

		try {
			session = openSession();

			if (tvShow.isNew()) {
				session.save(tvShow);

				tvShow.setNew(false);
			}
			else {
				session.merge(tvShow);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TvShowModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tvShowModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tvShowModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { tvShowModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((tvShowModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tvShowModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { tvShowModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(TvShowModelImpl.ENTITY_CACHE_ENABLED,
			TvShowImpl.class, tvShow.getPrimaryKey(), tvShow);

		clearUniqueFindersCache(tvShow);
		cacheUniqueFindersCache(tvShow);

		return tvShow;
	}

	protected TvShow toUnwrappedModel(TvShow tvShow) {
		if (tvShow instanceof TvShowImpl) {
			return tvShow;
		}

		TvShowImpl tvShowImpl = new TvShowImpl();

		tvShowImpl.setNew(tvShow.isNew());
		tvShowImpl.setPrimaryKey(tvShow.getPrimaryKey());

		tvShowImpl.setTvShowId(tvShow.getTvShowId());
		tvShowImpl.setGroupId(tvShow.getGroupId());
		tvShowImpl.setCompanyId(tvShow.getCompanyId());
		tvShowImpl.setUserId(tvShow.getUserId());
		tvShowImpl.setUserName(tvShow.getUserName());
		tvShowImpl.setCreateDate(tvShow.getCreateDate());
		tvShowImpl.setModifiedDate(tvShow.getModifiedDate());
		tvShowImpl.setTvShowTitle(tvShow.getTvShowTitle());
		tvShowImpl.setTvShowPremierDate(tvShow.getTvShowPremierDate());
		tvShowImpl.setTvShowDescription(tvShow.getTvShowDescription());
		tvShowImpl.setTvShowImageUrl(tvShow.getTvShowImageUrl());
		tvShowImpl.setTvShowImageUuid(tvShow.getTvShowImageUuid());
		tvShowImpl.setTvShowImageTitle(tvShow.getTvShowImageTitle());
		tvShowImpl.setTvShowImageVersion(tvShow.getTvShowImageVersion());

		return tvShowImpl;
	}

	/**
	 * Returns the tv show with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tv show
	 * @return the tv show
	 * @throws hu.webtown.liferay.portlet.NoSuchTvShowException if a tv show with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTvShowException, SystemException {
		TvShow tvShow = fetchByPrimaryKey(primaryKey);

		if (tvShow == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTvShowException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tvShow;
	}

	/**
	 * Returns the tv show with the primary key or throws a {@link hu.webtown.liferay.portlet.NoSuchTvShowException} if it could not be found.
	 *
	 * @param tvShowId the primary key of the tv show
	 * @return the tv show
	 * @throws hu.webtown.liferay.portlet.NoSuchTvShowException if a tv show with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow findByPrimaryKey(long tvShowId)
		throws NoSuchTvShowException, SystemException {
		return findByPrimaryKey((Serializable)tvShowId);
	}

	/**
	 * Returns the tv show with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tv show
	 * @return the tv show, or <code>null</code> if a tv show with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TvShow tvShow = (TvShow)EntityCacheUtil.getResult(TvShowModelImpl.ENTITY_CACHE_ENABLED,
				TvShowImpl.class, primaryKey);

		if (tvShow == _nullTvShow) {
			return null;
		}

		if (tvShow == null) {
			Session session = null;

			try {
				session = openSession();

				tvShow = (TvShow)session.get(TvShowImpl.class, primaryKey);

				if (tvShow != null) {
					cacheResult(tvShow);
				}
				else {
					EntityCacheUtil.putResult(TvShowModelImpl.ENTITY_CACHE_ENABLED,
						TvShowImpl.class, primaryKey, _nullTvShow);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TvShowModelImpl.ENTITY_CACHE_ENABLED,
					TvShowImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tvShow;
	}

	/**
	 * Returns the tv show with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tvShowId the primary key of the tv show
	 * @return the tv show, or <code>null</code> if a tv show with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow fetchByPrimaryKey(long tvShowId) throws SystemException {
		return fetchByPrimaryKey((Serializable)tvShowId);
	}

	/**
	 * Returns all the tv shows.
	 *
	 * @return the tv shows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TvShow> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<TvShow> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<TvShow> findAll(int start, int end,
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

		List<TvShow> list = (List<TvShow>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TVSHOW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TVSHOW;

				if (pagination) {
					sql = sql.concat(TvShowModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TvShow>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TvShow>(list);
				}
				else {
					list = (List<TvShow>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the tv shows from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TvShow tvShow : findAll()) {
			remove(tvShow);
		}
	}

	/**
	 * Returns the number of tv shows.
	 *
	 * @return the number of tv shows
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

				Query q = session.createQuery(_SQL_COUNT_TVSHOW);

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
	 * Initializes the tv show persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.hu.webtown.liferay.portlet.model.TvShow")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TvShow>> listenersList = new ArrayList<ModelListener<TvShow>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TvShow>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TvShowImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TVSHOW = "SELECT tvShow FROM TvShow tvShow";
	private static final String _SQL_SELECT_TVSHOW_WHERE = "SELECT tvShow FROM TvShow tvShow WHERE ";
	private static final String _SQL_COUNT_TVSHOW = "SELECT COUNT(tvShow) FROM TvShow tvShow";
	private static final String _SQL_COUNT_TVSHOW_WHERE = "SELECT COUNT(tvShow) FROM TvShow tvShow WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tvShow.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TvShow exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TvShow exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TvShowPersistenceImpl.class);
	private static TvShow _nullTvShow = new TvShowImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TvShow> toCacheModel() {
				return _nullTvShowCacheModel;
			}
		};

	private static CacheModel<TvShow> _nullTvShowCacheModel = new CacheModel<TvShow>() {
			@Override
			public TvShow toEntityModel() {
				return _nullTvShow;
			}
		};
}