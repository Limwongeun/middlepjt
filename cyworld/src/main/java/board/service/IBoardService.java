package board.service;

import java.sql.SQLException;
import java.util.List;

import vo.BoardVO;
import vo.ReplyVO;

public interface IBoardService {
	
	public int countBoard(String homeId);
	public void insertBoard(BoardVO vo);
	
	public BoardVO getBoard(int boardNo);
	
	public List<BoardVO> boardList(String homeId);
	
	public void updateBoard(BoardVO vo);
	
	public void deleteBoard(int boardNo);
	
	public int insertComment(ReplyVO vo);
	
	public ReplyVO getReply(int commentNo, int boardNo);
	
	public List<ReplyVO> getAllReply(int boardNo);
	
	public int updateReply(ReplyVO vo);
	
	public int deleteReply(int commentNo);
	
	public ReplyVO getUpdateSelectReply(int commentNo);
}
