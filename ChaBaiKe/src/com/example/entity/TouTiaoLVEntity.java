package com.example.entity;

public class TouTiaoLVEntity extends Entity {
	private String id;
	private String title;
	private String source;
	private String description;
	private String wapThumb;
	private String createTime;
	private String nickName;

	public TouTiaoLVEntity(String id, String title, String source,
			String description, String wapThumb, String createTime,
			String nickName) {
		super();
		this.id = id;
		this.title = title;
		this.source = source;
		this.description = description;
		this.wapThumb = wapThumb;
		this.createTime = createTime;
		this.nickName = nickName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWapThumb() {
		return wapThumb;
	}

	public void setWapThumb(String wapThumb) {
		this.wapThumb = wapThumb;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	@Override
	public String toString() {
		return "TouTiaoLVEntity [id=" + id + ", title=" + title + ", source="
				+ source + ", description=" + description + ", wapThumb="
				+ wapThumb + ", createTime=" + createTime + ", nickName="
				+ nickName + "]";
	}

	// public class Builder{
	// private
	// }

}
