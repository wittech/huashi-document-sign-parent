package com.louis.kitty.admin.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
public class PdfUtil {

    /**
     * 水印字体倾斜角度控制，水印文字成30度角倾斜
     */
    private static final int FONT_TEXT_INTERVAL = -8;

    /**
     * 合并PDF文件
     *
     * @param sourceFiles 需要合并文件數組(绝对路径如{ "e:\\1.pdf", "e:\\2.pdf"
     * @param targetFile  合并后的目标文件（绝对路径）
     * @throws IOException       文件流异常
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

    /**
     * @param inputFile     PDF文件地址
     * @param outputFile    添加水印后生成PDF存放的地址
     * @param waterMarkName 你的水印
     */
    public static void waterMark(String inputFile, String outputFile, String waterMarkName)
            throws Exception {
        PdfReader reader = new PdfReader(inputFile);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(
                outputFile));

        BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);

        Rectangle pageRect;
        PdfGState gs = new PdfGState();
        // 透明度，越小透明度越高，颜色越浅
        gs.setFillOpacity(0.1f);
//        gs.setStrokeOpacity(0.9f);
        int total = reader.getNumberOfPages() + 1;

        JLabel label = new JLabel();
        FontMetrics metrics;
        label.setText(waterMarkName);
        metrics = label.getFontMetrics(label.getFont());
        int textH = metrics.getHeight();
        int textW = metrics.stringWidth(label.getText());

        PdfContentByte under;
        for (int i = 1; i < total; i++) {
            pageRect = reader.getPageSizeWithRotation(i);
            under = stamper.getOverContent(i);
            under.saveState();
            under.setGState(gs);
            under.beginText();
            under.setFontAndSize(base, 20);

            // 水印文字成30度角倾斜
            //你可以随心所欲的改你自己想要的角度
            for (int height = FONT_TEXT_INTERVAL + textH; height < pageRect.getHeight();

                 // * 5 控制多个水印字体的间距高度， 数值越大距离越大
                 height = height + textH * 5) {
                for (int width = FONT_TEXT_INTERVAL + textW; width < pageRect.getWidth() + textW;

                     // * 2 控制多个水印字体的间距宽度， 数值越大距离越大
                     width = width + textW * 2) {
                    under.showTextAligned(Element.ALIGN_LEFT, waterMarkName, width - textW,
                            height - textH, 30);
                }
            }
            // 添加水印文字
            under.endText();
        }
        stamper.close();
        reader.close();
    }


    public static void main(String[] args) throws Exception {
        waterMark("/Users/tenx/Downloads/201908221554858-1-75961.pdf",
                "/Users/tenx/Downloads/201908221554858-1-75961-2444.pdf",
                "城北支行");
    }


}
