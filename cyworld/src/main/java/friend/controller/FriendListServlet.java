package friend.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import friend.service.FriendServiceImpl;
import friend.service.IFriendService;
import vo.FriendVO;
import vo.MemberFriendVO;


@WebServlet("/friendList.do")
public class FriendListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String homeId = request.getParameter("home_id");
		
		IFriendService service = FriendServiceImpl.getInstance();
		
		
		List<MemberFriendVO> friendList = service.getAllFriend(homeId);
		
		request.setAttribute("friendList", friendList); //list를 받기 위해선 setAttribute
		
//		RequestDispatcher rd = 
//				request.getRequestDispatcher(arg0)
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
