package com.b13.nooote.core;

public class BaseDAO {

	/**
	 * update aa set bb = ? ,cc =? where id=1<p>
	 * 该方法用于生成 <code> bb=?,cc=? </code>
	 * @param sb
	 * @param objArr
	 */
	protected int createUpdateSqlAfterSet(StringBuilder sb , Object ... objArr) {
		int sum = 0 ;
		for( Object o : objArr ){
			if ( o != null ){
				sb.append(" ").append(o.toString()).append("=").append("?").append(" ,");
				sum++;
			}
		}
		sb.substring(0, sb.length()-1);
		return sum;
	}
	
}
