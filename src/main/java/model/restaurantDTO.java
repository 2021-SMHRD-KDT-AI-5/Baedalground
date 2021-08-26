package model;

public class restaurantDTO {
	 // 식당순번 
    private int resSeq;

    // 식당아이디 
    private String resId;

    // 식당비밀번호 
    private String resPw;

    // 식당카테고리 
    private String resCategory;

    // 식당명 
    private String resName;

    // 식당주소 
    private String resAddr;

    // 식당전화번호 
    private String resPhone;

    // 위도 
    private Double latitude;

    // 경도 
    private Double longitude;

	public restaurantDTO(int resSeq, String resId, String resPw, String resCategory, String resName, String resAddr,
			String resPhone, Double latitude, Double longitude) {
		super();
		this.resSeq = resSeq;
		this.resId = resId;
		this.resPw = resPw;
		this.resCategory = resCategory;
		this.resName = resName;
		this.resAddr = resAddr;
		this.resPhone = resPhone;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getResSeq() {
		return resSeq;
	}

	public void setResSeq(int resSeq) {
		this.resSeq = resSeq;
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public String getResPw() {
		return resPw;
	}

	public void setResPw(String resPw) {
		this.resPw = resPw;
	}

	public String getResCategory() {
		return resCategory;
	}

	public void setResCategory(String resCategory) {
		this.resCategory = resCategory;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResAddr() {
		return resAddr;
	}

	public void setResAddr(String resAddr) {
		this.resAddr = resAddr;
	}

	public String getResPhone() {
		return resPhone;
	}

	public void setResPhone(String resPhone) {
		this.resPhone = resPhone;
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
