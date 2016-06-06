package hu.webtown.liferay.portlet.tvtracker.tvtadmin.action.test;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.BaseActionCommand;

import hu.webtown.liferay.portlet.model.Episode;
import hu.webtown.liferay.portlet.service.EpisodeLocalServiceUtil;

import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public class TestDeleteEpisodeActionCommand extends BaseActionCommand {
	
	private static final Log _logger = LogFactoryUtil.getLog(TestDeleteEpisodeActionCommand.class);

	@Override
	protected void doProcessCommand(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws SystemException, PortalException {
		
		ServiceContext serviceContext = ServiceContextFactory.
				getInstance(Episode.class.getName(), portletRequest);
		
		deleteEpisodes(serviceContext);
	}
	
	protected void deleteEpisodes(ServiceContext serviceContext) 
			throws SystemException, PortalException {
		
		long groupId = serviceContext.getScopeGroupId();	
		List<Episode> episodes = EpisodeLocalServiceUtil.getEpisodes(groupId);
		
		for (Episode episode : episodes) {
			long episodeId = episode.getEpisodeId();
			EpisodeLocalServiceUtil.deleteEpisode(episodeId, serviceContext);
		}
	}
}
