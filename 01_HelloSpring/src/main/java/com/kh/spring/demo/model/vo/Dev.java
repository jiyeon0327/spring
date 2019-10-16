package com.kh.spring.demo.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//객체 생성시에 기본적으로 생성해야하는 setter/getter를 
//생성자,toString(),hash(),equals()를 
//알아서 생성해주는 라이브러리 lombok를 사용하겠음
//cmd에서 

/*
 * @Getter
 * 
 * @NoArgsConstructor
 * 
 * @EqualAndHashCode
 * 
 * @AllArgsConstructor
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dev {
	//맴버변수 만들때 조심할것 단위별로 할것!(devName처럼)
	private String devName;
	private int devAge;
	private String devEmail;
	private String devGender;
	private String[] devLang;
	

}
