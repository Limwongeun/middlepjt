<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.Enumeration" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>설정된 모든 세션의 키와 값을 얻어와 출력하기</title>
</head>
<body>
<center>
    <h3>[ 설정된 세션 값을 얻어오는 예제 - 2 ]</h3>
</center>
<hr/>
getAttributeNames( ) 메소드를 사용하여 세션값을 얻어오는 예제
<hr/>
<%
    String ls_validate = "현재 페이지는 물론 이전 페이지에서 설정된 세션 값을 얻어오는 예제입니다.";
    session.setAttribute("Validate", ls_validate);

    String ls_name = "";
    String ls_value = "";

    Enumeration enum_app = session.getAttributeNames();
    int i = 0;

    while(enum_app.hasMoreElements()) {
   
        i++;
        ls_name = enum_app.nextElement().toString();
        ls_value = session.getAttribute(ls_name).toString();
   
        out.println("<br/>얻어온 세션 이름 [ " + i +" ] : " + ls_name + "<br/>");
        out.println("<br/>얻어온 세션 값 [ " + i +" ] : " + ls_value + "<hr/>");
}
%>
</body>
</html>