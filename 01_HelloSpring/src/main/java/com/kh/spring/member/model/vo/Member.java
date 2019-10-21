package com.kh.spring.member.model.vo;

import java.sql.Date;

import com.kh.spring.demo.model.vo.Dev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//디폴트 생성자 빼먹지 말고 꼭 만들것
//->@NoArgsConstructor,@AllArgsConstructor,@Data

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
	private String userId;
	private String password;
	private String userName;
	private String gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String[] hobby;
	private Date enrollDate;

}

