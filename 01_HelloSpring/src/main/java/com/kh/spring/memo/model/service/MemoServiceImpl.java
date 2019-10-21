package com.kh.spring.memo.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.memo.model.dao.MemoDao;
import com.kh.spring.memo.model.vo.Memo;

@Service
public class MemoServiceImpl implements MemoService {

	@Autowired 
	SqlSessionTemplate session;
	@Autowired
	MemoDao dao;
	
	@Override
	public List<Memo> selectMemoList() {
		return dao.selectMemo(session);
	}

	@Override
	public int insertMemo(Memo memo) {
		return dao.insertMemo(session,memo);
	}

}
