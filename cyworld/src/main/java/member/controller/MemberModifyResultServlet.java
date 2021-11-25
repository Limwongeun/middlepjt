package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.valves.RequestFilterValve;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import vo.MemberVO;

@WebServlet("/modifyResult.do")
public class MemberModifyResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		
		MemberVO vo = new MemberVO();
		
		String mem_id = (String) request.getParameter("mem_id");
		String mem_tel = (String) request.getParameter("mem_tel");
		String mem_pass = (String) request.getParameter("mem_pass");
		String mem_mail = (String) request.getParameter("mem_mail");
		String mem_addr1 = (String) request.getParameter("mem_addr1");
		String mem_addr2 = (String) request.getParameter("mem_addr2");
		String mem_zip = (String) request.getParameter("mem_zip");
		
		System.out.println("유저아이디" + mem_id);
		System.out.println("핸드폰" + mem_tel);
		System.out.println("비밀번호" + mem_pass);
		System.out.println("메일" + mem_mail);
		System.out.println("주소1" + mem_addr1);
		System.out.println("주소2" + mem_addr2);
		System.out.println("우편번호" + mem_zip);
		vo.setMem_id(mem_id);
		vo.setMem_tel(mem_tel);
		vo.setMem_pass(mem_pass);
		vo.setMem_mail(mem_mail);
		vo.setMem_addr1(mem_addr1);
		vo.setMem_addr2(mem_addr2);
		vo.setMem_zip(mem_zip);
		
		IMemberService service = MemberServiceImpl.getService();
		try {
			
			service.updateMember(vo);
			request.setAttribute("result", vo.getMem_id());
			
			System.out.println("리절트값 ....." + request.getAttribute("result"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("main/modifyResult.jsp").forward(request, response);
	}

}
