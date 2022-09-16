package com.demo.dao;

import java.util.List;

import com.demo.model.LoginVO;
import com.demo.model.RegVO;

public interface RegDAO {

	public void insert(RegVO regVO);
	public void insertLogin(LoginVO loginVO);
	public List searchRegister();
}
