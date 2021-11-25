package visitor.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import board.dao.BoardDaoImpl;
import board.dao.IBoardDao;
import util.SqlMapClientFactory;
import vo.VisitorVO;

public class VisitorDaoImpl implements IVisitorDao{
	private SqlMapClient client;
	private static VisitorDaoImpl dao;
	private VisitorDaoImpl() {
		client =  SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IVisitorDao getDao() {
		if(dao ==null) dao = new VisitorDaoImpl();
		return dao;
	}
	@Override
	public void insertVisitor(VisitorVO vo) throws SQLException {
		client.insert("visitor.insertVisitor", vo);
		
	}

	@Override
	public List<VisitorVO> visitorList(String homeId) throws SQLException {
		
		return client.queryForList("visitor.visitorList", homeId);
	}

	@Override
	public int updateVisitor(VisitorVO vo) throws SQLException {
		
		return client.update("visitor.updateVisitor", vo);
	}

	@Override
	public int deleteVisitor(int visitorNo) throws SQLException {
		
		return client.delete("visitor.deleteVisitor", visitorNo);
	}

	@Override
	public VisitorVO selectVisitor(int visitorNo) throws SQLException {
		
		return (VisitorVO) client.queryForObject("visitor.selectVisitor", visitorNo);
	}

	@Override
	public int updateSecret(VisitorVO vo) throws SQLException {
		
		return client.update("visitor.updateSecret", vo);
	}

	@Override
	public String visitorMinimi(String memId) throws SQLException {
		return (String) client.queryForObject("visitor.visitorMinimi", memId);
	}

}
