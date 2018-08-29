package kr.kitri.bigdataShop.board;

import java.util.ArrayList;
import java.util.List;

public interface BoardService {
	List<BoardDTO> boardList();
	List<BoardDTO> searchList(String search);
	List<BoardDTO> searchList(String tag,String search);
	List<BoardDTO> pageList();
	int txinsert(BoardDTO data,ArrayList<String> filelist) ;
	int txdelete(String board_no);
	BoardDTO read(String board_no);
	List<String> fileread(String board_no);
}
