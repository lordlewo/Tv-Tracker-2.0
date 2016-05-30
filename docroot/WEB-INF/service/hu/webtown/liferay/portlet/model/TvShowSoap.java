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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link hu.webtown.liferay.portlet.service.http.TvShowServiceSoap}.
 *
 * @author czeni
 * @see hu.webtown.liferay.portlet.service.http.TvShowServiceSoap
 * @generated
 */
public class TvShowSoap implements Serializable {
	public static TvShowSoap toSoapModel(TvShow model) {
		TvShowSoap soapModel = new TvShowSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTvShowId(model.getTvShowId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTvShowTitle(model.getTvShowTitle());
		soapModel.setTvShowPremierDate(model.getTvShowPremierDate());
		soapModel.setTvShowDescription(model.getTvShowDescription());
		soapModel.setTvShowImageUrl(model.getTvShowImageUrl());
		soapModel.setTvShowImageUuid(model.getTvShowImageUuid());
		soapModel.setTvShowImageTitle(model.getTvShowImageTitle());
		soapModel.setTvShowImageVersion(model.getTvShowImageVersion());

		return soapModel;
	}

	public static TvShowSoap[] toSoapModels(TvShow[] models) {
		TvShowSoap[] soapModels = new TvShowSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TvShowSoap[][] toSoapModels(TvShow[][] models) {
		TvShowSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TvShowSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TvShowSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TvShowSoap[] toSoapModels(List<TvShow> models) {
		List<TvShowSoap> soapModels = new ArrayList<TvShowSoap>(models.size());

		for (TvShow model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TvShowSoap[soapModels.size()]);
	}

	public TvShowSoap() {
	}

	public long getPrimaryKey() {
		return _tvShowId;
	}

	public void setPrimaryKey(long pk) {
		setTvShowId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTvShowId() {
		return _tvShowId;
	}

	public void setTvShowId(long tvShowId) {
		_tvShowId = tvShowId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTvShowTitle() {
		return _tvShowTitle;
	}

	public void setTvShowTitle(String tvShowTitle) {
		_tvShowTitle = tvShowTitle;
	}

	public Date getTvShowPremierDate() {
		return _tvShowPremierDate;
	}

	public void setTvShowPremierDate(Date tvShowPremierDate) {
		_tvShowPremierDate = tvShowPremierDate;
	}

	public String getTvShowDescription() {
		return _tvShowDescription;
	}

	public void setTvShowDescription(String tvShowDescription) {
		_tvShowDescription = tvShowDescription;
	}

	public String getTvShowImageUrl() {
		return _tvShowImageUrl;
	}

	public void setTvShowImageUrl(String tvShowImageUrl) {
		_tvShowImageUrl = tvShowImageUrl;
	}

	public String getTvShowImageUuid() {
		return _tvShowImageUuid;
	}

	public void setTvShowImageUuid(String tvShowImageUuid) {
		_tvShowImageUuid = tvShowImageUuid;
	}

	public String getTvShowImageTitle() {
		return _tvShowImageTitle;
	}

	public void setTvShowImageTitle(String tvShowImageTitle) {
		_tvShowImageTitle = tvShowImageTitle;
	}

	public String getTvShowImageVersion() {
		return _tvShowImageVersion;
	}

	public void setTvShowImageVersion(String tvShowImageVersion) {
		_tvShowImageVersion = tvShowImageVersion;
	}

	private String _uuid;
	private long _tvShowId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
}