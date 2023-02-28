package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JDBCClientH2 {

	public int printColumnName(ResultSet rs) throws Exception {
		ResultSetMetaData meta = rs.getMetaData();
		int count = meta.getColumnCount();
		
		StringBuilder sb = new StringBuilder("#");
		for (int i = 1 ; i <= count ; i++) {
			sb.append("," + meta.getColumnName(i));
		}
		System.out.println(sb);
		System.out.println("-".repeat(sb.length()));
		
		return count;
	}
	
	public void StudyStatement1(Connection con) throws Exception {

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from board ");

		int colCount = printColumnName(rs);
		int rowCount = 1;
		while(rs.next()) {
			for(int i = 1 ; i <= colCount ; i++) {
				if (i == 1)	System.out.print((rowCount++) + ",");
				else		System.out.print(",");
				System.out.print(rs.getString(i));
			}
			System.out.println();
		}
		rs.close();
		st.close();
	}
	
	public void StudyStatement2(Connection con) throws Exception {

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select id, pass, name, regidate from member ");

		int rowCount = 1;
		while(rs.next()) {
			for(int i = 1 ; i <= 4 ; i++) {
				if (i == 1)	System.out.print((rowCount++) + " ");
				else		System.out.print(" ");
				System.out.print(rs.getString(i));
			}
			System.out.println();
		}
		rs.close();
		st.close();
	}

	
	public static void main(String[] args) throws Exception  {

		JDBCClientH2 cli = new JDBCClientH2(); // 객체 . 인스턴스 생성

		Class.forName("org.h2.Driver"); // 변경할 것 2개 ** 1) 드라이버 클래스

		// ** 2) url, 사용자, 패스워드
		try (Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/musthave", "sa", "");) {
			
			System.out.println("<=== StudyStatement1 ===>");
			cli.StudyStatement1(con); // StudyStatement -> method 호출
			System.out.println();
			
			System.out.println("<=== StudyStatement2 ===>");
			cli.StudyStatement2(con); 
			System.out.println();

		}		
	}
}
