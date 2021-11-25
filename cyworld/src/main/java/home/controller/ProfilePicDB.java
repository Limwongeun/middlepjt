package home.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.service.HomeServiceImpl;
import home.service.IHomeService;
import vo.HomeVO;


@WebServlet("/profilePicDB.do")
public class ProfilePicDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IHomeService service = HomeServiceImpl.getInstance();
    HomeVO homeVo = new HomeVO();
    Map<String, String> map = new HashMap<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String imgName =(String) request.getAttribute("imgName");
		String homeId = (String) request.getAttribute("homeId");
		map.put("img_name", imgName);
		map.put("home_id", homeId);
		
		service.profileImgUpdate(map);
		
		
		request.getRequestDispatcher("/myMinihome/miniHomeContents.jsp")
		.forward(request, response);
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
