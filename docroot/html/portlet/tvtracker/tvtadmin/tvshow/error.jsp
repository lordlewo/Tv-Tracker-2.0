<%@ include file="/html/portlet/tvtracker/tvtadmin/init.jsp" %>

<liferay-ui:header
    backURL="javascript:history.go(-1);"
    title="error" 
    showBackURL="true"/>

<liferay-ui:error exception="<%= NoSuchTvShowException.class %>" message="the-tvshow-could-not-be-found" />
<liferay-ui:error exception="<%= NoSuchSeasonException.class %>" message="the-season-could-not-be-found" />
<liferay-ui:error exception="<%= NoSuchSeasonException.class %>" message="the-episode-could-not-be-found" />
<liferay-ui:error exception="<%= PrincipalException.class %>" message="you-do-not-have-the-required-permissions" />