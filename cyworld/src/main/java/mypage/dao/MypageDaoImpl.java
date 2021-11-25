package mypage.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import util.SqlMapClientFactory;
import vo.MypageVO;

public class MypageDaoImpl implements IMypageDao {

	private static MypageDaoImpl dao;
	private SqlMapClient smc;
	
	private MypageDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static MypageDaoImpl getInstance() {
		if(dao == null) dao = new MypageDaoImpl();
		
		return dao;
	}
	
	@Override
	public int insertProd(Map<String, String> map) {
		int cnt = 0;
		try {
			Object obj = smc.insert("mypage.insertProd", map);
			if(obj == null) cnt = 1;
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int insertNew(String newHome) {
		int cnt = 0;
		try {
			Object obj = smc.insert("mypage.newHome", newHome);
			if(obj == null) cnt = 1;
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MypageVO> viewProd(String memId) {
		List<MypageVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("mypage.viewProd", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
