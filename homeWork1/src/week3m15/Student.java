package week3m15;

public class Student {
	private int id;
	private String name;
	private int count = 0;
	private boolean isVote;
	
	public Student(int id, String name, boolean isVote) {
		super();
		this.id = id;
		this.name = name;
		this.isVote = isVote;
	}
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Student() {
		super();
	}

	public boolean isVote() {
		return isVote;
	}

	public void setVote(boolean isVote) {
		this.isVote = isVote;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void addCount() {
		count++;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
}
