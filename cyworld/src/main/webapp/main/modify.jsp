<%@page import="java.awt.PageAttributes.OrientationRequestedType"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원정보수정</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="../js/memberReg.js"></script>
<script src="../js/jquery.serializejson.min.js"></script>
<script   src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
   $(function() {
      // $(document).ready(function(){
      //  })   

      //    /* id 중복검사 */
      //    $('#idChk').on('click', function(){

      /* 실시간체크  - 비밀번호 */
      $('#pass').on('keyup', function() {

         passValue = $('#pass').val().trim();

         //입력확인
         if (passValue.length < 1) {
            nopro(this, "비밀번호을 입력하세요");
            return;
         }

         //글자수 체크
         /* if(nameValue.length < 2 || nameValue.length > 5){
            nopro(this, "2~5자 사이로 입력하세요");
            return;
         } */

         //정규식- 영문대소문자, 특수문자, 숫자가 반드시 1개 이상 존재해야 함
         //전방탐색 : 찾을문자?=기준문자
         //  '.(dot)':임의의 문자 , '*?' : 적게 일치하는 (* 0개 이상, + 1개 이상)  
         regPass = /^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*()-+]).{8,}$/;

         if (regPass.test(passValue)) {
            okpro(this);
         } else {
            nopro(this, "소문자,특수문자,숫자를 1개이상 입력해야 합니다(8자리 이상)");
         }
      })

      /* 실시간체크  - 비밀번호 확인 */
      $('#pass1').on('keyup',   function() {

         passValue = $('#pass1').val().trim();

         //입력확인
         if (passValue.length < 1) {
            nopro(this, "비밀번호을 입력하세요");
            return;
         }

         //글자수 체크
         /* if(nameValue.length < 2 || nameValue.length > 5){
            nopro(this, "2~5자 사이로 입력하세요");
            return;
         } */

         //정규식- 영문대소문자, 특수문자, 숫자가 반드시 1개 이상 존재해야 함
         //전방탐색 : 찾을문자?=기준문자
         //  '.(dot)':임의의 문자 , '*?' : 적게 일치하는 (* 0개 이상, + 1개 이상)  
         regPass = /^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*()-+]).{8,}$/;

         if (regPass.test(passValue)) {
            if ($('#pass').val().trim() == $('#pass1')
                  .val().trim()) {
               okpro(this);
            } else if ($('#pass').val().trim() != $('#pass1').val().trim()) {
               nopro1(this, "비밀번호가 서로 일치하지 않습니다.");
            }
         } else {
            nopro(this,"소문자,특수문자,숫자를 1개이상 입력해야 합니다(8자리 이상)");
         }
      })

      /* 실시간체크  - 휴대폰 */
      $('#hp').on('keyup', function() {

         hpValue = $('#hp').val().trim();

         //정규식- 010-111-2222 또는 010-3333-4444
         regHp = /^[0-9]{3}-[0-9]{3,4}-[0-9]{4}$/;

         if (regHp.test(hpValue)) {
            okpro(this);
         } else {
            nopro(this, "올바른 형식이 아닙니다");
         }
      })

      /* 실시간체크  - 이메일 */
      $('#mail').on('keyup', function() {

         mailValue = $('#mail').val().trim();

         //정규식- 123abc A123 a123 a3dA @naver @daum @zeroto7 .com .co.kr
         regMail = /^[0-9a-zA-Z]+@[0-9a-zA-Z]+(\.[a-z]+){1,2}$/;

         if (regMail.test(mailValue)) {
            okpro(this);
         } else {
            nopro(this, "올바른 형식이 아닙니다");
         }
      })

      $('#btn').on('click', function() {

         //       event.preventDefault();

         //입력 값 가져오기 - val() - 5개 (id, pass, hp, mail... )

         //jquery serialize 
         //:form value를 한번에 전송 가능한 data로 만들어준다
         //:form 데이터의 name을 vo필드명으로 작성해야 한다

         data = $('#frm').serializeJSON();

         $.ajax({
            url : '/modifyResult.do',
            type : 'post',
            data : data,
            success : function(res) {
               if (res.sw == 'ok') {
                  code = `수정성공`;
               } else {
                  code = `수정실패`;
               }
               $('#midifysp').html(code).css('color', 'blue');
//                $('#cancel').html(code).css('color', 'red');
               location.href="/main/index.jsp"
            },
            error : function(xhr) {
               alert(xhr.status);
            },
            dataType : 'json'
         })

      })

   })
   function findAddr() {
      new daum.Postcode({
         oncomplete : function(data) {

            console.log(data);

            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var jibunAddr = data.jibunAddress; // 지번 주소 변수
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('mem_zip').value = data.zonecode;
            if (roadAddr !== '') {
               document.getElementById("member_addr1").value = roadAddr;
            } else if (jibunAddr !== '') {
               document.getElementById("member_addr1").value = jibunAddr;
            }
         }
      }).open();
   }
   function cancel(){
        location.href = request.getContextPath()+"/main/index.jsp";
   }
</script>
<style>
#logo {
   width: 100px;
   height: 100px;
}
</style>
</head>
<body>
<%
   MemberVO vo = (MemberVO)request.getAttribute("result");
   String id = vo.getMem_id();
   String name = vo.getMem_name();
   String birth = vo.getMem_bir();
   
   String pass = vo.getMem_pass();
   String mail = vo.getMem_mail();
   String hp = vo.getMem_tel();
   String member_addr1 = vo.getMem_addr1();
   String member_addr2 = vo.getMem_addr2();
   String member_zip = vo.getMem_zip();

   System.out.println(id);
   System.out.println(pass);
   System.out.println(mail);
   System.out.println(hp);
   System.out.println(member_addr1);
   System.out.println(member_addr2);
   System.out.println(member_zip);
   

%>
   <div class="container">

      <h2 style="text-align: center;">
         <img alt="cylogo" src="../images/cy_logo.png" id="logo">회원정보 수정
      </h2>
      <br>
      <br>
      <br>

      <form class="form-horizontal" id="frm" name="frm">
         <div class="form-group">
            <label class="control-label col-sm-2" for="id">아이디</label> 
            <span class="sp"></span>
            <div class="col-sm-4">
               <input type="hidden" id ="mem_id" name="mem_id" value="<%=id%>"/>
               <%=id %>
            </div>
            <span id="res"></span>
         </div>

         <div class="form-group">
            <label class="control-label col-sm-2" for="name">이름</label>
            <div class="col-sm-4">
               <%=name %>
            </div>
            <span class="sp"></span>
         </div>

         <div class="form-group">
            <label class="control-label col-sm-2" for="bir">생년월일</label>
            <div class="col-sm-4">
               <%=birth %>
            </div>
         </div>

         <div class="form-group">
            <label class="control-label col-sm-2" for="pass">비밀번호</label>
            <div class="col-sm-4">
               <input type="password" class="form-control" id="pass"
                  name="mem_pass">
            </div>
            <span class="sp"></span>
         </div>

         <div class="form-group">
            <label class="control-label col-sm-2" for="pass1">비밀번호 확인</label>
            <div class="col-sm-4">
               <input type="password" class="form-control" id="pass1"
                  name="mem_pass1">
            </div>
            <span class="sp"></span>
         </div>


         <div class="form-group">
            <label class="control-label col-sm-2" for="hp">핸드폰</label>
            <div class="col-sm-4">
               <input class="form-control" id="hp" name="mem_tel"
                  placeholder="010-0000-0000">
            </div>
            <span class="sp"></span>
         </div>


         <div class="form-group">
            <label class="control-label col-sm-2" for="mail">이메일</label>
            <div class="col-sm-4">
               <input type="email" class="form-control" id="mail" name="mem_mail">
            </div>
            <span class="sp"></span>
         </div>

         <!-- 주소검색 테스트 -->
         <div class="form-group">
            <!--       <label class="control-label col-sm-2" for="zip">우편번호</label> -->
            <label class="control-label col-sm-2">우편번호</label>
            <div class="col-sm-1">
               <input class="form-control" id="mem_zip" name="mem_zip">
            </div>
            <button type="button" id="member_post" onclick="findAddr();"
               class="btn btn-info" value="우편번호">우편번호 검색</button>

         </div>
         <div class="form-group">
            <label class="control-label col-sm-2" for="add1">주소</label>
            <div class="col-sm-5">
               <input class="form-control" id="member_addr1" name="mem_addr1">
            </div>
         </div>

         <div class="form-group">
            <label class="control-label col-sm-2" for="add2">상세주소</label>
            <div class="col-sm-5">
               <input class="form-control" id="member_addr2" name="mem_addr2">
            </div>
         </div>

         <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
               <!--         <button type=submit class="btn btn-primary">Submit</button> -->
               <button type=button class="btn btn-primary" id="btn">수정하기</button>
               <span id="midifysp"></span>
<%--                <button type=button class="btn btn-primary" id="btn" onclick="location.href='<%=request.getContextPath()%>/main/index.jsp' ">취소하기</button> --%>
               <button type=button class="btn btn-primary" id="btn" onclick="window.open('/main/index.jsp') ">취소하기</button>
               <span id="cancel"></span>
            </div>
         </div>
      </form>
   </div>


</body>
</html>