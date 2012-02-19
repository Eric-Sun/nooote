package com.b13.nooote.core;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hb.hutil.core.HUtilException;
import com.hb.hutil.core.Lifecycle;
import com.hb.hutil.xml.XmlUtil;

/**
 * 配置文件加载类
 * @author Eric
 *
 */
public class ConfigLoader implements Lifecycle{
	
	Logger logger = LoggerFactory.getLogger(ConfigLoader.class);

	private static String sysFilePath = "sys.xml";
	private static String rootPath;
	public void setRootPath(String rootPath){
		this. rootPath = rootPath;
	}

	private void loadConfig(){
		String sysFullPath = rootPath+File.separator+sysFilePath;
		
		try {
			XmlUtil xml = new XmlUtil(sysFullPath);
			SysConstant.baseFileUploadPath = xml.getSingleElementText("sys/base_file_upload_path");
			SysConstant.templateFolder = xml.getSingleElementText("sys/template_folder");
			SysConstant.noteHtmlFolder = xml.getSingleElementText("sys/note_html_folder");
			
			
		} catch (HUtilException e) {
			logger.error("config load error. path="+sysFullPath,e);
		}
	}
	
	public void destory() {
	}

	public void init() {
		
		loadConfig();
	}
}
