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

import hu.webtown.liferay.portlet.model.TvShow;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TvShow in entity cache.
 *
 * @author czeni
 * @see TvShow
 * @generated
 */
public class TvShowCacheModel implements CacheModel<TvShow>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{tvShowId=");
		sb.append(tvShowId);
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
		sb.append(", tvShowTitle=");
		sb.append(tvShowTitle);
		sb.append(", tvShowPremierDate=");
		sb.append(tvShowPremierDate);
		sb.append(", tvShowDescription=");
		sb.append(tvShowDescription);
		sb.append(", tvShowImageUrl=");
		sb.append(tvShowImageUrl);
		sb.append(", tvShowImageUuid=");
		sb.append(tvShowImageUuid);
		sb.append(", tvShowImageTitle=");
		sb.append(tvShowImageTitle);
		sb.append(", tvShowImageVersion=");
		sb.append(tvShowImageVersion);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TvShow toEntityModel() {
		TvShowImpl tvShowImpl = new TvShowImpl();

		tvShowImpl.setTvShowId(tvShowId);
		tvShowImpl.setGroupId(groupId);
		tvShowImpl.setCompanyId(companyId);
		tvShowImpl.setUserId(userId);

		if (userName == null) {
			tvShowImpl.setUserName(StringPool.BLANK);
		}
		else {
			tvShowImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tvShowImpl.setCreateDate(null);
		}
		else {
			tvShowImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tvShowImpl.setModifiedDate(null);
		}
		else {
			tvShowImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (tvShowTitle == null) {
			tvShowImpl.setTvShowTitle(StringPool.BLANK);
		}
		else {
			tvShowImpl.setTvShowTitle(tvShowTitle);
		}

		if (tvShowPremierDate == Long.MIN_VALUE) {
			tvShowImpl.setTvShowPremierDate(null);
		}
		else {
			tvShowImpl.setTvShowPremierDate(new Date(tvShowPremierDate));
		}

		if (tvShowDescription == null) {
			tvShowImpl.setTvShowDescription(StringPool.BLANK);
		}
		else {
			tvShowImpl.setTvShowDescription(tvShowDescription);
		}

		if (tvShowImageUrl == null) {
			tvShowImpl.setTvShowImageUrl(StringPool.BLANK);
		}
		else {
			tvShowImpl.setTvShowImageUrl(tvShowImageUrl);
		}

		if (tvShowImageUuid == null) {
			tvShowImpl.setTvShowImageUuid(StringPool.BLANK);
		}
		else {
			tvShowImpl.setTvShowImageUuid(tvShowImageUuid);
		}

		if (tvShowImageTitle == null) {
			tvShowImpl.setTvShowImageTitle(StringPool.BLANK);
		}
		else {
			tvShowImpl.setTvShowImageTitle(tvShowImageTitle);
		}

		if (tvShowImageVersion == null) {
			tvShowImpl.setTvShowImageVersion(StringPool.BLANK);
		}
		else {
			tvShowImpl.setTvShowImageVersion(tvShowImageVersion);
		}

		tvShowImpl.resetOriginalValues();

		return tvShowImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tvShowId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		tvShowTitle = objectInput.readUTF();
		tvShowPremierDate = objectInput.readLong();
		tvShowDescription = objectInput.readUTF();
		tvShowImageUrl = objectInput.readUTF();
		tvShowImageUuid = objectInput.readUTF();
		tvShowImageTitle = objectInput.readUTF();
		tvShowImageVersion = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tvShowId);
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

		if (tvShowTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tvShowTitle);
		}

		objectOutput.writeLong(tvShowPremierDate);

		if (tvShowDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tvShowDescription);
		}

		if (tvShowImageUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tvShowImageUrl);
		}

		if (tvShowImageUuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tvShowImageUuid);
		}

		if (tvShowImageTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tvShowImageTitle);
		}

		if (tvShowImageVersion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tvShowImageVersion);
		}
	}

	public long tvShowId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String tvShowTitle;
	public long tvShowPremierDate;
	public String tvShowDescription;
	public String tvShowImageUrl;
	public String tvShowImageUuid;
	public String tvShowImageTitle;
	public String tvShowImageVersion;
}