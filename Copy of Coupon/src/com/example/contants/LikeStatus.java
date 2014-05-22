package com.example.contants;

import java.io.Serializable;
import java.util.List;

public class LikeStatus implements Serializable{
	private String like;

	private List<String> likePhotos;

	public String toString() {
		return "LikeStatus [like=" + like + ", likePhotos=" + likePhotos + "]";
	}

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

	// public List<String> getLikePhotos() {
	// return likePhotos;
	// }

	// public void setLikePhotos(List<String> likePhotos) {
	// this.likePhotos = likePhotos;
	// }

}
