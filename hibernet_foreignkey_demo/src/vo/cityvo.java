package vo;


public class cityvo {

	private int id;
	private String city;
	private countryvo con;
	private statevo sta;
	
	
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
	public countryvo getCon() {
		return con;
	}
	public void setCon(countryvo con) {
		this.con = con;
	}
	public statevo getSta() {
		return sta;
	}
	public void setSta(statevo sta) {
		this.sta = sta;
	}
}
