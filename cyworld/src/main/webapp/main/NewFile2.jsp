<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사이좋은 사람들 싸이월드에 오신 것을 환영합니다.</title>
<link rel ="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/images/cy_logo.png">
<style>
div {
	margin: 1px;
	width: auto;
	padding: 1px;
	border-radius: 10px;
	box-sizing: border-box;
	overflow: auto;
}

#header {
	background: #EDEDED;
	width: auto;
	height: 60px;
	overflow: hidden;
	text-align: right;
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
	float: inherit;
	border: none;
}

#nav1 {
	background: #EDEDED;
	width: auto;
	height: 60px;
	overflow: hidden;
	text-align: center;
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
	padding: 35px;
}


#footer {
	background: #EDEDED;
	clear: both;
	color: white;
}

a {
	text-decoration: none;
	color: black;
	text-align: top;
}

h5 {
	text-align: center;
}
</style>

	<div id="header"><br>
		<li id="liIn"><a href="<%=request.getContextPath()%>/logout.do" target="ifr">로그아웃</a></li>
		<li id="liIn"><a href="#" target="ifr">장바구니</a></li>
		<li id="liIn"><a href="#" target="ifr">마이페이지</a></li>
		<li id="liIn"><a href="#" target="ifr">내 미니홈피</a></li>
	</div>
</head>
<body>
	<div>
		<div id="nav1">
			<br>
			<li id="liIn"><a href="#">배경음악</a></li>
			<li id="liIn"><a href="#" target="ifr">스킨</a></li>
			<li id="liIn"><a href="#" target="ifr">미니미</a></li>
			<li id="liIn"><a href="#" target="ifr">스토리룸</a></li>
		</div>
				<div id="content">
					<article id="article1">
						<iframe src="<%=request.getContextPath()%>/main/login.jsp" name="ifr"> </iframe>
					</article> 
				</div>
			</aside>
		</div>
		<div id="footer">
			<br>
			<h5>
				주소 : 대전광역시 중구 중앙로 76 영민빌딩 4층<br>
				<br> 대표전화 : 042-222-8202팩스: 042-252-0678<br>
			</h5>
		</div>
	</div>
</body>
</html>
