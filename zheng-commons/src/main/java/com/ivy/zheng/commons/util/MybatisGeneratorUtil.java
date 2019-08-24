package com.ivy.zheng.commons.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.VelocityContext;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.api.VerboseProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class MybatisGeneratorUtil {

    private static String generatorConfig_vm = "/template/generatorConfig.vm";

    public static void generate(String jdbcDriver,
                                String jdbcUrl,
                                String jdbcUsername,
                                String jdbcPassword,
                                String database,
                                String tablePrefix,
                                String packageName,
                                Map<String, String> needInsertIdTables) throws Exception {

        log.info("========== 开始生成generatorConfig.xml文件 ==========");
        VelocityContext ctx = new VelocityContext();

        List<Map<String, Object>> tables = new ArrayList<>();

        JdbcUtil jdbcUtil = new JdbcUtil(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
        String sql = "SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = '" + database + "' and table_name like '" + tablePrefix + "_%'";
        List<Map<String, Object>> result = jdbcUtil.selectByParams(sql, null);
        for (Map map : result) {
            Map<String, Object> table = new HashMap<>();
            table.put("table_name", map.get("TABLE_NAME"));
            table.put("model_name", StringUtil.lineToHump((String) map.get("TABLE_NAME")));
            tables.add(table);
        }

        String basePath = MybatisGeneratorUtil.class.getResource("/").getPath();
        String targetProject = basePath.substring(0, basePath.indexOf("/target/class"));

        // 将数据放入context中
        ctx.put("generator_jdbc_password", jdbcPassword);
        ctx.put("generator_javaModelGenerator_targetPackage", packageName + ".dao.model");
        ctx.put("generator_sqlMapGenerator_targetPackage", packageName + ".dao.mapper");
        ctx.put("generator_javaClientGenerator_targetPackage", packageName + ".dao.mapper");
        ctx.put("target_project", targetProject);
        ctx.put("need_insert_id_tables", needInsertIdTables);
        ctx.put("tables", tables);

        String generatorConfigXmlPath = MybatisGeneratorUtil.class.getResource("/").getPath().replace("/target/classes/", "") + "/src/main/resources/generatorConfig.xml";

        VelocityUtil.generate(generatorConfig_vm, generatorConfigXmlPath, ctx);
        log.info("========== 结束生成generatorConfig.xml文件 ==========");

        log.info("========== 删除旧文件 ========");
        deleteDir(new File(targetProject + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/dao/model"));
        deleteDir(new File(targetProject + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/dao/mapper"));


        log.info("========== 开始执行generatorConfig.xml文件 ==========");
        List<String> warnings = new ArrayList<String>();
        //ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        //InputStream is = classloader.getResourceAsStream("generatorConfig.xml");
        File configFile = new File(generatorConfigXmlPath);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        ProgressCallback progressCallback = new VerboseProgressCallback();
        myBatisGenerator.generate(progressCallback);

        for (String warning : warnings) {
            log.warn(warning);
        }
        log.info("========== 结束执行generatorConfig.xml文件 ==========");

    }

    // 递归删除非空文件夹
    public static void deleteDir(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteDir(files[i]);
            }
        }
        dir.delete();
    }


}
