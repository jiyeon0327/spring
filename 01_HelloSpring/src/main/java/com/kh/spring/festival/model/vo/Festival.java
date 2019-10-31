package com.kh.spring.festival.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Festival {
	
	private int festival_No;
	private String festival_Content;
	private String festival_Title;
	private Date festival_Date;
	private String festival_Writer;
	private int festival_Count;
	private String festival_Pic;
	private String festival_Thumbnail;
	private String festival_StartDate;
	private String festival_EndDate;
	private String festival_Phone;
	private String festival_Homepage;
	private String festival_Address;
	private String festival_Host;
	private String festival_Sub;
	private String festival_Price;
	private String festival_Hashtag;
	private String festival_Proceeding;
	
}
