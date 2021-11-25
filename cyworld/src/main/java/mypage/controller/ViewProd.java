package mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypage.service.IMypageService;
import mypage.service.MypageServiceImpl;
import vo.MypageVO;

@WebServlet("/viewProd.do")
public class ViewProd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IMypageService service = MypageServiceImpl.getInstance();
		HttpSession session = request.getSession();
		
		List<MypageVO> list = service.viewProd((String) session.getAttribute("userId"));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getProd_id().contains("g0")) {
				String a = list.get(i).getProd_url();
				a = a.replace(".mp3", ".jpg");
				a = a.replace("mp3", "images");
				list.get(i).setProd_url(a);
			}
		}
		
		request.setAttribute("myProd", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/mypage/myProd.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
