package hw3m13;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TaskLetter {
	
	
	public static void main(String[] args) throws IOException {
		InputStream inputStream = System.in;
		Reader reader = new InputStreamReader(inputStream);
		int i = reader.read();
		while(i != '8'){
			System.out.print((char)i);
			 i = reader.read();
		}
	}
}
