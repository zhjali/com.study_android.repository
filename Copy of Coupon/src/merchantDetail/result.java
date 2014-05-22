package merchantDetail;


import java.util.List;

public class result {
	private String id;
	private String name;
	private String address;
	private String telno;
	private String price;
	private String view;
	private String features;
	private String x;
	private String y;
	private String shop_id;
	private String introduction;
	private String tag;
	private List<coupon> coupons;
	private List<group> groups;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getShop_id() {
		return shop_id;
	}

	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public List<coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<coupon> coupons) {
		this.coupons = coupons;
	}

	public List<group> getGoups() {
		return groups;
	}

	public void setGoups(List<group> goups) {
		this.groups = goups;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", name=" + name + ", address=" + address
				+ ", telno=" + telno + ", price=" + price + ", view=" + view
				+ ", features=" + features + ", x=" + x + ", y=" + y
				+ ", shop_id=" + shop_id + ", introduction=" + introduction
				+ ", coupons=" + coupons + ", goups=" + groups + "]";
	}

}
