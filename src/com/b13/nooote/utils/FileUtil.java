package com.b13.nooote.utils;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {
	static Logger logger = LoggerFactory.getLogger(FileUtil.class);
	
	/**
	 * 删除文件，如果不存在不做任何操作，如果存在的话就删除
	 * @param fileName
	 * @return true 成功删除  false 删除失败
	 */
	public static boolean delete(String fileName){
		File file = new File(fileName);
		boolean b = false;
		if( file.exists() ){
			b = file.delete();
		}
		if ( ! b )
			logger.warn(fileName+" delete error! ");
		else{
			logger.debug(fileName+" delete successful! ");
		}
		return b;
	}

	/**
	 * 删除文件，如果不存在的话，不做任何操作，如果存在的话删除
	 * @param file
	 * @return true 成功删除  false 删除失败
	 */
	public static boolean delete(File file){
		if( file.exists() ){
			return file.delete();
		}
		return true;
	}
}
