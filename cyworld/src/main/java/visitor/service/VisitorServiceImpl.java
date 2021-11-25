package visitor.service;

import java.sql.SQLException;
import java.util.List;

import visitor.dao.IVisitorDao;
import visitor.dao.VisitorDaoImpl;
import vo.VisitorVO;

public class VisitorServiceImpl implements IVisitorService{
	private IVisitorDao  dao;
	private static IVisitorService service;
	
	private VisitorServiceImpl() {
		dao = VisitorDaoImpl.getDao();
	}
	
	public static IVisitorService getService() {
		if(service == null) service = new VisitorServiceImpl();
		return service;
	}
	@Override
	public void insertVisitor(VisitorVO vo) {
		try {
			dao.insertVisitor(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<VisitorVO> visitorList(String homeId) {
		List<VisitorVO> list = null;
		try {
			list = dao.visitorList(homeId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int updateVisitor(VisitorVO vo) {
		int cnt =0;
		try {
			cnt = dao.updateVisitor(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteVisitor(int visitorNo) {
		int cnt = 0;
		try {
			cnt = dao.deleteVisitor(visitorNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public VisitorVO selectVisitor(int visitorNo) {
		VisitorVO vo = null;
		try {
			vo = dao.selectVisitor(visitorNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int updateSecret(VisitorVO vo) {
		int cnt = 0;
		try {
			cnt = dao.updateSecret(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public String visitorMinimi(String memId) {
		String minimi = null;
		try {
			minimi = dao.visitorMinimi(memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return minimi;
	}

}
