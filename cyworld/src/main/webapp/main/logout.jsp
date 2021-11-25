<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그아웃 페이지</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
<script src="<%=request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<%
	//값 가져오기
	String userid = (String)session.getAttribute("userId");
	System.out.println(userid);
%>
<%
	// 로그인 못했을 때 세션에 저장하지 않는 것
	if(userid != null){
%>



	<section class="login-form">
		<h1>회원 로그아웃</h1>
		<form method="post" action="<%=request.getContextPath()%>/logout.do" target="_top">
			<div class="int-area">
				<input type="text" name="userid" id="userid" autocomplete="off" required>
				<label for="userid">USER ID</label>
			</div>
			<div class="int-area">
				<input type="password" name="pass" id="pass" autocomplete="off" required>
				<label for="pass">PASSWORD</label>
			</div>
			<div class="btn-area">
				<button id="btn" type="submit">LOGIN</button>
			</div>
		</form>
		<div class="caption">
			<a href="join.html">아직 회원이 아니신가요?</a><br>
			<a href="#">아이디 혹은 패스워드를 잃어버리셨나요?</a>
		</div>
	</section>
<%
}else{
%>  
	<%=userid %>님 반갑습니다.<br><br>
	<a href="<%=request.getContextPath()%>/main/index.jsp"></a>
<%
}	
%>
	<script>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
		let id = $('#userid');
		let pw = $('#pass');
		let btn = $('#btn');
		
		$(btn).on('click', function() {
			if($(id).val() == ""){
				$(id).next('label').addClass('warning');
				setTimeout(function(){
					$('label').removeClass('warning')
				},1500);
			}
			else if($(pw).val() == ""){
				$(pw).next('label').addClass('warning');
				setTimeout(function(){
					$('label').removeClass('warning')
				},1500);
			}
		});
	</script>
</body>
</html>