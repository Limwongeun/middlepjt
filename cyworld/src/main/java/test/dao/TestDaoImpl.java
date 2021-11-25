package test.dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import test.vo.TestVO;

public class TestDaoImpl implements ITestDao {

	private static TestDaoImpl dao;
	private SqlMapClient smc;
	
	private TestDaoImpl() {
		try {
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
			
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static TestDaoImpl getInstance() {
		if(dao == null) dao = new TestDaoImpl();
		
		return dao;
	}
	
	
	@Override
	public List<TestVO> getTestList() {
		List<TestVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("test.getTest");
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		}
		return list;
	}

}
