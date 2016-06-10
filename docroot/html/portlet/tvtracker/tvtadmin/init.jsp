<%@ include file="/html/portlet/init.jsp" %>

<%@page import="java.text.Format"%>

<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>


<%@page import="hu.webtown.liferay.portlet.tvtracker.util.CustomWebKeys"%>

<%@page import="hu.webtown.liferay.portlet.model.Episode"%>
<%@page import="hu.webtown.liferay.portlet.model.Season"%>
<%@page import="hu.webtown.liferay.portlet.model.TvShow"%>

<%@page import="com.liferay.portal.security.auth.PrincipalException"%>
<%@page import="hu.webtown.liferay.portlet.NoSuchSeasonException"%>
<%@page import="hu.webtown.liferay.portlet.NoSuchTvShowException"%>


<%
Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale, timeZone);
Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);

String portletId = themeDisplay.getPortletDisplay().getId();
%>