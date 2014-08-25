package com.hxj.websimplejava.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@WebServlet(name = "initServlet",urlPatterns = "/")
public class InitServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5786977240355542619L;

	private  Logger logger = LoggerFactory.getLogger(InitServlet.class);
	
	public void init () {
		
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp){
		
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp){
		this.doGet(req, resp);
	}
	
	public void destroy() {
		
	}

}
