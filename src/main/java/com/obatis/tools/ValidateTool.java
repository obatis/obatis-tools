package com.obatis.tools;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常规校验库，提供常规通用校验方法
 * @author HuangLongPu
 */
public class ValidateTool {

	/**
	 * 身份证号码正则表达式
	 */
	private static final String ID_NUMBER_REGEX = "[1-9]{1}[0-9]{5}(19|20)[0-9]{2}((0[1-9]{1})|(1[0-2]{1}))((0[1-9]{1})|([1-2]{1}[0-9]{1}|(3[0-1]{1})))[0-9]{3}[0-9x]{1}";
	/**
	 * 手机号码正则表达式
	 */
	private static final String PHONE_NUMBER_REGEX = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(16[5,6])|(17[0-8])|(18[0-9])|(19[1、5、8、9]))\\d{8}$";
	/**
	 * 座机号码正则表达式
	 */
	private static final String TELEPHONE_NUMBER_REGEX = "^0[0-9]{2,3}[-|－][0-9]{7,8}([-|－][0-9]{1,4})?$";
	/**
	 * 电子邮箱正则表达式
	 */
	private static final String EMAIL_REGEX = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

	/**
	 * 身份证正则模板
	 */
	private static final Pattern ID_NUMBER_PATTERN = Pattern.compile(ID_NUMBER_REGEX);
	/**
	 * 手机号码正则模板
	 */
	private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(PHONE_NUMBER_REGEX);
	/**
	 * 座机号码正则模板
	 */
	private static final Pattern TELEPHONE_NUMBER_PATTERN = Pattern.compile(TELEPHONE_NUMBER_REGEX);
	/**
	 * 联系电话正则模板
	 */
	private static final Pattern CONTACT_NUMBER_PATTERN = Pattern.compile("(" + PHONE_NUMBER_REGEX + ")|(" + TELEPHONE_NUMBER_REGEX + ")");
	/**
	 * 电子邮箱正则模板
	 */
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

	/**
	 * 针对字符串的空判断，如果为空，返回ture，否则false。null、空字符串、空格等均判断为空，会转换为小写进行比较
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(String value) {
		if(value == null || "".equals(value.trim()) || "null".equals(value) || "null".equals(value.toLowerCase())) {
			return true;
		}
		return false;
	}

	/**
	 * 针对对象的空判断，如果为空，返回ture，否则false
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(Object value) {
		if (value == null) {
			return true;
		}

		if (value instanceof String) {
			return isEmpty((String) value);
		} else {
			return isEmpty(value.toString());
		}

	}

	/**
	 * 判断是否为整数(包括负数)
	 * @param value
	 * @return
	 */
	public static boolean isNumeric(Object value) {
		if (isEmpty(value)) {
			return false;
		}
		return (Pattern.compile("^-?[0-9]+")).matcher(value.toString()).matches();
	}

	/**
	 * 判断是否为整数（正数）
	 * @param value
	 * @return
	 */
	public static boolean isNumber(String value) {
		if (isEmpty(value)) {
			return false;
		}
		return (Pattern.compile("[0-9]*")).matcher(value).matches();
	}

	/**
	 * 判断是否为数字，可以为整数、小数
	 * @param obj
	 * @return
	 */
	public static boolean isFloat(Object obj) {
		if (isEmpty(obj)) {
			return false;
		}
		return obj.toString().matches("-?[0-9]+.*[0-9]*");
	}

	/**
	 * 验证身份证号是否正确，正确返回true，否则返回false
	 * @param idNumber
	 * @return
	 */
	public static boolean isIdNumber(String idNumber) {
		if (isEmpty(idNumber)) {
			return false;
		}
		/**
		 * HuangLongPu 2019-11-01 >>>  之前为 [1-9]{2}[0-9]{4}，改为 [1-9]{1}[0-9]{5} 主要兼容比如 50开头的身份证号码
		 */
		return ID_NUMBER_PATTERN.matcher(idNumber).matches();
	}

	/**
	 * 验证手机号码是否正确，正确返回true，否则返回false
	 * @param phoneNumber
	 * @return
	 */
	public static boolean isPhoneNumber(String phoneNumber) {
		if (isEmpty(phoneNumber)) {
			return false;
		}
//		String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
		/**
		 * 2020年5月新增165、172、174、191、195 等号段的验证
		 */
		if (phoneNumber.length() != 11) {
			return false;
		} else {
			return PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches();
		}
	}

	/**
	 * 验证是否为座机号码
	 * @param telephoneNumber
	 * @return
	 */
	public static boolean isTelephone(String telephoneNumber) {
		if (isEmpty(telephoneNumber)) {
			return false;
		}
		return TELEPHONE_NUMBER_PATTERN.matcher(telephoneNumber).matches();
	}

	/**
	 * 校验联系电话格式是否正确，主要体现为包含手机号码和座机
	 * @param contactNumber
	 * @return
	 */
	public static boolean isContactNumber(String contactNumber) {
		if (isEmpty(contactNumber)) {
			return false;
		}
		return CONTACT_NUMBER_PATTERN.matcher(contactNumber).matches();
	}

	/**
	 * 判断邮箱地址是否正确，正确返回true，否则返回false
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {

		if (isEmpty(email)) {
			return false;
		}
		return EMAIL_PATTERN.matcher(email).matches();
	}

	/**
	 * 判断是否包含有中文，有则返回 true，否则返回 false
	 * @param message
	 * @return
	 */
	public static boolean isHaveChinese(String message) {
		if(isEmpty(message)) {
			return false;
		}
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(message);
		return m.find();
	}

	/**
	 * 判断日期格式是否正确
	 * @param date
	 * @return
	 */
	public static boolean isDate(String date) {
		if(isEmpty(date)) {
			return false;
		}
		String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
		Pattern pat = Pattern.compile(rexp);
		Matcher mat = pat.matcher(date);
		return mat.matches();
	}

	/**
	 * 判断值是否为0
	 * @param value
	 * @return
	 */
	public static boolean isZero(Integer value) {
		if(value == null || value.intValue() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断值是否为0，包括空也归属为0的判断
	 * @param value
	 * @return
	 */
	public static boolean isZero(String value) {
		if(isEmpty(value)) {
			return true;
		} else if("0".equals(value)) {
			return true;
		}
		return false;
	}

	/**
	 * 判断值是否为0，包括空也归属为0的判断
	 * @param value
	 * @return
	 */
	public static boolean isZero(Long value) {
		if(value == null || value.intValue() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断值是否为0，包括空也归属为0的判断
	 * @param value
	 * @return
	 */
	public static boolean isZero(Double value) {
		if(value == null || value.intValue() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断值是否为0，包括空也归属为0的判断
	 * @param value
	 * @return
	 */
	public static boolean isZero(BigDecimal value) {
		if(value == null || value.compareTo(BigDecimal.ZERO) == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断值是否为0，包括空也归属为0的判断
	 * @param value
	 * @return
	 */
	public static boolean isZero(BigInteger value) {
		if(value == null || value.compareTo(BigInteger.ZERO) == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断值是否为0，包括空也归属为0的判断
	 * @param value
	 * @return
	 */
	public static boolean isZero(Object value) {
		if(isEmpty(value)) {
			return true;
		} else if (value instanceof Integer) {
			return isZero((Integer) value);
		} else if (value instanceof Long) {
			return isZero((Long) value);
		} else if (value instanceof Double) {
			return isZero((Double) value);
		} else if (value instanceof BigDecimal) {
			return isZero((BigDecimal) value);
		} else if (value instanceof BigInteger) {
			return isZero((BigInteger) value);
		} else {
			return value.toString().equals("0");
		}
	}

	/**
	 * 判断是否为数字、字母、下划线的组合
	 * @param value
	 * @return
	 */
	public static boolean isAlphanumericUnderline(Object value) {
		return !ValidateTool.isEmpty(value) && value.toString().matches("[0-9A-Za-z_-]*");
	}

	/**
	 * 判断车牌号格式是否正确
	 * @param vehicleLicense
	 * @return
	 */
	public static boolean isVehicleLicense(String vehicleLicense) {
		if(ValidateTool.isEmpty(vehicleLicense)) {
			return false;
		}
		String check = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领](([A-HJ-NP-Z]{2}|[A-HJ-NP-Z][0-9])[A-HJ-NP-Z0-9挂]{4,5}$)|([0-9]{2}[A-HJ-NP-Z0-9挂]{5,6}$)";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(vehicleLicense);
		return matcher.matches();
	}

}
