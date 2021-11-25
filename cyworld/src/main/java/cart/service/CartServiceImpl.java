package cart.service;

import java.util.List;
import java.util.Map;

import cart.dao.ICartDao;
import cart.dao.CartDaoImpl;
import vo.CartVO;

public class CartServiceImpl implements ICartService {
	private ICartDao dao;
	
	private static CartServiceImpl service;
	
	private CartServiceImpl() {
		dao = CartDaoImpl.getInstance();
	}
	
	public static CartServiceImpl getInstance() {
		if(service == null) service = new CartServiceImpl();
		return service;
	}	
	
	@Override
	public List<CartVO> listCart(String userId) {
		return dao.listCart(userId);
	}

	@Override
	public int insertCart(Map<String, String> map) {
		return dao.insertCart(map);
	}

	@Override
	public int delCart(Map<String, String> map) {
		return dao.delCart(map);
	}

	@Override
	public int newCart() {
		return dao.newCart();
	}

	@Override
	public int payCart(String memId) {
		return dao.payCart(memId);
	}

}
