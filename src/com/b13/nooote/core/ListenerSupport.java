package com.b13.nooote.core;

import java.util.ArrayList;
import java.util.List;

import com.b13.nooote.exceptions.NoooteException;

/**
 * 修改页面相关的所有的监听，用于嵌入到service中
 * @author Eric
 *
 */
public class ListenerSupport {
	
	ArrayList<NoooteEventListener> listeners ; 
	
	public ListenerSupport(ArrayList<NoooteEventListener> listeners){
		this.listeners = listeners;
	}
	
	public void fireAllListeners(NoooteEvent evt) throws NoooteException{
		for(NoooteEventListener l : listeners){
			l.fire(evt);
		}
	}
}
