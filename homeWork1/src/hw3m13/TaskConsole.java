package hw3m13;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class TaskConsole {

	public static void main(String[] args) throws IOException {
		File file = new File("C://1.txt");
		Reader in = new InputStreamReader(System.in);
		Writer out = new OutputStreamWriter(new FileOutputStream(file,true));
		char[] ch = new char[600];
		int i = 0;
		while(ch[0] != '8'){
			i = in.read(ch);
			System.out.println(new String(ch,0,i-2));
			out.write(ch, 0, i);
			out.flush();
		}
		
	}
}
