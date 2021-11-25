package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDaoImpl;
import board.dao.IBoardDao;
import board.service.BoardServiceImpl;
import board.service.IBoardService;
import vo.BoardVO;
import vo.ReplyVO;


@WebServlet("/boardNo.do")
public class boardNo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int boardNo = Integer.parseInt(request.getParameter("board_no"));
		
		IBoardService service = BoardServiceImpl.getService();
		BoardVO boardVo = service.getBoard(boardNo);
		
		List<ReplyVO> replyList = service.getAllReply(boardNo);
	
		request.setAttribute("boardVo", boardVo);
		request.setAttribute("replyList", replyList);
		
		request.getRequestDispatcher("board/boardView.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
