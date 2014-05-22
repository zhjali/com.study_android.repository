package com.example.contants;

import java.io.Serializable;

public class Coupon implements Serializable{
	private String description;
	private String id;
	private String image;
	private String source;
	private String title;
	private String useType;
	private String useful;
	private String useless;
	private String endTime;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUseType() {
		return useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	public String getUseful() {
		return useful;
	}

	public void setUseful(String useful) {
		this.useful = useful;
	}

	public String getUseless() {
		return useless;
	}

	public void setUseless(String useless) {
		this.useless = useless;
	}
	
	

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Coupon [description=" + description + ", id=" + id + ", image="
				+ image + ", source=" + source + ", title=" + title
				+ ", useType=" + useType + ", useful=" + useful + ", useless="
				+ useless + "]";
	}

}
