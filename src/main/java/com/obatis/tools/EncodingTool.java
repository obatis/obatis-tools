package com.obatis.tools;

import com.obatis.constant.CharsetConstant;

import java.io.UnsupportedEncodingException;

public class EncodingTool {

    /**
     * 判断是否为中文GBK编码
     * @param value
     * @return
     */
    public static boolean isChineseEncoding(String value) {
        return java.nio.charset.Charset.forName(CharsetConstant.CHARSET_GBK).newEncoder().canEncode(value);
    }

    /**
     * 编码转换基础方法
     * @param value
     * @param fromCharset
     * @param toCharset
     * @return
     */
    public static String encoding(String value, String fromCharset, String toCharset) {
        if(ValidateTool.isEmpty(value)) {
            return null;
        }
        try {
            return new String(value.getBytes(fromCharset), toCharset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转为 UTF-8 编码
     * @param value
     * @return
     */
    public static String isoEncodingUTF8(String value) {
        return encoding(value, CharsetConstant.CHARSET_ISO8859, CharsetConstant.CHARSET_UTF8);
    }
}
