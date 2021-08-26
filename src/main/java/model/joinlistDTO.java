package model;

public class joinlistDTO {
	    // 참여순번 
	    private int joinSeq;

	    // 글제목 
	    private String title;

	    // 커뮤니티순번 
	    private int communitySeq;

	    // 글내용 
	    private String content;

	    // 메뉴순번 
	    private int menuSeq;

	    // 메뉴수량 
	    private int menuCnt;

	    // 고객아이디 
	    private String memberId;

		public joinlistDTO(int joinSeq, String title, int communitySeq, String content, int menuSeq, int menuCnt,
				String memberId) {
			super();
			this.joinSeq = joinSeq;
			this.title = title;
			this.communitySeq = communitySeq;
			this.content = content;
			this.menuSeq = menuSeq;
			this.menuCnt = menuCnt;
			this.memberId = memberId;
		}

		public int getJoinSeq() {
			return joinSeq;
		}

		public void setJoinSeq(int joinSeq) {
			this.joinSeq = joinSeq;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public int getCommunitySeq() {
			return communitySeq;
		}

		public void setCommunitySeq(int communitySeq) {
			this.communitySeq = communitySeq;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public int getMenuSeq() {
			return menuSeq;
		}

		public void setMenuSeq(int menuSeq) {
			this.menuSeq = menuSeq;
		}

		public int getMenuCnt() {
			return menuCnt;
		}

		public void setMenuCnt(int menuCnt) {
			this.menuCnt = menuCnt;
		}

		public String getMemberId() {
			return memberId;
		}

		public void setMemberId(String memberId) {
			this.memberId = memberId;
		}




	
}