<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사이좋은 사람들 싸이월드에 오신 것을 환영합니다.</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel ="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/images/cy_logo.png">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<style>
div {
	margin: 1px;
	width: auto;
	padding: 1px;
	border-radius: 10px;
	box-sizing: border-box;
	overflow: auto;
}

#content {
	border: 1px solid white;
	background: white;
	width: auto;
	height: 800px;
	float: center;
}

iframe {
	width: 99%;
	height: 780px;
	overflow: inherit;
	float: center;
	border: none;
	position: absolute;
	
}

#nav1 {
	background: #EDEDED;
	width: auto;
	height: 60px;
	overflow: hidden;
	text-align: center;
	border-radius: 50px;
}

#nav2 {
	border: 1px solid #EDEDED;
	background: #EDEDED;
	width: 200px;
	height: 800px;
	float: left;
	overflow: visible;
	text-decoration: none;
}

#nav3 {
	border: 1px solid #EDEDED;
	background: #EDEDED;
	width: 200px;
	height: 800px;
	float: right;
	overflow: hidden;
	color: black;
}

#liIn {
	display: inline;
	padding: 50px;
	font: bold;
	font-weight: bold;
}


#footer {
	background: #EDEDED;
	clear: both;
	color: black;
}

a {
	text-decoration: none;
	color: black;
	text-align: top;
}

h5 {
	text-align: center;
	color: #747474;
}
.input-box {
    text-align: left;
    margin: 1px;
    margin-left: 23%;
    margin-right: 10%;
    padding: .px;
    overflow: hidden;
}
button {
    background-color: #EDEDED;
}
#cyImg{
	width: 300px; 
	height: 80px;
	margin-bottom: -10px;
	margin-left: -44px;
	margin-top: -10px;
}
#searchbar{
	height: 40px; 
	width: 50px;
}
#searchbarInput{
	height: 40px; 
	width: 400px;
}
#ppap{
	text-align: center;
	font-weight: bold;
	font-size: x-large;
	color: #1d1d1f;
}
#div #ifr{
	margin: 0 auto 0;
	text-align: center;
}
#korea{ 
	width: 280px; 
	height: 60px; 
	margin-top: -43px;
/* 	margin-right: 20px; */
  position : relative;
  left : 60px;
}
#search_name{
	margin-top: 5px;
 	font-size: 23px;
	border-radius: 50px 50%;
	border-style: solid;
	border-color: #FE9A2E;
	text-align: center;
	font-family: auto;
	font-weight: bold;
	margin-left: 28px;
}
#searchBtn{
	margin-top: 10px;
	background: white;
	border: none;
	font-size: 15px;
	margin-right: 16%;
}
.fa-search:before{ 
 	color: #FE9A2E;  
} 
ul li{
	display: inline;
}
</style>
</head>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#header").load('header.jsp');	
})

$(function(){
	   $("#searchBtn").on('click', function(){
		   var search_name = $("#search_name").val();
// 		   alert(search_name);
	     $.ajax({
		        "url" : "<%=request.getContextPath()%>/friendSearch.do",
		        data : {"search_name" : search_name},
		        "success" : function(result){
		        	$('#content').html(result);
		        },
		    	"error" : function(hx){
					alert(hx.status);
				},
				"dataType" : "html"
			});
		});
});

</script>
<body>
<%
	//값 가져오기
	String userid = (String)session.getAttribute("userId");
	String username = (String)session.getAttribute("userName");
%>
	<div id="header"><br>
	</div>
	<div class="input-box">
	       	<ul>
	       		<li id="list1"><a href="<%=request.getContextPath()%>/main/index.jsp"><img src="../images/cy_main_logo.PNG" id="cyImg" align="left"></a></li>
	       		<li id="list2">
	       		<form id="searchFriend">
				<input type="text" size=30 name="search_name" id="search_name" placeholder="친구를 찾아보세요!"> 
					<button type="button" id="searchBtn"><i class="fa fa-search fa-2x" aria-hidden="true"></i></button>
				</form>
	       		</li>
	       		<li id="list3">
	       		<a href="https://focus.daum.net/ch/og2020/home">			
				<img src="../images/korea1.png" id="korea" align="right">
			</a>
	       		</li>
	       	</ul>
	       	
			
	</div>
	 <div>
     <div id="nav1">
         <br>
         <li id="liIn"><a href="<%=request.getContextPath()%>/bgmList.do" target="ifr">배경음악</a></li>
         <li id="liIn"><a href="<%=request.getContextPath()%>/skinList.do" target="ifr">스킨</a></li>
         <li id="liIn"><a href="<%=request.getContextPath()%>/minimiList.do" target="ifr">미니미</a></li>
         <li id="liIn"><a href="<%=request.getContextPath()%>/roomList.do" target="ifr">스토리룸</a></li>
         <script>
         $('#liIn').click(function() {
             $("#ppap").hide();
          
         })
         </script>
      </div>
            <div id="content">
            
               <article id="article1">
                  <iframe src="<%=request.getContextPath()%>/main/indexImg.jsp" name="ifr" id="article2"></iframe>
            
<%

                  if(userid == null){
%>
                  <p id="ppap">guest로 입장하셨습니다.</p>
                  
<%
}else{
                  
%>  
                  <p id="ppap"><%=username %>님, 환영합니다. :)</p>               
<%
}
%>
               </article> 
            </div>
      </div>
      <div id="footer">
         <br>
         <h5>
            주소 : 대전광역시 중구 중앙로 76 영민빌딩 4층<br>
            대표전화 : 042-222-8202 | 팩스: 042-252-0678<br>
            이메일주소 : cyworld@cyworld.com<br>
            제휴문의 partner.biz@cyworld.com<br>
            이메일주소 무단 수집 거부 | 개인정보보호책임자 : 임성민<br>
            호스팅 서비스 제공자㈜싸이월드<br>
            Copyright © 2021 Cyworld. All Rights Reserved.<br>
         </h5>
      </div>
</body>
</html>
