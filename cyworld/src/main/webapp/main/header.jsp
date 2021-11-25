<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div {
   margin: 1px;
   width: auto;
   padding: 1px;
   border-radius: 10px;
   box-sizing: border-box;
   overflow: auto;
}

#header {
   background: white;
   width: auto;
   height: 40px; 
   overflow: hidden;
   text-align: right;
   
}

#liIn2 {
   display: inline;
   padding: 25px;
   text-align: center;
   font-weight:  bold;
}

</style>
</head>
<body>
<%
   //값 가져오기
   String userid = (String)session.getAttribute("userId");
   System.out.println("값 출력 : " + userid);
%>
<%
   // 로그인 못했을 때 세션에 저장하지 않는 것
   if(userid == null){
%>
      <div id="header">
         <li id="liIn2"><a href="<%=request.getContextPath()%>/login.do" target="ifr">로그인</a></li>
         <li id="liIn2"><a href="#" target="ifr">장바구니</a></li>
<!--          <li id="liIn2"><a href="/main/join.html" target="ifr">회원가입</a></li> -->
         <li id="liIn2"><a href="/main/join.jsp" target="ifr">회원가입</a></li>
      </div>
<%
   }else{
%>
      <div id="header">
         <li id="liIn2"><a href="<%=request.getContextPath()%>/logout.do" target="_top">로그아웃</a></li>
         <li id="liIn2"><a href="<%=request.getContextPath()%>/viewCart.do" target="ifr">장바구니</a></li>
         <li id="liIn2"><a href="/main/myPage.jsp" target="ifr">마이페이지</a></li>
         <li id="liIn2"><a href="/main/myMiniHome.jsp" target="ifr">내 미니홈피</a></li>
         <li id="liIn2"><a href="<%=request.getContextPath() %>/payment.do" target="ifr">도토리 충전</a></li>
      </div>
<%
   }
%>
      <script>
         $('#liIn2').click(function() {
             $("#ppap").hide();
          
         })
         </script>
</body>
</html>