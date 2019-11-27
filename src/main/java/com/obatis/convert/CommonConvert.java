package com.obatis.convert;

import com.obatis.constant.NormalCommonConstant;
import com.obatis.validate.ValidateTool;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
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
		try {
			return URLDecoder.decode(value, NormalCommonConstant.CHARSET_UTF8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
}
