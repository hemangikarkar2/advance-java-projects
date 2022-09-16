package com.demo1.Dao;

import java.util.List;

import com.demo1.Model.RegisteVO;

public interface RegisterDAO {

	public void insert(RegisteVO registerVo);

	public List search();

	public List deleteEdit(RegisteVO registerVo);
}
		