package ordered.service;

import ordered.dao.IOrderedDao;
import ordered.dao.OrderedDaoImpl;
import vo.OrderedVO;

public class OrderedServiceImpl implements IOrderedService {

	private IOrderedDao dao;
	
	private static OrderedServiceImpl service;
	
	private OrderedServiceImpl() {
		dao = OrderedDaoImpl.getInstance();
	}
	
	public static OrderedServiceImpl getInstance() {
		if(service == null) service = new OrderedServiceImpl();
		return service;
	}

	@Override
	public int updateOrdered(String userId) {
		return dao.updateOrdered(userId);
	}

	@Override
	public int insertOrdered(String memId) {
		return dao.insertOrdered(memId);
	}

	@Override
	public int payOrdered(String memId) {
		return dao.payOrdered(memId);
	}

	@Override
	public OrderedVO myOrder(String memId) {
		return dao.myOrder(memId);
	}	
}
