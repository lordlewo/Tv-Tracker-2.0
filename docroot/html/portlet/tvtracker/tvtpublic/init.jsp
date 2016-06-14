<%@ include file="/html/portlet/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="java.text.Format"%>

<%@page import="com.liferay.portal.service.ServiceContextFactory"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>

<%@page import="hu.webtown.liferay.portlet.tvtracker.util.*"%>

<%@page import="com.liferay.portal.security.auth.PrincipalException"%>
<%@page import="hu.webtown.liferay.portlet.NoSuchSeasonException"%>
<%@page import="hu.webtown.liferay.portlet.NoSuchTvShowException"%>

<%@page import="hu.webtown.liferay.portlet.tvtracker.tvtpublic.search.TvTrackerPublicSearch"%>
<%@page import="hu.webtown.liferay.portlet.tvtracker.tvtpublic.search.TvTrackerPublicDisplayTerms"%>
<%@page import="hu.webtown.liferay.portlet.tvtracker.tvtpublic.search.TvTrackerPublicSearchTerms"%>

<%@page import="hu.webtown.liferay.portlet.model.TvShow"%>
<%@page import="hu.webtown.liferay.portlet.model.Season"%>
<%@page import="hu.webtown.liferay.portlet.model.Episode"%>
<%@page import="hu.webtown.liferay.portlet.service.TvShowLocalServiceUtil"%>
<%@page import="hu.webtown.liferay.portlet.service.SeasonLocalService"%>
<%@page import="hu.webtown.liferay.portlet.service.EpisodeLocalService"%>

<%
Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale, timeZone);
Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);

String portletId = themeDisplay.getPortletDisplay().getId();
%>