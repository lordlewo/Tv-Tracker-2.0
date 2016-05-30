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
import hu.webtown.liferay.portlet.service.TvShowLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czeni
 */
public class TvShowClp extends BaseModelImpl<TvShow> implements TvShow {
	public TvShowClp() {
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
	public long getPrimaryKey() {
		return _tvShowId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTvShowId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tvShowId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
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
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_tvShowRemoteModel != null) {
			try {
				Class<?> clazz = _tvShowRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_tvShowRemoteModel, uuid);
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

		if (_tvShowRemoteModel != null) {
			try {
				Class<?> clazz = _tvShowRemoteModel.getClass();

				Method method = clazz.getMethod("setTvShowId", long.class);

				method.invoke(_tvShowRemoteModel, tvShowId);
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

		if (_tvShowRemoteModel != null) {
			try {
				Class<?> clazz = _tvShowRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_tvShowRemoteModel, groupId);
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

		if (_tvShowRemoteModel != null) {
			try {
				Class<?> clazz = _tvShowRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_tvShowRemoteModel, companyId);
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

		if (_tvShowRemoteModel != null) {
			try {
				Class<?> clazz = _tvShowRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_tvShowRemoteModel, userId);
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

		if (_tvShowRemoteModel != null) {
			try {
				Class<?> clazz = _tvShowRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_tvShowRemoteModel, userName);
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

		if (_tvShowRemoteModel != null) {
			try {
				Class<?> clazz = _tvShowRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_tvShowRemoteModel, createDate);
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

		if (_tvShowRemoteModel != null) {
			try {
				Class<?> clazz = _tvShowRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_tvShowRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTvShowTitle() {
		return _tvShowTitle;
	}

	@Override
	public void setTvShowTitle(String tvShowTitle) {
		_tvShowTitle = tvShowTitle;

		if (_tvShowRemoteModel != null) {
			try {
				Class<?> clazz = _tvShowRemoteModel.getClass();

				Method method = clazz.getMethod("setTvShowTitle", String.class);

				method.invoke(_tvShowRemoteModel, tvShowTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getTvShowPremierDate() {
		return _tvShowPremierDate;
	}

	@Override
	public void setTvShowPremierDate(Date tvShowPremierDate) {
		_tvShowPremierDate = tvShowPremierDate;

		if (_tvShowRemoteModel != null) {
			try {
				Class<?> clazz = _tvShowRemoteModel.getClass();

				Method method = clazz.getMethod("setTvShowPremierDate",
						Date.class);

				method.invoke(_tvShowRemoteModel, tvShowPremierDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTvShowDescription() {
		return _tvShowDescription;
	}

	@Override
	public void setTvShowDescription(String tvShowDescription) {
		_tvShowDescription = tvShowDescription;

		if (_tvShowRemoteModel != null) {
			try {
				Class<?> clazz = _tvShowRemoteModel.getClass();

				Method method = clazz.getMethod("setTvShowDescription",
						String.class);

				method.invoke(_tvShowRemoteModel, tvShowDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTvShowImageUrl() {
		return _tvShowImageUrl;
	}

	@Override
	public void setTvShowImageUrl(String tvShowImageUrl) {
		_tvShowImageUrl = tvShowImageUrl;

		if (_tvShowRemoteModel != null) {
			try {
				Class<?> clazz = _tvShowRemoteModel.getClass();

				Method method = clazz.getMethod("setTvShowImageUrl",
						String.class);

				method.invoke(_tvShowRemoteModel, tvShowImageUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTvShowImageUuid() {
		return _tvShowImageUuid;
	}

	@Override
	public void setTvShowImageUuid(String tvShowImageUuid) {
		_tvShowImageUuid = tvShowImageUuid;

		if (_tvShowRemoteModel != null) {
			try {
				Class<?> clazz = _tvShowRemoteModel.getClass();

				Method method = clazz.getMethod("setTvShowImageUuid",
						String.class);

				method.invoke(_tvShowRemoteModel, tvShowImageUuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTvShowImageTitle() {
		return _tvShowImageTitle;
	}

	@Override
	public void setTvShowImageTitle(String tvShowImageTitle) {
		_tvShowImageTitle = tvShowImageTitle;

		if (_tvShowRemoteModel != null) {
			try {
				Class<?> clazz = _tvShowRemoteModel.getClass();

				Method method = clazz.getMethod("setTvShowImageTitle",
						String.class);

				method.invoke(_tvShowRemoteModel, tvShowImageTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTvShowImageVersion() {
		return _tvShowImageVersion;
	}

	@Override
	public void setTvShowImageVersion(String tvShowImageVersion) {
		_tvShowImageVersion = tvShowImageVersion;

		if (_tvShowRemoteModel != null) {
			try {
				Class<?> clazz = _tvShowRemoteModel.getClass();

				Method method = clazz.getMethod("setTvShowImageVersion",
						String.class);

				method.invoke(_tvShowRemoteModel, tvShowImageVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				TvShow.class.getName()));
	}

	public BaseModel<?> getTvShowRemoteModel() {
		return _tvShowRemoteModel;
	}

	public void setTvShowRemoteModel(BaseModel<?> tvShowRemoteModel) {
		_tvShowRemoteModel = tvShowRemoteModel;
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

		Class<?> remoteModelClass = _tvShowRemoteModel.getClass();

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

		Object returnValue = method.invoke(_tvShowRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TvShowLocalServiceUtil.addTvShow(this);
		}
		else {
			TvShowLocalServiceUtil.updateTvShow(this);
		}
	}

	@Override
	public TvShow toEscapedModel() {
		return (TvShow)ProxyUtil.newProxyInstance(TvShow.class.getClassLoader(),
			new Class[] { TvShow.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TvShowClp clone = new TvShowClp();

		clone.setUuid(getUuid());
		clone.setTvShowId(getTvShowId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTvShowTitle(getTvShowTitle());
		clone.setTvShowPremierDate(getTvShowPremierDate());
		clone.setTvShowDescription(getTvShowDescription());
		clone.setTvShowImageUrl(getTvShowImageUrl());
		clone.setTvShowImageUuid(getTvShowImageUuid());
		clone.setTvShowImageTitle(getTvShowImageTitle());
		clone.setTvShowImageVersion(getTvShowImageVersion());

		return clone;
	}

	@Override
	public int compareTo(TvShow tvShow) {
		int value = 0;

		value = getTvShowTitle().compareTo(tvShow.getTvShowTitle());

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

		if (!(obj instanceof TvShowClp)) {
			return false;
		}

		TvShowClp tvShow = (TvShowClp)obj;

		long primaryKey = tvShow.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", tvShowId=");
		sb.append(getTvShowId());
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
		sb.append(", tvShowTitle=");
		sb.append(getTvShowTitle());
		sb.append(", tvShowPremierDate=");
		sb.append(getTvShowPremierDate());
		sb.append(", tvShowDescription=");
		sb.append(getTvShowDescription());
		sb.append(", tvShowImageUrl=");
		sb.append(getTvShowImageUrl());
		sb.append(", tvShowImageUuid=");
		sb.append(getTvShowImageUuid());
		sb.append(", tvShowImageTitle=");
		sb.append(getTvShowImageTitle());
		sb.append(", tvShowImageVersion=");
		sb.append(getTvShowImageVersion());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("hu.webtown.liferay.portlet.model.TvShow");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tvShowId</column-name><column-value><![CDATA[");
		sb.append(getTvShowId());
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
			"<column><column-name>tvShowTitle</column-name><column-value><![CDATA[");
		sb.append(getTvShowTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tvShowPremierDate</column-name><column-value><![CDATA[");
		sb.append(getTvShowPremierDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tvShowDescription</column-name><column-value><![CDATA[");
		sb.append(getTvShowDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tvShowImageUrl</column-name><column-value><![CDATA[");
		sb.append(getTvShowImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tvShowImageUuid</column-name><column-value><![CDATA[");
		sb.append(getTvShowImageUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tvShowImageTitle</column-name><column-value><![CDATA[");
		sb.append(getTvShowImageTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tvShowImageVersion</column-name><column-value><![CDATA[");
		sb.append(getTvShowImageVersion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _tvShowId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _tvShowTitle;
	private Date _tvShowPremierDate;
	private String _tvShowDescription;
	private String _tvShowImageUrl;
	private String _tvShowImageUuid;
	private String _tvShowImageTitle;
	private String _tvShowImageVersion;
	private BaseModel<?> _tvShowRemoteModel;
	private Class<?> _clpSerializerClass = hu.webtown.liferay.portlet.service.ClpSerializer.class;
}