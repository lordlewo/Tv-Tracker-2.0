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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedGroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Season service. Represents a row in the &quot;TvT_Season&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link hu.webtown.liferay.portlet.model.impl.SeasonModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link hu.webtown.liferay.portlet.model.impl.SeasonImpl}.
 * </p>
 *
 * @author czeni
 * @see Season
 * @see hu.webtown.liferay.portlet.model.impl.SeasonImpl
 * @see hu.webtown.liferay.portlet.model.impl.SeasonModelImpl
 * @generated
 */
public interface SeasonModel extends BaseModel<Season>, StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a season model instance should use the {@link Season} interface instead.
	 */

	/**
	 * Returns the primary key of this season.
	 *
	 * @return the primary key of this season
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this season.
	 *
	 * @param primaryKey the primary key of this season
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this season.
	 *
	 * @return the uuid of this season
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this season.
	 *
	 * @param uuid the uuid of this season
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the season ID of this season.
	 *
	 * @return the season ID of this season
	 */
	public long getSeasonId();

	/**
	 * Sets the season ID of this season.
	 *
	 * @param seasonId the season ID of this season
	 */
	public void setSeasonId(long seasonId);

	/**
	 * Returns the group ID of this season.
	 *
	 * @return the group ID of this season
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this season.
	 *
	 * @param groupId the group ID of this season
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this season.
	 *
	 * @return the company ID of this season
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this season.
	 *
	 * @param companyId the company ID of this season
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this season.
	 *
	 * @return the user ID of this season
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this season.
	 *
	 * @param userId the user ID of this season
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this season.
	 *
	 * @return the user uuid of this season
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this season.
	 *
	 * @param userUuid the user uuid of this season
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this season.
	 *
	 * @return the user name of this season
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this season.
	 *
	 * @param userName the user name of this season
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this season.
	 *
	 * @return the create date of this season
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this season.
	 *
	 * @param createDate the create date of this season
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this season.
	 *
	 * @return the modified date of this season
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this season.
	 *
	 * @param modifiedDate the modified date of this season
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the season title of this season.
	 *
	 * @return the season title of this season
	 */
	@AutoEscape
	public String getSeasonTitle();

	/**
	 * Sets the season title of this season.
	 *
	 * @param seasonTitle the season title of this season
	 */
	public void setSeasonTitle(String seasonTitle);

	/**
	 * Returns the season premier date of this season.
	 *
	 * @return the season premier date of this season
	 */
	public Date getSeasonPremierDate();

	/**
	 * Sets the season premier date of this season.
	 *
	 * @param seasonPremierDate the season premier date of this season
	 */
	public void setSeasonPremierDate(Date seasonPremierDate);

	/**
	 * Returns the season number of this season.
	 *
	 * @return the season number of this season
	 */
	public int getSeasonNumber();

	/**
	 * Sets the season number of this season.
	 *
	 * @param seasonNumber the season number of this season
	 */
	public void setSeasonNumber(int seasonNumber);

	/**
	 * Returns the season description of this season.
	 *
	 * @return the season description of this season
	 */
	@AutoEscape
	public String getSeasonDescription();

	/**
	 * Sets the season description of this season.
	 *
	 * @param seasonDescription the season description of this season
	 */
	public void setSeasonDescription(String seasonDescription);

	/**
	 * Returns the season image url of this season.
	 *
	 * @return the season image url of this season
	 */
	@AutoEscape
	public String getSeasonImageUrl();

	/**
	 * Sets the season image url of this season.
	 *
	 * @param seasonImageUrl the season image url of this season
	 */
	public void setSeasonImageUrl(String seasonImageUrl);

	/**
	 * Returns the season image uuid of this season.
	 *
	 * @return the season image uuid of this season
	 */
	@AutoEscape
	public String getSeasonImageUuid();

	/**
	 * Sets the season image uuid of this season.
	 *
	 * @param seasonImageUuid the season image uuid of this season
	 */
	public void setSeasonImageUuid(String seasonImageUuid);

	/**
	 * Returns the season image title of this season.
	 *
	 * @return the season image title of this season
	 */
	@AutoEscape
	public String getSeasonImageTitle();

	/**
	 * Sets the season image title of this season.
	 *
	 * @param seasonImageTitle the season image title of this season
	 */
	public void setSeasonImageTitle(String seasonImageTitle);

	/**
	 * Returns the season image version of this season.
	 *
	 * @return the season image version of this season
	 */
	@AutoEscape
	public String getSeasonImageVersion();

	/**
	 * Sets the season image version of this season.
	 *
	 * @param seasonImageVersion the season image version of this season
	 */
	public void setSeasonImageVersion(String seasonImageVersion);

	/**
	 * Returns the tv show ID of this season.
	 *
	 * @return the tv show ID of this season
	 */
	public long getTvShowId();

	/**
	 * Sets the tv show ID of this season.
	 *
	 * @param tvShowId the tv show ID of this season
	 */
	public void setTvShowId(long tvShowId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(hu.webtown.liferay.portlet.model.Season season);

	@Override
	public int hashCode();

	@Override
	public CacheModel<hu.webtown.liferay.portlet.model.Season> toCacheModel();

	@Override
	public hu.webtown.liferay.portlet.model.Season toEscapedModel();

	@Override
	public hu.webtown.liferay.portlet.model.Season toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}