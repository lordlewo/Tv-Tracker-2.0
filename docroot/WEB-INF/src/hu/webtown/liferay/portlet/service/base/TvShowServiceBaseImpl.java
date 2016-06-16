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

package hu.webtown.liferay.portlet.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.asset.service.persistence.AssetLinkPersistence;
import com.liferay.portlet.expando.service.persistence.ExpandoValuePersistence;

import hu.webtown.liferay.portlet.model.TvShow;
import hu.webtown.liferay.portlet.service.TvShowService;
import hu.webtown.liferay.portlet.service.persistence.EpisodePersistence;
import hu.webtown.liferay.portlet.service.persistence.SeasonPersistence;
import hu.webtown.liferay.portlet.service.persistence.TvShowFinder;
import hu.webtown.liferay.portlet.service.persistence.TvShowPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the tv show remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link hu.webtown.liferay.portlet.service.impl.TvShowServiceImpl}.
 * </p>
 *
 * @author czeni
 * @see hu.webtown.liferay.portlet.service.impl.TvShowServiceImpl
 * @see hu.webtown.liferay.portlet.service.TvShowServiceUtil
 * @generated
 */
public abstract class TvShowServiceBaseImpl extends BaseServiceImpl
	implements TvShowService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link hu.webtown.liferay.portlet.service.TvShowServiceUtil} to access the tv show remote service.
	 */

	/**
	 * Returns the episode local service.
	 *
	 * @return the episode local service
	 */
	public hu.webtown.liferay.portlet.service.EpisodeLocalService getEpisodeLocalService() {
		return episodeLocalService;
	}

	/**
	 * Sets the episode local service.
	 *
	 * @param episodeLocalService the episode local service
	 */
	public void setEpisodeLocalService(
		hu.webtown.liferay.portlet.service.EpisodeLocalService episodeLocalService) {
		this.episodeLocalService = episodeLocalService;
	}

	/**
	 * Returns the episode remote service.
	 *
	 * @return the episode remote service
	 */
	public hu.webtown.liferay.portlet.service.EpisodeService getEpisodeService() {
		return episodeService;
	}

	/**
	 * Sets the episode remote service.
	 *
	 * @param episodeService the episode remote service
	 */
	public void setEpisodeService(
		hu.webtown.liferay.portlet.service.EpisodeService episodeService) {
		this.episodeService = episodeService;
	}

	/**
	 * Returns the episode persistence.
	 *
	 * @return the episode persistence
	 */
	public EpisodePersistence getEpisodePersistence() {
		return episodePersistence;
	}

	/**
	 * Sets the episode persistence.
	 *
	 * @param episodePersistence the episode persistence
	 */
	public void setEpisodePersistence(EpisodePersistence episodePersistence) {
		this.episodePersistence = episodePersistence;
	}

	/**
	 * Returns the season local service.
	 *
	 * @return the season local service
	 */
	public hu.webtown.liferay.portlet.service.SeasonLocalService getSeasonLocalService() {
		return seasonLocalService;
	}

	/**
	 * Sets the season local service.
	 *
	 * @param seasonLocalService the season local service
	 */
	public void setSeasonLocalService(
		hu.webtown.liferay.portlet.service.SeasonLocalService seasonLocalService) {
		this.seasonLocalService = seasonLocalService;
	}

	/**
	 * Returns the season remote service.
	 *
	 * @return the season remote service
	 */
	public hu.webtown.liferay.portlet.service.SeasonService getSeasonService() {
		return seasonService;
	}

	/**
	 * Sets the season remote service.
	 *
	 * @param seasonService the season remote service
	 */
	public void setSeasonService(
		hu.webtown.liferay.portlet.service.SeasonService seasonService) {
		this.seasonService = seasonService;
	}

	/**
	 * Returns the season persistence.
	 *
	 * @return the season persistence
	 */
	public SeasonPersistence getSeasonPersistence() {
		return seasonPersistence;
	}

	/**
	 * Sets the season persistence.
	 *
	 * @param seasonPersistence the season persistence
	 */
	public void setSeasonPersistence(SeasonPersistence seasonPersistence) {
		this.seasonPersistence = seasonPersistence;
	}

	/**
	 * Returns the tv show local service.
	 *
	 * @return the tv show local service
	 */
	public hu.webtown.liferay.portlet.service.TvShowLocalService getTvShowLocalService() {
		return tvShowLocalService;
	}

	/**
	 * Sets the tv show local service.
	 *
	 * @param tvShowLocalService the tv show local service
	 */
	public void setTvShowLocalService(
		hu.webtown.liferay.portlet.service.TvShowLocalService tvShowLocalService) {
		this.tvShowLocalService = tvShowLocalService;
	}

	/**
	 * Returns the tv show remote service.
	 *
	 * @return the tv show remote service
	 */
	public hu.webtown.liferay.portlet.service.TvShowService getTvShowService() {
		return tvShowService;
	}

	/**
	 * Sets the tv show remote service.
	 *
	 * @param tvShowService the tv show remote service
	 */
	public void setTvShowService(
		hu.webtown.liferay.portlet.service.TvShowService tvShowService) {
		this.tvShowService = tvShowService;
	}

	/**
	 * Returns the tv show persistence.
	 *
	 * @return the tv show persistence
	 */
	public TvShowPersistence getTvShowPersistence() {
		return tvShowPersistence;
	}

	/**
	 * Sets the tv show persistence.
	 *
	 * @param tvShowPersistence the tv show persistence
	 */
	public void setTvShowPersistence(TvShowPersistence tvShowPersistence) {
		this.tvShowPersistence = tvShowPersistence;
	}

	/**
	 * Returns the tv show finder.
	 *
	 * @return the tv show finder
	 */
	public TvShowFinder getTvShowFinder() {
		return tvShowFinder;
	}

	/**
	 * Sets the tv show finder.
	 *
	 * @param tvShowFinder the tv show finder
	 */
	public void setTvShowFinder(TvShowFinder tvShowFinder) {
		this.tvShowFinder = tvShowFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the asset entry local service.
	 *
	 * @return the asset entry local service
	 */
	public com.liferay.portlet.asset.service.AssetEntryLocalService getAssetEntryLocalService() {
		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService) {
		this.assetEntryLocalService = assetEntryLocalService;
	}

	/**
	 * Returns the asset entry remote service.
	 *
	 * @return the asset entry remote service
	 */
	public com.liferay.portlet.asset.service.AssetEntryService getAssetEntryService() {
		return assetEntryService;
	}

	/**
	 * Sets the asset entry remote service.
	 *
	 * @param assetEntryService the asset entry remote service
	 */
	public void setAssetEntryService(
		com.liferay.portlet.asset.service.AssetEntryService assetEntryService) {
		this.assetEntryService = assetEntryService;
	}

	/**
	 * Returns the asset entry persistence.
	 *
	 * @return the asset entry persistence
	 */
	public AssetEntryPersistence getAssetEntryPersistence() {
		return assetEntryPersistence;
	}

	/**
	 * Sets the asset entry persistence.
	 *
	 * @param assetEntryPersistence the asset entry persistence
	 */
	public void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {
		this.assetEntryPersistence = assetEntryPersistence;
	}

	/**
	 * Returns the asset link local service.
	 *
	 * @return the asset link local service
	 */
	public com.liferay.portlet.asset.service.AssetLinkLocalService getAssetLinkLocalService() {
		return assetLinkLocalService;
	}

	/**
	 * Sets the asset link local service.
	 *
	 * @param assetLinkLocalService the asset link local service
	 */
	public void setAssetLinkLocalService(
		com.liferay.portlet.asset.service.AssetLinkLocalService assetLinkLocalService) {
		this.assetLinkLocalService = assetLinkLocalService;
	}

	/**
	 * Returns the asset link persistence.
	 *
	 * @return the asset link persistence
	 */
	public AssetLinkPersistence getAssetLinkPersistence() {
		return assetLinkPersistence;
	}

	/**
	 * Sets the asset link persistence.
	 *
	 * @param assetLinkPersistence the asset link persistence
	 */
	public void setAssetLinkPersistence(
		AssetLinkPersistence assetLinkPersistence) {
		this.assetLinkPersistence = assetLinkPersistence;
	}

	/**
	 * Returns the expando value local service.
	 *
	 * @return the expando value local service
	 */
	public com.liferay.portlet.expando.service.ExpandoValueLocalService getExpandoValueLocalService() {
		return expandoValueLocalService;
	}

	/**
	 * Sets the expando value local service.
	 *
	 * @param expandoValueLocalService the expando value local service
	 */
	public void setExpandoValueLocalService(
		com.liferay.portlet.expando.service.ExpandoValueLocalService expandoValueLocalService) {
		this.expandoValueLocalService = expandoValueLocalService;
	}

	/**
	 * Returns the expando value remote service.
	 *
	 * @return the expando value remote service
	 */
	public com.liferay.portlet.expando.service.ExpandoValueService getExpandoValueService() {
		return expandoValueService;
	}

	/**
	 * Sets the expando value remote service.
	 *
	 * @param expandoValueService the expando value remote service
	 */
	public void setExpandoValueService(
		com.liferay.portlet.expando.service.ExpandoValueService expandoValueService) {
		this.expandoValueService = expandoValueService;
	}

	/**
	 * Returns the expando value persistence.
	 *
	 * @return the expando value persistence
	 */
	public ExpandoValuePersistence getExpandoValuePersistence() {
		return expandoValuePersistence;
	}

	/**
	 * Sets the expando value persistence.
	 *
	 * @param expandoValuePersistence the expando value persistence
	 */
	public void setExpandoValuePersistence(
		ExpandoValuePersistence expandoValuePersistence) {
		this.expandoValuePersistence = expandoValuePersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return TvShow.class;
	}

	protected String getModelClassName() {
		return TvShow.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = tvShowPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = hu.webtown.liferay.portlet.service.EpisodeLocalService.class)
	protected hu.webtown.liferay.portlet.service.EpisodeLocalService episodeLocalService;
	@BeanReference(type = hu.webtown.liferay.portlet.service.EpisodeService.class)
	protected hu.webtown.liferay.portlet.service.EpisodeService episodeService;
	@BeanReference(type = EpisodePersistence.class)
	protected EpisodePersistence episodePersistence;
	@BeanReference(type = hu.webtown.liferay.portlet.service.SeasonLocalService.class)
	protected hu.webtown.liferay.portlet.service.SeasonLocalService seasonLocalService;
	@BeanReference(type = hu.webtown.liferay.portlet.service.SeasonService.class)
	protected hu.webtown.liferay.portlet.service.SeasonService seasonService;
	@BeanReference(type = SeasonPersistence.class)
	protected SeasonPersistence seasonPersistence;
	@BeanReference(type = hu.webtown.liferay.portlet.service.TvShowLocalService.class)
	protected hu.webtown.liferay.portlet.service.TvShowLocalService tvShowLocalService;
	@BeanReference(type = hu.webtown.liferay.portlet.service.TvShowService.class)
	protected hu.webtown.liferay.portlet.service.TvShowService tvShowService;
	@BeanReference(type = TvShowPersistence.class)
	protected TvShowPersistence tvShowPersistence;
	@BeanReference(type = TvShowFinder.class)
	protected TvShowFinder tvShowFinder;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetEntryLocalService.class)
	protected com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetEntryService.class)
	protected com.liferay.portlet.asset.service.AssetEntryService assetEntryService;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetLinkLocalService.class)
	protected com.liferay.portlet.asset.service.AssetLinkLocalService assetLinkLocalService;
	@BeanReference(type = AssetLinkPersistence.class)
	protected AssetLinkPersistence assetLinkPersistence;
	@BeanReference(type = com.liferay.portlet.expando.service.ExpandoValueLocalService.class)
	protected com.liferay.portlet.expando.service.ExpandoValueLocalService expandoValueLocalService;
	@BeanReference(type = com.liferay.portlet.expando.service.ExpandoValueService.class)
	protected com.liferay.portlet.expando.service.ExpandoValueService expandoValueService;
	@BeanReference(type = ExpandoValuePersistence.class)
	protected ExpandoValuePersistence expandoValuePersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private TvShowServiceClpInvoker _clpInvoker = new TvShowServiceClpInvoker();
}