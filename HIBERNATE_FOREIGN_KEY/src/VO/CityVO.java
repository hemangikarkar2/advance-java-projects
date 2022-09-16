package VO;

public class CityVO 
{
	private int id;
	private String city;
	private CountryVO c;
	private StateVO sv;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public CountryVO getC() {
		return c;
	}
	public void setC(CountryVO c) {
		this.c = c;
	}
	public StateVO getSv() {
		return sv;
	}
	public void setSv(StateVO sv) {
		this.sv = sv;
	}
}
