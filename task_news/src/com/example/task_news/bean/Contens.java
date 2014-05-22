package com.example.task_news.bean;

public class Contens extends AbstractBean {
	private String category;
	private String text;

	private String link;
	private String summary;
	private int width;
	private int height;

	public Contens(String category, String text) {
		super();
		this.category = category;
		this.text = text;
	}

	public Contens(String category, String link, String summary, int width,
			int height) {
		super();
		this.category = category;
		this.link = link;
		this.summary = summary;
		this.width = width;
		this.height = height;
	}

	public Contens() {
		super();
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Contens [category=" + category + ", text=" + text + ", link="
				+ link + ", summary=" + summary + ", width=" + width
				+ ", height=" + height + "]";
	}

}
