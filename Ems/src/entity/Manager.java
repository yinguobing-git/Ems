package entity;

public class Manager {
	private int id;
	private String name;
	private String username;
	private String password;
	private String sex;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Manager(int id, String name, String username, String password,
			String sex) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.sex = sex;
	}
	public Manager(String name, String username, String password, String sex) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.sex = sex;
	}
	public Manager() {
		super();
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", username="
				+ username + ", password=" + password + ", sex=" + sex + "]";
	}
	
}
