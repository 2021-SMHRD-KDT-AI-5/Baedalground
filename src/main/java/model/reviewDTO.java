package model;

public class reviewDTO {
	private String nick_name;
	private String write_date;
	private int score_del;
	private int score_amo;
	private int score_driv;
	
	public reviewDTO(String nick_name, String write_date, int score_del, int score_amo, int score_driv) {
		super();
		this.nick_name = nick_name;
		this.write_date = write_date;
		this.score_del = score_del;
		this.score_amo = score_amo;
		this.score_driv = score_driv;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}

	public int getScore_del() {
		return score_del;
	}

	public void setScore_del(int score_del) {
		this.score_del = score_del;
	}

	public int getScore_amo() {
		return score_amo;
	}

	public void setScore_amo(int score_amo) {
		this.score_amo = score_amo;
	}

	public int getScore_driv() {
		return score_driv;
	}

	public void setScore_driv(int score_driv) {
		this.score_driv = score_driv;
	}
	
	
}
