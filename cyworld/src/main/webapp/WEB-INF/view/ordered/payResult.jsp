<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int cnt = (Integer)request.getAttribute("cnt");
if(cnt >= 1){
%>   
   {
      "mw":"ok",
      "cnt":"<%=cnt%>"
   }
<%   
}else{
%>   
   {
      "mw":"no"
   }
<%   
}
%>