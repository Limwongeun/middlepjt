package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import vo.ReplyVO;


@WebServlet("/userCommentUpdate.do")
public class userCommentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int comment_no  = 0;
		try {
		String no = request.getParameter("commentNo");
		comment_no = Integer.parseInt(no);
		} catch (NumberFormatException e) {
			
		}catch(Exception e) {
			
		}
		
		
		String comment_text = request.getParameter("commentText");
		
		ReplyVO vo = new ReplyVO();
		
		vo.setComment_no(comment_no);
		vo.setComment_text(comment_text);
		
		IBoardService service = BoardServiceImpl.getService();
		 int updateReply = service.updateReply(vo);	// 업데이트 완료
	
		// 업데이트 뿌려주기
		ReplyVO updateSelectReply = service.getUpdateSelectReply(comment_no);
		
		
		Gson gson = new Gson();
		
		String replyJson = gson.toJson(updateSelectReply);
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(replyJson);
		response.flushBuffer();
		
		
		
	}

}
