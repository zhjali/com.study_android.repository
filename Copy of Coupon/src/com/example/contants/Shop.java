package com.example.contants;

import java.io.Serializable;

public class Shop implements Serializable{
	private String icon;
	private String id;
	private String like;
	private String name;
	private String price;
	private String star;
	private String tag;
	private String view;

	@Override
	public String toString() {
		return "Shop [icon=" + icon + ", id=" + id + ", like=" + like
				+ ", name=" + name + ", price=" + price + ", star=" + star
				+ ", tag=" + tag + ", view=" + view + "]";
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

}
