package kr.kitri.bigdataShop.product.comment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductCommentController {
	@Autowired
	ProductCommentService service;
	

	@RequestMapping(value = "/product/cmtinsert.do", method=RequestMethod.GET, produces="application/json;charset=utf-8" )
	public @ResponseBody List<ProductCommentDTO> cmtinsert(ProductCommentDTO prdcmt) {
		int result = service.prdcmtinsert(prdcmt);
		System.out.println(result+"개 prdcmt 삽입 성공");
		List<ProductCommentDTO> prdcmtlist = service.prdcmtlist(prdcmt.getPrd_no());
		return prdcmtlist;
	}
	
	@RequestMapping(value = "/product/cmtdelete.do", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public @ResponseBody List<ProductCommentDTO> cmtdelete(ProductCommentDTO prdcmt) {
		int result = service.prdcmtdelete(prdcmt.getPrdcmt_no());
		System.out.println(result+"개 삭제 성공");
		List<ProductCommentDTO> prdcmtlist = service.prdcmtlist(prdcmt.getPrd_no());
		return prdcmtlist;
	}
	
	@RequestMapping(value = "/comment/result.do", method = RequestMethod.GET)
	public ModelAndView showCommentResult() {
		ModelAndView mav = new ModelAndView();
		List<CommentResultDTO> resultList = service.commentResult();
		List<CommentResultDTO> tableList = new ArrayList<CommentResultDTO>();
		int size = resultList.size();
		tableList.add(resultList.get(0));
		for (int i = 1; i < size; i++) {
			if (!resultList.get(i).getContent().equals(resultList.get(i - 1).getContent())) {
				CommentResultDTO result = resultList.get(i);
				tableList.add(result);
			}
			if (tableList.size() == 10) {
				break;
			}
		}
		List<CommentResultDTO> tableList2 = new ArrayList<CommentResultDTO>();
		for (int i = 0; i < size; i++) {
			CommentResultDTO result = resultList.get(i);
			tableList2.add(result);
			if (size == 50) {
				break;
			}
		}
		mav.addObject("resultList", resultList);
		mav.addObject("tableList2", tableList2);
		mav.addObject("tableList", tableList);
		mav.setViewName("comment/result");
		return mav;
	}
}
