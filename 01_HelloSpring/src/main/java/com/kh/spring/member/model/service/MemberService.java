package com.kh.spring.member.model.service;

import org.springframework.stereotype.Service;

import com.kh.spring.member.model.vo.Member;

public interface MemberService {
	//여기선 자료형으로만 쓰는 것!얘를 통해서 service를 연결만
	int insertMember(Member m);//구현한 객체를 springbean등록하기 =>2가지:1)@방식선언 2)servlet-context.xml에서 등록
	
	Member selectMemberOne(Member m);
	
}
