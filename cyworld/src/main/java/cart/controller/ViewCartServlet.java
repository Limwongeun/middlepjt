package cart.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.service.CartServiceImpl;
import cart.service.ICartService;
import member.dao.IMemberDao;
import member.dao.MemberDaoImpl;
import ordered.service.IOrderedService;
import ordered.service.OrderedServiceImpl;
import vo.CartVO;
import vo.OrderedVO;

@WebServlet("/viewCart.do")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ICartService service = CartServiceImpl.getInstance();
		HttpSession session = request.getSession();
		
		List<CartVO> list = service.listCart((String) session.getAttribute("userId"));
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getProd_id().contains("g0")){
				String a = list.get(i).getProd_url();
				a = a.replace(".mp3", ".jpg");
				a = a.replace("mp3", "images");
				list.get(i).setProd_url(a);
			} 
		}
		String memId = (String) session.getAttribute("userId");
		IOrderedService service1 = OrderedServiceImpl.getInstance();
		OrderedVO vo = service1.myOrder(memId);
		request.setAttribute("OrderVo", vo);
//		IMemberDao2 dao = MemberDaoImpl2.getInstance();
//		MemberVO memVo = dao.getMemInfo(memId);
		IMemberDao dao2 = MemberDaoImpl.getDao();
		
		int dotori = 0;
		try {
			dotori = dao2.getDotori(memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("도토리 : " + dotori);
		
		request.setAttribute("dotori", dotori);
		
		request.setAttribute("cartList", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cart/cartList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
