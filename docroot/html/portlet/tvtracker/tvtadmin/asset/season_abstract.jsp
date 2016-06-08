<%@ include file="/html/portlet/tvtracker/tvtadmin/init.jsp" %>

<%
	Season season = (Season) renderRequest.getAttribute(CustomWebKeys.SEASON);
	String seasonDescription = season.getSeasonDescription();
	
	String summary = StringUtil.shorten(HtmlUtil.stripHtml(seasonDescription), 200);
%>

<%= summary %>