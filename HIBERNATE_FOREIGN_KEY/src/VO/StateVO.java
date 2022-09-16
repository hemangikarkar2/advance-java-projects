package VO;

public class StateVO 
{
	private int id;
	private String sn;
	private CountryVO c;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public CountryVO getC() {
		return c;
	}
	public void setC(CountryVO c) {
		this.c = c;
	}

}
