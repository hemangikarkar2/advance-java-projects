package com.demo.DAO;

import java.util.List;

import com.demo.model.RegisterVO;

public interface RegisterDAO {

	public void insert(RegisterVO regVO);
	
	public List search();
	
	public List deleteEdit(RegisterVO regVO);
	
	
}
