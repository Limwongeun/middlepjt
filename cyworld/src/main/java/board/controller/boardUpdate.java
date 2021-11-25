package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import vo.BoardVO;

@WebServlet("/boardUpdate.do")
public class boardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int boardNo = Integer.parseInt(request.getParameter("board_no"));
		
		IBoardService service = BoardServiceImpl.getService();
		BoardVO boardVo = service.getBoard(boardNo);
		
		request.setAttribute("boardVo", boardVo);
		request.getRequestDispatcher("board/update.jsp").forward(request, response);
		
		
		 
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
