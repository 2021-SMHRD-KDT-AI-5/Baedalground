package model;

public class menuDTO {
	
	// 메뉴순번 
    private int menuSeq;

    // 식당순번 
    private int resSeq;

    // 메뉴이미지 
    private String menufile1;

    // 메뉴명 
    private String menuName;

    // 메뉴가격 
    private int menuPrice;

    // 주문가능여부 
    private String orderYn;

	public menuDTO(int menuSeq, int resSeq, String menufile1, String menuName, int menuPrice, String orderYn) {
		super();
		this.menuSeq = menuSeq;
		this.resSeq = resSeq;
		this.menufile1 = menufile1;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.orderYn = orderYn;
	}

	public int getMenuSeq() {
		return menuSeq;
	}

	public void setMenuSeq(int menuSeq) {
		this.menuSeq = menuSeq;
	}

	public int getResSeq() {
		return resSeq;
	}

	public void setResSeq(int resSeq) {
		this.resSeq = resSeq;
	}

	public String getMenufile1() {
		return menufile1;
	}

	public void setMenufile1(String menufile1) {
		this.menufile1 = menufile1;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getOrderYn() {
		return orderYn;
	}

	public void setOrderYn(String orderYn) {
		this.orderYn = orderYn;
	}
	
    
	
}
