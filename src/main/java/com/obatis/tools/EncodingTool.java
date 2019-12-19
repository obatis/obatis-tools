package com.obatis.tools;

import com.obatis.constant.CharsetConstant;

import java.io.UnsupportedEncodingException;

public class EncodingTool {

    /**
     * 判断编码基础方法
     * @param value
     * @param charset
     * @return
     */
    public static boolean isEncodingByCharset(String value, String charset) {
        try {
            if (value.equals(new String(value.getBytes(), charset))) {
                return true;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断字符串编码格式是否为 ISO8859
     * @param value
     * @return
     */
    public static boolean isISO8859(String value) {
        return isEncodingByCharset(value, CharsetConstant.CHARSET_ISO8859);
    }

    /**
     * 判断字符串编码格式是否为 UTF-8
     * @param value
     * @return
     */
    public static boolean isUTF8(String value) {
        return isEncodingByCharset(value, CharsetConstant.CHARSET_UTF8);
    }

    /**
     * 编码转换基础方法
     * @param value
     * @param fromCharset
     * @param toCharset
     * @return
     */
    public static String toEncoding(String value, String fromCharset, String toCharset) {
        try {
            return new String(value.getBytes(fromCharset), toCharset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * ISO8859编码 转为 UTF8编码
     * @param value
     * @return
     */
    public static String iso8859ToUTF8(String value) {
        return toEncoding(value, CharsetConstant.CHARSET_ISO8859, CharsetConstant.CHARSET_UTF8);
    }

    /**
     * 转为 UTF-8 编码
     * @param value
     * @return
     */
    public static String toUTF8(String value) {
        if(isUTF8(value)) {
            return value;
        } else if (isISO8859(value)) {
            return iso8859ToUTF8(value);
        }
        return null;
    }
}
