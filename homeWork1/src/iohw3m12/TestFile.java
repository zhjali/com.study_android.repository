package iohw3m12;

import java.io.File;
import java.io.IOException;

public class TestFile {
	
	public File creatOrDelet(String pathname){
		int index = pathname.lastIndexOf('/');
		System.out.println(index);
		String parent = pathname.substring(0, index);
		String child = pathname.substring(index);
		File directory = new File(parent);
		File file = new File(parent,child);
		if(file.exists()){
			file.delete();
			System.out.println("The file of \""+pathname+"\" is delete");
		}else{
			try {
				directory.mkdirs();
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("can't created");
				return null;
			}
			System.out.println("The file of \""+pathname+"\" be created");
		}
		return file;
	}

	public void showFiles(File file) {
		System.out.println(file);
		if (file.isDirectory()) {// 如果是目录，就可以遍历
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				showFiles(files[i]);
			}
		}

	}
	
	public void show(File file){
		if(file.isFile()){
			System.out.println(file);
		}
		else{
			System.out.println(file);
			for(int i = 0; i<file.list().length; i++){
				show(file.listFiles()[i]);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		File file1 = new File("C://workspace/homeWork1");
//		File file2 = new File(file1,".");
//		System.out.println(file1.getAbsolutePath());
//		System.out.println(file2.getAbsolutePath());
		TestFile tf = new TestFile();
		File file = new File("C://hellow");
//		tf.show("C://hellow");
		tf.show(file);
		System.out.println("___________________");
		tf.showFiles(file);
	}
}
