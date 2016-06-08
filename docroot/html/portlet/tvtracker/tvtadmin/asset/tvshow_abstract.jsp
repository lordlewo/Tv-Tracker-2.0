<%@ include file="/html/portlet/tvtracker/tvtadmin/init.jsp" %>

<%
	TvShow tvShow = (TvShow) renderRequest.getAttribute(CustomWebKeys.TVSHOW);
	String tvShowDescription = tvShow.getTvShowDescription();
	
	String summary = StringUtil.shorten(HtmlUtil.stripHtml(tvShowDescription), 200);
%>

<%= summary %>