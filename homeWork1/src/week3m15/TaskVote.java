package week3m15;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TaskVote {
	private List<Student> list = new ArrayList<Student>();
	
	public TaskVote(){
		list.add(new Student(1,"z",true));
		list.add(new Student(2,"a",true));
		list.add(new Student(3,"b",true));
		list.add(new Student(4,"c",true));
		list.add(new Student(5,"d"));
		list.add(new Student(6,"e"));
		list.add(new Student(7,"f"));
	}
	
	public int getVote(){
		InputStream inputStream = System.in;
		int num = 0;
		try {
			num = inputStream.read()-'0'-1;
			inputStream.read();
			inputStream.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		list.get(num).addCount();
		return num;
	}
	
	public void vote() {
		List<Student> voteStudents = new ArrayList<Student>();
		Student student = null;
		boolean over = false;
		int count = 0;
		int maxVote = 0;
		Student maxStudent = null;
		while (!over) {
			Iterator<Student> it1 = list.iterator();
			Iterator<Student> it2 = list.iterator();
			System.out.println("============vote==================");
			System.out.println("竞选人名单：");
			while (it1.hasNext()) {
				student = it1.next();
				if (student.isVote() == true) {
					student.setCount(0);
					System.out.println("学号：" + student.getId() + "\t姓名："
							+ student.getName());
				}
			}
			System.out.println("现在开始进行投票：");
			for(int i = 0; i<list.size() ; i++){
				getVote();
			}

			for(int i = 0; i<list.size(); i++){
				if(list.get(i).getCount() > maxVote){
					maxVote = list.get(i).getCount();
				}
				list.get(i).setVote(false);
			}
			
			for(int i = 0; i<list.size();i++){
				if(list.get(i).getCount() == maxVote){
					list.get(i).setVote(true);
					maxStudent = list.get(i);
					count++;
				}
			}
			
			if(count == 1){
				System.out.println(maxStudent.getName()+" win");
				return;
			}
			count = 0;
		}
	}
	
	public static void main(String[] args) {
		TaskVote tVote = new TaskVote();
		tVote.vote();
	}
}
