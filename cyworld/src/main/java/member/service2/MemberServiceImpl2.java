package member.service2;

import member.dao2.IMemberDao2;
import member.dao2.MemberDaoImpl2;
import member.service2.IMemberService2;
import member.service2.MemberServiceImpl2;
import vo.MemberVO;

public class MemberServiceImpl2 implements IMemberService2 {
	private IMemberDao2 memDao;
	private static MemberServiceImpl2 service;
	private MemberServiceImpl2() {
		memDao = MemberDaoImpl2.getInstance();
	}
	public static MemberServiceImpl2 getInstance() {
		if(service==null) service = new MemberServiceImpl2();
		return service;
	}
	@Override
	public MemberVO getMemInfo(String memId) {
		// TODO Auto-generated method stub
		return memDao.getMemInfo(memId);
	}
	
	

} 