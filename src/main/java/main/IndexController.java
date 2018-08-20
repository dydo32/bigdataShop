package main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.kitri.bigdataShop.product.ProductDTO;
import kr.kitri.bigdataShop.product.ProductService;

@Controller
public class IndexController{

	@Autowired
	ProductService service;
	
	@RequestMapping("/index.do")
	public ModelAndView main(){
		//System.out.println("어노테이션 기반");
		//히트상품과 뉴상품을 조회하는 서비스의 메소드를 호출하고 ModelAndView에 히트상품과 뉴상품을 attribute로 저장
		ModelAndView mav = new ModelAndView();
		List<ProductDTO> newprdlist = service.newproduct();
		List<ProductDTO> hitprdlist = service.hitproduct();
		mav.addObject("newprdlist",newprdlist);
		mav.addObject("hitprdlist",hitprdlist);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/admin/index.do")
	public String adminmain(){
		System.out.println("어노테이션 기반");
		return "admin/index";
	}
}
