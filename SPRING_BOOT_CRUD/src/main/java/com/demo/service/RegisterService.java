package com.demo.service;

import java.util.List;

import com.demo.model.RegisterVO;

public interface RegisterService {

	public void insert(RegisterVO registerVO);
	
	public List search();
	
	public List deleteEdit(RegisterVO registerVO);
	
	
}
