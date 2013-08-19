package com.hxj.websimplejava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxj.websimplejava.LoggerService;

@Controller
public class HelloSpringMvc {

	@Autowired
	private LoggerService loggerService;
	
	@RequestMapping(value = "/helloSpringMvc.do")
	public void hello() {
		loggerService.addLog();
	}
	public void setLoggerService(LoggerService loggerService) {
		this.loggerService = loggerService;
	}
}
