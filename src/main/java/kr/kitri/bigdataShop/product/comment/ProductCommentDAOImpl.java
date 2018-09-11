package kr.kitri.bigdataShop.product.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("prdcmtdao")
public class ProductCommentDAOImpl implements ProductCommentDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public int prdcmtinsert(ProductCommentDTO prdcmt) {
		return sqlSession.insert("kr.kitri.bigdataShop.productcomment.insert", prdcmt);
	}

	@Override
	public List<ProductCommentDTO> prdcmtlist(String prd_no) {
		return sqlSession.selectList("kr.kitri.bigdataShop.productcomment.cmtlist", prd_no);
	}

	@Override
	public int prdcmtdelete(String prdcmt_no) {
		return sqlSession.delete("kr.kitri.bigdataShop.productcomment.delete", prdcmt_no);
	}
	
	@Override
	public List<CommentResultDTO> commentResult() {
		return  sqlSession.selectList("kr.kitri.bigdataShop.productcomment.comment_result");
	}	
	
}
