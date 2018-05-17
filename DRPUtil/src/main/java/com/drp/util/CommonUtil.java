package com.drp.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

//	1. 工具类通常不允许继承（工具是拿来直接使用而不是继承的）
//	2. 工具类不需要创建对象来使用 直接调用静态方法

/**
 * 常用工具类
 *
 * @author Administrator
 */
public final class CommonUtil {
    // 时间戳转字符串
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    // 字符串转时间戳
    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 根据文件名获得文件后缀名
     *
     * @param filename 文件名
     * @return 后缀名
     */
    public static String getSuffix(String filename) {
        int pos = filename.lastIndexOf(".");// 判读是否有 .
        return pos > 0 && pos < filename.length() - 1 ? filename.substring(pos) : null;
    }

    /**
     * 时间+文件名的方式获得唯一文件名
     *
     * @param filename 文件名
     * @return 带后缀名的文件名
     */
    public static String getUniqueFilename1(String filename) {
        //获取时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        //拼接文件名
        return sdf.format(date) + filename;
    }

    /**
     * 基于UUID的方式获得唯一文件名
     *
     * @param suffix 后缀名
     * @return 带后缀名的文件名
     */
    public static String getUniqueFilename2(String suffix) {
        String uuidString = UUID.randomUUID().toString();// 生成 32位 通用唯一识别码
        return uuidString + (suffix != null ? suffix : "");
    }


}
