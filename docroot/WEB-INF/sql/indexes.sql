create index IX_E3972AD4 on TvT_Episode (companyId);
create index IX_D45656 on TvT_Episode (groupId);
create index IX_EA730E90 on TvT_Episode (groupId, episodeId);
create index IX_6301E5A8 on TvT_Episode (groupId, seasonId);
create index IX_C0978660 on TvT_Episode (uuid_);
create index IX_87B0C1C8 on TvT_Episode (uuid_, companyId);
create unique index IX_A88F1A4A on TvT_Episode (uuid_, groupId);

create index IX_7B18D8B2 on TvT_Season (companyId);
create index IX_2603E3B4 on TvT_Season (groupId);
create index IX_BBDED586 on TvT_Season (groupId, seasonId);
create index IX_94FD7942 on TvT_Season (groupId, tvShowId);
create index IX_9C66D33E on TvT_Season (uuid_);
create index IX_EDA75E2A on TvT_Season (uuid_, companyId);
create unique index IX_4AE5672C on TvT_Season (uuid_, groupId);

create index IX_2CB0A876 on TvT_TvShow (companyId);
create index IX_1814D478 on TvT_TvShow (groupId);
create index IX_CCBDC42A on TvT_TvShow (tvShowId, groupId);
create index IX_2CC52502 on TvT_TvShow (uuid_);
create index IX_2FDF09E6 on TvT_TvShow (uuid_, companyId);
create unique index IX_894CD1E8 on TvT_TvShow (uuid_, groupId);