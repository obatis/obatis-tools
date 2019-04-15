package com.obatis.constant.http;

/**
 * 定义HTTP网络请求基本常量
 * @author HuangLongPu
 */
public class DefaultHttpConstant {

	/**
	 * HTTP 请求类型，分别定义 POST 和 GET
	 */
	/**
	 * HTTP 请求类型 POST
	 */
	public static final String REQ_METHOD_GET = "get";
	/**
	 * HTTP 请求类型 GET
	 */
	public static final String REQ_METHOD_POST = "post";

	/**
	 * 以下类型为微服务框架参数传递使用，主要使用于Spring cloud 微服务分布式开发的项目，单体应用则忽略
	 */
	/**
	 * 用户信息传递参数，适用于网关服务将用户信息放置于 header中，微服务项目从header中获取用户信息
	 */
	public static final String USER_INFO_HEADER = "userInfo";
	/**
	 * 用户认证token信息头，放置于请求体的header中
	 */
	public static final String ACCOUNT_TOKEN_HEADER = "accountToken";
}
