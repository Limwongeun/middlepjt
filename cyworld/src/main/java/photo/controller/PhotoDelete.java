package photo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import photo.service.IPhotoService;
import photo.service.PhotoServiceImpl;

@WebServlet("/photoDelete.do")
public class PhotoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int boardNo = Integer.parseInt(request.getParameter("delBtn"));
		System.out.println("board_no는 뭘까요  : " + boardNo);
		
		IPhotoService service = PhotoServiceImpl.getService();
		service.deleteBoard(boardNo);
		
		response.sendRedirect(request.getContextPath() + "/photoList.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
