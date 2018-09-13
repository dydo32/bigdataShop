package kr.kitri.bigdataShop.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("admindao")
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<AdminLogDTO> logResult() {
		
		return sqlSession.selectList("kr.kitri.bigdataShop.admin.log_result");
	}

	
	
}
