package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.DAO.RegisterDAO;
import com.demo.model.RegisterVO;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDAO registerDAO;

	public void insert(RegisterVO registerVO) {
		this.registerDAO.insert(registerVO);
	}

	public List search() {

		return this.registerDAO.search();
	}

	public List deleteEdit(RegisterVO registerVO) {
		return this.registerDAO.deleteEdit(registerVO);
	}

}
