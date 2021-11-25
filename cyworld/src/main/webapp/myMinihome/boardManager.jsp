<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판관리</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">



</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Single+Day&display=swap');
body{
	font-family: 'Single Day', cursive;
}
html,body {
    width: 100%;
    height: 100%;
    margin: 0;
    background-color: white;
}

.dropdown-button {
	background-color: #FFDAB9;
	padding: 8px;
	font-size: 15px;
	border: none;
	font-family: 'Single Day', cursive;
}

.dropdown {
	position: relative;
	display: inline-block;
}
.dropdown-content {
	display: none;
	position: absolute;
	background-color: #FFDAB9;
	min-width: 75px;
	padding: 5px;
	box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
	color: black;
	padding: 8px;
	text-decoration: none;
	display: block;
}
.dropdownA{
	width: 78.4px;
}

.dropdown-content a:hover { background-color: #FE9A2E; }
.dropdown:hover .dropdown-content { display: block; }
.dropdown:hover .dropdown-button { background-color: #FE9A2E; }
</style>
</head>
<body>
<div style="font-size: 25px; padding: 10px;">공개범위설정</div>

<div class="dropdown" style="left: 64px; top: 36px;">
		<button class="dropdown-button">사진첩 공개범위</button>
		<div class="dropdown-content">
			<a href="#" class="dropdownA">전체공개</a>
			<a href="#" class="dropdownA">일촌공개</a>
			<a href="#" class="dropdownA">비공개</a>
		</div>
</div>

<div class="dropdown" style="left: 100px; top: 36px;">
		<button class="dropdown-button">게시판 공개범위</button>
		<div class="dropdown-content">
			<a href="#" class="dropdownA">전체공개</a>
			<a href="#" class="dropdownA">일촌공개</a>
			<a href="#" class="dropdownA">비공개</a>
		</div>
</div>

<div class="dropdown" style="left: 138px; top: 36px;">
		<button class="dropdown-button">방명록 공개범위</button>
		<div class="dropdown-content">
			<a href="#" class="dropdownA">전체공개</a>
			<a href="#" class="dropdownA">일촌공개</a>
			<a href="#" class="dropdownA">비공개</a>
		</div>
</div>


</body>
</html>