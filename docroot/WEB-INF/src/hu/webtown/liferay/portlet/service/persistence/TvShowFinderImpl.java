package hu.webtown.liferay.portlet.service.persistence;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import hu.webtown.liferay.portlet.model.TvShow;
import hu.webtown.liferay.portlet.model.impl.TvShowImpl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TvShowFinderImpl extends BasePersistenceImpl<TvShow> implements TvShowFinder {
	
	public static final String FIND_BY_PREMIERYEAR = TvShowFinder.class.getName() + ".findByPremierYear";
	public static final String FIND_BY_G_P = TvShowFinder.class.getName() + ".findByG_P";
	
	public static final String FIND_BY_C_G_T_D_P = TvShowFinder.class.getName() + ".findByC_G_T_D_P";
	public static final String COUNT_BY_C_G_T_D_P = TvShowFinder.class.getName() + ".countByC_G_T_D_P";
	
	public static final String FIND_BY_C_G_T_D_PG_PL = TvShowFinder.class.getName() + ".findByC_G_T_D_PG_PL";
	public static final String COUNT_BY_C_G_T_D_PG_PL = TvShowFinder.class.getName() + ".countByC_G_T_D_PG_PL";

	public List<TvShow> findByPremierYear(int premierYear, int start, int end) throws SystemException{
		
		Session session = null;
		
		try{
			session = openSession();
			
			String sql = CustomSQLUtil.get(TvShowFinderImpl.FIND_BY_PREMIERYEAR);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.setCacheable(false);
			q.addEntity("TvT_TvShow", TvShowImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(premierYear);
			
			return (List<TvShow>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		
		return null;
	}
	
	public List<TvShow> findByPremierYear(int premierYear) throws SystemException{
		return findByPremierYear(premierYear, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	
	public List<TvShow> findByG_P(long groupId, int premierYear, int start, int end) throws SystemException {
		
		Session session = null;
		
		try{
			session = openSession();
			
			String sql = CustomSQLUtil.get(TvShowFinderImpl.FIND_BY_G_P);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.setCacheable(false);
			q.addEntity("TvT_TvShow", TvShowImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			qPos.add(premierYear);
			
			return (List<TvShow>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		
		return null;
	}
	
	public List<TvShow> findByG_P(long groupId, int premierYear) throws SystemException{
		return findByG_P(groupId, premierYear, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	
	
	public List<TvShow> findByC_G_T_D_PG_PL(
			long companyId,
			long groupId, 
			String tvShowTitle, 
			String tvShowDescription,
			int tvShowPremierYearGT,
			int tvShowPremierYearLT,
			boolean andOperator,
			int start, int end, 
			OrderByComparator obc) throws SystemException {
		
		Session session = null;
		
		try{
			session = openSession();
			
			String sql = CustomSQLUtil.get(TvShowFinderImpl.FIND_BY_C_G_T_D_PG_PL);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.setCacheable(false);
			q.addEntity("TvT_TvShow", TvShowImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(companyId);
			qPos.add(groupId);
			qPos.add("%" + tvShowTitle + "%");
			qPos.add("%" + tvShowDescription + "%");
			qPos.add(tvShowPremierYearGT);
			qPos.add(tvShowPremierYearLT);
			
			return (List<TvShow>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		
		return Collections.emptyList();
	}
	
	public List<TvShow> findByC_G_T_D_PG_PL(
			long companyId,
			long groupId, 
			String tvShowTitle, 
			String tvShowDescription,
			int tvShowPremierYearGT,
			int tvShowPremierYearLT,
			boolean andOperator,
			OrderByComparator obc) throws SystemException {
		
		return findByC_G_T_D_PG_PL(
				companyId, groupId, 
				tvShowTitle, tvShowDescription, 
				tvShowPremierYearGT, tvShowPremierYearLT, 
				andOperator, 
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, obc);
	}
	
	public int countByC_G_T_D_PG_PL(
			long companyId,
			long groupId, 
			String tvShowTitle, 
			String tvShowDescription,
			int tvShowPremierYearGT,
			int tvShowPremierYearLT,
			boolean andOperator,
			int start, int end) throws SystemException {
		
		Session session = null;
		
		try{
			session = openSession();
			
			String sql = CustomSQLUtil.get(TvShowFinderImpl.COUNT_BY_C_G_T_D_PG_PL);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.setCacheable(false);
			q.addScalar(TvShowFinderImpl.COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(companyId);
			qPos.add(groupId);
			qPos.add("%" + tvShowTitle + "%");
			qPos.add("%" + tvShowDescription + "%");
			qPos.add(tvShowPremierYearGT);
			qPos.add(tvShowPremierYearLT);
			
			Iterator<Long> iterator = q.iterate();
			
			if(iterator.hasNext()){
				Long count = iterator.next();
				
				if (count != null){
					return count.intValue();			
				}
			}
			
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		
		return 0;
	}
	
	public int countByC_G_T_D_PG_PL(
			long companyId,
			long groupId, 
			String tvShowTitle, 
			String tvShowDescription,
			int tvShowPremierYearGT,
			int tvShowPremierYearLT,
			boolean andOperator) throws SystemException {
		
		return countByC_G_T_D_PG_PL(
				companyId, groupId, 
				tvShowTitle, tvShowDescription, 
				tvShowPremierYearGT, tvShowPremierYearLT, 
				andOperator, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	
	public List<TvShow> findByKeyWords(
			long companyId,
			long groupId, 
			String keywords, 
			int start, int end, 
			OrderByComparator obc) throws SystemException{
			
		Session session = null;
		
		try{
			session = openSession();
			
			String sql = CustomSQLUtil.get(TvShowFinderImpl.FIND_BY_C_G_T_D_P);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.setCacheable(false);
			q.addEntity("TvT_TvShow", TvShowImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(companyId);
			qPos.add(groupId);
			qPos.add("%" + keywords + "%");
			qPos.add("%" + keywords + "%");
			qPos.add(keywords);
			
			return (List<TvShow>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		
		return Collections.emptyList();
	}
	
	public List<TvShow> findByKeyWords(
			long companyId,
			long groupId, 
			String keywords, 
			OrderByComparator obc) throws SystemException{
		
		return findByKeyWords(companyId, groupId, keywords, QueryUtil.ALL_POS, QueryUtil.ALL_POS, obc);
	}
	
	public int countByKeyWords(
			long companyId,
			long groupId, 
			String keywords, 
			int start, int end) throws SystemException{
			
		Session session = null;
		
		try{
			session = openSession();
			
			String sql = CustomSQLUtil.get(TvShowFinderImpl.COUNT_BY_C_G_T_D_P);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.setCacheable(false);
			q.addScalar(TvShowFinderImpl.COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(companyId);
			qPos.add(groupId);
			qPos.add("%" + keywords + "%");
			qPos.add("%" + keywords + "%");
			qPos.add(keywords);
			
			Iterator<Long> iterator = q.iterate();
			
			if(iterator.hasNext()){
				Long count = iterator.next();
				
				if (count != null){
					return count.intValue();			
				}
			}
			
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		
		return 0;
	}
	
	public int countByKeyWords(long companyId, long groupId, String keywords) throws SystemException {
		return countByKeyWords(companyId, groupId, keywords, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
}
