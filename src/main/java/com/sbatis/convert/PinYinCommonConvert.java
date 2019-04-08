package com.sbatis.convert;

import com.sbatis.validate.ValidateTool;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;

/**
 * 拼音转换公共库，提供汉字转拼音和转汉字首字母拼音，基于 pinyin4j 开源库进行转换
 * @author HuangLongPu
 */
public class PinYinCommonConvert {

	/**
	 * 将汉字转换为全拼
	 * @param value
	 * @return
	 */
	public static String convertPinYin(String value) {
		/*
		 * 解释一下代码: (1).HanyuPinyinOutputFormat,定义汉语拼音的输出形式.
		 * 
		 * (2).HanyuPinyinCaseType,定义汉语拼音的大小写,如: LOWERCASE min2 UPPERCASE MIN2
		 * 
		 * (3).HanyuPinyinToneType,定义音调的显示方式.如: WITH_TONE_MARK dǎ ,带音调
		 * WITH_TONE_NUMBER da3 ,带音调,用12345表示平上去入和轻声 WITHOUT_TONE da ,不带音调
		 * 
		 * (4).HanyuPinyinVCharType,定义'ü' 的显示方式.如: WITH_U_AND_COLON u:
		 * ,u加两点表示,如律师表示为lu:shi WITH_V v ,用字母v表示,这个用搜狗输入法的人想必有些印象.
		 * WITH_U_UNICODE ü
		 * 
		 * (5).input[i]).matches("[\\u4E00-\\u9FA5]+"),这个用来判断是否为中文的.
		 * 
		 * (6).PinyinHelper.toHanyuPinyinStringArray(input[i],
		 * format),这个返回单字的拼音字符串数组.
		 * 如果音调类型为WITH_TONE_NUMBER的话,"张",将返回"zhang1","李",会返回"li4".
		 * 
		 * (7).t0:将传入要转入的字符转为为char数组的长度
		 * 
		 * (8).t1:传入要转入的字符转为为char数组
		 * 
		 * (9).t2:通过char数组声明t2数组，将汉字的几种全拼都存到t2数组中
		 * 
		 * (10).t3:定义汉语拼音的输出形式
		 * 
		 * (11).t4:转化完成后的拼音
		 */

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