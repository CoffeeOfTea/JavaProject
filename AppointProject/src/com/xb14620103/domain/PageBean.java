package com.xb14620103.domain;

import java.util.List;

public class PageBean {
	private List<Diary> list; // 当前页内容
	private int totalCount; // 内容总条数
	private int pageSize;// 每页显示内容条数
	private int currPage;// 当前页
	private int totalPage;// 总页数

	public PageBean() {
		super();
	}

	public PageBean(List<Diary> list, int totalCount, int pageSize, int currPage) {
		super();
		this.list = list;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currPage = currPage;
	}

	public List<Diary> getList() {
		return list;
	}

	public void setList(List<Diary> list) {
		this.list = list;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalPage() {
		return (int) (Math.ceil(totalCount * 1.0 / 5));
	}

	@Override
	public String toString() {
		return "PageBean [list=" + list + ", totalCount=" + totalCount + ", pageSize=" + pageSize + ", currPage="
				+ currPage + "]";
	}
}
