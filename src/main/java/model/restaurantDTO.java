package model;

public class restaurantDTO {
	
    // �Ĵ���� 
    private Double resSeq;

    // �Ĵ�ī�װ� 
    private String resCategory;

    // �Ĵ�� 
    private String resName;

    // �Ĵ���ȭ��ȣ 
    private String resPhone;

    // �Ĵ��ּ� 
    private String resAddr;

    // ���� 
    private Double latitude;

    // �浵 
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
