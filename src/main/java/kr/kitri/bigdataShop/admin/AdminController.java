package kr.kitri.bigdataShop.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	@Autowired
	AdminService service;
	
	
	@RequestMapping(value = "/admin/logResult.do", method = RequestMethod.GET)
	public ModelAndView showCommentResult() {
		ModelAndView mav = new ModelAndView();
		List<AdminLogDTO> resultlist = service.logResult();
		mav.addObject("resultlist", resultlist);
		mav.setViewName("admin/logresult");
		return mav;
	}
}
