package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/boardManager.do")
public class BoardManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
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
		
		RequestDispatcher rd = request.getRequestDispatcher("/myMinihome/boardManager.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
