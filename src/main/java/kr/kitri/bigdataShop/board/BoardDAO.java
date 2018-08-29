package kr.kitri.bigdataShop.board;

import java.util.ArrayList;
import java.util.List;

public interface BoardDAO {
	List<BoardDTO> boardList();
	List<BoardDTO> searchList(String search);
	List<BoardDTO> searchList(String tag,String search);
	List<BoardDTO> pageList();
	int insert(BoardDTO data);
	int fileInsert(ArrayList<String> filelist);
	int delete(String board_no);
	int filedelete(String board_no);
	BoardDTO read(String board_no);
	List<String> fileread(String board_no);
}
