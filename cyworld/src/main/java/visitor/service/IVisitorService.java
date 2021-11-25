package visitor.service;

import java.util.List;

import vo.VisitorVO;

public interface IVisitorService {
	public void insertVisitor(VisitorVO vo);
	
	public List<VisitorVO> visitorList(String homeId);
	
	public int updateVisitor(VisitorVO vo); 
	
	public int deleteVisitor(int visitorNo);
	
	public VisitorVO selectVisitor(int visitorNo);
	
	public int updateSecret(VisitorVO vo);
	
	public String visitorMinimi(String memId);	// 방명록 남긴 회원의 미니미 조회
}
