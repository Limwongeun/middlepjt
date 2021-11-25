package home.service;

import java.util.Map;

import home.dao.HomeDaoImpl;
import home.dao.IHomeDao;
import vo.HomeVO;

public class HomeServiceImpl implements IHomeService{
	private IHomeDao homeDao;
	private static HomeServiceImpl service;
	private HomeServiceImpl() {
		homeDao = HomeDaoImpl.getInstance();
	}
	public static HomeServiceImpl getInstance() {
		if(service==null) service = new HomeServiceImpl();
		return service;
	}
	@Override
	public HomeVO getHomeInfo(String memId) {
		// TODO Auto-generated method stub
		return homeDao.getHomeInfo(memId);
	}



	@Override
	public int profileImgUpdate(Map<String, String> paramMap) {
		
		return homeDao.profileImgUpdate(paramMap);
	}
	@Override
	public int updateProfile(Map<String, String> paramMap) {

		return homeDao.updateProfile(paramMap);
	}
	@Override
	public int insertNew(String newMem) {
		return homeDao.insertNew(newMem);
	}
	@Override
	public String getHomeId(String memId) {
		return homeDao.getHomeId(memId);
	}

	

}
