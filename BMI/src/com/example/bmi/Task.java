package com.example.bmi;

import java.text.DecimalFormat;

public class Task {

	public static void main(String[] args) {
		String string = "<p>您的BMI指数为：<font color=\"#ff00\">result</font></p>"
				+ "<p>您的体重情况为：<font color=\"#f0f0\">status<\font></p>"
				+ "<p>您的健康体重为：lowkg~heikg</p>";
		DecimalFormat myFormate = new DecimalFormat("#####0.00");
		Double value = 23.444;
		System.out.println(myFormate.format(value));
		string = string.replaceAll("result", myFormate.format(value));
		System.out.println(string);
		// string.replace("status", status);
		// string.replace("low", String.valueOf(low));
		// string.replace("hei", String.valueOf(hei));
		// text.setText(Html.fromHtml(string));

	}
}
