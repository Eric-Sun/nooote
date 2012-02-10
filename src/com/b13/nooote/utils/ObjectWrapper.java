package com.b13.nooote.utils;

import java.util.Date;

/**
 * 用来处理对象的转换问�?
 * @author Eric
 *
 */
public class ObjectWrapper {
	
	/**
	 * 当传入的对象为null的时候，返回""的字符串
	 * @param o
	 * @return
	 */
	public static String cvt2String(Object o){
		if ( o == null ){
			return "";
		}else {
			return o.toString();
		}
	}
	
	public static long cvt2Long(Object o){
		if ( o == null )
			return 0;
		else
			return new Long(o.toString());
	}

	public static int cvt2Int(Object o){
		if ( o == null )
			return 0;
		else
			return new Integer(o.toString());
	}
	
	public static Date cvt2Date(Object o){
		if( o == null )
			return null;
		else
			return (Date)o;
	}
}
