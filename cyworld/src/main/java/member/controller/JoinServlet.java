package member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cart.service.CartServiceImpl;
import cart.service.ICartService;
import home.service.HomeServiceImpl;
import home.service.IHomeService;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import mypage.service.IMypageService;
import mypage.service.MypageServiceImpl;
import ordered.service.IOrderedService;
import ordered.service.OrderedServiceImpl;
import vo.MemberVO;

@WebServlet("/Member")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청 데이터 받기
		String memberId = request.getParameter("memberId");
		
		//service객체 얻어오기
		IMemberService service = MemberServiceImpl.getService();
		
		//service 메소드 호출 - 값 얻기
		String idCheck = null;
		try {
			idCheck = service.idCheck(memberId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("idCheck : " + idCheck);
		
		//jsp로 값 전달하기 
		request.setAttribute("idCheck", idCheck);
//		RequestDispatcher rd = request.getRequestDispatcher("middleTest/WEB-INF/idCheck.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/main/idCheck.jsp");
//		rd = request.getRequestDispatcher(request.getContextPath() + "/createHome.do");
		
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 데이터 받기 회원가입시 입력한 데이터들을 다 받아와서 처리
		MemberVO vo = new MemberVO();
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//service객체 얻어오기
		IMemberService service = MemberServiceImpl.getService();
		
		//service 메소드 호출 > 값 얻기!
		int insertYn = 0;
		try {
			insertYn = service.insertMember(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("insertYn : " + insertYn);
		
		if( insertYn> 0) {
			request.setAttribute("uId", vo.getMem_id());
			IHomeService homeSer = HomeServiceImpl.getInstance();
			IMypageService mySer = MypageServiceImpl.getInstance();
			System.out.println(vo.getMem_id());
			int newM = homeSer.insertNew(vo.getMem_id());
			System.out.println(newM);
			if(newM != 0) {
				String homeId = homeSer.getHomeId(vo.getMem_id());
				int newH = mySer.insertNew(homeId);
				System.out.println("home_id : " + homeId);
				System.out.println("newH : " + newH);
				if(newH != 0) {
					ICartService cartService = CartServiceImpl.getInstance();
					IOrderedService orderService = OrderedServiceImpl.getInstance();
				
					int cart = cartService.newCart();
					System.out.println("cart : " + cart);
					int ordered = 0;
					
					if(cart != 0) {
						ordered = orderService.insertOrdered(vo.getMem_id());
						System.out.println("ordered : " + ordered);
					}
				}
			}
			
			
			request.setAttribute("hId", vo.getHome_id());
		}else {
			request.setAttribute("uId", null);
		}
		
		System.out.println("값 : " +request.getAttribute("uId"));
		System.out.println("홈아이디~~~~~값 : " +request.getAttribute("hId"));
		
//		if(insert == "success") {
//			request.setAttribute("uId", vo.getMem_id());
//		}else {
//			request.setAttribute("uId", null);
//		}
		request.getRequestDispatcher("/main/insert.jsp").forward(request, response);
		
		
		
//		response.sendRedirect(request.getContextPath()+"/main/index.jsp");
		
		
	}

}
