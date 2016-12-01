package com.lcy.common.util;

/**
 * 字符串处理封装类
 * @author v_luchuanyou
 *
 */
public class StringUtil {

	/**
	 * 判断字符串是否为空
	 * @param data
	 * @return
	 * true：空
	 * false：不为空
	 */
	public static boolean isEmpty(String data){
		if(null == data || data.length() == 0){
			return true;
		}
		return false;
	}
	/**
	 * 判断字符串不为空
	 * @param data
	 * @return
	 */
	public static boolean isNotEmpty(String data){
		return !isEmpty(data);
	}
}
