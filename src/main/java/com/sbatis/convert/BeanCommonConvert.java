package com.sbatis.convert;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NameTransformers;
import org.modelmapper.convention.NamingConventions;

/**
 * bean 类型转换库
 * @author HuangLongPu
 */
public class BeanCommonConvert {

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	static {
		MODEL_MAPPER.getConfiguration().setSourceNamingConvention(NamingConventions.JAVABEANS_ACCESSOR)
				.setDestinationNamingConvention(NamingConventions.JAVABEANS_MUTATOR).setSourceNameTransformer(NameTransformers.JAVABEANS_ACCESSOR)
				.setDestinationNameTransformer(NameTransformers.JAVABEANS_MUTATOR).setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * 单个转换方法，包括map转对象、对象转对象等
	 * @param source       源
	 * @param targetClass  目标类型
	 * @return
	 */
	public static <M> M convert(Object source, Class<M> targetClass) {
		if (source == null) {
			return null;
		}
		return MODEL_MAPPER.map(source, targetClass);
	}

	/**
	 * List bean 列表转换，针对两个list不用泛型的转换
	 * @param sourceList    源列表
	 * @param targetClass   目标class泛型类型
	 * @return
	 */
	public static <MS, M> List<M> listConvert(Collection<MS> sourceList, Class<M> targetClass) {
		List<M> items = new ArrayList<M>();
		if (sourceList == null) {
			return items;
		}
		for (MS source : sourceList) {
			items.add(convert(source, targetClass));
		}
		return items;
	}

	/**
	 * 实体对象转成Map
	 * @param obj 实体对象
	 * @return
	 */
	public static Map<String, Object> objConvertMap(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj == null) {
			return map;
		}
		Class<?> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		try {
			for (Field field : fields) {
				// 过滤static 和 final 修饰的变量
				int mod = field.getModifiers();
				if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
					continue;
				}
				field.setAccessible(true);
				map.put(field.getName(), field.get(obj));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
