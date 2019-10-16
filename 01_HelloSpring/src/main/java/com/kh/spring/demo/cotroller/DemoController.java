package com.kh.spring.demo.cotroller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.demo.model.service.DemoService;
import com.kh.spring.demo.model.vo.Dev;

@Controller
//@Controller : spring은 자기가 관리하는 하나의 객체를 등록, 이 역할은 controller라고 정해두는 것
//이 controller는 service를 가리켜야함 
public class DemoController {
	
	//private DemoService service =new DemoServiceImpl(); 만들지 않고
	@Autowired
	private DemoService service;//@Autowired를 써서 얘가 가동된 시점에 알아서 필요한 것들을 만듦
	
	//화면전환용 HandlerMapping 메소드 만들기
	
	//@RequestMapping("주소값 mapping");
	@RequestMapping("/demo/demo.do")
	public String demo() {
		System.out.println("/demo.demo.do가 호출됨!");
		return "demo/demo"; //  /WEB-INF/views/demo/demo.jsp와 쓴것과 동일
		
	}
	
	@RequestMapping("/demo/demo1.do")
	public String demo1(HttpServletRequest req){
		//demo.jsp에서 맵핑값이 여기로 넘어옴 
		System.out.println(req.getParameter("devName"));
		System.out.println(req.getParameter("devAge"));
		System.out.println(req.getParameter("devEmail"));
		System.out.println(req.getParameter("devGender"));
		System.out.println(req.getParameter("devLang"));
		
		//맴버변수 만든 후 생성시키기
		Dev dev=new Dev();
		dev.setDevName(req.getParameter("devName"));
		dev.setDevAge(Integer.parseInt(req.getParameter("devAge")));
		dev.setDevEmail(req.getParameter("devEmail"));
		dev.setDevGender(req.getParameter("devGender"));
		dev.setDevLang(req.getParameterValues("devLang"));
		req.setAttribute("dev", dev);
		
		return "demo/demoView";//gerrequestDispature와 비슷한 기능을 함
	}
	//@RequestParam을 이용해서 파라미터 받기
	@RequestMapping("/demo/demo2.do")
	//public String demo2(
			//RequestParam는 값을 다 받아야 함 ==required와 같음
			//그래서 값을 안받고도 넘길 수 있는 방법:
			//*@RequestParam안에 속성값을 주기(value="파라미터가 넘어가는 키값" ,required=false)를 주면 값을 안받아도 넘어감
			//공백으로 들어오면 int로 자동으로 변환 못해줌
			//그래서  int는 공백이 오면  defaultValue="19"값을 넣어주고, 값이 있으면 입력한 값을 넣어줌
			
			/*1번방법
			 * @RequestParam(value="devName") String devName,
			@RequestParam(value="devAge",required=false,defaultValue="19") int devAge,
			@RequestParam String devEmail,
			@RequestParam String devGender,
			@RequestParam(value="devLang",required=false) String[] devLang,
			HttpServletRequest req) {	*/
			/*
			 * public String demo2() { System.out.println(devName);
			 * System.out.println(devAge); System.out.println(devEmail);
			 * System.out.println(devGender); System.out.println(devLang);
			 * req.setAttribute("dev", new Dev(devName,devAge,devEmail,devGender,devLang));
			 * return "demo/demoView"; }
			 */
	
	//* @RequestParam를 제외하고 값을 입력받지 않아도 넘어가게
	//하는게 불가능
	
		//2번 방법: 대신 이렇게 쓰려면 값을 다 입력받아야함 + 맴버변수 값과 동일해야함
		//앞에 input required를 쓰기
		public String sdemo2(String devName,int devAge,String devEmail,String devGender,String[] devLang
				,HttpServletRequest req) {
		
		System.out.println(devName);
		System.out.println(devAge);
		System.out.println(devEmail);
		System.out.println(devGender);
		System.out.println(devLang);
		req.setAttribute("dev", new Dev(devName,devAge,devEmail,devGender,devLang));
		return "demo/demoView";
		}
			
		//3번째 방법
		//map객체를 이용하는 방법
		@RequestMapping("/demo/demo3.do")
		public String demo3(@RequestParam Map map,String[] devLang,HttpServletRequest req) {
			System.out.println(map);
			System.out.println(devLang[0]);
			System.out.println(devLang[1]);
			req.setAttribute("dev", map);
			return "demo/demoView";
		}
		
		//4번째방법
		//Commend객체를 이용하는 방법(Vo)
		@RequestMapping("/demo/demo4.do")
		public String demo4(Dev dev,HttpServletRequest req) {
			req.setAttribute("dev", dev);
			return "demo/demoView";
		}
		
		@RequestMapping("/demo/insertDemo.do")
		public String insertDemo(Dev dev,Model model) {
			//redirect하기!(url주소가 바뀜)    => requestdispatcher(이전작업창에서 다시 요청)의 차이점: 
			//return "redirect:/demo/demo.do";
			int result =service.insertDemo(dev);
			return "redirect:/index.jsp";//index를 webapp에서 빼놔서 이렇게 가능
		}
		
	
}
