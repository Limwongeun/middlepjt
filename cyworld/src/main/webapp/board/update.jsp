<%@page import="vo.BoardVO"%>
<%@page import="board.service.BoardServiceImpl"%>
<%@page import="vo.BoardVO"%>
<%@page import="board.service.IBoardService"%>
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
<script>
$(function(){
	$('#submit').on('click', function(){
		alert('수정 완료.');
	})
})
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Single+Day&display=swap');
body, input, button{
   font-family: 'Single Day', cursive;
}
</style>
</head>
<body>
<%
BoardVO boardVo = (BoardVO)request.getAttribute("boardVo");
%>
	<div class="container">
		<div class="row">
			<h3 style="text-align: center;">게시판</h3>
			<form method="post" action="<%=request.getContextPath()%>/boardUpdate2.do">
			
			<table class="table table-striped" style="border: none;text-align : center;">
			<thead>
				<tr>
					<th colspan="3" style="background-color: #eeeeee; text-align: center;">게시판 수정</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="hidden" class="form-control" name="board_no" value="<%=boardVo.getBoard_no() %>"></td>
				</tr>
				<tr>
					<td><input type="text" class="form-control" placeholder="글 제목" name="board_title" maxlength="50" value="<%=boardVo.getBoard_title()%>"></td>
				</tr>
				<tr>
					<td><textarea class="form-control" placeholder="글 내용" name="board_text" maxlength="2048" style="height: 250px;" ><%=boardVo.getBoard_text()%></textarea></td>	
				</tr>
				
			</tbody>
			</table>
			<input type="submit" class="btn btn-primary pull-right" value="수정" id="submit">
			</form>
		</div>
	</div>
</body>
</html>