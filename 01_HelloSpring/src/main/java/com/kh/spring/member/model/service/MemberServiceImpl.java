package com.kh.spring.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.member.model.dao.MemberDao;
import com.kh.spring.member.model.vo.Member;
//@Component 이렇게 해도 bean등록이 됨-@만 보고 구분을 하기때문, 하지만 구분하기 위해 무얼 했는지 잘 써주는 게 좋음
@Service
public class MemberServiceImpl implements MemberService{
	
	//service의 역할
	//session관리(connection)
	//3가지 : connection생성(=SqlSession), connection.close()
	//		,트랜잭션처리(spring에게 위임함,aop와 트랙잭션 묶어서 처리 , 뒤에서 할것임)
	//spring은 bean으로 등록했으니 SqlSessionTemplate로 써주면 끝
	
	@Autowired
	private SqlSessionTemplate session;
	@Autowired
	private MemberDao dao;
	
	@Override
	public int insertMember(Member m) {
		
		return dao.insertMember(session, m);
	}

	@Override
	public Member selectMemberOne(Member m) {
		// TODO Auto-generated method stub
		return dao.selectMemberOne(session,m);
	}
	
	
	
	
}
