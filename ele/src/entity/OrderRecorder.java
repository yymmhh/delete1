package entity;

public class OrderRecorder {
	private int id;
	private User user;
	private Board board;
	private String recorder_time;
	private int taste;
	private int status;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public String getRecorder_time() {
		return recorder_time;
	}
	public void setRecorder_time(String recorder_time) {
		this.recorder_time = recorder_time;
	}
	public int getTaste() {
		return taste;
	}
	public void setTaste(int taste) {
		this.taste = taste;
	}
	
	public OrderRecorder(int id, User user, Board board, String recorderTime,
			int taste, int status) {
		super();
		this.id = id;
		this.user = user;
		this.board = board;
		recorder_time = recorderTime;
		this.taste = taste;
		this.status = status;
	}
	public OrderRecorder() {
		// TODO Auto-generated constructor stub
	}
}
