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

package hu.webtown.liferay.portlet.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author czeni
 */
public class TvShowFinderUtil {
	public static java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByPremierYear(
		int premierYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByPremierYear(premierYear, start, end);
	}

	public static java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByPremierYear(
		int premierYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByPremierYear(premierYear);
	}

	public static java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByG_P(
		long groupId, int premierYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByG_P(groupId, premierYear, start, end);
	}

	public static java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByG_P(
		long groupId, int premierYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByG_P(groupId, premierYear);
	}

	public static java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByC_G_T_D_PG_PL(
		long groupId, java.lang.String tvShowTitle,
		java.lang.String tvShowDescription, int tvShowPremierYearGT,
		int tvShowPremierYearLT, boolean andOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_G_T_D_PG_PL(groupId, tvShowTitle,
			tvShowDescription, tvShowPremierYearGT, tvShowPremierYearLT,
			andOperator, start, end, obc);
	}

	public static java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByKeyWords(
		long groupId, java.lang.String keywords, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByKeyWords(groupId, keywords, start, end, obc);
	}

	public static java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByKeyWords(
		long groupId, java.lang.String keywords,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByKeyWords(groupId, keywords, obc);
	}

	public static int countByKeyWords(long groupId, java.lang.String keywords,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByKeyWords(groupId, keywords, start, end);
	}

	public static int countByKeyWords(long groupId, java.lang.String keywords)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByKeyWords(groupId, keywords);
	}

	public static TvShowFinder getFinder() {
		if (_finder == null) {
			_finder = (TvShowFinder)PortletBeanLocatorUtil.locate(hu.webtown.liferay.portlet.service.ClpSerializer.getServletContextName(),
					TvShowFinder.class.getName());

			ReferenceRegistry.registerReference(TvShowFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(TvShowFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TvShowFinderUtil.class, "_finder");
	}

	private static TvShowFinder _finder;
}