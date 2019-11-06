package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ems {
	private int id;
	private String name;
	private double salary;
	private int age;
	private String sex;
	private Date birthday;

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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Ems [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", age=" + age + ", sex=" + sex + ", birthday=" + birthday
				+ "]";
	}
	public Ems(int id, String name, double salary, int age, String sex,
			Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
	}
	public Ems(String name, double salary, int age, String sex, Date birthday) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
	}
	public Ems() {
		super();
	}
	
}
