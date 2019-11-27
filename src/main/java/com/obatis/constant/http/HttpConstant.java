package com.obatis.constant.http;

/**
 * 定义HTTP网络请求基本常量
 * @author HuangLongPu
 */
public class HttpConstant {

	/**
	 * HTTP 请求类型，分别定义 POST 和 GET
	 */
	/**
	 * HTTP 请求类型 POST
	 */
	public static final String METHOD_GET = "get";
	/**
	 * HTTP 请求类型 GET
	 */
	public static final String METHOD_POST = "post";

	/**
	 * Http 网络请求参数，防止用户信息header 和 认证token等
	 */
	/**
	 * 用户信息传递参数，适用于网关服务将用户信息放置于 header中，微服务项目从header中获取用户信息
	 */
	public static final String HEADER_USER_INFO = "userInfo";
	/**
	 * 用户认证token信息头，放置于请求体的header中
	 */
	public static final String HEADER_ACCOUNT_TOKEN = "accountToken";
	/**
	 * 请求参数签名，放置于请求体的header中
	 */
	public static final String HEADER_SIGN = "sign";
}
