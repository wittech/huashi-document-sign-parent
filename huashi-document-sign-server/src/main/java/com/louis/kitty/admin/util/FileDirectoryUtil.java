package com.louis.kitty.admin.util;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class FileDirectoryUtil {

    /**
     * 当前日期20190807 文件夹存在则不创建文件夹，不存在则创建并通知下次不用在创建
     */
    private static volatile Map<String, DirMeta> CURRENT_DATE_DIR = new ConcurrentHashMap<>();

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

        if(CURRENT_DATE_DIR.containsKey(dirName)) {
            return CURRENT_DATE_DIR.get(dirName);
        }

        //如果不存在,创建文件
        File dir = new File(dirName);

        if (dir.exists()) {
            CURRENT_DATE_DIR.put(dirName, DirMeta.builder().result(true).path(dirName).build());
            return CURRENT_DATE_DIR.get(dirName);
        }

        boolean isOk = dir.mkdirs();
        if(!isOk) {
            return DirMeta.builder().result(false).msg("dir["+dirName+"] create failed").build();
        }

        CURRENT_DATE_DIR.put(dirName, DirMeta.builder().result(true).path(dirName).build());
        return CURRENT_DATE_DIR.get(dirName);
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
