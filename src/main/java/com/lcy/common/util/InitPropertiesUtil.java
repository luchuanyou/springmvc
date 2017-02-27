package com.lcy.common.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class InitPropertiesUtil extends PropertyPlaceholderConfigurer {
	private static Map<String, String> map = new HashMap<String, String>();

	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactory, Properties props) {
		super.processProperties(beanFactory, props);
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			map.put(keyStr, value);
		}
		System.out.println("===========test=========="+map);
	}

	public static String getProperty(String key) {
		return map.get(key);
	}
}
