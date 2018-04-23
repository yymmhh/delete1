package entity;

public class Food {
	private int id;
	private int typeId;
	private String name;
	private double price;
	private int count;
	private int saleCount;
	private String picSrc;
	public String getPicSrc() {
		return picSrc;
	}
	public void setPicSrc(String picSrc) {
		this.picSrc = picSrc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}

	public Food(int id, int typeId, String name, double price, int count,
			int saleCount, String picSrc) {
		super();
		this.id = id;
		this.typeId = typeId;
		this.name = name;
		this.price = price;
		this.count = count;
		this.saleCount = saleCount;
		this.picSrc = picSrc;
	}
	public Food() {
		// TODO Auto-generated constructor stub
	}
}
