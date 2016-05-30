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

package hu.webtown.liferay.portlet.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import hu.webtown.liferay.portlet.model.Season;
import hu.webtown.liferay.portlet.model.SeasonModel;
import hu.webtown.liferay.portlet.model.SeasonSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Season service. Represents a row in the &quot;TvT_Season&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link hu.webtown.liferay.portlet.model.SeasonModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SeasonImpl}.
 * </p>
 *
 * @author czeni
 * @see SeasonImpl
 * @see hu.webtown.liferay.portlet.model.Season
 * @see hu.webtown.liferay.portlet.model.SeasonModel
 * @generated
 */
@JSON(strict = true)
public class SeasonModelImpl extends BaseModelImpl<Season>
	implements SeasonModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a season model instance should use the {@link hu.webtown.liferay.portlet.model.Season} interface instead.
	 */
	public static final String TABLE_NAME = "TvT_Season";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "seasonId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "seasonTitle", Types.VARCHAR },
			{ "seasonPremierDate", Types.TIMESTAMP },
			{ "seasonNumber", Types.INTEGER },
			{ "seasonDescription", Types.VARCHAR },
			{ "seasonImageUrl", Types.VARCHAR },
			{ "seasonImageUuid", Types.VARCHAR },
			{ "seasonImageTitle", Types.VARCHAR },
			{ "sesonImageVersion", Types.VARCHAR },
			{ "tvShowId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table TvT_Season (uuid_ VARCHAR(75) null,seasonId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,seasonTitle VARCHAR(75) null,seasonPremierDate DATE null,seasonNumber INTEGER,seasonDescription VARCHAR(75) null,seasonImageUrl VARCHAR(75) null,seasonImageUuid VARCHAR(75) null,seasonImageTitle VARCHAR(75) null,sesonImageVersion VARCHAR(75) null,tvShowId LONG)";
	public static final String TABLE_SQL_DROP = "drop table TvT_Season";
	public static final String ORDER_BY_JPQL = " ORDER BY season.seasonNumber ASC";
	public static final String ORDER_BY_SQL = " ORDER BY TvT_Season.seasonNumber ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.hu.webtown.liferay.portlet.model.Season"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.hu.webtown.liferay.portlet.model.Season"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.hu.webtown.liferay.portlet.model.Season"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long SEASONID_COLUMN_BITMASK = 4L;
	public static long TVSHOWID_COLUMN_BITMASK = 8L;
	public static long UUID_COLUMN_BITMASK = 16L;
	public static long SEASONNUMBER_COLUMN_BITMASK = 32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Season toModel(SeasonSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Season model = new SeasonImpl();

		model.setUuid(soapModel.getUuid());
		model.setSeasonId(soapModel.getSeasonId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setSeasonTitle(soapModel.getSeasonTitle());
		model.setSeasonPremierDate(soapModel.getSeasonPremierDate());
		model.setSeasonNumber(soapModel.getSeasonNumber());
		model.setSeasonDescription(soapModel.getSeasonDescription());
		model.setSeasonImageUrl(soapModel.getSeasonImageUrl());
		model.setSeasonImageUuid(soapModel.getSeasonImageUuid());
		model.setSeasonImageTitle(soapModel.getSeasonImageTitle());
		model.setSesonImageVersion(soapModel.getSesonImageVersion());
		model.setTvShowId(soapModel.getTvShowId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Season> toModels(SeasonSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Season> models = new ArrayList<Season>(soapModels.length);

		for (SeasonSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.hu.webtown.liferay.portlet.model.Season"));

	public SeasonModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _seasonId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSeasonId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _seasonId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("uuid", getUuid());
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
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

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

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getSeasonId() {
		return _seasonId;
	}

	@Override
	public void setSeasonId(long seasonId) {
		_columnBitmask |= SEASONID_COLUMN_BITMASK;

		if (!_setOriginalSeasonId) {
			_setOriginalSeasonId = true;

			_originalSeasonId = _seasonId;
		}

		_seasonId = seasonId;
	}

	public long getOriginalSeasonId() {
		return _originalSeasonId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getSeasonTitle() {
		if (_seasonTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _seasonTitle;
		}
	}

	@Override
	public void setSeasonTitle(String seasonTitle) {
		_seasonTitle = seasonTitle;
	}

	@JSON
	@Override
	public Date getSeasonPremierDate() {
		return _seasonPremierDate;
	}

	@Override
	public void setSeasonPremierDate(Date seasonPremierDate) {
		_seasonPremierDate = seasonPremierDate;
	}

	@JSON
	@Override
	public int getSeasonNumber() {
		return _seasonNumber;
	}

	@Override
	public void setSeasonNumber(int seasonNumber) {
		_columnBitmask = -1L;

		_seasonNumber = seasonNumber;
	}

	@JSON
	@Override
	public String getSeasonDescription() {
		if (_seasonDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _seasonDescription;
		}
	}

	@Override
	public void setSeasonDescription(String seasonDescription) {
		_seasonDescription = seasonDescription;
	}

	@JSON
	@Override
	public String getSeasonImageUrl() {
		if (_seasonImageUrl == null) {
			return StringPool.BLANK;
		}
		else {
			return _seasonImageUrl;
		}
	}

	@Override
	public void setSeasonImageUrl(String seasonImageUrl) {
		_seasonImageUrl = seasonImageUrl;
	}

	@JSON
	@Override
	public String getSeasonImageUuid() {
		if (_seasonImageUuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _seasonImageUuid;
		}
	}

	@Override
	public void setSeasonImageUuid(String seasonImageUuid) {
		_seasonImageUuid = seasonImageUuid;
	}

	@JSON
	@Override
	public String getSeasonImageTitle() {
		if (_seasonImageTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _seasonImageTitle;
		}
	}

	@Override
	public void setSeasonImageTitle(String seasonImageTitle) {
		_seasonImageTitle = seasonImageTitle;
	}

	@JSON
	@Override
	public String getSesonImageVersion() {
		if (_sesonImageVersion == null) {
			return StringPool.BLANK;
		}
		else {
			return _sesonImageVersion;
		}
	}

	@Override
	public void setSesonImageVersion(String sesonImageVersion) {
		_sesonImageVersion = sesonImageVersion;
	}

	@JSON
	@Override
	public long getTvShowId() {
		return _tvShowId;
	}

	@Override
	public void setTvShowId(long tvShowId) {
		_columnBitmask |= TVSHOWID_COLUMN_BITMASK;

		if (!_setOriginalTvShowId) {
			_setOriginalTvShowId = true;

			_originalTvShowId = _tvShowId;
		}

		_tvShowId = tvShowId;
	}

	public long getOriginalTvShowId() {
		return _originalTvShowId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Season.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Season.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Season toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Season)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SeasonImpl seasonImpl = new SeasonImpl();

		seasonImpl.setUuid(getUuid());
		seasonImpl.setSeasonId(getSeasonId());
		seasonImpl.setGroupId(getGroupId());
		seasonImpl.setCompanyId(getCompanyId());
		seasonImpl.setUserId(getUserId());
		seasonImpl.setUserName(getUserName());
		seasonImpl.setCreateDate(getCreateDate());
		seasonImpl.setModifiedDate(getModifiedDate());
		seasonImpl.setSeasonTitle(getSeasonTitle());
		seasonImpl.setSeasonPremierDate(getSeasonPremierDate());
		seasonImpl.setSeasonNumber(getSeasonNumber());
		seasonImpl.setSeasonDescription(getSeasonDescription());
		seasonImpl.setSeasonImageUrl(getSeasonImageUrl());
		seasonImpl.setSeasonImageUuid(getSeasonImageUuid());
		seasonImpl.setSeasonImageTitle(getSeasonImageTitle());
		seasonImpl.setSesonImageVersion(getSesonImageVersion());
		seasonImpl.setTvShowId(getTvShowId());

		seasonImpl.resetOriginalValues();

		return seasonImpl;
	}

	@Override
	public int compareTo(Season season) {
		int value = 0;

		if (getSeasonNumber() < season.getSeasonNumber()) {
			value = -1;
		}
		else if (getSeasonNumber() > season.getSeasonNumber()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Season)) {
			return false;
		}

		Season season = (Season)obj;

		long primaryKey = season.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		SeasonModelImpl seasonModelImpl = this;

		seasonModelImpl._originalUuid = seasonModelImpl._uuid;

		seasonModelImpl._originalSeasonId = seasonModelImpl._seasonId;

		seasonModelImpl._setOriginalSeasonId = false;

		seasonModelImpl._originalGroupId = seasonModelImpl._groupId;

		seasonModelImpl._setOriginalGroupId = false;

		seasonModelImpl._originalCompanyId = seasonModelImpl._companyId;

		seasonModelImpl._setOriginalCompanyId = false;

		seasonModelImpl._originalTvShowId = seasonModelImpl._tvShowId;

		seasonModelImpl._setOriginalTvShowId = false;

		seasonModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Season> toCacheModel() {
		SeasonCacheModel seasonCacheModel = new SeasonCacheModel();

		seasonCacheModel.uuid = getUuid();

		String uuid = seasonCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			seasonCacheModel.uuid = null;
		}

		seasonCacheModel.seasonId = getSeasonId();

		seasonCacheModel.groupId = getGroupId();

		seasonCacheModel.companyId = getCompanyId();

		seasonCacheModel.userId = getUserId();

		seasonCacheModel.userName = getUserName();

		String userName = seasonCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			seasonCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			seasonCacheModel.createDate = createDate.getTime();
		}
		else {
			seasonCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			seasonCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			seasonCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		seasonCacheModel.seasonTitle = getSeasonTitle();

		String seasonTitle = seasonCacheModel.seasonTitle;

		if ((seasonTitle != null) && (seasonTitle.length() == 0)) {
			seasonCacheModel.seasonTitle = null;
		}

		Date seasonPremierDate = getSeasonPremierDate();

		if (seasonPremierDate != null) {
			seasonCacheModel.seasonPremierDate = seasonPremierDate.getTime();
		}
		else {
			seasonCacheModel.seasonPremierDate = Long.MIN_VALUE;
		}

		seasonCacheModel.seasonNumber = getSeasonNumber();

		seasonCacheModel.seasonDescription = getSeasonDescription();

		String seasonDescription = seasonCacheModel.seasonDescription;

		if ((seasonDescription != null) && (seasonDescription.length() == 0)) {
			seasonCacheModel.seasonDescription = null;
		}

		seasonCacheModel.seasonImageUrl = getSeasonImageUrl();

		String seasonImageUrl = seasonCacheModel.seasonImageUrl;

		if ((seasonImageUrl != null) && (seasonImageUrl.length() == 0)) {
			seasonCacheModel.seasonImageUrl = null;
		}

		seasonCacheModel.seasonImageUuid = getSeasonImageUuid();

		String seasonImageUuid = seasonCacheModel.seasonImageUuid;

		if ((seasonImageUuid != null) && (seasonImageUuid.length() == 0)) {
			seasonCacheModel.seasonImageUuid = null;
		}

		seasonCacheModel.seasonImageTitle = getSeasonImageTitle();

		String seasonImageTitle = seasonCacheModel.seasonImageTitle;

		if ((seasonImageTitle != null) && (seasonImageTitle.length() == 0)) {
			seasonCacheModel.seasonImageTitle = null;
		}

		seasonCacheModel.sesonImageVersion = getSesonImageVersion();

		String sesonImageVersion = seasonCacheModel.sesonImageVersion;

		if ((sesonImageVersion != null) && (sesonImageVersion.length() == 0)) {
			seasonCacheModel.sesonImageVersion = null;
		}

		seasonCacheModel.tvShowId = getTvShowId();

		return seasonCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", seasonId=");
		sb.append(getSeasonId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", seasonTitle=");
		sb.append(getSeasonTitle());
		sb.append(", seasonPremierDate=");
		sb.append(getSeasonPremierDate());
		sb.append(", seasonNumber=");
		sb.append(getSeasonNumber());
		sb.append(", seasonDescription=");
		sb.append(getSeasonDescription());
		sb.append(", seasonImageUrl=");
		sb.append(getSeasonImageUrl());
		sb.append(", seasonImageUuid=");
		sb.append(getSeasonImageUuid());
		sb.append(", seasonImageTitle=");
		sb.append(getSeasonImageTitle());
		sb.append(", sesonImageVersion=");
		sb.append(getSesonImageVersion());
		sb.append(", tvShowId=");
		sb.append(getTvShowId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("hu.webtown.liferay.portlet.model.Season");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seasonId</column-name><column-value><![CDATA[");
		sb.append(getSeasonId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seasonTitle</column-name><column-value><![CDATA[");
		sb.append(getSeasonTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seasonPremierDate</column-name><column-value><![CDATA[");
		sb.append(getSeasonPremierDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seasonNumber</column-name><column-value><![CDATA[");
		sb.append(getSeasonNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seasonDescription</column-name><column-value><![CDATA[");
		sb.append(getSeasonDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seasonImageUrl</column-name><column-value><![CDATA[");
		sb.append(getSeasonImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seasonImageUuid</column-name><column-value><![CDATA[");
		sb.append(getSeasonImageUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seasonImageTitle</column-name><column-value><![CDATA[");
		sb.append(getSeasonImageTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sesonImageVersion</column-name><column-value><![CDATA[");
		sb.append(getSesonImageVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tvShowId</column-name><column-value><![CDATA[");
		sb.append(getTvShowId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Season.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Season.class };
	private String _uuid;
	private String _originalUuid;
	private long _seasonId;
	private long _originalSeasonId;
	private boolean _setOriginalSeasonId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _seasonTitle;
	private Date _seasonPremierDate;
	private int _seasonNumber;
	private String _seasonDescription;
	private String _seasonImageUrl;
	private String _seasonImageUuid;
	private String _seasonImageTitle;
	private String _sesonImageVersion;
	private long _tvShowId;
	private long _originalTvShowId;
	private boolean _setOriginalTvShowId;
	private long _columnBitmask;
	private Season _escapedModel;
}