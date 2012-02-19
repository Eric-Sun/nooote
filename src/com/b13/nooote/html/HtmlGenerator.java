package com.b13.nooote.html;

import java.util.Map;

import com.b13.nooote.exceptions.HtmlGeneratorException;
import com.b13.nooote.exceptions.NoooteException;

import freemarker.template.Configuration;

/**
 * 静态页生成的接口
 * @author Eric
 *
 */
public interface HtmlGenerator {

	/**
	 * 生成静态的html页面
	 * @param valueMap
	 * @param templateFilePath
	 * @param destFilePath
	 * @return
	 */
	public boolean gen(Map<String, String> valueMap , String templateFilePath,String destFilePath)throws NoooteException;

}
