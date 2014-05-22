import java.util.ArrayList;

public class task_listAdd {
	ArrayList<String> strings = new ArrayList<String>();

	public static void main(String[] args) {
		task_listAdd ts = new task_listAdd();
		ts.strings.add("nihao)");
		ts.strings.add(0, "add");
		System.out.println(ts.strings.size());
	}
}
