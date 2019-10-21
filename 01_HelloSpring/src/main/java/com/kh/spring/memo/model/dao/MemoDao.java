package com.kh.spring.memo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.memo.model.vo.Memo;


public interface MemoDao {
	int insertMemo(SqlSessionTemplate session, Memo memo);

	List<Memo> selectMemo(SqlSessionTemplate session);
	

}
