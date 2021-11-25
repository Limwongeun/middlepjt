package mypage.controller;

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

import mypage.service.IMypageService;
import mypage.service.MypageServiceImpl;

@WebServlet("/insertProd.do")
public class InsertProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String memId = (String) session.getAttribute("userId");
		IMypageService myService = MypageServiceImpl.getInstance();
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_id", memId);
		
		int cnt = myService.insertProd(map);
		
		System.out.println("마이페이지 : " + cnt);
//		request.setAttribute("seq", cnt);
//		request.getRequestDispatcher("/WEB-INF/view/ordered/mypageResult.jsp").forward(request, response);
		RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath() + "/viewCart.do");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
