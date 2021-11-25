package photo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import photo.service.IPhotoService;
import photo.service.PhotoServiceImpl;
import vo.PhotoVO;

@WebServlet("/photoList.do")
public class PhotoList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userId");
		String homeId = (String)session.getAttribute("homeChk");

		//친구의 mem_id와 home_id
		String friendId = (String)session.getAttribute("friendId");
		String friendHomeId = (String)session.getAttribute("friendHomeId");


		//친구의 미니홈피 방문시 friendId = userid
		if(friendId!=null){
		   userid = friendId;
		   homeId = friendHomeId;
		}
		
		
		
		
		IPhotoService service = PhotoServiceImpl.getService();
		List<PhotoVO> boardList = service.boardList(homeId);
		
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher rd = request.getRequestDispatcher("photo/photo.jsp");
		rd.forward(request, response);
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
