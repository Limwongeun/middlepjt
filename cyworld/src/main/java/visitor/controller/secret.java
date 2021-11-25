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


@WebServlet("/secret.do")
public class secret extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String visitor_set = request.getParameter("visitor_set");
		
		int visitor_no = 0;
		try {
		String no = request.getParameter("visitor_no");
		visitor_no = Integer.parseInt(no);
		} catch (NumberFormatException e) {
			
		}catch(Exception e) {
			
		}
		
		VisitorVO vo = new VisitorVO();
		vo.setVisitor_no(visitor_no);
		vo.setVisitor_set(2);
		
		IVisitorService service = VisitorServiceImpl.getService();
		int cnt = service.updateSecret(vo);
		
		Gson gson = new Gson();
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
