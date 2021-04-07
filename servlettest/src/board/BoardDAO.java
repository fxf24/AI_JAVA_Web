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
	
	void insertBoard(BoardDTO dto) {
		//매개변수 전달 dto 
		//번호 - 시퀀스 값 자동 1 증가(입력x)
		//작성시간 - 기본 sysdate 자동
		//조회수 0 자동(입력x)
		//insert sql 작성
		//Driver 로딩
		//con 생성
		//pt나 st생성
		// 실행
		//close
		//try-catch-finally
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			String sql = 
//					"insert into board values(boardnum.nextval, ?, ?, ?, sysdate, ?, 0)";
					"insert into board values(select max(seq)+1 from board, ?, ?, ?, sysdate, ?, 0)";
			pt = conn.prepareStatement(sql);
			pt.setString(1, dto.getTitle());
			pt.setString(2, dto.getContents());
			pt.setString(3, dto.getWriter());
			pt.setInt(4, dto.getPassword());
			
			pt.executeUpdate();
			
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
		
	}
	
	ArrayList<BoardDTO> getBoardList(){
		ArrayList<BoardDTO> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			String sql = "select * from board";
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
	
	ArrayList<BoardDTO> getBoardList(int pagenum, int cntPerPage){
		ArrayList<BoardDTO> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			String sql = "select * "
					+ "from (select seq s, title, contents, writer, time, password, viewcount"
					+ " from board order by time desc)"
					+ "where s >= ? and s <= ?";
			
			pt = conn.prepareStatement(sql);
			pt.setInt(1, pagenum);
			pt.setInt(2, pagenum + cntPerPage -1);
			
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
}
