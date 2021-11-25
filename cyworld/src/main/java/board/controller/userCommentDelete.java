package board.controller;

import java.io.IOException;

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


@WebServlet("/userCommentDelete.do")
public class userCommentDelete extends HttpServlet {
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
		
		Gson gson = new Gson();
		IBoardService service = BoardServiceImpl.getService();
		int cnt = service.deleteReply(comment_no);
		String jsonStr = "";
		if(cnt>0) {
			jsonStr = gson.toJson("ok");
		}else {
			jsonStr = gson.toJson("fail");
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jsonStr);
		response.flushBuffer();
		
		
		
	}

}
