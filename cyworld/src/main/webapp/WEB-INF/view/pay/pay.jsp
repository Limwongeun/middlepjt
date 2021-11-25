<%@page import="vo.CartVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style5.css">
<script src="<%=request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
<style>
img{
	vertical-align: bottom;
	padding:  10px 10px 10px 10px;
}
</style>
<%-- 
<script>
$(function(){
	// <input class="b" type="checkbox" id="voucher_id" name =6 value="6">
	$('#check').on('click', function(){
// 		var price = $('#price').(this).attr('value')
		$.ajax({
			url : '/payment.do',
			success : function(res){
				if(res.sw == 'no'){
					alert("구매하기 오류")
					return false;
				}
				alert("구매 화면으로 이동합니다.")
				location.href="<%=request.getContextPath()%>/WEB-INF/view/pay/payTest.jsp"
			},
			error : function(xhr){
				alert(xhr.status)
			},
			dataType : 'json'
		})
	})
})
</script>
 --%>


</head>
<body>
<%int cnt = 0;%>
<%
	session.getAttribute("userId");
	List<CartVO> list = (List<CartVO>)request.getAttribute("cartList");
%>
<form class="a" action="<%=request.getContextPath()%>/payment/paymentSelect.do">
	<table style="margin-left: auto; margin-right: auto;">
		<tr>
			<h2>도토리 충전</h2><br><br><br>
			<td>
				<h2>10개</h2>
				<div class="price">
					<img src="../images/1개.png" width="250px" height="250px"><br>
					<span class="value">1,000</span> <span class="duration">원</span>
				</div>
				<br>
				<input class="b" type="checkbox" id="voucher_id" name="voucher_id" value="1">선택 <br><br>
			</td>
			<td>
				<h2>30개</h2>
				<div class="price">
					<img src="../images/2개.png" width="250px" height="250px"><br>
					<span class="value">2,900</span> <span class="duration">원</span>
				</div>
				<br>
				<input class="b" type="checkbox" id="voucher_id" name="voucher_id" value="2">선택 <br><br>
			</td>
			<td>
				<h2>50개</h2>
				<div class="price">
					<img src="../images/2개.png" width="250px" height="250px"><br>
					<span class="value">4,500</span> <span class="duration">원</span>
				</div>
				<br>
				<input class="b" type="checkbox" id="voucher_id" name="voucher_id" value="2">선택 <br><br>
			</td>
			<td>
				<h2>100개</h2>
				<div class="price">
					<img src="../images/4개.png" width="250px" height="250px"><br>
					<span class="value">9,000</span> <span class="duration">원</span>
				</div>
				<br>
				<input class="b" type="checkbox" id="voucher_id" name="voucher_id" value="4">선택 <br><br>
			</td>
			<td>
				<h2>150개</h2>
				<div class="price">
					<img src="../images/5개.png" width="250px" height="250px"><br>
					<span class="value">13,000</span> <span class="duration">원</span>
				</div>
				<br>
				<input class="b" type="checkbox" id="voucher_id" name="voucher_id" value="5">선택 <br><br>
			</td>
			<td>
				<h2>300개</h2>
				<div class="price">
					<img src="../images/6개.png" width="250px" height="250px"><br>
					<span class="value">20,000</span> <span class="duration">원</span>
				</div>
				<br>
				<input class="b" type="checkbox" id="voucher_id" name="voucher_id" value="6">선택 <br><br>
			</td>
		</tr>
	</table>
</form>
<br><hr><br>
<table style="margin-left: auto; margin-right: auto;">
<tr><td colspan="4" style="text-align: center;"><tr><tr>
</table>
 <section class="mini-form">
         <form method="post" action="#">
            <div class="btn-area">
               <button id="check" type="button">충전하기</button>
               <button id="reset" type="reset">취소하기</button> 
            </div>          
          </form>
</section>
<script>
	$(function(){
	<%--             <%request.setAttribute("pay.jsp","payTest.jsp");%> --%>
	$('#check').on('click', function(){
		location.href = "<%=request.getContextPath()%>/inicisPay.do"
		})
	})
	$(function(){
	$('#cancel').on('click', function(){
<%-- 		location.href = "<%=request.getContextPath()%>/index.jsp" --%>
		location.href = "<%=request.getContextPath()%>/main/index.jsp"
		})
	})
</script>


</body>
</html>