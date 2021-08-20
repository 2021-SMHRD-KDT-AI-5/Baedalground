package model;

public class memberDTO {
	private String id;
	private String pw;
	private String nick_name;
	private int age;
	private String address;
	private int cash;
	private String gender;
	
	public memberDTO(String id, String pw, String nick_name, int age, String address, int cash, String gender) {
		super();
		this.id = id;
		this.pw = pw;
		this.nick_name = nick_name;
		this.age = age;
		this.address = address;
		this.cash = cash;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getCash(int cash) {
		return cash;
	}
	
	public void setCash(int cash) {
		this.cash = cash;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}

