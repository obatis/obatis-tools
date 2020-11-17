package com.obatis.generator;

import com.obatis.convert.date.DateConvert;

import java.math.BigInteger;
import java.util.Random;
import java.util.UUID;

/**
 * 获取28长度的纯数字编号，可用作ID、订单号、流水号等。
 * 默认生成28位的数字串，若是下载源码编译jar 包使用的，可自行修改位数。
 * 经过测试，目前在快速生成10万次没发现有重复，欢迎测试并提出改进意见。
 * 如果你有更好的建议，也可以在线留言(留言途径有github项目、obatis项目主页)，我们会及时改进和调整，感谢你的支持 更多建议及意见，可以通过邮箱留言：huanglongpu@126.com。
 * 注：测试时仅为业务实现，未考虑性能问题，测试时可考虑加入线程池或者队列效果会更好。
 * @author HuangLongPu
 */
public final class NumberGenerator {

	private NumberGenerator() {}

	private static final int maxLength = 11;

	/**
	 * 获取类型为BigInteger，位数28位
	 * @return
	 */
	public static final BigInteger getNumber() {
		return new BigInteger(DateConvert.formatDateTimeMillis() + handleNumber());
	}

	/**
	 * 获取number后缀，根据uuid并且补全位数
	 * @return
	 */
	private static String handleNumber() {

		String hashCodeValue = getHashCode() + "";
		int lenth = hashCodeValue.length();
		StringBuffer s = new StringBuffer(hashCodeValue);
		if(lenth > maxLength) {
			s.deleteCharAt(maxLength);
			return s.toString();
		}
		int offset = maxLength - lenth;
		for (int i = 0; i < offset; i++) {
			s.insert(0, new Random().nextInt(10));
		}
		
		return s.toString();
	}

	/**
	 * 获取uuid值的hashcode
	 * @return
	 */
	private static int getHashCode() {
		int hashCode = UUID.randomUUID().hashCode();
		if(hashCode < 0) {
			hashCode = 0 - hashCode;
		}
		return hashCode;
	}

	/**
	 * 获取6位数的随机数字作为验证码
	 * @return
	 */
	public static String getVerifyCode() {
		return getVerifyCode(6);
	}

	/**
	 * 获取设定位数的随机数字作为验证码
	 * @return
	 */
	public static String getVerifyCode(int maxLength) {
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < maxLength; i++) {
			s.append(new Random().nextInt(10));
		}

		return s.toString();
	}
}