package cart.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import util.SqlMapClientFactory;
import vo.CartVO;

public class CartDaoImpl implements ICartDao {

	private static CartDaoImpl dao;
	private SqlMapClient smc;
	
	private CartDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static CartDaoImpl getInstance() {
		if(dao == null) dao = new CartDaoImpl();
		
		return dao;
	}
	@Override
	public List<CartVO> listCart(String userId) {
		List<CartVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("cart.viewCart", userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insertCart(Map<String, String> map) {
		int cnt = 0;
		try {
			Object obj = smc.insert("cart.addCart", map);
			if(obj == null) cnt = 1;
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	

	@Override
	public int delCart(Map<String, String> map) {
		int cnt = 0;
		try {
			cnt = smc.delete("cart.delCart", map);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int newCart() {
		int cnt = 0;
		
		try {
			Object obj = smc.insert("cart.newCart");
			if(obj == null) cnt = 1;
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int payCart(String memId) {
		int cnt = 0;
		
		try {
			cnt = smc.update("cart.payCart", memId);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	
}
