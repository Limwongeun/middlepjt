package member.service;

import java.sql.SQLException;
import java.util.Map;

import member.dao.IMemberDao;
import member.dao.MemberDaoImpl;
import vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	//객체를 얻어오기~ 
	private IMemberDao dao;
	private static IMemberService service;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getDao();
	}
	public static IMemberService getService() {
		if(service == null) service = new MemberServiceImpl();
		
		System.out.println("service : " + service);
		return service;
	}
	
	
	@Override
	public String idCheck(String id) {
		
		String memberId = null;
		try {
			System.out.println("serviceImpl");
			memberId = dao.idCheck(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberId;
	}
	@Override
	public int insertMember(MemberVO vo) {
		
		int ismb = 0;
		
		try {
			ismb = dao.insertMember(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ismb;
	}
	
	@Override
	public String loginCheck(MemberVO vo) throws Exception{
		return dao.loginCheck(vo);
	}
	
	@Override
	public String getHomeId(String homeId) {
		String home_Id = null;
		try {
			home_Id = dao.getHomeId(homeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return home_Id;
	}
	@Override
	public MemberVO getMemberName(String memId) throws Exception {
		MemberVO vo = null;
		try {
			vo = dao.getMemberName(memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	@Override
	public int updateMember(MemberVO vo) throws Exception {
		int result = 0;
		try {
			result = dao.updateMember(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int setDotori(String memId) throws Exception {
		int cnt = 0;
		try {
			cnt = dao.setDotori(memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int orderDotori(Map<String, String> map) throws Exception {
		int cnt = 0;
		try {
			cnt = dao.orderDotori(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int getDotori(String memId) throws Exception {
		int dotori = 0;
		try {
			dotori = dao.getDotori(memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dotori;
	}

}
