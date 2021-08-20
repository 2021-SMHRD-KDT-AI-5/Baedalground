package model;

public class communityDTO {
	private String address;
	private String order_time;
	private String res_name;
	private String number_of_p;
	
	public communityDTO(String address, String order_time, String res_name, String number_of_p) {
		super();
		this.address = address;
		this.order_time = order_time;
		this.res_name = res_name;
		this.number_of_p = number_of_p;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrder_time() {
		return order_time;
	}

	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}

	public String getRes_name() {
		return res_name;
	}

	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}

	public String getNumber_of_p() {
		return number_of_p;
	}

	public void setNumber_of_p(String number_of_p) {
		this.number_of_p = number_of_p;
	}
	
	
}
