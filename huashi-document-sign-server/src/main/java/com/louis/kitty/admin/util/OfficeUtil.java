package com.louis.kitty.admin.util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class OfficeUtil {

    private static final Logger logger = LoggerFactory.getLogger(OfficeUtil.class);

    /**
     * PDF 格式
     */
    private static final int wdFormatPDF = 17;
    private static final Integer EXCEL_TO_PDF_OPERAND = 0;

    private static void removeIfExists(String targetFileName) {
        File file = new File(targetFileName);
        if (file.exists()) {
            file.delete();
            logger.warn("targetFileName[{}] removed cause by 'exists'", targetFileName);
        }
    }

    /**
     * word转换为PDF
     *
     * @param sourceFileName 原文件名称（WORD）
     * @param targetFileName 转换后的新文件名称（PDF）
     */
    public static void word2Pdf(String sourceFileName, String targetFileName) throws Exception {
        logger.info("word#sourceFileName[{}] transform start ...", sourceFileName);
        long startTime = System.currentTimeMillis();
        ActiveXComponent app = null;
        Dispatch doc = null;
        try {
            app = new ActiveXComponent("Word.Application");
            app.setProperty("Visible", new Variant(false));
            Dispatch docs = app.getProperty("Documents").toDispatch();
            // 打开文档
            doc = Dispatch.call(docs, "Open", sourceFileName).toDispatch();

            removeIfExists(targetFileName);

            // 另存为
            Dispatch.call(doc, "SaveAs", targetFileName, wdFormatPDF);

            logger.info("$$word#sourceFileName[{}] transform finished, it cost {} ms ", sourceFileName,
                    (System.currentTimeMillis() - startTime));

        } catch (Exception e) {
            logger.error("word#sourceFileName[{}] transform failed", sourceFileName, e);
            throw e;
        } finally {
            // 关闭文档
            if (doc != null) {
                Dispatch.call(doc, "Close", false);
            }

            if (app != null) {
                app.invoke("Quit", new Variant[]{});
            }

            // 如果没有这句话,winword.exe进程将不会关闭
            ComThread.Release();
        }
    }

    /**
     * excel转换为PDF
     *
     * @param sourceFileName 原文件名称（EXCEL）
     * @param targetFileName 转换后的新文件名称（PDF）
     */
    public static void excel2Pdf(String sourceFileName, String targetFileName) throws Exception {
        logger.info("excel#sourceFileName[{}] transform start ...", sourceFileName);
        long startTime = System.currentTimeMillis();
        ActiveXComponent ax = null;
        Dispatch excel = null;
        try {
            ComThread.InitSTA();
            ax = new ActiveXComponent("Excel.Application");
            ax.setProperty("Visible", new Variant(false));
            ax.setProperty("AutomationSecurity", new Variant(3)); // 禁用宏
            Dispatch excels = ax.getProperty("Workbooks").toDispatch();

            Object[] obj = new Object[]{sourceFileName, new Variant(false),
                    new Variant(false)
            };
            excel = Dispatch.invoke(excels, "Open", Dispatch.Method, obj, new int[9]).toDispatch();

            // 转换格式 PDF格式=0
            Object[] obj2 = new Object[]{new Variant(EXCEL_TO_PDF_OPERAND),
                    targetFileName,
                    //0=标准 (生成的PDF图片不会变模糊) ; 1=最小文件
                    new Variant(0)
            };
            Dispatch.invoke(excel, "ExportAsFixedFormat", Dispatch.Method, obj2, new int[1]);

            logger.info("$$excel#sourceFileName[{}] transform finished, it cost {} ms ", sourceFileName,
                    (System.currentTimeMillis() - startTime));

        } catch (Exception e) {
            logger.error("excel#sourceFileName[{}] transform failed", sourceFileName, e);
            throw e;
        } finally {
            if (excel != null) {
                Dispatch.call(excel, "Close", new Variant(false));
            }
            if (ax != null) {
                ax.invoke("Quit", new Variant[]{});
                ax = null;
            }
            ComThread.Release();
        }

    }

    public static void main(String[] args) {

        try {
            excel2Pdf("f:\\8.xls", "f:\\8.pdf");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
