package storyroom.service;
 
import java.util.List;
import java.util.Map;

import storyroom.dao.IStoryDao;
import storyroom.dao.StoryDaoImpl;
import vo.StoryRoomVO;

public class StoryServiceImpl implements IStoryService {
	private IStoryDao storyDao;
	
	private static StoryServiceImpl service;
	
	private StoryServiceImpl() {
		storyDao = StoryDaoImpl.getInstance();
	}
	public static StoryServiceImpl getInstance() {
		if(service==null) service = new StoryServiceImpl();
		return service;
		
	}
	
	
	@Override
	public StoryRoomVO getStory(String rName) {
		return storyDao.getStory(rName);
	}
	
	@Override
	public StoryRoomVO getMinimi(String rName) {
		return storyDao.getMinimi(rName);
	}
	
	@Override
	public StoryRoomVO getSkinImg(String rName) {
		return storyDao.getSkinImg(rName);
	}
	@Override
	public StoryRoomVO getmp3(String rName) {
		return storyDao.getmp3(rName);
	}
	@Override
	public List<StoryRoomVO> myListMinimi(String homeId) {
		return storyDao.myListMinimi(homeId);
	}
	@Override
	public List<StoryRoomVO> myListSkin(String homeId) {
		return storyDao.myListSkin(homeId);
	}
	@Override
	public List<StoryRoomVO> myListStoryroom(String homeId) {
		return storyDao.myListStoryroom(homeId);
	}
	@Override
	public List<StoryRoomVO> myListBgm(String homeId) {
		return storyDao.myListBgm(homeId);
	}
	@Override
	public int changeMinimiY(Map<String, String> paramMap) {
		return storyDao.changeMinimiY(paramMap);
	}
	@Override
	public int changeMinimiN(Map<String, String> paramMap) {
		return storyDao.changeMinimiN(paramMap);
	}
	@Override
	public int changeSkinY(Map<String, String> paramMap) {
		return storyDao.changeSkinY(paramMap);
	}
	@Override
	public int changeSkinN(Map<String, String> paramMap) {
		return storyDao.changeSkinN(paramMap);
	}
	@Override
	public int changeRoomY(Map<String, String> paramMap) {
		return storyDao.changeRoomY(paramMap);
	}
	@Override
	public int changeRoomN(Map<String, String> paramMap) {
		return storyDao.changeRoomN(paramMap);
	}
	@Override
	public int changeMp3Y(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		return storyDao.changeMp3Y(paramMap);
	}
	@Override
	public int changeMp3N(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		return storyDao.changeMp3N(paramMap);
	}




}
