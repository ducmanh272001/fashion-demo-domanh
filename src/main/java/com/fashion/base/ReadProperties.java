package com.fashion.base;

import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	private static Properties properties;

	private ReadProperties() {
	}

	static {
		try {
			InputStream enStream = ReadProperties.class.getClassLoader()
					.getResourceAsStream("language/mess_lag_en_US.properties");
			InputStream jpStream = ReadProperties.class.getClassLoader()
					.getResourceAsStream("language/mess_lag_ja_JP.properties");
			InputStream krStream = ReadProperties.class.getClassLoader()
					.getResourceAsStream("language/mess_lag_ko_KR.properties");
			InputStream laStream = ReadProperties.class.getClassLoader()
					.getResourceAsStream("language/mess_lag_lo_LA.properties");
			InputStream viStream = ReadProperties.class.getClassLoader()
					.getResourceAsStream("language/mess_lag_vi_VN.properties");
			properties = new Properties();
			properties.load(enStream);
			properties.load(jpStream);
			properties.load(krStream);
			properties.load(laStream);
			properties.load(viStream);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static Properties getProperties() {
		return ReadProperties.getProperties();
	}

}
