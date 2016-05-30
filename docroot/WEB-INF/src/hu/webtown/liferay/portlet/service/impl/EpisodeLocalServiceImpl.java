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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import hu.webtown.liferay.portlet.model.Episode;
import hu.webtown.liferay.portlet.service.base.EpisodeLocalServiceBaseImpl;

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
	
	public Episode getEpisode(long groupId, long episodeId) throws PortalException, SystemException{
		
		// using of the finder method to retrive the requested entity instance
		
		Episode episode = episodePersistence.findByG_E(groupId, episodeId);
		
		return episode;
	}
}