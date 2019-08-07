package com.louis.kitty.admin.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;
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
    public static DirMeta createDir(String home) {
        if (StringUtils.isEmpty(home)) {
            return DirMeta.builder().result(false).msg("home dir is empty").build();
        }

        String dirName = home + getDate();
        //如果不存在,创建文件夹
        File dir = new File(dirName);
        if (dir.exists()) {
            return DirMeta.builder().result(true).msg("ignored cause by dir has exists").build();
        }

        boolean isOk = dir.mkdirs();
        if(!isOk) {
            return DirMeta.builder().result(false).msg("dir["+dirName+"] create failed").build();
        }

        return DirMeta.builder().result(true).path(dirName).build();
    }


    private static String getDate() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    @Builder
    @Getter
    public static class DirMeta {

        private boolean result;
        private String msg;
        private String path;

    }

}
