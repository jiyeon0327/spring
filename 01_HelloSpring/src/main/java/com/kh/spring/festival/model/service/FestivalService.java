package com.kh.spring.festival.model.service;

import java.util.List;

import com.kh.spring.festival.model.vo.Festival;

public interface FestivalService {

	int insertFestival(Festival festival);

	List<Festival> selectFestivalList();

	Festival selectFestival(int festival_No);

	Festival deleteFestival(String festival_Writer);



}
