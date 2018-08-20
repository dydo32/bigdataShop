package kr.kitri.bigdataShop.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("productdao")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<ProductDTO> productlist(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> hitproduct() {
		List<ProductDTO> hitprdlist = sqlSession.selectList("kr.kitri.product.hitprd");
		return hitprdlist;
	}

	@Override
	public List<ProductDTO> newproduct() {
		List<ProductDTO> newprdlist = sqlSession.selectList("kr.kitri.product.newprd");
		return newprdlist;
	}

	@Override
	public ProductDTO read(String prd_no) {
		// TODO Auto-generated method stub
		return null;
	}

}
