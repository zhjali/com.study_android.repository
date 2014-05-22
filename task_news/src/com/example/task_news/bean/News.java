package com.example.task_news.bean;

public class News extends AbstractBean {
	private int id;
	private int oid;
	private String category;
	private NewsData data;

	public News(int id, int oid, String category, NewsData data) {
		super();
		this.id = id;
		this.oid = oid;
		this.category = category;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public NewsData getData() {
		return data;
	}

	public void setData(NewsData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", oid=" + oid + ", category=" + category
				+ ", data=" + data + "]";
	}

}
