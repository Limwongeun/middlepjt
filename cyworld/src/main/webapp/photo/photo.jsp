<%@page import="vo.PhotoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>

</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Single+Day&display=swap');
body{
   font-family: 'Single Day', cursive;
}
#deleteBtn{
	border: none;
    font-size: 14.5px;
    border-radius: 5px;
    position: absolute;
}

</style>
</head>
<body>
<%
	List<PhotoVO> boardList = (List<PhotoVO>)request.getAttribute("boardList");
%>
<div style="
    text-align: center;
    position: relative;
    left: 50px;
    display: block;
    background-color: lightgray;
    border-radius: 5px;
    width: 700px;
    height: 40px;
">
<h3 style="
    padding-top: 5px;
">사진첩</h3>
</div>
<%
   //로그인한 회원의 mem_id와 home_id
   String userid = (String)session.getAttribute("userId");
   String homeId = (String)session.getAttribute("homeChk");
   
   //친구의 mem_id와 home_id
   String friendId = (String)session.getAttribute("friendId");
   String friendHomeId = (String)session.getAttribute("friendHomeId");
  
   //친구 아이디값이 있으면 로그인세션값에서 받아온 
   //memId, homeId를 친구의 값으로 바꿔준다
   if(friendId!=null){
      userid = friendId;
      homeId = friendHomeId;
   }
%>

<%if(friendId==null){
	%>
<div style="
    display: block;
    width: 15%;
    height: %;
    position: absolute;
    height: 6%;
    background-color: white;
    border-radius: 5px;
    text-align: center;
    border: 1px solid white;
    top: 13%;
    left: 78.3%;
    font-size: 16px;
    margin-bottom: 20px;
"><a href="photoWrite.do" style="
    position: relative;
    text-decoration: none;
    top: 5px;
">사진올리기</a></div>
<%
}
%>

<%
if(boardList==null||boardList.size()==0){
%>
<h4 style="
    position: absolute;
    top: 40%;
    left: 36.5%;
">등록된 게시물이 없습니다.</h4>
<%
}else{
	for(PhotoVO vo : boardList){
%>
	<div style="
    position: relative;
    left: 52px;
    top: 50px;
    bottom: 20px;
">
	<div style="
    text-align: center;
    width: 87.5%;
    height: 40px;
    border-top: 1px solid lightgray;
    border-bottom: 1px solid lightgray;
"><h4 style="
    position: relative;
    bottom: 10px;
"><%=vo.getBoard_title() %></h4></div>
	<div style="
    height: 40px;
    font-size: 15px;
"><%=vo.getBoard_date() %>

<%if(friendId==null){
	%>
<form action="/photoDelete.do" style="
    position: absolute;
    top: 10%;
    left: 82%;
    font-family: 'Single Day', cursive;
">
<button type="submit" name="delBtn" value="<%=vo.getBoard_no() %>" id="deleteBtn">delete</button>
</form> 
</div>
<%
}
%>


	<img src="<%=vo.getBoard_photo() %>" style="
    height: 384px;
    width: 695px;
">
	<div style="
    width: 694px;
    margin-top: 15px;
    margin-bottom: 150px;
"><%=vo.getBoard_text() %></div>
	</div>
	

<%		
	}
	
}
%>

</body>
</html>