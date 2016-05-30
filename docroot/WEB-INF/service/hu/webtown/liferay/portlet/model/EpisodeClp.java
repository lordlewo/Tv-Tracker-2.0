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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import hu.webtown.liferay.portlet.service.ClpSerializer;
import hu.webtown.liferay.portlet.service.EpisodeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czeni
 */
public class EpisodeClp extends BaseModelImpl<Episode> implements Episode {
	public EpisodeClp() {
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
	public long getPrimaryKey() {
		return _episodeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEpisodeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _episodeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
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
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_episodeRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEpisodeId() {
		return _episodeId;
	}

	@Override
	public void setEpisodeId(long episodeId) {
		_episodeId = episodeId;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setEpisodeId", long.class);

				method.invoke(_episodeRemoteModel, episodeId);
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

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_episodeRemoteModel, groupId);
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

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_episodeRemoteModel, companyId);
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

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_episodeRemoteModel, userId);
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

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_episodeRemoteModel, userName);
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

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_episodeRemoteModel, createDate);
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

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_episodeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEpisodeTitle() {
		return _episodeTitle;
	}

	@Override
	public void setEpisodeTitle(String episodeTitle) {
		_episodeTitle = episodeTitle;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setEpisodeTitle", String.class);

				method.invoke(_episodeRemoteModel, episodeTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEpisodeAirDate() {
		return _episodeAirDate;
	}

	@Override
	public void setEpisodeAirDate(Date episodeAirDate) {
		_episodeAirDate = episodeAirDate;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setEpisodeAirDate", Date.class);

				method.invoke(_episodeRemoteModel, episodeAirDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getEpisodeNumber() {
		return _episodeNumber;
	}

	@Override
	public void setEpisodeNumber(int episodeNumber) {
		_episodeNumber = episodeNumber;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setEpisodeNumber", int.class);

				method.invoke(_episodeRemoteModel, episodeNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEpisodeDescription() {
		return _episodeDescription;
	}

	@Override
	public void setEpisodeDescription(String episodeDescription) {
		_episodeDescription = episodeDescription;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setEpisodeDescription",
						String.class);

				method.invoke(_episodeRemoteModel, episodeDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEpisodeImageUrl() {
		return _episodeImageUrl;
	}

	@Override
	public void setEpisodeImageUrl(String episodeImageUrl) {
		_episodeImageUrl = episodeImageUrl;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setEpisodeImageUrl",
						String.class);

				method.invoke(_episodeRemoteModel, episodeImageUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEpisodeImageUuid() {
		return _episodeImageUuid;
	}

	@Override
	public void setEpisodeImageUuid(String episodeImageUuid) {
		_episodeImageUuid = episodeImageUuid;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setEpisodeImageUuid",
						String.class);

				method.invoke(_episodeRemoteModel, episodeImageUuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEpisodeImageTitle() {
		return _episodeImageTitle;
	}

	@Override
	public void setEpisodeImageTitle(String episodeImageTitle) {
		_episodeImageTitle = episodeImageTitle;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setEpisodeImageTitle",
						String.class);

				method.invoke(_episodeRemoteModel, episodeImageTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEpisodeImageVersion() {
		return _episodeImageVersion;
	}

	@Override
	public void setEpisodeImageVersion(String episodeImageVersion) {
		_episodeImageVersion = episodeImageVersion;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setEpisodeImageVersion",
						String.class);

				method.invoke(_episodeRemoteModel, episodeImageVersion);
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

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setSeasonId", long.class);

				method.invoke(_episodeRemoteModel, seasonId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Episode.class.getName()));
	}

	public BaseModel<?> getEpisodeRemoteModel() {
		return _episodeRemoteModel;
	}

	public void setEpisodeRemoteModel(BaseModel<?> episodeRemoteModel) {
		_episodeRemoteModel = episodeRemoteModel;
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

		Class<?> remoteModelClass = _episodeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_episodeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EpisodeLocalServiceUtil.addEpisode(this);
		}
		else {
			EpisodeLocalServiceUtil.updateEpisode(this);
		}
	}

	@Override
	public Episode toEscapedModel() {
		return (Episode)ProxyUtil.newProxyInstance(Episode.class.getClassLoader(),
			new Class[] { Episode.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EpisodeClp clone = new EpisodeClp();

		clone.setUuid(getUuid());
		clone.setEpisodeId(getEpisodeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setEpisodeTitle(getEpisodeTitle());
		clone.setEpisodeAirDate(getEpisodeAirDate());
		clone.setEpisodeNumber(getEpisodeNumber());
		clone.setEpisodeDescription(getEpisodeDescription());
		clone.setEpisodeImageUrl(getEpisodeImageUrl());
		clone.setEpisodeImageUuid(getEpisodeImageUuid());
		clone.setEpisodeImageTitle(getEpisodeImageTitle());
		clone.setEpisodeImageVersion(getEpisodeImageVersion());
		clone.setSeasonId(getSeasonId());

		return clone;
	}

	@Override
	public int compareTo(Episode episode) {
		int value = 0;

		value = DateUtil.compareTo(getEpisodeAirDate(),
				episode.getEpisodeAirDate());

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

		if (!(obj instanceof EpisodeClp)) {
			return false;
		}

		EpisodeClp episode = (EpisodeClp)obj;

		long primaryKey = episode.getPrimaryKey();

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
		sb.append(", episodeId=");
		sb.append(getEpisodeId());
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
		sb.append(", episodeTitle=");
		sb.append(getEpisodeTitle());
		sb.append(", episodeAirDate=");
		sb.append(getEpisodeAirDate());
		sb.append(", episodeNumber=");
		sb.append(getEpisodeNumber());
		sb.append(", episodeDescription=");
		sb.append(getEpisodeDescription());
		sb.append(", episodeImageUrl=");
		sb.append(getEpisodeImageUrl());
		sb.append(", episodeImageUuid=");
		sb.append(getEpisodeImageUuid());
		sb.append(", episodeImageTitle=");
		sb.append(getEpisodeImageTitle());
		sb.append(", episodeImageVersion=");
		sb.append(getEpisodeImageVersion());
		sb.append(", seasonId=");
		sb.append(getSeasonId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("hu.webtown.liferay.portlet.model.Episode");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>episodeId</column-name><column-value><![CDATA[");
		sb.append(getEpisodeId());
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
			"<column><column-name>episodeTitle</column-name><column-value><![CDATA[");
		sb.append(getEpisodeTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>episodeAirDate</column-name><column-value><![CDATA[");
		sb.append(getEpisodeAirDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>episodeNumber</column-name><column-value><![CDATA[");
		sb.append(getEpisodeNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>episodeDescription</column-name><column-value><![CDATA[");
		sb.append(getEpisodeDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>episodeImageUrl</column-name><column-value><![CDATA[");
		sb.append(getEpisodeImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>episodeImageUuid</column-name><column-value><![CDATA[");
		sb.append(getEpisodeImageUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>episodeImageTitle</column-name><column-value><![CDATA[");
		sb.append(getEpisodeImageTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>episodeImageVersion</column-name><column-value><![CDATA[");
		sb.append(getEpisodeImageVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seasonId</column-name><column-value><![CDATA[");
		sb.append(getSeasonId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _episodeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _episodeTitle;
	private Date _episodeAirDate;
	private int _episodeNumber;
	private String _episodeDescription;
	private String _episodeImageUrl;
	private String _episodeImageUuid;
	private String _episodeImageTitle;
	private String _episodeImageVersion;
	private long _seasonId;
	private BaseModel<?> _episodeRemoteModel;
	private Class<?> _clpSerializerClass = hu.webtown.liferay.portlet.service.ClpSerializer.class;
}