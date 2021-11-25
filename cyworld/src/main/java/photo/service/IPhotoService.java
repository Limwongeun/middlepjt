package photo.service;

import java.util.List;

import vo.PhotoVO;
import vo.ReplyVO;

	public interface IPhotoService {
	public void insertBoard(PhotoVO vo);
	
	public PhotoVO getBoard(int boardNo);
	
	public List<PhotoVO> boardList(String homeId);
	
	public void updateBoard(PhotoVO vo);
	
	public void deleteBoard(int boardNo);
	
	public int insertComment(ReplyVO vo);
	
	public ReplyVO getReply(int commentNo, int boardNo);
	
	public List<ReplyVO> getAllReply(int boardNo);
	
	public int updateReply(ReplyVO vo);
	
	public void deleteReply(int commentNo);
	
	public ReplyVO getUpdateSelectReply(int commentNo);
}
