package prod.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import util.SqlMapClientFactory;
import vo.ProdImgVO;
import vo.ProdVO;

public class ProdImgDaoImpl implements IProdImgDao {

	private static ProdImgDaoImpl dao;
	private SqlMapClient smc;
	
	private ProdImgDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static ProdImgDaoImpl getInstance() {
		if(dao == null) dao = new ProdImgDaoImpl();
		
		return dao;
	}
	
	@Override
	public List<ProdImgVO> getBgmImg() {
		List<ProdImgVO> listBI = new ArrayList<>();
		
		try {
			listBI = smc.queryForList("cy.getBgmImg");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBI;
	}

	@Override
	public List<ProdVO> getBgmNm() {
		List<ProdVO> listBN = new ArrayList<>();
		
		try {
			listBN = smc.queryForList("cy.getBgmNm");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listBN;
	}

	@Override
	public List<ProdVO> getBgmDotori() {
		List<ProdVO> listBD = new ArrayList<>();
		
		try {
			listBD = smc.queryForList("cy.getBgmDotori");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBD;
	}


	@Override
	public List<ProdImgVO> getSkinImg() {
		List<ProdImgVO> listSI = new ArrayList<>();
		
		try {
			listSI = smc.queryForList("cy.getSkinImg");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listSI;
	}

	@Override
	public List<ProdVO> getSkinNm() {
		List<ProdVO> listSN = new ArrayList<>();
		
		try {
			listSN = smc.queryForList("cy.getSkinNm");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listSN;
	}

	@Override
	public List<ProdVO> getMinimiNm() {
		List<ProdVO> listMN = new ArrayList<>();
		
		try {
			listMN = smc.queryForList("cy.getMinimiNm");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listMN;
	}

	@Override
	public List<ProdVO> getRoomNm() {
		List<ProdVO> listRN = new ArrayList<>();
		
		try {
			listRN = smc.queryForList("cy.getRoomNm");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listRN;
	}

	@Override
	public List<ProdImgVO> getMinimiImg() {
		List<ProdImgVO> listMI = new ArrayList<>();
		
		try {
			listMI = smc.queryForList("cy.getMinimiImg");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listMI;
	}

	@Override
	public List<ProdImgVO> getRoomImg() {
		List<ProdImgVO> listRI = new ArrayList<>();
		
		try {
			listRI = smc.queryForList("cy.getRoomImg");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listRI;
	}
}