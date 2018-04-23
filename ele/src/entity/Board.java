package entity;

public class Board {
	private int id;
	private BoardType boardType;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public Board(int id, BoardType boardType, int status) {
		super();
		this.id = id;
		this.boardType = boardType;
		this.status = status;
	}
	public BoardType getBoardType() {
		return boardType;
	}
	public void setBoardType(BoardType boardType) {
		this.boardType = boardType;
	}
	public Board() {
		// TODO Auto-generated constructor stub
	}
}
