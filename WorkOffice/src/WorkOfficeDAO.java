import java.sql.DriverManager;
import java.sql.SQLException;

public class WorkOfficeDAO
{

	private String protocol = "jdbc:derby:";
	private String dbName="C:/Users/Janki/Desktop/WorkOfficeDB";
		
	
	public WorkOfficeDAO(){
		
    //Connection
		try
		{
			DriverManager.getConnection(protocol+dbName+";create=true");
			System.out.println("Connected");	
			
	// Close connection connection		
			closeConnection();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
		
	}

	
	
	
//Close connection method.
	public void closeConnection(){
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
                
            // Prints details of an SQLException chain to <code>System.err</code>.
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
		
	}
	

	
	
	
	
	
	
}
