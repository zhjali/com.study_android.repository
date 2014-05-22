package com.example.task_news.bean;

import java.io.File;
import java.io.IOException;

public class TaskFile {
	File file = new File("C://hellow/nihao.txt");

	public static void main(String[] args) {
		TaskFile t = new TaskFile();
		System.out.println("abslu: " + t.file.getAbsolutePath());
		try {
			System.out.println(t.file.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(t.file.getName());
		System.out.println(t.file.getName());
		System.out.println(t.file.getPath());
		System.out.println(t.file.getParentFile().getAbsolutePath());
	}
}
