package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import friend.service.FriendServiceImpl;
import friend.service.IFriendService;
import home.service.HomeServiceImpl;
import home.service.IHomeService;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import vo.HomeVO;
import vo.MemberFriendVO;
import vo.MemberVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/main/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		MemberVO vo = new MemberVO();
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userid");
		String pass = request.getParameter("pass");
//		String homePic = request.getParameter("homepic");
//		String userName = request.getParameter("username");
		
		vo.setMem_id(userId);
		vo.setMem_pass(pass);
//		hVo.setHome_pic(homePic);
//		vo.setMem_name(userName);
		
		
		//service객체 얻어오기
		IMemberService service = MemberServiceImpl.getService();
		IHomeService service2 = HomeServiceImpl.getInstance();
		
		//홈 프로필사진 가져오기 용
		HomeVO homeVo = service2.getHomeInfo(userId);
		
		
		
		String loginCheckYn = "";
		String homeId = "";
		try {
			loginCheckYn = service.loginCheck(vo);
			vo = service.getMemberName(userId);
			
			if(loginCheckYn != null) {
				if(loginCheckYn.equals("1")){
					session.setAttribute("userId", userId);
					session.setAttribute("userName", vo.getMem_name());
					session.setAttribute("userDotori", vo.getMem_dotori());
					session.setAttribute("homeVo", homeVo);
					
					homeId = service.getHomeId(userId);
					
					if(homeId != null) {
						session.setAttribute("homeChk", homeId);
					}
				}
			}
			System.out.println(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("loginCheckYn : " + loginCheckYn);

		//---------일촌신청이 된 값 불러오기------------------
		IFriendService service3 = FriendServiceImpl.getInstance();
		
		MemberFriendVO memFriendVo = new MemberFriendVO();
		memFriendVo.setHome_id(homeId);
		System.out.println("session에 저장된 homeId" +homeId);
		

		//나에게 들어온 일촌신청 목록을 확인할 수 있다.
		List<MemberFriendVO> sendList = service3.sendFriend(memFriendVo);
		session.setAttribute("sendList", sendList);
		
		response.sendRedirect(request.getContextPath()+"/main/index.jsp");
		
		
	}

}
