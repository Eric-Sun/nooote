package com.b13.nooote.html;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hb.hutil.core.Lifecycle;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;

public class HtmlGenreratorFactory {
	
	private HtmlGenreratorFactory(){
	}
	
	public static HtmlGenerator getGenerator(){
		return new DefaultHtmlGenerator(); 
	}

}
