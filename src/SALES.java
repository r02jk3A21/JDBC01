/**
 * 
 */

/**
 * @author t.yoshizawa
 *
 */

import java.sql.*;
import java.util.ArrayList;

public class SALES {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		final String driverName = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@192.168.54.226:1521/orcl";
		final String id = "WIEN";
		final String pass = "WIEN";

		Class.forName(driverName);
		Connection connection=DriverManager.getConnection(url,id,pass);
		PreparedStatement st = 
				connection.prepareStatement(
					"SELECT PRODUCTS.PRODUCT_NAME , PRODUCTS.PRICE , SALES.QUANTITY , SALES.SALES_DATE , PRICE*QUANTITY  FROM PRODUCTS "
					+ "INNER JOIN SALES ON PRODUCTS.PRODUCT_ID = SALES.PRODUCT_ID"
					);
		ResultSet rs = st.executeQuery();
		
		while(rs.next() != false) {
			System.out.print( rs.getString("PRODUCT_NAME"));
			System.out.print( "|");
			System.out.print( rs.getString("PRICE"));
			System.out.print( "|");
			System.out.print( rs.getString("QUANTITY"));
			System.out.print( "|");
			System.out.print( rs.getString("SALES_DATE"));
			System.out.print( "|");
			System.out.print(rs.getString("PRICE*QUANTITY"));
			System.out.println( );

			
			
		}
		
	}

}

