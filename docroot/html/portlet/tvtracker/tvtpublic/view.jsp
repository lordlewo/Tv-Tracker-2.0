<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ include file="/html/portlet/tvtracker/tvtpublic/init.jsp" %>
	
<liferay-portlet:renderURL var="navigateToTestURL">
	<liferay-portlet:param name="mvcPath" value='<%= templatePath + "test.jsp" %>'/>
</liferay-portlet:renderURL>
	
Go to <strong>test.jsp</strong>:
<aui:button name="testButton" value="test.jsp" onClick="<%= navigateToTestURL %>"/>
<br/>
<br/>



<%!
	private static Log _logger = LogFactoryUtil.getLog("tvtracker:tvtpublic:view_jsp");
%>

<%
	long groupId = themeDisplay.getScopeGroupId();

	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("mvcPath", templatePath + "view.jsp");
%>
<aui:form action="<%= portletURL %>" method="post" name="fm">
	<div id="<portlet:namespace/>TvTrackerPublicContainer">
		<aui:fieldset>
			<liferay-ui:search-container searchContainer="<%= new TvTrackerPublicSearch(renderRequest, portletURL) %>" >
				
				<%
					TvTrackerPublicDisplayTerms displayTerms = (TvTrackerPublicDisplayTerms) searchContainer.getDisplayTerms();
					TvTrackerPublicSearchTerms searchTerms = (TvTrackerPublicSearchTerms) searchContainer.getSearchTerms();
				%>
				
				<liferay-ui:search-form page='<%= templatePath + "search.jsp" %>' servletContext="<%= application %>" />
				
<%-- 				<liferay-util:include page='<%= templatePath + "search.jsp" %>' servletContext="<%= application %>" /> --%>
				
				<liferay-ui:search-container-results>
					<%@ include file="/html/portlet/tvtracker/tvtpublic/search_results.jspf" %>
		        </liferay-ui:search-container-results>
		        
		        <liferay-ui:search-container-row 
		        	className="hu.webtown.liferay.portlet.model.TvShow"
					escapedModel="true"
		        	keyProperty="tvShowId"
		        	modelVar="tvShow">
	
					<portlet:renderURL var="tvShowDetailsURL">
						<portlet:param name="mvcPath" value='<%= templatePath + "detail/tvshow_detail.jsp" %>' />
						<portlet:param name="backURL" value="<%= searchContainer.getIteratorURL().toString() %>" />
						<portlet:param name="<%= CustomWebKeys.TVSHOW_ID %>" value="<%= String.valueOf(tvShow.getTvShowId()) %>"/>
						<%-- (value = 0) -> tvshow.details tab selected | (value != 0) -> tvshow.seasons tab selected --%>
						<portlet:param name="selected_tab_tvshow" value="0" />
					</portlet:renderURL>
		        	
	        		<%@ include file="/html/portlet/tvtracker/tvtpublic/search_columns.jspf" %>
		        </liferay-ui:search-container-row>
			
				<liferay-ui:search-iterator />
			
			</liferay-ui:search-container>
		</aui:fieldset>
	</div>
</aui:form>