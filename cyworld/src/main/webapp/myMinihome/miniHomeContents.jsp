<%@page import="vo.MemberFriendVO"%>
<%@page import="java.util.List"%>
<%@page import="friend.service.FriendServiceImpl"%>
<%@page import="friend.service.IFriendService"%>
<%@page import="vo.StoryRoomVO"%>
<%@page import="storyroom.service.StoryServiceImpl"%>
<%@page import="storyroom.service.IStoryService"%>
<%@page import="member.service2.MemberServiceImpl2"%>
<%@page import="member.service2.IMemberService2"%>
<%@page import="home.service.HomeServiceImpl"%>
<%@page import="home.service.IHomeService"%>
<%@page import="vo.MemberVO"%>
<%@page import="vo.HomeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Single+Day&display=swap');
body, input, button{
   font-family: 'Single Day', cursive;
}
html,body {
    width: 100%;
    height: 100%;
    margin: 0;
    background-color: white;
}
#total{
    width: 30%;
    position: absolute;
    display: inline;
    left: 9%;
    top: 2%;
}
#title{
   display: inline;
    position: absolute;
    left: 35%;
    top: 2%;
}
#uploadBtn{
      display: none;
}
#uploadBtn2{
   display: none;

}
#myTextarea{
   position: absolute;
    top: 47%;
    width: 23.3%;
    height: 26%;
    left: 3%;
}

#myTextarea2{
   position: absolute;
    top: 42%;
    width: 23.3%;
    height: 33%;
    left: 3%;
}
#textBtn{
   position: absolute;
   background-color: transparent;
   border : 0;
    top: 75%;
    left: 3%;
}

//일촌파도타기
#chonWave{
   position: absolute;
   top : 85%;
   left : 20%;
}

#insertFrinedBtn{
   position : absolute;
   top : 95%;
   left : 10%;
}
</style>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
   $("#textBtn").on("click",function(){
      newText = $("#myTextarea").val();
      homeId = $("#homeId").val();
      
      $.ajax({
         url : '/textChange.do',
         data : {'newText' : newText, 'homeId' : homeId},
         success : function(res){
         },
         error : function(xhr){
         },
         dataType : 'json'
         
                  
      });
      
   });
});

//일촌파도타기
$(function(){
   $("#waveBtn").on("click",function(){
      var mem_id = $("#bestFriend option:selected").val();
      window.open('<%=request.getContextPath()%>/friendIdSave.do?mem_id=' + mem_id, 'pop01', 'top=10, left=10, width=1100, height=650, status=no, menubar=no, toolbar=no, resizable=no,  location=no')
   });
});

//일촌신청
$(function(){
   $("#insertFrinedBtn").on("click",function(){
//       var mem_id = userid;
//       var friend_id = friendId;
      window.open('../friend/friendRequest.jsp','friendRequest','top=30, left=200, width= 455, height=525, status=no, menubar=yes,toolbar=no, resizable=no,  location=no')
   });
});
</script>

</head>

<body>
<!-- 방문자수 total-->
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

   IHomeService service = HomeServiceImpl.getInstance();
   IMemberService2 service2 = MemberServiceImpl2.getInstance();
   
   HomeVO homeVo = service.getHomeInfo(userid);
   session.setAttribute("homeVo", homeVo);
   
   MemberVO memVo = service2.getMemInfo(userid);
   request.setAttribute("homeVo", homeVo);
   request.setAttribute("memVo", memVo);
   
   //storyVo, minimiVo 연결
      IStoryService service3 = StoryServiceImpl.getInstance();
    StoryRoomVO storyVo = service3.getStory(homeId);
    StoryRoomVO minimiVo = service3.getMinimi(homeId);
    StoryRoomVO mp3Vo = service3.getmp3(homeId);
    
    
    //일촌파도타기 값 가져오기
    IFriendService service4 = FriendServiceImpl.getInstance();
    //--totay.total 값
    int todayCount =  service4.todayCount(homeId);
    int totalCount = service4.totalCount(homeId);
   
    //친구목록가져오기
    List<MemberFriendVO> bestFriendList = service4.bestFriendList(homeId);
    List<MemberFriendVO> bestFriendList2 = service4.bestFriendList((String)session.getAttribute("homeChk"));
%>

<!-- 자신이 방문하면 방문자수 증가X, 남이 방문하면 방문자수 1 증가 (검색이나 파도타기에서 클릭했을때 1 증가해야함) -->
<%if(friendId != null){
   service4.insertCount(homeId);
} 
%>
<div id="total" style="text-size:1.1em;">TODAY<%=service4.todayCount(homeId)%> | TOTAL <%=service4.totalCount(homeId) %></div>

<!-- 미니홈피 타이틀 -->
<div id="title" style="text-size:1.3em;">♥<%=memVo.getMem_name() %>♥님의 미니홈피</div>


<!-- 프로필 사진 -->
<img src="<%=homeVo.getHome_pic() %>" 
style="position: absolute; height: 32%; width: 25%; top: 7.5%; left: 2%;">

<!-- 자신의 미니홈피에서만 프로필 업로드와 문구 수정 일촌 파도타기가 보임 -->
<% if(friendId ==null){

 %>
<!-- 프로필사진 업로드&확인버튼 -->
<form method="post" action="/homePicUpload.do" enctype="multipart/form-data">

<div class="filebox" style="
    position: absolute;
    top: 41%;
    left: 3.3%;
">

<label for="uploadBtn">+EDIT</label>
<input type="file" id="uploadBtn" name="uploadfile" value="사진업로드"/>
</div>

<!-- <input type="file" id="uploadBtn" name="uploadfile" value="사진업로드"/> -->
<input type="hidden"  name="homeId" value="<%=homeId%>"/>
<div style="
    position: absolute;
    top: 41%;
    left: 13%;
">

<label for="uploadBtn2">OK</label>
<input id="uploadBtn2" type="submit" value="확인"/>
</div>

<!-- <input id="uploadBtn2" type="submit" value="확인"/> -->
</form>

<%}%>


<!-- 프로필문구 출력, 수정 -->
<form>


<%if(friendId ==null){ %>
<textarea id="myTextarea" name="text" style="resize: none; border-radius: 5px; font-family: 'Single Day', cursive; spellcheck:'false';">
<%=homeVo.getHome_text() %></textarea>
<input type="button" id="textBtn" name="textBtn" value="+EDIT">
<input type="hidden" id="homeId" name="homeId" value="<%=homeId %>">
<% }else{
%>
<textarea id="myTextarea2" name="text"><%=homeVo.getHome_text() %></textarea>
<%
}
%>
</form>

<div  style="position:absolute; left:3%; top:80%">
<span style="font-size : 1.2em;"><%=memVo.getMem_name() %></span>
</div>

<!-- 일촌 파도타기 -->
<select id="bestFriend" style="position:absolute; left:6.5%; top:85%" >
<%
   if(bestFriendList== null || bestFriendList.size()==0){
%>
      <option selected>★일촌 파도타기★</option>
      <option></option>
<%
   }else{
%>   
   <option id="wave" selected>★일촌 파도타기★</option> 
<%
       for(MemberFriendVO friendList : bestFriendList){
%>      
         <option value="<%=friendList.getMem_id()%>"><%=friendList.getMem_name()%>(<%=friendList.getFriend_name()%>)</option>
<%      
      }
   }
%>

</select>

<br>
<button type="button" id="waveBtn" style="position:absolute; left:8%; top: 90%;">홈피 방문하기</button>

<%
boolean exist = false;          
for(MemberFriendVO friendList : bestFriendList2){
      String id = friendList.getMem_id();
     if(!id.equals((String)session.getAttribute("friendId"))){
             }else{
        exist = true;
        break;
     }
   }

if(friendId !=null && exist==false){
%>
<input type="button" value="일촌신청" name="insert_friend" id="insertFrinedBtn"> 
<%

}
%>      
   
<audio controls style="
    position: absolute;
    left: 53%;
    top: 12%;
    width: 333px;
    height: 50px;
"> <source src="<%=mp3Vo.getProd_url() %>" type="audio/mp3"> </audio>

<!-- 내 아이템에서 적용한 스토리룸 출력 -->
<img style="
    position: absolute;
    width: 60%;
    height: 50%;
    top: 45%;
    left: 35%;
" src="<%=storyVo.getProd_url() %>">

<!-- 내 아이템에서 적용한 미니미 출력 -->

<img style="
    position: absolute;
    width: 15%;
    height: 24%;
    top: 65%;
    left: 45%;
" src="<%=minimiVo.getProd_url()%>">




</body>
</html>