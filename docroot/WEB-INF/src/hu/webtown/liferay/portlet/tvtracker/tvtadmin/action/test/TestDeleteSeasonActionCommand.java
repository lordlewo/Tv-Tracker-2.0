package hu.webtown.liferay.portlet.tvtracker.tvtadmin.action.test;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.BaseActionCommand;

import hu.webtown.liferay.portlet.model.Season;
import hu.webtown.liferay.portlet.service.SeasonLocalServiceUtil;

import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public class TestDeleteSeasonActionCommand extends BaseActionCommand {
	
	private static final Log _logger = LogFactoryUtil.getLog(TestDeleteSeasonActionCommand.class);

	@Override
	protected void doProcessCommand(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws SystemException, PortalException {

		ServiceContext serviceContext = ServiceContextFactory.
				getInstance(Season.class.getName(), portletRequest);
		
		deleteSeasons(serviceContext);
	}
	
	protected void deleteSeasons(ServiceContext serviceContext) 
			throws SystemException, PortalException {
		
		long groupId = serviceContext.getScopeGroupId();
		List<Season> seasons = SeasonLocalServiceUtil.getSeasons(groupId);
		
		for (Season season : seasons) {
			long seasonId = season.getSeasonId();
			SeasonLocalServiceUtil.deleteSeason(seasonId, serviceContext);
		}
	}
}
