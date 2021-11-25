package member.dao2;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import member.dao2.IMemberDao2;
import member.dao2.MemberDaoImpl2;
import util.SqlMapClientFactory;
import vo.MemberVO;

public class MemberDaoImpl2 implements IMemberDao2 {
	private static MemberDaoImpl2 dao;
	private SqlMapClient smc;
	private MemberDaoImpl2() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	public static MemberDaoImpl2 getInstance(){
		if(dao==null) dao = new MemberDaoImpl2();
		return dao;
	}
	@Override
	public MemberVO getMemInfo(String memId) {
		MemberVO memVo = null;
		try {
			memVo = (MemberVO)smc.queryForObject("member.getMemInfo",memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memVo;
	}

} 