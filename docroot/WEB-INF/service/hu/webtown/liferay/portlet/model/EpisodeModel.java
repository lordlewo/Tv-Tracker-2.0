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
 * The base model interface for the Episode service. Represents a row in the &quot;TvT_Episode&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link hu.webtown.liferay.portlet.model.impl.EpisodeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link hu.webtown.liferay.portlet.model.impl.EpisodeImpl}.
 * </p>
 *
 * @author czeni
 * @see Episode
 * @see hu.webtown.liferay.portlet.model.impl.EpisodeImpl
 * @see hu.webtown.liferay.portlet.model.impl.EpisodeModelImpl
 * @generated
 */
public interface EpisodeModel extends BaseModel<Episode>, StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a episode model instance should use the {@link Episode} interface instead.
	 */

	/**
	 * Returns the primary key of this episode.
	 *
	 * @return the primary key of this episode
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this episode.
	 *
	 * @param primaryKey the primary key of this episode
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this episode.
	 *
	 * @return the uuid of this episode
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this episode.
	 *
	 * @param uuid the uuid of this episode
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the episode ID of this episode.
	 *
	 * @return the episode ID of this episode
	 */
	public long getEpisodeId();

	/**
	 * Sets the episode ID of this episode.
	 *
	 * @param episodeId the episode ID of this episode
	 */
	public void setEpisodeId(long episodeId);

	/**
	 * Returns the group ID of this episode.
	 *
	 * @return the group ID of this episode
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this episode.
	 *
	 * @param groupId the group ID of this episode
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this episode.
	 *
	 * @return the company ID of this episode
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this episode.
	 *
	 * @param companyId the company ID of this episode
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this episode.
	 *
	 * @return the user ID of this episode
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this episode.
	 *
	 * @param userId the user ID of this episode
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this episode.
	 *
	 * @return the user uuid of this episode
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this episode.
	 *
	 * @param userUuid the user uuid of this episode
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this episode.
	 *
	 * @return the user name of this episode
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this episode.
	 *
	 * @param userName the user name of this episode
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this episode.
	 *
	 * @return the create date of this episode
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this episode.
	 *
	 * @param createDate the create date of this episode
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this episode.
	 *
	 * @return the modified date of this episode
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this episode.
	 *
	 * @param modifiedDate the modified date of this episode
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the episode title of this episode.
	 *
	 * @return the episode title of this episode
	 */
	@AutoEscape
	public String getEpisodeTitle();

	/**
	 * Sets the episode title of this episode.
	 *
	 * @param episodeTitle the episode title of this episode
	 */
	public void setEpisodeTitle(String episodeTitle);

	/**
	 * Returns the episode air date of this episode.
	 *
	 * @return the episode air date of this episode
	 */
	public Date getEpisodeAirDate();

	/**
	 * Sets the episode air date of this episode.
	 *
	 * @param episodeAirDate the episode air date of this episode
	 */
	public void setEpisodeAirDate(Date episodeAirDate);

	/**
	 * Returns the episode number of this episode.
	 *
	 * @return the episode number of this episode
	 */
	public int getEpisodeNumber();

	/**
	 * Sets the episode number of this episode.
	 *
	 * @param episodeNumber the episode number of this episode
	 */
	public void setEpisodeNumber(int episodeNumber);

	/**
	 * Returns the episode description of this episode.
	 *
	 * @return the episode description of this episode
	 */
	@AutoEscape
	public String getEpisodeDescription();

	/**
	 * Sets the episode description of this episode.
	 *
	 * @param episodeDescription the episode description of this episode
	 */
	public void setEpisodeDescription(String episodeDescription);

	/**
	 * Returns the episode image url of this episode.
	 *
	 * @return the episode image url of this episode
	 */
	@AutoEscape
	public String getEpisodeImageUrl();

	/**
	 * Sets the episode image url of this episode.
	 *
	 * @param episodeImageUrl the episode image url of this episode
	 */
	public void setEpisodeImageUrl(String episodeImageUrl);

	/**
	 * Returns the episode image uuid of this episode.
	 *
	 * @return the episode image uuid of this episode
	 */
	@AutoEscape
	public String getEpisodeImageUuid();

	/**
	 * Sets the episode image uuid of this episode.
	 *
	 * @param episodeImageUuid the episode image uuid of this episode
	 */
	public void setEpisodeImageUuid(String episodeImageUuid);

	/**
	 * Returns the episode image title of this episode.
	 *
	 * @return the episode image title of this episode
	 */
	@AutoEscape
	public String getEpisodeImageTitle();

	/**
	 * Sets the episode image title of this episode.
	 *
	 * @param episodeImageTitle the episode image title of this episode
	 */
	public void setEpisodeImageTitle(String episodeImageTitle);

	/**
	 * Returns the episode image version of this episode.
	 *
	 * @return the episode image version of this episode
	 */
	@AutoEscape
	public String getEpisodeImageVersion();

	/**
	 * Sets the episode image version of this episode.
	 *
	 * @param episodeImageVersion the episode image version of this episode
	 */
	public void setEpisodeImageVersion(String episodeImageVersion);

	/**
	 * Returns the season ID of this episode.
	 *
	 * @return the season ID of this episode
	 */
	public long getSeasonId();

	/**
	 * Sets the season ID of this episode.
	 *
	 * @param seasonId the season ID of this episode
	 */
	public void setSeasonId(long seasonId);

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
	public int compareTo(hu.webtown.liferay.portlet.model.Episode episode);

	@Override
	public int hashCode();

	@Override
	public CacheModel<hu.webtown.liferay.portlet.model.Episode> toCacheModel();

	@Override
	public hu.webtown.liferay.portlet.model.Episode toEscapedModel();

	@Override
	public hu.webtown.liferay.portlet.model.Episode toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}