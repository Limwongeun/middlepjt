package mypage.service;

import java.util.List;
import java.util.Map;

import mypage.dao.IMypageDao;
import mypage.dao.MypageDaoImpl;
import vo.MypageVO;

public class MypageServiceImpl implements IMypageService {
	
	private IMypageDao dao;
	
	private static MypageServiceImpl service;
	
	private MypageServiceImpl() {
		dao = MypageDaoImpl.getInstance();
	}
	
	public static MypageServiceImpl getInstance() {
		if(service == null) service = new MypageServiceImpl();
		return service;
	}
	
	@Override
	public int insertProd(Map<String, String> map) {
		return dao.insertProd(map);
	}

	@Override
	public int insertNew(String newHome) {
		return dao.insertNew(newHome);
	}

	@Override
	public List<MypageVO> viewProd(String memId) {
		return dao.viewProd(memId);
	}

}
