package com.obatis.convert;

import com.obatis.constant.NormalCommonConstant;
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
	 * String 类型转为 BigDecimal
	 * 调整为由 BigDecimalConvert 类提供转换
	 * @param value
	 * @return
	 */
	@Deprecated
	public static BigDecimal convert(String value) {
		if(ValidateTool.isEmpty(value)) {
			return BigDecimal.ZERO;
		}
		
		return new BigDecimal(value);
	}
	
	/**
	 * int 类型转为 BigDecimal
	 * 调整为由 BigDecimalConvert 类提供转换
	 * @param value
	 * @return
	 */
	@Deprecated
	public static BigDecimal convert(int value) {
		return new BigDecimal(value);
	}
	
	/**
	 * BigDecimal 类型精度设置，四舍五入规则
	 * 调整为由 BigDecimalConvert 类提供转换
	 * @param value
	 * @return
	 */
	@Deprecated
	public static BigDecimal convertHalfUp(BigDecimal value) {
		if (ValidateTool.isEmpty(value)) {
			value = BigDecimal.ZERO;
		}

		return value.setScale(NormalCommonConstant.BIGDECIMAL_SCALE2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * BigDecimal 类型精度设置，只入不舍规则
	 * 调整为由 BigDecimalConvert 类提供转换
	 * @param value
	 * @return
	 */
	@Deprecated
	public static BigDecimal convertUp(BigDecimal value) {
		if (ValidateTool.isEmpty(value)) {
			value = BigDecimal.ZERO;
		}

		return value.setScale(NormalCommonConstant.BIGDECIMAL_SCALE2, BigDecimal.ROUND_UP);
	}

	/**
	 * BigDecimal 类型精度设置，只舍不如规则
	 * 调整为由 BigDecimalConvert 类提供转换
	 * @param value
	 * @return
	 */
	@Deprecated
	public static BigDecimal convertDown(BigDecimal value) {
		if (ValidateTool.isEmpty(value)) {
			value = BigDecimal.ZERO;
		}

		return value.setScale(NormalCommonConstant.BIGDECIMAL_SCALE2, BigDecimal.ROUND_DOWN);
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
			return URLEncoder.encode(value, NormalCommonConstant.CHARSET_UTF8);
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
			return URLDecoder.decode(value, NormalCommonConstant.CHARSET_UTF8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
}
