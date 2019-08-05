package com.huashi.bank.test.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.AbstractTagProcessor;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import com.louis.kitty.admin.util.FontProvider;
import com.louis.kitty.admin.util.FreemarkerUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.util.encoders.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class PdfGeneratorUtil {


    public PdfGeneratorUtil() {
        super();
    }

    /**
     * 读取模板文件
     *
     * @param htmlPath
     * @return
     */
    public static byte[] readTemplate(String htmlPath) {
        try {
            return Files.readAllBytes(Paths.get(htmlPath));
        } catch (IOException e) {
            log.error("readTemplate[{}] failed", htmlPath, e);
            return null;
        }
    }


    /**
     * 将传入的json数据与选择的html模板结合生成PDF文件字节流
     *
     * @param model   传入的json数据
     * @param docPath html模板
     * @return pdf文件字节流
     */
    public static byte[] moduleToPdf(Object model, String docPath) throws Exception {
//        InputStream is = readTemplate(docPath);
        String content = translateFile(readTemplate(docPath), model);
        if (StringUtils.isEmpty(content)) {
            throw new RuntimeException("模板参数数据为空");
        }
        return createPdf(content);
    }


    /**
     * 将html模板与json数据结合并转化为一串字符串
     *
     * @return 返回值为字符串
     */
    public static String translateFile(byte[] data, Object model) {
        try {

//            byte[] data = IOUtils.toByteArray(is);
            if (data == null) {
                throw new RuntimeException("HTML数据为空");
            }
//            return FreemarkerUtil.parse(new String(data, Charset.forName("UTF-8")), model);

            return new String(data, Charset.forName("UTF-8"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将传入的字符串转化为PDF文件输出到制定的缓存路径
     *
     * @param content 传入的是模板与json组成的字符串
     * @return 返回PDF文件的字节流数组
     * @throws IOException
     * @throws DocumentException
     */
    public static byte[] createPdf(String content) throws Exception {
        // step 1
        final Document document = new Document();
        // step 2
        byte[] temp = null;
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final PdfWriter writer = PdfWriter.getInstance(document, baos);
        // step 3
        document.open();
        // 使用我们的字体提供器，并将其设置为unicode字体样式
//        final TagProcessorFactory tagProcessorFactory = Tags.getHtmlTagProcessorFactory();
//        tagProcessorFactory.removeProcessor(HTML.Tag.IMG);
//        tagProcessorFactory.addProcessor(new ImageTagProcessor(), HTML.Tag.IMG);

//
//        final FontProvider fontProvider = new FontProvider();
//        fontProvider.addFontSubstitute("lowagie", "garamond");
//        fontProvider.setUseUnicode(true);
//        final CssAppliers cssAppliers = new CssAppliersImpl(fontProvider);
//
//        CssFilesImpl cssFiles = new CssFilesImpl();
//        cssFiles.add(XMLWorkerHelper.getInstance().getDefaultCSS());
//        final StyleAttrCSSResolver cssResolver = new StyleAttrCSSResolver(cssFiles);
//
//
//        final HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
//        htmlContext.setAcceptUnknown(true).autoBookmark(true).setTagFactory(tagProcessorFactory);
//        final HtmlPipeline htmlPipeline = new HtmlPipeline(htmlContext, new PdfWriterPipeline(document, writer));
//        final Pipeline<?> pipeline = new CssResolverPipeline(cssResolver, htmlPipeline);
//        final XMLWorker worker = new XMLWorker(pipeline, true);
//        final Charset charset = Charset.forName("UTF-8");
//        final XMLParser xmlParser = new XMLParser(true, worker, charset);
//        final InputStream is = new ByteArrayInputStream(content.getBytes());

//        xmlParser.parse(is, charset);
        // step 5
//        is.close();


        XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
        worker.parseXHtml(writer, document, new ByteArrayInputStream(content.getBytes()), Charset.forName("UTF-8"), new FontProvider());
        document.close();




        document.close();
        temp = baos.toByteArray();
        baos.close();
        return temp;
    }

}

class ImageTagProcessor extends AbstractTagProcessor {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<Element> end(final WorkerContext ctx, final Tag tag, final List<Element> currentContent) {
        final Map<String, String> attributes = tag.getAttributes();
        String src = attributes.get(HTML.Attribute.SRC);
        List<Element> elements = new ArrayList<>(1);
        if (null != src && src.length() > 0) {
            Image img = null;
            try {
                img = Image.getInstance(Base64.decode(src));

            } catch (Exception e) {
                if (logger.isLogging(Level.ERROR)) {
                    logger.error(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.HTML_IMG_RETRIEVE_FAIL), src), e);
                }
            }
            if (img != null) {
                try {
                    final HtmlPipelineContext htmlPipelineContext = getHtmlPipelineContext(ctx);
                    elements.add(getCssAppliers().apply(new Chunk((Image) getCssAppliers().apply(img, tag, htmlPipelineContext), 0, 0, true), tag,
                            htmlPipelineContext));
                } catch (NoCustomContextException e) {
                    throw new RuntimeWorkerException(e);
                }
            }


            if (img == null) {
                elements = super.end(ctx, tag, currentContent);
            }
        }
        return elements;
    }
}
