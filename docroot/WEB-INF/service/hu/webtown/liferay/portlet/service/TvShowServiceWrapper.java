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

package hu.webtown.liferay.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TvShowService}.
 *
 * @author czeni
 * @see TvShowService
 * @generated
 */
public class TvShowServiceWrapper implements TvShowService,
	ServiceWrapper<TvShowService> {
	public TvShowServiceWrapper(TvShowService tvShowService) {
		_tvShowService = tvShowService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tvShowService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tvShowService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tvShowService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TvShowService getWrappedTvShowService() {
		return _tvShowService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTvShowService(TvShowService tvShowService) {
		_tvShowService = tvShowService;
	}

	@Override
	public TvShowService getWrappedService() {
		return _tvShowService;
	}

	@Override
	public void setWrappedService(TvShowService tvShowService) {
		_tvShowService = tvShowService;
	}

	private TvShowService _tvShowService;
}