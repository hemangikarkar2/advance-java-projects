package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Spring_Reg")
public class RegisterVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	
	@Column(name="FirstName")
	private String firstName; 
	
	
	@Column(name="LastName")
	private String lastName;

	
	@ManyToOne
	@JoinColumn(name="loginId")
	private LoginVO loginVO;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public LoginVO getLoginVO() {
		return loginVO;
	}


	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	
	

}
