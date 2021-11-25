<%@page import="vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Single+Day&display=swap');
body, input, button{
   font-family: 'Single Day', cursive;
}
.container{
	overflow: auto;
}
.btn-primary {
    color: black;
    background-color: lightgray;
    border-color: white;
}
</style>
</head>
<body>

<%

	List<BoardVO> boardList = (List<BoardVO>)request.getAttribute("boardList");
%>

<%

String userid = (String)session.getAttribute("userId");
String homeId = (String)session.getAttribute("homeChk");

//친구의 mem_id와 home_id
String friendId = (String)session.getAttribute("friendId");
String friendHomeId = (String)session.getAttribute("friendHomeId");


//친구의 미니홈피 방문시 friendId = userid
if(friendId!=null){
   userid = friendId;
   homeId = friendHomeId;
}

%>
	<div class="container">
		<div class="row">
			<h3 style="text-align: center; background-color: #D8D8D8; border-radius: 8px; height: 35px; ">게시판</h3>
			
			
			<%if(friendId==null){
	%>
			<a href="boardWrite.do" class="btn btn-primary pull-right" style="color: black; background-color: lightgray; border-color: white;">게시물올리기</a>
			<%
			}
			%>
			
			
			
			
			<table class="table table-striped" style="border: none;text-align : center;">
			<thead>
				<tr>
					<th style="background-color: #eeeeee; text-align: center;">번호</th>
					<th style="background-color: #eeeeee; text-align: center;">제목</th>
		<!-- 			<th style="background-color: #eeeeee; text-align: center;">작성자</th> -->
					<th style="background-color: #eeeeee; text-align: center;">작성일</th>
				</tr>
			</thead>
<%
if(boardList==null || boardList.size()==0){
%>	
				<tr><td colspan="4">등록된 게시물이 없습니다.</td></tr>	
<%
}else{
	for(BoardVO vo : boardList){
%>				
			
			<tbody>
				<tr>
					<td><a href="<%=request.getContextPath()%>/boardNo.do?board_no=<%=vo.getBoard_no() %>"><%=vo.getBoard_no() %></a></td>
					<td><%=vo.getBoard_title() %></td>
				<%-- 	<td><%=vo.getBoard_writer() %></td> --%>
					<td><%=vo.getBoard_date() %></td>
				</tr>
			</tbody>
<%
	}
}
%>
			</table>
		</div>
	</div>
</body>
</html>