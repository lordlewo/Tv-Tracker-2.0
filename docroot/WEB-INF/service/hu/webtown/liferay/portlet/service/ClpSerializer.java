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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import hu.webtown.liferay.portlet.model.EpisodeClp;
import hu.webtown.liferay.portlet.model.SeasonClp;
import hu.webtown.liferay.portlet.model.TvShowClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author czeni
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"tv-tracker-2.0-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"tv-tracker-2.0-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "tv-tracker-2.0-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(EpisodeClp.class.getName())) {
			return translateInputEpisode(oldModel);
		}

		if (oldModelClassName.equals(SeasonClp.class.getName())) {
			return translateInputSeason(oldModel);
		}

		if (oldModelClassName.equals(TvShowClp.class.getName())) {
			return translateInputTvShow(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputEpisode(BaseModel<?> oldModel) {
		EpisodeClp oldClpModel = (EpisodeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEpisodeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSeason(BaseModel<?> oldModel) {
		SeasonClp oldClpModel = (SeasonClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSeasonRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTvShow(BaseModel<?> oldModel) {
		TvShowClp oldClpModel = (TvShowClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTvShowRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"hu.webtown.liferay.portlet.model.impl.EpisodeImpl")) {
			return translateOutputEpisode(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"hu.webtown.liferay.portlet.model.impl.SeasonImpl")) {
			return translateOutputSeason(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"hu.webtown.liferay.portlet.model.impl.TvShowImpl")) {
			return translateOutputTvShow(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"hu.webtown.liferay.portlet.EpisodeAirDateException")) {
			return new hu.webtown.liferay.portlet.EpisodeAirDateException();
		}

		if (className.equals(
					"hu.webtown.liferay.portlet.EpisodeDescriptionException")) {
			return new hu.webtown.liferay.portlet.EpisodeDescriptionException();
		}

		if (className.equals("hu.webtown.liferay.portlet.EpisodeImageException")) {
			return new hu.webtown.liferay.portlet.EpisodeImageException();
		}

		if (className.equals(
					"hu.webtown.liferay.portlet.EpisodeNumberException")) {
			return new hu.webtown.liferay.portlet.EpisodeNumberException();
		}

		if (className.equals("hu.webtown.liferay.portlet.EpisodeTitleException")) {
			return new hu.webtown.liferay.portlet.EpisodeTitleException();
		}

		if (className.equals(
					"hu.webtown.liferay.portlet.SeasonDescriptionException")) {
			return new hu.webtown.liferay.portlet.SeasonDescriptionException();
		}

		if (className.equals("hu.webtown.liferay.portlet.SeasonImageException")) {
			return new hu.webtown.liferay.portlet.SeasonImageException();
		}

		if (className.equals("hu.webtown.liferay.portlet.SeasonNumberException")) {
			return new hu.webtown.liferay.portlet.SeasonNumberException();
		}

		if (className.equals(
					"hu.webtown.liferay.portlet.SeasonPremierDateException")) {
			return new hu.webtown.liferay.portlet.SeasonPremierDateException();
		}

		if (className.equals("hu.webtown.liferay.portlet.SeasonTitleException")) {
			return new hu.webtown.liferay.portlet.SeasonTitleException();
		}

		if (className.equals(
					"hu.webtown.liferay.portlet.TvShowDescriptionException")) {
			return new hu.webtown.liferay.portlet.TvShowDescriptionException();
		}

		if (className.equals("hu.webtown.liferay.portlet.TvShowImageException")) {
			return new hu.webtown.liferay.portlet.TvShowImageException();
		}

		if (className.equals(
					"hu.webtown.liferay.portlet.TvShowPremierDateException")) {
			return new hu.webtown.liferay.portlet.TvShowPremierDateException();
		}

		if (className.equals("hu.webtown.liferay.portlet.TvShowTitleException")) {
			return new hu.webtown.liferay.portlet.TvShowTitleException();
		}

		if (className.equals(
					"hu.webtown.liferay.portlet.NoSuchEpisodeException")) {
			return new hu.webtown.liferay.portlet.NoSuchEpisodeException();
		}

		if (className.equals("hu.webtown.liferay.portlet.NoSuchSeasonException")) {
			return new hu.webtown.liferay.portlet.NoSuchSeasonException();
		}

		if (className.equals("hu.webtown.liferay.portlet.NoSuchTvShowException")) {
			return new hu.webtown.liferay.portlet.NoSuchTvShowException();
		}

		return throwable;
	}

	public static Object translateOutputEpisode(BaseModel<?> oldModel) {
		EpisodeClp newModel = new EpisodeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEpisodeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSeason(BaseModel<?> oldModel) {
		SeasonClp newModel = new SeasonClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSeasonRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTvShow(BaseModel<?> oldModel) {
		TvShowClp newModel = new TvShowClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTvShowRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}