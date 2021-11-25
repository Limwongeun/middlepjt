<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
</script>
<%
	String userid = (String)session.getAttribute("userId");
	String homeId = (String)session.getAttribute("homeChk");

%>
<%
	String id = request.getParameter("id");
%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#linkToMini").on("click",function(){
		window.open('<%=request.getContextPath()%>/miniHomeMain.do?id=<%=id%>', 'pop01', 'top=10, left=10, width=1100, height=650, status=no, menubar=no, toolbar=no, resizable=no,  location=no');

	
	})
});
</script>
</head>
<body>


<%
	MemberVO memVo = (MemberVO)request.getAttribute("memVo");	
%>
<%=memVo.getMem_name() %>님 환영합니다.<br>
보유도토리:<%=memVo.getMem_dotori() %>
<br>
<form action="<%=request.getContextPath()%>/miniHomeMain.do">
<input type="hidden" id="id" name="id" value="<%=id %>">

<button type="button" id="linkToMini" >나의 미니홈피</button>
</form>

</body>
</html>