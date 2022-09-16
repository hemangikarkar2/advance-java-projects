package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SP_State")
public class StateVO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="StateId")
	private int stateId;
	
	@Column(name="StateName")
	private String stateName;
	
	
	@Column(name="Status")
	private boolean status=false;
	

	@ManyToOne CountryVO countryVO;


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


	public CountryVO getCountryVO() {
		return countryVO;
	}


	public void setCountryVO(CountryVO countryVO) {
		this.countryVO = countryVO;
	}
	

}
