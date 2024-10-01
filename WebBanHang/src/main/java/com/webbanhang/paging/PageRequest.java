package com.webbanhang.paging;

public class PageRequest implements Pageble {
	
	private Integer page;
	private Integer maxPageItem;
	private Sorter sorter;
	
	public PageRequest(Integer page, Integer maxPageItem, Sorter sorter) {
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sorter = sorter;
	}

	@Override
	public Integer getPage() {
		return this.page;
	}
	
	
	@Override//Lấy phần tử tại vị trí page -1 vì trong sql chạy từ 1
	public Integer getOffset() {
		if (this.page != null && this.maxPageItem != null) {
			return (this.page - 1) * this.maxPageItem;
		}
		return null;
	}

	@Override//Lấy ra tổng số item trong 1 page
	public Integer getLimit() {
		return this.maxPageItem;
	}

	@Override//kiểm tra tồn tại sort trên đường dẫn web
	public Sorter getSorter() {
		if (this.sorter != null) {
			return this.sorter;
		}
		return null;
	}

}
