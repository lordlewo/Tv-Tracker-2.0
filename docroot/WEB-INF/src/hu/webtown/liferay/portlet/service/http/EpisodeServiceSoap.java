/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package hu.webtown.liferay.portlet.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import hu.webtown.liferay.portlet.service.EpisodeServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link hu.webtown.liferay.portlet.service.EpisodeServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link hu.webtown.liferay.portlet.model.EpisodeSoap}.
 * If the method in the service utility returns a
 * {@link hu.webtown.liferay.portlet.model.Episode}, that is translated to a
 * {@link hu.webtown.liferay.portlet.model.EpisodeSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author czeni
 * @see EpisodeServiceHttp
 * @see hu.webtown.liferay.portlet.model.EpisodeSoap
 * @see hu.webtown.liferay.portlet.service.EpisodeServiceUtil
 * @generated
 */
public class EpisodeServiceSoap {
	public static hu.webtown.liferay.portlet.model.EpisodeSoap addEpisode(
		long userId, long groupId, long seasonId,
		java.lang.String episodeTitle, java.util.Date episodeAirDate,
		int episodeNumber, java.lang.String episodeDescription,
		java.lang.String episodeImageUrl, java.lang.String episodeImageUuid,
		java.lang.String episodeImageTitle,
		java.lang.String episodeImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.webtown.liferay.portlet.model.Episode returnValue = EpisodeServiceUtil.addEpisode(userId,
					groupId, seasonId, episodeTitle, episodeAirDate,
					episodeNumber, episodeDescription, episodeImageUrl,
					episodeImageUuid, episodeImageTitle, episodeImageVersion,
					serviceContext);

			return hu.webtown.liferay.portlet.model.EpisodeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.webtown.liferay.portlet.model.EpisodeSoap deleteEpisode(
		long groupId, long episodeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.webtown.liferay.portlet.model.Episode returnValue = EpisodeServiceUtil.deleteEpisode(groupId,
					episodeId, serviceContext);

			return hu.webtown.liferay.portlet.model.EpisodeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.webtown.liferay.portlet.model.EpisodeSoap updateEpisode(
		long userId, long groupId, long seasonId, long episodeId,
		java.lang.String episodeTitle, java.util.Date episodeAirDate,
		int episodeNumber, java.lang.String episodeDescription,
		java.lang.String episodeImageUrl, java.lang.String episodeImageUuid,
		java.lang.String episodeImageTitle,
		java.lang.String episodeImageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.webtown.liferay.portlet.model.Episode returnValue = EpisodeServiceUtil.updateEpisode(userId,
					groupId, seasonId, episodeId, episodeTitle, episodeAirDate,
					episodeNumber, episodeDescription, episodeImageUrl,
					episodeImageUuid, episodeImageTitle, episodeImageVersion,
					serviceContext);

			return hu.webtown.liferay.portlet.model.EpisodeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EpisodeServiceSoap.class);
}