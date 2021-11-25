package photo.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import photo.service.IPhotoService;
import photo.service.PhotoServiceImpl;
import vo.PhotoVO;

@WebServlet("/photoWrite.do")
@MultipartConfig
public class PhotoWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("photo/write.jsp");
		disp.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int boardNo = 0;
		try {
		String no = request.getParameter("board_no");
		 boardNo = Integer.parseInt(no);
		} catch (NumberFormatException e) {}
		catch(Exception e) {}
		
		String home_id = request.getParameter("home_id");
		String writer = request.getParameter("board_writer");
		String title = request.getParameter("board_title");
		String text = request.getParameter("board_text");
		String date = request.getParameter("board_date");
		
		
		System.out.println(home_id + writer + title + text + date);
		
		Part part = request.getPart("uploadfile");
		String dir ="D:\\A_TeachingMaterial\\4.MiddleProject\\cyworld\\cyworld\\WebContent\\images\\";
		String filename = UUID.randomUUID().toString().replace("-", "");
		String ext = ".png";
	    String namee = filename+ext;
	    String imgName = dir+filename+ext;
	    part.write(imgName);//write메서드의 매개변수로 경로와 파일이름 확장자명을 넘긴다.
	    
	    PhotoVO vo = new PhotoVO();
	    vo.setHome_id(home_id);
	    vo.setBoard_writer(writer);
	    vo.setBoard_title(title);
	    vo.setBoard_text(text);
	    vo.setBoard_date(date);
	    vo.setBoard_photo(namee);
	    
	    IPhotoService service = PhotoServiceImpl.getService();
	    service.insertBoard(vo);
	    
	    response.sendRedirect(request.getContextPath() + "/photoList.do");
	    
	    
	    
	    
	}

}
