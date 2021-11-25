package member.service;

import java.sql.SQLException;
import java.util.Map;

import vo.MemberVO;

public interface IMemberService {

	//아이디 중복 체크
	public String idCheck(String id) throws Exception; // 전달받는 매개변수 String id
	
	//회원정보 입력
	public int insertMember(MemberVO vo) throws Exception;

	//회원가입 여부 확인
	public String loginCheck(MemberVO vo) throws Exception;
	
	//홈피ID, 멤버ID조회 
	public String getHomeId(String homeId) throws Exception;
	
	//멤버NAME 조회
	public MemberVO getMemberName(String memId) throws Exception;
	
	//회원정보 수정
	public int updateMember(MemberVO vo) throws Exception;
	
	// 상품 결제(도토리 업데이트)
	public int setDotori(String memId) throws Exception;
	
	// 도토리 구매
	public int orderDotori(Map<String, String> map) throws Exception;
	
	// 멤버 도토리 조회
	public int getDotori(String memId) throws Exception;
}
