package model;

public class restaurantDTO {
	private String res_id;
	private String res_pw;
	private String res_name;
	private String res_address;
	private int call_num;
	
	public restaurantDTO(String res_id, String res_pw, String res_name, String res_address, int call_num) {
		super();
		this.res_id = res_id;
		this.res_pw = res_pw;
		this.res_name = res_name;
		this.res_address = res_address;
		this.call_num = call_num;
	}

	public String getRes_id() {
		return res_id;
	}

	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}

	public String getRes_pw() {
		return res_pw;
	}

	public void setRes_pw(String res_pw) {
		this.res_pw = res_pw;
	}

	public String getRes_name() {
		return res_name;
	}

	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}

	public String getRes_address() {
		return res_address;
	}

	public void setRes_address(String res_address) {
		this.res_address = res_address;
	}

	public int getCall_num() {
		return call_num;
	}

	public void setCall_num(int call_num) {
		this.call_num = call_num;
	}
	
	
}
