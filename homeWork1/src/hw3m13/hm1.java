package hw3m13;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import work27.A;

public class hm1 {

	public static void randomPrint() throws IOException {
		BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(
				System.out));
		for (int i = 0; i < 100; i++) {
			Integer a = (int) (Math.random() * 101);
			bf.write(a.toString());
			bf.newLine();
			bf.flush();
		}
		bf.close();
	}

	public static void plus() throws IOException {
		Reader reader = new InputStreamReader(System.in);
		char[] ch = new char[100];
		int len = 0;
		int num = 0;
		int result = 0; // 统计结果
		int times = 2; // 控制循环次数，非数字情况下2次
		while (times != 0) {
			len = reader.read(ch);
			for (int i = 0; i < len - 2; i++) {	//len-2循环遍历时排除\r\n
				if (ch[i] < '0' || ch[i] > '9') {
					System.out.println("输入了非数字信息，请再输入");
					times++;
					break;
				}
				// 遍历字符数组，组装输入数据
				num += (ch[i] - '0') * (int) Math.pow(10, len - i - 3);
			}
			// System.out.println(b);
			result += num;
			num = 0;
			times--;
		}
		System.out.println("计算结果是： " + result);
	}

	public static void menu() throws IOException {
		Writer writer = new OutputStreamWriter(System.out);
		Reader reader = new InputStreamReader(System.in);
		char[] ch = new char[600];
		int len = 0;
		
		boolean flag = true;
		while (flag) {
			writer.write("======XXX系统=====\n");
			writer.write("[1]、增加数据\n");
			writer.write("[2]、删除数据\n");
			writer.write("[3]、修改数据\n");
			writer.write("[4]、查看数据\n");
			writer.write("[0]、系统退出\n");
			writer.write("请选择：\n");
			writer.flush();
			len = reader.read(ch);
			if (len == 3) {
				switch (ch[0]) {
				case '1':
					System.out.println("add(){/.....}");
					flag = false;
					break;
				case '2':
					System.out.println("delete(){/.....}");
					flag = false;
					break;
				case '3':
					System.out.println("change(){/.....}");
					flag = false;
					break;
				case '4':
					System.out.println("look(){/.....}");
					flag = false;
					break;
				case '0':
					System.out.println("exit(){/.....}");
					flag = false;
					break;
				}
			}
			if(flag == true){
				System.out.println("输入信息错误，请重新输入");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// hm1.randomPrint();
		// hm1.plus();
			hm1.menu();
	}
}
