package visitor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import visitor.service.IVisitorService;
import visitor.service.VisitorServiceImpl;
import vo.VisitorVO;


@WebServlet("/userVisitorUpdate.do")
public class userVisitorUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int visitor_no = 0;
		try {
		String no = request.getParameter("visitor_no");
		visitor_no = Integer.parseInt(no);
		} catch (NumberFormatException e) {
			
		}catch(Exception e) {
			
		}
		
		String visitor_text = request.getParameter("visitor_text");
		
		VisitorVO vo = new VisitorVO();
		vo.setVisitor_no(visitor_no);
		vo.setVisitor_text(visitor_text);
		
		IVisitorService service = VisitorServiceImpl.getService();
		int updateVisitor = service.updateVisitor(vo);
		
		VisitorVO visitorNo = service.selectVisitor(visitor_no);
		
		
		 Gson gson = new Gson();
		 
		 String visitorJson = gson.toJson(visitorNo);
		 response.setCharacterEncoding("utf-8");
		 response.getWriter().print(visitorJson); response.flushBuffer();
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
