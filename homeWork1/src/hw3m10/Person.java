package hw3m10;

public class Person implements Comparable<Person>{
	String name;
	String sex;
	int age;
	int socre;
	String range;
	
	public int getSocre() {
		return socre;
	}
	public void setSocre(int socre) {
		this.socre = socre;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(String name, String sex, int age , int socre) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.socre = socre;
		range = this.rangH(socre);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((range == null) ? 0 : range.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + socre;
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
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (range == null) {
			if (other.range != null)
				return false;
		} else if (!range.equals(other.range))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (socre != other.socre)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" 
					+ sex + ", age=" + age + ", socre=" + socre +"]";
	}
	@Override
	public int compareTo(Person o) {
		if(this.socre < o.socre)
			return 1;
		else if(this.socre > o.socre)
			return -1;
		
		if(this.age < o.age)
			return -1;
		else if(this.age > o.age)
			return 1;
		return this.name.compareTo(o.name);
	}
	
	public String rangH(int sorce){
		if(sorce < 60)
			return "Bad";
		if(socre < 70)
			return "pass";
		if(socre < 80)
			return "Mid";
		if(socre < 90)
			return "Good";
		if(socre < 100)
			return "Perfect";
		return "OutOfIndex";
	}
}
