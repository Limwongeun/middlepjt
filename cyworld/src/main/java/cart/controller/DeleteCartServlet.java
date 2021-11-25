package cart.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

@WebServlet("/deleteCart.do")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String memId = (String) session.getAttribute("userId");
		String pridId = request.getParameter("prodId");
		ICartService service = CartServiceImpl.getInstance();
		IOrderedService serviceOrder = OrderedServiceImpl.getInstance();
		Map<String, String> map = new HashMap<String, String>();
		map.put("memId", memId);
		map.put("prodId", pridId);
		int cnt = service.delCart(map);
		int cntOrder = serviceOrder.updateOrdered(memId);
		request.setAttribute("seq", cnt);
		request.getRequestDispatcher("/WEB-INF/view/cart/deleteCartResult.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
