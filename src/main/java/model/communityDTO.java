package model;

public class communityDTO {
	private String title;
	private String restaurant;
	private String time;
	private String min;
	private String location;
	private String host_nick;
	private String content;
	
	public communityDTO(String title, String restaurant, String time, String min, String location, String host_nick,
			String content) {
		super();
		this.title = title;
		this.restaurant = restaurant;
		this.time = time;
		this.min = min;
		this.location = location;
		this.host_nick = host_nick;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRestaurant() {
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
	
	
	
	
}
