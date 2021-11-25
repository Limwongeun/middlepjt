package prod.service;

import java.util.List;

import prod.dao.IProdImgDao;
import prod.dao.ProdImgDaoImpl;
import vo.ProdImgVO;
import vo.ProdVO;

public class ProdImgServiceImpl implements IProdImgService {

	private IProdImgDao dao;
	
	private static ProdImgServiceImpl service;
	
	private ProdImgServiceImpl() {
		dao = ProdImgDaoImpl.getInstance();
	}
	
	public static ProdImgServiceImpl getInstance() {
		if(service == null) service = new ProdImgServiceImpl();
		return service;
	}
	@Override
	public List<ProdImgVO> getBgmImg() {
		return dao.getBgmImg();
	}

	@Override
	public List<ProdVO> getBgmNm() {
		return dao.getBgmNm();
	}

	@Override
	public List<ProdVO> getBgmDotori() {
		return dao.getBgmDotori();
	}


	@Override
	public List<ProdImgVO> getSkinImg() {
		return dao.getSkinImg();
	}

	@Override
	public List<ProdVO> getSkinNm() {
		return dao.getSkinNm();
	}

	@Override
	public List<ProdVO> getMinimiNm() {
		return dao.getMinimiNm();
	}

	@Override
	public List<ProdVO> getRoomNm() {
		return dao.getRoomNm();
	}

	@Override
	public List<ProdImgVO> getMinimiImg() {
		return dao.getMinimiImg();
	}

	@Override
	public List<ProdImgVO> getRoomImg() {
		return dao.getRoomImg();
	}

}
