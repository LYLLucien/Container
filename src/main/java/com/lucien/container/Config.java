package com.lucien.container;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map.*;
import java.util.Map;
import java.util.Set;
import java.util.Properties;

public class Config {

    private static volatile Config config;
    private Map<Object, Object> configMap;
    private final static Object lock = new Object();
    private static final String filename = "config.properties";

    public static Config getConfig() {
        if (config == null) {
            synchronized (lock) {
                if (config == null) {
                    config = new Config();
                }
            }
        }
        return config;
    }

    public static Config getConfig(HashMap<Object, Object> configMap) {
        if (config == null) {
            synchronized (lock) {
                if (config == null) {
                    config = new Config(configMap);
                }
            }
        }
        return config;
    }

    private Config() {
        Properties prop = new Properties();
        InputStream in;
        configMap = new HashMap<Object, Object>();

        try {
            in = getClass().getClassLoader().getResourceAsStream(filename);
            prop.load(in);
            for (Entry<Object, Object> entry : prop.entrySet()) {
                configMap.put(entry.getKey(), entry.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Config(HashMap<Object, Object> configMap) {
        this.configMap = configMap;
    }
}
