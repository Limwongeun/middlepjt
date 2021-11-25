package cart.service;

import java.util.List;
import java.util.Map;

import vo.CartVO;

public interface ICartService {

	public List<CartVO> listCart(String userId);	// 장바구니 목록 
	
	public int insertCart(Map<String, String> map);	// 장바구니 추가
	
	public int delCart(Map<String, String> map);	// 장바구니 삭제
	
	public int newCart();							// 장바구니 생성
	
	public int payCart(String memId);				// 장바구니 결제

	
//	public int deleteAll(String userId);	// 장바구니 비우기
//	
//	
//	public int sumPrice(int price);	// 장바구니 총 금액
//	
//	public int cartQty(int qty);	// 상품 총 갯수
}
