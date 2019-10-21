package com.kh.spring.memo.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Memo {
	
	private int memoNo; 
	private String memo;
	private int password;
	private Date memoDate;
	
	

}
