package blog.naver.db;

public class VO {
	private String rank, id, pw, name;
	public VO() {}
	public VO(String rank, String id, String pw, String name) {
		super();
		this.rank = rank;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
