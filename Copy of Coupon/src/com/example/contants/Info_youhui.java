package com.example.contants;

import java.io.Serializable;

import com.example.exception.BuilderException;

public class Info_youhui implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5057947889095240945L;
	private String startTime;
	private String couponId;
	private String couponTitle;
	private String description;
	private String download;
	private String shopId;
	private String shopName;
	private String endTime;
	private String source;
	private String useType;
	private String useful;
	private String useless;

	@SuppressWarnings("unused")
	private Info_youhui() {
	}
	
	public Info_youhui(String startTime,String couponTitle,String description,String download,
			String endTime,String source,String useful,String useless) {
		this.startTime = startTime;
		this.couponTitle = couponTitle;
		this.description = description;
		this.download = download;
		this.endTime = endTime;
		this.source = source;
		this.useful = useful;
		this.useless = useless;
		
	}

	public String getStartTime() {
		return startTime;
	}

	public String getCouponId() {
		return couponId;
	}

	public String getCouponTitle() {
		return couponTitle;
	}

	public String getDescription() {
		return description;
	}

	public String getDownload() {
		return download;
	}

	public String getShopId() {
		return shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getSource() {
		return source;
	}

	public String getUseType() {
		return useType;
	}

	public String getUseful() {
		return useful;
	}

	public String getUseless() {
		return useless;
	}

	@Override
	public String toString() {
		return "Info_zuire [aTime=" + startTime + ", couponId=" + couponId
				+ ", couponTitle=" + couponTitle + ", description="
				+ description + ", download=" + download + ", shopId=" + shopId
				+ ", shopName=" + shopName + ", source=" + source
				+ ", useType=" + useType + ", useful=" + useful + ", useless="
				+ useless + "]";
	}
	
	public static class Builder{
		private String startTime;
		private String couponTitle;
		private String description;
		private String download;
		private String endTime;
		private String source;
		private String useful;
		private String useless;		
		
		public Builder(){
			
		}
		
		public Builder setStartTime(String startTime) {
			this.startTime = startTime;
			return this;
		}
		
		public Builder setCouponTitle(String couponTitle) {
			this.couponTitle = couponTitle;
			return this;
		}

		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder setDownload(String download) {
			this.download = download;
			return this;
		}

		public Builder setEndTime(String endTime) {
			this.endTime = endTime;
			return this;
		}

		public Builder setSource(String source) {
			this.source = source;
			return this;
		}

		public Builder setUseful(String useful) {
			this.useful = useful;
			return this;
		}

		public Builder setUseless(String useless) {
			this.useless = useless;
			return this;
		}
		
		public Info_youhui build() throws BuilderException{
				check();
				return new Info_youhui(
						startTime,
						couponTitle , 
						 description ,
						 download ,
						 endTime,
						 source,
						 useful,
						 useless);
		}
		
		protected void check() throws BuilderException {
			if (startTime == null
					|| couponTitle == null 
					|| description == null
					|| download == null
					|| endTime == null
					|| source == null
					|| useful == null
					|| useless == null)
				throw new BuilderException("缺少参数");
		}
	}
}
