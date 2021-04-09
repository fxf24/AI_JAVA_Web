package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	PreparedStatement pt = null;
	Connection conn = null;
	ResultSet rs = null;
	
	int insertBoard(BoardDTO dto) {
		int num = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			String sql = "insert into board values( (select max(seq)+1 from board), ?, ?, ?, sysdate, ?, 0)";
			pt = conn.prepareStatement(sql);
			pt.setString(1, dto.getTitle());
			pt.setString(2, dto.getContents());
			pt.setString(3, dto.getWriter());
			pt.setInt(4, dto.getPassword());
			
			num = pt.executeUpdate();
		} 
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		}
		catch(SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace();
		}
		finally {
			try {
				pt.close();
				conn.close();
			}
			catch(SQLException e) {
				
			}
		}
		return num;
	}
	
	public ArrayList<BoardDTO> getBoardList(){
		ArrayList<BoardDTO> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			String sql = "select * from board order by time desc";
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();
			
			while(rs.next()) {
				int seq = rs.getInt("seq");
				int password = rs.getInt("password");
				int viewcount = rs.getInt("viewcount");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String writer = rs.getString("writer");
				String time = rs.getString("time");
				
				list.add(new BoardDTO(seq, password, viewcount, title, contents, writer, time));
			}
			
			
		} 
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		}
		catch(SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pt.close();
				conn.close();
			}
			catch(SQLException e) {
				
			}
		}
		
		return list;
	}
	
	public ArrayList<BoardDTO> getBoardList(int pagenum, int cntPerPage){
		ArrayList<BoardDTO> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			String sql = "select * "
					+ "from (select seq s, title, contents, writer, time, password, viewcount"
					+ " from board order by time desc)"
					+ "where s >= ? and s <= ?";
			
			pt = conn.prepareStatement(sql);
			int startnum = pagenum*cntPerPage - cntPerPage +1;
			pt.setInt(1, startnum);
			pt.setInt(2, startnum + cntPerPage -1);
			
			rs = pt.executeQuery();
			
			while(rs.next()) {
				int seq = rs.getInt("s");
				int password = rs.getInt("password");
				int viewcount = rs.getInt("viewcount");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String writer = rs.getString("writer");
				String time = rs.getString("time");
				
				list.add(new BoardDTO(seq, password, viewcount, title, contents, writer, time));
			}
			
			
		} 
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		}
		catch(SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pt.close();
				conn.close();
			}
			catch(SQLException e) {
				
			}
		}
		
		return list;
	}
	
	public int getBoardCount() {
		int cnt = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			String sql = "select count(*) from board";
			
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt("count(*)");
			}
			
		} 
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		}
		catch(SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pt.close();
				conn.close();
			}
			catch(SQLException e) {
				
			}
		}
		
		return cnt;
	}
	
	BoardDTO getDetailBoardList(int seq){
		BoardDTO bdto = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			String sql = "update board set viewcount = viewcount +1 where seq= ?";
			pt = conn.prepareStatement(sql);
			pt.setInt(1, seq);
			pt.executeUpdate();
			
			sql = "select * from board where seq=?";
			pt = conn.prepareStatement(sql);
			pt.setInt(1, seq);
			rs = pt.executeQuery();
			
			while(rs.next()) {
				int sequ = rs.getInt("seq");
				int password = rs.getInt("password");
				int viewcount = rs.getInt("viewcount");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String writer = rs.getString("writer");
				String time = rs.getString("time");
				
				bdto = new BoardDTO(sequ, password, viewcount, title, contents, writer, time);
			}
			
			
		} 
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		}
		catch(SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pt.close();
				conn.close();
			}
			catch(SQLException e) {
				
			}
		}
		
		return bdto;
	}
	
	boolean getMember(String writer){
		boolean result = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			String sql = "select id from member where id=?";

			pt = conn.prepareStatement(sql);
			pt.setString(1, writer);
			rs = pt.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
		} 
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		}
		catch(SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pt.close();
				conn.close();
			}
			catch(SQLException e) {
				
			}
		}
		
		return result;
	}
}
