package friend.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import friend.service.FriendServiceImpl;
import friend.service.IFriendService;
import vo.HomeVO;
import vo.MemberFriendVO;

@WebServlet("/friendAccept.do")
public class FriendAcceptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		//일촌 신청을 보낸 사람의 id를 찾아오기(내가 수락을 눌렀을 때의  id)
		String memId = request.getParameter("id"); 
		System.out.println("memId : " + memId);
		String homeId = (String) session.getAttribute("homeChk");//로그인한 사람의 홈피
		System.out.println("memId : " + homeId);
		String userId = (String)session.getAttribute("userId");
		System.out.println("memId : " + userId);
		
		MemberFriendVO memfriendVo = new MemberFriendVO();

		//내가 수락하면 나 update
		memfriendVo.setHome_id(homeId); 
		memfriendVo.setMem_id(memId);

		IFriendService service = FriendServiceImpl.getInstance();
		service.acceptFriend(memfriendVo);
		
		//일촌신청을 보낸 사람도 같이 update됨
		MemberFriendVO memfriendVo2 = new MemberFriendVO();
		

		List<HomeVO> meminfoList = 	service.memInfo(memId);

		String homeId2="";//일촌요청자의 홈피id
		for(HomeVO meminfo: meminfoList) {
			homeId2 = meminfo.getHome_id();
		}
		System.out.println("homeId2 : "+homeId2);
		
		memfriendVo2.setHome_id(homeId2);
		memfriendVo2.setMem_id(userId);

		service.acceptFriend(memfriendVo2);

		//시도1)일촌신청목록 불러오는 sendList session을 다시 저장할 수 있나>???->실패
//		MemberFriendVO memfriendVo3 = new MemberFriendVO();
//		memfriendVo3.setHome_id(homeId);//로그인한 사람의 홈피
//
//		List<MemberFriendVO> sendList2 = service.sendFriend(memfriendVo3);
//		session.setAttribute("sendList", sendList2);
		
		//시도2)일촌신청목록이 자동으로 새로고침 될 수 있게...
		//일촌상태가 n인값을 친구목록과 동시에 불러들어오기
		MemberFriendVO memFriendVo = new MemberFriendVO();
		memFriendVo.setHome_id(homeId);
		
		List<MemberFriendVO> sendList2 = service.sendFriend(memFriendVo);
		request.setAttribute("sendList2", sendList2);
		
		RequestDispatcher rd = request.getRequestDispatcher("/friend/friendList2.jsp");
		rd.forward(request, response);
//		RequestDispatcher rd = request.getRequestDispatcher("<%=requst.getContextPath%>/allFriendList.do");
//		response.sendRedirect(request.getContextPath()+"/allFriendList.do");


		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
