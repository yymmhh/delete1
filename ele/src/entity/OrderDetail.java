package entity;

public class OrderDetail {
	private String id;
	private String user_id;
	private String board_Id;
	private String recorder_time;
	private String taste;
	private String status;
	private String total;
	private OrderInfo info;
	public OrderDetail(String id, String user_id, String board_Id, String recorder_time, String status,
			OrderInfo info) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.board_Id = board_Id;
		this.recorder_time = recorder_time;
		this.status = status;
		this.info = info;
	}
	public OrderInfo getInfo() {
		return info;
	}
	public void setInfo(OrderInfo info) {
		this.info = info;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBoard_Id() {
		return board_Id;
	}
	public void setBoard_Id(String board_Id) {
		this.board_Id = board_Id;
	}
	public String getRecorder_time() {
		return recorder_time;
	}
	public void setRecorder_time(String recorder_time) {
		this.recorder_time = recorder_time;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
