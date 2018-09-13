package kr.kitri.bigdataShop.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	@Qualifier("admindao")
	AdminDAO dao;

	@Override
	public List<AdminLogDTO> logResult() {
		
		return dao.logResult();
	}

	

}
