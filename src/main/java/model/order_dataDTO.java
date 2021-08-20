package model;

public class order_dataDTO {
	private String nick_name;
	private String res_name;
	private String menu_name;
	private int price;
	private String ordered_time;
	
	public order_dataDTO(String nick_name, String res_name, String menu_name, int price, String ordered_time) {
		super();
		this.nick_name = nick_name;
		this.res_name = res_name;
		this.menu_name = menu_name;
		this.price = price;
		this.ordered_time = ordered_time;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getRes_name() {
		return res_name;
	}

	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOrdered_time() {
		return ordered_time;
	}

	public void setOrdered_time(String ordered_time) {
		this.ordered_time = ordered_time;
	}
	
	
	
}
