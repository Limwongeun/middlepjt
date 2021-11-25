package member.controller;

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

@WebServlet("/createCart.do")
public class CreateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String memId = (String) session.getAttribute("userId");
		ICartService cartService = CartServiceImpl.getInstance();
		IOrderedService orderService = OrderedServiceImpl.getInstance();
	
		int cart = cartService.newCart();
		int ordered = 0;
		
		if(cart != 0) {
			ordered = orderService.insertOrdered(memId);
		}
		
		request.setAttribute("cnt", cart);
		request.getRequestDispatcher("/WEB-INF/view/ordered/payResult.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
