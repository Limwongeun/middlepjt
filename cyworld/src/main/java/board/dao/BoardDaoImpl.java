package board.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import util.SqlMapClientFactory;
import vo.BoardVO;
import vo.ReplyVO;


public class BoardDaoImpl implements IBoardDao {
	private SqlMapClient client;
	private static BoardDaoImpl dao;
	private BoardDaoImpl() {
		client =  SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IBoardDao getDao() {
		if(dao ==null) dao = new BoardDaoImpl();
		return dao;
	}

	public void insertBoard(BoardVO vo) throws SQLException {
		
//		return (Integer)client.insert("board.insertBoard",vo);
		client.insert("board.insertBoard",vo);
	}

	public BoardVO getBoard(int boardNo) throws SQLException {
		
		return (BoardVO) client.queryForObject("board.getBoard", boardNo);
	}

	public List<BoardVO> boardList(String homeId) throws SQLException {
		
		return client.queryForList("board.boardList",homeId);
	}

	public void updateBoard(BoardVO vo) throws SQLException {
		
//		return client.update("board.updateBoard", boardNo);
		client.update("board.updateBoard", vo);
	}

	public void deleteBoard(int boardNo) throws SQLException {
		client.delete("board.deleteBoard", boardNo);
		
	}

	public int insertComment(ReplyVO vo) throws SQLException {
		
		return (Integer) client.insert("board.insertComment", vo);
	}

	public ReplyVO getReply(int commentNo, int boardNo) throws SQLException {
		Map<String, Integer> noParam = new HashMap<String, Integer>();
		noParam.put("comment_no", commentNo);
		noParam.put("board_no", boardNo);
		
		return (ReplyVO) client.queryForObject("board.getReply", noParam);
	}

	public List<ReplyVO> getAllReply(int boardNo) throws SQLException {
		
		return  client.queryForList("board.getAllReply", boardNo);
	}

	@Override
	public int updateReply(ReplyVO vo) throws SQLException {
		
		return client.update("board.updateReply", vo);
	}

	@Override
	public int deleteReply(int commentNo) throws SQLException {
		
		return client.delete("board.deleteReply", commentNo);
	}

	@Override
	public ReplyVO getUpdateSelectReply(int commentNo) throws SQLException{
		
		return (ReplyVO) client.queryForObject("board.getUpdateSelectReply", commentNo);
	}

	@Override
	public int countBoard(String homeId) throws SQLException {
		
		return (int) client.queryForObject("board.countBoard",homeId);
	}

	
	
	

	
	
}
