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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import hu.webtown.liferay.portlet.model.Season;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Season in entity cache.
 *
 * @author czeni
 * @see Season
 * @generated
 */
public class SeasonCacheModel implements CacheModel<Season>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", seasonId=");
		sb.append(seasonId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", seasonTitle=");
		sb.append(seasonTitle);
		sb.append(", seasonPremierDate=");
		sb.append(seasonPremierDate);
		sb.append(", seasonNumber=");
		sb.append(seasonNumber);
		sb.append(", seasonDescription=");
		sb.append(seasonDescription);
		sb.append(", seasonImageUrl=");
		sb.append(seasonImageUrl);
		sb.append(", seasonImageUuid=");
		sb.append(seasonImageUuid);
		sb.append(", seasonImageTitle=");
		sb.append(seasonImageTitle);
		sb.append(", sesonImageVersion=");
		sb.append(sesonImageVersion);
		sb.append(", tvShowId=");
		sb.append(tvShowId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Season toEntityModel() {
		SeasonImpl seasonImpl = new SeasonImpl();

		if (uuid == null) {
			seasonImpl.setUuid(StringPool.BLANK);
		}
		else {
			seasonImpl.setUuid(uuid);
		}

		seasonImpl.setSeasonId(seasonId);
		seasonImpl.setGroupId(groupId);
		seasonImpl.setCompanyId(companyId);
		seasonImpl.setUserId(userId);

		if (userName == null) {
			seasonImpl.setUserName(StringPool.BLANK);
		}
		else {
			seasonImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			seasonImpl.setCreateDate(null);
		}
		else {
			seasonImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			seasonImpl.setModifiedDate(null);
		}
		else {
			seasonImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (seasonTitle == null) {
			seasonImpl.setSeasonTitle(StringPool.BLANK);
		}
		else {
			seasonImpl.setSeasonTitle(seasonTitle);
		}

		if (seasonPremierDate == Long.MIN_VALUE) {
			seasonImpl.setSeasonPremierDate(null);
		}
		else {
			seasonImpl.setSeasonPremierDate(new Date(seasonPremierDate));
		}

		seasonImpl.setSeasonNumber(seasonNumber);

		if (seasonDescription == null) {
			seasonImpl.setSeasonDescription(StringPool.BLANK);
		}
		else {
			seasonImpl.setSeasonDescription(seasonDescription);
		}

		if (seasonImageUrl == null) {
			seasonImpl.setSeasonImageUrl(StringPool.BLANK);
		}
		else {
			seasonImpl.setSeasonImageUrl(seasonImageUrl);
		}

		if (seasonImageUuid == null) {
			seasonImpl.setSeasonImageUuid(StringPool.BLANK);
		}
		else {
			seasonImpl.setSeasonImageUuid(seasonImageUuid);
		}

		if (seasonImageTitle == null) {
			seasonImpl.setSeasonImageTitle(StringPool.BLANK);
		}
		else {
			seasonImpl.setSeasonImageTitle(seasonImageTitle);
		}

		if (sesonImageVersion == null) {
			seasonImpl.setSesonImageVersion(StringPool.BLANK);
		}
		else {
			seasonImpl.setSesonImageVersion(sesonImageVersion);
		}

		seasonImpl.setTvShowId(tvShowId);

		seasonImpl.resetOriginalValues();

		return seasonImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		seasonId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		seasonTitle = objectInput.readUTF();
		seasonPremierDate = objectInput.readLong();
		seasonNumber = objectInput.readInt();
		seasonDescription = objectInput.readUTF();
		seasonImageUrl = objectInput.readUTF();
		seasonImageUuid = objectInput.readUTF();
		seasonImageTitle = objectInput.readUTF();
		sesonImageVersion = objectInput.readUTF();
		tvShowId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(seasonId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (seasonTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(seasonTitle);
		}

		objectOutput.writeLong(seasonPremierDate);
		objectOutput.writeInt(seasonNumber);

		if (seasonDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(seasonDescription);
		}

		if (seasonImageUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(seasonImageUrl);
		}

		if (seasonImageUuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(seasonImageUuid);
		}

		if (seasonImageTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(seasonImageTitle);
		}

		if (sesonImageVersion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sesonImageVersion);
		}

		objectOutput.writeLong(tvShowId);
	}

	public String uuid;
	public long seasonId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String seasonTitle;
	public long seasonPremierDate;
	public int seasonNumber;
	public String seasonDescription;
	public String seasonImageUrl;
	public String seasonImageUuid;
	public String seasonImageTitle;
	public String sesonImageVersion;
	public long tvShowId;
}