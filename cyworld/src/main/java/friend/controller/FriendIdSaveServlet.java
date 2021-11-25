package friend.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import home.service.HomeServiceImpl;
import home.service.IHomeService;
import vo.HomeVO;

@WebServlet("/friendIdSave.do")
public class FriendIdSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//friendSearch에서 mem_id 파라미터값으로 받아오기
		String friendId = request.getParameter("mem_id");
		
		//friendId의 homeId값 찾아오기
		IHomeService service = HomeServiceImpl.getInstance();
		HomeVO homeVo = service.getHomeInfo(friendId);
		String friendHomeId = homeVo.getHome_id();
		System.out.println("mem_id가 잘 들어왔니?"+friendId);
		System.out.println("mem_id가 잘 들어왔니?"+friendHomeId);
		
		
		
		//friend의 mem_id와 home_id값 session에 저장하기
		//세션생성
		HttpSession session = request.getSession(); 
		
		session.setAttribute("friendId", friendId);
		session.setAttribute("friendHomeId", friendHomeId);
		
		RequestDispatcher rd = 
				request.getRequestDispatcher("/myMinihome/miniHomeMain.jsp");

		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
