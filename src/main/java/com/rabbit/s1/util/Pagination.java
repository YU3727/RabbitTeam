package com.rabbit.s1.util;

public class Pagination {
	
	//페이지(parameter)번호와 한 페이지에서 볼 row의 개수
	private Long page;
	private Long perPage;
	
	//table에서 조회할 시작/끝번호
	private Long startRow;
	private Long lastRow;
	
	//총페이지 개수, 블럭 계산을 위한 한 블럭당 출력할 번호 개수
	private Long totalPage;
	private Long perBlock;
	
	//jsp에 출력하기 위한 변수
	private Long startNum;
	private Long lastNum;
	
	//시작과 끝 블럭에서 disabled 시키기 위한 스위치
	private boolean before;
	private boolean after;
	
	//검색방법와 검색어
	private String kind;
	private String search;
	
	public Pagination() {}
	
	//start/lastRow 계산 메서드
	public void makeRow() {
		//page번호마다 받아와야할 startRow / lastRow를 계산
		this.startRow = (this.getPage()-1)*this.getPerPage() +1;
		this.lastRow = this.getPage()*this.getPerPage();
	}
	
	//start/lastNum 계산 메서드
	public void makeNum(Long totalCount) {
		//전체 로직
		//1. 전체 row의 개수 구하기
		//2. 총 page 개수 구하기
		//3. 한 블럭에 출력할 번호의 개수(page 번호를 몇개씩 나타낼건가) -> 5개로 해보자
		//4. 총 블럭의 개수
		//5. page 번호로 현재 블럭 번호를 구하기
		//6. 현재블럭으로 Pagination의 시작번호, 끝번호 구하기
		//7. 이전블럭과 다음블럭의 유무 체크
		//8. 현재 블럭이 마지막 블럭과 같다면, 전체 페이지의 블럭 번호와 같게 설정
		
		
		//1) totalCount는 매개변수로. query와 DAO에서 메서드로 계산
		//2) data row 430줄을 페이지당 10줄씩 보여줄거면 총 페이지는 43페이지여야 함
		this.totalPage = totalCount/this.getPerPage();
		//2-1) data row 433줄을 페이지당 10줄씩 보여줄거면 총 페이지는 44페이지여야 함(나머지가 0이아님)
		if(totalCount%this.getPerPage() != 0) {
			totalPage++;
		}
		
		//현재 page가 totalPage를 넘지 않게 설정
		if(this.getPage() > totalPage) {
			this.setPage(totalPage);
		}
		
		//3) perBlock은 getter로 처리
		//4) 총 페이지 40페이지를 블럭당 5페이지씩 보여줄거면 총 블럭은 8개가 있어야함
		Long totalBlock = totalPage/getPerBlock();
		//4-1) 총 페이지 43페이지를 블럭당 5페이지씩 보여줄거면 총 블럭은 9개가 있어야함(나머지가 0이 아님)
		if(totalPage%getPerBlock() != 0) {
			totalBlock++;
		}
		
		//5) page : 1-5 -> curBlock = 1 // 6-10 : =2 // 11-15 : =3 ...
		Long curBlock = this.getPage() / getPerBlock();
		//5-1) 나머지가 0이 아닌경우 현재블럭을 1만큼 값을 높여야함
		if(this.getPage()%getPerBlock() != 0) {
			curBlock++;
		}
		
		//6) curBlock = 1 -> startNum 1 - lastNum 5 // =2 : 6-10 // =3 : 11-15 ...
		this.startNum = (curBlock -1)*getPerBlock() +1;
		this.lastNum = curBlock*getPerBlock();
		
		//7)체크용 before, after 값 설정
		this.before = false;
		this.after = false;
		if(curBlock == 1) {
			this.before = true;
		}
		if(curBlock == totalBlock) {
			this.after = true;
		}
		
		//8)마지막 블럭에서는 lastNum을 totalPage값으로 대체
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
		
	}
	

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(search == null) {
			search = "";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Long getTotalPage() {
		return totalPage;
	}

//	외부에서 값을 넣어줄 필요가 없다. DB에서 긁어오는대로만 나와야 하기 때문
//	public void setTotalPage(Long totalPage) {
//		this.totalPage = totalPage;
//	}

	public Long getPerBlock() {
		if(this.perBlock == null || this.perBlock < 1)
			this.perBlock = 5L;
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isBefore() {
		return before;
	}

	public void setBefore(boolean before) {
		this.before = before;
	}

	public boolean isAfter() {
		return after;
	}

	public void setAfter(boolean after) {
		this.after = after;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getPerPage() {
		if(this.perPage == null || this.perPage == 0) {
			this.perPage = 10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	
}
