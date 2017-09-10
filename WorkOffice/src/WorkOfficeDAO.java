import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class WorkOfficeDAO
{

	private String protocol = "jdbc:derby:";
	private String dbName="C:/Users/Janki/Desktop/WorkOfficeDB";
	private Connection conn=null;
	private Statement stm=null;
		
	
	public WorkOfficeDAO(){
		
        
		try
		{	
			//Connection to DataBase
			conn=DriverManager.getConnection(protocol+dbName+";create=true");
			System.out.println("Connected");
		} 
		catch (SQLException e)
		{
			printSQLException(e);
			e.printStackTrace();
		}	
	}
	
	
	
	
	
	
	
//Method to check if tables exist;
	
	public void ifTablesExist(){
		try
		{
			DatabaseMetaData dbmd=conn.getMetaData();
			ResultSet tables=dbmd.getTables(null, null, "FAMILIES", null);
			if(tables.next()){
				System.out.println("tables exists");
			}
			else{
				createTables();
				System.out.println("Tables has been created");
			}
			tables.close();
		} catch (SQLException e)
		{
			printSQLException(e);
		}
		
	}
	
	
	
	
//Method to creating Families Table;
	
	public void createTables(){
	
		String createFamiliesT="create table Families("
				+ "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
				+ "Name VARCHAR(20) NOT NULL,"
				+ "Surname VARCHAR(20) NOT NULL,"
				+ "Birth_Date VARCHAR(20) NOT NULL,"
				+ "Phone VARCHAR(20) NOT NULL,"
				+ "City VARCHAR(20) NOT NULL,"
				+ "Post_Code VARCHAR(20) NOT NULL,"
				+ "Street VARCHAR(20) NOT NULL,"
				+ "HousNr VARCHAR(20) NOT NULL,"
				+ "FlatNr VARCHAR(20) NOT NULL,"
				+ "FamilyPhone VARCHAR(20) NOT NULL,"
				+ "Physical_Fit VARCHAR(20) NOT NULL,"
				+ "Rate VARCHAR(20) NOT NULL,"
				+ "Info VARCHAR(100) NOT NULL,"
				+ "LanguageLvl VARCHAR(20) NOT NULL,"
				+ "Experience VARCHAR(20) NOT NULL,"
				+ "Physical_Work VARCHAR(20) NOT NULL,"
				+ "Employee_Age VARCHAR(20) NOT NULL"
				+ ")";	
			
		try
		{
			stm=conn.createStatement();
			stm.execute(createFamiliesT);
			stm.close();
		} catch (SQLException e)
		{
			System.out.println("Problem with created tables Families");
			printSQLException(e);
		}
	
	}
	
// Insert data.
	public void insertData(String name,String surname,String birthdate,String phone,String city,String postcode,String street,String housnr,
			String flatnr,String familyphone,String physicalfit,String rate,String info,String languagelvl,String experiencce,
			String physicalwork,String employeeage){

		try
		{

			PreparedStatement prst=conn.prepareStatement("insert into FAMILIES(Name,Surname,Birth_Date,Phone,City,Post_Code,Street,HousNr,FlatNr,"
					                                    + "FamilyPhone,Physical_Fit,Rate,Info,LanguageLvl,Experience,Physical_Work,Employee_Age) "
					                                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			prst.setString(1, name);
			prst.setString(2, surname);
			prst.setString(3, birthdate);
			prst.setString(4, phone);
			prst.setString(5, city);
			prst.setString(6, postcode);
			prst.setString(7, street);
			prst.setString(8, housnr);
			prst.setString(9, flatnr);
			prst.setString(10, familyphone);
			prst.setString(11, physicalfit);
			prst.setString(12, rate);
			prst.setString(13, info);
			prst.setString(14, languagelvl);
			prst.setString(15, experiencce);
			prst.setString(16, physicalwork);
			prst.setString(17, employeeage);
			prst.execute();
			System.out.print("Data inserted");
			
			prst.close();
		} catch (SQLException e)
		{
			System.out.print("Problem with insert data.");
			printSQLException(e);
		}
	}
	
	

//Method to print table.
	
	public void showTable(){
	 String sqlSelect="select * from Families";
	 
		try
		{
			stm=conn.createStatement();
			ResultSet res=stm.executeQuery(sqlSelect);
			ResultSetMetaData rsmd=res.getMetaData();
			int columnCount=rsmd.getColumnCount();
			System.out.println("");
			for(int i=1; i<=columnCount; i++){
				System.out.format("%20s", rsmd.getColumnName(i)+"|");
			}
			System.out.println("");
			
			while(res.next()){
				for(int i=1; i<=columnCount; i++){
					System.out.format("%20s", res.getString(i)+"|");
				}
				System.out.println("");
			}
			res.close();
			stm.close();
		
		
		} catch (SQLException e)
		{
			printSQLException(e);
		}
	}
	
	
	
	
//Method to close connection.
	public void closeConnection(){
		try
		{
			DriverManager.getConnection("jdbc:derby:;shutdown=true");
			conn.close();
			stm.close();
		} 
		catch (SQLException e)
		{
			if (( (e.getErrorCode() == 50000) && ("XJ015".equals(e.getSQLState()) ))) {
                System.out.println("Derby shut down normally");
            } 
			else 
			{
				printSQLException(e);
                System.err.println("Derby did not shut down normally");
                
            }
		}
		
	}
	

	
	
//Print SQL exception	
	public static void printSQLException(SQLException e)
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
