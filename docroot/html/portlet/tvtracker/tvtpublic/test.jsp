<%@ include file="/html/portlet/tvtracker/tvtpublic/init.jsp" %>

<h3>Testing:</h3>
<br> 

<portlet:actionURL name="TestAddTvShow" var="testAddTvShowURL"/>
<portlet:actionURL name="TestDeleteTvShow" var="testDeleteTvShowURL"/>

Add TvShows:
<aui:button name="addTvShowButton" value="Add TvShows" onClick="<%= testAddTvShowURL %>" />
<br>
<br>
Delete TvShows:
<aui:button name="deleteTvShowButton" value="Delete TvShows" onClick="<%= testDeleteTvShowURL %>" />

<br>
<br>

<portlet:actionURL name="TestAddSeason" var="testAddSeasonURL"/>
<portlet:actionURL name="TestDeleteSeason" var="testDeleteSeasonURL"/>

Add Seasons:
<aui:button name="addSeasonButton" value="Add Seasons" onClick="<%= testAddSeasonURL %>" />
<br>
<br>
Delete Seasons:
<aui:button name="deleteSeasonButton" value="Delete Seasons" onClick="<%= testDeleteSeasonURL %>" />

<br>
<br>

<portlet:actionURL name="TestAddEpisode" var="testAddEpisodeURL"/>
<portlet:actionURL name="TestDeleteEpisode" var="testDeleteEpisodeURL"/>

Add Episodes:
<aui:button name="addEpisodeButton" value="Add Episodes" onClick="<%= testAddEpisodeURL %>" />
<br>
<br>
Delete Episodes:
<aui:button name="deleteEpisodeButton" value="Delete Episodes" onClick="<%= testDeleteEpisodeURL %>" />

<br>
<br>
Add TvShow with Season:
<portlet:actionURL name="TestAddTvShowWithSeason" var="testAddTvShowWithSeasonURL"/>
<aui:button name="addTvShowWithSeasonButton" value="Add TvShow With Season" onClick="<%= testAddTvShowWithSeasonURL %>" />