package com.obatis.convert;

import java.math.BigDecimal;

import com.obatis.constant.NormalCommonConstant;
import com.obatis.validate.ValidateTool;

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
	 * @param value
	 * @return
	 */
	public static BigDecimal convert(String value) {
		if(ValidateTool.isEmpty(value)) {
			return BigDecimal.ZERO;
		}
		
		return new BigDecimal(value);
	}
	
	/**
	 * int 类型转为 BigDecimal
	 * @param value
	 * @return
	 */
	public static BigDecimal convert(int value) {
		return new BigDecimal(value);
	}
	
	/**
	 * BigDecimal 类型精度设置，四舍五入规则
	 * @param value
	 * @return
	 */
	public static BigDecimal convertHalfUp(BigDecimal value) {
		if (ValidateTool.isEmpty(value)) {
			value = BigDecimal.ZERO;
		}

		return value.setScale(NormalCommonConstant.BIGDECIMAL_SCALE2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * BigDecimal 类型精度设置，只入不舍规则
	 * @param value
	 * @return
	 */
	public static BigDecimal convertUp(BigDecimal value) {
		if (ValidateTool.isEmpty(value)) {
			value = BigDecimal.ZERO;
		}

		return value.setScale(NormalCommonConstant.BIGDECIMAL_SCALE2, BigDecimal.ROUND_UP);
	}

	/**
	 * BigDecimal 类型精度设置，只舍不如规则
	 * @param value
	 * @return
	 */
	public static BigDecimal convertDown(BigDecimal value) {
		if (ValidateTool.isEmpty(value)) {
			value = BigDecimal.ZERO;
		}

		return value.setScale(NormalCommonConstant.BIGDECIMAL_SCALE2, BigDecimal.ROUND_DOWN);
	}
}
