package member;

public class MemberDTO {
//member 테이블의 id만 board
	String id;
	int password;
	String name;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	public MemberDTO(String id, int password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return id + " | " + password + " | " + name;
		}
}
