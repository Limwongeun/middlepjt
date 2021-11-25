package prod.dao;

import java.util.List;

import vo.ProdImgVO;
import vo.ProdVO;

public interface IProdImgDao {

	public List<ProdImgVO> getBgmImg();

	public List<ProdImgVO> getSkinImg();

	public List<ProdImgVO> getMinimiImg();
	
	public List<ProdImgVO> getRoomImg();
	
	public List<ProdVO> getBgmNm();

	public List<ProdVO> getSkinNm();
	
	public List<ProdVO> getMinimiNm();

	public List<ProdVO> getRoomNm();
	
	public List<ProdVO> getBgmDotori(); // BGM 도토리용
	
	
	
}
