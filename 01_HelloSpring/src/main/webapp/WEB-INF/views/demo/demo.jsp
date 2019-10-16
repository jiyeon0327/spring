<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="pageTitle" value="DemoTest"/>
</jsp:include>

<style>
	div#demo-container{
		width:40%;
		padding:15px;
		margin:0 auto;
		border:1px solid lightgray;
		border-radius : 10px;
	}
</style>
<section id="content">
<div id="demo-container">
	<h3>파라미터 테스트</h3>
	<!--  spring이 파라미터 를 어떻게 받을건지?
	스프링이 기본적으로 parameter값을 받는 방법
		- 메소드에 매개변수를 선언하면 spring이 알아서 그 값을 넣어줌!		
		- 매개변수로 들어갈수 있는 값
		 :HttpServletRequest/HttpServletResponse (do get/do post와 같음)
		  HttpSession
		  @RequestParam 자료형 변수명 ->input의 name속성과 동일한 명칭대입 자동대입
		  *[자료형 변수명] 이렇게 생략가능하다
		 Map -> 넘어오는 key:value형식의 값을 전체 보관
		 Model -> 데이터를 보관하는 기능을 하는 변수 (requestScope)
		 Commend -> vo객체 맴버변수명과 input의 name값이 일치하면 객체의 맴버변수에 자동대입
		 ---------------여기까지가 제일 잘 쓰게 됨 ---------------------------------
		 -----------------------------------------------------------------
		 @PathVarivable -> url:localhost:9090/member/memberEnrollEnd.do/1 :1번을 조회하란 뜻
		  	=>mapping("/member/memberEnrollEnd.do/{name}")이런식으로 해서 {name}을 갖고옴
		 @RequestHeader -> header값을 가져올 때
		 @CookieValue -> cookie
		 
		 @RequestBody -> ajax통신할 때 사용 *with jackson
		 SessionStatus -> session관리
		  
	   -->
	   
		<form id="devFrm">
			<div class="form-group row">
				<label for="devName" class="col-sm-2 col-form-label">이름</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="devName" name="devName"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="devAge" class="col-sm-2 col-form-label">나이</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="devAge" name="devAge"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="devEmail" class="col-sm-2 col-form-label">이메일</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="devEmail" name="devEmail"/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">성별</label>
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="devGender"
						id="devGender0" value="M"/>
						<label class="form-check-label" for="devGender0">남</label>
						<input class="form-check-input" type="radio" name="devGender"
						id="devGender1" value="F"/>
						<label class="form-check-label" for="devGender1">여</label>
					</div>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">개발언어</label>
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" name="devLang"
						id="devLang0" value="Java"/>
						<label class="form-check-label" for="devLang0">Java</label>
					</div>	
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" name="devLang"
						id="devLang1" value="C"/>
						<label class="form-check-label" for="devLang1">C</label>
					</div>	
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" name="devLang"
						id="devLang2" value="Javascript"/>
						<label class="form-check-label" for="devLang2">Javascript</label>
					</div>
				</div>
			</div>
			<div class="list-group">
				<button type="button" onclick="demo1('${path}/demo/demo1.do');" class="list-group-item list-group-item-action">
					HttpServletRequest로 파라미터 받기
				</button>
				<button type="button" onclick="demo1('${path}/demo/demo2.do');" class="list-group-item list-group -item-action">
					@RequestParam이용하여 파라미터 받기
				</button>
				<button type="button" onclick="demo1('${path}/demo/demo3.do');" class="list-group-item list-group -item-action">
					@RequestParam이용하여 Map객체 이용해서 받기
				</button>
				<button type="button" onclick="demo1('${path}/demo/demo4.do');" class="list-group-item list-group -item-action">
					Commend객체 이용해서 받기(Vo)
				</button>
				<button type="button" onclick="demo1('${path}/demo/insertDemo.do');" class="list-group-item list-group -item-action">
					dev입력하기(insert)
					<!-- db에 테이블 만들기 ,환경설정하기-sqlSessionTemplates  -->
				</button>
			</div>
		</form>
	</div>

</section>
	<script>
		function demo1(url){
			$("#devFrm").attr("action",url);
			/* controller에서  /demo/demo1.do를 맵핑되는 것 만들기 */
			$("#devFrm").submit();
		}
		function demo2(){
			$("#devFrm").attr("action",url);
			$("#devFrm").submit();
		}
		
	</script>
	
	
	

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

