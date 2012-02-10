package com.b13.nooote.exceptions;

public class NoooteException extends Exception{
	
	public NoooteException(String msg){
		super(msg);
	}
	
	public NoooteException(String msg,Throwable t){
		super(msg,t);
	}

}
