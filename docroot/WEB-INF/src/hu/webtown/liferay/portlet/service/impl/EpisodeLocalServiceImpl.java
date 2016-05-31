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

import hu.webtown.liferay.portlet.EpisodeAirDateException;
import hu.webtown.liferay.portlet.EpisodeDescriptionException;
import hu.webtown.liferay.portlet.EpisodeImageException;
import hu.webtown.liferay.portlet.EpisodeNumberException;
import hu.webtown.liferay.portlet.EpisodeTitleException;
import hu.webtown.liferay.portlet.model.Episode;
import hu.webtown.liferay.portlet.service.base.EpisodeLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the episode local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.webtown.liferay.portlet.service.EpisodeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author czeni
 * @see hu.webtown.liferay.portlet.service.base.EpisodeLocalServiceBaseImpl
 * @see hu.webtown.liferay.portlet.service.EpisodeLocalServiceUtil
 */
public class EpisodeLocalServiceImpl extends EpisodeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link hu.webtown.liferay.portlet.service.EpisodeLocalServiceUtil} to access the episode local service.
	 */
	
	/***************************************************************************/
	/********** BLL - GET Entity ***********************************************/
	/***************************************************************************/
	
	public Episode getEpisode(long episodeId) throws PortalException, SystemException{
			
		// using of the finder method to retrive the requested entity instance
		
		Episode episode = episodePersistence.fetchByPrimaryKey(episodeId);
		
		return episode;
	}
	
	public Episode getEpisode(long groupId, long episodeId) throws PortalException, SystemException{
		
		// using of the finder method to retrive the requested entity instance
		
		Episode episode = episodePersistence.findByG_E(groupId, episodeId);
		
		return episode;
	}
	
	/***************************************************************************/
	/********** BLL - GET Entities *********************************************/
	/***************************************************************************/
	
	public List<Episode> getEpisodes(long groupId) throws SystemException{
		
		// using of the finder method

		return episodePersistence.findByGroupId(groupId);
	}
	
	public List<Episode> getEpisodes(long groupId, long seasonId) throws SystemException{
		
		// using of the finder method
		
		return episodePersistence.findByG_S(groupId, seasonId);
	}
	
	public List<Episode> getEpisodes(long groupId, int start, int end) throws SystemException {
		
		// using of the finder method
		
		return episodePersistence.findByGroupId(groupId, start, end);
	}
	
	public List<Episode> getEpisodes(long groupId, long seasonId, int start, int end) throws SystemException {
		
		// using of the finder method
		
		return episodePersistence.findByG_S(groupId, seasonId, start, end);
	}
	
	public List<Episode> getEpisodes(long groupId, OrderByComparator orderByComparator) throws SystemException {
		
		int start = QueryUtil.ALL_POS;
		int end = QueryUtil.ALL_POS;
		
		return getEpisodes(groupId, start, end, orderByComparator);
	}
	
	public List<Episode> getEpisodes(long groupId, long seasonId, OrderByComparator orderByComparator) throws SystemException {
		
		int start = QueryUtil.ALL_POS;
		int end = QueryUtil.ALL_POS;
		
		return getEpisodes(groupId, seasonId, start, end, orderByComparator);
	}
	
	public List<Episode> getEpisodes(long groupId, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		
		// using of the finder method
		
		return episodePersistence.findByGroupId(groupId, start, end, orderByComparator);
		
	}
	
	public List<Episode> getEpisodes(long groupId, long seasonId, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		
		// using of the finder method
		
		return episodePersistence.findByG_S(groupId, seasonId, start, end, orderByComparator);
	}
	
	/***************************************************************************/
	/********** BLL - Count Entities *******************************************/
	/***************************************************************************/
	
	public int getEpisodesCount(long groupId) throws SystemException {
		
		// using of the appropriate method generated by service builder
		
		return episodePersistence.countByGroupId(groupId);
	}
	
	public int getEpisodesCount(long groupId, long seasonId) throws SystemException {
		
		// using of the appropriate method generated by service builder
		
		return episodePersistence.countByG_S(groupId, seasonId);
	}
	
	/***************************************************************************/
	/********** BLL - CREATE Entity ********************************************/
	/***************************************************************************/
	
	public Episode addEpisode(
			long userId, long groupId, long seasonId, 
			String episodeTitle, Date episodeAirDate, 
			int episodeNumber, String episodeDescription, 
			String episodeImageUrl, String episodeImageUuid, 
			String episodeImageTitle, String episodeImageVersion, 
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
				episodeTitle, 
				episodeAirDate, 
				episodeNumber, 
				episodeDescription, 
				episodeImageUrl, 
				episodeImageUuid, 
				episodeImageTitle, 
				episodeImageVersion);
		
		
		// create new entity instance and fill up with the prepared parameters
		
		String className = Episode.class.getName();
		
		long episodeId = counterLocalService.increment(className);
		Episode episode = episodePersistence.create(episodeId);
		
		episode.setCompanyId(companyId);
		episode.setGroupId(groupId);
		episode.setUuid(uuid);
		episode.setUserId(userId);
		episode.setUserUuid(userUuid);
		episode.setUserName(userName);
		episode.setCreateDate(createDate);
		episode.setModifiedDate(modifiedDate);
		//episode.setExpandoBridgeAttributes(serviceContext);
		episode.setEpisodeTitle(episodeTitle);
		episode.setEpisodeAirDate(episodeAirDate);
		episode.setEpisodeNumber(episodeNumber);
		episode.setEpisodeDescription(episodeDescription);
		episode.setEpisodeImageUrl(episodeImageUrl);
		episode.setEpisodeImageUuid(episodeImageUuid);
		episode.setEpisodeImageTitle(episodeImageTitle);
		episode.setEpisodeImageVersion(episodeImageVersion);
		episode.setSeasonId(seasonId);
		
		
		// persist the properly created instance
		
		episodePersistence.update(episode);
		
		
		// Permission/Resource 
		
		boolean addGroupPermissions = serviceContext.isAddGroupPermissions();
		boolean addGuestPermissions = serviceContext.isAddGuestPermissions();
		
        if (addGroupPermissions || addGuestPermissions) {
        	
            addEpisodeResources(episode, addGroupPermissions, addGuestPermissions);
            
        } else {
        	
        	String[] groupPermissions = serviceContext.getGroupPermissions();
    		String[] guestPermissions = serviceContext.getGuestPermissions();
        	
            addEpisodeModelResources(episode, groupPermissions, guestPermissions);
        }
		

		// Expando

        ExpandoBridge expandoBridge = episode.getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
		
        
		// Asset

        long[] assetCategoryIds = serviceContext.getAssetCategoryIds();
		String[] assetTagNames = serviceContext.getAssetTagNames();
		long[] assetLinkEntryIds = serviceContext.getAssetLinkEntryIds();
		
		updateEpisodeAsset(userId, episode, assetCategoryIds, assetTagNames, assetLinkEntryIds);
		
		
		// Search/Index
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Episode.class);
		
		indexer.reindex(episode);
		
		
		return episode;
	}
	
	/***************************************************************************/
	/********** BLL - UPDATE Entity ********************************************/
	/***************************************************************************/
	
	public Episode updateEpisode(
			long userId, long groupId, 
			long seasonId, long episodeId,
			String episodeTitle, Date episodeAirDate, 
			int episodeNumber, String episodeDescription, 
			String episodeImageUrl, String episodeImageUuid, 
			String episodeImageTitle, String episodeImageVersion, 
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
				episodeTitle, 
				episodeAirDate, 
				episodeNumber, 
				episodeDescription, 
				episodeImageUrl, 
				episodeImageUuid, 
				episodeImageTitle, 
				episodeImageVersion);
		
		
		// get the editable entity instance and fill up with the prepared newly parameters
		
		Episode episode = getEpisode(episodeId);
		
		episode.setCompanyId(companyId);
		episode.setGroupId(groupId);
		episode.setUuid(uuid);
		episode.setUserId(userId);
		episode.setUserUuid(userUuid);
		episode.setUserName(userName);
		episode.setCreateDate(createDate);
		episode.setModifiedDate(modifiedDate);
		//episode.setExpandoBridgeAttributes(serviceContext);
		episode.setEpisodeTitle(episodeTitle);
		episode.setEpisodeAirDate(episodeAirDate);
		episode.setEpisodeNumber(episodeNumber);
		episode.setEpisodeDescription(episodeDescription);
		episode.setEpisodeImageUrl(episodeImageUrl);
		episode.setEpisodeImageUuid(episodeImageUuid);
		episode.setEpisodeImageTitle(episodeImageTitle);
		episode.setEpisodeImageVersion(episodeImageVersion);
		episode.setSeasonId(seasonId);
		
		
		// persist the updated entity instance
		
		episodePersistence.update(episode);
		
		
		// Permission/Resource 
		
		boolean addGroupPermissions = serviceContext.isAddGroupPermissions();
		boolean addGuestPermissions = serviceContext.isAddGuestPermissions();
		
        if (addGroupPermissions || addGuestPermissions) {
        	
        	String[] groupPermissions = serviceContext.getGroupPermissions();
    		String[] guestPermissions = serviceContext.getGuestPermissions();
        	
            updateEpisodeResources(episode, groupPermissions, guestPermissions);
            
        } else {
        	
        	updateEpisodeModelResources(episode, serviceContext);
        }
		
        
		// Expando

        ExpandoBridge expandoBridge = episode.getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
        
        
        // Asset
        
        long[] assetCategoryIds = serviceContext.getAssetCategoryIds();
		String[] assetTagNames = serviceContext.getAssetTagNames();
		long[] assetLinkEntryIds = serviceContext.getAssetLinkEntryIds();
		
		updateEpisodeAsset(userId, episode, assetCategoryIds, assetTagNames, assetLinkEntryIds);
        
		
        // Search/Index
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Episode.class);
		
		indexer.reindex(episode);
		

		return episode;
	}
	
	/***************************************************************************/
	/********** BLL - DELETE Entity ********************************************/
	/***************************************************************************/
	
	public Episode deleteEpisode(long episodeId, ServiceContext serviceContext) 
			throws PortalException, SystemException {
		
		// retrieve the deletable entity instance from the database
		
		Episode episode = getEpisode(episodeId);
		
		return deleteEpisode(episode, serviceContext);
	}
	
	public Episode deleteEpisode(long groupId, long episodeId, ServiceContext serviceContext) 
			throws PortalException, SystemException {
		
		Episode episode = getEpisode(groupId, episodeId);
		
		return deleteEpisode(episode);
		
	}
	
	public Episode deleteEpisode(Episode episode, ServiceContext serviceContext) 
			throws PortalException, SystemException {
		
		// unbox and prepare the necessary parameters
		
		long companyId = serviceContext.getCompanyId();
		long episodeId = episode.getEpisodeId();
		
		// prepare some parameters for permission/resource deleting
		
		String className = Episode.class.getName();
		
		
		// Permission/Resource 
		
		resourceLocalService.deleteResource(companyId, className, ResourceConstants.SCOPE_INDIVIDUAL, episodeId);
		
		
		// Expando

        expandoValueLocalService.deleteValues(className, episodeId);

		
		// Asset
        
        AssetEntry assetEntry = assetEntryLocalService.getEntry(className, episodeId);
        
        long entryId = assetEntry.getEntryId();
        
        assetLinkLocalService.deleteLinks(entryId);
        
		assetEntryLocalService.deleteEntry(className, episodeId);
		
		
		// Search/Index
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Episode.class);
		
		indexer.reindex(episode);
		
		
		// delete the entity instance
		
		episodePersistence.remove(episode);
		
		
		return episode;
	}
	
	/***************************************************************************/
	/********** Resource adding ************************************************/
	/***************************************************************************/
	
    public void addEpisodeResources(Episode episode, boolean addGroupPermissions, boolean addGuestPermissions) 
    		throws PortalException, SystemException {

    	long companyId = episode.getCompanyId();
    	long groupId = episode.getGroupId();
    	long userId = episode.getUserId();
    	
    	String className = Episode.class.getName();
    	
    	long episodeId = episode.getEpisodeId();
    	
    	boolean portletActions = false;
    	
        resourceLocalService.addResources(
            companyId, groupId, userId, className, 
            episodeId, portletActions, 
            addGroupPermissions, addGuestPermissions);
    }

    public void addEpisodeModelResources(Episode episode, String[] groupPermissions, String[] guestPermissions) 
    		throws PortalException, SystemException {

    	long companyId = episode.getCompanyId();
    	long groupId = episode.getGroupId();
    	long userId = episode.getUserId();
    	
    	String className = Episode.class.getName();
    	
    	long episodeId = episode.getEpisodeId();
    	
        resourceLocalService.addModelResources(
            companyId, groupId, userId, className,
            episodeId, groupPermissions, guestPermissions);
    }
	
   
    /***************************************************************************/
	/********** Resource updating **********************************************/
	/***************************************************************************/
	
    public void updateEpisodeResources(Episode episode, String[] groupPermissions, String[] guestPermissions) 
    		throws PortalException, SystemException {

    	long companyId = episode.getCompanyId();
    	long groupId = episode.getGroupId();
    	
    	String className = Episode.class.getName();
    	
    	long episodeId = episode.getEpisodeId();
    	
        resourceLocalService.updateResources(companyId, groupId, className, episodeId, groupPermissions, guestPermissions);
    }

    public void updateEpisodeModelResources(Episode episode, ServiceContext serviceContext) 
    		throws PortalException, SystemException {
    	
        resourceLocalService.updateModelResources(episode, serviceContext);
    }
    
    /***************************************************************************/
	/********** Asset updating *************************************************/
	/***************************************************************************/
    
    public void updateEpisodeAsset(long userId, Episode episode, long[] assetCategoryIds, String[] assetTagNames, long[] assetLinkEntryIds) 
    		throws PortalException, SystemException {
    	
    	long groupId = episode.getGroupId();
    	Date createDate = episode.getCreateDate();
    	Date modifiedDate = episode.getModifiedDate();
    	String className = Episode.class.getName();
    	long episodeId = episode.getEpisodeId();
    	String uuid = episode.getUuid();
    	
    	long classTypeId = 0;
		boolean visible = true;
		Date startDate = null; 
		Date endDate = null;
		Date expirationDate = null;
		String mimeType = ContentTypes.TEXT_HTML;
		String assetTitle = episode.getEpisodeTitle(); 
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
				className, episodeId, uuid, classTypeId, 
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
			String episodeTitle, 
			Date episodeAirDate, 
			int episodeNumber, 
			String episodeDescription, 
			String episodeImageUrl, 
			String episodeImageUuid, 
			String episodeImageTitle, 
			String episodeImageVersion) throws PortalException{
		
		// checking if the paramaters are acceptable
		
		if(Validator.isNull(episodeTitle)){
			
			throw new EpisodeTitleException("The episode's title is mandatory!");
		}
		
		if(Validator.isNull(episodeAirDate)){
			
			throw new EpisodeAirDateException("The episode's air date is mandatory!");
		}
		
		if(episodeNumber < 1){
			
			throw new EpisodeNumberException("The episode's number must be a positive integer number!");
		}
		
		if(Validator.isNull(episodeDescription)){
			
			throw new EpisodeDescriptionException("The episode's description is mandatory!");
		}
		
		if(episodeImageUrl == null || episodeImageUuid == null || episodeImageTitle == null || episodeImageVersion == null){
			
			throw new EpisodeImageException("The episode's image musn't be null!");
		}
	}
}