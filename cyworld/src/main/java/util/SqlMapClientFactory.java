package util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
	private static SqlMapClient smc;
	static {
		try {
			// Dao의 생성자에서 iBatis 환경 설정 및 iBatis용 객체를 생성하는 일을 한다.
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset); // 리소스는 ibatis껄로

			// 환경 설정 파일을 읽어온다.
			Reader rd = Resources.getResourceAsReader("ibatis/config/sqlMapConfig.xml");

			// 위에서 읽어온 Reader객체를 이용하여 실제 환경 설정을 완성한 후
			// 작성된 SQL문을 호출해서 처리할 객체를 생성한다.(= smc)
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close(); // Reader객체 닫기

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlMapClient getSqlMapClient() {
		return smc;
	}
	
}
