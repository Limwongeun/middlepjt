package photo.service;

import java.sql.SQLException;
import java.util.List;

import photo.dao.IPhotoDao;
import photo.dao.PhotoDaoImpl;
import vo.PhotoVO;
import vo.ReplyVO;

public class PhotoServiceImpl implements IPhotoService {
	private IPhotoDao dao;
	private static IPhotoService service;
	
	private PhotoServiceImpl() {
		dao = PhotoDaoImpl.getDao();
	}
	public static IPhotoService getService() {
		if(service ==null) service = new PhotoServiceImpl();
		return service;
	}
	@Override
	public void insertBoard(PhotoVO vo) {
		try {
			dao.insertBoard(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public PhotoVO getBoard(int boardNo) {
		PhotoVO vo = null;
		try {
			vo = dao.getBoard(boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<PhotoVO> boardList(String homeId) {
		List<PhotoVO> list = null;
		try {
			list = dao.boardList(homeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateBoard(PhotoVO vo) {
		try {
			dao.updateBoard(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteBoard(int boardNo) {
		try {
			dao.deleteBoard(boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public int insertComment(ReplyVO vo) {
		int comment=0;
		try {
		comment=dao.insertComment(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comment;
	}

	public ReplyVO getReply(int commentNo, int boardNo) {
		ReplyVO vo = null;
		try {
			vo = dao.getReply(commentNo, boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public List<ReplyVO> getAllReply(int boardNo) {
		List<ReplyVO> list = null;
		try {
			list = dao.getAllReply(boardNo);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int updateReply(ReplyVO vo) {
		int update =0;
		try {
			update = dao.updateReply(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public void deleteReply(int commentNo) {
		
		try {
		 dao.deleteReply(commentNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ReplyVO getUpdateSelectReply(int commentNo) {
		ReplyVO vo = null;
		try {
			vo = dao.getUpdateSelectReply(commentNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

}
