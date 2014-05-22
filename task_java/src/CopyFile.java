import java.io.File;
import java.io.FilenameFilter;
import java.util.Calendar;

public class CopyFile implements FilenameFilter {
	public static final String ROOT_PATH = "C:/Documents and Settings/Administrator/����/android";
	public static final File ROOT_FILE = new File(ROOT_PATH);
	// �жϵ����ļ���һ���׼
	public static final int HOUR = 6;

	public boolean haveNewFile() {
		System.out.println("hello");
		ROOT_FILE.list(this);
		File[] files = ROOT_FILE.listFiles();
		System.out.println("-----" + files.length);
		for (File item : files) {
			if (item.isDirectory()) {
				if (isNew(item)) {

				}
			}
		}
		return false;
	}

	public boolean isNew(File file) {
		// �ļ����һ���޸ĵ����ڵ�Сʱ��
		int hour = (int) ((Calendar.getInstance().getTimeInMillis() - file
				.lastModified()) / (1000 * 3600));
		if (hour < HOUR) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		CopyFile copyFile = new CopyFile();
		copyFile.haveNewFile();
	}

	@Override
	public boolean accept(File dir, String name) {
		File file = new File(name);
		System.out.println(file.exists());
		return false;
	}
}
