package home.dao;

import java.util.Map;

import vo.HomeVO;

public interface IHomeDao {
	public HomeVO getHomeInfo(String memId);

	public int profileImgUpdate(Map<String, String> paramMap);
	
	public int updateProfile(Map<String, String> paramMap);
	
	public int insertNew(String newMem);
	
	public String getHomeId(String memId);
}
