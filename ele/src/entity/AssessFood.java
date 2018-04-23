package entity;

public class AssessFood {
	private int id;
	private String assess;
	private UserInfo userInfo;
	private String commentTime;
	private String picSrc;
	private int rank;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAssess() {
		return assess;
	}
	public void setAssess(String assess) {
		this.assess = assess;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public String getPicSrc() {
		return picSrc;
	}
	public void setPicSrc(String picSrc) {
		this.picSrc = picSrc;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public AssessFood(int id, String assess, UserInfo userInfo,
			String commentTime, String picSrc, int rank) {
		super();
		this.id = id;
		this.assess = assess;
		this.userInfo = userInfo;
		this.commentTime = commentTime;
		this.picSrc = picSrc;
		this.rank = rank;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public AssessFood() {
		// TODO Auto-generated constructor stub
	}
}
