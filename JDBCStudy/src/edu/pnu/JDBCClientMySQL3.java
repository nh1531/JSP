package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JDBCClientMySQL3 {

	public void StudyStatement1(Connection con) throws Exception {

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select count(cl.Language) "
				+ "from country c, countrylanguage cl "
				+ "where c.Code = cl.CountryCode "
				+ "and cl.Language = 'English'");

		while (rs.next()) {
			System.out.print(rs.getString(1));

			System.out.println();
		}
		rs.close();
		st.close();
	}
	
	public void StudyStatement2(Connection con) throws Exception {

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select cl.Language "
				+ "from country c, countrylanguage cl "
				+ "where c.Code = cl.CountryCode "
				+ "and c.Code = 'KOR';");

		while (rs.next()) {
			System.out.print(rs.getString(1));

			System.out.println();
		}
		rs.close();
		st.close();
	}
	
	public void StudyStatement3(Connection con) throws Exception {

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select c.Name, c.Continent "
				+ "from country c, countrylanguage cl "
				+ "where cl.Language = 'English' and cl.IsOfficial = 'T' "
				+ "and c.Code = cl.CountryCode");

		while (rs.next()) {
			System.out.print(rs.getString(1) + " / " +rs.getString(2));

			System.out.println();
		}
		rs.close();
		st.close();
	}
	
	public void StudyStatement4(Connection con) throws Exception {

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select c.Continent, count(c.Name) as count "
				+ "from country c, countrylanguage cl "
				+ "where c.Code = cl.CountryCode "
				+ "and cl.Language = 'English' "
				+ "group by c.Continent");

		while (rs.next()) {
			System.out.print(rs.getString(1) + " / " +rs.getString(2) );

			System.out.println();
		}
		rs.close();
		st.close();
	}


	public static void main(String[] args) throws Exception {

		JDBCClientMySQL3 cli = new JDBCClientMySQL3(); // 객체 . 인스턴스 생성

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "musthave", "tiger");) {

			System.out.println("<=== StudyStatement1 ===>");
			cli.StudyStatement1(con); // StudyStatement -> method 호출
			System.out.println();

			System.out.println("<=== StudyStatement2 ===>");
			cli.StudyStatement2(con); 
			System.out.println();
			
			System.out.println("<=== StudyStatement3 ===>");
			cli.StudyStatement3(con); 
			System.out.println();
			
			System.out.println("<=== StudyStatement4 ===>");
			cli.StudyStatement4(con); 
			System.out.println();
		}
	}
}
