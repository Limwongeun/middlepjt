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

@WebServlet("/friendSearch.do")
public class FriendSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");
	      response.setCharacterEncoding("utf-8");
	      
	      HttpSession session = request.getSession();
	      String mem_id= (String)session.getAttribute("userId");

	      //폼에서 입력한 데이터
	      String mem_name = request.getParameter("search_name");
	      
	      MemberFriendVO memFriendVo = new MemberFriendVO();
	      memFriendVo.setMem_id(mem_id);
	      memFriendVo.setMem_name(mem_name);
	      
	      IFriendService service = FriendServiceImpl.getInstance();
	      	   
	      List<MemberFriendVO> friendList = service.friendSearch(memFriendVo); 
	      request.setAttribute("SearchFriendList", friendList);
	      request.setAttribute("search_name", mem_name);
	      
	      RequestDispatcher rd = request.getRequestDispatcher("/friend/friendSearch.jsp");
			
		  rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
