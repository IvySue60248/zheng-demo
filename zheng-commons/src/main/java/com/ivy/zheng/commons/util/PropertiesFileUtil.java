package com.ivy.zheng.commons.util;

import java.util.ResourceBundle;

/**
 * Properties工具类
 * 加载properties配置文件，并从中读取值
 * @author i505137
 * @date 2019/08/23
 */
public class PropertiesFileUtil {

    private static ResourceBundle resourceBundle = null;
    private volatile static PropertiesFileUtil instance = null;

    private PropertiesFileUtil(String configFile) {
        resourceBundle = ResourceBundle.getBundle(configFile);
    }

    public static PropertiesFileUtil getInstance(String configFile) {
        if (instance == null) {
            synchronized (PropertiesFileUtil.class) {
                if (instance == null) {
                    instance = new PropertiesFileUtil(configFile);
                }
            }
        }
        return instance;
    }

    public String getValue(String key) {
        return resourceBundle.getString(key);
    }
}
