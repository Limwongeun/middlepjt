package friend.service;

import java.util.List;

import friend.dao.FriendDaoImpl;
import friend.dao.IFriendDAO;
import vo.HomeVO;
import vo.MemberFriendVO;

public class FriendServiceImpl implements IFriendService {

	private IFriendDAO friendDao;
	
	private static FriendServiceImpl service;
	
	private FriendServiceImpl() {
		friendDao = FriendDaoImpl.getInstance();
	}
	
	public static FriendServiceImpl getInstance() {
		if(service==null) service =new FriendServiceImpl();
		return service;
	}
	
	@Override
	public List<MemberFriendVO> getAllFriend(String homeId) {
		return friendDao.getAllFriend(homeId);
	}

	@Override
	public List<MemberFriendVO> friendList(String homeId) {
		return friendDao.friendList(homeId);
	}

	@Override
	public List<MemberFriendVO> friendSearch(MemberFriendVO memberFriendVO) {
		return friendDao.searchFriend(memberFriendVO);
	}

	@Override
	public int deleteFriend(MemberFriendVO memFriendVo) {
		return friendDao.deleteFriend(memFriendVo);
	}
 
	@Override
	public List<MemberFriendVO> bestFriendList(String homeId) {
		return friendDao.bestFriendList(homeId);
	}

	@Override
	public int insertCount(String homeId) {
		return friendDao.insertCount(homeId);
	}

	@Override
	public int todayCount(String homeId) {
		return friendDao.todayCount(homeId);
	}

	@Override
	public int totalCount(String homeId) {
		return friendDao.totalCount(homeId);
	}

	@Override
	public List<MemberFriendVO> memberInfo(String userId) {
		return friendDao.memberInfo(userId);
	}

	@Override
	public int requestFriend(MemberFriendVO memFriendVo) {
		return friendDao.requestFriend(memFriendVo);
	}

	@Override
	public List<MemberFriendVO> sendFriend(MemberFriendVO memFriendVo) {
		return friendDao.sendFriend(memFriendVo);
	}

	@Override
	public int acceptFriend(MemberFriendVO memFriendVo) {
		return friendDao.acceptFriend(memFriendVo);
	}

	@Override
	public int deleteAccept(MemberFriendVO memFriendVo) {
		return friendDao.deleteAccept(memFriendVo);
	}

	@Override
	public List<HomeVO> memInfo(String memId) {
		return friendDao.memInfo(memId);
	}


}
