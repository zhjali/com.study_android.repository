package com.example.contants.ground;

import java.util.List;

public class Icons {
	private String total;
	private List<Datas> datas;

	public List<Datas> getDatas() {
		return datas;
	}

	public void setDatas(List<Datas> datas) {
		this.datas = datas;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Icons [total=" + total + ", datas=" + datas + "]";
	}

}
