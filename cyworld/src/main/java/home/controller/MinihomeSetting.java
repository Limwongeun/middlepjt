package home.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.service.HomeServiceImpl;
import home.service.IHomeService;
import member.service2.IMemberService2;
import member.service2.MemberServiceImpl2;
import vo.HomeVO;
import vo.MemberVO;

@WebServlet("/minihomeSetting.do")
public class MinihomeSetting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memId =request.getParameter("id");
		IHomeService service = HomeServiceImpl.getInstance();
		IMemberService2 service2 = MemberServiceImpl2.getInstance();
		HomeVO homeVo = service.getHomeInfo(memId);
		MemberVO memVo = service2.getMemInfo(memId);
		
		request.setAttribute("homeVo", homeVo);
		request.setAttribute("memVo", memVo);
		request.getRequestDispatcher("/myMinihome/SettingMain.jsp")
		.forward(request, response);
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
