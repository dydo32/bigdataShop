package kr.kitri.bigdataShop.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	@Qualifier("boarddao")
	BoardDAO dao;
	
	@Override
	public List<BoardDTO> boardList() {
		return dao.boardList();
	}

	@Override
	public List<BoardDTO> searchList(String search) {
		return null;
	}

	@Override
	public List<BoardDTO> searchList(String tag, String search) {
		return null;
	}

	@Override
	public List<BoardDTO> pageList() {
		return null;
	}
	
	@Override
	public int txinsert(BoardDTO data, ArrayList<String> filelist) {
		int result1 = dao.insert(data);
		int result2 = 0;
		System.out.println(filelist.size());
		if(filelist.size()!=0) {
			result2 = dao.fileInsert(filelist);
		}
		return result1+result2;
	}

	@Override
	public int txdelete(String board_no) {
		int result = 0;
		if(dao.fileread(board_no).size()>0) {
			result = dao.delete(board_no);
			dao.filedelete(board_no);
		}else {
			result = dao.delete(board_no);
		}
		return result;
	}

	@Override
	public BoardDTO read(String board_no) {
		return dao.read(board_no);
	}

	@Override
	public List<String> fileread(String board_no) {
		return dao.fileread(board_no);
	}
	

}
