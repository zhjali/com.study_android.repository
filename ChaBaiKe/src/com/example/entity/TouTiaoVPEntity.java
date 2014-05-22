package com.example.entity;

public class TouTiaoVPEntity extends Entity {
	private String id;
	private String title;
	private String name;
	private String link;
	private String content;
	private String image;
	private String imageS;

	public TouTiaoVPEntity() {
		super();
	}

	public TouTiaoVPEntity(String url) {
		super();
		this.image = url;
	}

	public TouTiaoVPEntity(String id, String title, String name, String link,
			String content, String image, String imageS) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.link = link;
		this.content = content;
		this.image = image;
		this.imageS = imageS;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImageS() {
		return imageS;
	}

	public void setImageS(String imageS) {
		this.imageS = imageS;
	}

	@Override
	public String toString() {
		return "TouTiaoVPEntity [id=" + id + ", title=" + title + ", name="
				+ name + ", link=" + link + ", content=" + content + ", image="
				+ image + ", imageS=" + imageS + "]";
	}

}
