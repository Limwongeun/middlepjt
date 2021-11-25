<%@page import="vo.MemberVO"%>
<%@page import="vo.OrderedVO"%>
<%@page import="vo.CartVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style5.css">
<script src="<%=request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$('.goCart').on('click', function(){
		var prodId = $(this).attr('name')
		
		$.ajax({
		       url : '/deleteCart.do',
		       data : {'prodId' : prodId},
		       success : function(res){
		          if(res.sw == 'no'){
		        	  alert("해당 상품이 장바구니에 존재하지 않습니다.");
		        	  return false;
		          }
		          alert("장바구니에서 해당 상품을 삭제했습니다.");
		          //성공 시 장바구니에서 상품을 삭제
		          location.href="<%=request.getContextPath()%>/viewCart.do";
		       },
		       error : function(xhr){
		          alert(xhr.status)
		       },
		       dataType : 'json'
		})
	})
	
	$('#btn').on('click', function(){
		$.ajax({
			url : '/paymentOrdered.do',
			success : function(res){
				console.log("res.mw : " + res.mw);
				
				if(res.mw == 'no'){
					alert("해당 상품을 결제하기에 도토S리가 부족합니다.");
					return false;
				} else if(res.mw == 'ok') {
					alert("결제가 완료됐습니다.\n구매하신 상품은 마이페이지에서 조회 가능합니다.")
				}
					location.href="<%=request.getContextPath()%>/insertProd.do";
<%-- 					location.href="<%=request.getContextPath()%>/insertProd.do"; --%>
			},
			error : function(xhr){
				console.log("오류");
				alert(xhr.status)
			},
			dataType : 'json'
		});
		
		$.ajax({
			url : '/setDotori.do',
			success : function(res){
				console.log("res.sw : " + res.sw);
				
				if(res.sw == 'no'){
					alert("해당 상품을 결제하기에 도토리가 부족합니다.");
					return false;
				} else if(res.sw == 'ok') {
					console.log("회원정보(도토리) 변경 완료.")
				}
			},
			error : function(xhr){
				alert(xhr.status)
			},
			dataType : 'json'
		});
	});
	
	
})
</script>
<style>
h3#pay{
	color: red;
}
</style>
</head>
<body>
<%int cnt = 0;%>
<%
	session.getAttribute("userId");
	List<CartVO> list = (List<CartVO>)request.getAttribute("cartList");
	OrderedVO vo = (OrderedVO)request.getAttribute("OrderVo");
// 	MemberVO memVo = (MemberVO)request.getAttribute("memVo");
	int dotori = (int)request.getAttribute("dotori");
%>
<table style="margin-left: auto; margin-right: auto;">
<tr>
	<td colspan="4" style="text-align: center;"><br><h2>장바구니</h2><br></td>
</tr>
<tr>
<%
if(list == null || list.size() == 0){
%>
<td colspan="4">장바구니에 담은 상품이 없습니다.</td></tr>
<script>
$(function(){
	$('.mini-form').hide()
	$('#pay').hide()
})
</script>
<%
} else {
	for(int i=0; i<list.size(); i++){
		cnt += list.get(i).getCart_price();
%>
<%
		if(i % 4 == 3){
%>
		<form>
			<td><img src="<%=list.get(i).getProd_url()%>" height="200px" width="300px"><br>
				<%=list.get(i).getProd_name() %><br>
				분류 : <%=list.get(i).getLprod_name() %>, 수량 : <%=list.get(i).getCart_qty() %>개, 
				가격 : <img src="../images/도토리.png" width="15px" height="15px"><%=list.get(i).getCart_price() %>
				<br>
				<input type="button" name="<%=list.get(i).getProd_id()  %>" class="goCart" value="삭제하기" style="float: right;">
				</td>
		</form>
	</tr><tr>
<%
		} else {
%>
		<form>
		<td><img src="<%=list.get(i).getProd_url()%>" height="200px" width="300px"><br>
			<%=list.get(i).getProd_name() %><br>
			분류 : <%=list.get(i).getLprod_name() %>, 수량 : <%=list.get(i).getCart_qty() %>개, 
			가격 : <img src="../images/도토리.png" width="15px" height="15px"><%=list.get(i).getCart_price() %>
			<br>
			<input type="button" name="<%=list.get(i).getProd_id()  %>" class="goCart" value="삭제하기" style="float: right;">
			</td>
		</form>
<%			
		}
	}
%>
</tr>
<%
}
%>
</table>
<br><br><br><hr><br>
<table id="pay" style="margin-left: auto; margin-right: auto;">
<tr><td colspan="4" style="text-align: center;"><h3>결제하실 도토리 : <img src="../images/도토리.png" width="20px" height="20px"><%=cnt %>개</h3></td></tr>
<tr><td colspan="4" style="text-align: center;"><h3>보유하신 도토리 : <%=dotori %>개</h3></td></tr>
<tr><td colspan="4" style="text-align: center;"><h3 id="pay">결제 후  도토리 : <%=dotori-cnt %>개</h3></td></tr>
</table>
 <section class="mini-form">
         <form>
            <div class="btn-area">
               <button type="button" id="btn">결제하기</button>
            </div>
            </form>
 </section>


</body>
</html>