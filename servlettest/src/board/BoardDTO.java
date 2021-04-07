package board;

public class BoardDTO {
	int seq, password, viewcount;
	String title, contents, writer, time;
	
	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardDTO(int seq, int password, int viewcount, String title, String contents, String writer, String time) {
		this.seq = seq;
		this.password = password;
		this.viewcount = viewcount;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.time = time;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return seq + "|" + title  + "|" + contents + "|" + writer + "|" + time + "|" + password + "|" + viewcount;
	}
}
