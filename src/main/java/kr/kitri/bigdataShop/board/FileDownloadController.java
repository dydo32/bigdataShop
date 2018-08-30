package kr.kitri.bigdataShop.board;

import java.io.File;

import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.ApplicationContextAware;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileDownloadController implements ApplicationContextAware{
		private WebApplicationContext context = null;
     
	    @RequestMapping("/board/download.do")
	    public ModelAndView download(@RequestParam("path")String path,
	                                  @RequestParam("fileName")String fileName){
	        String fullPath = path + "\\" + fileName;
	        File file = new File(fullPath);
	        //ModelAndView(String viewName, String modelName, Object modelObject) 
	        return new ModelAndView("download", "downloadFile", file);
	    }
	 
	    @Override
	    public void setApplicationContext(ApplicationContext arg0)
	            throws BeansException {
	        this.context = (WebApplicationContext)arg0;
	    }
}
