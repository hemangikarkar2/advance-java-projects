package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.RegDAO;
import com.demo.model.LoginVO;
import com.demo.model.RegVO;

@Service
@Transactional
public class RegServiceImp implements RegService {

	@Autowired private RegDAO regDAO;
	public void insert(RegVO regVO) {
			this.regDAO.insert(regVO);
	}

	public  void insertLogin(LoginVO loginVO) {
		// TODO Auto-generated method stub
			this.regDAO.insertLogin(loginVO);
	}

	
	public List searchRegister() {
		// TODO Auto-generated method stub
		return this.regDAO.searchRegister();
	}

}
