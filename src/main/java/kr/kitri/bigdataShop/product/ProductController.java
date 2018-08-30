package kr.kitri.bigdataShop.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kitri.bigdataShop.product.comment.ProductCommentDTO;
import kr.kitri.bigdataShop.product.comment.ProductCommentService;

@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
	@Autowired
	ProductCommentService service2;
	
	//전체상품보기, 카테고리별 보기
	@RequestMapping("/product/list.do")
	public String list(String category, Model model){
		//System.out.println(category);
		List<ProductDTO> prdlist = service.productlist(category);
		model.addAttribute("prdlist",prdlist);	//db에서 조회한 결과 
												//서블릿에서 request.setAttribute
		return "product/list";
	}
	
	//상품상세보기
	@RequestMapping("/product/read.do")
	public String showProduct(String category_no,String prd_no, @CookieValue(value="prdNoCookie", required=false) Cookie prdNoCookie, HttpServletResponse res,Model model) {
		//System.out.println("상품조회:"+prd_no);
		
		//쿠키리스트
		Cookie cookie = null;
		ArrayList<ProductDTO> cookielist = new ArrayList<ProductDTO>();
		if(prdNoCookie==null) {
			cookie = new Cookie("prdNoCookie", prd_no);
			System.out.println("최초작업: "+prd_no);
			cookielist.add(service.read(prd_no));
		}else {
			String value = prdNoCookie.getValue();
			String[] str = value.split(",");
			value = prd_no;
			cookielist.add(service.read(prd_no));
			for(int i=0;i<str.length;i++) {
				if(str[i].equals(prd_no)) {
					System.out.println("같은값 존재");
				}else {
					value = value + "," + str[i];
					cookielist.add(service.read(str[i]));
				}
			}
			System.out.println("쿠키 저장값: "+value);
			cookie = new Cookie("prdNoCookie", value);
		}
		cookie.setMaxAge(60*60*24);
		res.addCookie(cookie);
	
		//상품상세정보
		ProductDTO product = service.read(prd_no);
		//댓글list
		List<ProductCommentDTO> prdcmtlist = service2.prdcmtlist(prd_no);
		
		model.addAttribute("product", product);
		model.addAttribute("prdcmtlist", prdcmtlist);
		model.addAttribute("cookielist", cookielist);
		return "product/read";
	}

}
