package model;

public class memberDTO {
	// ������ 
    private int memberSeq;

    // �����̵� 
    private String memberId;

    // ����й�ȣ 
    private String memberPw;

    // ���г��� 
    private String nickname;

    // ������ 
    private int memberAge;

    // ���ּ� 
    private String memberAddr;

    // �����ݾ� 
    private int memberCash;

    // ������ 
    private String memberGender;

    // ���� 
    private Double latitude;

    // �浵 
    private Double longitude;

	public memberDTO(int memberSeq, String memberId, String memberPw, String nickname, int memberAge, String memberAddr,
			int memberCash, String memberGender, Double latitude, Double longitude) {
		super();
		this.memberSeq = memberSeq;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.nickname = nickname;
		this.memberAge = memberAge;
		this.memberAddr = memberAddr;
		this.memberCash = memberCash;
		this.memberGender = memberGender;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	public int getMemberCash() {
		return memberCash;
	}

	public void setMemberCash(int memberCash) {
		this.memberCash = memberCash;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
    
    
}

