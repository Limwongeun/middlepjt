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


@WebServlet("/boardUpdate2.do")
public class boardUpdate2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int board_no = 0;
		try {
		String no = request.getParameter("board_no");
		board_no = Integer.parseInt(no);
		} catch (NumberFormatException e) {
			
		}catch(Exception e) {
			
		}
		
		String board_title = request.getParameter("board_title");
		String board_text = request.getParameter("board_text");
		
		BoardVO vo = new BoardVO();
		vo.setBoard_no(board_no);
		vo.setBoard_title(board_title);
		vo.setBoard_text(board_text);
		
		IBoardService service = BoardServiceImpl.getService();
		service.updateBoard(vo);
		
		response.sendRedirect(request.getContextPath() + "/boardList.do");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
