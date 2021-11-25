package home.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import home.service.HomeServiceImpl;
import home.service.IHomeService;
import member.service2.IMemberService2;
import member.service2.MemberServiceImpl2;
import vo.HomeVO;
import vo.MemberVO;


@WebServlet("/miniHomeMain.do")
public class MiniHomeMain extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
//		String memId =request.getParameter("userid");
		
		String memId = (String)session.getAttribute("userId");
		String friendId = (String)session.getAttribute("friendId");
		
		System.out.println("memID : "+memId+",friendId : "+friendId);
		
		if(friendId !=null) {
			memId = friendId;
		}
		
		IHomeService service = HomeServiceImpl.getInstance();
		IMemberService2 service2 = MemberServiceImpl2.getInstance();
		HomeVO homeVo = service.getHomeInfo(memId);
//		session.setAttribute("homeVo", homeVo);
		MemberVO memVo = service2.getMemInfo(memId);
		System.out.println(memId);
		System.out.println(homeVo.getHome_count());
		System.out.println(homeVo.getHome_id());
		
//		request.setAttribute("homeVo", homeVo);
//		request.setAttribute("memVo", memVo); 
		request.getRequestDispatcher("/myMinihome/miniHomeMain.jsp")
		.forward(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
