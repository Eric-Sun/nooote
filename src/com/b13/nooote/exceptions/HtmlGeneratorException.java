package com.b13.nooote.exceptions;

public class HtmlGeneratorException extends NoooteException {
	
	public HtmlGeneratorException(String msg){
			super(msg);
	}
	
	public HtmlGeneratorException(String msg, Throwable t){
		super(msg,t);
	}
}
