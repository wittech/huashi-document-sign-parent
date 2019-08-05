package com.louis.kitty.admin.util;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;

public class FreemarkerUtil {

    private static String DEFAULT_CHARSET = "UTF-8";
    private static Configuration configuration;

    static {
        configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setDefaultEncoding(DEFAULT_CHARSET);
        configuration.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);
    }

    /**
     * 填充freemarker元素
     *
     * @param content 模板文件
     * @param values  模板变量内容
     * @return html内容
     */
    public static String parse(String content, Object values) {
        try {

            StringTemplateLoader stringLoader = new StringTemplateLoader();
            stringLoader.putTemplate("myTemplate", content);
            configuration.setTemplateLoader(stringLoader);
            // 这个一定要设置，不然在生成的页面中 会乱码
            configuration.setDefaultEncoding(DEFAULT_CHARSET);
            configuration.setLogTemplateExceptions(false);

            Template template = configuration.getTemplate("myTemplate", "UTF-8");
            StringWriter writer = new StringWriter();
            template.process(values, writer);


            return writer.toString();
//            org.jsoup.nodes.Document doc = Jsoup.parse(writer.toString());

//            return doc.html();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
