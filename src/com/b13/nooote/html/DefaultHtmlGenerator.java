package com.b13.nooote.html;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.b13.nooote.exceptions.HtmlGeneratorException;

public class DefaultHtmlGenerator implements HtmlGenerator{
	Logger logger = LoggerFactory.getLogger(DefaultHtmlGenerator.class);
	
	private static String SUFFIX = "\\}";
	private static String PREFIX = "\\$\\{";
	BufferedWriter bw = null;
	BufferedReader br = null;
	StringBuilder sb = new StringBuilder();
	public boolean gen(Map<String, String> valueMap, String templateFilePath,
			String destFilePath) throws HtmlGeneratorException {
		try {
			File destFile = new File(destFilePath);
			if( ! destFile.exists() )
				destFile.createNewFile();
			bw = new BufferedWriter(new OutputStreamWriter( new  FileOutputStream(destFile),"UTF-8"));
		
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(templateFilePath)),"UTF-8"));
			
			// 读取template文件
			String templLine = null;
			while((templLine=br.readLine())!=null){
				sb.append(templLine).append("\r\n");
			}
			String tmp = sb.toString();
			// 替换
			for( String key : valueMap.keySet()){
				System.out.println(key);
				String realKey = new StringBuilder().append(PREFIX).append(key).append(SUFFIX).toString();
				tmp = tmp.replaceAll(realKey, valueMap.get(key));
			}
			bw.write(tmp);
			bw.flush();
			bw.close();
			br.close();
		} catch (Exception e) {
			throw new HtmlGeneratorException("genereate file error. templ="+templateFilePath+" dest="+destFilePath,e );
		}
		return false;
	}

}
