package photo.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import util.SqlMapClientFactory;
import vo.PhotoVO;
import vo.ReplyVO;

public class PhotoDaoImpl implements IPhotoDao {
	private SqlMapClient client;
	private static PhotoDaoImpl dao;
	private PhotoDaoImpl() {
		client =  SqlMapClientFactory.getSqlMapClient();
	}
	public static IPhotoDao getDao() {
		if(dao==null) dao = new PhotoDaoImpl();
		return dao;
	}

	@Override
	public void insertBoard(PhotoVO vo) throws SQLException {
		client.insert("photo.insertBoard",vo);

	}

	@Override
	public PhotoVO getBoard(int boardNo) throws SQLException {
		return (PhotoVO) client.queryForObject("photo.getBoard", boardNo);
	}

	@Override
	public List<PhotoVO> boardList(String homeId) throws SQLException {
		return client.queryForList("photo.boardList", homeId);

	}

	@Override
	public void updateBoard(PhotoVO vo) throws SQLException {
		client.update("photo.updateBoard", vo);

	}

	@Override
	public void deleteBoard(int boardNo) throws SQLException {
		client.delete("photo.deleteBoard", boardNo);

	}

	@Override
	public int insertComment(ReplyVO vo) throws SQLException {
		return (Integer) client.insert("photo.insertComment", vo);
	}

	@Override
	public ReplyVO getReply(int commentNo, int boardNo) throws SQLException {
		Map<String, Integer> noParam = new HashMap<String, Integer>();
		noParam.put("comment_no", commentNo);
		noParam.put("board_no", boardNo);
		
		return (ReplyVO) client.queryForObject("photo.getReply", noParam);
	}

	@Override
	public List<ReplyVO> getAllReply(int boardNo) throws SQLException {
		return  client.queryForList("photo.getAllReply", boardNo);
	}

	@Override
	public int updateReply(ReplyVO vo) throws SQLException {
		return client.update("photo.updateReply", vo);
	}

	@Override
	public void deleteReply(int commentNo) throws SQLException {
		client.delete("photo.deleteReply", commentNo);

	}

	@Override
	public ReplyVO getUpdateSelectReply(int commentNo) throws SQLException {
		return (ReplyVO) client.queryForObject("photo.getUpdateSelectReply", commentNo);
	}

}
