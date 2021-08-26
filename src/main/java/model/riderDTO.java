package model;

public class riderDTO {
	// 라이더순번 
    private int rider_Seq;

    // 라이더아이디 
    private String rider_Id;

    // 라이더비밀번호 
    private String rider_Pw;

    // 라이더가입일자 
    private String rider_Entrydate;

	public riderDTO(int rider_Seq, String rider_Id, String rider_Pw, String rider_Entrydate) {
		super();
		this.rider_Seq = rider_Seq;
		this.rider_Id = rider_Id;
		this.rider_Pw = rider_Pw;
		this.rider_Entrydate = rider_Entrydate;
	}

	public int getRiderSeq() {
		return rider_Seq;
	}

	public void setRiderSeq(int rider_Seq) {
		this.rider_Seq = rider_Seq;
	}

	public String getRiderId() {
		return rider_Id;
	}

	public void setRiderId(String rider_Id) {
		this.rider_Id = rider_Id;
	}

	public String getRiderPw() {
		return rider_Pw;
	}

	public void setRiderPw(String rider_Pw) {
		this.rider_Pw = rider_Pw;
	}

	public String getRiderEntrydate() {
		return rider_Entrydate;
	}

	public void setRiderEntrydate(String rider_Entrydate) {
		this.rider_Entrydate = rider_Entrydate;
	}
    
    
}
