package com.cheer.mini.base.util;

import com.cheer.mini.base.spring.SpringContextHolder;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import net.sf.ehcache.CacheManager;

public final class CacheUtil {
	private static CacheManager cacheManager = SpringContextHolder.getBean("cacheManager");
	private final static String DICT_NAMESPACE = "DICT";

	public static void put(String key, Object object) {
		Cache dict = cacheManager.getCache(DICT_NAMESPACE);
		if (dict == null) {
			cacheManager.addCache(DICT_NAMESPACE);
		}
		dict = cacheManager.getCache(DICT_NAMESPACE);
		Element element = new Element(key, object);
		dict.put(element);
	}

	public static Object get(String key) {
		Cache dict = cacheManager.getCache(DICT_NAMESPACE);
		if (dict == null) {
			cacheManager.addCache(DICT_NAMESPACE);
		}
		dict = cacheManager.getCache(DICT_NAMESPACE);
		return dict.get(key) == null ? null : dict.get(key).getValue();
	}

}
