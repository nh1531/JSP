package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JDBCClientMySQL2 {

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
	
	public void StudyStatement(Connection con) throws Exception {

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from country limit 10");

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

	// Statement 
	// PrepareStatement 뒤에 파라미터가 들어갈 때 where절에 조건 들어갈 땐 이거 사용 ex) "select * from country where code=?" 
	// 변수형식으로 조건 받을 때
	// st.setString(1,"a"); a='a'
	// st.setInt(2,100); b= 100
	public void StudyPrepareStatement(Connection con) throws Exception {
		
		PreparedStatement st = con.prepareStatement("select * from country where code=?"); // '' 안들어감
		st.setString(1, "KOR"); // setString -> 자동으로 ' ' 를 찍어서 넣어줌. setInt -> 숫자 넣어주는 메서드
		ResultSet rs = st.executeQuery();

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
	
	public static void main(String[] args) throws Exception  {

		JDBCClientMySQL2 cli = new JDBCClientMySQL2(); // 객체 . 인스턴스 생성

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "musthave", "tiger");) {
			
			System.out.println("<=== StudyStatement ===>");
			cli.StudyStatement(con); // StudyStatement -> method 호출
			System.out.println();

			System.out.println("<=== StudyPrepareStatement ===>");
			cli.StudyPrepareStatement(con);
		}		
	}
}
