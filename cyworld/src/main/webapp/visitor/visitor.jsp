<%@page import="visitor.service.VisitorServiceImpl"%>
<%@page import="visitor.service.IVisitorService"%>
<%@page import="vo.StoryRoomVO"%>
<%@page import="storyroom.service.StoryServiceImpl"%>
<%@page import="storyroom.service.IStoryService"%>
<%@page import="vo.HomeVO"%>
<%@page import="vo.VisitorVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String userid = (String)session.getAttribute("userId");
String homechk = (String)session.getAttribute("homeChk");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
$(function() {
	
	$('.userUpdate').on('click', function(){
		
		var visitor_no = $(this).parents('.div').attr("id");
		var visitor_text = $(this).parents('.div').attr("text");
		
		
		var updateForm = $("#updateForm")
		$("#visitor_no").val(visitor_no);
		$("#visitor_text").val(visitor_text);
		
		$(this).parents('.div').find('.area').append(updateForm);
		updateForm.show();
		
		
	})
	
	$("#okBtn").on("click", function(){
			var visitor_no = $("#visitor_no").val();
			var visitor_text = $("#visitor_text").val();
			
			$.ajax({
				url : '/userVisitorUpdate.do',
				type : 'post',
				data : {'visitor_no' : visitor_no, 'visitor_text' : visitor_text},
				success : function(res){
					var updateForm = $("#updateForm")
					updateForm.hide();
					 code = res.visitor_text;
					$("#visit").text(code); 
					location.reload();
				},
				error : function(xhr){
					alert(xhr.status);
				},
				dataType : 'json'
			});
		})
		
		
		$(".userDelete").on('click', function(){
			var visitor_no = $(this).parents('.div').attr("id");
				
				$.ajax({
					url : '/userVisitorDelete.do',
					type : 'post',
					data : {'visitor_no' : visitor_no},
					success : function(res){
						
						location.reload();
					},
					error : function(xhr){
						alert(xhr.status);
					},
					dataType : 'json'
				})
				
			}) 
			
			$(".otherDelete").on('click', function(){
				var visitor_no = $(this).parents('.div').attr("id");
					$.ajax({
						url : '/userVisitorDelete.do',
						type : 'post',
						data : {'visitor_no' : visitor_no},
						success : function(res){
							
							location.reload();
						},
						error : function(xhr){
							alert(xhr.status);
						},
						dataType : 'json'
					})
					
				}) 
	
				
				$('.secretBtn').on('click', function(){

					var visitor_set = $(this).parents('.div').attr("secret");
					var visitor_no = $(this).parents('.div').attr("id");
					var secretText = $("#secretText")
					
					$(this).parents('.div').find('.sec').append(secretText);
					secretText.show();
						
					$.ajax({
						url : '/secret.do',
						type : 'post',
						data : {'visitor_no' : visitor_no, 'visitor_set' : visitor_set},
						success : function(res){
						  
						},
						error : function(xhr){
							alert(xhr.status);
						},
						dataType : 'json'
					})
				
			})
				
})
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Single+Day&display=swap');
body{
	font-family: 'Single Day', cursive;
}
#container{
	border: 1px solid white;
	background-color: white;
	overflow: auto;
}
.pre{
	border: 1px solid #D8D8D8;
	margin-left : 10%;
	width : 82%;
	background: #D8D8D8;
	border-radius: 10px;
	height: 45px;
	font-size : 15px;
}
#div1{
	text-align : center;
	border: 1px solid #3296D7;
	background: #3296D7;
	border-radius: 5px;
	width: 100px;
	height : 30px;
	margin-left: 80%;
	margin-top: 30px;
	
}
 #a{
	text-align : center;
	text-decoration: none;
	color: white;
	
} 

#table{
	border : 1px solid white;
	margin-left : 10%;
	width: 82%;
    height: 200px;
   	text-align: center;
}
#okBtn{
	background: #3296D7; 
	border-radius: 5px; 
	vertical-align: top;
	
}

#label{
	vertical-align: top;
}
#visit{
vertical-align : middle;
}
</style>
</head>
<body>
<%
List<VisitorVO> visitorList = (List<VisitorVO>)request.getAttribute("visitorList");
%>
	<div class="container">
		<div class="row">
		
		
		<%
   //로그인한 회원의 mem_id와 home_id
   String homeId = (String)session.getAttribute("homeChk");
   
   //친구의 mem_id와 home_id
   String friendId = (String)session.getAttribute("friendId");
   String friendHomeId = (String)session.getAttribute("friendHomeId");
  
   //친구 아이디값이 있으면 로그인세션값에서 받아온 
   //memId, homeId를 친구의 값으로 바꿔준다

%>
		
			<%if(friendId!=null){
			%>
			<p id="div1"><a href="visitorWrite.do" id="a">방명록남기기</a></p>
			<%
			}
			%>
			
			
			<h3 style="text-align: center;">방명록</h3>
			<span id="secretText" style="color:orange; display:none;">비밀이야<br>(이글은 홈주인과 작성자만 볼 수 있어요)</span>
					<div id="updateForm" style="display:none;">
							<form name="frm" id="frm">
								<input type="hidden" name="mem_id" value=<%=session.getAttribute("userId")%> />
								<input type="hidden" name="visitor_no" id="visitor_no">
							 	
							 	<label id="label">방명록수정</label>
							 	<textarea id="visitor_text" rows="2" cols="60"></textarea>
								<input type="button" value="확인" id="okBtn">
								
							</form>
						</div>
						
<%
if(visitorList==null || visitorList.size()==0){
%>	
				<div style="margin-top: 100px;"><h3 style="text-align: center;">등록된 방명록이 없습니다</h3></div>


<%
}else{
	for(VisitorVO vo : visitorList){

		
		IStoryService service3 = StoryServiceImpl.getInstance();
		StoryRoomVO minimiVo = service3.getMinimi(homechk); 
		IVisitorService service4 = VisitorServiceImpl.getService();
		String getMinimi = service4.visitorMinimi(vo.getMem_id());
				
		String disabled = "";
		String spanTag = "";
		if(vo.getVisitor_set()==0 || homechk.equals(vo.getHome_id()) || userid.equals(vo.getMem_id())){
			if(vo.getVisitor_set()==2){
				disabled = "disabled";
				spanTag = "<span id='secretText' style='color:orange;'>비밀이야<br>(이글은 홈주인과 작성자만 볼 수 있어요)</span>";
			}
		
%>	
		
			<div class="div" id="<%=vo.getVisitor_no()%>" text="<%=vo.getVisitor_text()%>" secret="<%=vo.getVisitor_set()%>">		
	<pre class="pre">NO.<%=vo.getVisitor_no() %>  <%=vo.getMem_id() %>  <%=vo.getVisitor_date() %> </pre>
	
			<form id="frm">
				<table id="table" class="table table-striped ">
					<tr>
					 <td style="width:150px; text-align: center;"><img src="<%=getMinimi %>" style="width:150px;"></td> 
						<td id="visit" style="width:270px;"><span class="sec"><%=spanTag %></span><br><%=vo.getVisitor_text() %></td>
						<td>
<%
			if(userid.equals(vo.getMem_id())){

%>
						
						<input type="button" name="secret" <%=disabled %> class="secretBtn" value="비밀로하기" style="background: #3296D7; border-radius: 5px; margin-top: 70px;" ><br><br>
						<input type="button" value="수정" class="userUpdate"style="background: #3296D7; border-radius: 5px;">
						<input type="button" value="삭제" class="userDelete"style="background: #3296D7; border-radius: 5px;">
					
<%
			}if(homechk.equals(vo.getHome_id())){
%>
						
						<input type="button" value="삭제" class="otherDelete"style="background: #3296D7; border-radius: 5px; margin-top: 70px;">
							
<%
			}
	
%>
						</td>
					</tr>
				</table>
			</form>		
		<div class="area" style="text-align: center;"></div>
		</div>
<%
		}
	}
}
%> 
						
		</div>
	</div>
</body>
</html>