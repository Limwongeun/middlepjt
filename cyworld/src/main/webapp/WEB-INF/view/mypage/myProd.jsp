<%@page import="vo.MypageVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style5.css">
</head>
<body>
<%
	session.getAttribute("userId");
	List<MypageVO> list = (List<MypageVO>)request.getAttribute("myProd");
%>
<table style="margin-left: auto; margin-right: auto;">
<tr>
	<td colspan="4" style="text-align: center;"><br><h2>구매 상품 목록</h2><br></td>
</tr>
<tr>
<%
if(list == null || list.size() == 0){
%>
<td colspan="4">구매하신 상품이 없습니다.</td></tr>
<%
} else {
	for(int i=0; i<list.size(); i++){
%>
<%
		if(i % 4 == 3){
%>
		<form>
			<td><img src="<%=list.get(i).getProd_url()%>" height="200px" width="300px"><br>
				<%=list.get(i).getProd_name() %><br>
				<br>
				</td>
		</form>
	</tr><tr>
<%
		} else {
%>
		<form>
		<td><img src="<%=list.get(i).getProd_url()%>" height="200px" width="300px"><br>
			<%=list.get(i).getProd_name() %><br>
			<br>
			</td>
		</form>
<%			
		}
	}
%>
</tr>
<%
}
%>
</table>
</body>
</html>