<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.StoryRoomVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이템관리</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$('.minimiClass').on('click', function(){
		var prodId = $(this).attr('id');
		
		$.ajax({
			url : '/changeMinimi.do',
			data : {'prod_id' : prodId},
			success : function (res) {
				alert("미니미가 변경되었습니다.");
			},
			error : function(xhr){
				alert("미니미가 변경되었습니다.");
				
			},
			dataType : 'json'
		
		})
	});
	
	
	$('.skinClass').on('click', function(){
		var prodId = $(this).attr('id');
		$.ajax({
			url : '/changeSkin.do',
			data : {'prod_id' : prodId},
			success : function (res) {
				alert("미니홈피 스킨이 변경되었습니다.");
			},
			error : function(xhr){
				alert("미니홈피 스킨이 변경되었습니다.");
				
			},
			dataType : 'json'
		
		})
	});
	
	
	$('.roomClass').on('click', function(){
		var prodId = $(this).attr('id');
		$.ajax({
			url : '/changeRoom.do',
			data : {'prod_id' : prodId},
			success : function (res) {
				alert("스토리룸이 변경되었습니다.");
			},
			error : function(xhr){
				alert("스토리룸이 변경되었습니다.");
				
			},
			dataType : 'json'
		
		})
	});
	
	
	$('.mp3Class').on('click', function(){
		var prodId = $(this).attr('id');
		$.ajax({
			url : '/changeMp3.do',
			data : {'prod_id' : prodId},
			success : function (res) {
				alert("BGM이 변경되었습니다.");
			},
			error : function(xhr){
				alert("BGM이 변경되었습니다.");
				
			},
			dataType : 'json'
		
		})
	});
	
	
	
	
});

</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Single+Day&display=swap');
body{
	font-family: 'Single Day', cursive;
}

#minimiImg{
    display: inline;
    height: 100px;
}
html,body {
    width: 100%;
    height: 100%;
    margin: 0;
    background-color: white;
}
</style>
</head>
<body>
<%
	//로그인한 회원의 mem_id와 home_id
	String userid = (String)session.getAttribute("userId");
	String homeId = (String)session.getAttribute("homeChk");
	//친구의 mem_id와 home_id
	String friendId = (String)session.getAttribute("friendId");
	String friendHomeId = (String)session.getAttribute("friendHomeId");
	
%> 

<%
	List<StoryRoomVO> minimiList = (List<StoryRoomVO>)request.getAttribute("minimiList");
	List<StoryRoomVO> skinList = (List<StoryRoomVO>)request.getAttribute("skinList");
	List<StoryRoomVO> storyroomList = (List<StoryRoomVO>)request.getAttribute("storyroomList");
	List<StoryRoomVO> bgmList = (List<StoryRoomVO>)request.getAttribute("bgmList");
%>
<div style="font-size: 25px; padding: 10px;">나의 미니미</div>
<table style="padding: 10px;">

<%
if(minimiList ==null||minimiList.size()==0){
%>
<tr><td>구매한 미니미가 없습니다.</td></tr>
<%
}else{
	for(int i=0; i<minimiList.size(); i++){
%>

	<form id="form1">
	<td style=" padding: 30px;">
	<img src="<%=minimiList.get(i).getProd_url() %>"
	height="150px" width="150px"  style="padding-bottom: 15px;"><br>

	<input type="button" id="<%=minimiList.get(i).getProd_id() %>"  value="OK" class="minimiClass" style="position: relative; left: 17%;">
	</td>
	</form>
	

<%
	}
}
%>
</table>
<hr style="width: 100%;">





<div style="font-size: 25px; padding: 10px;">나의 스킨</div>
<table style="padding: 10px;">
<%
if(skinList ==null||skinList.size()==0){
%>
<tr><td>구매한 스킨이 없습니다.</td></tr>
<%
}else{
	for(int i=0; i<skinList.size(); i++){
		
%>
	<form>
		<td style=" padding: 30px;">
		<img src="<%=skinList.get(i).getProd_url() %>"
		height="150px" width="210px" style="padding-bottom: 15px;"><br>
 		<input type="button" id="<%=skinList.get(i).getProd_id()%>"
		value="OK" class="skinClass" style="position: relative; margin-top: 10px; margin-left: 40%;">
		</td>
	</form>

<%

	}
}

%>
</table>
<hr style="width: 100%;">


<div style="font-size: 25px; padding: 10px;">나의 스토리룸</div>
<table style="padding: 10px;">
<%
if(storyroomList ==null||storyroomList.size()==0){
%>
<tr><td>구매한 스토리룸이 없습니다.</td></tr>
<%
}else{
	for(int i=0; i<storyroomList.size(); i++){
		
%>
	<form>
		<td style="padding: 30px;">
		<img src="<%=storyroomList.get(i).getProd_url() %>"
		height="150px" width="210px" style="padding-bottom: 15px;"><br>
		<input type="button" id="<%=storyroomList.get(i).getProd_id()%>"
		value="OK" class="roomClass" style="position: relative;left: 37%;">
		</td>
	</form>

<%

	}
}

%>
</table>
<hr style="width: 100%;">


<div style="font-size: 25px; padding: 10px;">나의 배경음악</div>
<table style="padding: 10px;">
<%
if(bgmList ==null||bgmList.size()==0){
%>
<tr><td style="padding: 30px;">구매한 배경음악이 없습니다.</td></tr>
<%
}else{
	for(int i=0; i<bgmList.size(); i++){
%>
<form>
<tr><td style="padding: 30px;"><p style="display: inline;">
<%=bgmList.get(i).getProd_url() %></p>
<input type="button" id="<%=bgmList.get(i).getProd_id() %>" value="OK"
class="mp3Class"></td></tr>
</form>

<%

	}
}

%>

</table>




</body>

</html>