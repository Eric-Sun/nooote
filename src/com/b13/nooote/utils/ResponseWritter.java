package com.b13.nooote.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseWritter {
	
	HttpServletResponse resp = null;
	
	public ResponseWritter(HttpServletResponse resp){
		this.resp = resp;
	}
	
	public ResponseWritter write(String msg) throws IOException{
		resp.getWriter().write(msg);
		return this;
	}
	
	public void end() throws IOException{
		resp.flushBuffer();
	}

}
