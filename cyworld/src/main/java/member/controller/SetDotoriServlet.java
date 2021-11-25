package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.IMemberService;
import member.service.MemberServiceImpl;

@WebServlet("/setDotori.do")
public class SetDotoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String memId = (String) session.getAttribute("userId");
		IMemberService memService = MemberServiceImpl.getService();
		
		int cnt = 0;
		int dotori = 0;
		try {
			cnt = memService.setDotori(memId);
			dotori = memService.getDotori(memId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("회원도토리변경 : " + cnt);
		session.setAttribute("userDotori", dotori);
		
		request.setAttribute("seq", cnt);
		request.getRequestDispatcher("/WEB-INF/view/ordered/setDotoriResult.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
