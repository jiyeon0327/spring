package com.kh.spring.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.spring.LoggerTest;
import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;


//로그흔적:오류를 더 찾기 편하기 위해 파일로 남김
//로그흔적에 따라 레벨이 있어 

@SessionAttributes(value= {"loginMember","msg"})
//이렇게 배열값으로 쓸수도 있다 {"key":"value"}
@Controller
public class MemberController {
	private static Logger logger =LoggerFactory.getLogger(LoggerTest.class);
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	@Autowired
	private MemberService service;
	
	//spring container가 알아서 해당하는 객체를 생성해서 활용해
	//범위:springBean중에서!!!!!!!!!!!!!!!!!!!!
	
	@RequestMapping("/member/memberEnroll.do")
	public String memberEnroll() {
		//페이지 전환용
		//System.out.println("/member.member.do가 호출됨");
		return "member/memberEnroll";//xml에 등록된 resolver로 거쳐서 감=>view찾아감
	}

	@RequestMapping("/member/memberEnrollEnd.do")
	public String memberEnrollEnd(Member m, Model model) {
		//1.파라미터
			//1)request.getParamter();
			//2)vo객체로 받는것
			//3)Map객체로 받는 것
			//4)@RequestParam이용,변수명,name값 매칭시켜 선언!@requestparam(value="getName" ,required=true/false,defaultValue="19")String devName		//2.파라미터 DB저장요청!
			//controller -> service -> dao 
		//             (interface)   (interface)
		//비밀번호를 암호화 해보자!
		//->위에 @Autowired선언
		m.setPassword(pwEncoder.encode(m.getPassword()));//자동으로 인코드한 값으로 출력
		logger.debug(m.getPassword());
		//System.out.println(m.getPassword());
		//결과:$2a$10$f8.xr4RKyWFSnyWvr6CRquKL2qavSHRDPMHmL55faBThFOi2ij.yC
		//알고리즘과 특수한 구분자를 넣어둠 +필요없는 아무내용+실질적인 값
		//암호비교하는 메소드를 제공해줌 ->매개변수를 비교할 값. 해서 true/false 해줌
		
		
		
		int result=service.insertMember(m);
		
		//Spring-loaded 이용해서 서버 끄지 않고 자동으로 load되게 하는 법
		//단, 이미 있는 메소드 변경의 한에서(url맵핑값, 어노테이션 수정할때는 불가능!!! 단순한 코드수정만 가능)
		//pom.xml에 등록 ->spring-loaded 라이브러리 등록 ->server설정하기
		//System.out.println(result);//확인용
		//msg.jsp이용하여 처리해보자
		String msg="";
		String loc="/";
		if(result>0) {
			msg="회원가입완료!";
		}else {
			msg="회원가입실패!";
		}
		//model은 request.~~와 같은 기능!
		model.addAttribute("msg",msg);
		model.addAttribute("loc",loc);
		
		
		//가입이 끝나면??그냥 view로 연결하면 
		//return "redirect:/";//redirect(페이지 재요청)방식으로 메인화면으로 이동
		return "common/msg";//msg를 거쳐서 redirect할것
	}

	/*
	 * //로그인
	 * 
	 * @RequestMapping("/member/memberLogin.do") public String login(Member m,Model
	 * model,HttpSession session) { //HttpSession session =req.getSession();
	 * 
	 * Member result=service.selectMemberOne(m);
	 * 
	 * //이 아래는 불가능~비밀번호 encoder 값이 달라지니까 다 false나옴
	 * //if(m.getPassword().equals(result.getPassword())) {}
	 * //if(pwEncoder.encode(m.getPassword()).equals(result.getPassword())) {}
	 * 
	 * String msg=""; String loc="";
	 * 
	 * if(result!=null) {
	 * if(pwEncoder.matches(m.getPassword(),result.getPassword())) { //matches(앞에가
	 * 사용자 입력받는 것, 뒤에가 DB) msg="로그인 성공!"; //로그인 가져오려면 //HttpSession을 매개변수에써주기 //값
	 * 받기???????????????????????????????????????????????????????????????????????????
	 * ???? session.setAttribute("loginMember", result); }else { msg="비밀번호가 틀렸습니다.";
	 * } } else { msg="로그인 실패,다시 시도하세요!"; }
	 * 
	 * model.addAttribute("msg",msg); model.addAttribute("loc",loc);
	 * 
	 * 
	 * 
	 * 
	 * return "common/msg";
	 * 
	 * }
	 * 
	 * @RequestMapping("/member/memberLogout.do") public String logout(HttpSession
	 * session) { session.invalidate(); return "redirect:/"; }
	 */
	//로그인
		@RequestMapping("/member/memberLogin.do")
		public String login(Member m,Model model) {
			//HttpSession session =req.getSession();
			
			Member result=service.selectMemberOne(m);
			
			//이 아래는 불가능~비밀번호 encoder 값이 달라지니까 다 false나옴
			//if(m.getPassword().equals(result.getPassword())) {}
			//if(pwEncoder.encode(m.getPassword()).equals(result.getPassword())) {}
			
			String msg="";
			String loc="";
			
			if(result!=null) {
				if(pwEncoder.matches(m.getPassword(),result.getPassword())) {
					//matches(앞에가 사용자 입력받는 것, 뒤에가 DB)
					msg="로그인 성공!";
					//로그인 가져오려면
					//HttpSession을 매개변수에써주기
					//값 받기???????????????????????????????????????????????????????????????????????????????
						//session.setAttribute("loginMember", result);
					//request는 페이지주소가 바뀔때마다 새로운 request가 됨 .session은 다른페이지로 가도 
					//서버 안에서 유지가 됨,브라우저 하나로!그래서 session하나에다가 값을 저장을 하면
					//다른페이지에서도 불러 올 수 있음
					logger.debug(result.toString());
					model.addAttribute("loginMember",result);
					//페이지 새요청을 해서 안됨, 로그인 성공만 되고
					//그래서 @SessionAttributes("loginMember")라고 위에 선언해주면 가능!!!!!!!model하나로 처리가능!
					//근데 이걸로 하면 logout하지를 못해!logout부분에서 SessionStatus상태를 확인하고 completed가 되지 않았으면 로그아웃 처리시키기
					
				}else
				{
					msg="비밀번호가 틀렸습니다.";
				}
			}
			else {
					msg="로그인 실패,다시 시도하세요!";
			}
			
			model.addAttribute("msg",msg);
			model.addAttribute("loc",loc);
			
		
			return "common/msg";
			
		}
		@RequestMapping("/member/memberLogout.do")
		public String logout(HttpSession session,SessionStatus s) {
			//SessionStatus:세션 상태를  확인해주기
			
			if(!s.isComplete()) {
				//세션 종료했는지 확인하는 것
				s.setComplete();//로그아웃해준다! =>SessionAttributes에 있는 걸
				session.invalidate();
			}
			return "redirect:/";
		
		}
		
	
}
