<%@page import="vo.MemberFriendVO"%>
<%@page import="java.util.List"%>
<%@page import="java.io.Console"%>
<%@page import="friend.service.FriendServiceImpl"%>
<%@page import="friend.service.IFriendService"%>
<%@page import="vo.HomeVO"%>
<%@page import="vo.MemberVO"%>
<%@page import="vo.FriendVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Single+Day&display=swap');
body, span, pre{
   font-family: 'Single Day', cursive;
}
h3{
	positon : absolute;
	left : 40px;
}
table{
/*  	border : 1px solid black; */
	width : 380px;
}
img{
	width : 130px;
	height : 130px;
}
#td_img{
	width : 150px;
}
.name{
	color : orange;
	font-size : 1.13em;
}

</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
// $(function(){
	
// 	$("#send").on('click',function(){
		
// 		window.close();
// 	});
// });

</script>
</head>
<body bgcolor="orange">
<%
	String userId = (String)session.getAttribute("userId");
	String friendId = (String)session.getAttribute("friendId");

	IFriendService service = FriendServiceImpl.getInstance();

	//친구id, 내id값 받아서 이름저장하기
	List<MemberFriendVO> userInfo = service.memberInfo(userId);
	List<MemberFriendVO> friendInfo = service.memberInfo(friendId);
	 
	String userName1 = "";
	String friendName1 = "";
	for(MemberFriendVO userName : userInfo){
		userName1 = userName.getMem_name();
	}
	
	for(MemberFriendVO friendName : friendInfo){
		friendName1 = friendName.getMem_name();
	}
%>

<!-- <div style="background-color : #FACC2E;"> -->

<div style="width : 385px; height: 450px; margin : 0px; padding : 8px; background-color:white">
<form id="chonForm" action="<%=request.getContextPath()%>/friendRequest.do">
<h3>♡일촌맺어요♡</h3>
<pre>보내는이:<%=userName1 %> </pre>
<table>
	<tr>
		<td id="td_img"><img src="../minimi/test12.gif" alt="미니미"></td>
		<td><%=friendName1%>님께<br> 일촌을 신청합니다</td>
	</tr>
</table>
<pre><span class="name"><b><%=userName1 %></b></span>님은 <span class="name"><b><%=friendName1%></b></span>의 <input type="text" size =10 id="myName" name="myName">으로<br>
<span class="name"><b><%=friendName1%></b></span>님을 <span class="name"><b><%=userName1 %></b></span>님의 <input type="text" size =10 id="friendName" name="friendName">으로<br>
일촌 맺고 싶어요~♡</pre><hr>

<pre>상대방이 동의하면 일촌이 맺어집니다.</pre>

<input type="submit" value="보내기" id="send">
<input type="reset" value="취소" id="cancle">
</form>
</div>

</body>
</html>