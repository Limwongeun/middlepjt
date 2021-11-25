<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
<style>
.button{
     max-width: 550px;
    height: 350px;
    margin: 0 auto;
    padding: 120px 80px;
}
.tbl01 tbl_m{
   max-width: 550px;
    height: 350px;
    margin: 0 auto;
    padding: 120px 80px;
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
 <title>Insert title here</title>
 

<script src="../js/jquery-3.6.0.min.js"></script>
</head>
<body>

 <div id="subCont">
    <div class="scont_wrap">
    

     
     
     
     <div class="subcontents">
       <div id="location">
         <h2>이용권 결제</h2>
       </div>
       <div id="cont_wrap">
       <div class="mytashuArea">
         
         
     <form class="a" action = "<%=request.getContextPath() %>/payment.do"> 
     
      <div class = "pay">
      <li data-type="monthly" class="is-visible">
          <header class="pricing-header">
            <h2>10개</h2>
            <div class="price">
              <img src="../images/1개.png" width="300px" height="300px"><br>
              <span class="value">1,000</span>
              <span class="duration">원</span>
            </div>
          </header>
          <footer class="pricing-footer"><br><br><br><br><br>
               <input class="b" type="checkbox" id="voucher_id" name =1 value="1">선택
               <input type="hidden" id="price" name=1000 value=1000>
               <input type="hidden" id="qty" name="qty" value=10>
          </footer>
        </li>
      </div>
      
      
      <div class = "pay">
      <li data-type="monthly" class="is-visible">
          <header class="pricing-header">
            <h2>30개</h2>
            <div class="price">
             <img src="../images/2개.png" width="300px" height="300px"><br>
              <span class="value">2,900</span>
              <span class="duration">원</span>
            </div>
          </header>
          <footer class="pricing-footer"><br><br><br><br><br>
           <input class="b" type="checkbox" id="voucher_id" name =2 value="2">선택
           <input type="hidden" id="price" name=2900 value=2900>
           <input type="hidden" id="qty" name="qty" value=30>
          </footer>
        </li>
      </div>
      
      <div class = "pay">
      <li data-type="monthly" class="is-visible">
          <header class="pricing-header">
            <h2>50개</h2>
            <div class="month">
             <img src="../images/3개.png" width="300px" height="300px"><br>
              <span class="value">4,500</span>
              <span class="duration">원</span>
            </div>
          </header>
          <footer class="pricing-footer"><br><br><br><br><br>
             <input class="b" type="checkbox" id="voucher_id" name =3 value="3">선택
             <input type="hidden" id="price" name=4500 value=4500>
             <input type="hidden" id="qty" name="qty" value=50>
          </footer>
        </li>
      </div>
      
     <div class = "pay">
      <li data-type="monthly" class="is-visible">
          <header class="pricing-header">
            <h2>100개</h2>
            <div class="price">
            <img src="../images/4개.png" width="300px" height="300px"><br>
              <span class="value">9,000</span>
              <span class="duration">원</span>
            </div>
          </header>
          <footer class="pricing-footer"><br><br><br><br><br>
               <input class="b" type="checkbox" id="voucher_id" name =4 value="4">선택
               <input type="hidden" id="price" name=9000 value=9000>
               <input type="hidden" id="qty" name="qty" value=100>
          </footer>
        </li>
      </div>
      
      
      <div class = "pay">
      <li data-type="monthly" class="is-visible">
          <header class="pricing-header">
            <h2>150개</h2>
            <div class="price">
             <img src="../images/5개.png" width="300px" height="300px"><br>
              <span class="value">13,000</span>
              <span class="duration">원</span>
            </div>
          </header>
          <footer class="pricing-footer"><br><br><br><br><br>
           <input class="b" type="checkbox" id="voucher_id" name =5 value="5">선택
           <input type="hidden" id="price" name=13000 value=13000>
           <input type="hidden" id="qty" name="qty" value=150>
          </footer>
        </li>
      </div>
      
      <div class = "pay">
      <li data-type="monthly" class="is-visible">
          <header class="pricing-header">
            <h2>300개</h2>
            <div class="month">
             <img src="../images/6개.png" width="300px" height="300px"><br>
              <span class="value">20,000</span>
              <span class="duration">원</span>
            </div>
          </header>
          <footer class="pricing-footer"><br><br><br><br><br>
             <input class="b" type="checkbox" id="voucher_id" name =6 value="6">선택
             <input type="hidden" id="price" name=20000 value=20000>
             <input type="hidden" id="qty" name="qty" value=300>
          </footer>
        </li>
      </div>
      
         <br><br><br>
         <form action="<%=request.getContextPath()%>/WEB-INF/view/pay/payTest.jsp">
            <div class = "button1" >
            <input class="c" type="submit" id="check" value = "확인" >
            <input class="c" type="reset" value = "취소">
            </div>
         </form>
            
         </form>   
           
           
           
           
         </div>
       </div>
     </div>
    </div>
  </div>

  
  

</body>
</html>