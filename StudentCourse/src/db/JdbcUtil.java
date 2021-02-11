package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
public class JdbcUtil {

	
	public static Connection getConnection() {
		Connection con = null;
		try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env"); //폴더 이름
		DataSource ds = (DataSource) envCtx.lookup("jdbc/OracleDB"); //파일 이름
		
		con=ds.getConnection();
		con.setAutoCommit(false);
		System.out.println("DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
	
	public static void close(Connection con) {
		try {
			con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void commit(Connection con) {
		try {
			con.commit();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
			}catch(Exception e) {
				e.printStackTrace();
			}
		
	}
}
