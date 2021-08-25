package model;

public class reviewDTO {
	private int tast;
	private int amount;
	private int speed;
	private String review;
	private String review_nick;
	
	public reviewDTO(int tast, int amount, int speed, String review, String review_nick) {
		super();
		this.tast = tast;
		this.amount = amount;
		this.speed = speed;
		this.review = review;
		this.review_nick = review_nick;
	}

	public int getTast() {
		return tast;
	}

	public void setTast(int tast) {
		this.tast = tast;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getReview_nick() {
		return review_nick;
	}

	public void setReview_nick(String review_nick) {
		this.review_nick = review_nick;
	}
	
	
	
	
}
