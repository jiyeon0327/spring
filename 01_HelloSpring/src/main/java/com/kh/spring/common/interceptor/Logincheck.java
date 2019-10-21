package com.kh.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Logincheck extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getSession().getAttribute("loginMember")==null){
			request.setAttribute("msg", "로그인 후 이용하세요!");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);//dispatcher은 안거치고 감 
			return false;
			//요청->controller로 가는 걸 다 인터셉트가 가로챌 수 있음
			//demo에 들어오는 걸 관리자만 들어갈 수 있게 하려면 마찬가지로 interceptor 하나를 통해서 패턴설정해놓으면 됨
		}
		else {
			return super.preHandle(request, response, handler);//super는 무조건 true야
	}
	
	
	}
}
