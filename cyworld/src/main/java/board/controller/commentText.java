package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import vo.ReplyVO;


@WebServlet("/commentText.do")
public class commentText extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		
		int board_no = 0;
		try {
		String no = request.getParameter("board_no");
		board_no = Integer.parseInt(no);
		} catch (NumberFormatException e) {
			
		}catch(Exception e) {
			
		}
		
		
		String mem_id = request.getParameter("mem_id");
		String comment_text = request.getParameter("comment_text");
		String comment_date = request.getParameter("comment_date");

		
		ReplyVO vo = new ReplyVO();
		vo.setBoard_no(board_no);
		vo.setMem_id(mem_id);
		vo.setComment_gu("1");
		vo.setComment_text(comment_text);
		vo.setComment_date(comment_date);
		
		IBoardService service = BoardServiceImpl.getService();
		int comment_no = service.insertComment(vo);
		
		ReplyVO reply = service.getReply(comment_no, board_no);
		Gson gson = new Gson();
		
		String replyJson = gson.toJson(reply);
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(replyJson);
		response.flushBuffer();
		
		
		
	}

}
