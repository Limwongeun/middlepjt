<%@page import="vo.MemberFriendVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
   
   $("#friendListBtn").on('click', function(){
      $.ajax({
         "url" : "<%=request.getContextPath()%>/allFriendList.do",
<%--          "data" : "homeChk=<%=(String)session.getAttribute("homeChk")%>", --%>
         "success" : function(data){
            
            $("#result").html(data);
         
         
          },
         "error" : function(hx){
            alert(hx.status);
         },
         "dataType" : "html"
      });
   });
   
   $('#itemMngBtn').on('click', function(){
	  $.ajax({
		  "url" : "<%=request.getContextPath()%>/itemList.do",
		  "success" : function(data){
			 
			  $("#result").html(data);
			  
		  },
		  "error" : function(hx){
			  alert(hx.status);
		  },
		  "dataType" : "html"
	  });
	   
   });
   
   $('#boardMngBtn').on('click', function(){
		  $.ajax({
			  "url" : "<%=request.getContextPath()%>/boardManager.do",
			  "success" : function(data){
				 
				  $("#result").html(data);
				  
			  },
			  "error" : function(hx){
				  alert(hx.status);
			  },
			  "dataType" : "html"
		  });
		   
	   });
   
   
});

</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Single+Day&display=swap');
body{
   font-family: 'Single Day', cursive;
}
html, body{
    width: 100%;
    height: 100%;
    margin: 0;
    background-color: white;
}

#friendListBtn, #boardMngBtn, #itemMngBtn{
   background-color :#D8D8D8;
   border:none;
   border-radius : 15px;
   padding : 10px;
   margin : 5px 10px 4px 30px;;
   text-align : center;
   font-size : 1.2em;
   text-decoration:none;
}

#friendListBtn:focus {
  background-color: orange;
  color : white;
  font-weight:bold;
}
#boardMngBtn:focus {
  background-color: orange;
  color : white;
  font-weight:bold;
}
#itemMngBtn:focus {
  background-color: orange;
  color : white;
  font-weight:bold;
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
  
   //친구 아이디값이 있으면 로그인세션값에서 받아온 
   //memId, homeId를 친구의 값으로 바꿔준다
   if(friendId!=null){
      userid = friendId;
      homeId = friendHomeId;
   }
%>
<%
   List<MemberFriendVO> memFriendList = (List<MemberFriendVO>)request.getAttribute("AllFriendList");

%>
<div style="margin: 110px 20px 5px 25px; width: 126px; border-bottom:1px solid black; font-size:2em;">Manager</div>

<form class="btn1" action="<%=request.getContextPath()%>/myMinihome/SettingMain1.jsp">
<input type="hidden" name="homeId"  value="<%=homeId %>">
<input type="button" value="일촌관리" name="friendList" id="friendListBtn" style="font-family: 'Single Day', cursive;">
</form>
<br>



<form class="btn1" action="<%=request.getContextPath()%>/myMinihome/SettingMain1.jsp">
<input type="hidden" name="homeId"  value="<%=homeId %>">
<input type="button" value="아이템관리" name="itemList" id="itemMngBtn" style="font-family: 'Single Day', cursive;">
</form>
</div>

<div id="result" style="
    position: absolute;
    height: 90%;
    width: 74%;
    top: 5%;
    left: 23%;
   /*  border : 1px solid; */
    overflow:auto;"></div>


</body>
</html>