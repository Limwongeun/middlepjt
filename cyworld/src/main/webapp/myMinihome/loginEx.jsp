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
</head>
<body>
<%-- <%=request.getAttribute("userid") %> --%>

<form action="<%=request.getContextPath()%>/memInfo.do">
ID값<input type="text" id="id" name="id">
<button id="btn">전송</button>
</form>
</body>
</html>