package ordered.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import util.SqlMapClientFactory;
import vo.OrderedVO;

public class OrderedDaoImpl implements IOrderedDao {

	private static OrderedDaoImpl dao;
	private SqlMapClient smc;
	
	private OrderedDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static OrderedDaoImpl getInstance() {
		if(dao == null) dao = new OrderedDaoImpl();
		
		return dao;
	}

	@Override
	public int updateOrdered(String userId) {
		int cnt = 0;
		try {
			cnt = smc.update("ordered.addOrdered", userId);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int insertOrdered(String memId) {
		int cnt = 0;
		try {
			Object obj = smc.insert("ordered.newOrdered", memId);
			if(obj == null) cnt = 1;
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int payOrdered(String memId) {
		int cnt = 0;
		try {
			cnt = smc.update("ordered.payOrdered", memId);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public OrderedVO myOrder(String memId) {
		OrderedVO vo = null;
		try {
			vo = (OrderedVO) smc.queryForObject("ordered.myOrder", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
}
