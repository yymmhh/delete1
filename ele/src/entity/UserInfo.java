package entity;

public class UserInfo {
	private int id;
	private User user;
	private String user_name;
	private String user_photo;
	private String user_gender;
	private String user_phoneNo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_photo() {
		return user_photo;
	}
	public void setUser_photo(String user_photo) {
		this.user_photo = user_photo;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_phoneNo() {
		return user_phoneNo;
	}
	public UserInfo(int id, User user, String user_name, String user_photo,
			String user_gender, String user_phoneNo) {
		super();
		this.id = id;
		this.user = user;
		this.user_name = user_name;
		this.user_photo = user_photo;
		this.user_gender = user_gender;
		this.user_phoneNo = user_phoneNo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setUser_phoneNo(String user_phoneNo) {
		this.user_phoneNo = user_phoneNo;
	}

	public UserInfo() {
		// TODO Auto-generated constructor stub
	}
	public UserInfo(int id, String user_name, String user_photo, String user_gender, String user_phoneNo) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.user_photo = user_photo;
		this.user_gender = user_gender;
		this.user_phoneNo = user_phoneNo;
	}
	public UserInfo(int id, String user_name, String user_photo) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.user_photo = user_photo;
	}
	public UserInfo(int id) {
		super();
		this.id = id;
	}
	
	
	
	
	
	
}
