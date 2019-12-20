package com.obatis.convert;

import com.obatis.constant.NormalCommonConstant;
import com.obatis.tools.ValidateTool;

import java.math.BigDecimal;

/**
 * BigDecimal 转换类
 */
public class BigDecimalConvert {

    /**
     * String 类型转为 BigDecimal
     * @param value
     * @return
     */
    public static BigDecimal convert(String value) {
        if(ValidateTool.isEmpty(value)  || !ValidateTool.isFloat(value)) {
            return BigDecimal.ZERO;
        }

        return new BigDecimal(value);
    }

    /**
     * Integer 类型转为 BigDecimal
     * @param value
     * @return
     */
    public static BigDecimal convert(Integer value) {
        if(value == null || value == 0) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(value);
    }

    /**
     * Long 类型转为 BigDecimal
     * @param value
     * @return
     */
    public static BigDecimal convert(Long value) {
        if(value == null || value == 0L) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(value);
    }

    /**
     * Double 类型转为 BigDecimal
     * @param value
     * @return
     */
    public static BigDecimal convert(Double value) {
        if(value == null || value == 0D) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(value);
    }

    /**
     * Double 类型转为 BigDecimal
     * @param value
     * @return
     */
    public static BigDecimal convert(Object value) {
        if(ValidateTool.isEmpty(value)  || !ValidateTool.isFloat(value)) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(value.toString());
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
