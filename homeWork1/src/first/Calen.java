package first;

import java.util.Scanner;

/**
 * ���˼·��1900��1��1��Ϊ����һ�� ���ָ�����ھ���1900/1/1��������sum�� sum/7+1���ָ���·ݵ�һ�죬�����ڼ���
 **/

class Calen {
	boolean leapYear = false;

	/**
	 * ������� ����������򷵻�true�����򷵻�false
	 **/
	public boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
			return true;
		else
			return false;
	}

	/**
	 * ������ݡ��·� ���ض�Ӧ�·ݵ�����
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
	 * ������� ���ش����1900��1��1�յ�����
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

	// ���뱾��ȵ�һ��һ�ղ�����죬%sum%��
	public int spanThis(int year, int month) {
		int i = 1;
		int sum = 0;

		for (; i < month; i++)
			sum += monthDay(year, i);
		System.out.println("spanThis: " + sum);
		return sum;
	}

	// ���ر��µ�һ�������ڼ�������%first%
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
		int sum = 0; // ��ӡ�����������ӣ����Ͽհ׵�

		System.out.println("�������꣺");
		year = scan.nextInt();
		System.out.println("�������·ݣ�");
		month = scan.nextInt();
		day = ca.monthDay(year, month);
		firstDay = ca.firstDay(year, month);
		System.out.println("firstDay: " + firstDay);
		sum = firstDay + day;

		System.out.print("������\t");
		System.out.print("����һ\t");
		System.out.print("���ڶ�\t");
		System.out.print("������\t");
		System.out.print("������\t");
		System.out.print("������\t");
		System.out.println("������");

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
