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

package hu.webtown.liferay.portlet.service.impl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.expando.model.ExpandoBridge;

import hu.webtown.liferay.portlet.TvShowDescriptionException;
import hu.webtown.liferay.portlet.TvShowImageException;
import hu.webtown.liferay.portlet.TvShowPremierDateException;
import hu.webtown.liferay.portlet.TvShowTitleException;
import hu.webtown.liferay.portlet.model.Season;
import hu.webtown.liferay.portlet.model.TvShow;
import hu.webtown.liferay.portlet.service.SeasonLocalServiceUtil;
import hu.webtown.liferay.portlet.service.base.TvShowLocalServiceBaseImpl;
import hu.webtown.liferay.portlet.tvtracker.util.CustomCalendarUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

/**
 * The implementation of the tv show local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.webtown.liferay.portlet.service.TvShowLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author czeni
 * @see hu.webtown.liferay.portlet.service.base.TvShowLocalServiceBaseImpl
 * @see hu.webtown.liferay.portlet.service.TvShowLocalServiceUtil
 */
public class TvShowLocalServiceImpl extends TvShowLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link hu.webtown.liferay.portlet.service.TvShowLocalServiceUtil} to access the tv show local service.
	 */
	
	/***************************************************************************/
	/********** BLL - GET Entity ***********************************************/
	/***************************************************************************/
	
	public TvShow getTvShow(long tvShowId) throws PortalException, SystemException{
			
		// using of the finder method to retrive the requested entity instance
		
		TvShow tvShow = tvShowPersistence.findByPrimaryKey(tvShowId);
		
		
		// init calculeted props
		
		long groupId = tvShow.getGroupId();
		long userId = tvShow.getUserId();
		User user = userLocalService.fetchUserById(userId);
		Locale locale = user.getLocale();
		TimeZone timeZone = user.getTimeZone();
		
		setCalculatedProps(groupId, tvShow, locale, timeZone);
		
		
		return tvShow;
	}
	
	public TvShow getTvShow(long groupId, long tvShowId) throws PortalException, SystemException {
		
		// using of the finder method to retrive the requested entity instance
		
		TvShow tvShow = tvShowPersistence.findByG_T(tvShowId, groupId);


		// init calculeted props
		
		long userId = tvShow.getUserId();
		User user = userLocalService.fetchUserById(userId);
		Locale locale = user.getLocale();
		TimeZone timeZone = user.getTimeZone();
		
		setCalculatedProps(groupId, tvShow, locale, timeZone);
		
		
		return tvShow;
	}

	/***************************************************************************/
	/********** BLL - GET Entities *********************************************/
	/***************************************************************************/
	
	public List<TvShow> getTvShows(long groupId) throws SystemException{
		
		// using of the finder method

		List<TvShow> tvShows = tvShowPersistence.findByGroupId(groupId);
		
		
		for (TvShow tvShow : tvShows) {
			
			// init calculeted props
			
			long userId = tvShow.getUserId();
			User user = userLocalService.fetchUserById(userId);
			Locale locale = user.getLocale();
			TimeZone timeZone = user.getTimeZone();
			
			setCalculatedProps(groupId, tvShow, locale, timeZone);
		}
		
		
		return tvShows;
	}
	
	public List<TvShow> getTvShows(long groupId, int start, int end) throws SystemException {
		
		// using of the finder method
		
		List<TvShow> tvShows = tvShowPersistence.findByGroupId(groupId, start, end);
		
		
		for (TvShow tvShow : tvShows) {
			
			// init calculeted props
			
			long userId = tvShow.getUserId();
			User user = userLocalService.fetchUserById(userId);
			Locale locale = user.getLocale();
			TimeZone timeZone = user.getTimeZone();
			
			setCalculatedProps(groupId, tvShow, locale, timeZone);
		}
		
		return tvShows;
	}
	
	public List<TvShow> getTvShows(long groupId, OrderByComparator orderByComparator) throws SystemException {
		
		int start = QueryUtil.ALL_POS;
		int end = QueryUtil.ALL_POS;
		
		return getTvShows(groupId, start, end, orderByComparator);
	}
	
	public List<TvShow> getTvShows(long groupId, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		
		// using of the finder method
		
		List<TvShow> tvShows = tvShowPersistence.findByGroupId(groupId, start, end, orderByComparator);
		
		
		for (TvShow tvShow : tvShows) {
			
			// init calculeted props
			
			long userId = tvShow.getUserId();
			User user = userLocalService.fetchUserById(userId);
			Locale locale = user.getLocale();
			TimeZone timeZone = user.getTimeZone();
			
			setCalculatedProps(groupId, tvShow, locale, timeZone);
		}
		
		
		return tvShows;
	}
	
	/***************************************************************************/
	/********** BLL - Count Entities *******************************************/
	/***************************************************************************/
	
	public int getTvShowsCount(long groupId) throws SystemException {
		
		// using of the appropriate method generated by service builder
		
		return tvShowPersistence.countByGroupId(groupId);
	}
	
	/***************************************************************************/
	/********** BLL - Search Entity ********************************************/
	/***************************************************************************/
	
	public List<TvShow> search(
			long groupId, 
			String keywords, 
			int start, int end, 
			OrderByComparator obc)
	        throws SystemException { 
		
		List<TvShow> searchResult = tvShowFinder
				.findByKeyWords(groupId, keywords, start, end, obc);
		
		List<TvShow> copy = new ArrayList<>(searchResult);
		
		Collections.sort(copy, obc);
		
		for (TvShow tvShow : copy) {
			
			// init calculeted props
			
			long userId = tvShow.getUserId();
			User user = userLocalService.fetchUserById(userId);
			Locale locale = user.getLocale();
			TimeZone timeZone = user.getTimeZone();
			
			setCalculatedProps(groupId, tvShow, locale, timeZone);
		}
		
		return copy;
	}
	
	public int searchCount(
			long groupId, 
			String keywords)
	        throws SystemException { 
		
		int countResult = tvShowFinder.countByKeyWords(groupId, keywords);
		
		return countResult;
	}
	
	public List<TvShow> search(
			long companyId, long groupId, 
			String tvShowTitle, 
			String tvShowDescription,
			int tvShowPremierYearGT,
			int tvShowPremierYearLT,
			boolean andOperator,
			int start, int end, 
			OrderByComparator obc)
	        throws SystemException { 
		
		return tvShowFinder.findByC_G_T_D_PG_PL(
				groupId, 
				tvShowTitle, 
				tvShowDescription, 
				tvShowPremierYearGT, 
				tvShowPremierYearLT, 
				andOperator, 
				start, end, obc);
	}

	/***************************************************************************/
	/********** BLL - CREATE Entity ********************************************/
	/***************************************************************************/
	
	public TvShow addTvShow(
			long userId, long groupId,
			String tvShowTitle, Date tvShowPremierDate, 
			String tvShowDescription, 
			String tvShowImageUrl, String tvShowImageUuid, 
			String tvShowImageTitle, String tvShowImageVersion, 
			ServiceContext serviceContext) throws PortalException, SystemException {
		
		
		// unbox and prepare the necessary parameters
		
		long companyId = serviceContext.getCompanyId();
		String uuid = serviceContext.getUuid();
		
		User user = userPersistence.findByPrimaryKey(userId);
		String userName = user.getFullName();
		String userUuid = user.getUserUuid();
		
		Date now = new Date();
		Date createDate = serviceContext.getCreateDate(now);
		Date modifiedDate = serviceContext.getModifiedDate(now);
			
		
		// check the validity of the input parameters
		
		validate(
				tvShowTitle, 
				tvShowPremierDate, 
				tvShowDescription, 
				tvShowImageUrl, 
				tvShowImageUuid, 
				tvShowImageTitle, 
				tvShowImageVersion);
		
		
		// create new entity instance and fill up with the prepared parameters
		
		String className = TvShow.class.getName();
		
		long tvShowId = counterLocalService.increment(className);
		TvShow tvShow = tvShowPersistence.create(tvShowId);
		
		tvShow.setCompanyId(companyId);
		tvShow.setGroupId(groupId);
		tvShow.setUuid(uuid);
		tvShow.setUserId(userId);
		tvShow.setUserUuid(userUuid);
		tvShow.setUserName(userName);
		tvShow.setCreateDate(createDate);
		tvShow.setModifiedDate(modifiedDate);
		//tvShow.setExpandoBridgeAttributes(serviceContext);
		tvShow.setTvShowTitle(tvShowTitle);
		tvShow.setTvShowPremierDate(tvShowPremierDate);
		tvShow.setTvShowDescription(tvShowDescription);
		tvShow.setTvShowImageUrl(tvShowImageUrl);
		tvShow.setTvShowImageUuid(tvShowImageUuid);
		tvShow.setTvShowImageTitle(tvShowImageTitle);
		tvShow.setTvShowImageVersion(tvShowImageVersion);
		
		
		// init calculated properties, to be indexed by these props
		
		Locale locale = serviceContext.getLocale();
		TimeZone timeZone = serviceContext.getTimeZone();
		Calendar calendar = CustomCalendarUtil.getCalendar(locale, timeZone);
		
		calendar.setTime(tvShowPremierDate);
		int tvShowPremierYear = calendar.get(Calendar.YEAR);
		tvShow.setTvShowPremierYear(tvShowPremierYear);
		calendar.clear();
		
		int tvShowSeasonCount = seasonLocalService.getSeasonsCount(groupId, tvShowId);
		tvShow.setTvShowSeasonCount(tvShowSeasonCount);
		
		
		// persist the properly created instance
		
		tvShowPersistence.update(tvShow);
		
		
		// Permission/Resource 
		
		boolean addGroupPermissions = serviceContext.isAddGroupPermissions();
		boolean addGuestPermissions = serviceContext.isAddGuestPermissions();
		
        if (addGroupPermissions || addGuestPermissions) {
        	
            addTvShowResources(tvShow, addGroupPermissions, addGuestPermissions);
            
        } else {
        	
        	String[] groupPermissions = serviceContext.getGroupPermissions();
    		String[] guestPermissions = serviceContext.getGuestPermissions();
        	
            addTvShowModelResources(tvShow, groupPermissions, guestPermissions);
        }
		

		// Expando

        ExpandoBridge expandoBridge = tvShow.getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
		
        
		// Asset

        long[] assetCategoryIds = serviceContext.getAssetCategoryIds();
		String[] assetTagNames = serviceContext.getAssetTagNames();
		long[] assetLinkEntryIds = serviceContext.getAssetLinkEntryIds();
		
		updateTvShowAsset(userId, tvShow, assetCategoryIds, assetTagNames, assetLinkEntryIds);
		
		
		// Search/Index
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(TvShow.class);
		
		indexer.reindex(tvShow);
		
		
		return tvShow;
	}
	
	@SuppressWarnings("rawtypes")
	public List addTvShowWithSeason(
			long userId, long groupId, TvShow tvShow, List<Season> seasons, 
			ServiceContext serviceContextForTvShow, ServiceContext serviceContextForSeason) throws PortalException, SystemException {
		
		List<List<? extends PersistedModel>> returnedModels = new ArrayList<List<? extends PersistedModel>>();
		
		List<Season> createdSeasons = new ArrayList<Season>();
		List<TvShow> createdTvShows = new ArrayList<TvShow>();
		
		
		// tvshow
		
		String tvShowTitle = tvShow.getTvShowTitle();
		Date tvShowPremierDate = tvShow.getTvShowPremierDate();
		String tvShowDescription = tvShow.getTvShowDescription();
		
		String tvShowImageUrl = tvShow.getTvShowImageUrl();
		String tvShowImageUuid = tvShow.getTvShowImageUuid();
		String tvShowImageTitle = tvShow.getTvShowImageTitle();
		String tvShowImageVersion = tvShow.getTvShowImageVersion();
		
		TvShow createdTvShow = addTvShow(
				userId, groupId, 
				tvShowTitle, tvShowPremierDate, 
				tvShowDescription, tvShowImageUrl, 
				tvShowImageUuid, tvShowImageTitle, 
				tvShowImageVersion, serviceContextForTvShow);
		
		createdTvShows.add(createdTvShow);
		
		
		// seasons
		
		long tvShowId = createdTvShow.getTvShowId();
		
		for (int i = 0; i < seasons.size(); i++) {
			
			Season season = seasons.get(i);
			
			Date seasonPremierDate = season.getSeasonPremierDate();
			String seasonTitle = season.getSeasonTitle();
			int seasonNumber = season.getSeasonNumber();
			String seasonDescription = season.getSeasonDescription();
			
			String seasonImageUrl = season.getSeasonImageUrl();
			String seasonImageUuid = season.getSeasonImageUuid();
			String seasonImageTitle = season.getSeasonImageUrl();
			String seasonImageVersion = season.getSeasonImageVersion();
			
			Season createdSeason = seasonLocalService.addSeason(
					userId, groupId, tvShowId, seasonTitle, 
					seasonPremierDate, seasonNumber, 
					seasonDescription, seasonImageUrl, 
					seasonImageUuid, seasonImageTitle, 
					seasonImageVersion, serviceContextForSeason);
		
			createdSeasons.add(createdSeason);
		}
		
		returnedModels.add(createdTvShows);
		returnedModels.add(createdSeasons);
		
		return returnedModels;
	}
	
	/***************************************************************************/
	/********** BLL - UPDATE Entity ********************************************/
	/***************************************************************************/
	
	public TvShow updateTvShow(
			long userId, long groupId, long tvShowId,
			String tvShowTitle, Date tvShowPremierDate, 
			String tvShowDescription, 
			String tvShowImageUrl, String tvShowImageUuid, 
			String tvShowImageTitle, String tvShowImageVersion, 
			ServiceContext serviceContext) throws PortalException, SystemException {
		
		
		// unbox and prepare the necessary parameters
		
		long companyId = serviceContext.getCompanyId();
		String uuid = serviceContext.getUuid();
		
		User user = userPersistence.findByPrimaryKey(userId);
		String userName = user.getFullName();
		String userUuid = user.getUserUuid();
		
		Date now = new Date();
		Date createDate = serviceContext.getCreateDate(now);
		Date modifiedDate = serviceContext.getModifiedDate(now);
			
		
		// check the validity of the input parameters
		
		validate(
				tvShowTitle, 
				tvShowPremierDate, 
				tvShowDescription, 
				tvShowImageUrl, 
				tvShowImageUuid, 
				tvShowImageTitle, 
				tvShowImageVersion);
		
		
		// get the editable entity instance and fill up with the prepared newly parameters
		
		TvShow tvShow = getTvShow(groupId, tvShowId);
		
		tvShow.setCompanyId(companyId);
		tvShow.setGroupId(groupId);
		tvShow.setUuid(uuid);
		tvShow.setUserId(userId);
		tvShow.setUserUuid(userUuid);
		tvShow.setUserName(userName);
		tvShow.setCreateDate(createDate);
		tvShow.setModifiedDate(modifiedDate);
		//tvShow.setExpandoBridgeAttributes(serviceContext);
		tvShow.setTvShowTitle(tvShowTitle);
		tvShow.setTvShowPremierDate(tvShowPremierDate);
		tvShow.setTvShowDescription(tvShowDescription);
		tvShow.setTvShowImageUrl(tvShowImageUrl);
		tvShow.setTvShowImageUuid(tvShowImageUuid);
		tvShow.setTvShowImageTitle(tvShowImageTitle);
		tvShow.setTvShowImageVersion(tvShowImageVersion);
		
		
		// init calculated properties, to be indexed by these props
		
		Locale locale = serviceContext.getLocale();
		TimeZone timeZone = serviceContext.getTimeZone();
		Calendar calendar = CustomCalendarUtil.getCalendar(locale, timeZone);
		
		calendar.setTime(tvShowPremierDate);
		int tvShowPremierYear = calendar.get(Calendar.YEAR);
		tvShow.setTvShowPremierYear(tvShowPremierYear);
		calendar.clear();
		
		int tvShowSeasonCount = seasonLocalService.getSeasonsCount(groupId, tvShowId);
		tvShow.setTvShowSeasonCount(tvShowSeasonCount);
		
		
		// persist the updated entity instance
		
		tvShowPersistence.update(tvShow);
		
		
		// Permission/Resource 
		
		boolean addGroupPermissions = serviceContext.isAddGroupPermissions();
		boolean addGuestPermissions = serviceContext.isAddGuestPermissions();
		
        if (addGroupPermissions || addGuestPermissions) {
        	
        	String[] groupPermissions = serviceContext.getGroupPermissions();
    		String[] guestPermissions = serviceContext.getGuestPermissions();
        	
            updateTvShowResources(tvShow, groupPermissions, guestPermissions);
            
        } else {
        	
        	updateTvShowModelResources(tvShow, serviceContext);
        }
		
        
		// Expando

        ExpandoBridge expandoBridge = tvShow.getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
        
        
        // Asset
        
        long[] assetCategoryIds = serviceContext.getAssetCategoryIds();
		String[] assetTagNames = serviceContext.getAssetTagNames();
		long[] assetLinkEntryIds = serviceContext.getAssetLinkEntryIds();
		
		updateTvShowAsset(userId, tvShow, assetCategoryIds, assetTagNames, assetLinkEntryIds);
        
		
        // Search/Index
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(TvShow.class);
		
		indexer.reindex(tvShow);
		

		return tvShow;
	}
	
	@SuppressWarnings("rawtypes")
	public List updateTvShowWithSeason(
			long userId, long groupId, TvShow tvShow, List<Season> seasons, 
			ServiceContext serviceContextForTvShow, ServiceContext serviceContextForSeason) throws PortalException, SystemException {
		
		List<List<? extends PersistedModel>> returnedModels = new ArrayList<List<? extends PersistedModel>>();
		
		List<TvShow> updatedTvShows = new ArrayList<TvShow>();
		List<Season> createdSeasons = new ArrayList<Season>();
		List<Season> updatedSeasons = new ArrayList<Season>();
		List<Season> deletedSeasons = new ArrayList<Season>();
		
		
		// tvshow
		
		long tvShowId = tvShow.getTvShowId();
		String tvShowTitle = tvShow.getTvShowTitle();
		Date tvShowPremierDate = tvShow.getTvShowPremierDate();
		String tvShowDescription = tvShow.getTvShowDescription();
		
		String tvShowImageUrl = tvShow.getTvShowImageUrl();
		String tvShowImageUuid = tvShow.getTvShowImageUuid();
		String tvShowImageTitle = tvShow.getTvShowImageTitle();
		String tvShowImageVersion = tvShow.getTvShowImageVersion();
		
		TvShow updatedTvShow = updateTvShow(
				userId, groupId, tvShowId, 
				tvShowTitle, tvShowPremierDate, 
				tvShowDescription, 
				tvShowImageUrl, tvShowImageUuid, 
				tvShowImageTitle, tvShowImageVersion, 
				serviceContextForTvShow);
		
		updatedTvShows.add(updatedTvShow);
		

		// seasons
		
		List<Season> currentSeasons = SeasonLocalServiceUtil.getSeasons(groupId, tvShowId);
		
		Set<Long> createdSeasonIds = new HashSet<Long>();
		Set<Long> updatedSeasonIds = new HashSet<Long>();
		Set<Long> deletedSeasonIds = new HashSet<Long>();
		
		for (int i = 0; i < seasons.size(); i++) { 
			
			Season season = seasons.get(i);
			
			long seasonId = season.getSeasonId();
			Date seasonPremierDate = season.getSeasonPremierDate();
			String seasonTitle = season.getSeasonTitle();
			int seasonNumber = season.getSeasonNumber();
			String seasonDescription = season.getSeasonDescription();
			
			String seasonImageUrl = season.getSeasonImageUrl();
			String seasonImageUuid = season.getSeasonImageUuid();
			String seasonImageTitle = season.getSeasonImageUrl();
			String seasonImageVersion = season.getSeasonImageVersion();
			
			if(seasonId > 0) {
			
				Season updatedSeason = seasonLocalService.updateSeason(
						userId, groupId, tvShowId, seasonId, 
						seasonTitle, seasonPremierDate, 
						seasonNumber, seasonDescription, 
						seasonImageUrl, seasonImageUuid, 
						seasonImageTitle, seasonImageVersion, 
						serviceContextForSeason);
			
				updatedSeasons.add(updatedSeason);
				
				long updatedSeasonId = updatedSeason.getSeasonId();
				updatedSeasonIds.add(updatedSeasonId);
			} else {
				
				Season createdSeason = seasonLocalService.addSeason(
						userId, groupId, tvShowId, 
						seasonTitle, seasonPremierDate, 
						seasonNumber, seasonDescription, 
						seasonImageUrl, seasonImageUuid, 
						seasonImageTitle, seasonImageVersion, 
						serviceContextForSeason);
				
				createdSeasons.add(createdSeason);
				
				long createdSeasonId = createdSeason.getSeasonId();
				createdSeasonIds.add(createdSeasonId);
			}
		}
		
		for (Season curSeason : currentSeasons) {
			long curSeasonId = curSeason.getSeasonId();
			
			if(!updatedSeasonIds.contains(curSeasonId)){
				Season deletedSeason = SeasonLocalServiceUtil.deleteSeason(groupId, curSeasonId, serviceContextForSeason);
				
				deletedSeasons.add(deletedSeason);
				
				long deletedSeasonId = deletedSeason.getSeasonId();
				deletedSeasonIds.add(deletedSeasonId);
			}
		}
		
		returnedModels.add(updatedTvShows);
		returnedModels.add(updatedSeasons);
		returnedModels.add(createdSeasons);
		returnedModels.add(deletedSeasons);
		
		return returnedModels;
	}
	
	/***************************************************************************/
	/********** BLL - DELETE Entity ********************************************/
	/***************************************************************************/
	
	public TvShow deleteTvShow(long tvShowId, ServiceContext serviceContext) 
			throws PortalException, SystemException {
		
		// retrieve the deletable entity instance from the database
		
		TvShow tvShow = getTvShow(tvShowId);
		
		return deleteTvShow(tvShow, serviceContext);
	}
	
	public TvShow deleteTvShow(long groupId, long tvShowId, ServiceContext serviceContext) 
			throws PortalException, SystemException {
		
		TvShow tvShow = getTvShow(groupId, tvShowId);
		
		return deleteTvShow(tvShow);
		
	}
	
	public TvShow deleteTvShow(TvShow tvShow, ServiceContext serviceContext) 
			throws PortalException, SystemException {
		
		// unbox and prepare the necessary parameters
		
		long companyId = serviceContext.getCompanyId();
		long tvShowId = tvShow.getTvShowId();
		
		// prepare some parameters for permission/resource deleting
		
		String className = TvShow.class.getName();
		
		
		// Permission/Resource 
		
		resourceLocalService.deleteResource(companyId, className, ResourceConstants.SCOPE_INDIVIDUAL, tvShowId);
		
		
		// Expando

        expandoValueLocalService.deleteValues(className, tvShowId);

		
		// Asset
        
        AssetEntry assetEntry = assetEntryLocalService.getEntry(className, tvShowId);
        
        long entryId = assetEntry.getEntryId();
        
        assetLinkLocalService.deleteLinks(entryId);
        
		assetEntryLocalService.deleteEntry(className, tvShowId);
		
		
		// Search/Index
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(TvShow.class);
		
		indexer.delete(tvShow);
		
		
		// delete the entity instance
		
		tvShowPersistence.remove(tvShow);
		
		
		return tvShow;
	}
	
	@SuppressWarnings("rawtypes")
	public List deleteTvShowWithSeason(long groupId, long tvShowId, ServiceContext serviceContext) 
			throws PortalException, SystemException { 
		
		List<List<? extends PersistedModel>> returnedModels = new ArrayList<List<? extends PersistedModel>>();
		
		List<TvShow> deletedTvShows = new ArrayList<TvShow>();
		List<Season> deletedSeasons = new ArrayList<Season>();
		
		List<Season> seasons = getSeasonLocalService().getSeasons(groupId, tvShowId);
		
		for (int i = 0; i < seasons.size(); i++) {
			
			Season season = seasons.get(i);
			long seasonId = season.getSeasonId(); 
			
			Season deletedSeason = getSeasonLocalService().deleteSeason(groupId, seasonId, serviceContext);
			
			deletedSeasons.add(deletedSeason);
		}
		
		TvShow deletedTvShow = deleteTvShow(groupId, tvShowId, serviceContext);
		deletedTvShows.add(deletedTvShow);
		
		returnedModels.add(deletedTvShows);
		returnedModels.add(deletedSeasons);
		
		return returnedModels;
	}
	
	/***************************************************************************/
	/********** Resource adding ************************************************/
	/***************************************************************************/
	
    public void addTvShowResources(TvShow tvShow, boolean addGroupPermissions, boolean addGuestPermissions) 
    		throws PortalException, SystemException {

    	long companyId = tvShow.getCompanyId();
    	long groupId = tvShow.getGroupId();
    	long userId = tvShow.getUserId();
    	
    	String className = TvShow.class.getName();
    	
    	long tvShowId = tvShow.getTvShowId();
    	
    	boolean portletActions = false;
    	
        resourceLocalService.addResources(
            companyId, groupId, userId, className, 
            tvShowId, portletActions, 
            addGroupPermissions, addGuestPermissions);
    }

    public void addTvShowModelResources(TvShow tvShow, String[] groupPermissions, String[] guestPermissions) 
    		throws PortalException, SystemException {

    	long companyId = tvShow.getCompanyId();
    	long groupId = tvShow.getGroupId();
    	long userId = tvShow.getUserId();
    	
    	String className = TvShow.class.getName();
    	
    	long tvShowId = tvShow.getTvShowId();
    	
        resourceLocalService.addModelResources(
            companyId, groupId, userId, className,
            tvShowId, groupPermissions, guestPermissions);
    }
   
    /***************************************************************************/
	/********** Resource updating **********************************************/
	/***************************************************************************/
	
    public void updateTvShowResources(TvShow tvShow, String[] groupPermissions, String[] guestPermissions) 
    		throws PortalException, SystemException {

    	long companyId = tvShow.getCompanyId();
    	long groupId = tvShow.getGroupId();
    	
    	String className = TvShow.class.getName();
    	
    	long tvShowId = tvShow.getTvShowId();
    	
        resourceLocalService.updateResources(companyId, groupId, className, tvShowId, groupPermissions, guestPermissions);
    }

    public void updateTvShowModelResources(TvShow tvShow, ServiceContext serviceContext) 
    		throws PortalException, SystemException {
    	
        resourceLocalService.updateModelResources(tvShow, serviceContext);
    }
    
    /***************************************************************************/
	/********** Asset updating *************************************************/
	/***************************************************************************/

    public void updateTvShowAsset(long userId, TvShow tvShow, long[] assetCategoryIds, String[] assetTagNames, long[] assetLinkEntryIds) 
    		throws PortalException, SystemException {
    	
    	long groupId = tvShow.getGroupId();
    	Date createDate = tvShow.getCreateDate();
    	Date modifiedDate = tvShow.getModifiedDate();
    	String className = TvShow.class.getName();
    	long tvShowId = tvShow.getTvShowId();
    	String uuid = tvShow.getUuid();
    	
    	long classTypeId = 0;
		boolean visible = true;
		Date startDate = null; 
		Date endDate = null;
		Date expirationDate = null;
		String mimeType = ContentTypes.TEXT_HTML;
		String assetTitle = tvShow.getTvShowTitle(); 
		String assetDescription = null; 
		String assetSummary = null; 
		String assetUrl = null; 
		String assetLayoutUuId = null;
		int height = 0;
		int width = 0;
		Integer priority = null;
		boolean sync = false;
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(
				userId, groupId, createDate, modifiedDate, 
				className, tvShowId, uuid, classTypeId, 
				assetCategoryIds, assetTagNames, visible, 
				startDate, endDate, expirationDate, mimeType, 
				assetTitle, assetDescription, 
				assetSummary, assetUrl, assetLayoutUuId, 
				height, width, priority, sync);

		long entryId = assetEntry.getEntryId();
		int typeId = AssetLinkConstants.TYPE_RELATED;
		
		assetLinkLocalService.updateLinks(userId, entryId, assetLinkEntryIds, typeId);
    }
    
    /***************************************************************************/
	/********** Calculated props ***********************************************/
	/***************************************************************************/
    
    protected void setCalculatedProps(long groupId, TvShow tvShow, Locale locale, TimeZone timeZone) throws SystemException{
		
		long tvShowId = tvShow.getTvShowId();
		Calendar calendar = CustomCalendarUtil.getCalendar(locale, timeZone);
		Date tvShowPremierDate = tvShow.getTvShowPremierDate();
		calendar.setTime(tvShowPremierDate);
		
		int tvShowPremierYear = calendar.get(Calendar.YEAR);
		int tvShowSeasonCount = seasonLocalService.getSeasonsCount(groupId, tvShowId);
		
		tvShow.setTvShowSeasonCount(tvShowSeasonCount);
		tvShow.setTvShowPremierYear(tvShowPremierYear);
		
		calendar.clear();
	}
    
	/***************************************************************************/
	/********** Validation *****************************************************/
	/***************************************************************************/
	
	private void validate(
			String tvShowTitle, 
			Date tvShowPremierDate, 
			String tvShowDescription, 
			String tvShowImageUrl, 
			String tvShowImageUuid, 
			String tvShowImageTitle, 
			String tvShowImageVersion) throws PortalException{
		
		// checking if the paramaters are acceptable
		
		if(Validator.isNull(tvShowTitle)){
			
			throw new TvShowTitleException("The tvshow's title is mandatory!");
		}
		
		if(Validator.isNull(tvShowPremierDate)){
			
			throw new TvShowPremierDateException("The tvshow's premier date is mandatory!");
		}
		
		if(Validator.isNull(tvShowDescription)){
			
			throw new TvShowDescriptionException("The tvshow's description is mandatory!");
		}
		
		if(tvShowImageUrl == null || tvShowImageUuid == null || tvShowImageTitle == null || tvShowImageVersion == null){
			
			throw new TvShowImageException("The tvshow's image musn't be null!");
		}
	}
}