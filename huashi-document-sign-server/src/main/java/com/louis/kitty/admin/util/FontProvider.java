package com.louis.kitty.admin.util;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class FontProvider extends XMLWorkerFontProvider {

    public FontProvider() {
        super(null, null);
    }

    @Override
    public Font getFont(String fontName, String encoding, boolean embedded, float size, int style, BaseColor color) {
        try {
            BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            return new Font(bfChinese, size, style);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (StringUtils.isEmpty(fontName)) {
            fontName = "宋体";
        }
        if (size == 0) {
            size = 5;
        }

        return super.getFont(fontName, encoding, size, style);
    }
}
