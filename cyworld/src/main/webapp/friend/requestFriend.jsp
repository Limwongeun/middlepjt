<%@page import="vo.FriendVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	FriendVO friendVo = (FriendVO)request.getAttribute("memId");
%>
<div style="padding: 10px; background : orange">
<div style="width: 100px; height: 400px;">

<h3> 일촌신청</h3>
<pre>보내는 이 : 김지영</pre><!-- 로그인한 사람 -->
<pre>홍길동님께 일촌을 신청합니다.</pre><br><br>

<pre>
<b>홍길동</b> 님은 김지영님의 <input type="text" id="friendName">로
<br><b>김지영</b> 님을 홍길동님의 <input type="text" id="friendName2">러<br>
일촌 맺고 싶어요

<sapn>    상대방이 동의하면 일촌이 맺어집니다.</sapn>
</pre>
<input type="reset" value="취소" id="cancle"><input type="submit" value="보내기" in="send">
</div>

</div>
</body>
</html>