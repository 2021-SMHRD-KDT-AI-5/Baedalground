package model;

public class reviewDTO {
	// ������� 
    private int reviewSeq;

    // ȸ�����̵� 
    private String memberId;

    // ���䳻�� 
    private String reviewContents;

    // �Է����� 
    private String inputDate;

    // ���� 
    private int tasteReview;

    // ���� 
    private int amountReview;

    // ����� 
    private int deliReview;

    // �ֹ����� 
    private int orderSeq;

	public reviewDTO(int reviewSeq, String memberId, String reviewContents, String inputDate, int tasteReview,
			int amountReview, int deliReview, int orderSeq) {
		super();
		this.reviewSeq = reviewSeq;
		this.memberId = memberId;
		this.reviewContents = reviewContents;
		this.inputDate = inputDate;
		this.tasteReview = tasteReview;
		this.amountReview = amountReview;
		this.deliReview = deliReview;
		this.orderSeq = orderSeq;
	}

	public int getReviewSeq() {
		return reviewSeq;
	}

	public void setReviewSeq(int reviewSeq) {
		this.reviewSeq = reviewSeq;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getReviewContents() {
		return reviewContents;
	}

	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public int getTasteReview() {
		return tasteReview;
	}

	public void setTasteReview(int tasteReview) {
		this.tasteReview = tasteReview;
	}

	public int getAmountReview() {
		return amountReview;
	}

	public void setAmountReview(int amountReview) {
		this.amountReview = amountReview;
	}

	public int getDeliReview() {
		return deliReview;
	}

	public void setDeliReview(int deliReview) {
		this.deliReview = deliReview;
	}

	public int getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(int orderSeq) {
		this.orderSeq = orderSeq;
	}

    
	
	
	
	
}
