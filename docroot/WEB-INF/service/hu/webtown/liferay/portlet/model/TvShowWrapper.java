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
 * This class is a wrapper for {@link TvShow}.
 * </p>
 *
 * @author czeni
 * @see TvShow
 * @generated
 */
public class TvShowWrapper implements TvShow, ModelWrapper<TvShow> {
	public TvShowWrapper(TvShow tvShow) {
		_tvShow = tvShow;
	}

	@Override
	public Class<?> getModelClass() {
		return TvShow.class;
	}

	@Override
	public String getModelClassName() {
		return TvShow.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tvShowId", getTvShowId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("tvShowTitle", getTvShowTitle());
		attributes.put("tvShowPremierDate", getTvShowPremierDate());
		attributes.put("tvShowDescription", getTvShowDescription());
		attributes.put("tvShowImageUrl", getTvShowImageUrl());
		attributes.put("tvShowImageUuid", getTvShowImageUuid());
		attributes.put("tvShowImageTitle", getTvShowImageTitle());
		attributes.put("tvShowImageVersion", getTvShowImageVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tvShowId = (Long)attributes.get("tvShowId");

		if (tvShowId != null) {
			setTvShowId(tvShowId);
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

		String tvShowTitle = (String)attributes.get("tvShowTitle");

		if (tvShowTitle != null) {
			setTvShowTitle(tvShowTitle);
		}

		Date tvShowPremierDate = (Date)attributes.get("tvShowPremierDate");

		if (tvShowPremierDate != null) {
			setTvShowPremierDate(tvShowPremierDate);
		}

		String tvShowDescription = (String)attributes.get("tvShowDescription");

		if (tvShowDescription != null) {
			setTvShowDescription(tvShowDescription);
		}

		String tvShowImageUrl = (String)attributes.get("tvShowImageUrl");

		if (tvShowImageUrl != null) {
			setTvShowImageUrl(tvShowImageUrl);
		}

		String tvShowImageUuid = (String)attributes.get("tvShowImageUuid");

		if (tvShowImageUuid != null) {
			setTvShowImageUuid(tvShowImageUuid);
		}

		String tvShowImageTitle = (String)attributes.get("tvShowImageTitle");

		if (tvShowImageTitle != null) {
			setTvShowImageTitle(tvShowImageTitle);
		}

		String tvShowImageVersion = (String)attributes.get("tvShowImageVersion");

		if (tvShowImageVersion != null) {
			setTvShowImageVersion(tvShowImageVersion);
		}
	}

	/**
	* Returns the primary key of this tv show.
	*
	* @return the primary key of this tv show
	*/
	@Override
	public long getPrimaryKey() {
		return _tvShow.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tv show.
	*
	* @param primaryKey the primary key of this tv show
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tvShow.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tv show ID of this tv show.
	*
	* @return the tv show ID of this tv show
	*/
	@Override
	public long getTvShowId() {
		return _tvShow.getTvShowId();
	}

	/**
	* Sets the tv show ID of this tv show.
	*
	* @param tvShowId the tv show ID of this tv show
	*/
	@Override
	public void setTvShowId(long tvShowId) {
		_tvShow.setTvShowId(tvShowId);
	}

	/**
	* Returns the group ID of this tv show.
	*
	* @return the group ID of this tv show
	*/
	@Override
	public long getGroupId() {
		return _tvShow.getGroupId();
	}

	/**
	* Sets the group ID of this tv show.
	*
	* @param groupId the group ID of this tv show
	*/
	@Override
	public void setGroupId(long groupId) {
		_tvShow.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this tv show.
	*
	* @return the company ID of this tv show
	*/
	@Override
	public long getCompanyId() {
		return _tvShow.getCompanyId();
	}

	/**
	* Sets the company ID of this tv show.
	*
	* @param companyId the company ID of this tv show
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tvShow.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this tv show.
	*
	* @return the user ID of this tv show
	*/
	@Override
	public long getUserId() {
		return _tvShow.getUserId();
	}

	/**
	* Sets the user ID of this tv show.
	*
	* @param userId the user ID of this tv show
	*/
	@Override
	public void setUserId(long userId) {
		_tvShow.setUserId(userId);
	}

	/**
	* Returns the user uuid of this tv show.
	*
	* @return the user uuid of this tv show
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShow.getUserUuid();
	}

	/**
	* Sets the user uuid of this tv show.
	*
	* @param userUuid the user uuid of this tv show
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tvShow.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this tv show.
	*
	* @return the user name of this tv show
	*/
	@Override
	public java.lang.String getUserName() {
		return _tvShow.getUserName();
	}

	/**
	* Sets the user name of this tv show.
	*
	* @param userName the user name of this tv show
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_tvShow.setUserName(userName);
	}

	/**
	* Returns the create date of this tv show.
	*
	* @return the create date of this tv show
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _tvShow.getCreateDate();
	}

	/**
	* Sets the create date of this tv show.
	*
	* @param createDate the create date of this tv show
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_tvShow.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this tv show.
	*
	* @return the modified date of this tv show
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _tvShow.getModifiedDate();
	}

	/**
	* Sets the modified date of this tv show.
	*
	* @param modifiedDate the modified date of this tv show
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tvShow.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the tv show title of this tv show.
	*
	* @return the tv show title of this tv show
	*/
	@Override
	public java.lang.String getTvShowTitle() {
		return _tvShow.getTvShowTitle();
	}

	/**
	* Sets the tv show title of this tv show.
	*
	* @param tvShowTitle the tv show title of this tv show
	*/
	@Override
	public void setTvShowTitle(java.lang.String tvShowTitle) {
		_tvShow.setTvShowTitle(tvShowTitle);
	}

	/**
	* Returns the tv show premier date of this tv show.
	*
	* @return the tv show premier date of this tv show
	*/
	@Override
	public java.util.Date getTvShowPremierDate() {
		return _tvShow.getTvShowPremierDate();
	}

	/**
	* Sets the tv show premier date of this tv show.
	*
	* @param tvShowPremierDate the tv show premier date of this tv show
	*/
	@Override
	public void setTvShowPremierDate(java.util.Date tvShowPremierDate) {
		_tvShow.setTvShowPremierDate(tvShowPremierDate);
	}

	/**
	* Returns the tv show description of this tv show.
	*
	* @return the tv show description of this tv show
	*/
	@Override
	public java.lang.String getTvShowDescription() {
		return _tvShow.getTvShowDescription();
	}

	/**
	* Sets the tv show description of this tv show.
	*
	* @param tvShowDescription the tv show description of this tv show
	*/
	@Override
	public void setTvShowDescription(java.lang.String tvShowDescription) {
		_tvShow.setTvShowDescription(tvShowDescription);
	}

	/**
	* Returns the tv show image url of this tv show.
	*
	* @return the tv show image url of this tv show
	*/
	@Override
	public java.lang.String getTvShowImageUrl() {
		return _tvShow.getTvShowImageUrl();
	}

	/**
	* Sets the tv show image url of this tv show.
	*
	* @param tvShowImageUrl the tv show image url of this tv show
	*/
	@Override
	public void setTvShowImageUrl(java.lang.String tvShowImageUrl) {
		_tvShow.setTvShowImageUrl(tvShowImageUrl);
	}

	/**
	* Returns the tv show image uuid of this tv show.
	*
	* @return the tv show image uuid of this tv show
	*/
	@Override
	public java.lang.String getTvShowImageUuid() {
		return _tvShow.getTvShowImageUuid();
	}

	/**
	* Sets the tv show image uuid of this tv show.
	*
	* @param tvShowImageUuid the tv show image uuid of this tv show
	*/
	@Override
	public void setTvShowImageUuid(java.lang.String tvShowImageUuid) {
		_tvShow.setTvShowImageUuid(tvShowImageUuid);
	}

	/**
	* Returns the tv show image title of this tv show.
	*
	* @return the tv show image title of this tv show
	*/
	@Override
	public java.lang.String getTvShowImageTitle() {
		return _tvShow.getTvShowImageTitle();
	}

	/**
	* Sets the tv show image title of this tv show.
	*
	* @param tvShowImageTitle the tv show image title of this tv show
	*/
	@Override
	public void setTvShowImageTitle(java.lang.String tvShowImageTitle) {
		_tvShow.setTvShowImageTitle(tvShowImageTitle);
	}

	/**
	* Returns the tv show image version of this tv show.
	*
	* @return the tv show image version of this tv show
	*/
	@Override
	public java.lang.String getTvShowImageVersion() {
		return _tvShow.getTvShowImageVersion();
	}

	/**
	* Sets the tv show image version of this tv show.
	*
	* @param tvShowImageVersion the tv show image version of this tv show
	*/
	@Override
	public void setTvShowImageVersion(java.lang.String tvShowImageVersion) {
		_tvShow.setTvShowImageVersion(tvShowImageVersion);
	}

	@Override
	public boolean isNew() {
		return _tvShow.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tvShow.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tvShow.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tvShow.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tvShow.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tvShow.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tvShow.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tvShow.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tvShow.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tvShow.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tvShow.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TvShowWrapper((TvShow)_tvShow.clone());
	}

	@Override
	public int compareTo(hu.webtown.liferay.portlet.model.TvShow tvShow) {
		return _tvShow.compareTo(tvShow);
	}

	@Override
	public int hashCode() {
		return _tvShow.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<hu.webtown.liferay.portlet.model.TvShow> toCacheModel() {
		return _tvShow.toCacheModel();
	}

	@Override
	public hu.webtown.liferay.portlet.model.TvShow toEscapedModel() {
		return new TvShowWrapper(_tvShow.toEscapedModel());
	}

	@Override
	public hu.webtown.liferay.portlet.model.TvShow toUnescapedModel() {
		return new TvShowWrapper(_tvShow.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tvShow.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tvShow.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tvShow.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TvShowWrapper)) {
			return false;
		}

		TvShowWrapper tvShowWrapper = (TvShowWrapper)obj;

		if (Validator.equals(_tvShow, tvShowWrapper._tvShow)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TvShow getWrappedTvShow() {
		return _tvShow;
	}

	@Override
	public TvShow getWrappedModel() {
		return _tvShow;
	}

	@Override
	public void resetOriginalValues() {
		_tvShow.resetOriginalValues();
	}

	private TvShow _tvShow;
}