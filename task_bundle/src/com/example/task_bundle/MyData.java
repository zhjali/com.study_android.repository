package com.example.task_bundle;

import java.io.Serializable;

public class MyData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x;
	int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
