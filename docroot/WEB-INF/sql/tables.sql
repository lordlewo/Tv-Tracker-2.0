create table TvT_Episode (
	uuid_ VARCHAR(75) null,
	episodeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	episodeTitle VARCHAR(75) null,
	episodeAirDate DATE null,
	episodeNumber INTEGER,
	episodeDescription VARCHAR(75) null,
	episodeImageUrl VARCHAR(75) null,
	episodeImageUuid VARCHAR(75) null,
	episodeImageTitle VARCHAR(75) null,
	episodeImageVersion VARCHAR(75) null,
	seasonId LONG
);

create table TvT_Season (
	uuid_ VARCHAR(75) null,
	seasonId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	seasonTitle VARCHAR(75) null,
	seasonPremierDate DATE null,
	seasonNumber INTEGER,
	seasonDescription VARCHAR(75) null,
	seasonImageUrl VARCHAR(75) null,
	seasonImageUuid VARCHAR(75) null,
	seasonImageTitle VARCHAR(75) null,
	seasonImageVersion VARCHAR(75) null,
	tvShowId LONG
);

create table TvT_TvShow (
	uuid_ VARCHAR(75) null,
	tvShowId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	tvShowTitle VARCHAR(75) null,
	tvShowPremierDate DATE null,
	tvShowDescription VARCHAR(75) null,
	tvShowImageUrl VARCHAR(75) null,
	tvShowImageUuid VARCHAR(75) null,
	tvShowImageTitle VARCHAR(75) null,
	tvShowImageVersion VARCHAR(75) null
);