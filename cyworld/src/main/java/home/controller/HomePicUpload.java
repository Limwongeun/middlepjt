package home.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 
 
@WebServlet("/homePicUpload.do")
@MultipartConfig
//sevlet클래스에서 request를 javax.servlet.http.Part 
//타입으로 받을 수 있도록@MultipartConfig 어노테이션  추가
public class HomePicUpload extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HomePicUpload() {
        super();
 
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String homeId = request.getParameter("homeId");
        Part part = request.getPart("uploadfile"); //part타입으로 업로드된 파일을 받아온다.
        System.out.println("part : " + part);
        
        String dir ="D:\\A_TeachingMaterial\\4.MiddleProject\\cyworld\\cyworld\\WebContent\\images\\";
        String filename = UUID.randomUUID().toString().replace("-", "");
        //UUID는 파일명이 중복되지않도록 랜덤의 문자열을 생성한다.
        String ext = ".png";
        String namee = filename+ext;
        String imgName = dir+filename+ext;
        part.write(imgName);//write메서드의 매개변수로 경로와 파일이름 확장자명을 넘긴다.
        request.setAttribute("imgName", namee);
        request.setAttribute("homeId", homeId);

		request.getRequestDispatcher("/profilePicDB.do")
		.forward(request, response);
		
        
    }
 
}