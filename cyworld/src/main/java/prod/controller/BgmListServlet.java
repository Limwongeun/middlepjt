package prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prod.service.IProdImgService;
import prod.service.ProdImgServiceImpl;
import vo.ProdImgVO;
import vo.ProdVO;

@WebServlet("/bgmList.do")
public class BgmListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IProdImgService service = ProdImgServiceImpl.getInstance();	
		
		List<ProdImgVO> imgList = service.getBgmImg();
		
		List<ProdVO> nmList = service.getBgmNm();
		
		List<ProdVO> DoList = service.getBgmDotori();
		
		request.setAttribute("imgList", imgList);
		request.setAttribute("nmList", nmList);
		request.setAttribute("DoList", DoList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/prod/bgmList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
