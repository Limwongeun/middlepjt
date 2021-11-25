package test.service;

import java.util.List;

import test.dao.ITestDao;
import test.dao.TestDaoImpl;
import test.vo.TestVO;

public class TestServiceImpl implements ITestService {

	private ITestDao dao;
	
	private static TestServiceImpl service;
	
	private TestServiceImpl() {
		dao = TestDaoImpl.getInstance();
	}
	
	public static TestServiceImpl getInstance() {
		if(service == null) service = new TestServiceImpl();
		return service;
	}
	
	@Override
	public List<TestVO> getTestList() {
		// TODO Auto-generated method stub
		return dao.getTestList();
	}

}
