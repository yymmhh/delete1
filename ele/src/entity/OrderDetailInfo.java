package entity;
//4.9 开始废除
public class OrderDetailInfo {
	private String foodName;
	private int count;
	private double price;
	private String userName;
	private String userPhoto;
	private int recorderId;
	private int taste;
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public int getRecorderId() {
		return recorderId;
	}
	public void setRecorderId(int recorderId) {
		this.recorderId = recorderId;
	}
	public int getTaste() {
		return taste;
	}
	public void setTaste(int taste) {
		this.taste = taste;
	}
	public OrderDetailInfo(String foodName, int count, double price,
			String userName, String userPhoto, int recorderId, int taste) {
		super();
		this.foodName = foodName;
		this.count = count;
		this.price = price;
		this.userName = userName;
		this.userPhoto = userPhoto;
		this.recorderId = recorderId;
		this.taste = taste;
	}
	
	public OrderDetailInfo() {
		// TODO Auto-generated constructor stub
	}
}
