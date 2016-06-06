<%@ include file="/html/portlet/tvtracker/init.jsp" %>
	
<liferay-portlet:renderURL var="navigateToTestURL">
	<liferay-portlet:param name="mvcPath" value="/html/portlet/tvtracker/tvtpublic/test.jsp"/>
</liferay-portlet:renderURL>
	
Go to <strong>test.jsp</strong>:
<aui:button name="testButton" value="test.jsp" onClick="<%= navigateToTestURL %>"/>
<br/><br/>

This is the <b>Tv Tracker Public</b> portlet in View mode.
