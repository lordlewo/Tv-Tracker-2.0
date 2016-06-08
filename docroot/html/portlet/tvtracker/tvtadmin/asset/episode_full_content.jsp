<%@ include file="/html/portlet/tvtracker/tvtadmin/init.jsp" %>

<%
	Episode episode = (Episode) renderRequest.getAttribute(CustomWebKeys.EPISODE);
	String episodeDescription = episode.getEpisodeDescription();
	
	String summary = HtmlUtil.stripHtml(episodeDescription);
%>

<%= summary %>