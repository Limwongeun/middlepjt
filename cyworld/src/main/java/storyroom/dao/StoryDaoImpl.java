package storyroom.dao;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import util.SqlMapClientFactory;
import vo.StoryRoomVO;

public class StoryDaoImpl implements IStoryDao {
	
	private static StoryDaoImpl dao;
	private SqlMapClient smc;
	private StoryDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	public static StoryDaoImpl getInstance() {
		if(dao==null) dao = new StoryDaoImpl();
		return dao;
	}
	
	@Override
	public StoryRoomVO getStory(String rName) {
		StoryRoomVO storyVo = null;
		try {
			storyVo = (StoryRoomVO) smc.queryForObject("story.getRoomImg",rName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return storyVo;
	}
	@Override
	public StoryRoomVO getMinimi(String rName) {
		StoryRoomVO storyVo = null;
		try {
			storyVo = (StoryRoomVO) smc.queryForObject("story.getMinimiImg",rName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return storyVo;
	}
	
	@Override
	public StoryRoomVO getSkinImg(String nName) {
		StoryRoomVO storyVo = null;
		try {
			storyVo = (StoryRoomVO) smc.queryForObject("story.getSkinImg",nName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return storyVo;
	}

	@Override
	public StoryRoomVO getmp3(String rName) {
		StoryRoomVO storyVo = null;
		try {
			storyVo = (StoryRoomVO) smc.queryForObject("story.getmp3",rName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return storyVo;
	}
	
	@Override
	public List<StoryRoomVO> myListMinimi(String homeId) {
		List<StoryRoomVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("story.myListMinimi",homeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<StoryRoomVO> myListSkin(String homeId) {
		List<StoryRoomVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("story.myListSkin",homeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<StoryRoomVO> myListStoryroom(String homeId) {
		List<StoryRoomVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("story.myListStoryroom",homeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<StoryRoomVO> myListBgm(String homeId) {
		List<StoryRoomVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("story.myListBgm",homeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int changeMinimiY(Map<String, String> paramMap) {
		int cnt = 0;
		try {
			cnt = smc.update("story.changeMinimiY", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	@Override
	public int changeMinimiN(Map<String, String> paramMap) {
		int cnt = 0;
		try {
			cnt = smc.update("story.changeMinimiN", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	@Override
	public int changeSkinY(Map<String, String> paramMap) {
		int cnt = 0;
		try {
			cnt = smc.update("story.changeSkinY", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	@Override
	public int changeSkinN(Map<String, String> paramMap) {
		int cnt = 0;
		try {
			cnt = smc.update("story.changeSkinN", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	@Override
	public int changeRoomY(Map<String, String> paramMap) {
		int cnt = 0;
		try {
			cnt = smc.update("story.changeRoomY", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	@Override
	public int changeRoomN(Map<String, String> paramMap) {
		int cnt = 0;
		try {
			cnt = smc.update("story.changeRoomN", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	@Override
	public int changeMp3Y(Map<String, String> paramMap) {
		int cnt = 0;
		try {
			cnt = smc.update("story.changeMp3Y", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	@Override
	public int changeMp3N(Map<String, String> paramMap) {
		int cnt = 0;
		try {
			cnt = smc.update("story.changeMp3N", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

}
