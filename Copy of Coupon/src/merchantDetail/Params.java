package merchantDetail;



import java.util.ArrayList;
import java.util.List;

public class Params {
	private List<String> params_Result1;
	private List<String> params_Coupon;
	private List<String> params_Shop;
	private List<String> params_Tuangou_Result;
	private List<String> params_Tuangou_Shop;
	private List<String> params_groundList;
	private List<String> params_pinglunList;
	private List<String> params_bankCoupons;
	private List<String> params_books;

	public Params() {
		params_Result1 = new ArrayList<String>();
		params_Result1.add("id");
		params_Result1.add("name");
		params_Result1.add("address");
		params_Result1.add("telno");
		params_Result1.add("price");
		params_Result1.add("view");
		params_Result1.add("features");
		params_Result1.add("x");
		params_Result1.add("y");
		params_Result1.add("shop_id");
		params_Result1.add("introduction");
		params_Result1.add("tag");
		params_Coupon = new ArrayList<String>();
		params_Coupon.add("id");
		params_Coupon.add("source");
		params_Coupon.add("title");
		params_Coupon.add("start_time");
		params_Coupon.add("end_time");
		params_Coupon.add("use_type");
		params_Coupon.add("useful");
		params_Coupon.add("useless");
		params_Coupon.add("description");
		params_Shop = new ArrayList<String>();
		params_Shop.add("id");
		params_Shop.add("name");
		params_Shop.add("address");
		params_Shop.add("trade_name");
		params_Shop.add("hasCoupon");
		params_Shop.add("hasGroup");
		params_Shop.add("hasBank");
		params_Shop.add("onlyShop");
		params_Shop.add("star");
		params_Shop.add("shop_id");
		params_Tuangou_Result = new ArrayList<String>();
		params_Tuangou_Result.add("id");
		params_Tuangou_Result.add("title");
		params_Tuangou_Result.add("category");
		params_Tuangou_Result.add("city");
		params_Tuangou_Result.add("endTime");
		params_Tuangou_Result.add("image");
		params_Tuangou_Result.add("price");
		params_Tuangou_Result.add("value");
		params_Tuangou_Result.add("rebate");
		params_Tuangou_Result.add("bought");
		params_Tuangou_Result.add("website");
		params_Tuangou_Result.add("delivery");
		params_Tuangou_Result.add("freightFree");
		params_Tuangou_Result.add("maxPerOrder");
		params_Tuangou_Result.add("freight");
		params_Tuangou_Result.add("minPerOrder");
		params_Tuangou_Result.add("dealUrl");
		params_Tuangou_Result.add("isWap");
		params_Tuangou_Result.add("distance");
		params_groundList = new ArrayList<String>();
		params_groundList.add("id");
		params_groundList.add("name");
		params_groundList.add("address");
		params_groundList.add("telno");
		params_groundList.add("trade_name");
		params_groundList.add("content");
		params_groundList.add("onlyShop");
		params_groundList.add("x");
		params_groundList.add("y");
		params_groundList.add("star");
		params_groundList.add("price");
		params_groundList.add("shop_id");
		params_groundList.add("distance");
		params_groundList.add("view");
		params_pinglunList = new ArrayList<String>();
		params_pinglunList.add("id");
		params_pinglunList.add("name");
		params_pinglunList.add("star");
		params_pinglunList.add("date");
		params_pinglunList.add("content");
		params_bankCoupons = new ArrayList<String>();
		params_bankCoupons.add("id");
		params_bankCoupons.add("name");
		params_bankCoupons.add("address");
		params_bankCoupons.add("discount");
		params_bankCoupons.add("introduction");
		params_bankCoupons.add("tel");
		params_bankCoupons.add("lat");
		params_bankCoupons.add("lng");
		params_bankCoupons.add("bank");
		params_bankCoupons.add("end");
		params_books = new ArrayList<String>();
		params_books.add("id");
		params_books.add("shopId");
		params_books.add("name");
		params_books.add("title");
		params_books.add("description");
		params_books.add("source");
		params_books.add("tel");
	}

	public List<String> getParams_Result1() {
		return params_Result1;
	}

	public List<String> getParams_books() {
		return params_books;
	}

	public void setParams_books(List<String> params_books) {
		this.params_books = params_books;
	}

	public List<String> getParams_bankCoupons() {
		return params_bankCoupons;
	}

	public void setParams_bankCoupons(List<String> params_bankCoupons) {
		this.params_bankCoupons = params_bankCoupons;
	}

	public void setParams_Result1(List<String> params_Result1) {
		this.params_Result1 = params_Result1;
	}

	public List<String> getParams_Coupon() {
		return params_Coupon;
	}

	public List<String> getParams_groundList() {
		return params_groundList;
	}

	public List<String> getParams_pinglunList() {
		return params_pinglunList;
	}

	public void setParams_pinglunList(List<String> params_pinglunList) {
		this.params_pinglunList = params_pinglunList;
	}

	public void setParams_groundList(List<String> params_groundList) {
		this.params_groundList = params_groundList;
	}

	public void setParams_Coupon(List<String> params_Coupon) {
		this.params_Coupon = params_Coupon;
	}

	public List<String> getParams_Shop() {
		return params_Shop;
	}

	public void setParams_Shop(List<String> params_Shop) {
		this.params_Shop = params_Shop;
	}

	public List<String> getParams_Tuangou_Result() {
		return params_Tuangou_Result;
	}

	public void setParams_Tuangou_Result(List<String> params_Tuangou_Result) {
		this.params_Tuangou_Result = params_Tuangou_Result;
	}

	public List<String> getParams_Tuangou_Shop() {
		return params_Tuangou_Shop;
	}

	public void setParams_Tuangou_Shop(List<String> params_Tuangou_Shop) {
		this.params_Tuangou_Shop = params_Tuangou_Shop;
	}

}
