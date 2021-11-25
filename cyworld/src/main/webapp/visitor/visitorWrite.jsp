<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String homechk = (String)session.getAttribute("homeChk");
String userid = (String)session.getAttribute("userId");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<div class="row">
			<h3 style="text-align: center;">방명록</h3>
			<form method="post" action="<%=request.getContextPath()%>/visitorWrite.do">
			<table class="table table-striped" style="text-align : center;" border="1px solid #dddddd">
			<thead>
				<tr>
					<th colspan="3" style="background-color: #eeeeee; text-align: center;">방명록 글쓰기</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="hidden" class="form-control" placeholder="방명록번호" name="visitor_no" maxlength="50"></td>
				</tr>
				<tr>
					<td><input type="text" class="form-control" placeholder="회원아이디" name="mem_id" value="<%=session.getAttribute("userId")%>" readonly></td>
				</tr>
				<tr>
					<td><input type="hidden" class="form-control" placeholder="홈피코드" name="home_id" value="<%=session.getAttribute("friendHomeId")%>"></td>
				</tr>
				<tr>
					<td><input type="hidden" class="form-control" placeholder="방명록작성날짜" name="visitor_date"></td>
				</tr>
				<tr>
					<td><textarea class="form-control" placeholder="방명록내용" name="visitor_text" maxlength="2048" style="height: 230px;"></textarea></td>	
				</tr>
				<tr>
					<td><input type="hidden" class="form-control" placeholder="방명록공개설정" name="visitor_set"></td>
				</tr>
			</tbody>
			</table>
			<div style="margin-left: 40%;">
			<input type="submit" class="btn btn-primary" value="방명록 남기기" id="submit">
			<a href="<%=request.getContextPath() %>/visitorList.do" class="btn btn-primary">뒤로가기</a>
			</div>
			</form>
		</div>
	</div>
</body>
</html>