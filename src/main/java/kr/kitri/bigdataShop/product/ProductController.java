package kr.kitri.bigdataShop.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	
	@RequestMapping("/product/list.do")
	public String list(){
		System.out.println("어노테이션 기반");
		return "product/prdlist";
	}
	@RequestMapping("/product/list2.do")
	public String list2(){
		System.out.println("어노테이션 기반");
		return "product/prdlist2";
	}
}
