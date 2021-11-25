<%@page import="vo.MemberFriendVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Single+Day&display=swap');
#div1, #searchList{
	font-family: 'Single Day', cursive;
}
img{
	width : 50px;
	height : 50px;
	border-radius : 50px;
	} 

#searchList{
/*  	float : center; */
	
}
.td1{
	border-bottom : 0.7px solid #D8D8D8;
}
#div1 {
  text-align : center;
}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

$(function(){
	$(".friendHomeBtn").on("click",function(){
		var mem_id = $(this).attr("id");
		window.open('<%=request.getContextPath()%>/friendIdSave.do?mem_id=' + mem_id, 'minihome', 'top=10, left=10, width=1100, height=650, status=no, menubar=no, toolbar=no, resizable=no,  location=no')
	}) 
})


</script>
</head>
<body>

<%
	List<MemberFriendVO> memFriendList = (List<MemberFriendVO>)request.getAttribute("SearchFriendList");
%>
<br>
<div id="div1">
<span><span style="color :#FE9A2E; font-size: 1.2em"><b><%=request.getAttribute("search_name")%></b></span>에 대한 검색결과 입니다. </span><span> <%=memFriendList.size()%> 건</span>
</div><br>

<div id="searchList">
<table style="border-collapse: collapse; margin : 0 auto 0;">

<%
if(memFriendList == null || memFriendList.size()==0){
%>

<tr><td colspan="4">검색하신 이름을 찾을 수 없습니다.</td></tr>
<%
}else{
	int cnt = 0;
	for(MemberFriendVO memList : memFriendList){
%>	

<tr>
<td class = td1 style="width:70px;height:70px;"><img src="<%=memList.getHome_pic()%>" alt ="홈피사진"></td>
<td class = td1 style="width:100px;height:70px;"><%=memList.getMem_name()%>(<%=memList.getMem_id()%>)</td>
<td class = td1 style="width:650px;height:70px;"><%=memList.getHome_text()%></td>
<td class = td1 style="width:120px;height:70px;">

<%-- <a href="<%=request.getContextPath()%>/friendIdSave.do?mem_id=<%=memList.getMem_id()%>"> --%>
<!-- <span style="border:1px solid black">미니홈피로 가기1</span></a> -->
<a href="#" class="friendHomeBtn" id="<%=memList.getMem_id()%>">
<span style="border:1px solid black; padding : 3px;">미니홈피로가기</span></a>

<%-- <form action="<%=request.getContextPath()%>/friendIdSave.do?mem_id=<%=memList.getMem_id()%>"> --%>
<!-- <input type="button" name="mem_id" id="friendHomeBtn" value="미니홈피로 가기"> -->
<!-- </form> -->
<!-- <script> -->
<!-- // $(function)({ -->
<!-- // 	$("#friendHomeBtn").on("click",function(){ -->
<%-- 		window.open('<%=request.getContextPath()%>/friendIdSave.do?mem_id=<%=memList.getMem_id()%>') --%>
<!-- // 	}) -->
<!-- // }) -->
<!-- </script> -->
<%-- <input type="button<%=cnt%>" value="미니홈피로 가기" id="minihome"> --%>
</td>
</tr>
<%
	cnt++;
	}
}

%>		


 </table>
</div>
</body>
</html>