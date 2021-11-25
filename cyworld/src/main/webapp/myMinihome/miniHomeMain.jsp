<%@page import="vo.StoryRoomVO"%>
<%@page import="storyroom.service.StoryServiceImpl"%>
<%@page import="storyroom.service.IStoryService"%>
<%@page import="vo.MemberVO"%>
<%@page import="vo.HomeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Single+Day&display=swap" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Single+Day&display=swap');
body{
	font-family: 'Single Day', cursive;
}
#text{
	border: 1px solid;
	width: 100px;
	height: 120px;
}
html,body {  <!-- 컨텐츠  전체 -->
    width: 100%;
    height: 100%;
    margin: 0;
    font-family: 'Single Day', cursive;
}
#backgr{
	margin: 0;
	width: 100%;
    height: 100%;
/* 	background-color: lightgray;  <!-- 컨텐츠 밖 배경화면.스킨 설정부분-->	 */
	/* background-image : url("../images/homeMain_img.png"); */
}

#frame{
	display: inline;
}
#list{
	position: absolute;
	top: 65px;
    left: 90%;
}
#div{
	position: absolute;
    top: 10%;
    left: 80%;
}
#category{
position: absolute;
    top: 10%;
    left: 78.7%;
    width: 6%;
    height: 30%;
    
}
#cg1{
margin-bottom: 10%;
background-color: #FE9A2E;
height: 15%;
border-radius: 0px 5px 5px 0px;

}
#cg2{
margin-bottom: 10%;
background-color: white;
height: 15%;
border-radius: 0px 5px 5px 0px;


}
#cg3{
margin-bottom: 10%;
background-color: white;
height: 15%;
border-radius: 0px 5px 5px 0px;


}
#cg4{
margin-bottom: 10%;
background-color: white;
height: 15%;
border-radius: 0px 5px 5px 0px;


}
#cg5{
margin-bottom: 10%;
background-color: white;
height: 15%;
border-radius: 0px 5px 5px 0px;


}
#c1{
text-decoration: none;
color: white;
}
#c2{
text-decoration: none;
}
#c3{
text-decoration: none;
}
#c4{
text-decoration: none;
}
#c5{
text-decoration: none;
}


</style>
<%
	//로그인한 회원의 mem_id와 home_id
	String userid = (String)session.getAttribute("userId");
	String homeId = (String)session.getAttribute("homeChk");
%>
</head>
<body onbeforeunload="closeIt()"><!-- window가 닫힐때 감지하는 function -->

<!-- <div id="container"> -->
<%
	//로그인한 회원의 mem_id와 home_id
	
	//친구의 mem_id와 home_id
	String friendId = (String)session.getAttribute("friendId");
	String friendHomeId = (String)session.getAttribute("friendHomeId");
	

	HomeVO homeVo = (HomeVO)request.getAttribute("homeVo");
	MemberVO memVo =(MemberVO)request.getAttribute("memVo");
	
	//친구의 미니홈피 방문시 friendId = userid
	if(friendId!=null){
		userid = friendId;
		homeId = friendHomeId;
	}
%>

<%
IStoryService service= StoryServiceImpl.getInstance();
StoryRoomVO storyVo = service.getSkinImg(homeId);


%>
<div id="backgr" style="background-image: url('<%=storyVo.getProd_url() %>');">

<%-- <div id="header">
방문자수 | <%=homeVo.getHome_count() %>
 

<%=memVo.getMem_name() %>님의 미니홈피<br>
</div>

프로필 소개글 <br>
<div id="text">
<%=homeVo.getHome_text() %>

</div>
<button id="textEdit">edit</button> --%>

<!-- 일촌신청 버튼. 타인의 홈페이지에 들어갈때만 보여야함. -->
<!-- <button type="button" value="일촌신청" name="insert_friend" id="insertFrinedBtn">일촌신청</button> -->



<div style="position:absolute; width:75%; height:85%; top:50px; left:40px; display: block; border-radius: 10px;">

<iframe id="frame" src="<%=request.getContextPath()%>/myMinihome/miniHomeContents.jsp"
width="100%" height="100%" scrolling="no" frameborder="0" style="border-radius : 10px">
 </iframe>
 </div>
 
<!--버튼 추후 수정-->
<div id="category" style="text-align:center">
<div id="cg1"><a id="c1" href = "/myMinihome/miniHomeMain.jsp">홈</a></div>
<div id="cg2"><a id="c2" href = "/myMinihome/boardMain.jsp">게시판</a><br></div>
<div id="cg3"><a id="c3" href = "/myMinihome/photoMain.jsp">사진첩</a><br></div>
<div id="cg4"><a id="c4" href = "/myMinihome/guestMain.jsp">방명록</a><br></div>
<% if(friendId==null){
	
%>
<div id="cg5"><a id="c5" href = "/myMinihome/SettingMain.jsp">관리</a>
<%
}
%>
</div>

</div>
</body>
</html>