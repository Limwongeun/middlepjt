package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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


@WebServlet("/boardWrite.do")
public class boardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("board/write.jsp");
		disp.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int boardNo = 0;
		try {
		String no = request.getParameter("board_no");
		 boardNo = Integer.parseInt(no);
		} catch (NumberFormatException e) {
			
		}catch(Exception e) {
			
		}
		String home_id = request.getParameter("home_id");
		String writer = request.getParameter("board_writer");
		String title = request.getParameter("board_title");
		String text = request.getParameter("board_text");
		String date = request.getParameter("board_date");
		
		BoardVO vo = new BoardVO();
//		vo.setBoard_no(boardNo);
		vo.setHome_id(home_id);
		vo.setBoard_writer(writer);
		vo.setBoard_title(title);
		vo.setBoard_text(text);
		vo.setBoard_date(date);
		
		IBoardService service = BoardServiceImpl.getService();
//		int boardWrite = service.insertBoard(vo);
		service.insertBoard(vo);
		
//		request.setAttribute("boardWrite", boardWrite);
		request.setAttribute("home_id", home_id);
	//response.sendRedirect(request.getContextPath() + "/boardList.do");
		RequestDispatcher disp = request.getRequestDispatcher("/boardList.do");
		disp.forward(request, response);
		
	}

}
