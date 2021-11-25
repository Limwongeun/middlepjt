package storyroom.service;
 
import java.util.List;
import java.util.Map;

import vo.StoryRoomVO;

public interface IStoryService {
	public StoryRoomVO getStory(String rName);
	
	public StoryRoomVO getMinimi(String rName);
	
	public StoryRoomVO getSkinImg(String rName);
	
	public StoryRoomVO getmp3(String rName);
	
	public List<StoryRoomVO> myListMinimi(String homeId); 
	
	public List<StoryRoomVO> myListSkin(String homeId); 
	
	public List<StoryRoomVO> myListStoryroom(String homeId); 
	
	public List<StoryRoomVO> myListBgm(String homeId); 
	
	public int changeMinimiY(Map<String, String> paramMap);
	
	public int changeMinimiN(Map<String, String> paramMap);
	
	public int changeSkinY(Map<String, String> paramMap);
	
	public int changeSkinN(Map<String, String> paramMap);
	
	public int changeRoomY(Map<String, String> paramMap);
	
	public int changeRoomN(Map<String, String> paramMap);
	
	public int changeMp3Y(Map<String, String> paramMap);
	
	public int changeMp3N(Map<String, String> paramMap);
}
