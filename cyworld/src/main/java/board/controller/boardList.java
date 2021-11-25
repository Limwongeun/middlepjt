package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import vo.BoardVO;
import vo.HomeVO;


@WebServlet("/boardList.do")
public class boardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		   String userid = (String)session.getAttribute("userId");
		   String homeId = (String)session.getAttribute("homeChk");
		   
		   //친구의 mem_id와 home_id
		   String friendId = (String)session.getAttribute("friendId");
		   String friendHomeId = (String)session.getAttribute("friendHomeId");
		  
		   //친구 아이디값이 있으면 로그인세션값에서 받아온 
		   //memId, homeId를 친구의 값으로 바꿔준다
		   if(friendId!=null){
		      userid = friendId;
		      homeId = friendHomeId;
		   }
		
	/*	HomeVO homeVo = (HomeVO) session.getAttribute("homeVo");
		System.out.println(homeVo.getHome_id());
		String home_id = homeVo.getHome_id();*/
		
		
		IBoardService service = BoardServiceImpl.getService();
		List<BoardVO> boardList = service.boardList(homeId);
		
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher rd = request.getRequestDispatcher("board/board.jsp");
		rd.forward(request, response);
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
