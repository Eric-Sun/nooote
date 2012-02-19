package com.b13.nooote.core;

/**
 * 监听的类型
 * @author Eric
 *
 */
public class NoooteEventType {
	
	/**
	 * 创建一个note
	 */
	public static String CREATE_NOTE = "0";
	
	/**
	 * 重新创建一个note，修改一个note等，需要重载note页面的
	 */
	public static String MODIFY_NOTE = "1";
	
}
