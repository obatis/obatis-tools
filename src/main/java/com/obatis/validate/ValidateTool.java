package com.obatis.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常规校验库，提供常规通用校验方法
 * @author HuangLongPu
 */
public class ValidateTool {

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
	 * 判断是否是数字（正数）
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
	 * 
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
		String str = "[1-9]{2}[0-9]{4}(19|20)[0-9]{2}" + "((0[1-9]{1})|(1[0-2]{1}))((0[1-9]{1})|([1-2]{1}[0-9]{1}|(3[0-1]{1})))"
				+ "[0-9]{3}[0-9x]{1}";
		Pattern pattern = Pattern.compile(str);
		return pattern.matcher(idNumber).matches();
	}

	/**
	 * 验证手机号码是否正确，正确返回true，否则返回false
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public static boolean isPhoneNumber(String phoneNumber) {
		if (isEmpty(phoneNumber)) {
			return false;
		}
		String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
		if (phoneNumber.length() != 11) {
			return false;
		} else {
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(phoneNumber);
			return m.matches();
		}
	}

	/**
	 * 判断邮箱地址是否正确，正确返回true，否则返回false
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {

		if (isEmpty(email)) {
			return false;
		}
		String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(email);
		return matcher.matches();
	}

	/**
	 * 判断是否包含有中文，有则返回 true，否则返回 false
	 * 
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

}
