package hu.webtown.liferay.portlet.tvtracker.tvtadmin.action.test;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.BaseActionCommand;

import hu.webtown.liferay.portlet.model.TvShow;
import hu.webtown.liferay.portlet.service.TvShowLocalServiceUtil;

import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public class TestDeleteTvShowActionCommand extends BaseActionCommand{
	
	private static final Log _logger = LogFactoryUtil.getLog(TestDeleteTvShowActionCommand.class);

	@Override
	protected void doProcessCommand(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws SystemException, PortalException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				TvShow.class.getName(), portletRequest);
		
		deleteTvShows(serviceContext);
	}
	
	protected void deleteTvShows(ServiceContext serviceContext) 
			throws SystemException, PortalException {
		
		long groupId = serviceContext.getScopeGroupId();
		
		List<TvShow> tvShows = TvShowLocalServiceUtil.getTvShows(groupId);
		
		for (TvShow tvShow : tvShows) {
			long tvShowId = tvShow.getTvShowId();
			TvShowLocalServiceUtil.deleteTvShow(tvShowId, serviceContext);
		}
	}
}
