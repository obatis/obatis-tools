package com.sbatis.convert;

import java.math.BigDecimal;

import com.sbatis.constant.DefaultNormalConstant;
import com.sbatis.validate.CommonValidate;

/**
 * 转换公共库，主要用于常规类型转换
 * @author HuangLongPu
 */
public class CommonConvert {

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		if(CommonValidate.isNull(obj)) {
			return "";
		}
		return obj.toString();
	}
	
	/**
	 * String 类型转为 BigDecimal
	 * @param value
	 * @return
	 */
	public static BigDecimal convertBigDecimal(String value) {
		if(CommonValidate.isNull(value)) {
			return BigDecimal.ZERO;
		}
		
		return new BigDecimal(value);
	}
	
	/**
	 * int 类型转为 BigDecimal
	 * @param value
	 * @return
	 */
	public static BigDecimal convertBigDecimal(int value) {
		return new BigDecimal(value);
	}
	
	/**
	 * BigDecimal 类型精度设置
	 * @param value
	 * @return
	 */
	public static BigDecimal convertBigDecimalForTwo(BigDecimal value) {
		if (CommonValidate.isNull(value)) {
			value = BigDecimal.ZERO;
		}

		return value.setScale(DefaultNormalConstant.BIGDECIMAL_SCALE2, BigDecimal.ROUND_HALF_UP);
	}
}
