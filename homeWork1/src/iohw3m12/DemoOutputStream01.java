package iohw3m12;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DemoOutputStream01 {

	public static void main(String[] args) throws IOException {
		// ���󣺽����ݴ��뵽�����ļ�
		String s1 = "helloworld";
		File f1 = new File("c:\\pro\\bb.txt");
		// step1:�����������򣬵�λ
		OutputStream os = null;
		// step2:������
		os = new FileOutputStream(f1);
		// step3:��������
		os.write(97);// �������ֽ�д�뵽�����ļ�
		for (int i = 0; i < s1.length(); i++) {
			os.write(s1.charAt(i));
		}
		System.out.println("���д���ˡ�����");

		byte[] b = { 97, 98, 99, 100, 101 };
		os.write(b);// ���������������д���ļ���

		os.close();
		// ��ϰ1�����ַ�����д�뱾���ļ������ֽ����飬д�뱾���ļ���
		// ��ϰ2��write(byte[]b,int off,int len);
		// ��ϰ3������ļ������ڣ�д�����Զ������ļ�����д������ļ��в������أ�

	}

}
