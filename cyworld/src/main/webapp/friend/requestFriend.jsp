<%@page import="vo.FriendVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	FriendVO friendVo = (FriendVO)request.getAttribute("memId");
%>
<div style="padding: 10px; background : orange">
<div style="width: 100px; height: 400px;">

<h3> ���̽�û</h3>
<pre>������ �� : ������</pre><!-- �α����� ��� -->
<pre>ȫ�浿�Բ� ������ ��û�մϴ�.</pre><br><br>

<pre>
<b>ȫ�浿</b> ���� ���������� <input type="text" id="friendName">��
<br><b>������</b> ���� ȫ�浿���� <input type="text" id="friendName2">��<br>
���� �ΰ� �;��

<sapn>    ������ �����ϸ� ������ �ξ����ϴ�.</sapn>
</pre>
<input type="reset" value="���" id="cancle"><input type="submit" value="������" in="send">
</div>

</div>
</body>
</html>