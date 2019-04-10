package com.rc.yooblog.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 作者：flandre on 2019/4/8 22:42
 * 描述：
 */
public class MD5Utils {

    /**
     * 获取32位MD5
     * @param message
     * @return
     */
    public static String getMD5(String message) {
        if (message != null && message.length() != 0) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(message.getBytes());
                byte[] b = md.digest();
                int i;
                StringBuilder buf = new StringBuilder();
                for (byte b1 : b) {
                    i = b1;
                    if (i < 0) {
                        i += 256;
                    }
                    if (i < 16)
                        buf.append("0");
                    buf.append(Integer.toHexString(i));
                }
                //32位
                return buf.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
