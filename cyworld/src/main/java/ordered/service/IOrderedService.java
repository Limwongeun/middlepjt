package ordered.service;

import vo.OrderedVO;

public interface IOrderedService {

	public int updateOrdered(String userId);			// 주문상태 변경
	
	public int insertOrdered(String memId);				// 주문상태 생성
	
	public int payOrdered(String memId);				// 결제하기
	
	public OrderedVO myOrder(String memId);				// 주문정보 받기
	
}
