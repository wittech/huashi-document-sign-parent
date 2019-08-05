package com.louis.kitty.admin.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class FileDirectoryUtil {

    /**
     * 创建目录
     *
     * @param home 基础目录
     * @return 创建结果
     */
    public static boolean createDir(String home) {
        if (StringUtils.isEmpty(home)) {
            log.error("home dir is empty");
            return false;
        }

        String dirName = home + File.separator + getDate();
        //如果不存在,创建文件夹
        File dir = new File(dirName);
        if (dir.exists()) {
            return true;
        }

        return dir.mkdirs();
    }


    private static String getDate() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

}
