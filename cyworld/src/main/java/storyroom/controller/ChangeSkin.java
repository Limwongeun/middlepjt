package storyroom.controller;
 
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import storyroom.service.IStoryService;
import storyroom.service.StoryServiceImpl;
import vo.StoryRoomVO;

@WebServlet("/changeSkin.do")
public class ChangeSkin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IStoryService service = StoryServiceImpl.getInstance();
	StoryRoomVO storyVo = new StoryRoomVO();
	Map<String, String> map = new HashMap<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String homeId = (String)session.getAttribute("homeChk");
		String prodId = request.getParameter("prod_id");
		
		map.put("home_id", homeId);
		map.put("prod_id", prodId);
		
		service.changeSkinN(map);
		service.changeSkinY(map);
		
		request.getRequestDispatcher("/myMinihome/itemSet.jsp")
		.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
