package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sb_login")

public class LoginVO {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		
		@Column(name="Id")
		private int id;
		
		
		@Column(name="UserName")
		private String userName;
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Column(name="Password")
		private String password;

		
		
		
		
}
