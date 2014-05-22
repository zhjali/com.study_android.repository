package hw3m7;

public class Student implements Comparable<Student>{
	int age;
	int score;
	String name;
	String dirthday;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result
				+ ((dirthday == null) ? 0 : dirthday.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (dirthday == null) {
			if (other.dirthday != null)
				return false;
		} else if (!dirthday.equals(other.dirthday))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (score != other.score) 
				return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", score=" + score + ", name=" + name
				+ ", dirthday=" + dirthday + "]";
	}

	public Student() {
		super();
	}
	
	public Student(String name, int age, int score, String dirthday) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
		this.dirthday = dirthday;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getscore() {
		return score;
	}
	public void setscore(int score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirthday() {
		return dirthday;
	}
	public void setDirthday(String dirthday) {
		this.dirthday = dirthday;
	}

	@Override
	public int compareTo(Student o) {
		if(this.score < o.score)
			return -1;
		if(this.score > o.score)
			return 1;
		if(this.age < o.age)
			return -1;
		else if(this.age > o.age)
			return 1;
		return this.name.compareTo(o.name);
	}
	
}
