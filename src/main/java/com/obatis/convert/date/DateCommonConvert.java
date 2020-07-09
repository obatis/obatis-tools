package com.obatis.convert.date;


import com.obatis.tools.ValidateTool;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * Date转换公共组件库
 * @author HuangLongPu
 */
public class DateCommonConvert {

	private DateCommonConvert(){}

	/**
	 * 获取当前日期的字符串，格式：yyyy-MM-dd
	 * @return
	 */
	public static String formatDate() {
		return formatDate(LocalDate.now());
	}

	/**
	 * 将传入的Date转为日期字符串，转换后格式：yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String formatDate(LocalDate date) {
		if(date == null) {
			return null;
		}
		return date.format(DefaultDateConstant.FORMAT_DATE);
	}

	/**
	 * 将传入的Date转为日期字符串，转换后格式：yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String formatDate(LocalDate date, String format) {
		if(date == null) {
			return null;
		}
		return date.format(DateTimeFormatter.ofPattern(format));
	}

	/**
	 * 得到当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String formatDateTime() {
		return formatDateTime(LocalDateTime.now());
	}

	/**
	 * 将传入的Date转为日期字符串，格式：yyyy-MM-dd HH:mm:ss
	 * @param dateTime
	 * @return
	 */
	public static String formatDateTime(LocalDateTime dateTime) {
		if(dateTime == null) {
			return null;
		}
		return dateTime.format(DefaultDateConstant.FORMAT_DATE_TIME);
	}

	/**
	 * 获取当前年月日时分秒毫秒时间串，格式：yyyyMMddHHmmssSSS
	 * @return
	 */
	public static String formatDateTimeMillis() {
		return formatDateTimeMillis(LocalDateTime.now());
	}

	/**
	 * 将传入的Date转换为年月日时分秒毫秒时间串，格式：yyyyMMddHHmmssSSS
	 * @param dateTime
	 * @return
	 */
	public static String formatDateTimeMillis(LocalDateTime dateTime) {
		if(dateTime == null) {
			return null;
		}
		return dateTime.format(DefaultDateConstant.FORMAT_TIME_MILLIS);
	}

	/**
	 * 获取当前日期的年月，格式：yyyy-MM
	 * @return
	 */
	public static String formatYearMonth() {
		return formatYearMonth(LocalDate.now());
	}

	/**
	 * 获取日期的年月，格式：yyyy-MM
	 * @return
	 */
	public static String formatYearMonth(LocalDate date) {
		return date.format(DefaultDateConstant.FORMAT_YEAR_MONTH);
	}

	/**
	 * 获取日期的年月，格式：yyyy-MM
	 * @return
	 */
	public static String formatYearMonth(LocalDateTime dateTime) {
		return dateTime.format(DefaultDateConstant.FORMAT_YEAR_MONTH);
	}
	
    /**
     * 获取开始时间，格式为：yyyy-MM-dd 00:00:00
     * @param beginDate
     * @return
     */
    public static String formatBeginDateTime(LocalDate beginDate) {
    	if(beginDate == null) {
    		return null;
    	}

    	return beginDate.format(DefaultDateConstant.FORMAT_BEGIN_DATE_TIME);
    }

	/**
	 * 获取开始时间，格式为：yyyy-MM-dd 00:00:00
	 * @param beginDateTime
	 * @return
	 */
	public static String formatBeginDateTime(LocalDateTime beginDateTime) {
		if(beginDateTime == null) {
			return null;
		}

		return beginDateTime.format(DefaultDateConstant.FORMAT_BEGIN_DATE_TIME);
	}
    
    /**
     * 将字符串的日期格式转为开始时间字符串
     * @param beginDateTime
     * @return
     */
    public static String formatBeginDateTime(String beginDateTime) {
    	if(ValidateTool.isEmpty(beginDateTime)) {
    		return null;
    	}

		// 将 '/' 转为 '-'
		if(beginDateTime.contains("/")) {
			beginDateTime = beginDateTime.replace("/", "-");
		}

    	if(ValidateTool.isDate(beginDateTime)) {
    		return beginDateTime + " 00:00:00";
    	}

		LocalDateTime dateTime = LocalDateTime.parse(beginDateTime, DefaultDateConstant.FORMAT_DATE_TIME);
    	return dateTime.format(DefaultDateConstant.FORMAT_BEGIN_DATE_TIME);
    }
    
    /**
     * 将字符串的日期转为结束时间字符串
     * @param endDateTime
     * @return
     */
    public static String formatEndDateTime(String endDateTime) {
    	if(ValidateTool.isEmpty(endDateTime)) {
    		return null;
    	}

		// 将 '/' 转为 '-'
		if(endDateTime.contains("/")) {
			endDateTime = endDateTime.replace("/", "-");
		}

    	if(ValidateTool.isDate(endDateTime)) {
    		return endDateTime + " 23:59:59";
    	}

		LocalDateTime dateTime = LocalDateTime.parse(endDateTime, DefaultDateConstant.FORMAT_DATE_TIME);
		return dateTime.format(DefaultDateConstant.FORMAT_END_DATE_TIME);
    }

	/**
	 * 结束时间，格式为：yyyy-MM-dd 23:59:59
	 * @param endDate
	 * @return
	 */
	public static String formatEndDateTime(LocalDate endDate) {
		if(endDate == null) {
			return null;
		}

		return endDate.format(DefaultDateConstant.FORMAT_END_DATE_TIME);
	}
    
    /**
     * 结束时间，格式为：yyyy-MM-dd 23:59:59
     * @param endDateTime
     * @return
     */
    public static String formatEndDateTime(LocalDateTime endDateTime) {
    	if(endDateTime == null) {
    		return null;
    	}

    	return endDateTime.format(DefaultDateConstant.FORMAT_END_DATE_TIME);
    }
    
    /**
     * 根据传入的date，获取1号
     * @param date
     * @return
     */
    public static String formatFirstDay(LocalDate date) {
    	if(date == null) {
    		return null;
    	}

    	return date.format(DefaultDateConstant.FORMAT_DATE_FIRST_DAY);
    }

	/**
	 * 根据传入的时间，获取1号
	 * @param dateTime
	 * @return
	 */
	public static String formatFirstDay(LocalDateTime dateTime) {
		if(dateTime == null) {
			return null;
		}

		return dateTime.format(DefaultDateConstant.FORMAT_DATE_FIRST_DAY);
	}
    
    /**
     * 获取当前月的第一天
     * @return
     */
    public static String formatFirstDay() {
    	return formatFirstDay(getDate());
    }
    
    /**
     * 获取时间戳，long类型格式
     * @return
     */
    public static long getTimeMillis() {
        return TimeGenerator.getTimeMillis();
    }

	/**
	 * 获取当前日期，返回Date类型(格式：yyyy-MM-dd)
	 * @return
	 */
	public static LocalDate getDate() {
		return LocalDate.now();
    }

	/**
	 * 获取当前时间，返回DateTime类型(格式：yyyy-MM-dd HH:mm:ss)
	 * @return
	 */
	public static LocalDateTime getDateTime() {
		return LocalDateTime.now();
	}

	/**
	 * 将日期格式字符串转为Date类型，格式：yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static LocalDate parseDate(String date) {
		if(ValidateTool.isEmpty(date)) {
			return null;
		}

		// 将 '/' 转为 '-'
		if(date.contains("/")) {
			date = date.replace("/", "-");
		}

		return LocalDate.parse(date, DefaultDateConstant.FORMAT_DATE);
	}

	/**
	 * 将日期格式字符串转为Date类型，格式：yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static LocalDate parseDate(String date, String format) {
		if(ValidateTool.isEmpty(date)) {
			return null;
		}

		// 将 '/' 转为 '-'
		if(date.contains("/")) {
			date = date.replace("/", "-");
		}

		return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
	}

    /**
     * 将传入的时间格式字符串转为DateTime类型，传入格式：yyyy-MM-dd HH:mm:ss
     * @param dateTime
     * @return
     */
    public static LocalDateTime parseDateTime(String dateTime) {
    	if(ValidateTool.isEmpty(dateTime)) {
    		return null;
    	}

		// 将 '/' 转为 '-'
		if(dateTime.contains("/")) {
			dateTime = dateTime.replace("/", "-");
		}

    	return LocalDateTime.parse(dateTime, DefaultDateConstant.FORMAT_DATE_TIME);
    }

	/**
	 * 将传入的时间格式字符串转为DateTime类型，传入格式：yyyy-MM-dd HH:mm:ss
	 * @param dateTime
	 * @return
	 */
	public static LocalDateTime parseDateTime(String dateTime, String format) {
		if(ValidateTool.isEmpty(dateTime)) {
			return null;
		}

		// 将 '/' 转为 '-'
		if(dateTime.contains("/")) {
			dateTime = dateTime.replace("/", "-");
		}

		return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(format));
	}
    
    /**
     * 获取开始时间，格式：yyyy-MM-dd 00:00:00
     * @param dateTime
     * @return
     */
    public static LocalDateTime parseBeginDateTime(String dateTime) {
    	if(ValidateTool.isEmpty(dateTime)) {
    		return null;
    	}

		return LocalDateTime.parse(formatBeginDateTime(dateTime), DefaultDateConstant.FORMAT_DATE_TIME);
    }
    
    /**
     * 获取结束时间，格式：yyyy-MM-dd 23:59:59
     * @param dateTime
     * @return
     */
    public static LocalDateTime parseEndDateTime(String dateTime) {
    	
    	if(ValidateTool.isEmpty(dateTime)) {
    		return null;
    	}

		return LocalDateTime.parse(formatEndDateTime(dateTime), DefaultDateConstant.FORMAT_DATE_TIME);
    }

	/**
	 * 得到当前月份的第一天的Date
	 * @return
	 */
	public static LocalDate getFirstDay() {
		return getFirstDay(getDate());
	}
    
    /**
     * 根据传入的字符串date，获取第一天的Date
     * @param date
     * @return
     */
    public static LocalDate getFirstDay(String date) {
    	if(ValidateTool.isEmpty(date)) {
    		return null;
    	}

    	if(ValidateTool.isDate(date)) {
			return getFirstDay(LocalDate.parse(date, DefaultDateConstant.FORMAT_DATE));
		} else {
			return getFirstDay(LocalDate.parse(date, DefaultDateConstant.FORMAT_DATE_TIME));
		}
    }

	/**
	 * 根据传入的日期，获取日期月份第一天的日期
	 * @param date
	 * @return
	 */
	public static LocalDate getFirstDay(LocalDate date) {
		if(date == null) {
			return null;
		}

		return date.with(TemporalAdjusters.firstDayOfMonth());
	}

	/**
	 * 根据传入的日期，获取日期月份第一天的日期
	 * @param dateTime
	 * @return
	 */
	public static LocalDate getFirstDay(LocalDateTime dateTime) {
		if(dateTime == null) {
			return null;
		}

		return dateTime.toLocalDate().with(TemporalAdjusters.firstDayOfMonth());
	}

	public static void main(String[] args) {
		System.out.println(addSecond(LocalDateTime.now(), 20));
	}

	/**
	 * 在当前日期的基础上，增加秒数操作
	 * 如果传入的秒数为大于0的正数，表示在传入日期的基础上新增秒数
	 * 如果传入的秒数为小于0的负数，表示在传入日期的基础上减少秒数
	 * 如果传入的秒数为0，则不进行任何操作
	 * @param seconds       操作增加或者减少的秒数
	 * @return
	 */
	public static LocalDateTime addSecond(int seconds) {
		return addSecond(getDateTime(), seconds);
	}

	/**
	 * 在传入日期格式的基础上增加秒数操作。
	 * 如果传入的秒数为大于0的正数，表示在传入日期的基础上新增秒数
	 * 如果传入的秒数为小于0的负数，表示在传入日期的基础上减少秒数
	 * 如果传入的秒数为0，则不进行任何操作
	 * @param dateTime           传入的 dateTime 时间
	 * @param seconds        操作增加或者减少的秒数
	 * @return
	 */
	public static LocalDateTime addSecond(LocalDateTime dateTime, int seconds) {

		/**
		 * 如果传入的日期为空，或者分钟数为空，则不进行任务操作，直接返回传入的 date 即可
		 */
		if(dateTime == null || seconds == 0) {
			return dateTime;
		}

		if(seconds > 0) {
			return dateTime.plusSeconds(seconds);
		} else {
			return dateTime.minusSeconds(seconds);
		}
	}

	/**
	 * 在当前日期的基础上，增加分钟数操作
	 * 如果传入的分钟数为大于0的正数，表示在传入日期的基础上新增分钟数
	 * 如果传入的分钟数为小于0的负数，表示在传入日期的基础上减少分钟数
	 * 如果传入的分钟数为0，则不进行任何操作
	 * @param minutes       操作增加或者减少的分钟数
	 * @return
	 */
	public static LocalDateTime addMinute(int minutes) {
		return addMinute(getDateTime(), minutes);
	}

	/**
	 * 在传入日期格式的基础上增加分钟数操作。
	 * 如果传入的分钟数为大于0的正数，表示在传入日期的基础上新增分钟数
	 * 如果传入的分钟数为小于0的负数，表示在传入日期的基础上减少分钟数
	 * 如果传入的分钟数为0，则不进行任何操作
	 * @param dateTime           传入的 dateTime 时间
	 * @param minutes        操作增加或者减少的分钟数
	 * @return
	 */
    public static LocalDateTime addMinute(LocalDateTime dateTime, int minutes) {

		/**
		 * 如果传入的日期为空，或者分钟数为空，则不进行任务操作，直接返回传入的 date 即可
		 */
		if(dateTime == null || minutes == 0) {
    		return dateTime;
		}

		if (minutes > 0) {
			return dateTime.plusMinutes(minutes);
		} else {
			return dateTime.minusMinutes(minutes);
		}
	}

	/**
	 * 在当前日期的基础上，增加小时数操作。
	 * 如果传入的小时数为大于0的正数，表示在传入日期的基础上增加小时数。
	 * 如果传入的小时数为小于0的负数，表示在传入日期的基础上减少小时数。
	 * 如果传入的小时数为0，则不进行任何操作。
	 * @param hours     操作增加或者减少的小时数
	 * @return
	 */
	public static LocalDateTime addHour(int hours) {
		return addHour(getDateTime(), hours);
	}

	/**
	 * 在传入日期的基础，增加小时数操作。
	 * 如果传入的小时数为大于0的正数，表示在传入日期的基础上增加小时数。
	 * 如果传入的小时数为小于0的负数，表示在传入日期的基础上减少小时数。
	 * 如果传入的小时数为0，则不进行任何操作。
	 * @param dateTime       传入的 date 日期
	 * @param hours      操作增加或者减少的小时数
	 * @return
	 */
	public static LocalDateTime addHour(LocalDateTime dateTime, int hours) {
		/**
		 * 如果传入的日期为空，或者小时数为空，则不进行任务操作，直接返回传入的 date 即可
		 */
		if(dateTime == null || hours == 0) {
			return dateTime;
		}

		if(hours > 0) {
			return dateTime.plusHours(hours);
		} else {
			return dateTime.minusHours(hours);
		}
	}

	/**
	 * 在当前日期的基础上，增加天数操作。
	 * 如果传入的天数为大于0的正数，表示在传入日期的基础上增加天数。
	 * 如果传入的天数为小于0的负数，表示在传入日期的基础上减少天数。
	 * 如果传入的天数为0，则不进行任何操作。
	 * @param days    操作增加或者减少的天数
	 * @return
	 */
	public static LocalDate addDay(int days) {
    	return addDay(getDate(), days);
	}

	/**
	 * 在传入日期的基础，增加天数操作。
	 * 如果传入的天数为大于0的正数，表示在传入日期的基础上增加天数。
	 * 如果传入的天数为小于0的负数，表示在传入日期的基础上减少天数。
	 * 如果传入的天数为0，则不进行任何操作。
	 * @param date      传入的 date 日期
	 * @param days      操作增加或者减少的天数
	 * @return
	 */
	public static LocalDate addDay(LocalDate date, int days) {
		/**
		 * 如果传入的日期为空，或者小时数为空，则不进行任务操作，直接返回传入的 date 即可
		 */
		if(date == null || days == 0) {
			return date;
		}

		if(days > 0) {
			return date.plusDays(days);
		} else {
			return date.minusDays(days);
		}
	}

	/**
	 * 在当前日期的基础上，增加月操作。
	 * 如果传入的月数为大于0的正数，表示在传入日期的基础上增加月数。
	 * 如果传入的月数为小于0的负数，表示在传入日期的基础上减少月数。
	 * 如果传入的月数为0，则不进行任何操作。
	 * @param months     操作增加或者减少的月数
	 * @return
	 */
	public static LocalDate addMonth(int months) {
		return addMonth(getDate(), months);
	}

	/**
	 * 在传入日期格式的基础上增加月操作。
	 * 如果传入的月数为大于0的正数，表示在传入日期的基础上增加月数。
	 * 如果传入的月数为小于0的负数，表示在传入日期的基础上减少月数。
	 * 如果传入的月数为0，则不进行任何操作。
	 * @param date           传入的 date 日期
	 * @param months         操作增加或者减少的月数
	 * @return
	 */
	public static LocalDate addMonth(LocalDate date, int months) {
		/**
		 * 如果传入的日期为空，或者月数为0，则不进行任务操作，直接返回传入的 date 即可
		 */
		if(date == null || months == 0) {
			return date;
		}

		return date.plusMonths(months);
	}

	/**
	 * 兼容Date类型，将 LocalDate 转为Date
	 * @param date
	 * @return
	 */
	public static Date toDate(LocalDate date) {
		if(date == null) {
			return null;
		}
		ZonedDateTime zonedDateTime = date.atStartOfDay(ZoneId.systemDefault());
		return Date.from(zonedDateTime.toInstant());
	}

	/**
	 * 兼容Date类型，将 LocalDateTime 转为Date
	 * @param dateTime
	 * @return
	 */
	public static Date toDate(LocalDateTime dateTime) {
		if(dateTime == null) {
			return null;
		}
		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zdt = dateTime.atZone(zoneId);
		return Date.from(zdt.toInstant());
	}

}
