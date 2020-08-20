package com.obatis.convert;

import com.obatis.constant.CharsetConstant;
import com.obatis.tools.ValidateTool;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 公共转换库，主要用于常规类型转换
 * @author HuangLongPu
 */
public class CommonConvert {

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		if(ValidateTool.isEmpty(obj)) {
			return "";
		}
		return obj.toString();
	}

	/**
	 * 将字符串转为Integer类型，加入空判断
	 * @param value
	 * @return
	 */
	public static Integer toInteger(Object value) {
		if(ValidateTool.isEmpty(value) || !ValidateTool.isNumeric(value)) {
			return 0;
		} else if(value instanceof Integer) {
			return (Integer) value;
		} else if (value instanceof Long) {
			return ((Long) value).intValue();
		} else if (value instanceof Float) {
			return ((Float) value).intValue();
		} else if (value instanceof Double) {
			return ((Double) value).intValue();
		} else if (value instanceof BigInteger) {
			return ((BigInteger) value).intValue();
		} else if (value instanceof BigDecimal) {
			return ((BigDecimal) value).intValue();
		}
		return Integer.parseInt(value.toString());
	}

	/**
	 * 将字符串转为BigInteger类型，加入空判断
	 * @param value
	 * @return
	 */
	public static BigInteger toBigInteger(Object value) {
		if(ValidateTool.isEmpty(value) || !ValidateTool.isNumeric(value)) {
			return BigInteger.ZERO;
		} else if (value instanceof BigInteger) {
			return (BigInteger) value;
		} else if (value instanceof BigDecimal) {
			return ((BigDecimal) value).toBigInteger();
		}
		return new BigInteger(value.toString());
	}

	/**
	 * 将字符串转为Long类型，加入空判断
	 * @param value
	 * @return
	 */
	public static Long toLong(Object value) {
		if(ValidateTool.isEmpty(value) || !ValidateTool.isFloat(value)) {
			return 0L;
		} else if (value instanceof Integer) {
			((Integer) value).longValue();
		} else if (value instanceof Long) {
			return (Long) value;
		} else if (value instanceof Float) {
			return ((Float) value).longValue();
		} else if (value instanceof Double) {
			return ((Double) value).longValue();
		} else if (value instanceof BigInteger) {
			return ((BigInteger) value).longValue();
		} else if (value instanceof BigDecimal) {
			return ((BigDecimal) value).longValue();
		}
		return Long.parseLong(value.toString());
	}

	/**
	 * 将字符串转为Float类型，加入空判断
	 * @param value
	 * @return
	 */
	public static Float toFloat(Object value) {
		if(ValidateTool.isEmpty(value) || !ValidateTool.isFloat(value)) {
			return 0F;
		} else if (value instanceof Integer) {
			return ((Integer) value).floatValue();
		} else if (value instanceof Long) {
			return ((Long) value).floatValue();
		} else if( value instanceof Float) {
			return (Float) value;
		} else if (value instanceof Double) {
			return ((Double) value).floatValue();
		} else if (value instanceof BigDecimal) {
			return ((BigDecimal) value).floatValue();
		} else if (value instanceof BigInteger) {
			return ((BigInteger) value).floatValue();
		}
		return Float.parseFloat(value.toString());
	}

	/**
	 * 将字符串转为Double类型，加入空判断
	 * @param value
	 * @return
	 */
	public static Double toDouble(Object value) {
		if(ValidateTool.isEmpty(value) || !ValidateTool.isFloat(value)) {
			return 0D;
		} else if (value instanceof Integer) {
			return ((Integer) value).doubleValue();
		} else if (value instanceof Long) {
			return ((Long) value).doubleValue();
		} else if (value instanceof Double) {
			return (Double) value;
		} else if (value instanceof BigDecimal) {
			return ((BigDecimal) value).doubleValue();
		} else if (value instanceof BigInteger) {
			return ((BigInteger) value).doubleValue();
		}
		return Double.parseDouble(value.toString());
	}

	/**
	 * 对URL参数或者参数值进行编码
	 * @param value
	 * @return
	 */
	public static String urlEncoder(String value) {

		if(ValidateTool.isEmpty(value)) {
			return "";
		}
		try {
			return URLEncoder.encode(value, CharsetConstant.CHARSET_UTF8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 对URL参数或者参数值进行解码
	 * @param value
	 * @return
	 */
	public static String urlLDecoder(String value) {
		if(ValidateTool.isEmpty(value)) {
			return "";
		}
		try {
			return URLDecoder.decode(value, CharsetConstant.CHARSET_UTF8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 进行html片段转义，防止xss攻击
	 * @param source
	 * @return
	 */
	public static String htmlEncode(String source) {
		if (source == null) {
			return "";
		}
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < source.length(); i++) {
			char c = source.charAt(i);
			switch (c) {
				case '<':
					buffer.append("&lt;");
					break;
				case '>':
					buffer.append("&gt;");
					break;
				case '&':
					buffer.append("&amp;");
					break;
				case '"':
					buffer.append("&quot;");
					break;
				case '\'':
					buffer.append("&#x27;");
					break;
				case '/':
					buffer.append("&#x2F;");
					break;
				case 10:
				case 13:
					break;
				default:
					buffer.append(c);
			}
		}
		return buffer.toString();
	}
}
