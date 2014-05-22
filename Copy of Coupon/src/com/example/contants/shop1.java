package com.example.contants;

import java.io.Serializable;

public class shop1 implements Serializable{
	private String id;
	private String name;
	private String address;
	private String telno;
	private String trade_name;
	private String hasCoupon;
	private String hasGroup;
	private String hasBank;
	private String hasBook;
	private String onlyShop;
	private String star;
	private String price;
	private String shop_id;
	private String distance;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
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

	public String getOnlyShop() {
		return onlyShop;
	}

	public void setOnlyShop(String onlyShop) {
		this.onlyShop = onlyShop;
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

	@Override
	public String toString() {
		return "shop1 [id=" + id + ", name=" + name + ", address=" + address
				+ ", telno=" + telno + ", trade_name=" + trade_name
				+ ", hasCoupon=" + hasCoupon + ", hasGroup=" + hasGroup
				+ ", hasBank=" + hasBank + ", hasBook=" + hasBook
				+ ", onlyShop=" + onlyShop + ", star=" + star + ", price="
				+ price + ", shop_id=" + shop_id + ", distance=" + distance
				+ "]";
	}

}
