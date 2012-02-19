package com.b13.nooote.core;

import java.util.EventObject;

/**
 * nooote系统中的event实体类，用来存储event的信息，比如源，目的，类型，等参数
 * @author Eric
 *
 */
public class NoooteEvent extends EventObject {
	private Object origin;
	
	private String type;
	
	private Object data;
	

	public NoooteEvent(){
		super(null);
	}

	public NoooteEvent(Object origin , String type ,Object data){
		super(origin);
		this.origin = origin;
		this.data = data;
		this.type = type;
	
	}
	

	public Object getOrigin() {
		return origin;
	}

	public String getType() {
		return type;
	}

	public Object getData() {
		return data;
	}
}
