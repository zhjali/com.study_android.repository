package com.example.contants.ground;

public class Data1 {
	private String content;
	private String star;
	private String date;
	private String name;
	private String id;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Data1 [content=" + content + ", star=" + star + ", date="
				+ date + ", name=" + name + ", id=" + id + "]";
	}

}
