package com.ivy.zheng.upms.dao;

import com.ivy.zheng.commons.util.MybatisGeneratorUtil;
import com.ivy.zheng.commons.util.PropertiesFileUtil;

import java.util.HashMap;
import java.util.Map;

public class Generator {

    private static String MODULE = "zheng-upms";
    private static String DATABASE = "zheng";
    private static String TABLE_PREFIX = "upms";
    private static String PACKAGE_NAME = "com.ivy.zheng.upms";
    private static String JDBC_DRIVER = PropertiesFileUtil.getInstance("generator").getValue("generator.jdbc.driver");
    private static String JDBC_URL = PropertiesFileUtil.getInstance("generator").getValue("generator.jdbc.url");
    private static String JDBC_USERNAME = PropertiesFileUtil.getInstance("generator").getValue("generator.jdbc.username");
    private static String JDBC_PASSWORD = PropertiesFileUtil.getInstance("generator").getValue("generator.jdbc.password");
    private static Map<String, String> NEED_INSERT_ID_TABLES = new HashMap<String, String>();
    static {
        NEED_INSERT_ID_TABLES.put("upms_user", "user_id");
    }

    public static void main(String[] args) throws Exception{
        MybatisGeneratorUtil.generate(JDBC_DRIVER, JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD, DATABASE, TABLE_PREFIX, PACKAGE_NAME, NEED_INSERT_ID_TABLES);
    }
}
