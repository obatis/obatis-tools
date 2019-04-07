package com.sbatis.convert.date;

import java.text.SimpleDateFormat;

/**
 * 日期（时间）处理常量类，包括日期格式，定义的转换类，转化类只能用于date包中
 * @author HuangLongPu
 */
public class DefaultDateConstant {
	
	private DefaultDateConstant(){}

	private static final String YEAR_PATTERN = "yyyy";
	private static final String YEAR_MONTH_PATTERN = "yyyy-MM";
	private static final String DATE_PATTERN = "yyyy-MM-dd";
	private static final String DATE_HOUR_PATTERN = "yyyy-MM-dd HH";
	private static final String DATE_HOUR_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
	public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	private static final String BEGIN_DATE_TIME_PATTERN = "yyyy-MM-dd 00:00:00";
	private static final String TIME_MILLIS_PATTERN = "yyyyMMddHHmmssSSS";
	private static final String END_DATE_TIME_PATTERN = "yyyy-MM-dd 23:59:59";
	private static final String DATE_FIRST_DAY_PATTERN = "yyyy-MM-01";
	
	/**
	 * 常规日期格式为：yyyy
	 */
	protected static final SimpleDateFormat SD_FORMAT_YEAR = new SimpleDateFormat(YEAR_PATTERN);
	/**
	 * 常规日期格式为：yyyy-MM
	 */
	protected static final SimpleDateFormat SD_FORMAT_YEAR_MONTH = new SimpleDateFormat(YEAR_MONTH_PATTERN);
	/**
	 * 常规日期格式为：yyyy-MM-dd
	 */
	protected static final SimpleDateFormat SD_FORMAT_DATE = new SimpleDateFormat(DATE_PATTERN);
	/**
	 * 常规日期格式为：yyyy-MM-dd HH
	 */
	protected static final SimpleDateFormat SD_FORMAT_DATE_HOUR = new SimpleDateFormat(DATE_HOUR_PATTERN);
	/**
	 * 常规日期格式为：yyyy-MM-dd HH:mm
	 */
	protected static final SimpleDateFormat SD_FORMAT_DATE_HOUR_MINUTE = new SimpleDateFormat(DATE_HOUR_MINUTE_PATTERN);
	/**
	 * 常规时间格式为：yyyy-MM-dd HH:mm:ss
	 */
	protected static final SimpleDateFormat SD_FORMAT_DATE_TIME = new SimpleDateFormat(DATE_TIME_PATTERN);
	/**
	 * 格式为：yyyyMMddHHmmssSSS
	 */
	protected static final SimpleDateFormat SD_FORMAT_TIME_MILLIS = new SimpleDateFormat(TIME_MILLIS_PATTERN);
	/**
	 * 格式为：yyyy-MM-dd 00:00:00
	 */
	protected static final SimpleDateFormat SD_FORMAT_BEGIN_DATE_TIME = new SimpleDateFormat(BEGIN_DATE_TIME_PATTERN);
	/**
	 * 格式为：yyyy-MM-dd 23:59:59
	 */
	protected static final SimpleDateFormat SD_FORMAT_END_DATE_TIME = new SimpleDateFormat(END_DATE_TIME_PATTERN);
	/**
	 * 格式为：yyyy-MM-dd 23:59:59
	 */
	protected static final SimpleDateFormat SD_FORMAT_DATE_FIRST_DAY = new SimpleDateFormat(DATE_FIRST_DAY_PATTERN);
}
