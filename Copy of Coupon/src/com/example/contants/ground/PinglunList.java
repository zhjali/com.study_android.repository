package com.example.contants.ground;

import java.util.List;

public class PinglunList {
	private List<Comment_Xml> comments;

	public List<Comment_Xml> getComments() {
		return comments;
	}

	public void setComments(List<Comment_Xml> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "PinglunList [comments=" + comments + "]";
	}

}
