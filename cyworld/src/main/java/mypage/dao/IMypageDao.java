package mypage.dao;

import java.util.List;
import java.util.Map;

import vo.MypageVO;

public interface IMypageDao {

	public int insertProd(Map<String, String> map); // 결제완료된 상품 인서트
	
	public int insertNew(String newHome);	// 신규회원 기본 상품 인서트
	
	public List<MypageVO> viewProd(String memId);	// 결제 상품 출력
}
