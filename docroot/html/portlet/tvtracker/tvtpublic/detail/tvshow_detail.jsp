<%@page import="javax.portlet.RenderRequest"%>
<%@ include file="/html/portlet/tvtracker/tvtpublic/init.jsp" %>

<%!
	private static Log _logger = LogFactoryUtil.getLog("tvtracker:tvtpublic:tvshow_detail_jsp");
%>

<%!
	private static String getCategories(long tvShowId) throws PortalException,SystemException {
	
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(TvShow.class.getName(), tvShowId);
		List<AssetCategory> categories = assetEntry.getCategories();
		
		StringBuffer stringBuffer = new StringBuffer();
		
		if(categories != null && !categories.isEmpty()){
			stringBuffer.append(categories.get(0).getName());
			
			for(int i = 1; i < categories.size(); i++){
				stringBuffer.append(StringPool.COMMA_AND_SPACE);
				stringBuffer.append(categories.get(i).getName());
			}
		}
		
		if(stringBuffer.toString().isEmpty()){
			stringBuffer.append(StringPool.DASH);
		}
		
		return stringBuffer.toString();
	}
%>

<%
	// url params
	String backURL = ParamUtil.getString(renderRequest, "backURL");
	long groupId = ParamUtil.getLong(renderRequest, "groupId");
	long tvShowId = ParamUtil.getLong(renderRequest, CustomWebKeys.TVSHOW_ID);
	
	// tvshow instance
	TvShow tvShow = TvShowLocalServiceUtil.getTvShow(groupId, tvShowId);

	// tab selection logic
	String selectedTab = ParamUtil.getString(
			renderRequest, 
			CustomConstants.PUBLIC_SEARCH_TVSHOW_DETAIL_SELECTED_TAB, 
			CustomConstants.PUBLIC_TVSHOW_DETAILS_TAB);
	
	boolean tabVisibility = (selectedTab.equalsIgnoreCase(CustomConstants.PUBLIC_TVSHOW_DETAILS_TAB)) ? true : false;
	
	String detailsCssClass = (selectedTab.equalsIgnoreCase(CustomConstants.PUBLIC_TVSHOW_DETAILS_TAB)) ? 
			CustomConstants.TAB_VISIBILITY_CSS_CLASS : StringPool.BLANK;
	
	String seasonsCssClass = (selectedTab.equalsIgnoreCase(CustomConstants.PUBLIC_TVSHOW_DETAILS_TAB)) ? 
			StringPool.BLANK : CustomConstants.TAB_VISIBILITY_CSS_CLASS ;
	
	// asset categories
	String tvShowCategories = getCategories(tvShowId);
	
	//breadcrumb
	PortalUtil.addPortletBreadcrumbEntry(request, tvShow.getTvShowTitle(), currentURL);
	PortalUtil.setPageSubtitle(tvShow.getTvShowTitle(), request);
    PortalUtil.setPageDescription(tvShow.getTvShowTitle(), request);

%>

<aui:container>
	<c:if test="<%= TvShowPermission.contains(permissionChecker, groupId, tvShowId, CustomActionKeys.VIEW) %>">
		<aui:row cssClass="tvShowHeaderRow" >
			<h1> 
				<a href="<%= backURL %>" class="icon-arrow-left" style="text-decoration: none;" ></a> &nbsp;
				<%= HtmlUtil.escape(tvShow.getTvShowTitle()) %> &nbsp; 
				(<%= HtmlUtil.escape(String.valueOf(tvShow.getTvShowPremierYear())) %>) 
			</h1>
		</aui:row>
		
		<aui:row>
			<aui:col span="<%= ((selectedTab.equalsIgnoreCase(CustomConstants.PUBLIC_TVSHOW_DETAILS_TAB)) ? 6 : 4) %>" >
				<aui:row class="tvShowImage">
					<img src="<%= tvShow.getTvShowImageUrl() %>" id="<portlet:namespace/>tvShowImage" class="tvShowImage" />
				</aui:row>
			</aui:col>
			
			<aui:col span="<%= ((selectedTab.equalsIgnoreCase(CustomConstants.PUBLIC_TVSHOW_DETAILS_TAB)) ? 6 : 8) %>" >
			
			    <portlet:renderURL var="detailsTabURL">
			    	<portlet:param name="mvcPath" value='<%= templatePath + "detail/tvshow_detail.jsp" %>' />
			    	<portlet:param name="backURL" value="<%= backURL %>" />
					<portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" />
			        <portlet:param name="<%= CustomWebKeys.TVSHOW_ID %>" value="<%=String.valueOf(tvShowId) %>" />
			       	<portlet:param 
							name="<%= CustomConstants.PUBLIC_SEARCH_TVSHOW_DETAIL_SELECTED_TAB %>" 
							value="<%= CustomConstants.PUBLIC_TVSHOW_DETAILS_TAB %>" />
			    </portlet:renderURL>
  			    <portlet:renderURL var="seasonsTabURL">
  			    	<portlet:param name="mvcPath" value='<%= templatePath + "detail/tvshow_detail.jsp" %>' />
  			    	<portlet:param name="backURL" value="<%= backURL %>" />
					<portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" />
			        <portlet:param name="<%= CustomWebKeys.TVSHOW_ID %>" value="<%=String.valueOf(tvShowId) %>" />
			        <portlet:param 
							name="<%= CustomConstants.PUBLIC_SEARCH_TVSHOW_DETAIL_SELECTED_TAB %>" 
							value="<%= CustomConstants.PUBLIC_SEASONS_TAB %>" />
			    </portlet:renderURL>
			
				<aui:nav cssClass="nav-tabs">			
					<aui:nav-item cssClass="<%= detailsCssClass %>" label="Details" href="<%= detailsTabURL %>" />			
					<aui:nav-item cssClass="<%= seasonsCssClass %>" label="Seasons" href="<%= seasonsTabURL %>" />
				</aui:nav>
				
				<c:if test="<%= tabVisibility %>">
					<div class="tvShowDetailsTab">
						<aui:row cssClass="tvShowDetailsTabRow">
							<aui:col span="3"/>
							<aui:col span="8" cssClass="tvShowDetailsRowTitle">
								<h3> <%= HtmlUtil.escape(tvShow.getTvShowTitle()) %> </h3>
							</aui:col>
							<aui:col span="1"/>
						</aui:row>
						
						<aui:row cssClass="tvShowDetailsTabRow">
							<aui:col span="3">
								<strong>Premier Date:</strong>
							</aui:col>
							<aui:col span="8" cssClass="tvShowDetailsRowText">
								<fmt:formatDate value="<%= tvShow.getTvShowPremierDate() %>" type="date" pattern="MMM dd, yyyy"/>
							</aui:col>
						</aui:row>
						
						<aui:row cssClass="tvShowDetailsTabRow">
							<aui:col span="3">
								<strong>Genres:</strong>
							</aui:col>
							<aui:col span="8" cssClass="tvShowDetailsRowText">
								<%= HtmlUtil.escape(tvShowCategories) %>
							</aui:col>
						</aui:row>
						
						<aui:row cssClass="tvShowDetailsTabRow">
							<aui:col span="3">
								<strong>Number of Seasons:</strong>
							</aui:col>
							<aui:col span="8" cssClass="tvShowDetailsRowText">
								<%= HtmlUtil.escape(String.valueOf(tvShow.getTvShowSeasonCount())) %>
							</aui:col>
						</aui:row>
						
						<aui:row cssClass="tvShowDetailsTabRow">
							<aui:col span="3">
								<strong>Description:</strong>
							</aui:col>
							<aui:col span="8" cssClass="tvShowDetailsRowText tvShowDeatilsRowTextDetails">
								<%= HtmlUtil.escape(tvShow.getTvShowDescription()) %>
							</aui:col>
						</aui:row>
					</div>
				</c:if>
				
				<c:if test="<%= !tabVisibility %>">
					<div class="tvShowSeasonsTab">
						<liferay-util:include page="/html/tvtracker/detail/tvshow_detail_seasons_tab.jsp" servletContext="<%= application %>" >
							<liferay-util:param name="<%= CustomWebKeys.TVSHOW_ID %>" value="<%= String.valueOf(tvShowId) %>" />
						</liferay-util:include>
					</div>
				</c:if>
			</aui:col>
		</aui:row>
	</c:if>
	
	<c:if test="<%= !TvShowPermission.contains(permissionChecker, tvShowId, CustomActionKeys.VIEW) %>">
		You must have the appropriate permission for view the tv show!
	</c:if>
</aui:container>