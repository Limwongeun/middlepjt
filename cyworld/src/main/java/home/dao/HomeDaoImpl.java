package home.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import util.SqlMapClientFactory;
import vo.HomeVO;

public class HomeDaoImpl implements IHomeDao {
	private static HomeDaoImpl dao;
	private SqlMapClient smc;
	private HomeDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	public static HomeDaoImpl getInstance() {
		if(dao==null) dao = new HomeDaoImpl();
		return dao;
	}
	@Override
	public HomeVO getHomeInfo(String memId) {
		HomeVO homeVo = null;
		try {
			homeVo = (HomeVO) smc.queryForObject("home.getHomeInfo",memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return homeVo;
	}



	@Override
	public int profileImgUpdate(Map<String, String> paramMap) {
		int cnt =0;
		try {
			cnt = smc.update("home.profileImgUpdate", paramMap);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int updateProfile(Map<String, String> paramMap) {
		int cnt =0;
		try {
			cnt = smc.update("home.updateProfile",paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int insertNew(String newMem) {
		int cnt = 0;
		try {
			Object obj = smc.insert("home.newMem", newMem);
			if(obj == null) cnt = 1;
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public String getHomeId(String memId) {
		String homeId = null;
		try {
			homeId = (String) smc.queryForObject("home.getHomeId", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return homeId;
	}

	


}
