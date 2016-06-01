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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import hu.webtown.liferay.portlet.service.ClpSerializer;
import hu.webtown.liferay.portlet.service.SeasonLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czeni
 */
public class SeasonClp extends BaseModelImpl<Season> implements Season {
	public SeasonClp() {
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
		attributes.put("seasonImageVersion", getSeasonImageVersion());
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

		String seasonImageVersion = (String)attributes.get("seasonImageVersion");

		if (seasonImageVersion != null) {
			setSeasonImageVersion(seasonImageVersion);
		}

		Long tvShowId = (Long)attributes.get("tvShowId");

		if (tvShowId != null) {
			setTvShowId(tvShowId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_seasonRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSeasonId() {
		return _seasonId;
	}

	@Override
	public void setSeasonId(long seasonId) {
		_seasonId = seasonId;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setSeasonId", long.class);

				method.invoke(_seasonRemoteModel, seasonId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_seasonRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_seasonRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_seasonRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_seasonRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_seasonRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_seasonRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSeasonTitle() {
		return _seasonTitle;
	}

	@Override
	public void setSeasonTitle(String seasonTitle) {
		_seasonTitle = seasonTitle;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setSeasonTitle", String.class);

				method.invoke(_seasonRemoteModel, seasonTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSeasonPremierDate() {
		return _seasonPremierDate;
	}

	@Override
	public void setSeasonPremierDate(Date seasonPremierDate) {
		_seasonPremierDate = seasonPremierDate;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setSeasonPremierDate",
						Date.class);

				method.invoke(_seasonRemoteModel, seasonPremierDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSeasonNumber() {
		return _seasonNumber;
	}

	@Override
	public void setSeasonNumber(int seasonNumber) {
		_seasonNumber = seasonNumber;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setSeasonNumber", int.class);

				method.invoke(_seasonRemoteModel, seasonNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSeasonDescription() {
		return _seasonDescription;
	}

	@Override
	public void setSeasonDescription(String seasonDescription) {
		_seasonDescription = seasonDescription;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setSeasonDescription",
						String.class);

				method.invoke(_seasonRemoteModel, seasonDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSeasonImageUrl() {
		return _seasonImageUrl;
	}

	@Override
	public void setSeasonImageUrl(String seasonImageUrl) {
		_seasonImageUrl = seasonImageUrl;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setSeasonImageUrl",
						String.class);

				method.invoke(_seasonRemoteModel, seasonImageUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSeasonImageUuid() {
		return _seasonImageUuid;
	}

	@Override
	public void setSeasonImageUuid(String seasonImageUuid) {
		_seasonImageUuid = seasonImageUuid;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setSeasonImageUuid",
						String.class);

				method.invoke(_seasonRemoteModel, seasonImageUuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSeasonImageTitle() {
		return _seasonImageTitle;
	}

	@Override
	public void setSeasonImageTitle(String seasonImageTitle) {
		_seasonImageTitle = seasonImageTitle;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setSeasonImageTitle",
						String.class);

				method.invoke(_seasonRemoteModel, seasonImageTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSeasonImageVersion() {
		return _seasonImageVersion;
	}

	@Override
	public void setSeasonImageVersion(String seasonImageVersion) {
		_seasonImageVersion = seasonImageVersion;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setSeasonImageVersion",
						String.class);

				method.invoke(_seasonRemoteModel, seasonImageVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTvShowId() {
		return _tvShowId;
	}

	@Override
	public void setTvShowId(long tvShowId) {
		_tvShowId = tvShowId;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setTvShowId", long.class);

				method.invoke(_seasonRemoteModel, tvShowId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setSeasonEpisodeCount(int seasonEpisodeCount) {
		try {
			String methodName = "setSeasonEpisodeCount";

			Class<?>[] parameterTypes = new Class<?>[] { int.class };

			Object[] parameterValues = new Object[] { seasonEpisodeCount };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public int getSeasonEpisodeCount() {
		try {
			String methodName = "getSeasonEpisodeCount";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Integer returnObj = (Integer)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Season.class.getName()));
	}

	public BaseModel<?> getSeasonRemoteModel() {
		return _seasonRemoteModel;
	}

	public void setSeasonRemoteModel(BaseModel<?> seasonRemoteModel) {
		_seasonRemoteModel = seasonRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _seasonRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_seasonRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SeasonLocalServiceUtil.addSeason(this);
		}
		else {
			SeasonLocalServiceUtil.updateSeason(this);
		}
	}

	@Override
	public Season toEscapedModel() {
		return (Season)ProxyUtil.newProxyInstance(Season.class.getClassLoader(),
			new Class[] { Season.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SeasonClp clone = new SeasonClp();

		clone.setUuid(getUuid());
		clone.setSeasonId(getSeasonId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSeasonTitle(getSeasonTitle());
		clone.setSeasonPremierDate(getSeasonPremierDate());
		clone.setSeasonNumber(getSeasonNumber());
		clone.setSeasonDescription(getSeasonDescription());
		clone.setSeasonImageUrl(getSeasonImageUrl());
		clone.setSeasonImageUuid(getSeasonImageUuid());
		clone.setSeasonImageTitle(getSeasonImageTitle());
		clone.setSeasonImageVersion(getSeasonImageVersion());
		clone.setTvShowId(getTvShowId());

		return clone;
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

		if (!(obj instanceof SeasonClp)) {
			return false;
		}

		SeasonClp season = (SeasonClp)obj;

		long primaryKey = season.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
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
		sb.append(", seasonImageVersion=");
		sb.append(getSeasonImageVersion());
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
			"<column><column-name>seasonImageVersion</column-name><column-value><![CDATA[");
		sb.append(getSeasonImageVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tvShowId</column-name><column-value><![CDATA[");
		sb.append(getTvShowId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _seasonId;
	private long _groupId;
	private long _companyId;
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
	private String _seasonImageVersion;
	private long _tvShowId;
	private BaseModel<?> _seasonRemoteModel;
	private Class<?> _clpSerializerClass = hu.webtown.liferay.portlet.service.ClpSerializer.class;
}