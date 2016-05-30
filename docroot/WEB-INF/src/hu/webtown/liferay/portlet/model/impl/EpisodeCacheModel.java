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

import hu.webtown.liferay.portlet.model.Episode;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Episode in entity cache.
 *
 * @author czeni
 * @see Episode
 * @generated
 */
public class EpisodeCacheModel implements CacheModel<Episode>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{episodeId=");
		sb.append(episodeId);
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
		sb.append(", episodeTitle=");
		sb.append(episodeTitle);
		sb.append(", episodeAirDate=");
		sb.append(episodeAirDate);
		sb.append(", episodeNumber=");
		sb.append(episodeNumber);
		sb.append(", episodeDescription=");
		sb.append(episodeDescription);
		sb.append(", episodeImageUrl=");
		sb.append(episodeImageUrl);
		sb.append(", episodeImageUuid=");
		sb.append(episodeImageUuid);
		sb.append(", episodeImageTitle=");
		sb.append(episodeImageTitle);
		sb.append(", episodeImageVersion=");
		sb.append(episodeImageVersion);
		sb.append(", seasonId=");
		sb.append(seasonId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Episode toEntityModel() {
		EpisodeImpl episodeImpl = new EpisodeImpl();

		episodeImpl.setEpisodeId(episodeId);
		episodeImpl.setGroupId(groupId);
		episodeImpl.setCompanyId(companyId);
		episodeImpl.setUserId(userId);

		if (userName == null) {
			episodeImpl.setUserName(StringPool.BLANK);
		}
		else {
			episodeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			episodeImpl.setCreateDate(null);
		}
		else {
			episodeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			episodeImpl.setModifiedDate(null);
		}
		else {
			episodeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (episodeTitle == null) {
			episodeImpl.setEpisodeTitle(StringPool.BLANK);
		}
		else {
			episodeImpl.setEpisodeTitle(episodeTitle);
		}

		if (episodeAirDate == Long.MIN_VALUE) {
			episodeImpl.setEpisodeAirDate(null);
		}
		else {
			episodeImpl.setEpisodeAirDate(new Date(episodeAirDate));
		}

		episodeImpl.setEpisodeNumber(episodeNumber);

		if (episodeDescription == null) {
			episodeImpl.setEpisodeDescription(StringPool.BLANK);
		}
		else {
			episodeImpl.setEpisodeDescription(episodeDescription);
		}

		if (episodeImageUrl == null) {
			episodeImpl.setEpisodeImageUrl(StringPool.BLANK);
		}
		else {
			episodeImpl.setEpisodeImageUrl(episodeImageUrl);
		}

		if (episodeImageUuid == null) {
			episodeImpl.setEpisodeImageUuid(StringPool.BLANK);
		}
		else {
			episodeImpl.setEpisodeImageUuid(episodeImageUuid);
		}

		if (episodeImageTitle == null) {
			episodeImpl.setEpisodeImageTitle(StringPool.BLANK);
		}
		else {
			episodeImpl.setEpisodeImageTitle(episodeImageTitle);
		}

		if (episodeImageVersion == null) {
			episodeImpl.setEpisodeImageVersion(StringPool.BLANK);
		}
		else {
			episodeImpl.setEpisodeImageVersion(episodeImageVersion);
		}

		episodeImpl.setSeasonId(seasonId);

		episodeImpl.resetOriginalValues();

		return episodeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		episodeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		episodeTitle = objectInput.readUTF();
		episodeAirDate = objectInput.readLong();
		episodeNumber = objectInput.readInt();
		episodeDescription = objectInput.readUTF();
		episodeImageUrl = objectInput.readUTF();
		episodeImageUuid = objectInput.readUTF();
		episodeImageTitle = objectInput.readUTF();
		episodeImageVersion = objectInput.readUTF();
		seasonId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(episodeId);
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

		if (episodeTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(episodeTitle);
		}

		objectOutput.writeLong(episodeAirDate);
		objectOutput.writeInt(episodeNumber);

		if (episodeDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(episodeDescription);
		}

		if (episodeImageUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(episodeImageUrl);
		}

		if (episodeImageUuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(episodeImageUuid);
		}

		if (episodeImageTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(episodeImageTitle);
		}

		if (episodeImageVersion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(episodeImageVersion);
		}

		objectOutput.writeLong(seasonId);
	}

	public long episodeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String episodeTitle;
	public long episodeAirDate;
	public int episodeNumber;
	public String episodeDescription;
	public String episodeImageUrl;
	public String episodeImageUuid;
	public String episodeImageTitle;
	public String episodeImageVersion;
	public long seasonId;
}