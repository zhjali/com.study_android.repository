package merchantDetail;

public class shop {
	private String id;
	private String name;
	private String address;
	private String trade_name;
	private String hasCoupon;
	private String hasGroup;
	private String hasBank;
	private String onlyShop;
	private String star;
	private String shop_id;

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

	public String getShop_id() {
		return shop_id;
	}

	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}

	@Override
	public String toString() {
		return "shop [id=" + id + ", name=" + name + ", address=" + address
				+ ", trade_name=" + trade_name + ", hasCoupon=" + hasCoupon
				+ ", hasGroup=" + hasGroup + ", hasBank=" + hasBank
				+ ", onlyShop=" + onlyShop + ", star=" + star + ", shop_id="
				+ shop_id + "]";
	}

}
