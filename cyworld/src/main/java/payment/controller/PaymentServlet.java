package payment.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.IMemberService;
import member.service.MemberServiceImpl;

@WebServlet("/payment.do")
public class PaymentServlet extends HttpServlet {
	   private static final long serialVersionUID = 1L;

	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      request.setCharacterEncoding("utf-8");
	      response.setCharacterEncoding("utf-8");
	      response.setContentType("text/html; charset=UTF-8");
	      Map<String, String> map = new HashMap<String, String>();
	      HttpSession session = request.getSession();
	      String memId = (String) session.getAttribute("userId");
	      
		  IMemberService service = MemberServiceImpl.getService();
		  
		  map.put("mem_id", memId);
		  
		  int cnt = 0;
		try {
			cnt = service.orderDotori(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  System.out.println("cnt : " + cnt);
		  
//		  request.setAttribute("seq", cnt);
//		  request.getRequestDispatcher("/WEB-INF/view/ordered/setDotoriResult.jsp").forward(request, response);
		  
//		  RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/pay/payTest.jsp");
		  RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/pay/pay.jsp");
//	      request.getRequestDispatcher("/WEB-INF/view/pay/payTest.jsp");
		  rd.forward(request, response);
	   }

	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      doGet(request, response);
	   }

	}