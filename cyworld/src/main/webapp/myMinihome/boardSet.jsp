<%@page import="vo.MemberVO"%>
<%@page import="vo.HomeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
html,body {
    width: 100%;
    height: 100%;
    margin: 0;
    background-color: white;
}
</style>
</head>
<body>
<%
	String userid = (String)session.getAttribute("userId");
	String homeId = (String)session.getAttribute("homeChk");
	
	//친구의 mem_id와 home_id
	String friendId = (String)session.getAttribute("friendId");
	String friendHomeId = (String)session.getAttribute("friendHomeId");
	
	HomeVO homeVo = (HomeVO)request.getAttribute("homeVo");
	MemberVO memVo =(MemberVO)request.getAttribute("memVo");
	
	//친구의 미니홈피 방문시 friendId = userid
	if(friendId!=null){
		userid = friendId;
		homeId = friendHomeId;
	}

%>

<div id="btnlist" style="position: absolute;width: 20%;height: 100%;background-color: gray;">
<form class="btn1" action="<%=request.getContextPath()%>/myMinihome/SettingMain1.jsp">
<input type="hidden" name="homeId"  value="<%=homeId %>">
<button>일촌관리</button>
</form>
<br> 

<form class="btn1" action="<%=request.getContextPath()%>/myMinihome/boardSet.jsp">
<button>게시판관리</button>
</form>
<br>

<form class="btn1" action="<%=request.getContextPath()%>/myMinihome/itemSet.jsp">
<input type="hidden" name="homeId"  value="<%=homeId %>">
<button>아이템관리</button>
</form>
</div>


<div id="friendsSet" style="
    position: absolute;
    height: 90%;
    width: 74%;
    top: 5%;
    left: 23%;
    background-color: lightblue;">게시판관리부분</div>
</body>
</html>