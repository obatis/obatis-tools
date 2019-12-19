package com.obatis.convert.date;


import com.obatis.tools.ValidateTool;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date转换公共组件库
 * @author HuangLongPu
 */
public class DateCommonConvert {

	private DateCommonConvert(){}

	/**
	 * 将传入的Date转为日期字符串，转换后格式：yyyy-MM-dd
	 * @author HuangLongPu
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		if(date == null) {
			return null;
		}
		return DefaultDateConstant.SD_FORMAT_DATE.format(date);
	}
	
	/**
	 * 获取当前日期的字符串，格式：yyyy-MM-dd
	 * @author HuangLongPu
	 * @return
	 */
	public static String formatCurDate() {
		return formatDate(getCurDate());
	}

	/**
	 * 将传入的Date转为日期字符串，格式：yyyy-MM-dd HH:mm:ss
	 * @author HuangLongPu
	 * @param dateTime
	 * @return
	 */
	public static String formatDateTime(Date dateTime) {
		if(dateTime == null) {
			return null;
		}
		return DefaultDateConstant.SD_FORMAT_DATE_TIME.format(dateTime);
	}

	/**
	 * 得到当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
	 * @author HuangLongPu
	 * @return
	 */
	public static String formatCurTime() {
		return formatDateTime(TimeGenerator.getTimestamp());
	}

	/**
	 * 获取当前年月日时分秒毫秒时间串，格式：yyyyMMddHHmmssSSS
	 * @author HuangLongPu
	 * @return
	 */
	public static String formatCurDateTimeMillis() {
		return formatDateTimeMillis(TimeGenerator.getTimestamp());
	}

	/**
	 * 将传入的Date转换为年月日时分秒毫秒时间串，格式：yyyyMMddHHmmssSSS
	 * @author HuangLongPu
	 * @param date
	 * @return
	 */
	public static String formatDateTimeMillis(Date date) {
		if(date == null) {
			return null;
		}
		return DefaultDateConstant.SD_FORMAT_TIME_MILLIS.format(date);
	}

	/**
	 * 获取当前日期的年月，格式：yyyyMM
	 * @author HuangLongPu
	 * @return
	 */
	public static String formatCurYearMonth() {
		return DefaultDateConstant.SD_FORMAT_YEAR_MONTH.format(TimeGenerator.getTimestamp());
	}

	/**
	 * 获取日期的年月，格式：yyyyMM
	 * @author HuangLongPu
	 * @return
	 */
	public static String formatYearMonth(Date date) {
		return DefaultDateConstant.SD_FORMAT_YEAR_MONTH.format(date);
	}
	
    /**
     * 获取开始时间，格式为：yyyy-MM-dd 00:00:00
	 * @author HuangLongPu
     * @param beginDate
     * @return
     */
    public static String formatBeginDateTime(Date beginDate) {
    	if(beginDate == null) {
    		return null;
    	}
    	return DefaultDateConstant.SD_FORMAT_BEGIN_DATE_TIME.format(beginDate);
    }
    
    /**
     * 将字符串的日期格式转为开始时间字符串
	 * @author HuangLongPu
     * @param beginDate
     * @return
     */
    public static String formatBeginDateTime(String beginDate) {
    	if(ValidateTool.isEmpty(beginDate)) {
    		return null;
    	}
    	if(ValidateTool.isDate(beginDate)) {
    		return beginDate + " 00:00:00";
    	}
    	Date date = parseDate(beginDate);
    	if(date != null) {
    		return DefaultDateConstant.SD_FORMAT_BEGIN_DATE_TIME.format(date);
    	}
    	return null;
    }
    
    /**
     * 将字符串的日期转为结束时间字符串
	 * @author HuangLongPu
     * @param endDate
     * @return
     */
    public static String formatEndDateTime(String endDate) {
    	if(ValidateTool.isEmpty(endDate)) {
    		return null;
    	}
    	if(ValidateTool.isDate(endDate)) {
    		return endDate + " 23:59:59";
    	}
    	Date date = parseDate(endDate);
    	if(date != null) {
    		return DefaultDateConstant.SD_FORMAT_END_DATE_TIME.format(date);
    	}
    	return null;
    }
    
    /**
     * 结束时间，格式为：yyyy-MM-dd 23:59:59
	 * @author HuangLongPu
     * @param endDate
     * @return
     */
    public static String formatEndDateTime(Date endDate) {
    	if(endDate == null) {
    		return null;
    	}
    	return DefaultDateConstant.SD_FORMAT_END_DATE_TIME.format(endDate);
    }
    
    /**
     * 根据传入的date，获取1号
	 * @author HuangLongPu
     * @param date
     * @return
     */
    public static String formatDateFirstDay(Date date) {
    	if(date == null) {
    		return null;
    	}
    	return DefaultDateConstant.SD_FORMAT_DATE_FIRST_DAY.format(date);
    }
    
    /**
     * 获取当前月的第一天
	 * @author HuangLongPu
     * @return
     */
    public static String formatCurDateFirstDay() {
    	return formatDateFirstDay(getCurDate());
    }
    
    /**
     * 获取时间戳，long类型格式
	 * @author HuangLongPu
     * @return
     */
    public static long getTimeMillis() {
        return TimeGenerator.getTimeMillis();
    }
    
    /**
     * 获取当前日期，返回Date类型
	 * @author HuangLongPu
     * @return
     */
    public static Date getCurDate() {
    	return TimeGenerator.getTimestamp();
    }
    
    /**
     * 将传入的时间格式字符串转为Date类型，传入格式：yyyy-MM-dd HH:mm:ss
	 * @author HuangLongPu
     * @param dateTime
     * @return
     */
    public static Date parseDateTime(String dateTime) {
    	if(ValidateTool.isEmpty(dateTime)) {
    		return null;
    	}
    	
    	try {
			return DefaultDateConstant.SD_FORMAT_DATE_TIME.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 将日期格式字符串转为Date类型，格式：yyyy-MM-dd
     * @param date
     * @return
     */
    public static Date parseDate(String date) {
    	if(ValidateTool.isEmpty(date)) {
    		return null;
    	}
    	
    	try {
    		return DefaultDateConstant.SD_FORMAT_DATE.parse(date);
    	} catch (ParseException e) {
    		e.printStackTrace();
    	}
    	return null;
    }

	/**
	 * 将日期格式字符串转为Date类型，格式：可选，默认为yyyy-mm-dd
	 * @author HuangLongPu
	 * @param date    String 字符型日期
	 * @param format  String 格式
	 * @return Date 日期
	 */
	public static Date parseDate(String date, String format) {
		if(ValidateTool.isEmpty(date)) {
			return null;
		}

		if(ValidateTool.isEmpty(format)) {
			format = DefaultDateConstant.DATE_PATTERN;
		}

		try {
			DateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    
    /**
     * 获取开始时间，格式：yyyy-MM-dd 00:00:00
	 * @author HuangLongPu
     * @param dateTime
     * @return
     */
    public static Date parseBeginDateTime(String dateTime) {
    	if(ValidateTool.isEmpty(dateTime)) {
    		return null;
    	}
    	
    	try {
			return DefaultDateConstant.SD_FORMAT_BEGIN_DATE_TIME.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 获取结束时间，格式：yyyy-MM-dd 23:59:59
	 * @author HuangLongPu
     * @param dateTime
     * @return
     */
    public static Date parseEndDateTime(String dateTime) {
    	
    	if(ValidateTool.isEmpty(dateTime)) {
    		return null;
    	}
    	
    	try {
			return DefaultDateConstant.SD_FORMAT_END_DATE_TIME.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
    }

	/**
	 * 得到当前月份的第一天的Date
	 * @author HuangLongPu
	 * @return
	 */
	public static Date parseCurDateFirstDay() {
		return parseDateFirstDay(formatCurDate());
	}
    
    /**
     * 根据传入的字符串date，获取第一天的Date
	 * @author HuangLongPu
     * @param date
     * @return
     */
    public static Date parseDateFirstDay(String date) {
    	if(ValidateTool.isEmpty(date)) {
    		return null;
    	}
    	
    	try {
			return DefaultDateConstant.SD_FORMAT_DATE_FIRST_DAY.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	return null;
    }

	/**
	 * 在当前日期的基础上，增加秒数操作
	 * 如果传入的秒数为大于0的正数，表示在传入日期的基础上新增秒数
	 * 如果传入的秒数为小于0的负数，表示在传入日期的基础上减少秒数
	 * 如果传入的秒数为0，则不进行任何操作
	 * @author HuangLongPu
	 * @param seconds       操作增加或者减少的秒数
	 * @return
	 */
	public static Date addSecondByCurDate(int seconds) {
		return addSecond(getCurDate(), seconds);
	}

	/**
	 * 在传入日期格式的基础上增加秒数操作。
	 * 如果传入的秒数为大于0的正数，表示在传入日期的基础上新增秒数
	 * 如果传入的秒数为小于0的负数，表示在传入日期的基础上减少秒数
	 * 如果传入的秒数为0，则不进行任何操作
	 * @author HuangLongPu
	 * @param date           传入的 date 日期
	 * @param seconds        操作增加或者减少的秒数
	 * @return
	 */
	public static Date addSecond(Date date, int seconds) {

		/**
		 * 如果传入的日期为空，或者分钟数为空，则不进行任务操作，直接返回传入的 date 即可
		 */
		if(date == null || seconds == 0) {
			return date;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, seconds);
		return calendar.getTime();
	}

	/**
	 * 在当前日期的基础上，增加分钟数操作
	 * 如果传入的分钟数为大于0的正数，表示在传入日期的基础上新增分钟数
	 * 如果传入的分钟数为小于0的负数，表示在传入日期的基础上减少分钟数
	 * 如果传入的分钟数为0，则不进行任何操作
	 * @author HuangLongPu
	 * @param minutes       操作增加或者减少的分钟数
	 * @return
	 */
	public static Date addMinuteByCurDate(int minutes) {
		return addMinute(getCurDate(), minutes);
	}

	/**
	 * 在传入日期格式的基础上增加分钟数操作。
	 * 如果传入的分钟数为大于0的正数，表示在传入日期的基础上新增分钟数
	 * 如果传入的分钟数为小于0的负数，表示在传入日期的基础上减少分钟数
	 * 如果传入的分钟数为0，则不进行任何操作
	 * @author HuangLongPu
	 * @param date           传入的 date 日期
	 * @param minutes        操作增加或者减少的分钟数
	 * @return
	 */
    public static Date addMinute(Date date, int minutes) {

		/**
		 * 如果传入的日期为空，或者分钟数为空，则不进行任务操作，直接返回传入的 date 即可
		 */
		if(date == null || minutes == 0) {
    		return date;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minutes);
		return calendar.getTime();
	}

	/**
	 * 在当前日期的基础上，增加小时数操作。
	 * 如果传入的小时数为大于0的正数，表示在传入日期的基础上增加小时数。
	 * 如果传入的小时数为小于0的负数，表示在传入日期的基础上减少小时数。
	 * 如果传入的小时数为0，则不进行任何操作。
	 * @author HuangLongPu
	 * @param hours     操作增加或者减少的小时数
	 * @return
	 */
	public static Date addHourByCurDate(int hours) {
		return addHour(getCurDate(), hours);
	}

	/**
	 * 在传入日期的基础，增加小时数操作。
	 * 如果传入的小时数为大于0的正数，表示在传入日期的基础上增加小时数。
	 * 如果传入的小时数为小于0的负数，表示在传入日期的基础上减少小时数。
	 * 如果传入的小时数为0，则不进行任何操作。
	 * @author HuangLongPu
	 * @param date       传入的 date 日期
	 * @param hours      操作增加或者减少的小时数
	 * @return
	 */
	public static Date addHour(Date date, int hours) {
		/**
		 * 如果传入的日期为空，或者小时数为空，则不进行任务操作，直接返回传入的 date 即可
		 */
		if(date == null || hours == 0) {
			return date;
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		return calendar.getTime();
	}

	/**
	 * 在当前日期的基础上，增加天数操作。
	 * 如果传入的天数为大于0的正数，表示在传入日期的基础上增加天数。
	 * 如果传入的天数为小于0的负数，表示在传入日期的基础上减少天数。
	 * 如果传入的天数为0，则不进行任何操作。
	 * @author HuangLongPu
	 * @param days    操作增加或者减少的天数
	 * @return
	 */
	public static Date addDayByCurDate(int days) {
    	return addDay(getCurDate(), days);
	}

	/**
	 * 在传入日期的基础，增加天数操作。
	 * 如果传入的天数为大于0的正数，表示在传入日期的基础上增加天数。
	 * 如果传入的天数为小于0的负数，表示在传入日期的基础上减少天数。
	 * 如果传入的天数为0，则不进行任何操作。
	 * @author HuangLongPu
	 * @param date      传入的 date 日期
	 * @param days      操作增加或者减少的天数
	 * @return
	 */
	public static Date addDay(Date date, int days) {
		/**
		 * 如果传入的日期为空，或者小时数为空，则不进行任务操作，直接返回传入的 date 即可
		 */
		if(date == null || days == 0) {
			return date;
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}

	/**
	 * 在当前日期的基础上，增加月操作。
	 * 如果传入的月数为大于0的正数，表示在传入日期的基础上增加月数。
	 * 如果传入的月数为小于0的负数，表示在传入日期的基础上减少月数。
	 * 如果传入的月数为0，则不进行任何操作。
	 * @author HuangLongPu
	 * @param months     操作增加或者减少的月数
	 * @return
	 */
	public static Date addMonthbyCurDate(int months) {
		return addMonth(getCurDate(), months);
	}

	/**
	 * 在传入日期格式的基础上增加月操作。
	 * 如果传入的月数为大于0的正数，表示在传入日期的基础上增加月数。
	 * 如果传入的月数为小于0的负数，表示在传入日期的基础上减少月数。
	 * 如果传入的月数为0，则不进行任何操作。
	 * @author HuangLongPu
	 * @param date           传入的 date 日期
	 * @param months         操作增加或者减少的月数
	 * @return
	 */
	public static Date addMonth(Date date, int months) {
		/**
		 * 如果传入的日期为空，或者月数为0，则不进行任务操作，直接返回传入的 date 即可
		 */
		if(date == null || months == 0) {
			return date;
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}

}
