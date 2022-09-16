package com.demo1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo1.Dao.RegisterDAO;
import com.demo1.Model.RegisteVO;


@Service
@Transactional
public class RegisterServiceImp implements RegisterService {

	@Autowired
	private RegisterDAO registerDao;

	
	
	public void insert(RegisteVO registerVo){
		this.registerDao.insert(registerVo);
	}
	public List search(){
		return this.registerDao.search();
		
	}
	
	public List deleteEdit(RegisteVO registerVo){
		return this.registerDao.deleteEdit(registerVo);
		
	}

}
