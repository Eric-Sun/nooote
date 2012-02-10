package com.b13.nooote.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.b13.nooote.core.constant.SysConstant;
import com.hb.hutil.core.HUtilException;
import com.hb.hutil.core.Lifecycle;
import com.hb.hutil.xml.XmlUtil;

public class ConfigLoader implements Lifecycle{
	
	Logger logger = LoggerFactory.getLogger(ConfigLoader.class);

	private static String sysFilePath = "/conf/sys.xml";
	private static String rootPath;
	public void setRootPath(String rootPath){
		this. rootPath = rootPath;
	}

	private void loadConfig(){
		String sysFullPath = rootPath+sysFilePath;
		
		try {
			XmlUtil xml = new XmlUtil(sysFullPath);
			SysConstant.baseFileUploadPath = xml.getSingleElementText("base_file_upload_path");
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
