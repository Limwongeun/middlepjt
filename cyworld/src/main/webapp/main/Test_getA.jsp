<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세션에 저장된 값 얻어오기</title>
</head>
<body>
<center><h3>[ 세션에 값을 얻어오는 예제 ]</h3></center>
<hr/>
얻어온 세션값은 다음과 같습니다.
<hr/>
<%
    Object lobj_getdata = session.getAttribute("Testing");
    String ls_getdata = (String)lobj_getdata;
   
    int li_primitive = (Integer)session.getAttribute("MyData");
   
    out.println("설정된 세션값 [1] → " + ls_getdata + "<br/><br/>");
    out.println("설정된 세션값 [2] → " + li_primitive + "<hr/>");
%>
</body>
</html>
