<%@page import="board.service.BoardServiceImpl"%>
<%@page import="board.service.IBoardService"%>
<%@page import="member.service.MemberServiceImpl"%>
<%@page import="member.service.IMemberService"%>
<%@page import="java.util.List"%>
<%@page import="vo.MemberFriendVO"%>
<%@page import="friend.service.FriendServiceImpl"%>
<%@page import="friend.service.IFriendService"%>
<%@page import="vo.MemberVO"%>
<%@page import="home.service.IHomeService"%>
<%@page import="member.service2.IMemberService2"%>
<%@page import="member.service2.MemberServiceImpl2"%>
<%@page import="home.service.HomeServiceImpl"%>
<%@page import="vo.HomeVO"%>
<%@page import="friend.service.FriendServiceImpl"%>
<%@page import="friend.service.IFriendService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>내 미니홈피</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style3.css">
<script src="<%=request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#btn").on('click',function(){
		$.ajax({
			"url":"<%=request.getContextPath()%>/friendSessionDel.do",
			"success" :function(data){
// 				alert("friend session이 삭제되었습니다.");
			}
		})
	});

});
</script>
</head>
<body>
<% 
	//값 가져오기
	String userid = (String)session.getAttribute("userId");
	String homeId = (String)session.getAttribute("homeChk");
	String username = (String)session.getAttribute("userName");
	int userdotori = (Integer)session.getAttribute("userDotori");
	IHomeService service = HomeServiceImpl.getInstance();
	IMemberService2 service2 = MemberServiceImpl2.getInstance();
	HomeVO homeVo = service.getHomeInfo(userid);
// 	HomeVO homeVo = (HomeVO)request.getAttribute("homeVo");
    MemberVO memVo =(MemberVO)request.getAttribute("memVo");
    IFriendService service4 = FriendServiceImpl.getInstance();
    int todayCount =  service4.todayCount(homeId);
    String friendId = (String)session.getAttribute("friendId");
    
  //일촌상태가 n인값을 친구목록과 동시에 불러들어오기
	MemberFriendVO memFriendVo = new MemberFriendVO();
	memFriendVo.setHome_id(homeId);
	
	IFriendService service3 = FriendServiceImpl.getInstance();
	List<MemberFriendVO> sendList2 = service3.sendFriend(memFriendVo);
	request.setAttribute("sendList2", sendList2);
	List<MemberFriendVO> sendList3 = (List<MemberFriendVO>)request.getAttribute("sendList2");
	IMemberService memService = MemberServiceImpl.getService();
	IBoardService service5 = BoardServiceImpl.getService();
	
	
	int dotori = 0;
	try {
		dotori = memService.getDotori(userid);
	} catch (Exception e) {
		e.printStackTrace();
	}
	

%>
<%
	// 로그인인 상태!!
	if(userid != null){
%>
<%if(friendId != null){
	service4.insertCount(homeId);
} 
%>
	      <h2>♥<%=username %>♥님의 미니홈피</h2>
    <table>
        <tr>
          <th><img src="<%=homeVo.getHome_pic() %>" style="width: 276px; height: 233px;" ></th>
          <th id="th1"><br><br><br><br><br><br>
           오늘 방문자&nbsp;&nbsp;&nbsp;<%=service4.todayCount(homeId)%>  <br><br>
           새 게시물&nbsp;&nbsp;&nbsp;<%=service5.countBoard(homeId) %>   <br><br>
           <span style="color:red;">new</span>일촌 신청 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=sendList3.size() %><br><br>
           내 도토리 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=dotori %><br><br>           
           <section class="mini-form">
			<form method="post" action="#">
				<div class="btn-area">
					<button id="btn" type="submit">내 미니홈피로 가기</button>
				</div>
		</form>
	</section>
	</table>
<script>
	$(function(){
   		$("#btn").on("click",function(){
      		window.open('<%=request.getContextPath()%>/miniHomeMain.do?userid=<%=userid%>', 'pop01', 'top=10, left=10, width=1100, height=650, status=no, menubar=no, toolbar=no, resizable=no,  location=no');
   		})
	});
</script>


	
<%
}else{ //로그인상태가 아닐때
%>  
<%
}	
%>
</body>
</html>