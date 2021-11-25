package home.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service2.IMemberService2;
import member.service2.MemberServiceImpl2;
import vo.MemberVO;


@WebServlet("/memInfo.do")
public class MemberInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memId =request.getParameter("id");
		IMemberService2 service = MemberServiceImpl2.getInstance();
		MemberVO memVo = service.getMemInfo(memId);
		request.setAttribute("memVo", memVo);
		request.getRequestDispatcher("/myMinihome/linkToMinihome.jsp")
		.forward(request, response);
 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); 
	}

}
