package entity;

public class OrderInfo {

    
    private String id;
    private String food_info;
    private String order_id;
    private String sum;
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFood_info() {
		return food_info;
	}
	public void setFood_info(String food_info) {
		this.food_info = food_info;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public OrderInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderInfo(String food_info, String order_id,String sum) {
		super();
		
		this.food_info = food_info;
		this.order_id = order_id;
		this.sum = sum;
	}
    
    
}
