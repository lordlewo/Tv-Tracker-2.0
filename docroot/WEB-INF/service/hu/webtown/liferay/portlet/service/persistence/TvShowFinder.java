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

/**
 * @author czeni
 */
public interface TvShowFinder {
	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByPremierYear(
		int premierYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByPremierYear(
		int premierYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByG_P(
		long groupId, int premierYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByG_P(
		long groupId, int premierYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByC_G_T_D_PG_PL(
		long companyId, long groupId, java.lang.String tvShowTitle,
		java.lang.String tvShowDescription, int tvShowPremierYearGT,
		int tvShowPremierYearLT, boolean andOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByC_G_T_D_PG_PL(
		long companyId, long groupId, java.lang.String tvShowTitle,
		java.lang.String tvShowDescription, int tvShowPremierYearGT,
		int tvShowPremierYearLT, boolean andOperator,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByC_G_T_D_PG_PL(long companyId, long groupId,
		java.lang.String tvShowTitle, java.lang.String tvShowDescription,
		int tvShowPremierYearGT, int tvShowPremierYearLT, boolean andOperator,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByC_G_T_D_PG_PL(long companyId, long groupId,
		java.lang.String tvShowTitle, java.lang.String tvShowDescription,
		int tvShowPremierYearGT, int tvShowPremierYearLT, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByKeyWords(
		long companyId, long groupId, java.lang.String keywords, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<hu.webtown.liferay.portlet.model.TvShow> findByKeyWords(
		long companyId, long groupId, java.lang.String keywords,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByKeyWords(long companyId, long groupId,
		java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByKeyWords(long companyId, long groupId,
		java.lang.String keywords)
		throws com.liferay.portal.kernel.exception.SystemException;
}