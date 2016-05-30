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
 * This class is used by SOAP remote services, specifically {@link hu.webtown.liferay.portlet.service.http.EpisodeServiceSoap}.
 *
 * @author czeni
 * @see hu.webtown.liferay.portlet.service.http.EpisodeServiceSoap
 * @generated
 */
public class EpisodeSoap implements Serializable {
	public static EpisodeSoap toSoapModel(Episode model) {
		EpisodeSoap soapModel = new EpisodeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEpisodeId(model.getEpisodeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEpisodeTitle(model.getEpisodeTitle());
		soapModel.setEpisodeAirDate(model.getEpisodeAirDate());
		soapModel.setEpisodeNumber(model.getEpisodeNumber());
		soapModel.setEpisodeDescription(model.getEpisodeDescription());
		soapModel.setEpisodeImageUrl(model.getEpisodeImageUrl());
		soapModel.setEpisodeImageUuid(model.getEpisodeImageUuid());
		soapModel.setEpisodeImageTitle(model.getEpisodeImageTitle());
		soapModel.setEpisodeImageVersion(model.getEpisodeImageVersion());
		soapModel.setSeasonId(model.getSeasonId());

		return soapModel;
	}

	public static EpisodeSoap[] toSoapModels(Episode[] models) {
		EpisodeSoap[] soapModels = new EpisodeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EpisodeSoap[][] toSoapModels(Episode[][] models) {
		EpisodeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EpisodeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EpisodeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EpisodeSoap[] toSoapModels(List<Episode> models) {
		List<EpisodeSoap> soapModels = new ArrayList<EpisodeSoap>(models.size());

		for (Episode model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EpisodeSoap[soapModels.size()]);
	}

	public EpisodeSoap() {
	}

	public long getPrimaryKey() {
		return _episodeId;
	}

	public void setPrimaryKey(long pk) {
		setEpisodeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEpisodeId() {
		return _episodeId;
	}

	public void setEpisodeId(long episodeId) {
		_episodeId = episodeId;
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

	public String getEpisodeTitle() {
		return _episodeTitle;
	}

	public void setEpisodeTitle(String episodeTitle) {
		_episodeTitle = episodeTitle;
	}

	public Date getEpisodeAirDate() {
		return _episodeAirDate;
	}

	public void setEpisodeAirDate(Date episodeAirDate) {
		_episodeAirDate = episodeAirDate;
	}

	public int getEpisodeNumber() {
		return _episodeNumber;
	}

	public void setEpisodeNumber(int episodeNumber) {
		_episodeNumber = episodeNumber;
	}

	public String getEpisodeDescription() {
		return _episodeDescription;
	}

	public void setEpisodeDescription(String episodeDescription) {
		_episodeDescription = episodeDescription;
	}

	public String getEpisodeImageUrl() {
		return _episodeImageUrl;
	}

	public void setEpisodeImageUrl(String episodeImageUrl) {
		_episodeImageUrl = episodeImageUrl;
	}

	public String getEpisodeImageUuid() {
		return _episodeImageUuid;
	}

	public void setEpisodeImageUuid(String episodeImageUuid) {
		_episodeImageUuid = episodeImageUuid;
	}

	public String getEpisodeImageTitle() {
		return _episodeImageTitle;
	}

	public void setEpisodeImageTitle(String episodeImageTitle) {
		_episodeImageTitle = episodeImageTitle;
	}

	public String getEpisodeImageVersion() {
		return _episodeImageVersion;
	}

	public void setEpisodeImageVersion(String episodeImageVersion) {
		_episodeImageVersion = episodeImageVersion;
	}

	public long getSeasonId() {
		return _seasonId;
	}

	public void setSeasonId(long seasonId) {
		_seasonId = seasonId;
	}

	private String _uuid;
	private long _episodeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
}