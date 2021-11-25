package test.dao;

import java.util.List;

import test.vo.TestVO;

public interface ITestDao {
	/**
	 * DB의 회원테이블의 전체 레코드를 가져와서 List에 담아서 반환하는 메서드
	 * @return 검색된 데이터가 저장된 List객체
	 */
	public List<TestVO> getTestList();
}
