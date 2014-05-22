package com.example.contants.ground;

public class ground_pinglun {
	private Head head;
	private ShopInfo shopinfo;
	private Icons icons;
	private Comment comment;

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public ShopInfo getShopinfo() {
		return shopinfo;
	}

	public void setShopinfo(ShopInfo shopinfo) {
		this.shopinfo = shopinfo;
	}

	public Icons getIcons() {
		return icons;
	}

	public void setIcons(Icons icons) {
		this.icons = icons;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		comment = comment;
	}

	@Override
	public String toString() {
		return "ground_pinglun [head=" + head + ", shopinfo=" + shopinfo
				+ ", icons=" + icons + ", Comment=" + comment + "]";
	}

}
