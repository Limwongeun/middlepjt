package member.dao;

import java.sql.SQLException;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import util.SqlMapClientFactory;
import vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {

	private SqlMapClient smc;
	private static MemberDaoImpl dao;

	private MemberDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static IMemberDao getDao() {
		if (dao == null) dao = new MemberDaoImpl();

		return dao;
	}

	@Override
	public String idCheck(String id) throws SQLException {
		return (String) smc.queryForObject("member.idCheck", id);
	}

	@Override
	public int insertMember(MemberVO vo) throws SQLException {
		System.out.println("아이디 : " + vo.getMem_id());

//		return (String) smc.queryForObject("member.insertMember", vo); 

//		return (String) smc.insert("member.insertMember", vo);

		int insertYn = smc.update("member.insertMember", vo);
		return insertYn;

	}

	@Override
	public String loginCheck(MemberVO vo) throws SQLException {

		return (String) smc.queryForObject("member.loginCheck", vo);
	}

	@Override
	public String getHomeId(String homeId) throws SQLException {

		return (String) smc.queryForObject("home.getHomeId", homeId);
	}

	@Override
	public MemberVO getMemberName(String memId) throws SQLException {
		return (MemberVO) smc.queryForObject("member.getMemInfo", memId);
	}

	@Override
	public int updateMember(MemberVO vo) throws SQLException {
		return smc.update("member.updateMember", vo);
	}
	
	@Override
	public int setDotori(String memId) throws SQLException {
		int cnt = smc.update("member.setDotori", memId);
		return cnt;
	}

	@Override
	public int orderDotori(Map<String, String> map) throws SQLException {
		int cnt = smc.update("member.orderDotori", map);
		return cnt;
	}

	@Override
	public int getDotori(String memId) throws SQLException {
		int dotori = (int) smc.queryForObject("member.getDotori", memId);
		return dotori;
	}

}
