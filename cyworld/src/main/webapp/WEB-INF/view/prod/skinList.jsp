<%@page import="vo.ProdVO"%>
<%@page import="vo.ProdImgVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style5.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	
$('.goCart').on('click',function(){

    var prodId = $(this).attr('name');
    console.log(prodId)
    
    $.ajax({
       url : '/insertSkin.do',
       data : {'prodId' : prodId},
       success : function(res){
          if(res.sw == 'no'){
        	  alert("해당 상품은 이미 보유 중이거나 장바구니에 담긴 상품입니다.");
        	  return false;
          }
          alert("장바구니에 담았습니다.");
          //성공 시 장바구니에 담는 서블릿
          location.href="<%=request.getContextPath()%>/skinList.do";
       },
       error : function(xhr){
          alert(xhr.status)
       },
       dataType : 'json'
    })
    
 });
})

</script>
</head>
<body>
<%
	List<ProdImgVO> imgList = (List<ProdImgVO>)request.getAttribute("imgList");
	List<ProdVO> nmList = (List<ProdVO>)request.getAttribute("nmList");
%>
<table id="tb" style="margin-left: auto; margin-right: auto;">
<tr>
	<td colspan="4" style="text-align: center;"><br><h2>SKIN</h2><br></td>
</tr>
<tr>
<%
if(imgList == null || imgList.size() == 0){
%>
<td colspan="4">상품이 없습니다.</td></tr>
<%	
} else {
	for(int i=0; i<imgList.size(); i++){
		if(imgList.get(i).getProd_id().contains("s0")){
// 			if(DoList.get(i).getProd_price() == 0){
// 				i++;
			if(i % 3 == 2){
%>
					<form>
						<td>
						<img src="<%=imgList.get(i).getProd_url() %>" height="200px" width="300px"><br>
						<%=nmList.get(i).getProd_name() %><br>
						<img src="../images/도토리.png" width="15px" height="15px"><%=nmList.get(i).getProd_price() %>
						<br>
						<input type="button" name="<%=imgList.get(i).getProd_id()  %>" class="goCart" value="장바구니 담기" style="float: right;">
						</td>
					</form>
				</tr><tr>
<%
			} else {
%>
			<form>
				<td>
				<img src="<%=imgList.get(i).getProd_url() %>" height="200px" width="300px"><br>
				<%=nmList.get(i).getProd_name() %><br>
				<img src="../images/도토리.png" width="15px" height="15px"><%=nmList.get(i).getProd_price() %>
				<br>
				<input type="button" name="<%=imgList.get(i).getProd_id()  %>" class="goCart" value="장바구니 담기" style="float: right;">
				</td>
			</form>
				<%
			}
		}
	}
// }
%>
</tr>
<%
}
%>
</table>
</body>
</html>