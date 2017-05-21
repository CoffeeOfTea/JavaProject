package com.xb14620103.domain;

import java.util.List;

public class PageBean {
	private List<Diary> list; // ��ǰҳ����
	private int totalCount; // ����������
	private int pageSize;// ÿҳ��ʾ��������
	private int currPage;// ��ǰҳ
	private int totalPage;// ��ҳ��

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
