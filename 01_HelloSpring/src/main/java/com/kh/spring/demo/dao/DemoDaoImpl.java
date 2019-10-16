package com.kh.spring.demo.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.demo.model.vo.Dev;

@Repository
public class DemoDaoImpl implements DemoDao{

	//spring관련 어노테이션 만들기
	
	@Override
	public int insertDemo(SqlSessionTemplate session,Dev dev){
		return session.insert("dev.insertDemo",dev);
	}
	
}
