package kr.kitri.bigdataShop.product.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class ProductCommentServiceImpl implements ProductCommentService {

	@Autowired
	@Qualifier("prdcmtdao")
	ProductCommentDAO dao;

	@Override
	public int prdcmtinsert(ProductCommentDTO prdcmtDTO) {
		return dao.prdcmtinsert(prdcmtDTO);
	}

	@Override
	public List<ProductCommentDTO> prdcmtlist(String prd_no) {
		return dao.prdcmtlist(prd_no);
	}

	@Override
	public int prdcmtdelete(String prdcmt_no) {
		return dao.prdcmtdelete(prdcmt_no);
	}
	
	@Override
	public List<CommentResultDTO> commentResult() {
		return dao.commentResult();
	}

}
