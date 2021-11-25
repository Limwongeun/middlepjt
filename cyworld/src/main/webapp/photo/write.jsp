<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String homechk = (String)session.getAttribute("homeChk");
String userid = (String)session.getAttribute("userId");
%>
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
		alert('등록이 완료되었습니다.');
	})
})
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Single+Day&display=swap');
body{
   font-family: 'Single Day', cursive;
}
.container{
	width : 90%;
	height : 70%;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row" style="
    position: absolute;
    top: 5%;
    width: 90%;
">
			<form method="post" action="<%=request.getContextPath()%>/photoWrite.do" enctype="multipart/form-data">
			<table class="table table-striped" style="text-align : center;" border="1px solid #dddddd">
			<thead>
				<tr>
					<th colspan="3" style="background-color: #eeeeee; text-align: center;">사진첩 글쓰기</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="hidden" class="form-control" placeholder="게시판 번호" name="board_no" maxlength="50"/></td>
				</tr>
				<tr>
					<td><input type="text" class="form-control" placeholder="작성자" name="board_writer" value="<%=session.getAttribute("userId")%>" readonly/></td>
				</tr>
				<tr>
					<td><input type="hidden" class="form-control" placeholder="홈피코드" name="home_id" value="<%=session.getAttribute("homeChk")%>"/></td>
				</tr>
				<tr>
					<td><input type="text" class="form-control" placeholder="글 제목" name="board_title" maxlength="50"/></td>
				</tr>
				<tr>
					<td><input type="file" class="form-control" id="uploadBtn" name="uploadfile" value="사진업로드"/></td>
				</tr>
				<tr>
					<td><textarea class="form-control" placeholder="글 내용" name="board_text" maxlength="2048" style="height: 230px;"/></textarea></td>	
				</tr>
				<tr>
					<td><input type="hidden" class="form-control" placeholder="날짜" name="board_date" maxlength="50"/></td>
				</tr>


			</tbody>
			</table>
			<div style="margin-left: 40%;">
			<input type="submit" class="btn btn-primary" value="글쓰기" id="submit">
			<a href="<%=request.getContextPath() %>/photoList.do" class="btn btn-primary">뒤로가기</a>
			</div>
			</form>
		</div>
	</div>
</body>
</html>