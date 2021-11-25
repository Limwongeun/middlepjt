<%@page import="vo.ReplyVO"%>
<%@page import="java.util.List"%>
<%@page import="board.service.IBoardService"%>
<%@page import="board.service.BoardServiceImpl"%>
<%@page import="vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	
	$('.row4 input:button').on('click', function(){
	
		//commentText = $(".row4 : text").val();
		 var queryString = $("form[name=frm]").serialize();
		$.ajax({
			url : '/commentText.do',
			type : 'post',
			data : queryString,
			success : function(res){
					
				/* var code = "";
				code += res.mem_id;
			    code += res.comment_text;
				$('#row5').append(code); */
				location.reload();
			},
			error : function(xhr){
				alert(xhr.status);
			},
			dataType : 'json'
		})
	})
	
	
	$('.userUpdate').on('click', function(){
		
		var commentNo = $(this).parent().attr("idx");
		var commentText = $(this).parent().attr("text");
		
		var commentUpdateForm = $("#commentUpdateForm")
		$("#commentText").val(commentText);
		$("#commentNo").val(commentNo);
		
		$(this).parent().append(commentUpdateForm);
		commentUpdateForm.show();
		
		
	})
	
		$("#commentUpdateBtn").on("click", function(){
			var commentNo = $("#commentNo").val();
			var commentText = $("#commentText").val();
			
			$.ajax({
				url : '/userCommentUpdate.do',
				type : 'post',
				data : {'commentNo' : commentNo, 'commentText' : commentText},
				success : function(res){
					var commentUpdateForm = $("#commentUpdateForm")
					commentUpdateForm.hide();
					code = res.comment_text;
					$("#row5").children('.textBtn').text(code);
					location.reload();
				},
				error : function(xhr){
					alert(xhr.status);
				},
				dataType : 'json'
			});
		})
	
			
	 $('.userDelete').on('click', function(){
		var commentNo = $(this).parent().attr("idx");
		$.ajax({
			url : '/userCommentDelete.do',
			type : 'post',
			data : {'commentNo' : commentNo},
			success : function(res){
				
				location.reload();
			},
			error : function(xhr){
				alert(xhr.status);
			},
			dataType : 'json'
		})
		
	}) 
	
	
	$('.Reply').on('click', function(){
		
		var commentNo = $(this).parent().attr("idx");
		
		
		var replyform = $("#replyform")
		$("#comment_no").val(commentNo);
		$(this).parent().append(replyform);
		replyform.show();	
	})
	
	$('#replyBtn').on('click', function(){
		
		var queryString = $("form[name=frm2]").serialize();
		$.ajax({
			url : '/replyText2.do',
			type : 'post',
			data : queryString,
			success : function(res){
				var replyform = $("#replyform")
				replyform.hide();
				var code = "";
				code += res.mem_id;
			    code += res.comment_text;
			    $('#Reply').children().append(code);
			    location.reload();
			},
			error : function(xhr){
				alert(xhr.status);
			},
			dataType : 'json'
		});
			
	})
	
	
})
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Single+Day&display=swap');
body, input, button{
   font-family: 'Single Day', cursive;
}
.container{
	margin-top : 20px;
	width: 90%;
}
.row2{
	border : 1px solid #dddddd;
	height : 240px;
	margin-bottom: 10px;
}
.row3{
	text-align: center;
	
}
#button{
	background: #3296D7;
	border-radius: 5px;
	width : 70px;
	height : 35px;
	color: white;
}
.row4{
	margin-top: 7px;
	margin-left: 15px;
}
body{
	-ms-overflow-style: none;
}
::-webkit-scrollbar { display: none; }

#row5{
	 -ms-overflow-style: none;
}
#row5::-webkit-scrollbar{ display:none; }
#userUpdate{
	background-color: #3296D7;
	border-radius: 6px;
	margin: 4px;
	color : white;	
}
#userDelete{
	background-color: #3296D7;
	border-radius: 6px;
	margin: 4px;
	color : white;	
}
#commentUpdateBtn{
	
	background-color: #3296D7;
	border-radius: 6px;
	margin: 4px;
	color : white;	
}
#Reply{
	
	background-color: #3296D7;
	border-radius: 6px;
	margin: 4px;
	color : white;		
}
#replyBtn{
	
	background-color: #3296D7;
	border-radius: 6px;
	margin: 4px;
	color : white;	
}
</style>
</head>
<body>

<%
BoardVO boardVo = (BoardVO)request.getAttribute("boardVo");
List<ReplyVO> replyList = (List<ReplyVO>)request.getAttribute("replyList");
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
		<table class="table table-striped" style="text-align : center;border: none;">
			<thead>
				<tr>
					<th colspan="4" style="background-color:#D8D8D8; text-align: center;">게시판 글 보기</th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td>제목</td>
					<td colspan="2"><td><%=boardVo.getBoard_title() %></td>
				</tr>
				<tr>
					<td>작성일자</td>
					<td colspan="2"><td><%=boardVo.getBoard_date().substring(0,11)%></td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="2" style="height: 70px; text-align: left;"><td><%=boardVo.getBoard_text()%></td>
				</tr>
			</tbody>
		</table>
			<div class="row2">
				<div class="row4">
<!-- 				  <form name="frm" id="frm" method="post" action="/commentText.do"> -->
				  <form name="frm" id="frm">
					<label style="margin-right: 15px; font-size: 20px; font-family: sans-serif;">댓글남기기 </label>
					<input type="hidden" name="board_no" value=<%=boardVo.getBoard_no() %> />
					<input type="hidden" name="comment_no" />
					<input type="hidden" name="comment_date"/>
					<input type="hidden" name="mem_id" value=<%=session.getAttribute("userId")%> />
<!-- 
	BOARD_NO board_no
REPLY_NO null
COMMENT_GU 1
COMMENT_DATE sysdate
COMMENT_NO	일련번호
MEM_ID	a001
	COMMENT_TEXT comment_text
 -->					
					<input type="text" name="comment_text" placeholder="내용을 입력해주세요" maxlength="2048" style="width: 70%; height: 38px; margin-right: 5px; border-radius: 5px; border: 2px solid #dddddd">
					<input type="button" value="확인" id="button">
				  </form>
				</div>
				<div id="row5" style="margin-left: 20px; margin-top: 5px; width: 90%; height: 180px; overflow: auto;">
				<div id="commentUpdateForm" style="display:none;">
					<form>
						<textarea id="commentText" rows="2" cols="60"></textarea>
						<input type="hidden" id="commentNo">
						<input type="button" id="commentUpdateBtn" value="확인">
					</form>
				</div>
			   
				<%
				for(ReplyVO replyVo : replyList){
				%>
				<p idx="<%=replyVo.getComment_no()%>" text="<%=replyVo.getComment_text()%>">	
				<%	
					if(replyVo.getMem_id().equals(boardVo.getBoard_writer())){
				%>
					<span id="sp" style="color:red;"><%=replyVo.getMem_id() %></span>
				<%		
					}else {
				%>	
					<span id="sp" style="color:blue;"><%=replyVo.getMem_id() %></span>
				<%	
					}//else end
				%>	
					:  <span class ="textBtn"><%=replyVo.getComment_text() %></span> (<%=replyVo.getComment_date() %>)
				
				
				<%
					if(userid.equals(replyVo.getMem_id())) {
				%>
					
					
					<%if(friendId ==null){ %>
					<input type="button" value="수정" class="userUpdate" id="userUpdate" style="margin-left: 10px;"> 
					<%
					}%>
				
				<% 		
					}
				%>	
				
				
				<%
					if(userid.equals(replyVo.getMem_id()) || userid.equals(boardVo.getBoard_writer())) {
				%>
					
					
					 
					 
					 <%if(friendId ==null){ %>
					 <input type="button" value="삭제" class="userDelete" id="userDelete"> 
					<%
					}%>
				<% 		
					}
				%>	
			    <%
					if(!userid.equals(replyVo.getMem_id())) {
				%>
					 <input type="button" value="댓글남기기" class="Reply" id="Reply"> 
					
				<% 		
					}
				%>
					
					</p>									
					<div id="userText"></div>
				<%	
				}//for end
				%>
				<div id="replyform" style="display:none;">
					<form name="frm2" id="frm2">
						<label>댓글남기기</label>
						<input type="text" id="comment_text" name="comment_text"style="width: 300px;">
						<input type="hidden" name="board_no" value=<%=boardVo.getBoard_no() %> />
						<input type="hidden" id="comment_no" name="comment_no">
						<!-- <input type="hidden" id="reply_no"> -->
						<input type="hidden" name="mem_id" value=<%=session.getAttribute("userId")%> />
						<input type="button" id="replyBtn" value="확인">
					</form>
				</div>
				
				
				</div>
				
			</div>
			<div class="row3">
			<a href="<%=request.getContextPath() %>/boardList.do" class="btn btn-primary" style="text-align: center;">목록</a>
			 <%
				if(userid != null && userid.equals(boardVo.getBoard_writer())) {	// 회원일때 수정 삭제
			%> 
				
				<%if(friendId ==null){ %>
				<a href="<%=request.getContextPath() %>/boardUpdate.do?board_no=<%=boardVo.getBoard_no()%>" class="btn btn-primary">수정</a>
				<%} %>
				
				<%if(friendId ==null){ %>
				<a onclick="return confirm('정말로 삭제하시겠습니까?')" href="<%=request.getContextPath() %>/boardDelete.do?board_no=<%=boardVo.getBoard_no()%>" class="btn btn-primary">삭제</a>
			<%} %>
			
			
			
			
			<%
				}
			%> 
			
			
			
			
			
			
			</div>	
	</div>

</div>
</body>
</html>