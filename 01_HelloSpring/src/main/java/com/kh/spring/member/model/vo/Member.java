package com.kh.spring.member.model.vo;

import java.sql.Date;

import com.kh.spring.demo.model.vo.Dev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
	private String userId;
	private String password;
	private String userName;
	private char gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String[] hobby;
	private Date enrollDate;

}
