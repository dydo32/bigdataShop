package kr.kitri.bigdataShop.product.comment;

import java.util.List;

import kr.kitri.bigdataShop.product.ProductDTO;

public interface ProductCommentService {
	int prdcmtinsert(ProductCommentDTO prdcmtDTO);
	List<ProductCommentDTO> prdcmtlist();
	int prdcmtdelete();
}