package com.kh.spring.memo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.memo.model.service.MemoService;
import com.kh.spring.memo.model.vo.Memo;

@Controller
public class MemoController {
	
	@Autowired
	private MemoService service;

	
	@RequestMapping("/memo/insertMemo.do")
	private String insertMemo(Memo memo, Model model) {
		int result=service.insertMemo(memo);
		
		String msg="";
		String loc="/memo/memo.do"; //메모목록화면으로 이동
		//String msg=result>0?"입력성공":"입력실패";
		
		
		if(result>0) {
			msg="등록 성공";
		}else {
			msg="등록 실패";
		}
		
		model.addAttribute("msg",msg);
		model.addAttribute("loc",loc);
		
		return "common/msg";
	}
	
	@RequestMapping("/memo/memo.do")
	private String MemoEnd(Model model) {
		List<Memo> list=service.selectMemoList();
		model.addAttribute("list",list);
		
		//model.addAttribute("list",service.selectMemoList()); //이렇게 한줄로 줄여서도 가능
		
		return "memo/memo";
	}
	
	

}
