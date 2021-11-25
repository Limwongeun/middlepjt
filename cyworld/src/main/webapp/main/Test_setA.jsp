<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String ls_test = "세션에 저장된 데이터가 바로 접니다. ^O^";
    session.setAttribute("Testing", ls_test);    // "Testing"을 키로 문자열을 저장
   
    session.setAttribute("MyData", 10);    // "MyData"를 키로 정수를 저장
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세션에 값 설정하기</title>
</head>
<body>
<center><h3>[ 세션 값을 설정하는 예제 ]</h3></center>
<hr/>
세션값을 설정하는 페이지 입니다.
<hr/>
</body>
</html>