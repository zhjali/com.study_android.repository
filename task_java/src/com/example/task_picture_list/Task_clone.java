package com.example.task_picture_list;

import java.util.Date;

public class Task_clone implements Cloneable {
	int x;
	Integer integer;
	Date date = new java.util.Date();
	B b = new B();

	public static void main(String[] args) {
		Task_clone a = new Task_clone();
		a.integer = new Integer(23);
		try {
			System.out.println("a.b.z: " + a.b.z);
			Task_clone bClone = (Task_clone) a.clone();
			bClone.b.z = 32;
			bClone.integer = 32;
			Thread.sleep(2000);
			bClone.date = new Date();
			System.out.println("a.b.z: " + a.b.z);
			System.out.println("a.integer: " + a.integer + " a.data.second: "
					+ a.b.z + a.date.getSeconds() + "\na.b:	" + a.b);
			System.out.println("bClone.integer:" + bClone.integer
					+ " bClone.data.second: " + bClone.b.z
					+ bClone.date.getSeconds() + "\nbClone.b:	" + bClone.b);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
