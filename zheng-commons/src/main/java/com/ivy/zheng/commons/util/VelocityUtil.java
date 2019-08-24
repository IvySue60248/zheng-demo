package com.ivy.zheng.commons.util;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;

public class VelocityUtil {

    public static void generate(String inputVmFilePath, String outputFilePath, VelocityContext ctx) throws Exception{
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        Template t = ve.getTemplate(getFile(inputVmFilePath), "utf-8");
        File outputFile = new File(outputFilePath);
        FileWriterWithEncoding writer = new FileWriterWithEncoding(outputFile, "utf-8");
        t.merge(ctx, writer);
        writer.close();
    }

    /**
     * 根据文件绝对路径截取文件名
     * @param filePath
     * @return
     */
    public static String getFile(String filePath) {
        String file = "";
        if (StringUtils.isNotBlank(filePath)) {
            file = filePath.substring(filePath.lastIndexOf("/") + 1);
        }
        return file;
    }
}
