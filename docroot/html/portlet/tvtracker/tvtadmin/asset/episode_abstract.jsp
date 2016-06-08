<%@ include file="/html/portlet/tvtracker/tvtadmin/init.jsp" %>

<%
	Episode episode = (Episode) renderRequest.getAttribute(CustomWebKeys.EPISODE);
	String episodeDescription = episode.getEpisodeDescription();
	
	String summary = StringUtil.shorten(HtmlUtil.stripHtml(episodeDescription), 200);
%>

<%= summary %>