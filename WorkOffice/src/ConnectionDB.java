import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB
{
	private Connection conn=null;
	private String protocol = "jdbc:derby:";
	private String dbName="C:/Users/Janki/Desktop/WorkOfficeDB";
		
	
	public ConnectionDB(){
		
   //Connection
		try
		{
			conn=DriverManager.getConnection(protocol+dbName+";create=true");
			System.out.println("Connected");
			
			
			
			
			
			
		// ShutDown connection		
			try
			{
				DriverManager.getConnection("jdbc:derby:;shutdown=true");
			} 
			catch (SQLException e)
			{
				if (( (e.getErrorCode() == 50000) && ("XJ015".equals(e.getSQLState()) ))) {
	                System.out.println("Derby shut down normally");
	            } 
				else 
				{
	                System.err.println("Derby did not shut down normally");
	                printSQLException(e);
	            }
			}
			
			
		
			
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
		
	}

	
	
	
// Prints details of an SQLException chain to <code>System.err</code>.
	private void printSQLException(SQLException e)
	{
		while (e != null)
        {
            System.err.println("\n----- SQLException -----");
            System.err.println("  SQL State:  " + e.getSQLState());
            System.err.println("  Error Code: " + e.getErrorCode());
            System.err.println("  Message:    " + e.getMessage());
            e = e.getNextException();
        }
		
	}

}
