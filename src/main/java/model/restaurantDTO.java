package model;

public class restaurantDTO {
	
    // 식당순번 
    private Double resSeq;

    // 식당카테고리 
    private String resCategory;

    // 식당명 
    private String resName;

    // 식당전화번호 
    private String resPhone;

    // 식당주소 
    private String resAddr;

    // 위도 
    private Double latitude;

    // 경도 
    private Double longitude;

    public Double getResSeq() {
        return resSeq;
    }

	public restaurantDTO(Double resSeq, String resCategory, String resName, String resPhone, String resAddr,
			Double latitude, Double longitude) {
		super();
		this.resSeq = resSeq;
		this.resCategory = resCategory;
		this.resName = resName;
		this.resPhone = resPhone;
		this.resAddr = resAddr;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public String getResPhone() {
		return resPhone;
	}

	public void setResPhone(String resPhone) {
		this.resPhone = resPhone;
	}

	public String getResAddr() {
		return resAddr;
	}

	public void setResAddr(String resAddr) {
		this.resAddr = resAddr;
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

	public void setResSeq(Double resSeq) {
		this.resSeq = resSeq;
	}
	    
	
    
	
}
