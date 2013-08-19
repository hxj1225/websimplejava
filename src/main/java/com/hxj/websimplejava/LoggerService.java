package com.hxj.websimplejava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {

	private Logger logger = LoggerFactory.getLogger(LoggerService.class);
	
	public void addLog() {
		logger.info("loggerService start");
		System.out.println("big head");
		logger.info("loggerService end");
	}
}
