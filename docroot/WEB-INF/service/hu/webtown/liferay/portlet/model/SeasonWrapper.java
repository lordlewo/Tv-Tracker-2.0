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
 * This class is a wrapper for {@link Season}.
 * </p>
 *
 * @author czeni
 * @see Season
 * @generated
 */
public class SeasonWrapper implements Season, ModelWrapper<Season> {
	public SeasonWrapper(Season season) {
		_season = season;
	}

	@Override
	public Class<?> getModelClass() {
		return Season.class;
	}

	@Override
	public String getModelClassName() {
		return Season.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("seasonId", getSeasonId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("seasonTitle", getSeasonTitle());
		attributes.put("seasonPremierDate", getSeasonPremierDate());
		attributes.put("seasonNumber", getSeasonNumber());
		attributes.put("seasonDescription", getSeasonDescription());
		attributes.put("seasonImageUrl", getSeasonImageUrl());
		attributes.put("seasonImageUuid", getSeasonImageUuid());
		attributes.put("seasonImageTitle", getSeasonImageTitle());
		attributes.put("sesonImageVersion", getSesonImageVersion());
		attributes.put("tvShowId", getTvShowId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long seasonId = (Long)attributes.get("seasonId");

		if (seasonId != null) {
			setSeasonId(seasonId);
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

		String seasonTitle = (String)attributes.get("seasonTitle");

		if (seasonTitle != null) {
			setSeasonTitle(seasonTitle);
		}

		Date seasonPremierDate = (Date)attributes.get("seasonPremierDate");

		if (seasonPremierDate != null) {
			setSeasonPremierDate(seasonPremierDate);
		}

		Integer seasonNumber = (Integer)attributes.get("seasonNumber");

		if (seasonNumber != null) {
			setSeasonNumber(seasonNumber);
		}

		String seasonDescription = (String)attributes.get("seasonDescription");

		if (seasonDescription != null) {
			setSeasonDescription(seasonDescription);
		}

		String seasonImageUrl = (String)attributes.get("seasonImageUrl");

		if (seasonImageUrl != null) {
			setSeasonImageUrl(seasonImageUrl);
		}

		String seasonImageUuid = (String)attributes.get("seasonImageUuid");

		if (seasonImageUuid != null) {
			setSeasonImageUuid(seasonImageUuid);
		}

		String seasonImageTitle = (String)attributes.get("seasonImageTitle");

		if (seasonImageTitle != null) {
			setSeasonImageTitle(seasonImageTitle);
		}

		String sesonImageVersion = (String)attributes.get("sesonImageVersion");

		if (sesonImageVersion != null) {
			setSesonImageVersion(sesonImageVersion);
		}

		Long tvShowId = (Long)attributes.get("tvShowId");

		if (tvShowId != null) {
			setTvShowId(tvShowId);
		}
	}

	/**
	* Returns the primary key of this season.
	*
	* @return the primary key of this season
	*/
	@Override
	public long getPrimaryKey() {
		return _season.getPrimaryKey();
	}

	/**
	* Sets the primary key of this season.
	*
	* @param primaryKey the primary key of this season
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_season.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the season ID of this season.
	*
	* @return the season ID of this season
	*/
	@Override
	public long getSeasonId() {
		return _season.getSeasonId();
	}

	/**
	* Sets the season ID of this season.
	*
	* @param seasonId the season ID of this season
	*/
	@Override
	public void setSeasonId(long seasonId) {
		_season.setSeasonId(seasonId);
	}

	/**
	* Returns the group ID of this season.
	*
	* @return the group ID of this season
	*/
	@Override
	public long getGroupId() {
		return _season.getGroupId();
	}

	/**
	* Sets the group ID of this season.
	*
	* @param groupId the group ID of this season
	*/
	@Override
	public void setGroupId(long groupId) {
		_season.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this season.
	*
	* @return the company ID of this season
	*/
	@Override
	public long getCompanyId() {
		return _season.getCompanyId();
	}

	/**
	* Sets the company ID of this season.
	*
	* @param companyId the company ID of this season
	*/
	@Override
	public void setCompanyId(long companyId) {
		_season.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this season.
	*
	* @return the user ID of this season
	*/
	@Override
	public long getUserId() {
		return _season.getUserId();
	}

	/**
	* Sets the user ID of this season.
	*
	* @param userId the user ID of this season
	*/
	@Override
	public void setUserId(long userId) {
		_season.setUserId(userId);
	}

	/**
	* Returns the user uuid of this season.
	*
	* @return the user uuid of this season
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _season.getUserUuid();
	}

	/**
	* Sets the user uuid of this season.
	*
	* @param userUuid the user uuid of this season
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_season.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this season.
	*
	* @return the user name of this season
	*/
	@Override
	public java.lang.String getUserName() {
		return _season.getUserName();
	}

	/**
	* Sets the user name of this season.
	*
	* @param userName the user name of this season
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_season.setUserName(userName);
	}

	/**
	* Returns the create date of this season.
	*
	* @return the create date of this season
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _season.getCreateDate();
	}

	/**
	* Sets the create date of this season.
	*
	* @param createDate the create date of this season
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_season.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this season.
	*
	* @return the modified date of this season
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _season.getModifiedDate();
	}

	/**
	* Sets the modified date of this season.
	*
	* @param modifiedDate the modified date of this season
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_season.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the season title of this season.
	*
	* @return the season title of this season
	*/
	@Override
	public java.lang.String getSeasonTitle() {
		return _season.getSeasonTitle();
	}

	/**
	* Sets the season title of this season.
	*
	* @param seasonTitle the season title of this season
	*/
	@Override
	public void setSeasonTitle(java.lang.String seasonTitle) {
		_season.setSeasonTitle(seasonTitle);
	}

	/**
	* Returns the season premier date of this season.
	*
	* @return the season premier date of this season
	*/
	@Override
	public java.util.Date getSeasonPremierDate() {
		return _season.getSeasonPremierDate();
	}

	/**
	* Sets the season premier date of this season.
	*
	* @param seasonPremierDate the season premier date of this season
	*/
	@Override
	public void setSeasonPremierDate(java.util.Date seasonPremierDate) {
		_season.setSeasonPremierDate(seasonPremierDate);
	}

	/**
	* Returns the season number of this season.
	*
	* @return the season number of this season
	*/
	@Override
	public int getSeasonNumber() {
		return _season.getSeasonNumber();
	}

	/**
	* Sets the season number of this season.
	*
	* @param seasonNumber the season number of this season
	*/
	@Override
	public void setSeasonNumber(int seasonNumber) {
		_season.setSeasonNumber(seasonNumber);
	}

	/**
	* Returns the season description of this season.
	*
	* @return the season description of this season
	*/
	@Override
	public java.lang.String getSeasonDescription() {
		return _season.getSeasonDescription();
	}

	/**
	* Sets the season description of this season.
	*
	* @param seasonDescription the season description of this season
	*/
	@Override
	public void setSeasonDescription(java.lang.String seasonDescription) {
		_season.setSeasonDescription(seasonDescription);
	}

	/**
	* Returns the season image url of this season.
	*
	* @return the season image url of this season
	*/
	@Override
	public java.lang.String getSeasonImageUrl() {
		return _season.getSeasonImageUrl();
	}

	/**
	* Sets the season image url of this season.
	*
	* @param seasonImageUrl the season image url of this season
	*/
	@Override
	public void setSeasonImageUrl(java.lang.String seasonImageUrl) {
		_season.setSeasonImageUrl(seasonImageUrl);
	}

	/**
	* Returns the season image uuid of this season.
	*
	* @return the season image uuid of this season
	*/
	@Override
	public java.lang.String getSeasonImageUuid() {
		return _season.getSeasonImageUuid();
	}

	/**
	* Sets the season image uuid of this season.
	*
	* @param seasonImageUuid the season image uuid of this season
	*/
	@Override
	public void setSeasonImageUuid(java.lang.String seasonImageUuid) {
		_season.setSeasonImageUuid(seasonImageUuid);
	}

	/**
	* Returns the season image title of this season.
	*
	* @return the season image title of this season
	*/
	@Override
	public java.lang.String getSeasonImageTitle() {
		return _season.getSeasonImageTitle();
	}

	/**
	* Sets the season image title of this season.
	*
	* @param seasonImageTitle the season image title of this season
	*/
	@Override
	public void setSeasonImageTitle(java.lang.String seasonImageTitle) {
		_season.setSeasonImageTitle(seasonImageTitle);
	}

	/**
	* Returns the seson image version of this season.
	*
	* @return the seson image version of this season
	*/
	@Override
	public java.lang.String getSesonImageVersion() {
		return _season.getSesonImageVersion();
	}

	/**
	* Sets the seson image version of this season.
	*
	* @param sesonImageVersion the seson image version of this season
	*/
	@Override
	public void setSesonImageVersion(java.lang.String sesonImageVersion) {
		_season.setSesonImageVersion(sesonImageVersion);
	}

	/**
	* Returns the tv show ID of this season.
	*
	* @return the tv show ID of this season
	*/
	@Override
	public long getTvShowId() {
		return _season.getTvShowId();
	}

	/**
	* Sets the tv show ID of this season.
	*
	* @param tvShowId the tv show ID of this season
	*/
	@Override
	public void setTvShowId(long tvShowId) {
		_season.setTvShowId(tvShowId);
	}

	@Override
	public boolean isNew() {
		return _season.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_season.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _season.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_season.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _season.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _season.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_season.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _season.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_season.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_season.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_season.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SeasonWrapper((Season)_season.clone());
	}

	@Override
	public int compareTo(hu.webtown.liferay.portlet.model.Season season) {
		return _season.compareTo(season);
	}

	@Override
	public int hashCode() {
		return _season.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<hu.webtown.liferay.portlet.model.Season> toCacheModel() {
		return _season.toCacheModel();
	}

	@Override
	public hu.webtown.liferay.portlet.model.Season toEscapedModel() {
		return new SeasonWrapper(_season.toEscapedModel());
	}

	@Override
	public hu.webtown.liferay.portlet.model.Season toUnescapedModel() {
		return new SeasonWrapper(_season.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _season.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _season.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_season.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SeasonWrapper)) {
			return false;
		}

		SeasonWrapper seasonWrapper = (SeasonWrapper)obj;

		if (Validator.equals(_season, seasonWrapper._season)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Season getWrappedSeason() {
		return _season;
	}

	@Override
	public Season getWrappedModel() {
		return _season;
	}

	@Override
	public void resetOriginalValues() {
		_season.resetOriginalValues();
	}

	private Season _season;
}