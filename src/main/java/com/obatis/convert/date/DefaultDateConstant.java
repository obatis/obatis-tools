package com.obatis.convert.date;

import java.time.format.DateTimeFormatter;

/**
 * 日期（时间）处理常量类，包括日期格式，定义的转换类，转化类只能用于date包中
 * @author HuangLongPu
 */
public class DefaultDateConstant {
	
	private DefaultDateConstant(){}

	protected static final String PARSE_YEAR_MONTH_PATTERN = "yyyy-M";
	protected static final String PARSE_DATE_PATTERN = "yyyy-M-d";
	protected static final String PARSE_DATE_HOUR_PATTERN = "yyyy-M-d H";
	protected static final String PARSE_DATE_HOUR_MINUTE_PATTERN = "yyyy-M-d H:m";
	protected static final String PARSE_DATE_TIME_PATTERN = "yyyy-M-d H:m:s";

	public static final String YEAR_MONTH_PATTERN = "yyyy-MM";
	public static final String YEAR_MONTH_JOINT_PATTERN = "yyyyMM";
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	public static final String DATE_JOINT_PATTERN = "yyyyMMdd";
	public static final String DATE_HOUR_PATTERN = "yyyy-MM-dd HH";
	public static final String DATE_HOUR_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
	public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String BEGIN_DATE_TIME_PATTERN = "yyyy-MM-dd 00:00:00";
	public static final String TIME_MILLIS_PATTERN = "yyyyMMddHHmmssSSS";
	public static final String END_DATE_TIME_PATTERN = "yyyy-MM-dd 23:59:59";
	public static final String DATE_FIRST_DAY_PATTERN = "yyyy-MM-01";
	public static final String HOUR_MINUTE_PATTERN = "HH:mm";

	/**
	 * 常规日期格式为：yyyy-MM
	 */
	public static final DateTimeFormatter FORMAT_YEAR_MONTH = DateTimeFormatter.ofPattern(YEAR_MONTH_PATTERN);
	/**
	 * 常规日期格式为：yyyyMM，没有连接线
	 */
	public static final DateTimeFormatter FORMAT_YEAR_MONTH_JOINT = DateTimeFormatter.ofPattern(YEAR_MONTH_JOINT_PATTERN);
	/**
	 * 常规日期格式为：yyyy-MM-dd
	 */
    public static final DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern(DATE_PATTERN);
	/**
	 * 常规日期格式为：yyyyMMdd，没有连接线
	 */
	public static final DateTimeFormatter FORMAT_DATE_JOINT = DateTimeFormatter.ofPattern(DATE_JOINT_PATTERN);
	/**
	 * 常规日期格式为：yyyy-MM-dd HH
	 */
	public static final DateTimeFormatter FORMAT_DATE_HOUR = DateTimeFormatter.ofPattern(DATE_HOUR_PATTERN);
	/**
	 * 常规日期格式为：yyyy-MM-dd HH:mm
	 */
	public static final DateTimeFormatter FORMAT_DATE_HOUR_MINUTE = DateTimeFormatter.ofPattern(DATE_HOUR_MINUTE_PATTERN);
	/**
	 * 常规时间格式为：yyyy-MM-dd HH:mm:ss
	 */
	public static final DateTimeFormatter FORMAT_DATE_TIME = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
	/**
	 * 格式为：yyyyMMddHHmmssSSS
	 */
	public static final DateTimeFormatter FORMAT_TIME_MILLIS = DateTimeFormatter.ofPattern(TIME_MILLIS_PATTERN);
	/**
	 * 格式为：yyyy-MM-dd 00:00:00
	 */
	public static final DateTimeFormatter FORMAT_BEGIN_DATE_TIME = DateTimeFormatter.ofPattern(BEGIN_DATE_TIME_PATTERN);
	/**
	 * 格式为：yyyy-MM-dd 23:59:59
	 */
	public static final DateTimeFormatter FORMAT_END_DATE_TIME = DateTimeFormatter.ofPattern(END_DATE_TIME_PATTERN);
	/**
	 * 格式为：yyyy-MM-01
	 */
	public static final DateTimeFormatter FORMAT_DATE_FIRST_DAY = DateTimeFormatter.ofPattern(DATE_FIRST_DAY_PATTERN);
	/**
	 * 格式为：HH:mm
	 */
	public static final DateTimeFormatter FORMAT_HOUR_MINUTE = DateTimeFormatter.ofPattern(HOUR_MINUTE_PATTERN);
}
