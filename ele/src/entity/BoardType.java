package entity;

public class BoardType {
	private int id;
	private String board_typr;
	private int maxCount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBoard_typr() {
		return board_typr;
	}
	public void setBoard_typr(String board_typr) {
		this.board_typr = board_typr;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	public BoardType(int id, String board_typr, int maxCount) {
		super();
		this.id = id;
		this.board_typr = board_typr;
		this.maxCount = maxCount;
	}
	public BoardType() {
		// TODO Auto-generated constructor stub
	}
}
