package entity;

public class User {
	private int id;
	private String account;
	private String password;
	private String salt;
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(int id, String account, String password, String salt) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.salt = salt;
	}
	
	
	public User(int id) {
		super();
		this.id = id;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
}
