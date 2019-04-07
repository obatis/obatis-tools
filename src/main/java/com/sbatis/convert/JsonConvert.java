package com.sbatis.convert;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sbatis.convert.date.DefaultDateConstant;

/**
 * JSON转换公共库，支持Java对象于json字符串的互相转换，基于 alibaba fastjson 标准
 * @author HuangLongPu
 */
public class JsonConvert {

	/**
	 * 将Json字符串转为list集合，需传入泛型class
	 * @param json
	 * @param cls
	 * @return
	 */
	public static <M> List<M> jsonConvertList(String json, Class<M> cls) {
		return JSONArray.parseArray(json, cls);
	}

	/**
	 * 将json字符串转为Java对象，需传入泛型class
	 * @param json
	 * @param cls
	 * @return
	 */
	public static <M> M jsonConvertObject(String json, Class<M> cls) {
		return JSONObject.parseObject(json, cls);
	}
	
	/**
	 * 将Java对象转为Json字符串,传入Java对象（Object的子类）即可
	 * @param obj
	 * @return
	 */
	public static String objConvertJson(Object obj) {
		return JSONObject.toJSONStringWithDateFormat(obj, DefaultDateConstant.DATE_TIME_PATTERN, SerializerFeature.WriteDateUseDateFormat);
	}
}
