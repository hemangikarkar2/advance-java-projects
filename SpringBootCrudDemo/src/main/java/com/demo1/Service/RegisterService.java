package com.demo1.Service;

import java.util.List;

import com.demo1.Model.RegisteVO;

public interface RegisterService {

	public void insert(RegisteVO registerVo);
	
	public List search();
	
	public List deleteEdit(RegisteVO registerVo);

}
