package model;

public class deliveryDTO {
	// ��޼��� 
    private int deliSeq;

    // �ֹ���ȣ 
    private int orderSeq;

    // ���̴����̵� 
    private String riderId;

    // ���̴������ð� 
    private String riderPickuptime;

    // ��޻��� 
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
