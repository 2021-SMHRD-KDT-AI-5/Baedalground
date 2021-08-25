package model;

public class joinlistDTO {
	private String title;
	private String restaurant;
	private String time;
	private String min;
	private String host_nick;
	private String location;
	private String content;
	private String my_nick;
//	private String book_menu;
//	private String book_price;

	// 2. 생성자 : 객체 생성할떄 저장 될 데이터를 절달받음

	public joinlistDTO(String title, String restaurant, String time, String min, String location , String host_nick,
			String content, String my_nick ) {
		
		this.title = title;
		this.restaurant = restaurant;
		this.time = time;
		this.min = min;
		this.location = location;
		this.host_nick = host_nick;
		this.content = content;
		this.my_nick = my_nick;
//		this.book_menu = book_menu;
//		this.book_price = book_price;
	}
	

//	public String getBook_menu() {
//		return book_menu;
//	}
//
//
//	public void setBook_menu(String book_menu) {
//		this.book_menu = book_menu;
//	}
//
//
//	public String getBook_price() {
//		return book_price;
//	}
//
//
//	public void setBook_price(String book_price) {
//		this.book_price = book_price;
//	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRestaurnat() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getHost_nick() {
		return host_nick;
	}


	public void setHost_nick(String host_nick) {
		this.host_nick = host_nick;
	}


	public String getRestaurant() {
		return restaurant;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getMy_nick() {
		return my_nick;
	}


	public void setMy_nick(String my_nick) {
		this.my_nick = my_nick;
	}

	
}