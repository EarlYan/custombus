package com.dzbs.util.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 配置文件读取
 * 
 * @author earlyan
 * 
 */
@Component
public class ConfigProperties {

	private static Logger log = Logger.getLogger(ConfigProperties.class);

	private static Map<String, String> map = new HashMap<String, String>();
	/**
	 * 配置文件名
	 */
	private final String propertiesFileName = "jdbc.properties";
	

	private ConfigProperties() {// 初始化.载入配置文件
		Properties prop = new Properties();
		try {
			prop.load(ConfigProperties.class.getClassLoader()
					.getResourceAsStream(this.propertiesFileName));
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		Set<Entry<Object, Object>> proSet = prop.entrySet();
		for (Entry<Object, Object> en : proSet) {
			map.put((String) en.getKey(), (String) en.getValue());
		}
		log.info("配置文件载入完成");
	}

	/***
	 * 获取配置
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return ConfigProperties.map.get(key);
	}

}
