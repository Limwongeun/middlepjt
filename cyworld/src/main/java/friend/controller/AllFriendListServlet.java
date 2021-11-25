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

import friend.service.FriendServiceImpl;
import friend.service.IFriendService;
import vo.MemberFriendVO;


@WebServlet("/allFriendList.do")
public class AllFriendListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String homeId = (String)session.getAttribute("homeChk");//home_id 로그인시 세션에 저장됨
		
	   //친구의 home_id
	   String friendHomeId = (String)session.getAttribute("friendHomeId");
	  
	   //친구 아이디값이 있으면 로그인세션값에서 받아온 
	   //memId, homeId를 친구의 값으로 바꿔준다 
	   if(friendHomeId!=null){
	      homeId = friendHomeId;
	   }
		
		System.out.println("homeId는 "+homeId);
		
		IFriendService service = FriendServiceImpl.getInstance();
		
		List<MemberFriendVO> friendList = service.bestFriendList(homeId);
		request.setAttribute("AllFriendList", friendList);
		
		//일촌상태가 n인값을 친구목록과 동시에 불러들어오기
		MemberFriendVO memFriendVo = new MemberFriendVO();
		memFriendVo.setHome_id(homeId);
		
		List<MemberFriendVO> sendList2 = service.sendFriend(memFriendVo);
		request.setAttribute("sendList2", sendList2);
		
//		List<MemberFriendVO> memFriendList = (List<MemberFriendVO>)request.getAttribute("AllFriendList");
		
		RequestDispatcher rd = request.getRequestDispatcher("/friend/friendList2.jsp");
		
		rd.forward(request, response);

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
