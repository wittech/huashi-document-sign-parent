package com.louis.kitty.admin.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public final class FileUploadUtil {

    private static final char[] N36_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static String newFileName() {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return String.format("%s%d", f.format(new Date()), new Random().nextInt(100));
    }

    public static String dateFileName() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }

    /**
     * 获取最终重命名后的文件路径
     *
     * @param uploadPath 文件上传路径
     * @param fileName   文件名称
     * @return 最终路径
     */
    public static String getFinalPath(String uploadPath, String fileName, String suffix) {
        return uploadPath + File.separator + fileName + suffix;
    }

    public static String fileName(String fileNamePrefix) {
        return String.format("%s%s", fileNamePrefix, newFileName());
    }

    public static String suffix(String oldFileName) {
        return oldFileName.substring(oldFileName.lastIndexOf("."));
    }

    // public static Object[] upload(File file, String fileNamePrefix,
    // String uploadPath, String oldFileName) throws Exception {
    // String finalPath = "";
    // int availableSize = 0;
    // String filename = fileName(fileNamePrefix);
    // String suffix = suffix(oldFileName);
    // FileInputStream inputStream = null;
    // FileOutputStream outputStream = null;
    // try {
    // finalPath = getFinalPath(uploadPath, filename, suffix);
    // inputStream = new FileInputStream(file);
    // availableSize = inputStream.available();
    // outputStream = new FileOutputStream(finalPath);
    // byte[] buf = new byte[1024];
    // int length = 0;
    // while ((length = inputStream.read(buf)) != -1) {
    // outputStream.write(buf, 0, length);
    // }
    // } catch (Exception e) {
    // finalPath = "";
    // } finally {
    // outputStream.close();
    // inputStream.close();
    // }
    // return new Object[] { finalPath, availableSize, filename, suffix };
    // }
    public static void directory(String path) {
        if (StringUtils.isEmpty(path)) {
            return;
        }

        File file = new File(path);
        if (!file.exists() || (!file.isDirectory())) {
            file.mkdir();
        }
    }

    public static FileUploadResult upload(byte[] file, String filename, String uploadpath) {
        return upload(file, filename, uploadpath, "");
    }

    private static FileUploadResult upload(byte[] file, String filename, String uploadpath, String prefix) {
        String imgName;
        String realPath;
        String fullPath;
        String diskPath;
        long availableSize = 0L;
        try {
            String ext = filename.substring(filename.indexOf("."), filename.length());
            imgName = getRandFileName();
            String newName = imgName + ext;
            String dateFileName = dateFileName();
            String filePath = uploadpath + File.separator + getDiskPath(dateFileName);

            File outFile = new File(filePath);
            if (!outFile.exists()) {
                if (!outFile.mkdirs()) {
                    return FileUploadResult.builder().result(false).msg("创建目录[" + filePath + "]失败").build();
                }
            }
            diskPath = filePath + File.separator + newName;
            File fileName = new File(diskPath);
            if (!fileName.createNewFile()) {
                return FileUploadResult.builder().result(false).msg("创建文件[" + diskPath + "]失败").build();
            }
            availableSize = file.length;
            Files.write(Paths.get(diskPath), file);

            realPath = prefix + String.format("/%s/%s", getDomainPath(dateFileName), newName);
            // This value is not use in this moment
            fullPath = String.format("%s/%s/%s", uploadpath, getDomainPath(dateFileName), newName);
        } catch (IOException e) {
            return FileUploadResult.builder().result(false).msg("IO处理失败").build();
        }

        return FileUploadResult.builder().filename(imgName).realPath(realPath).diskPath(diskPath).fullPath(fullPath)
                .fileSize(availableSize).result(true).msg("处理成功").build();

    }

    private static String getRandFileName() {
        String name = longToN36(System.currentTimeMillis());
        return RandomStringUtils.random(4, N36_CHARS) + name;
    }

    private static String longToN36(long l) {
        return longToNBuf(l).reverse().toString();
    }

    private static StringBuilder longToNBuf(long l) {
        int upgrade = N36_CHARS.length;
        StringBuilder result = new StringBuilder();
        int last;
        while (l > 0) {
            last = (int) (l % upgrade);
            result.append(N36_CHARS[last]);
            l /= upgrade;
        }
        return result;
    }

    /**
     * 获取硬盘图片路径
     *
     * @param date 日期
     * @return 获取硬盘物理路径
     */
    private static String getDiskPath(String date) {
        StringBuilder fileName = new StringBuilder();
        for (String d : date.split("-")) {
            fileName.append(d).append(File.separator);
        }
        return fileName.toString().substring(0, fileName.length() - 1);
    }

    /**
     * 获取域名图片路径
     *
     * @param date 日期
     * @return 生成网络路径
     */
    private static String getDomainPath(String date) {
        StringBuilder fileName = new StringBuilder();
        for (String d : date.split("-")) {
            fileName.append(d).append("/");
        }
        return fileName.toString().substring(0, fileName.length() - 1);
    }

    public static String parsePathToDiskMode(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            {
                return "";
            }
        }
        return fileName.replace("/", "\\" + File.separator);
    }

    public static String parsePathToUrlMode(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            return "";
        }
        return fileName.replace("\\" + File.separator, "/");
    }

    @Setter
    @Getter
    @Builder
    public static class FileUploadResult {

        /**
         * 生成新的文件名称
         */
        private String filename;

        /**
         * 文件相对路径，包括按日期生成的目录结构，如/2014/11/11/fcvpi24rx3bq.jpg
         */
        private String realPath;

        /**
         * 文件占用硬盘空间大小（字节）
         */
        private long fileSize;

        /**
         * 物理硬盘全路径
         */
        private String diskPath;

        /**
         * 最终处理结果
         */
        private boolean result;

        /**
         * 返回消息
         */
        private String msg;

        private String fullPath;

    }

}
