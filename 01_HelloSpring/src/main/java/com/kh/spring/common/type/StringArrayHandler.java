package com.kh.spring.common.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class StringArrayHandler implements TypeHandler<String[]> {

	@Override
	public void setParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
		// pstmt(=ps).setString( 인덱스(=i),값(=parameter) )
		if(parameter!=null) {
			ps.setString(i, String.join(",", parameter));
			//"Java,C"이렇게 들어감
		}else {
			ps.setString(i,"");
		}

	}

	@Override
	public String[] getResult(ResultSet rs, String columnName) throws SQLException {
		// 반환을 string[]로 
		String temp=rs.getString(columnName);
		return temp.split(",");
	}

	@Override
	public String[] getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		String temp=rs.getString(columnIndex);
		return temp.split(",");
	}

	@Override
	public String[] getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// DB에 프로시저 호출(실행)시켜 결과를 갖고오는 객체:CallableStatement
		String temp=cs.getString(columnIndex);
		return temp.split(",");
	}

}
