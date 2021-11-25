package visitor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import visitor.service.IVisitorService;
import visitor.service.VisitorServiceImpl;
import vo.HomeVO;
import vo.VisitorVO;


@WebServlet("/visitorList.do")
public class visitorList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		HomeVO homeVo = (HomeVO) session.getAttribute("homeVo");
		System.out.println(homeVo.getHome_id());
		String home_id = homeVo.getHome_id();
	
		IVisitorService service = VisitorServiceImpl.getService();
		List<VisitorVO> visitorList = service.visitorList(home_id);
		
		request.setAttribute("visitorList", visitorList);
		
		RequestDispatcher rd = request.getRequestDispatcher("visitor/visitor.jsp");
		rd.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
