<%@page import="home.service.IHomeService"%>
<%@page import="member.service2.IMemberService2"%>
<%@page import="member.service2.MemberServiceImpl2"%>
<%@page import="home.service.HomeServiceImpl"%>
<%@page import="vo.HomeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>내 미니홈피</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style6.css">
<script src="<%=request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<% 
   //값 가져오기
   String userid = (String)session.getAttribute("userId");
   String homeId = (String)session.getAttribute("homeChk");
   String username = (String)session.getAttribute("userName");
   int userdotori = (Integer)session.getAttribute("userDotori");
   IHomeService service = HomeServiceImpl.getInstance();
   IMemberService2 service2 = MemberServiceImpl2.getInstance();
   HomeVO homeVo = service.getHomeInfo(userid);
   
   System.out.println(userid);
   
   
%>
<%
   // 로그인인 상태!!
   if(userid != null){
%>
         <h2><%=username %>님의 마이페이지</h2>
    <table>
        <tr>
          <th></th>
          <th id="th1"><br><br><br><br><br><br>
           <section class="mini-form">
         <form method="post" action="#" id="mypageForm">
            <div class="btn-area">
               <button id="btn" onclick="modify();">회원정보 수정</button>
               <input type="hidden" value = "<%=userid%>" name ="userid"/>
               <button id="btn" onclick="myProd();">구매상품 목록</button>
               <input type="hidden" value = "<%=userid%>" name ="userid"/>
               <button id="btn" onclick="pay();" type="submit">도토리 충전</button>
               <input type="hidden" value = "<%=userid%>" name ="userid"/>
            </div>
      </form>
   </section>
   </table>
<script type="text/javaScript">
function modify(){
   $('#mypageForm').attr('action',"<%=request.getContextPath()%>/modify.do").submit();
}
function myProd(){
   $('#mypageForm').attr('action',"<%=request.getContextPath()%>/viewProd.do").submit();
}
function pay(){
   $('#mypageForm').attr('action',"<%=request.getContextPath()%>/payment.do").submit();
}
</script>
<%
}else{ //로그인상태가 아닐때
%>  
<%
}   
%>
</body>
</html>