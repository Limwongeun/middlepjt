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


@WebServlet("/friendDelete.do")
public class FriendDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 
		//삭제할 id
		String memId = request.getParameter("mem_id");
		System.out.println("mem_id는"+memId);
		
		HttpSession session = request.getSession();
     	String homeId = (String)session.getAttribute("homeChk");
		
		MemberFriendVO memFriendVo = new MemberFriendVO();
		memFriendVo.setMem_id(memId);
		memFriendVo.setHome_id(homeId);
		
		IFriendService service = FriendServiceImpl.getInstance();
		service.deleteFriend(memFriendVo);//delete하기
		
		
		List<MemberFriendVO> friendList = service.friendList(homeId);
		request.setAttribute("AllFriendList", friendList);
		
//		List<MemberFriendVO> memFriendList = (List<MemberFriendVO>)request.getAttribute("AllFriendList");
		
		RequestDispatcher rd = request.getRequestDispatcher("/friend/friendList2.jsp");
		
		rd.forward(request, response);
		//목록으로 이동
//		response.sendRedirect(request.getContextPath()+"/allFriendList.do");
		//response.sendRedirect("/cyworld/myMinihome/SettingMain.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
