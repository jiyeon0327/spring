package com.kh.spring.demo.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.demo.dao.DemoDao;
import com.kh.spring.demo.model.vo.Dev;

//라고 표시하는 순간 DemoService에 넣어줌
@Service
public class DemoServiceImpl implements DemoService {
	//선언된 "controller에 @autowired"에 찾아서 자동으로 넣어줌
	//spring이 관리하는 bean이 됨
	
	@Autowired
	private DemoDao dao;
	@Autowired
	private SqlSessionTemplate session;//db에서 설정을 따로 안해줘도 이미 갖고 있음 ->session.select이런식으로 넣어주면 됨
	
	@Override
	public int insertDemo(Dev dev) {
		return dao.insertDemo(session,dev);
	}
	
	
	

}
