package com.example.contants.ground;

public class Result_Ground {
	private String id;
	private String name;
	private String address;
	private String telno;
	private String trade_name;
	private String content;
	private String onlyShop;
	private String hasCoupon;
	private String hasGroup;
	private String hasBank;
	private String hasBook;
	private String y;
	private String x;
	private String star;
	private String price;
	private String shop_id;
	private String distance;
	private String view;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getHasCoupon() {
		return hasCoupon;
	}

	public void setHasCoupon(String hasCoupon) {
		this.hasCoupon = hasCoupon;
	}

	public String getHasGroup() {
		return hasGroup;
	}

	public void setHasGroup(String hasGroup) {
		this.hasGroup = hasGroup;
	}

	public String getHasBank() {
		return hasBank;
	}

	public void setHasBank(String hasBank) {
		this.hasBank = hasBank;
	}

	public String getHasBook() {
		return hasBook;
	}

	public void setHasBook(String hasBook) {
		this.hasBook = hasBook;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getTrade_name() {
		return trade_name;
	}

	public void setTrade_name(String trade_name) {
		this.trade_name = trade_name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOnlyShop() {
		return onlyShop;
	}

	public void setOnlyShop(String onlyShop) {
		this.onlyShop = onlyShop;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getShop_id() {
		return shop_id;
	}

	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	@Override
	public String toString() {
		return "Result_Ground [id=" + id + ", name=" + name + ", address="
				+ address + ", telno=" + telno + ", trade_name=" + trade_name
				+ ", content=" + content + ", onlyShop=" + onlyShop
				+ ", hasCoupon=" + hasCoupon + ", hasGroup=" + hasGroup
				+ ", hasBank=" + hasBank + ", hasBook=" + hasBook + ", y=" + y
				+ ", x=" + x + ", star=" + star + ", price=" + price
				+ ", shop_id=" + shop_id + ", distance=" + distance + ", view="
				+ view + "]";
	}

}
