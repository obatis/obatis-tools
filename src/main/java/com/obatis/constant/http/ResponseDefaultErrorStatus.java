package com.obatis.constant.http;

/**
 * 请求异常结果返回状态码，该会用于请求返回处理时引用
 * @author HuangLongPu
 */
public class ResponseDefaultErrorStatus {

	/**
	 * 3001:请求参数值无效
	 */
	public static final int PARAM_INVALID_ERROR_STATUS = 3001;
	/**
	 * 3002:请求参数值类型不匹配
	 */
	public static final int PARAM_TYPE_ERROR_STATUS = 3002;
	/**
	 * 3003:请求体 header token为空
	 */
	public static final int TOKEN_NULL_ERROR_STATUS = 3003;
	/**
	 * 5000:业务异常，一般表示为进行手动异常抛出
	 */
	public static final int BUS_ERROR_STATUS = 5000;
	/**
	 * 5001:微服务熔断异常
	 */
	public static final int FAIL_BACK_ERROR_STATUS = 5001;
	/**
	 * 5002:HTTP URL 地址错误
	 */
	public static final int URL_ERROR_STATUS = 5002;
	/**
	 * 5003:微服务网关请求服务异常
	 */
	public static final int GATEWAY_REQ_ERROR_STATUS = 5003;
	/**
	 * 5004:程序错误，运行异常
	 */
	public static final int RUN_ERROR_STATUS = 5004;
	/**
	 * 5005:程序执行错误，未知异常（表示程序执行错误，未进行try……catch 处理）
	 */
	public static final int SYSTEM_ERROR_STATUS = 5005;
	/**
	 * 6001:用户未登录
	 */
	public static final int NOT_LOGIN_ERROR_STATUS = 6001;
	/**
	 * 6002:请求未授权，没有操作权限
	 */
	public static final int NOT_AUTH_ERROR_STATUS = 6002;
	/**
	 * 7001:发送邮件异常
	 */
	public static final int SEND_MAIL_ERROR_STATUS = 7001;
}
