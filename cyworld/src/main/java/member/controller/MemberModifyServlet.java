package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import vo.MemberVO;

@WebServlet("/modify.do")
public class MemberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		
		MemberVO vo = new MemberVO();
		
		String userId = (String) session.getAttribute("userId");
		vo.setMem_id(userId);
		
		IMemberService service = MemberServiceImpl.getService();
		try {
			
			vo = service.getMemberName(userId);
			
//			service.updateMember(vo);
			request.setAttribute("result", vo);
			
			System.out.println("리절트값 ....." + request.getAttribute("result"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("main/modify.jsp").forward(request, response);
	}

}
