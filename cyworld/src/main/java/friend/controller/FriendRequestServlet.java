package friend.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import friend.service.FriendServiceImpl;
import friend.service.IFriendService;
import vo.FriendVO;
import vo.MemberFriendVO;

@WebServlet("/friendRequest.do")
public class FriendRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		//form에서 입력한 데이터 받아오기
		String myNick = request.getParameter("myName");//나를 저장하는 별명
		String friendNick = request.getParameter("friendName");//친구를 저장하는 별명

		//로그인한 사람의 아이디(친구신청하는 사람)
		String userId = (String)session.getAttribute("userId");
		String homeId = (String)session.getAttribute("homeChk");
		//친구신청 받는 사람의 아이디
		String friendId = (String)session.getAttribute("friendId");
		String friendHomeId = (String)session.getAttribute("friendHomeId");
		
		MemberFriendVO memFriendVo = new MemberFriendVO();
		memFriendVo.setHome_id(homeId);//내홈피
		memFriendVo.setMem_id(friendId);//친구아이디 
		memFriendVo.setFriend_name(friendNick);//내홈피에서 친구의별명
		
		//내가 친구에서 일촌신청했을때 저장되는 행1(내홈피ㅣ, 친구아이디, 친구별명)
		IFriendService service = FriendServiceImpl.getInstance();
		service.requestFriend(memFriendVo);
		
		//---------------------------------------------------
		
		MemberFriendVO memFriendVo2 = new MemberFriendVO();
		memFriendVo2.setHome_id(friendHomeId);//친구홈피
		memFriendVo2.setMem_id(userId);//내아이디
		memFriendVo2.setFriend_name(myNick);//친구홈피의 내별명
		
		//내가 친구신청했을 때 친구행도 삽입(친구홈피, 내아이디, 내별명)
		service.requestFriend(memFriendVo2);
		//-------------------쿼리문 2개 insert!!!!-----------------
		
//		RequestDispatcher rd = request.getRequestDispatcher("/myMinihome/miniHomeMain.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/friend/close.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
