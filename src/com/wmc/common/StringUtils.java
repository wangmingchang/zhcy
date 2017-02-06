package com.wmc.common;

import java.util.UUID;

import org.apache.log4j.Logger;
/**
 * 类描述 : 字符串-工具类
 * @version 1.0
 * @author WMC
 *
 */
public class StringUtils {
	private static final Logger log = Logger.getLogger(FileUtils.class);
	
	/**
	 * 截取字符串为value且最后一个字符为chr
	 * @param value
	 * @param chr
	 * @return 
	 */
	public static String subLastChar(String value,String chr){
		String str =  value;
		if(isNotEmpty(value)){
			int indexOf = value.indexOf(chr);
		 str = value.substring(indexOf);
		}
		return str;
	}
	
	/**
	 * 判断是否不为空
	 * @param value
	 * @return boolean
	 */
	  public static boolean isNotEmpty(String value){
	        return value != null && "" != value ? true : false;
	    }

	  /**
	   * 获取UUID
	   * @return
	   */
	  public static String getUUID() {  
	        UUID uuid = UUID.randomUUID();  
	        String str = uuid.toString();  
	        // 去掉"-"符号  
	        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);  
	        return temp;  
	    }
	  
}
