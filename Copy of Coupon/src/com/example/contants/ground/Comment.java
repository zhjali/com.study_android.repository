package com.example.contants.ground;

import java.util.List;

public class Comment {
	private String total;
	private String star;
	private List<Data1> datas;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public List<Data1> getDatas() {
		return datas;
	}

	public void setDatas(List<Data1> datas) {
		this.datas = datas;
	}

	@Override
	public String toString() {
		return "Comment [total=" + total + ", star=" + star + ", data=" + datas
				+ "]";
	}

}
