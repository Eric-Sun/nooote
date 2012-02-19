package com.b13.nooote.core;

import java.util.EventListener;

import com.b13.nooote.exceptions.HtmlGeneratorException;
import com.b13.nooote.exceptions.NoooteException;

/**
 * 时间的监听，绑定在固定的组件上，如果调用fire，来进行触发
 * 传入的是一个event的对象，其中包含对象和时间的类型
 * <p>
 * 每一个listener可能会触发多种不同的事件类型
 * @author Eric
 *
 */
public interface NoooteEventListener extends EventListener {
	
	/**
	 * 触发规定的事件
	 * @param evt
	 */
	public void fire(NoooteEvent evt) throws NoooteException;

}
