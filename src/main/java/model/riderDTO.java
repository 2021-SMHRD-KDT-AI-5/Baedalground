package model;

public class riderDTO {
	// ���̴����� 
    private int rider_Seq;

    // ���̴����̵� 
    private String rider_Id;

    // ���̴���й�ȣ 
    private String rider_Pw;

    // ���̴��������� 
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
