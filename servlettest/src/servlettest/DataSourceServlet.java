package servlettest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class DataSourceServlet
 */
@WebServlet("/DataSourceServlet")
public class DataSourceServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
//		try {
//			for(int i = 1; i<100; i++) {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
//				System.out.println(i + " 번째 연결 생성 - " + conn);
//				conn.close();//db연결 해제. 메모리 삭제 con 표시, 나중에 모아서 삭제 작업 일괄적
//			}
//			
//			
//
//		}catch(ClassNotFoundException e) {
//			System.out.println("드라이버 문제");
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
		try {

			//1. context = 현재의 dynamic web project
			//servlettest 관련설정 가능 
			Context initContext = new InitialContext();//현재작업다이나믹웹 프로젝트  찾아와
			Context envContext = (Context)initContext.lookup("java:/comp/env");//2. server.xml 설정 찾아와
			//3. name=jdbc/myoracle 설정 객체 읽어와라
			//ds = connectionpool 객체 
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle"); //name="jdbc/myoracle 찾아와	
			
			for(int i = 1; i <= 100; i++) {
				Connection con = ds.getConnection();
				System.out.println(i + " 번째 연결 생성 - " + con);
				//작업 소요 시간에 따라 달라짐
				con.close();
			}
		}catch(NamingException e) {
			System.out.println("이름 문제");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
