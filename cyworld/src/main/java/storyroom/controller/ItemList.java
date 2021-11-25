package storyroom.controller;
 
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import storyroom.service.IStoryService;
import storyroom.service.StoryServiceImpl;
import vo.StoryRoomVO;


@WebServlet("/itemList.do")
public class ItemList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String homeId = (String)session.getAttribute("homeChk");
		System.out.println("홈ID값" + homeId);
		IStoryService service = StoryServiceImpl.getInstance();
		
		List<StoryRoomVO> minimiList = service.myListMinimi(homeId);
		request.setAttribute("minimiList", minimiList);
		
		List<StoryRoomVO> skinList = service.myListSkin(homeId);
		request.setAttribute("skinList", skinList);
		
		List<StoryRoomVO> storyroomList = service.myListStoryroom(homeId);
		request.setAttribute("storyroomList", storyroomList);
		
		List<StoryRoomVO> bgmList = service.myListBgm(homeId);
		request.setAttribute("bgmList", bgmList);

		RequestDispatcher rd = request.getRequestDispatcher("/myMinihome/itemSet.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
