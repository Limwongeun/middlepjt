package test.controller;

import java.awt.Panel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TestController {


	public static void main(String[] args) {
		new TestController().copyImg();
	}

//	private void testStart() {
//		System.out.println("DB사진 복사 테스트를 시작합니다.");
//		copyImg();
//	}

	private void copyImg() {
		JFileChooser chooser = new JFileChooser();
	      
	      //선택할 파일의 확장자 설정
	      FileNameExtensionFilter img = new FileNameExtensionFilter("그림파일", "png", "jpg", "gif");//뒤에는 확장자
	      
	      chooser.addChoosableFileFilter(img);
	      
	      //Dialog창에 나타날 기본 경로 설정
	      chooser.setCurrentDirectory(new File("d:/d_other"));
	      
	      int result = chooser.showOpenDialog(new Panel());//열기창

	      File file = null;
	      
	      if(result == JFileChooser.APPROVE_OPTION) {//'저장'또는 '열기'버튼을 눌렀을 때
	         file = chooser.getSelectedFile();
	      }else {
	         System.out.println("원본 파일을 선택하지 않았습니다.");
	         System.out.println("복사 작업을 중지합니다.");
	      }
	      
	      if(!file.exists()) {
	         System.out.println(file.getPath()+"파일이 없습니다.");
	         System.out.println("복사 작업을 중지합니다.");
	         return;
	      }
		try {
			System.out.println("복사 시작...");
			// 원본 데이터를 읽어올 입력용 스트림 객체 생성
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);

			// 저장할 출력용 스트림 객체 생성
			FileOutputStream fout = new FileOutputStream("d:/A_TeachingMaterial/4.MiddleProject/workspace/cyworld/WebContent/images/" + file.getName());
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			int data;
			/*
			 * while ((data = fis.read()) != -1) { fout.write(data); } // 스트림 닫기
			 * fout.flush(); fis.close();
			 */
			while ((data = bis.read()) != -1) {
				bout.write(data);
			}
			bout.flush();

			// 스트림 닫기
			bout.close();
			bis.close();

			System.out.println("복사 완료...");

		} catch (IOException e) {
			// TODO Auto-generated catch block

		}

	}

}

