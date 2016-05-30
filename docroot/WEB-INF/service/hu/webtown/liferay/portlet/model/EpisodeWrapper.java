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

package hu.webtown.liferay.portlet.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Episode}.
 * </p>
 *
 * @author czeni
 * @see Episode
 * @generated
 */
public class EpisodeWrapper implements Episode, ModelWrapper<Episode> {
	public EpisodeWrapper(Episode episode) {
		_episode = episode;
	}

	@Override
	public Class<?> getModelClass() {
		return Episode.class;
	}

	@Override
	public String getModelClassName() {
		return Episode.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("episodeId", getEpisodeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("episodeTitle", getEpisodeTitle());
		attributes.put("episodeAirDate", getEpisodeAirDate());
		attributes.put("episodeNumber", getEpisodeNumber());
		attributes.put("episodeDescription", getEpisodeDescription());
		attributes.put("episodeImageUrl", getEpisodeImageUrl());
		attributes.put("episodeImageUuid", getEpisodeImageUuid());
		attributes.put("episodeImageTitle", getEpisodeImageTitle());
		attributes.put("episodeImageVersion", getEpisodeImageVersion());
		attributes.put("seasonId", getSeasonId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long episodeId = (Long)attributes.get("episodeId");

		if (episodeId != null) {
			setEpisodeId(episodeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String episodeTitle = (String)attributes.get("episodeTitle");

		if (episodeTitle != null) {
			setEpisodeTitle(episodeTitle);
		}

		Date episodeAirDate = (Date)attributes.get("episodeAirDate");

		if (episodeAirDate != null) {
			setEpisodeAirDate(episodeAirDate);
		}

		Integer episodeNumber = (Integer)attributes.get("episodeNumber");

		if (episodeNumber != null) {
			setEpisodeNumber(episodeNumber);
		}

		String episodeDescription = (String)attributes.get("episodeDescription");

		if (episodeDescription != null) {
			setEpisodeDescription(episodeDescription);
		}

		String episodeImageUrl = (String)attributes.get("episodeImageUrl");

		if (episodeImageUrl != null) {
			setEpisodeImageUrl(episodeImageUrl);
		}

		String episodeImageUuid = (String)attributes.get("episodeImageUuid");

		if (episodeImageUuid != null) {
			setEpisodeImageUuid(episodeImageUuid);
		}

		String episodeImageTitle = (String)attributes.get("episodeImageTitle");

		if (episodeImageTitle != null) {
			setEpisodeImageTitle(episodeImageTitle);
		}

		String episodeImageVersion = (String)attributes.get(
				"episodeImageVersion");

		if (episodeImageVersion != null) {
			setEpisodeImageVersion(episodeImageVersion);
		}

		Long seasonId = (Long)attributes.get("seasonId");

		if (seasonId != null) {
			setSeasonId(seasonId);
		}
	}

	/**
	* Returns the primary key of this episode.
	*
	* @return the primary key of this episode
	*/
	@Override
	public long getPrimaryKey() {
		return _episode.getPrimaryKey();
	}

	/**
	* Sets the primary key of this episode.
	*
	* @param primaryKey the primary key of this episode
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_episode.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the episode ID of this episode.
	*
	* @return the episode ID of this episode
	*/
	@Override
	public long getEpisodeId() {
		return _episode.getEpisodeId();
	}

	/**
	* Sets the episode ID of this episode.
	*
	* @param episodeId the episode ID of this episode
	*/
	@Override
	public void setEpisodeId(long episodeId) {
		_episode.setEpisodeId(episodeId);
	}

	/**
	* Returns the group ID of this episode.
	*
	* @return the group ID of this episode
	*/
	@Override
	public long getGroupId() {
		return _episode.getGroupId();
	}

	/**
	* Sets the group ID of this episode.
	*
	* @param groupId the group ID of this episode
	*/
	@Override
	public void setGroupId(long groupId) {
		_episode.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this episode.
	*
	* @return the company ID of this episode
	*/
	@Override
	public long getCompanyId() {
		return _episode.getCompanyId();
	}

	/**
	* Sets the company ID of this episode.
	*
	* @param companyId the company ID of this episode
	*/
	@Override
	public void setCompanyId(long companyId) {
		_episode.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this episode.
	*
	* @return the user ID of this episode
	*/
	@Override
	public long getUserId() {
		return _episode.getUserId();
	}

	/**
	* Sets the user ID of this episode.
	*
	* @param userId the user ID of this episode
	*/
	@Override
	public void setUserId(long userId) {
		_episode.setUserId(userId);
	}

	/**
	* Returns the user uuid of this episode.
	*
	* @return the user uuid of this episode
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _episode.getUserUuid();
	}

	/**
	* Sets the user uuid of this episode.
	*
	* @param userUuid the user uuid of this episode
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_episode.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this episode.
	*
	* @return the user name of this episode
	*/
	@Override
	public java.lang.String getUserName() {
		return _episode.getUserName();
	}

	/**
	* Sets the user name of this episode.
	*
	* @param userName the user name of this episode
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_episode.setUserName(userName);
	}

	/**
	* Returns the create date of this episode.
	*
	* @return the create date of this episode
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _episode.getCreateDate();
	}

	/**
	* Sets the create date of this episode.
	*
	* @param createDate the create date of this episode
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_episode.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this episode.
	*
	* @return the modified date of this episode
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _episode.getModifiedDate();
	}

	/**
	* Sets the modified date of this episode.
	*
	* @param modifiedDate the modified date of this episode
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_episode.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the episode title of this episode.
	*
	* @return the episode title of this episode
	*/
	@Override
	public java.lang.String getEpisodeTitle() {
		return _episode.getEpisodeTitle();
	}

	/**
	* Sets the episode title of this episode.
	*
	* @param episodeTitle the episode title of this episode
	*/
	@Override
	public void setEpisodeTitle(java.lang.String episodeTitle) {
		_episode.setEpisodeTitle(episodeTitle);
	}

	/**
	* Returns the episode air date of this episode.
	*
	* @return the episode air date of this episode
	*/
	@Override
	public java.util.Date getEpisodeAirDate() {
		return _episode.getEpisodeAirDate();
	}

	/**
	* Sets the episode air date of this episode.
	*
	* @param episodeAirDate the episode air date of this episode
	*/
	@Override
	public void setEpisodeAirDate(java.util.Date episodeAirDate) {
		_episode.setEpisodeAirDate(episodeAirDate);
	}

	/**
	* Returns the episode number of this episode.
	*
	* @return the episode number of this episode
	*/
	@Override
	public int getEpisodeNumber() {
		return _episode.getEpisodeNumber();
	}

	/**
	* Sets the episode number of this episode.
	*
	* @param episodeNumber the episode number of this episode
	*/
	@Override
	public void setEpisodeNumber(int episodeNumber) {
		_episode.setEpisodeNumber(episodeNumber);
	}

	/**
	* Returns the episode description of this episode.
	*
	* @return the episode description of this episode
	*/
	@Override
	public java.lang.String getEpisodeDescription() {
		return _episode.getEpisodeDescription();
	}

	/**
	* Sets the episode description of this episode.
	*
	* @param episodeDescription the episode description of this episode
	*/
	@Override
	public void setEpisodeDescription(java.lang.String episodeDescription) {
		_episode.setEpisodeDescription(episodeDescription);
	}

	/**
	* Returns the episode image url of this episode.
	*
	* @return the episode image url of this episode
	*/
	@Override
	public java.lang.String getEpisodeImageUrl() {
		return _episode.getEpisodeImageUrl();
	}

	/**
	* Sets the episode image url of this episode.
	*
	* @param episodeImageUrl the episode image url of this episode
	*/
	@Override
	public void setEpisodeImageUrl(java.lang.String episodeImageUrl) {
		_episode.setEpisodeImageUrl(episodeImageUrl);
	}

	/**
	* Returns the episode image uuid of this episode.
	*
	* @return the episode image uuid of this episode
	*/
	@Override
	public java.lang.String getEpisodeImageUuid() {
		return _episode.getEpisodeImageUuid();
	}

	/**
	* Sets the episode image uuid of this episode.
	*
	* @param episodeImageUuid the episode image uuid of this episode
	*/
	@Override
	public void setEpisodeImageUuid(java.lang.String episodeImageUuid) {
		_episode.setEpisodeImageUuid(episodeImageUuid);
	}

	/**
	* Returns the episode image title of this episode.
	*
	* @return the episode image title of this episode
	*/
	@Override
	public java.lang.String getEpisodeImageTitle() {
		return _episode.getEpisodeImageTitle();
	}

	/**
	* Sets the episode image title of this episode.
	*
	* @param episodeImageTitle the episode image title of this episode
	*/
	@Override
	public void setEpisodeImageTitle(java.lang.String episodeImageTitle) {
		_episode.setEpisodeImageTitle(episodeImageTitle);
	}

	/**
	* Returns the episode image version of this episode.
	*
	* @return the episode image version of this episode
	*/
	@Override
	public java.lang.String getEpisodeImageVersion() {
		return _episode.getEpisodeImageVersion();
	}

	/**
	* Sets the episode image version of this episode.
	*
	* @param episodeImageVersion the episode image version of this episode
	*/
	@Override
	public void setEpisodeImageVersion(java.lang.String episodeImageVersion) {
		_episode.setEpisodeImageVersion(episodeImageVersion);
	}

	/**
	* Returns the season ID of this episode.
	*
	* @return the season ID of this episode
	*/
	@Override
	public long getSeasonId() {
		return _episode.getSeasonId();
	}

	/**
	* Sets the season ID of this episode.
	*
	* @param seasonId the season ID of this episode
	*/
	@Override
	public void setSeasonId(long seasonId) {
		_episode.setSeasonId(seasonId);
	}

	@Override
	public boolean isNew() {
		return _episode.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_episode.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _episode.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_episode.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _episode.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _episode.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_episode.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _episode.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_episode.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_episode.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_episode.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EpisodeWrapper((Episode)_episode.clone());
	}

	@Override
	public int compareTo(hu.webtown.liferay.portlet.model.Episode episode) {
		return _episode.compareTo(episode);
	}

	@Override
	public int hashCode() {
		return _episode.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<hu.webtown.liferay.portlet.model.Episode> toCacheModel() {
		return _episode.toCacheModel();
	}

	@Override
	public hu.webtown.liferay.portlet.model.Episode toEscapedModel() {
		return new EpisodeWrapper(_episode.toEscapedModel());
	}

	@Override
	public hu.webtown.liferay.portlet.model.Episode toUnescapedModel() {
		return new EpisodeWrapper(_episode.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _episode.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _episode.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_episode.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EpisodeWrapper)) {
			return false;
		}

		EpisodeWrapper episodeWrapper = (EpisodeWrapper)obj;

		if (Validator.equals(_episode, episodeWrapper._episode)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Episode getWrappedEpisode() {
		return _episode;
	}

	@Override
	public Episode getWrappedModel() {
		return _episode;
	}

	@Override
	public void resetOriginalValues() {
		_episode.resetOriginalValues();
	}

	private Episode _episode;
}