package com.louis.kitty.admin.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;

import java.io.FileOutputStream;
import java.io.IOException;

public class PdfUtil {

    /**
     * 合并PDF文件
     * @param sourceFiles 需要合并文件數組(绝对路径如{ "e:\\1.pdf", "e:\\2.pdf"
     * @param targetFile 合并后的目标文件（绝对路径）
     * @throws IOException 文件流异常
     * @throws DocumentException PDF文件异常
     */
    public static void mergeFiles(String[] sourceFiles, String targetFile) throws IOException, DocumentException {
        Document document = null;
        try {
            Rectangle firstFilePageSize = new PdfReader(sourceFiles[0]).getPageSize(1);

            document = new Document(firstFilePageSize);
            PdfCopy copy = new PdfCopy(document, new FileOutputStream(targetFile));
            document.open();

            for (String sourceFile : sourceFiles) {
                PdfReader reader = new PdfReader(sourceFile);
                int n = reader.getNumberOfPages();
                for (int j = 1; j <= n; j++) {
                    document.newPage();
                    PdfImportedPage page = copy.getImportedPage(reader, j);
                    copy.addPage(page);
                }
            }

        } finally {
            if (document != null) {
                document.close();
            }
        }
    }

}
