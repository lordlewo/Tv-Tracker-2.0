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
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.expando.model.ExpandoBridge;

import hu.webtown.liferay.portlet.SeasonDescriptionException;
import hu.webtown.liferay.portlet.SeasonImageException;
import hu.webtown.liferay.portlet.SeasonNumberException;
import hu.webtown.liferay.portlet.SeasonPremierDateException;
import hu.webtown.liferay.portlet.SeasonTitleException;
import hu.webtown.liferay.portlet.model.Season;
import hu.webtown.liferay.portlet.service.base.SeasonLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the season local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.webtown.liferay.portlet.service.SeasonLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author czeni
 * @see hu.webtown.liferay.portlet.service.base.SeasonLocalServiceBaseImpl
 * @see hu.webtown.liferay.portlet.service.SeasonLocalServiceUtil
 */
public class SeasonLocalServiceImpl extends SeasonLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link hu.webtown.liferay.portlet.service.SeasonLocalServiceUtil} to access the season local service.
	 */
	
	/***************************************************************************/
	/********** BLL - GET Entity ***********************************************/
	/***************************************************************************/
	
	public Season getSeason(long seasonId) throws PortalException, SystemException{
		
		// using of the finder method to retrive the requested entity instance
		
		Season season = seasonPersistence.findByPrimaryKey(seasonId);

		return season;
	}
	
	public Season getSeason(long groupId, long seasonId) throws PortalException, SystemException{
		
		// using of the finder method to retrive the requested entity instance
		
		Season season = seasonPersistence.findByG_S(groupId, seasonId);

		return season;
	}

	/***************************************************************************/
	/********** BLL - GET Entities *********************************************/
	/***************************************************************************/
	
	public List<Season> getSeasons(long groupId) throws SystemException{
		
		// using of the finder method

		return seasonPersistence.findByGroupId(groupId);
	}
	
	public List<Season> getSeasons(long groupId, long tvShowId) throws SystemException{
		
		// using of the finder method
		
		return seasonPersistence.findByG_T(groupId, tvShowId);
	}
	
	public List<Season> getSeasons(long groupId, int start, int end) throws SystemException {
		
		// using of the finder method
		
		return seasonPersistence.findByGroupId(groupId, start, end);
	}
	
	public List<Season> getSeasons(long groupId, long tvShowId, int start, int end) throws SystemException {
		
		// using of the finder method
		
		return seasonPersistence.findByG_T(groupId, tvShowId, start, end);
	}
	
	public List<Season> getSeasons(long groupId, OrderByComparator orderByComparator) throws SystemException {
		
		int start = QueryUtil.ALL_POS;
		int end = QueryUtil.ALL_POS;
		
		return getSeasons(groupId, start, end, orderByComparator);
	}
	
	public List<Season> getSeasons(long groupId, long tvShowId, OrderByComparator orderByComparator) throws SystemException {
		
		int start = QueryUtil.ALL_POS;
		int end = QueryUtil.ALL_POS;
		
		return getSeasons(groupId, tvShowId, start, end, orderByComparator);
	}
	
	public List<Season> getSeasons(long groupId, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		
		// using of the finder method
		
		return seasonPersistence.findByGroupId(groupId, start, end, orderByComparator);
	}
	
	public List<Season> getSeasons(long groupId, long tvShowId, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		
		// using of the finder method
		
		return seasonPersistence.findByG_T(groupId, tvShowId, start, end, orderByComparator);
	}
	
	/***************************************************************************/
	/********** BLL - Count Entities *******************************************/
	/***************************************************************************/
	
	public int getSeasonsCount(long groupId) throws SystemException {
		
		// using of the appropriate method generated by service builder
		
		return seasonPersistence.countByGroupId(groupId);
	}
	
	public int getSeasonsCount(long groupId, long tvShowId) throws SystemException {
		
		// using of the appropriate method generated by service builder
		
		return seasonPersistence.countByG_T(groupId, tvShowId);
	}
	
	/***************************************************************************/
	/********** BLL - CREATE Entity ********************************************/
	/***************************************************************************/
	
	public Season addSeason(
			long userId, long groupId, long tvShowId, 
			String seasonTitle, Date seasonPremierDate, 
			int seasonNumber, String seasonDescription, 
			String seasonImageUrl, String seasonImageUuid, 
			String seasonImageTitle, String seasonImageVersion, 
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
				seasonTitle, 
				seasonPremierDate, 
				seasonNumber, 
				seasonDescription, 
				seasonImageUrl, 
				seasonImageUuid, 
				seasonImageTitle, 
				seasonImageVersion);
		
		
		// create new entity instance and fill up with the prepared parameters
		
		String className = Season.class.getName();
		
		long seasonId = counterLocalService.increment(className);
		Season season = seasonPersistence.create(seasonId);
		
		season.setCompanyId(companyId);
		season.setGroupId(groupId);
		season.setUuid(uuid);
		season.setUserId(userId);
		season.setUserUuid(userUuid);
		season.setUserName(userName);
		season.setCreateDate(createDate);
		season.setModifiedDate(modifiedDate);
		//season.setExpandoBridgeAttributes(serviceContext);
		season.setSeasonTitle(seasonTitle);
		season.setSeasonPremierDate(seasonPremierDate);
		season.setSeasonNumber(seasonNumber);
		season.setSeasonDescription(seasonDescription);
		season.setSeasonImageUrl(seasonImageUrl);
		season.setSeasonImageUuid(seasonImageUuid);
		season.setSeasonImageTitle(seasonImageTitle);
		season.setSeasonImageVersion(seasonImageVersion);
		season.setTvShowId(tvShowId);
		
		
		// persist the properly created instance
		
		seasonPersistence.update(season);
		
		
		// Permission/Resource 
		
		boolean addGroupPermissions = serviceContext.isAddGroupPermissions();
		boolean addGuestPermissions = serviceContext.isAddGuestPermissions();
		
        if (addGroupPermissions || addGuestPermissions) {
        	
            addSeasonResources(season, addGroupPermissions, addGuestPermissions);
            
        } else {
        	
        	String[] groupPermissions = serviceContext.getGroupPermissions();
    		String[] guestPermissions = serviceContext.getGuestPermissions();
        	
            addSeasonModelResources(season, groupPermissions, guestPermissions);
        }
		

		// Expando

        ExpandoBridge expandoBridge = season.getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
		
        
		// Asset

        long[] assetCategoryIds = serviceContext.getAssetCategoryIds();
		String[] assetTagNames = serviceContext.getAssetTagNames();
		long[] assetLinkEntryIds = serviceContext.getAssetLinkEntryIds();
		
		updateSeasonAsset(userId, season, assetCategoryIds, assetTagNames, assetLinkEntryIds);
		
		
		// Search/Index
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Season.class);
		
		indexer.reindex(season);
		
		
		return season;
	}
	
	/***************************************************************************/
	/********** BLL - UPDATE Entity ********************************************/
	/***************************************************************************/
	
	public Season updateSeason(
			long userId, long groupId, 
			long tvShowId, long seasonId,
			String seasonTitle, Date seasonPremierDate, 
			int seasonNumber, String seasonDescription, 
			String seasonImageUrl, String seasonImageUuid, 
			String seasonImageTitle, String seasonImageVersion, 
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
				seasonTitle, 
				seasonPremierDate, 
				seasonNumber, 
				seasonDescription, 
				seasonImageUrl, 
				seasonImageUuid, 
				seasonImageTitle, 
				seasonImageVersion);
		
		
		// get the editable entity instance and fill up with the prepared newly parameters
		
		Season season = getSeason(groupId, seasonId);
		
		season.setCompanyId(companyId);
		season.setGroupId(groupId);
		season.setUuid(uuid);
		season.setUserId(userId);
		season.setUserUuid(userUuid);
		season.setUserName(userName);
		season.setCreateDate(createDate);
		season.setModifiedDate(modifiedDate);
		//season.setExpandoBridgeAttributes(serviceContext);
		season.setSeasonTitle(seasonTitle);
		season.setSeasonPremierDate(seasonPremierDate);
		season.setSeasonNumber(seasonNumber);
		season.setSeasonDescription(seasonDescription);
		season.setSeasonImageUrl(seasonImageUrl);
		season.setSeasonImageUuid(seasonImageUuid);
		season.setSeasonImageTitle(seasonImageTitle);
		season.setSeasonImageVersion(seasonImageVersion);
		season.setTvShowId(tvShowId);
		
		
		// persist the updated entity instance
		
		seasonPersistence.update(season);
		
		
		// Permission/Resource 
		
		boolean addGroupPermissions = serviceContext.isAddGroupPermissions();
		boolean addGuestPermissions = serviceContext.isAddGuestPermissions();
		
        if (addGroupPermissions || addGuestPermissions) {
        	
        	String[] groupPermissions = serviceContext.getGroupPermissions();
    		String[] guestPermissions = serviceContext.getGuestPermissions();
        	
            updateSeasonResources(season, groupPermissions, guestPermissions);
            
        } else {
        	
        	updateSeasonModelResources(season, serviceContext);
        }
		
        
		// Expando

        ExpandoBridge expandoBridge = season.getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
        
        
        // Asset
        
        long[] assetCategoryIds = serviceContext.getAssetCategoryIds();
		String[] assetTagNames = serviceContext.getAssetTagNames();
		long[] assetLinkEntryIds = serviceContext.getAssetLinkEntryIds();
		
		updateSeasonAsset(userId, season, assetCategoryIds, assetTagNames, assetLinkEntryIds);
        
		
        // Search/Index
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Season.class);
		
		indexer.reindex(season);
		

		return season;
	}
	
	/***************************************************************************/
	/********** BLL - DELETE Entity ********************************************/
	/***************************************************************************/
	
	public Season deleteSeason(long seasonId, ServiceContext serviceContext) 
			throws PortalException, SystemException {
		
		// retrieve the deletable entity instance from the database
		
		Season season = getSeason(seasonId);
		
		return deleteSeason(season, serviceContext);
	}
	
	public Season deleteSeason(long groupId, long seasonId, ServiceContext serviceContext) 
			throws PortalException, SystemException {
		
		Season season = getSeason(groupId, seasonId);
		
		return deleteSeason(season);
		
	}
	
	public Season deleteSeason(Season season, ServiceContext serviceContext) 
			throws PortalException, SystemException {
		
		// unbox and prepare the necessary parameters
		
		long companyId = serviceContext.getCompanyId();
		long seasonId = season.getSeasonId();
		
		// prepare some parameters for permission/resource deleting
		
		String className = Season.class.getName();
		
		
		// Permission/Resource 
		
		resourceLocalService.deleteResource(companyId, className, ResourceConstants.SCOPE_INDIVIDUAL, seasonId);
		
		
		// Expando

        expandoValueLocalService.deleteValues(className, seasonId);

		
		// Asset
        
        AssetEntry assetEntry = assetEntryLocalService.getEntry(className, seasonId);
        
        long entryId = assetEntry.getEntryId();
        
        assetLinkLocalService.deleteLinks(entryId);
        
		assetEntryLocalService.deleteEntry(className, seasonId);
		
		
		// Search/Index
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Season.class);
		
		indexer.reindex(season);
		
		
		// delete the entity instance
		
		seasonPersistence.remove(season);
		
		
		return season;
	}
	
	
	/***************************************************************************/
	/********** Resource adding ************************************************/
	/***************************************************************************/
	
    public void addSeasonResources(Season season, boolean addGroupPermissions, boolean addGuestPermissions) 
    		throws PortalException, SystemException {

    	long companyId = season.getCompanyId();
    	long groupId = season.getGroupId();
    	long userId = season.getUserId();
    	
    	String className = Season.class.getName();
    	
    	long seasonId = season.getSeasonId();
    	
    	boolean portletActions = false;
    	
        resourceLocalService.addResources(
            companyId, groupId, userId, className, 
            seasonId, portletActions, 
            addGroupPermissions, addGuestPermissions);
    }

    public void addSeasonModelResources(Season season, String[] groupPermissions, String[] guestPermissions) 
    		throws PortalException, SystemException {

    	long companyId = season.getCompanyId();
    	long groupId = season.getGroupId();
    	long userId = season.getUserId();
    	
    	String className = Season.class.getName();
    	
    	long seasonId = season.getSeasonId();
    	
        resourceLocalService.addModelResources(
            companyId, groupId, userId, className,
            seasonId, groupPermissions, guestPermissions);
    }
   
    /***************************************************************************/
	/********** Resource updating **********************************************/
	/***************************************************************************/
	
    public void updateSeasonResources(Season season, String[] groupPermissions, String[] guestPermissions) 
    		throws PortalException, SystemException {

    	long companyId = season.getCompanyId();
    	long groupId = season.getGroupId();
    	
    	String className = Season.class.getName();
    	
    	long seasonId = season.getSeasonId();
    	
        resourceLocalService.updateResources(companyId, groupId, className, seasonId, groupPermissions, guestPermissions);
    }

    public void updateSeasonModelResources(Season season, ServiceContext serviceContext) 
    		throws PortalException, SystemException {
    	
        resourceLocalService.updateModelResources(season, serviceContext);
    }
    
    /***************************************************************************/
	/********** Asset updating *************************************************/
	/***************************************************************************/
    
    public void updateSeasonAsset(long userId, Season season, long[] assetCategoryIds, String[] assetTagNames, long[] assetLinkEntryIds) 
    		throws PortalException, SystemException {
    	
    	long groupId = season.getGroupId();
    	Date createDate = season.getCreateDate();
    	Date modifiedDate = season.getModifiedDate();
    	String className = Season.class.getName();
    	long seasonId = season.getSeasonId();
    	String uuid = season.getUuid();
    	
    	long classTypeId = 0;
		boolean visible = true;
		Date startDate = null; 
		Date endDate = null;
		Date expirationDate = null;
		String mimeType = ContentTypes.TEXT_HTML;
		String assetTitle = season.getSeasonTitle();
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
				className, seasonId, uuid, classTypeId, 
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
	/********** Validation *****************************************************/
	/***************************************************************************/
	
	private void validate(
			String seasonTitle, 
			Date seasonPremierDate, 
			int seasonNumber, 
			String seasonDescription, 
			String seasonImageUrl, 
			String seasonImageUuid, 
			String seasonImageTitle, 
			String seasonImageVersion) throws PortalException{
		
		// checking if the paramaters are acceptable
		
		if(Validator.isNull(seasonTitle)){
			
			throw new SeasonTitleException("The season's title is mandatory!");
		}
		
		if(Validator.isNull(seasonPremierDate)){
			
			throw new SeasonPremierDateException("The season's premier date is mandatory!");
		}
		
		if(seasonNumber < 1){
			
			throw new SeasonNumberException("The season's number must be a positive integer number!");
		}
		
		if(Validator.isNull(seasonDescription)){
			
			throw new SeasonDescriptionException("The season's description is mandatory!");
		}
		
		if(seasonImageUrl == null || seasonImageUuid == null || seasonImageTitle == null || seasonImageVersion == null){
			
			throw new SeasonImageException("The season's image musn't be null!");
		}
	}
}