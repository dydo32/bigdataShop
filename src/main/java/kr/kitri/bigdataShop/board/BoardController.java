package kr.kitri.bigdataShop.board;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

@Controller
public class BoardController {
	@Autowired
	BoardService service;

	@Autowired
	FIleUploadLogic uploadservice;

	@RequestMapping("/board/list.do")
	public String list(Model model) {
		List<BoardDTO> boardlist = service.boardList();
		model.addAttribute("boardlist", boardlist);
		return "board/list";
	}

	@RequestMapping(value = "/board/insert.do", method = RequestMethod.POST)
	public String write(BoardDTO board, HttpSession session) throws FileNotFoundException {
		// 파일업로드
		MultipartFile[] file = board.getUpFile();
		String path = WebUtils.getRealPath(session.getServletContext(), "/WEB-INF/upload");
		// System.out.println(file.length);
		ArrayList<String> fileName = new ArrayList<String>();
		for (int i = 0; i < file.length; i++) {
			if (!file[i].getOriginalFilename().equals("")) {
				fileName.add(file[i].getOriginalFilename());
			}
		}
		// 파일업로드
		uploadservice.upload(file, path, fileName);
		// board, 첨부파일명 insert
		int result = service.txinsert(board, fileName);
		System.out.println(result + "개 삽입 성공");
		return "redirect:/board/list.do";

	}

	@RequestMapping("/board/delete.do")
	public String delete(String board_no) {
		int result = service.txdelete(board_no);
		System.out.println(result + "개 게시판 삭제 성공");
		return "board/list";
	}

	@RequestMapping("/board/read.do")
	public String read(String board_no, Model model) {
		BoardDTO board = service.read(board_no);
		List<String> fileName = service.fileread(board_no);
		String path="/WEB-INF/upload";
		model.addAttribute("fileName",fileName);
		model.addAttribute("path",path);
		model.addAttribute("board", board);
		return "board/read";
	}

}
