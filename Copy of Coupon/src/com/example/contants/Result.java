package com.example.contants;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable{
	private String id;
	private String title;
	private String category;
	private String city;
	private String endTime;
	private String image;
	private String price;
	private String value;
	private String rebate;
	private String bought;
	private String website;
	private String delivery;
	private String freightFree;
	private String freight;
	private String maxPerOrder;
	private String minPerOrder;
	private String dealUrl;
	private String isWap;
	private String distance;
	private List<shop1> shops;

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRebate() {
		return rebate;
	}

	public void setRebate(String rebate) {
		this.rebate = rebate;
	}

	public String getBought() {
		return bought;
	}

	public void setBought(String bought) {
		this.bought = bought;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getFreightFree() {
		return freightFree;
	}

	public void setFreightFree(String freightFree) {
		this.freightFree = freightFree;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getMaxPerOrder() {
		return maxPerOrder;
	}

	public void setMaxPerOrder(String maxPerOrder) {
		this.maxPerOrder = maxPerOrder;
	}

	public String getMinPerOrder() {
		return minPerOrder;
	}

	public void setMinPerOrder(String minPerOrder) {
		this.minPerOrder = minPerOrder;
	}

	public String getDealUrl() {
		return dealUrl;
	}

	public void setDealUrl(String dealUrl) {
		this.dealUrl = dealUrl;
	}

	public String getIsWap() {
		return isWap;
	}

	public void setIsWap(String isWap) {
		this.isWap = isWap;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public List<shop1> getShops() {
		return shops;
	}

	public void setShops(List<shop1> shops) {
		this.shops = shops;
	}

	@Override
	public String toString() {
		return "result [id=" + id + ", title=" + title + ", category="
				+ category + ", city=" + city + ", endTime=" + endTime
				+ ", image=" + image + ", price=" + price + ", value=" + value
				+ ", rebate=" + rebate + ", bought=" + bought + ", website="
				+ website + ", delivery=" + delivery + ", freightFree="
				+ freightFree + ", freight=" + freight + ", maxPerOrder="
				+ maxPerOrder + ", minPerOrder=" + minPerOrder + ", dealUrl="
				+ dealUrl + ", isWap=" + isWap + ", distance=" + distance
				+ ", shops=" + shops + "]";
	}

}
