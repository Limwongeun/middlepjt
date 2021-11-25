package photo.dao;

import java.sql.SQLException;
import java.util.List;

import vo.PhotoVO;
import vo.ReplyVO;

public interface IPhotoDao {
	public void insertBoard(PhotoVO vo) throws SQLException;
	
	public PhotoVO getBoard(int boardNo)throws SQLException;
	
	public List<PhotoVO> boardList(String homeId)throws SQLException;
	
	public void updateBoard(PhotoVO vo)throws SQLException;
	
	public void deleteBoard(int boardNo)throws SQLException;
	
	public int insertComment(ReplyVO vo)throws SQLException;
	
	public ReplyVO getReply(int commentNo, int boardNo)throws SQLException;
	
	public List<ReplyVO> getAllReply(int boardNo)throws SQLException;
	
	public int updateReply(ReplyVO vo)throws SQLException;
	
	public void deleteReply(int commentNo)throws SQLException;
	
	public ReplyVO getUpdateSelectReply(int commentNo)throws SQLException;
	
	
}
