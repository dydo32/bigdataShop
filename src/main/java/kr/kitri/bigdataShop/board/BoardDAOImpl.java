package kr.kitri.bigdataShop.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boarddao")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<BoardDTO> boardList() {
		return sqlSession.selectList("kr.kitri.bigdataShop.board.boardlist");
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
	public int insert(BoardDTO data) {
		return sqlSession.insert("kr.kitri.bigdataShop.board.insert", data);
	}

	@Override
	public int fileInsert(ArrayList<String> filelist) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		map.put("fileName", filelist);
		return sqlSession.insert("kr.kitri.bigdataShop.board.fileinsert", map);
	}

	@Override
	public int delete(String board_no) {
		return sqlSession.update("kr.kitri.bigdataShop.board.delete", board_no);
	}

	@Override
	public int filedelete(String board_no) {
		return sqlSession.update("kr.kitri.bigdataShop.board.filedelete", board_no);
	}

	@Override
	public BoardDTO read(String board_no) {
		return sqlSession.selectOne("kr.kitri.bigdataShop.board.read", board_no);
	}

	@Override
	public String fileread(String board_no) {
		return sqlSession.selectOne("kr.kitri.bigdataShop.board.fileread", board_no);
	}
	
}
