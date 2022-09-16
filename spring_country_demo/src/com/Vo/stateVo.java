package com.Vo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="state_sptbl")
public class stateVo {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="StateId")
		private int stateId;
		
		@Column(name="StateName")
		private String stateName;
		
		@Column(name="Status")
		private boolean status=false;
		
		@ManyToOne
		@JoinColumn(name="countryId")
		countryVo countryVo;

		public int getStateId() {
			return stateId;
		}

		public void setStateId(int stateId) {
			this.stateId = stateId;
		}

		public String getStateName() {
			return stateName;
		}

		public void setStateName(String stateName) {
			this.stateName = stateName;
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public countryVo getCountryVo() {
			return countryVo;
		}

		public void setCountryVo(countryVo countryVo) {
			this.countryVo = countryVo;
		}

		}
		


