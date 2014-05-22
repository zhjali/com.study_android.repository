package first;

import java.util.Scanner;

/**
 * 编程思路：1900年1月1日为星期一。 求出指定日期距离1900/1/1的总天数sum， sum/7+1求出指定月份第一天，是星期几。
 **/

class Calen {
	boolean leapYear = false;

	/**
	 * 输入年份 如果是闰年则返回true，否则返回false
	 **/
	public boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
			return true;
		else
			return false;
	}

	/**
	 * 输入年份、月份 返回对应月份的天数
	 **/
	public int monthDay(int year, int month) {
		boolean leapYear = isLeapYear(year);
		int day = 0;

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
			break;
		case 2:
			if (leapYear)
				day = 29;
			else
				day = 28;
			break;
		}
		return day;
	}

	/**
	 * 输入年份 返回此年距1900年1月1日的日期
	 **/
	public int span1900(int year) {
		int sum = 0;
		int year19 = 1900;

		for (; year19 < year; year19++) {
			if (isLeapYear(year19))
				sum += 366;
			else
				sum += 365;
		}
		System.out.println("1900: " + sum);
		return sum;

	}

	// 距离本年度的一月一日差多少天，%sum%天
	public int spanThis(int year, int month) {
		int i = 1;
		int sum = 0;

		for (; i < month; i++)
			sum += monthDay(year, i);
		System.out.println("spanThis: " + sum);
		return sum;
	}

	// 返回本月第一天是星期几，星期%first%
	public int firstDay(int year, int month) {
		int sum = span1900(year) + spanThis(year, month);
		System.out.println("sum: " + sum);
		int first = 0;

		first = (sum % 7) + 1;
		System.out.println("firstDay: " + first);
		return first;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Calen ca = new Calen();
		int year = 0;
		int month = 0;
		int firstDay = 0;
		int day = 0;
		int sum = 0; // 打印的总天数格子，算上空白的

		System.out.println("请输入年：");
		year = scan.nextInt();
		System.out.println("请输入月份：");
		month = scan.nextInt();
		day = ca.monthDay(year, month);
		firstDay = ca.firstDay(year, month);
		System.out.println("firstDay: " + firstDay);
		sum = firstDay + day;

		System.out.print("星期日\t");
		System.out.print("星期一\t");
		System.out.print("星期二\t");
		System.out.print("星期三\t");
		System.out.print("星期四\t");
		System.out.print("星期五\t");
		System.out.println("星期六");

		for (int i = 0; i < firstDay; i++)
			System.out.print("\t");

		for (int i = 1; i <= day; i++) {
			if ((firstDay + i) % 7 == 0)
				System.out.println(i + "");
			else
				System.out.print(i + "\t");
		}

	}
}
