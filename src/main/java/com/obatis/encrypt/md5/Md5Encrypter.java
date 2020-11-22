package com.obatis.encrypt.md5;

import java.security.MessageDigest;

/**
 * md5加密库，该md5加密方法用于常规的md5标准，不包含其他特殊标准的md5加密。
 * 由于特殊情况，一些机构返回的md5加密串码为非常规加密生成，若用此方法生成md5串码进行比较，或许存在比对失败的情况
 * @author HuangLongPu
 */
public class Md5Encrypter {

	/**
	 * 进行Md5串加密，返回16位字符串
	 * @param text
	 * @return
	 */
	public static String encrypt16(String text) {
		return toStringBuffer(text).toString().substring(8, 24);
	}

	/**
	 * 进行Md5串加密，返回32位字符串
	 * @param text
	 * @return
	 */
	public static String encrypt32(String text) {
		return toStringBuffer(text).toString();
	}

	private static StringBuffer toStringBuffer(String text) {
		int i;
		if (text == null)
			text = "";

		StringBuffer buf = new StringBuffer();
		try {
			MessageDigest md;
			(md = MessageDigest.getInstance("MD5")).update(text.getBytes());

			byte[] b = md.digest();

			for (int offset = 0; offset < b.length; ++offset) {
				if ((i = b[offset]) < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}

				buf.append(Integer.toHexString(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buf;
	}
}