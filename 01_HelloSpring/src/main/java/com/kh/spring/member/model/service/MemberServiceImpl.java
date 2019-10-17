package com.kh.spring.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.member.model.dao.MemberDao;
import com.kh.spring.member.model.vo.Member;

@Service
public class MemberServiceImpl implements memberService{
	
	@Autowired
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertMember(Member m) {
		
		return dao.insertMember(session, m);
	}
	
	
	
	
}
