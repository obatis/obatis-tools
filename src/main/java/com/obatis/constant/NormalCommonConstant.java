package com.obatis.constant;

/**
 * 默认常量类
 * @author HuangLongPu
 */
public class NormalCommonConstant {

	private NormalCommonConstant() {}

	/**
	 * 编码格式，表示utf-8
	 * 标注过期，迁移到 com.obatis.constant.CharsetConstant 中
	 */
	@Deprecated
	public static final String CHARSET_UTF8 = "utf-8";

	/**
	 * BigDecimal 转换小数点保留2位
	 */
	public static final int BIGDECIMAL_SCALE2 = 2;
}
