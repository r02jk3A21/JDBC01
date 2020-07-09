/**
 * 
 */

/**
 * @author t.yoshizawa
 *
 */

import java.sql.*;
import java.util.ArrayList;

public class JDBC01 {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		final String driverName = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@192.168.54.226:1521/orcl";
		final String id = "SCOTT";
		final String pass = "TIGER";

		Class.forName(driverName);
		Connection connection=DriverManager.getConnection(url,id,pass);
		PreparedStatement st = 
				connection.prepareStatement(
					"SELECT EMPNO , ENAME , JOB , SAL , NVL(COMM,0) AS COMM2  FROM EMP"
					);
		ResultSet rs = st.executeQuery();
		
		while(rs.next() != false) {
			String empno = rs.getString("EMPNO");
			System.out.print( empno);
			System.out.print( "|");
			System.out.print( rs.getString("ENAME"));
			System.out.print( "|");
			System.out.print( rs.getString("JOB"));
			System.out.print( "|");
			System.out.print(rs.getString("SAL"));
			System.out.print( "|");
			System.out.print(rs.getString("COMM2"));
			System.out.println( );
			
			
		}
		
	}

}

