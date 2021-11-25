<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
	<%@page import="vo.FriendVO"%>
<%@page import="vo.MemberFriendVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
//일촌끊기를 눌렀을 때 실행되는 function
// $(function(){
//    $("#deleteFriend").on('click',function(){
      
//       var result = confirm("일촌관계를 정말 끊으시겠습니까?")
       
//       if(result){
<%--          $("#friendForm").attr("action","<%=request.getContextPath()%>/friendDelete.do"); --%>
//          $("#friendForm").submit();

//           alert("일촌 목록에서 삭제되었습니다.");
//       }
     
//    });
   
// });

function fn_submit(vara){
   $.ajax({
      "url" : "<%=request.getContextPath()%>/friendDelete.do",
      "data" : "mem_id=" + vara,
      "success" : function(data){
         
         $("#result").html(data);
          alert("일촌 목록에서 삭제되었습니다.");
         },
      "error" : function(hx){
         alert(hx.status);
      },
      "dataType" : "html"
   });
   
}


  $(function(){
	  $(".accept").on('click',function(){
		  var id = $(this).attr("id");
// 		  alert(id);
		  
		  $.ajax({
			  "url" : "<%=request.getContextPath()%>/friendAccept.do",
			 "data" : {"id":id},
			 "success" :function(data){
				 alert("일촌이 수락되었습니다.")
				 //location.reload();	
				$("#friendListBtn").trigger("click");
			 },
			 "error":function(hx){
				 alert(hx.status);
			 },
			 "dataType" : "html"
		  });
	  });
  });
	
  $(function(){
	  $(".delete").on('click',function(){
		  var id = $(this).attr("id");
// 		  alert(id);
		  
		  $.ajax({
			  "url" : "<%=request.getContextPath()%>/friendAcceptDel.do",
			  "data" : {"id":id},
			  "success" : function(data){
				  alert("일촌신청을 거절하였습니다.")
					$("#friendListBtn").trigger("click");

			  },
			  "error":function(hx){
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
img{
width : 50px;
height : 50px;
border-radius : 50px;
}
#myList{
    width : 600px;
    height : 45px;
    border-radius: 10px;
    background :#D8D8D8;
    font-size : 17px;
    line-height : 48px;
 }
#myList span{
   position: relative;
   left : 10px;
}
.name{
	color : orange;
	font-size : 1.13em;
}

</style>
</head>
<body>

<%
   List<MemberFriendVO> memFriendList = (List<MemberFriendVO>)request.getAttribute("AllFriendList");
%>
<div id="myList"> <span>나의 일촌 목록</span></div><br>
<table border="0" style="border-collapse: collapse;">

<%

if(memFriendList == null|| memFriendList.size()==0){
%>
<tr><td colspan="3">일촌을 맺은 친구가 한 명도 없습니다.</td></tr>
<%

}else{
   int cnt = 0;
   for(MemberFriendVO memList : memFriendList){
%>
<!-- <img src="/cyworld/images/cy_logo.png" style="width:60px;"/> -->
<tr>
<td style="width:60px;height:50px;"><img src="<%=memList.getHome_pic()%>" alt ="홈피사진"></td>
<td style="width:120px;height:50px;"><%=memList.getMem_name() %>(<%=memList.getMem_id() %>)</td>
<td style="width:60px;"><span id="deleteFriend<%=cnt%>" style="color:#6E6E6E; font-size: 35px;" 
   onclick="fn_submit('<%=memList.getMem_id() %>')"><i class="fa fa-minus-square" aria-hidden="true" style="cursor:pointer;"></i></span></td>
<!-- deleteFriend+cnt 로 버튼마다 고유의 id값을 지정한다 , 클릭시 현재 저장된 mem_id가 전달되게함-->
</tr>

<%-- <input type="hidden" name="home_id" id="home_id" value="<%=session.getAttribute("homeChk") %>"> --%>
<%
   cnt++;
   }
}

%>      

</table>
<form id="friendForm" method="get" action="<%=request.getContextPath()%>/friendDelete.do" >
<input type="hidden" name="mem_id" id="mem_id" value="">
</form>
<br>

<%
	String userName = (String)session.getAttribute("userName");
	String friendName = (String)session.getAttribute("friendName");

//1.로그인시 session값을 불러옴
// 	List<MemberFriendVO> sendList = (List<MemberFriendVO>)session.getAttribute("sendList");
//2.allfriend.do에서 받아옴
	List<MemberFriendVO> sendList2 = (List<MemberFriendVO>)request.getAttribute("sendList2");
%>
<div id="myList"><span>새로운 일촌신청</span>
<form id="acceptFriend" action="<%=request.getContextPath()%>/friendAccept.do">
<table border="0" style="border-collapse: collapse;">
<%
	if(sendList2 == null|| sendList2.size()==0){
%>
	<tr><td>신청된 일촌이 없습니다.</td></tr>
<%
	}else
		
	for(MemberFriendVO sendList3 : sendList2){
%>
	<tr>
		<td "width:130px;height:60px; padding-right: 25px;"><img src="../images/cyworld_logo.png" alt="로고"></td>
		<td "width:450px;height:60px;  padding-right: 25px;"><span class="name" style="padding-right: 10px;"><%=sendList3.getMem_name()%> </span>님이 일촌을 신청하셨습니다.<br>
		  일촌을 맺으시겠습니까?</td>
		<td "width:90px;height:60px;"><input type="button" class="accept" value = "수락" id="<%=sendList3.getMem_id()%>" />
			<input type="button" class="delete" value="삭제" id="<%=sendList3.getMem_id()%>"/></td>
	</tr>
<%
	}
%>		
</table>
</form>
</div>


</body>
</html>