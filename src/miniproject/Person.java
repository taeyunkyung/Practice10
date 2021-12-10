package miniproject;

public class Person {

	private String name;
	private String hp;
	private String company;
	private int count;

	public Person() {

	}

	public Person(String name, String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", hp=" + hp + ", company=" + company + ", count=" + count + "]";
	}

	public void printList() {
		System.out.println(count + ".   " + name + "   " + hp + "   " + company);
	}

	public String enter() {
		return name + "," + hp + "," + company;
	}

}
