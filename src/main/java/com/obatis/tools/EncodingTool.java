package com.obatis.tools;

import com.obatis.constant.CharsetConstant;

import java.io.UnsupportedEncodingException;

public class EncodingTool {

    /**
     * 将传入的字符串，转为utf-8格式
     * @param value
     * @param charset
     * @return
     */
    public static String encodingByCharset(String value, String charset) {
        if(ValidateTool.isEmpty(value)) {
            return null;
        }
        try {
            return new String(value.getBytes(), charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
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
    public static String encodingUTF8(String value) {
        return encodingByCharset(value, CharsetConstant.CHARSET_UTF8);
    }
}
