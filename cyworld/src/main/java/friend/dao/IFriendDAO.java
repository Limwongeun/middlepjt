package friend.dao;

import java.util.List;

import vo.FriendVO;
import vo.HomeVO;
import vo.MemberFriendVO;
import vo.MemberVO;

public interface IFriendDAO {

	/**
	 * DB home테이블에서 homeId가 갖는 일촌목록의 이름과 별명을
	 * 전체 레코드를 가져와 List에 담아서 반환
	 * @param homeId 검색할 home_id
	 * @return 검색된 데이터가 저장된 List객체
	 */
	public List<MemberFriendVO> getAllFriend(String homeId);

	/**
	 * DB테이블에서 homeId가 갖는 일촌목록을 List에 담아서 반환
	 * @param homeId 검색한 home_id
	 * @return 검색된 데이터가 저장된 List객체
	 */ 
	public List<MemberFriendVO> friendList(String homeId);

	/**
	 * 일촌 파도타기 - 일촌의 이름과 별명을 List에 담아서 반환
	 * @param homeId 검색할 home_id
	 * @return 검색된 데이터가 저장된 List객체
	 */
	public List<MemberFriendVO> bestFriendList(String homeId);
	
	/**
	 * 검색창에서 회원의 이름 검색시 DB에서 결과값을 List에 담아서 반환
	 * @param memId 로그인한 회원
	 * @return 검색된 데이터가 저장된 List객체
	 */
	public List<MemberFriendVO> searchFriend(MemberFriendVO memFriendVo);
	
	/**
	 * 일촌 목록에서 memId의 일촌 삭제
	 * @param memId 삭제할 회원 Id
	 * @return 작업성공 : 1, 작업실패: 0
	 */
	public int deleteFriend(MemberFriendVO memFriendVo);
	
	/**
	 * 일촌요청시 friend 테이블 insert
	 * @param friendVo 
	 * @return 작업성공 1이상, 작업실패 : 0
	 */
	public int requestFriend(MemberFriendVO memFriendVo);
	
	/**
	 * 친구상태가 'n'인 값을 불러옴
	 * @param memFriendVo
	 * @return 검색된 데이터가 저장된 list객체
	 */
	public List<MemberFriendVO> sendFriend(MemberFriendVO memFriendVo);
	
	/**
	 * 친구상태를 'Y'로 UPDATE
	 * @param memberFriendVO
	 * @return 작업성공 : 1이상, 작업실패 : 0
	 */
	public int acceptFriend(MemberFriendVO memFriendVo);
	
	/**
	 * 친구 요청 거절시 행삭제
	 * @param memberFriendVO
	 * @return 작업성공 : 1이상, 작업실패 : 0
	 */
	public int deleteAccept(MemberFriendVO memFriendVo);
	
	/**
	 * count데이터 db에 인서트
	 * @param homeId
	 * @return 작업성공 : 1이상, 작업실패 : 0
	 */
	public int insertCount(String homeId);
	
	/**
	 * memId를 통해 home정보 가져오기
	 * @param memId 
	 * @return home에 대한 리스트 가져오기
	 */
	public List<HomeVO> memInfo(String memId);
	
	/**
	 * 오늘 접속한 회원의 count수를 조회
	 * @return 
	 */
	public int todayCount(String homeId);
	
	/**
	 * 그동안 홈피를 방문한 총 count수를 조회
	 * @return
	 */
	public int totalCount(String homeId);
	
	/**
	 * user와 friend의 member정보 조회
	 * @param memberVo
	 * @return member정보를 리스트로 받아옴
	 */
	public List<MemberFriendVO> memberInfo(String userId);
//	public int deleteFriend(String memId, String homeId);
	
}
