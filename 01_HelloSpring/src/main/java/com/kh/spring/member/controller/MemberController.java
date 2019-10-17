package com.kh.spring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.member.model.service.memberService;
import com.kh.spring.member.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private memberService service;
	@RequestMapping("/member/memberEnroll.do")
	public String member() {
		System.out.println("/member.member.do가 호출됨");
		return "member/memberEnroll";
	}

	@RequestMapping("/member/memberEnrollEnd.do")
	public String memberEnroll(Member m) {
		int result=service.insertMember(m);
		return "redirect:/index.jsp";
	}
	
}
