package visitor.dao;

import java.sql.SQLException;
import java.util.List;

import vo.VisitorVO;

public interface IVisitorDao {
	public void insertVisitor(VisitorVO vo) throws SQLException;
	
	public List<VisitorVO> visitorList(String homeId)throws SQLException;
	
	public int updateVisitor(VisitorVO vo)throws SQLException; 
	
	public int deleteVisitor(int visitorNo)throws SQLException;
	
	public VisitorVO selectVisitor(int visitorNo)throws SQLException;
	
	public int updateSecret(VisitorVO vo)throws SQLException;
	
	public String visitorMinimi(String memId) throws SQLException;
}
