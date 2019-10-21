package com.kh.spring.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AspectTest {
	private Logger logger = LoggerFactory.getLogger(AspectTest.class);

	// 선언적으로 함->xml에 필요.라이브러리 필요(aspectJ)/web.xml에 넣어주기(항상 xml새로 만들면 추가해줘야함)
	public void beforeTest(JoinPoint jp) {
		
		  logger.debug("=======before========"); Signature
		  sig=jp.getSignature();//Signature:각종 요청 주소나 정보(실행되는 메소드에 대한 정보)를 담고있음 
		  String methodName=sig.getName();//실행되는 메소드의 이름 logger.debug("실행된 메소드: "+methodName);
		 
	}

}
