package model;

public class communityDTO {

    // Ŀ�´�Ƽ���� 
    private int communitySeq;

    // ������ 
    private String title;

    // �Ĵ���� 
    private int resSeq;

    // �ֹ�����ð� 
    private String reserveString;

    // �ּ��ο� 
    private int cnt;

    // �����̵� 
    private String memberId;

    // �۳��� 
    private String content;

    // ���Է½ð� 
    private String input_date;

	public communityDTO(int communitySeq, String title, int resSeq, String reserveString, int cnt, String memberId,
			String content, String input_date) {
		super();
		
		this.communitySeq = communitySeq;
		this.title = title;
		this.resSeq = resSeq;
		this.reserveString = reserveString;
		this.cnt = cnt;
		this.memberId = memberId;
		this.content = content;
		this.input_date = input_date;
	}

	public int getCommunitySeq() {
		return communitySeq;
	}

	public void setCommunitySeq(int communitySeq) {
		this.communitySeq = communitySeq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getResSeq() {
		return resSeq;
	}

	public void setResSeq(int resSeq) {
		this.resSeq = resSeq;
	}

	public String getReserveString() {
		return reserveString;
	}

	public void setReserveString(String reserveString) {
		this.reserveString = reserveString;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInput_date() {
		return input_date;
	}

	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}

    


	
}
