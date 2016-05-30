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
 * This class is used by SOAP remote services, specifically {@link hu.webtown.liferay.portlet.service.http.SeasonServiceSoap}.
 *
 * @author czeni
 * @see hu.webtown.liferay.portlet.service.http.SeasonServiceSoap
 * @generated
 */
public class SeasonSoap implements Serializable {
	public static SeasonSoap toSoapModel(Season model) {
		SeasonSoap soapModel = new SeasonSoap();

		soapModel.setSeasonId(model.getSeasonId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSeasonTitle(model.getSeasonTitle());
		soapModel.setSeasonPremierDate(model.getSeasonPremierDate());
		soapModel.setSeasonNumber(model.getSeasonNumber());
		soapModel.setSeasonDescription(model.getSeasonDescription());
		soapModel.setSeasonImageUrl(model.getSeasonImageUrl());
		soapModel.setSeasonImageUuid(model.getSeasonImageUuid());
		soapModel.setSeasonImageTitle(model.getSeasonImageTitle());
		soapModel.setSesonImageVersion(model.getSesonImageVersion());
		soapModel.setTvShowId(model.getTvShowId());

		return soapModel;
	}

	public static SeasonSoap[] toSoapModels(Season[] models) {
		SeasonSoap[] soapModels = new SeasonSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SeasonSoap[][] toSoapModels(Season[][] models) {
		SeasonSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SeasonSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SeasonSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SeasonSoap[] toSoapModels(List<Season> models) {
		List<SeasonSoap> soapModels = new ArrayList<SeasonSoap>(models.size());

		for (Season model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SeasonSoap[soapModels.size()]);
	}

	public SeasonSoap() {
	}

	public long getPrimaryKey() {
		return _seasonId;
	}

	public void setPrimaryKey(long pk) {
		setSeasonId(pk);
	}

	public long getSeasonId() {
		return _seasonId;
	}

	public void setSeasonId(long seasonId) {
		_seasonId = seasonId;
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

	public String getSeasonTitle() {
		return _seasonTitle;
	}

	public void setSeasonTitle(String seasonTitle) {
		_seasonTitle = seasonTitle;
	}

	public Date getSeasonPremierDate() {
		return _seasonPremierDate;
	}

	public void setSeasonPremierDate(Date seasonPremierDate) {
		_seasonPremierDate = seasonPremierDate;
	}

	public int getSeasonNumber() {
		return _seasonNumber;
	}

	public void setSeasonNumber(int seasonNumber) {
		_seasonNumber = seasonNumber;
	}

	public String getSeasonDescription() {
		return _seasonDescription;
	}

	public void setSeasonDescription(String seasonDescription) {
		_seasonDescription = seasonDescription;
	}

	public String getSeasonImageUrl() {
		return _seasonImageUrl;
	}

	public void setSeasonImageUrl(String seasonImageUrl) {
		_seasonImageUrl = seasonImageUrl;
	}

	public String getSeasonImageUuid() {
		return _seasonImageUuid;
	}

	public void setSeasonImageUuid(String seasonImageUuid) {
		_seasonImageUuid = seasonImageUuid;
	}

	public String getSeasonImageTitle() {
		return _seasonImageTitle;
	}

	public void setSeasonImageTitle(String seasonImageTitle) {
		_seasonImageTitle = seasonImageTitle;
	}

	public String getSesonImageVersion() {
		return _sesonImageVersion;
	}

	public void setSesonImageVersion(String sesonImageVersion) {
		_sesonImageVersion = sesonImageVersion;
	}

	public long getTvShowId() {
		return _tvShowId;
	}

	public void setTvShowId(long tvShowId) {
		_tvShowId = tvShowId;
	}

	private long _seasonId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
}