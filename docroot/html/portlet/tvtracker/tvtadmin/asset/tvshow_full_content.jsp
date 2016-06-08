<%@ include file="/html/portlet/tvtracker/tvtadmin/init.jsp" %>

<%
	TvShow tvShow = (TvShow) renderRequest.getAttribute(CustomWebKeys.TVSHOW);
	String tvShowDescription = tvShow.getTvShowDescription();
	
	String summary = HtmlUtil.stripHtml(tvShowDescription);
%>

<%= summary %>