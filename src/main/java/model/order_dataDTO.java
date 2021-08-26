package model;

public class order_dataDTO {
	// �ֹ����� 
    private int orderSeq;

    // �޴����� 
    private int menuSeq;

    // �ֹ����� 
    private int cnt;

    // ���հ�ݾ� 
    private int totalAmount;

    // ���αݾ� 
    private int discountAmount;

    // �����հ�ݾ� 
    private int finalSum;

    // �ֹ���¥ 
    private String orderDay;

    // �ֹ��޸� 
    private String orderMemo;

    // �ֹ����� 
    private String orderState;

    // ȸ�����̵� 
    private String memberId;

    // ���̴����̵� 
    private String riderId;

	public order_dataDTO(int orderSeq, int menuSeq, int cnt, int totalAmount, int discountAmount, int finalSum,
			String orderDay, String orderMemo, String orderState, String memberId, String riderId) {
		super();
		this.orderSeq = orderSeq;
		this.menuSeq = menuSeq;
		this.cnt = cnt;
		this.totalAmount = totalAmount;
		this.discountAmount = discountAmount;
		this.finalSum = finalSum;
		this.orderDay = orderDay;
		this.orderMemo = orderMemo;
		this.orderState = orderState;
		this.memberId = memberId;
		this.riderId = riderId;
	}

	public int getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(int orderSeq) {
		this.orderSeq = orderSeq;
	}

	public int getMenuSeq() {
		return menuSeq;
	}

	public void setMenuSeq(int menuSeq) {
		this.menuSeq = menuSeq;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}

	public int getFinalSum() {
		return finalSum;
	}

	public void setFinalSum(int finalSum) {
		this.finalSum = finalSum;
	}

	public String getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(String orderDay) {
		this.orderDay = orderDay;
	}

	public String getOrderMemo() {
		return orderMemo;
	}

	public void setOrderMemo(String orderMemo) {
		this.orderMemo = orderMemo;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getRiderId() {
		return riderId;
	}

	public void setRiderId(String riderId) {
		this.riderId = riderId;
	}
	
	
	
}
