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
		int result = 0; // ͳ�ƽ��
		int times = 2; // ����ѭ�������������������2��
		while (times != 0) {
			len = reader.read(ch);
			for (int i = 0; i < len - 2; i++) {	//len-2ѭ������ʱ�ų�\r\n
				if (ch[i] < '0' || ch[i] > '9') {
					System.out.println("�����˷�������Ϣ����������");
					times++;
					break;
				}
				// �����ַ����飬��װ��������
				num += (ch[i] - '0') * (int) Math.pow(10, len - i - 3);
			}
			// System.out.println(b);
			result += num;
			num = 0;
			times--;
		}
		System.out.println("�������ǣ� " + result);
	}

	public static void menu() throws IOException {
		Writer writer = new OutputStreamWriter(System.out);
		Reader reader = new InputStreamReader(System.in);
		char[] ch = new char[600];
		int len = 0;
		
		boolean flag = true;
		while (flag) {
			writer.write("======XXXϵͳ=====\n");
			writer.write("[1]����������\n");
			writer.write("[2]��ɾ������\n");
			writer.write("[3]���޸�����\n");
			writer.write("[4]���鿴����\n");
			writer.write("[0]��ϵͳ�˳�\n");
			writer.write("��ѡ��\n");
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
				System.out.println("������Ϣ��������������");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// hm1.randomPrint();
		// hm1.plus();
			hm1.menu();
	}
}
