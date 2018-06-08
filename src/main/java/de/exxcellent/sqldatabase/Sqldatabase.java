package de.exxcellent.sqldatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement; 

public class Sqldatabase {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		

		
	}
		
	
	
	
	public static String dayWithSmallestTempSpread() throws Exception {
		String dayWithSmallestTempSpread = getSmallestSpreadfromsqldatabase("weather", "Day" ,"MxT", "MnT");
		return dayWithSmallestTempSpread;
		
		
	}
	
	public static String teamWithSmallesGoalSpread() throws Exception {
		String dayWithSmallestTempSpread = getSmallestSpreadfromsqldatabase("football", "Team", "Goals", "`Goals Allowed`");
		return dayWithSmallestTempSpread;

	}

	
	
	
	/**
	 * 
	 * Returns the name of the "identifier" with the smallest spread between two columns of an sql table.
	 *
	 * @param  tablename  Name of the sql table (i.e. "weather" or "football"
	 * @param  identifiercolumn Name of the sql column name which works as an identifier (i.e. "Day" or "Team"
	 * @param  spreadcolumn1 Column name of the 1st spread value (i.e "MxT" or "Goals")
	 * @param  spreadcolumn2 Column name of the 2nd spread value (i.e. "MnT" or "`Goals Allowed`")
	 * @return Returns a string containing the fieldcontent of the identifiercolumn with the smallest spread
	 */

	public static String getSmallestSpreadfromsqldatabase(String tablename,String identifiercolumn, String spreadcolum1, String spreadcolum2) throws Exception{
		
		try {
			
	                	Connection conn = getConnection();
	                    Statement stmt = conn.createStatement();
	                    ResultSet rs;
	                    String identifier = identifiercolumn;
	                    String spreadvalue1 = spreadcolum1;
	                    String spreadvalue2 = spreadcolum2;
	                    String table = tablename;
	                    
	                    rs = stmt.executeQuery("SELECT " +identifier +", " +spreadvalue1 +"-" +spreadvalue2 +" AS Spread FROM " +table +" ORDER BY Spread ASC");
	                    if ( rs.first() ) {                   	
	                    	                    	

	                      return rs.getString(identifier);
	                                   
	                    }
	                    conn.close();
	                } 
	
	catch (Exception e) {
	                    System.err.println("Got an exception! ");
	                    System.err.println(e.getMessage());
	                }
		return null;		
		}

	
		
		
	public static Connection getConnection() throws Exception{

		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://www.db4free.net:3306/challweather"; 
			String username = "challenger"; 
			String password = "rw88Nwv3ZjqgLybq"; 
			Class.forName(driver); 
			Connection conn = DriverManager.getConnection(url,username,password); 
			System.out.println("Connected to sql database"); 
			return conn;
		}
		catch(Exception e){System.out.println(e);}
		
		return null;
		
	}
	
}


