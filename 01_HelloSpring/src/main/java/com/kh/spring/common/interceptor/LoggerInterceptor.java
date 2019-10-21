package com.kh.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
	private Logger logger=LoggerFactory.getLogger(LoggerInterceptor.class);

	//preHandle,postHandle만 override할것
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//HttpServletRequest request, HttpServletResponse response:doget/dopost와 같음.즉 서블릿처럼 처리할 수 있음
		
		logger.debug("=============start!============");
		logger.debug("요청주소: "+request.getRequestURI());
		logger.debug("------------메소드 시작!--------------");
		return super.preHandle(request, response, handler);
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		logger.debug("------------메소드 종료!--------------");
		logger.debug(""+modelAndView.getViewName());
		if(modelAndView.getModel()!=null) {
			for(String key:modelAndView.getModel().keySet()) {
				logger.debug(key+":"+modelAndView.getModel().get(key));//응답하기 전에 확인가능 하다
			}
		}	
			logger.debug("=============end!===============");
		super.postHandle(request, response, handler, modelAndView);
		
		//ModelAndView: 모델안에 들어있는 객체, 모듈들을 확인가능함
	}
	

}
