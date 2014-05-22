package com.example.contants.ground;

public class ShopInfo {
	private String like;
	private String flag;
	private String save;
	private String savenum;

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getSave() {
		return save;
	}

	public void setSave(String save) {
		this.save = save;
	}

	public String getSavenum() {
		return savenum;
	}

	public void setSavenum(String savenum) {
		this.savenum = savenum;
	}

	@Override
	public String toString() {
		return "ShopInfo [like=" + like + ", flag=" + flag + ", save=" + save
				+ ", savenum=" + savenum + "]";
	}

}
