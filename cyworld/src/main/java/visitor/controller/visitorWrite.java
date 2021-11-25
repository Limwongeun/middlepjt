package visitor.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import visitor.service.IVisitorService;
import visitor.service.VisitorServiceImpl;
import vo.VisitorVO;


@WebServlet("/visitorWrite.do")
public class visitorWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("visitor/visitorWrite.jsp");
		disp.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		/*String visitor_no = request.getParameter("visitor_no");*/
		/*if(visitor_no==null || visitor_no.equals("")) {
			visitor_no = "0";
		}*/
		String mem_id = request.getParameter("mem_id");
		String home_id = request.getParameter("home_id");
		String visitor_date = request.getParameter("visitor_date");
		String visitor_text = request.getParameter("visitor_text");
		
		int visitor_set = 0;
		int visitor_no = 0;
		try {
			String no = request.getParameter("visitor_set");
			visitor_set = Integer.parseInt(no);
			String no1 = request.getParameter("visitor_no");
			visitor_no = Integer.parseInt(no1);
		} catch (NumberFormatException e) {
			
		}catch(Exception e) {
			
		}
		
		
		VisitorVO vo = new VisitorVO();
		/*vo.setVisitor_no(Integer.parseInt(visitor_no));*/
		vo.setVisitor_no(visitor_no);
		vo.setMem_id(mem_id);
		vo.setHome_id(home_id);
		vo.setVisitor_date(visitor_date);
		vo.setVisitor_text(visitor_text);
		vo.getVisitor_set();
		
		IVisitorService service = VisitorServiceImpl.getService();
		service.insertVisitor(vo);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		 
	
		response.sendRedirect(request.getContextPath() + "/visitorList.do");
	}

}
