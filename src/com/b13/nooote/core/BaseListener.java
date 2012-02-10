package com.b13.nooote.core;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 * context listener
 * <p>
 * it will be execute when the web container starts. And the init the config for the statistic
 *  System.
 * 
 * @author Eric
 *
 */
public class BaseListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
		// nothing to do
		
	}

	private final String CONFIG_PATH = "WEB-INF/classes/conf";
	
	
	public void contextInitialized(ServletContextEvent e) {
		// TODO Auto-generated method stub
		String path = e.getServletContext().getRealPath("/");
		// init the configuration
		
		ConfigLoader conf = new ConfigLoader();
		conf.setRootPath(path);
		conf.init();
		
	}

	
	
	
}
