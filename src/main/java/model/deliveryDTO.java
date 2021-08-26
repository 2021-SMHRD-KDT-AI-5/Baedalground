package model;

public class deliveryDTO {
	// 배달순번 
    private int deliSeq;

    // 주문번호 
    private int orderSeq;

    // 라이더아이디 
    private String riderId;

    // 라이더접수시간 
    private String riderPickuptime;

    // 배달상태 
    private String deliState;

	public deliveryDTO(int deliSeq, int orderSeq, String riderId, String riderPickuptime, String deliState) {
		super();
		this.deliSeq = deliSeq;
		this.orderSeq = orderSeq;
		this.riderId = riderId;
		this.riderPickuptime = riderPickuptime;
		this.deliState = deliState;
	}

	public int getDeliSeq() {
		return deliSeq;
	}

	public void setDeliSeq(int deliSeq) {
		this.deliSeq = deliSeq;
	}

	public int getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(int orderSeq) {
		this.orderSeq = orderSeq;
	}

	public String getRiderId() {
		return riderId;
	}

	public void setRiderId(String riderId) {
		this.riderId = riderId;
	}

	public String getRiderPickuptime() {
		return riderPickuptime;
	}

	public void setRiderPickuptime(String riderPickuptime) {
		this.riderPickuptime = riderPickuptime;
	}

	public String getDeliState() {
		return deliState;
	}

	public void setDeliState(String deliState) {
		this.deliState = deliState;
	}
    
    
    
}
