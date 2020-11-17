package com.obatis.constant.http;

/**
 * 定义网络请求基础异常错误状态异常码，框架默认使用，该会用于请求返回处理时引用
 * @author HuangLongPu
 */
public class ResponseErrorCode {

	/**
	 * 默认返回异常，提现在业务处理时错误返回码为空时使用
	 */
	public static final String DEFAULT_ERROR_CODE = "ERR01";
	/**
	 * 请求参数值无效异常码，比如要求非空时传入空值
	 */
	public static final String PARAM_INVALID_ERROR_CODE = "ERR0101";
	/**
	 * 传入参数值类型不匹配异常码，比如要求 int 类型传入了字符串 "abc"
	 */
	public static final String PARAM_TYPE_ERROR_CODE = "ERR0102";
	/**
	 * 账户未登录异常码
	 */
	public static final String NOT_LOGIN_ERROR_CODE = "ERR0103";
	/**
	 * 请求未授权异常码
	 */
	public static final String NOT_AUTH_ERROR_CODE = "ERR0104";
	/**
	 * 发送邮件异常码
	 */
	public static final String SEND_MAIL_ERROR_CODE = "ERR0105";
	/**
	 * HTTP请求方式不支持，例如POST接口用GET方式请求
	 */
	public static final String METHOD_NOT_SUPPORT_ERROR_CODE = "ERR0106";
	/**
	 * HTTP网络请求异常码，表示请求状态码非200
	 */
	public static final String NETWORK_ERROR_CODE = "ERR02";
	/**
	 * HTTP请求URL地址不正确，表示请求状态码为404
	 */
	public static final String URL_NOT_FOUND_ERROR_CODE = "ERR0201";
	/**
	 * 网关请求服务异常码，表示请求状态非200
	 */
	public static final String GATEWAY_REQ_ERROR_CODE = "ERR0202";
	/**
	 * 业务代码执行错误，系统运行异常码
	 */
	public static final String SYSTEM_ERROR_CODE = "ERR03";
	/**
	 * 业务代码执行错误，空指针异常码
	 */
	public static final String NULL_POINTER_ERROR_CODE = "ERR0301";
	/**
	 * 业务代码执行错误，数组(集合)越界异常码
	 */
	public static final String INDEX_OUT_ERROR_CODE = "ERR0302";
	/**
	 * 业务代码执行错误，SQL数据库执行异常码
	 */
	public static final String SQL_EXECUTE_ERROR_CODE = "ERR0303";
}
