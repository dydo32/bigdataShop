package kr.kitri.bigdataShop.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kitri.bigdataShop.product.comment.ProductCommentDTO;
import kr.kitri.bigdataShop.product.comment.ProductCommentService;

/*
 * 나중에 로그기록 객체를 따로 설계하고 난후에 AOP를 적용하면
 * Advice에서 처리할 일
 */
@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
	@Autowired
	ProductCommentService service2;
	
	protected static Logger logger = LoggerFactory.getLogger("myweb");
	
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
	public String showProduct(String category_no,String prd_no, @CookieValue(value="prdNoCookie", required=false) Cookie prdNoCookie, HttpServletResponse res,HttpServletRequest req,Model model) {
		//System.out.println("상품조회:"+prd_no);
	/*	logger.info("상품페이지에 접속함: "+prd_no);
		logger.info("접속한 IP: "+req.getRemoteAddr());
		logger.info("접속시간: "+new Date().toString());
		logger.info("접속아이디:(세션에서 꺼냈다 가정하고 -jang)");
		logger.info("요청구분:A요청");*/
		logger.info("상품페이지에 접속함: "+prd_no+","
				+"접속한 IP: "+req.getRemoteAddr()
				+"접속시간: "+new Date().toString()
				+"요청구분:A요청");
		
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
