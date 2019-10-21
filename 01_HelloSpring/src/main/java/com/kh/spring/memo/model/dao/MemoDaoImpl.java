package com.kh.spring.memo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.memo.model.vo.Memo;

@Repository
public class MemoDaoImpl implements MemoDao {

	@Override
	public int insertMemo(SqlSessionTemplate session, Memo memo) {
		// TODO Auto-generated method stub
		return session.insert("memo.insertMemo",memo);
	}

	@Override
	public List<Memo> selectMemo(SqlSessionTemplate session) {
		return session.selectList("memo.selectMemo");
	}
	
	
	
	
	
	

}
