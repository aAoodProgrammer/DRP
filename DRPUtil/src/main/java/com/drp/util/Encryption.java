package com.drp.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @author 刘江涛
 * @ClassName: Encryption
 * @Description: 用MD5的方式进行加密
 * @date 2017年11月15日 下午3:05:03
 */
public class Encryption {
    /**
     * 利用MD5进行加密
     *
     * @param str 待加密的字符串
     * @param str
     * @return
     * @throws NoSuchAlgorithmException     没有这种产生消息摘要的算法
     * @throws UnsupportedEncodingException
     */
    public static String EncoderByMd5(String str) {
        //确定计算方法
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //BASE64Encoder base64en = new BASE64Encoder();
        //newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        //加密后的字符串
        String newstr = null;
        try {
            byte[] newbyte = md5.digest(str.getBytes("utf-8"));
            newstr = newbyte.toString();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return newstr;
    }
}
