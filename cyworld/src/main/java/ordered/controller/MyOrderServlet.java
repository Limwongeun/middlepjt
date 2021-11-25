//package ordered.controller;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import member.dao2.IMemberDao2;
//import member.dao2.MemberDaoImpl2;
//import ordered.service.IOrderedService;
//import ordered.service.OrderedServiceImpl;
//import vo.MemberVO;
//import vo.OrderedVO;
//
//@WebServlet("/myOrder.do")
//public class MyOrderServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		HttpSession session = request.getSession();
//		String memId = (String) session.getAttribute("userId");
//		IOrderedService service = OrderedServiceImpl.getInstance();
//		OrderedVO vo = service.myOrder(memId);
//		request.setAttribute("OrderVo", vo);
//		IMemberDao2 dao = MemberDaoImpl2.getInstance();
//		MemberVO memVo = dao.getMemInfo(memId);
//		request.setAttribute("memVo", memVo);
//		
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cart/cartList.jsp");
//		rd.forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}
