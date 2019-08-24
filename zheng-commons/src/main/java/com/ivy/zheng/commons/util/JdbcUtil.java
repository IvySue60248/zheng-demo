package com.ivy.zheng.commons.util;

import org.apache.commons.collections.CollectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JdbcUtil class
 *
 * @author ivy.xue
 * @date 2019/08/23
 */
public class JdbcUtil {

    private Connection conn;
    private PreparedStatement pstmt;
    // 定义查询返回的结果集合
    private ResultSet rs;

    public JdbcUtil(String jdbcDriver, String jdbcUrl, String jdbcUsername, String jdbcPassword) {
        try {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public List<Map<String, Object>> selectByParams(String sql, List params) throws SQLException{
        List<Map<String, Object>> list = new ArrayList<>();
        pstmt = conn.prepareStatement(sql);
        if (CollectionUtils.isNotEmpty(params)) {
            for (int i = 0; i < params.size(); i ++) {
                pstmt.setObject(i+1, params.get(i));
            }
        }
        rs = pstmt.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int columsLen = metaData.getColumnCount();
        while(rs.next()) {
            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < columsLen; i ++) {
                String columnName = metaData.getColumnName(i + 1);
                Object columnValue = rs.getObject(columnName);
                if (null == columnValue) {
                    columnValue = "";
                }
                map.put(columnName, columnValue);
            }
            list.add(map);
        }
        return list;
    }
}
