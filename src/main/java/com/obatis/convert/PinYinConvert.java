package com.obatis.convert;

import com.obatis.tools.ValidateTool;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;

/**
 * 拼音转换公共库，提供汉字转拼音和转汉字首字母拼音，基于 pinyin4j 开源库进行转换
 * @author HuangLongPu
 */
public class PinYinConvert {

	/**
	 * 将汉字转换为全拼
	 * @param value
	 * @return
	 */
	public static String convertPinYin(String value) {
		if(ValidateTool.isEmpty(value)) {
			return "";
		}
		char[] t1 = value.toCharArray();
		String[] t2 = new String[t1.length];
		// 设置汉字拼音输出的格式
		HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
		t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		t3.setVCharType(HanyuPinyinVCharType.WITH_V);
		StringBuffer pinyin = new StringBuffer();
		int t0 = t1.length;
		try {
			for (int i = 0; i < t0; i++) {
				if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
					t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
					// 取出第一种读音进行拼接
					pinyin.append(t2[0]);
				} else {
					// 说明不是汉字字符
					pinyin.append(CommonConvert.toString(t1[i]));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pinyin.toString();
	}

	/**
	 * 将汉字转换为拼音首字母
	 * @param value
	 * @return
	 */
	public static String convertHeaderPinYin(String value) {
		if(ValidateTool.isEmpty(value)) {
			return "";
		}
		StringBuffer headerPinyin = new StringBuffer();
		try {
			for (int j = 0; j < value.length(); j++) {
				char word = value.charAt(j);
				// 提取汉字的首字母
				String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
				if (pinyinArray != null) {
					headerPinyin.append(pinyinArray[0].charAt(0));
				} else {
					headerPinyin.append(word);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 并且将首字母拼音转为小写
		if(!ValidateTool.isEmpty(headerPinyin)) {
			return headerPinyin.toString().toLowerCase();
		}
		return "";
	}

}