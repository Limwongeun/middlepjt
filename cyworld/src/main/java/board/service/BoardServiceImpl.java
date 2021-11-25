package board.service;

import java.sql.SQLException;
import java.util.List;

import board.dao.BoardDaoImpl;
import board.dao.IBoardDao;
import vo.BoardVO;
import vo.ReplyVO;

public class BoardServiceImpl implements IBoardService{
	private IBoardDao  dao;
	private static IBoardService service;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getDao();
	}
	
	public static IBoardService getService() {
		if(service == null) service = new BoardServiceImpl();
		return service;
	}

	public void insertBoard(BoardVO vo) {
	//	int board =0;
		try {
		//	board= dao.insertBoard(vo);
			dao.insertBoard(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	//	return board;
	}

	public BoardVO getBoard(int boardNo) {
		BoardVO vo = null;
		try {
			vo = dao.getBoard(boardNo);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return vo;
	}

	public List<BoardVO> boardList(String homeId) {
		List<BoardVO> list = null;
		try {
			list = dao.boardList(homeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void updateBoard(BoardVO vo) {
//		int update =0;
		try {
			dao.updateBoard(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return update;
	}

	public void deleteBoard(int boardNo) {
		try {
		
			dao.deleteBoard(boardNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public int deleteReply(int commentNo) {
		int cnt = 0;
		try {
		 cnt = dao.deleteReply(commentNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
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

	@Override
	public int countBoard(String homeId) {
		int cnt=0;
		try {
			cnt=dao.countBoard(homeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	
	

	

	

}
