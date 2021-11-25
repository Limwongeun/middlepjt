package board.dao;

import java.sql.SQLException;
import java.util.List;

import vo.BoardVO;
import vo.ReplyVO;

public interface IBoardDao {
	public int countBoard(String homeId) throws SQLException;
	
	public void insertBoard(BoardVO vo) throws SQLException;
	
	public BoardVO getBoard(int boardNo)throws SQLException;
	
	public List<BoardVO> boardList(String homeId)throws SQLException;
	
	public void updateBoard(BoardVO vo)throws SQLException;
	
	public void deleteBoard(int boardNo)throws SQLException;
	
	public int insertComment(ReplyVO vo)throws SQLException;
	
	public ReplyVO getReply(int commentNo, int boardNo)throws SQLException;
	
	public List<ReplyVO> getAllReply(int boardNo)throws SQLException;
	
	public int updateReply(ReplyVO vo)throws SQLException;
	
	public int deleteReply(int commentNo)throws SQLException;
	
	public ReplyVO getUpdateSelectReply(int commentNo)throws SQLException;
}
