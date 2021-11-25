package friend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import util.SqlMapClientFactory;
import vo.FriendVO;
import vo.HomeVO;
import vo.MemberFriendVO;
import vo.MemberVO;

public class FriendDaoImpl implements IFriendDAO {

	private static FriendDaoImpl dao;
	private SqlMapClient smc;
	
	private FriendDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
			
	}
	
	public static FriendDaoImpl getInstance() {
		if(dao==null) dao=new FriendDaoImpl();
		return dao;
	} 

	//친구값 다 받아오기
	@Override
	public List<MemberFriendVO> getAllFriend(String homeId) {
		
		List<MemberFriendVO> friendlist = new ArrayList<>();
		
		try {
			friendlist = smc.queryForList("friend.getAllFriend",homeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return friendlist;
	}

	@Override
	public List<MemberFriendVO> friendList(String homeId) {
		List<MemberFriendVO> allFriendList  = new ArrayList<>();
		
		try {
			allFriendList = smc.queryForList("friend.friendList", homeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allFriendList;
	}

	//검샘한 친구찾기(나제외)
	@Override
	public List<MemberFriendVO> searchFriend(MemberFriendVO memFriendVo) {
		List<MemberFriendVO> friendSearchList  = new ArrayList<>();
		
		try {
			friendSearchList = smc.queryForList("friend.searchFriend", memFriendVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return friendSearchList;
		
	}

	//일촌목록에서 친구 삭제하기
	@Override
	public int deleteFriend(MemberFriendVO memfriendVo) {
		int cnt = 0;
		try {
			cnt = smc.delete("friend.deleteFriend",memfriendVo );
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	//일촌목록
	@Override
	public List<MemberFriendVO> bestFriendList(String homeId) {
		List<MemberFriendVO> bestFriendList = new ArrayList<>();
		try {
			bestFriendList = smc.queryForList("friend.bestFriendList", homeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bestFriendList;
	}

	//조회수 insert
	@Override
	public int insertCount(String homeId) {
		int cnt = 0;
		try {
			Object obj = smc.insert("friend.insertCount", homeId);
			if(obj == null) cnt =1;
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	//오늘날짜인것만 받아오기
	@Override
	public int todayCount(String homeId) {
		int count = 0;
		try {
			count = (int)smc.queryForObject("friend.todayCount", homeId);
		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	//totalcount 받아오기
	@Override
	public int totalCount(String homeId) {
		 int count = 0;
		try {
			count = (int)smc.queryForObject("friend.totalCount", homeId);
		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	//회원검색..?
	@Override
	public List<MemberFriendVO> memberInfo(String userId) {
		List<MemberFriendVO> memberInfoList = new ArrayList<>();
		try {
			memberInfoList = smc.queryForList("friend.memberInfo", userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return memberInfoList;
	}

	//일촌요청시 친구행 insert(친구여부 'n')
	@Override
	public int requestFriend(MemberFriendVO memFriendVo) {
		int cnt=0;
		try {
			Object c = smc.insert("friend.requestFriend", memFriendVo);
			if(c==null) {
				cnt =1;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	
	//일촌신청 보내기누리면 친구행 insert됨
	@Override
	public List<MemberFriendVO> sendFriend(MemberFriendVO memFriendVo) {
		List<MemberFriendVO> sendFriendList = new ArrayList<>();
		
		try {
			sendFriendList =smc.queryForList("friend.sendFriend", memFriendVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sendFriendList;
	}

	//친구요청을 허락했을 때 친구set이 n->y가 됨
	@Override
	public int acceptFriend(MemberFriendVO memFriendVo) {
			int cnt = 0;
			try {
				Object c = smc.update("friend.acceptFriend", memFriendVo);
				if(c==null) {
					cnt =1;
				}
			} catch (SQLException e) {
				cnt =0;
				e.printStackTrace();
			}
			return cnt;
	}

	
	//친구요청을 삭제했을 때 친구행이 삭제됨
	@Override
	public int deleteAccept(MemberFriendVO memFriendVo) {
			int cnt = 0;
			try {
				Object c = smc.delete("friend.deleteAccept", memFriendVo);
				if(c==null) {
					cnt = 1;
				}
			} catch (SQLException e) {
				cnt = 0;
				e.printStackTrace();
			}
			return cnt;

	}

	//친구id로 홈id찾기
	@Override
	public List<HomeVO> memInfo(String memId) {
		List<HomeVO> memInfo = new ArrayList<>();
		try {
			memInfo = smc.queryForList("friend.memInfo", memId);
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memInfo;
	}


}
