package model;

public class reviewDTO {
	// 리뷰순번 
    private int reviewSeq;

    // 회원아이디 
    private String memberId;

    // 리뷰내용 
    private String reviewContents;

    // 입력일자 
    private String inputDate;

    // 맛평가 
    private int tasteReview;

    // 양평가 
    private int amountReview;

    // 배달평가 
    private int deliReview;

    // 주문순번 
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
