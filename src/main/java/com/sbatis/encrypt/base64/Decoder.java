package com.sbatis.encrypt.base64;

import com.sbatis.constant.NormalCommonConstant;

/**
 * base64 解密库
 * 此base64 解密库为提取原生base64包的方法，无需额外引入base64 jar包
 * @author HuangLongPu
 */
public class Decoder {
	
	private Decoder() {}
    
    private static final byte[] decodingTable;
   
    static {
        decodingTable = new byte[128];

        for (int i = 0; i < 128; i++) {
            decodingTable[i] = (byte) -1;
        }

        for (int i = 'A'; i <= 'Z'; i++) {
            decodingTable[i] = (byte) (i - 'A');
        }

        for (int i = 'a'; i <= 'z'; i++) {
            decodingTable[i] = (byte) (i - 'a' + 26);
        }

        for (int i = '0'; i <= '9'; i++) {
            decodingTable[i] = (byte) (i - '0' + 52);
        }

        decodingTable['+'] = 62;
        decodingTable['/'] = 63;
    }
    
    /**
     * base64解密，针对byte数组
     * @param data
     * @return
     */
    public static byte[] decode(byte[] data) {
        byte[] bytes;
        byte b1;
        byte b2;
        byte b3;
        byte b4;

        data = discardNonBase64Bytes(data);

        if (data[data.length - 2] == '=') {
            bytes = new byte[(((data.length / 4) - 1) * 3) + 1];
        } else if (data[data.length - 1] == '=') {
            bytes = new byte[(((data.length / 4) - 1) * 3) + 2];
        } else {
            bytes = new byte[((data.length / 4) * 3)];
        }

        for (int i = 0, j = 0; i < (data.length - 4); i += 4, j += 3) {
            b1 = decodingTable[data[i]];
            b2 = decodingTable[data[i + 1]];
            b3 = decodingTable[data[i + 2]];
            b4 = decodingTable[data[i + 3]];

            bytes[j] = (byte) ((b1 << 2) | (b2 >> 4));
            bytes[j + 1] = (byte) ((b2 << 4) | (b3 >> 2));
            bytes[j + 2] = (byte) ((b3 << 6) | b4);
        }

        if (data[data.length - 2] == '=') {
            b1 = decodingTable[data[data.length - 4]];
            b2 = decodingTable[data[data.length - 3]];

            bytes[bytes.length - 1] = (byte) ((b1 << 2) | (b2 >> 4));
        } else if (data[data.length - 1] == '=') {
            b1 = decodingTable[data[data.length - 4]];
            b2 = decodingTable[data[data.length - 3]];
            b3 = decodingTable[data[data.length - 2]];

            bytes[bytes.length - 2] = (byte) ((b1 << 2) | (b2 >> 4));
            bytes[bytes.length - 1] = (byte) ((b2 << 4) | (b3 >> 2));
        } else {
            b1 = decodingTable[data[data.length - 4]];
            b2 = decodingTable[data[data.length - 3]];
            b3 = decodingTable[data[data.length - 2]];
            b4 = decodingTable[data[data.length - 1]];

            bytes[bytes.length - 3] = (byte) ((b1 << 2) | (b2 >> 4));
            bytes[bytes.length - 2] = (byte) ((b2 << 4) | (b3 >> 2));
            bytes[bytes.length - 1] = (byte) ((b3 << 6) | b4);
        }

        return bytes;
    }
    
    /**
     * base64解密，针对byte数组，返回String字符串，编码为utf-8
     * @param data
     * @return
     */
    public static String decodeStr(byte[] data) {
    	return decodeStr(data, NormalCommonConstant.CHARSET_UTF8);
    }
    
    /**
     * base64解密，针对byte数组，返回String字符串，编码自定义
     * @param data
     * @param charsetName
     * @return
     */
    public static String decodeStr(byte[] data, String charsetName) {
    	
    	if(charsetName == null || charsetName.isEmpty()) {
    		charsetName = NormalCommonConstant.CHARSET_UTF8;
    	}
    	byte[] b = decode(data);
    	try {
    		return new String(b, charsetName);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }

    /**
     * base64解密，传入字符串，返回byte数组
     * @param data
     * @return
     */
    public static byte[] decode(String data) {
        byte[] bytes;
        byte b1;
        byte b2;
        byte b3;
        byte b4;

        data = discardNonBase64Chars(data);

        if (data.charAt(data.length() - 2) == '=') {
            bytes = new byte[(((data.length() / 4) - 1) * 3) + 1];
        } else if (data.charAt(data.length() - 1) == '=') {
            bytes = new byte[(((data.length() / 4) - 1) * 3) + 2];
        } else {
            bytes = new byte[((data.length() / 4) * 3)];
        }

        for (int i = 0, j = 0; i < (data.length() - 4); i += 4, j += 3) {
            b1 = decodingTable[data.charAt(i)];
            b2 = decodingTable[data.charAt(i + 1)];
            b3 = decodingTable[data.charAt(i + 2)];
            b4 = decodingTable[data.charAt(i + 3)];

            bytes[j] = (byte) ((b1 << 2) | (b2 >> 4));
            bytes[j + 1] = (byte) ((b2 << 4) | (b3 >> 2));
            bytes[j + 2] = (byte) ((b3 << 6) | b4);
        }

        if (data.charAt(data.length() - 2) == '=') {
            b1 = decodingTable[data.charAt(data.length() - 4)];
            b2 = decodingTable[data.charAt(data.length() - 3)];

            bytes[bytes.length - 1] = (byte) ((b1 << 2) | (b2 >> 4));
        } else if (data.charAt(data.length() - 1) == '=') {
            b1 = decodingTable[data.charAt(data.length() - 4)];
            b2 = decodingTable[data.charAt(data.length() - 3)];
            b3 = decodingTable[data.charAt(data.length() - 2)];

            bytes[bytes.length - 2] = (byte) ((b1 << 2) | (b2 >> 4));
            bytes[bytes.length - 1] = (byte) ((b2 << 4) | (b3 >> 2));
        } else {
            b1 = decodingTable[data.charAt(data.length() - 4)];
            b2 = decodingTable[data.charAt(data.length() - 3)];
            b3 = decodingTable[data.charAt(data.length() - 2)];
            b4 = decodingTable[data.charAt(data.length() - 1)];

            bytes[bytes.length - 3] = (byte) ((b1 << 2) | (b2 >> 4));
            bytes[bytes.length - 2] = (byte) ((b2 << 4) | (b3 >> 2));
            bytes[bytes.length - 1] = (byte) ((b3 << 6) | b4);
        }

        return bytes;
    }
    
    /**
     * 传入字符串进行base64解密，返回字符串，编码为utf-8
     * @param data
     * @return
     */
    public static String decodeStr(String data) {
    	return decodeStr(data.getBytes());
    }

    private static byte[] discardNonBase64Bytes(byte[] data) {
        byte[] temp = new byte[data.length];
        int bytesCopied = 0;

        for (int i = 0; i < data.length; i++) {
            if (isValidBase64Byte(data[i])) {
                temp[bytesCopied++] = data[i];
            }
        }

        byte[] newData = new byte[bytesCopied];

        System.arraycopy(temp, 0, newData, 0, bytesCopied);

        return newData;
    }

    private static String discardNonBase64Chars(String data) {
        StringBuffer sb = new StringBuffer();

        int length = data.length();

        for (int i = 0; i < length; i++) {
            if (isValidBase64Byte((byte) (data.charAt(i)))) {
                sb.append(data.charAt(i));
            }
        }

        return sb.toString();
    }

    private static boolean isValidBase64Byte(byte b) {
        if (b == '=') {
            return true;
        } else if ((b < 0) || (b >= 128)) {
            return false;
        } else if (decodingTable[b] == -1) {
            return false;
        }

        return true;
    }

}