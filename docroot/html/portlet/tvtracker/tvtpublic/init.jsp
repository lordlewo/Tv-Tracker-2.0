<%@ include file="/html/portlet/init.jsp" %>

<%@page import="java.util.List"%>

<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="java.text.Format"%>

<%@page import="com.liferay.portal.service.ServiceContextFactory"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>

<%@page import="hu.webtown.liferay.portlet.tvtracker.util.*"%>

<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portal.security.auth.PrincipalException"%>
<%@page import="hu.webtown.liferay.portlet.NoSuchSeasonException"%>
<%@page import="hu.webtown.liferay.portlet.NoSuchTvShowException"%>

<%@page import="hu.webtown.liferay.portlet.tvtracker.tvtpublic.search.TvTrackerPublicSearch"%>
<%@page import="hu.webtown.liferay.portlet.tvtracker.tvtpublic.search.TvTrackerPublicDisplayTerms"%>
<%@page import="hu.webtown.liferay.portlet.tvtracker.tvtpublic.search.TvTrackerPublicSearchTerms"%>

<%@page import="hu.webtown.liferay.portlet.model.constant.DateRangeType"%>

<%@page import="hu.webtown.liferay.portlet.model.TvShow"%>
<%@page import="hu.webtown.liferay.portlet.model.Season"%>
<%@page import="hu.webtown.liferay.portlet.model.Episode"%>
<%@page import="hu.webtown.liferay.portlet.service.TvShowLocalServiceUtil"%>
<%@page import="hu.webtown.liferay.portlet.service.SeasonLocalService"%>
<%@page import="hu.webtown.liferay.portlet.service.EpisodeLocalService"%>
<%@page import="hu.webtown.liferay.portlet.service.permission.TvTrackerModelPermission"%>
<%@page import="hu.webtown.liferay.portlet.service.permission.TvShowPermission"%>
<%@page import="hu.webtown.liferay.portlet.service.permission.SeasonPermission"%>
<%@page import="hu.webtown.liferay.portlet.service.permission.EpisodePermission"%>
<%@page import="hu.webtown.liferay.portlet.service.permission.CustomActionKeys"%>

<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>

<%
Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale, timeZone);
Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);

String portletId = themeDisplay.getPortletDisplay().getId();
%>