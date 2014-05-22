package com.example.task_picture_list;

public class ItemData {
	private String name;
	private String imageUrl;

	public ItemData(String name, String imageUrl) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
	}

	public ItemData() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "ItemData [name=" + name + ", imageUrl=" + imageUrl + "]";
	}
}
