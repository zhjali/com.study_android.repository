package com.example.contants.ground;

public class Head {
	private String code;
	private String message;
	private String score;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Head [code=" + code + ", message=" + message + ", score="
				+ score + "]";
	}

}
