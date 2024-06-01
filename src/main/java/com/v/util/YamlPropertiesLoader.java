package com.v.util;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.yaml.snakeyaml.Yaml;

public class YamlPropertiesLoader {

	public static Properties loadYamlIntoProperties(String yamlFileName) {
		Yaml yaml = new Yaml();
		Properties properties = new Properties();

		try (InputStream inputStream = YamlPropertiesLoader.class.getClassLoader().getResourceAsStream(yamlFileName)) {
			if (inputStream == null) {
				throw new IllegalArgumentException("YAML file not found: " + yamlFileName);
			}

			Map<String, Object> yamlMap = yaml.load(inputStream);
			flattenYamlMap("", yamlMap, properties);
		} catch (Exception e) {
			throw new RuntimeException("Failed to load YAML file: " + yamlFileName, e);
		}

		return properties;
	}

	private static void flattenYamlMap(String parentKey, Map<String, Object> yamlMap, Properties properties) {
		for (Map.Entry<String, Object> entry : yamlMap.entrySet()) {
			String key = parentKey.isEmpty() ? entry.getKey() : parentKey + "." + entry.getKey();
			Object value = entry.getValue();

			if (value instanceof Map) {
				flattenYamlMap(key, (Map<String, Object>) value, properties);
			} else {
				properties.put(key, value.toString());
			}
		}
	}
}
