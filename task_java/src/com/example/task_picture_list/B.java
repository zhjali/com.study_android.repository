package com.example.task_picture_list;

public class B implements Cloneable {
	int z;
	int h;

	protected Object clone() throws CloneNotSupportedException {
		return new B();
	}
}
