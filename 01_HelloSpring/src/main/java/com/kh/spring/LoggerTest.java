package com.kh.spring;
//Append가 console!!

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
	
	//logger를 찍기 위해서는 Logger객체를 생성해야함. 맴버변수로 logger 생성하기
	private static Logger logger =LoggerFactory.getLogger(LoggerTest.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//테스트 호출
		LoggerTest.test();//test()에 순차적으로 찍힘
		//p(레벨):c(class):m(message) 이렇게 찍힘
		//logger level의 따라 찍히는 게 다름
		
	}
	public static void test() {
		logger.debug("DEBUG LOGGER");
		logger.info("INFO LOGGER");
		logger.warn("WARN LOGGER");
		logger.error("ERROR LOGGER");
		
	}
	

}
