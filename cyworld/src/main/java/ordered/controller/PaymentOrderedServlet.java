package ordered.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.service.CartServiceImpl;
import cart.service.ICartService;
import ordered.service.IOrderedService;
import ordered.service.OrderedServiceImpl;

@WebServlet("/paymentOrdered.do")
public class PaymentOrderedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String memId = (String) session.getAttribute("userId");
		ICartService cartService = CartServiceImpl.getInstance();
		IOrderedService orderService = OrderedServiceImpl.getInstance();
		
		
		int cnt2 = cartService.payCart(memId);
		System.out.println("cnt2 : " + cnt2);
		int cnt3 = 0;
		int cnt5 = 0;
		int cnt6 = 0;
		
		if (cnt2 != 0) {
			cnt3 = orderService.payOrdered(memId);
			System.out.println("cnt3 : " + cnt3);
			if (cnt3 != 0) {
				cnt5 = cartService.newCart();
				System.out.println("cnt5 : " + cnt5);
			} if (cnt5 != 0) {
				cnt6 = orderService.insertOrdered(memId);
				System.out.println("cnt6 : " + cnt6);
			}
		}
//		System.out.println(cnt2 + ", " + cnt3 + ", "
//				 + cnt5 + ", " + cnt6);
		System.out.println("cnt2 : " + cnt2);
		request.setAttribute("cnt", cnt2);
		request.getRequestDispatcher("/WEB-INF/view/ordered/payResult.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
