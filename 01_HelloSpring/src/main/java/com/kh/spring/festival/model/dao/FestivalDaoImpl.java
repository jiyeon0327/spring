package com.kh.spring.festival.model.dao;




import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.festival.model.vo.Festival;

@Repository
public class FestivalDaoImpl implements FestivalDao {


	@Override
	public int insertFestival(SqlSessionTemplate session, Festival festival) {
		return session.insert("festival.insertFestival",festival);
	}

	@Override
	public List<Festival> selectFestivalList(SqlSessionTemplate session) {
		return session.selectList("festival.selectFestivalList");
	}

	@Override
	public Festival selectFestival(SqlSessionTemplate session, int festival_No) {
		return session.selectOne("festival.selectFestival",festival_No);
	}

	@Override
	public Festival deleteFestival(SqlSessionTemplate session, String festival_Writer) {
		return session.delete("festival.deleteFestival",festival_Writer);
	}

	
	
	
	
	

}
