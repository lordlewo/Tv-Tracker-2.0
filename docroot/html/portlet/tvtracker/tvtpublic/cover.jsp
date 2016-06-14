<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/portlet/tvtracker/tvtpublic/init.jsp" %>
<%
	ResultRow resultRow = (ResultRow) renderRequest.getAttribute(CustomWebKeys.SEARCH_CONTAINER_RESULT_ROW);
	TvShow tvShow = (TvShow) resultRow.getObject();
%>

<aui:container>
	<aui:row align="center">
		<img src="<%= tvShow.getTvShowImageUrl() %>" width="300"/>
	</aui:row>
</aui:container>