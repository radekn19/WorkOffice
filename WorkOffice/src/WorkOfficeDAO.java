import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;


/*
 * 
 * The class by which other classes connect to the database
 * 
 */

public class WorkOfficeDAO {

	private final String protocol = "jdbc:derby:";
	private final String dbName = "WorkOfficeDB";
	private Connection conn = null;
	private Statement stm = null;

	public WorkOfficeDAO() {

		// Connection to DataBase

		try {
			conn = DriverManager.getConnection(protocol + dbName + ";create=true;user=test;password=test");
			System.out.println("(WorkOfficeDAO) Connected");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
			printSQLException(e);

		}
	}

	// ------------------------------------------------FAMILIES METHODS---------------------------------------------------------

	// Method to check if Families tables exist;

	public void ifTablesExist() {
		try {
			DatabaseMetaData dbmd = conn.getMetaData();
			ResultSet res = dbmd.getTables(null, null, "FAMILIES", null);
			if (res.next()) {
				System.out.println("(WorkOfficeDAO) Families table exists");

			} else {
				createTables();
				System.out.println("(WorkOfficeDAO) Families table has been created");
			}
			res.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
			printSQLException(e);
		}

	}

	// Method to creating Families Table into Database;

	public void createTables() {
		String createFamiliesT = "create table Families("
				+ "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
				+ "Name VARCHAR(20) NOT NULL," + "Surname VARCHAR(20) NOT NULL," + "Birth_Date VARCHAR(20) NOT NULL,"
				+ "Phone VARCHAR(20) NOT NULL," + "City VARCHAR(20) NOT NULL," + "Post_Code VARCHAR(20) NOT NULL,"
				+ "Street VARCHAR(20) NOT NULL," + "HousNr VARCHAR(20) NOT NULL," + "FlatNr VARCHAR(20) NOT NULL,"
				+ "FamilyPhone VARCHAR(20) NOT NULL," + "Physical_Fit VARCHAR(20) NOT NULL,"
				+ "Rate VARCHAR(20) NOT NULL," + "Info VARCHAR(100) NOT NULL," + "LanguageLvl VARCHAR(20) NOT NULL,"
				+ "Experience VARCHAR(20) NOT NULL," + "Physical_Work VARCHAR(20) NOT NULL,"
				+ "Employee_Age VARCHAR(20) NOT NULL" + ")";

		try {

			stm = conn.createStatement();
			stm.execute(createFamiliesT);
			stm.close();

		} catch (SQLException e) {
			System.out.println("(WorkOfficeDAO) Problem with created Families table");
			JOptionPane.showMessageDialog(null, e.toString());
			printSQLException(e);
		}

	}

	// Insert data to family table into Database.

	public void insertDataFamily(FamilyModel fam) {

		try {

			PreparedStatement prst = conn
					.prepareStatement("insert into FAMILIES(" + "Name,Surname,Birth_Date,Phone,City,Post_Code,"
							+ "Street,HousNr,FlatNr,FamilyPhone,Physical_Fit,Rate,"
							+ "Info,LanguageLvl,Experience,Physical_Work,Employee_Age) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			prst.setString(1, fam.getName());
			prst.setString(2, fam.getSurname());
			prst.setString(3, fam.getBirthdate());
			prst.setString(4, fam.getPhone());
			prst.setString(5, fam.getCity());
			prst.setString(6, fam.getPostcode());
			prst.setString(7, fam.getStreet());
			prst.setString(8, fam.getNrhouse());
			prst.setString(9, fam.getNrflat());
			prst.setString(10, fam.getPhonetofamily());
			prst.setString(11, fam.getPhysicalfit());
			prst.setString(12, fam.getRate());
			prst.setString(13, fam.getInfo());
			prst.setString(14, fam.getLanguage());
			prst.setString(15, fam.getExperience());
			prst.setString(16, fam.getPhysicalwork());
			prst.setString(17, fam.getEmployeeage());

			prst.execute();
			prst.close();
			System.out.print("(WorkOfficeDAO) Family data inserted");
			JOptionPane.showMessageDialog(null, "Family data inserted.");

		} catch (SQLException e) {
			System.out.print("(WorkOfficeDAO) Problem with insert family data.");
			JOptionPane.showMessageDialog(null, e.toString());
			printSQLException(e);
		}
	}

	// Update Family data to DataBase
	public void updateData(FamilyModel fam, int id) {

		try {

			PreparedStatement prst = conn
					.prepareStatement("UPDATE FAMILIES SET " + "Name=?,Surname=?,Birth_Date=?,Phone=?,City=?,"
							+ "Post_Code=?,Street=?,HousNr=?,FlatNr=?,FamilyPhone=?,"
							+ "Physical_Fit=?,Rate=?,Info=?,LanguageLvl=?,"
							+ "Experience=?,Physical_Work=?,Employee_Age=? " + "WHERE id=?");

			prst.setString(1, fam.getName());
			prst.setString(2, fam.getSurname());
			prst.setString(3, fam.getBirthdate());
			prst.setString(4, fam.getPhone());
			prst.setString(5, fam.getCity());
			prst.setString(6, fam.getPostcode());
			prst.setString(7, fam.getStreet());
			prst.setString(8, fam.getNrhouse());
			prst.setString(9, fam.getNrflat());
			prst.setString(10, fam.getPhonetofamily());
			prst.setString(11, fam.getPhysicalfit());
			prst.setString(12, fam.getRate());
			prst.setString(13, fam.getInfo());
			prst.setString(14, fam.getLanguage());
			prst.setString(15, fam.getExperience());
			prst.setString(16, fam.getPhysicalwork());
			prst.setString(17, fam.getEmployeeage());
			prst.setInt(18, id);

			prst.executeUpdate();
			prst.close();

			System.out.println("(WorkOfficeDAO) Family data updated");
			JOptionPane.showMessageDialog(null, "Family data updated");

		} catch (SQLException e) {
			System.out.println("(WorkOfficeDAO) Problem with update Family data");

			printSQLException(e);
		}
	}

	// Delete family from DataBase

	public void deleteData(int id) {
		try {
			PreparedStatement prst = conn.prepareStatement("DELETE FROM FAMILIES WHERE id=?");
			prst.setInt(1, id);
			prst.executeUpdate();
			prst.close();
			JOptionPane.showMessageDialog(null, "Data deleted");
		} catch (SQLException e) {
			printSQLException(e);
		}

	}

	// Loading data from Database.

	public ArrayList<FamilyModel> getFamilyList() {

		ArrayList<FamilyModel> familyList = new ArrayList<>();
		String sqlList = "select * FROM Families";
		try {
			ResultSet res;
			stm = conn.createStatement();
			res = stm.executeQuery(sqlList);
			FamilyModel person;
			while (res.next()) {
				person = new FamilyModel(res.getInt("id"), res.getString("Name"), res.getString("Surname"),
						res.getString("Birth_Date"), res.getString("Phone"), res.getString("City"),
						res.getString("Post_Code"), res.getString("Street"), res.getString("HousNr"),
						res.getString("FlatNr"), res.getString("FamilyPhone"), res.getString("Physical_Fit"),
						res.getString("Rate"), res.getString("Info"), res.getString("LanguageLvl"),
						res.getString("Experience"), res.getString("Physical_Work"), res.getString("Employee_Age"));

				familyList.add(person);
			}

			stm.close();
			res.close();

			System.out.println("(WorkOfficeDAO) DB loaded/getFamilyList");

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("(WorkOfficeDAO) Problem with loaded/getFamilyList");

		}
		return familyList;

	}

	// Method to print table.

	public void showTable() {

		String sqlSelect = "select * from Families";

		try {
			System.out.println("(WorkOfficeDAO) Wyswietlam liste");
			stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sqlSelect);
			ResultSetMetaData rsmd = res.getMetaData();
			int columnCount = rsmd.getColumnCount();
			System.out.println("");
			for (int i = 1; i <= columnCount; i++) {
				System.out.format("%20s", rsmd.getColumnName(i) + "|");
			}
			System.out.println("");

			while (res.next()) {
				for (int i = 1; i <= columnCount; i++) {
					System.out.format("%20s", res.getString(i) + "|");
				}
				System.out.println("");
			}
			res.close();
			conn.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	// =================================================EMPLOYEEMETHODS=========================================================

	// Method to check if Employee table exist

	public void ifEmpTablesExist() {

		try {

			DatabaseMetaData dbmd = conn.getMetaData();
			ResultSet res = dbmd.getTables(null, null, "EMPLOYEE", null);
			if (res.next()) {

				System.out.println("(WorkOfficeDAO) EMPLOYEE table exists");

			} else {

				createEmployeeTables();
				System.out.println("(WorkOfficeDAO) EMPLOYEE table has been created");
			}
			res.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
			printSQLException(e);
		}

	}

	// Create a Employee table.

	public void createEmployeeTables() {

		String createEmployeeT = "create table EMPLOYEE("
				+ "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
				+ "Name VARCHAR(20) NOT NULL," + "Surname VARCHAR(20) NOT NULL," + "Birth_Date VARCHAR(20) NOT NULL,"
				+ "Phone VARCHAR(20) NOT NULL," + "City VARCHAR(20) NOT NULL," + "Post_Code VARCHAR(20) NOT NULL,"
				+ "Street VARCHAR(20) NOT NULL," + "HousNr VARCHAR(20) NOT NULL," + "FlatNr VARCHAR(20) NOT NULL,"
				+ "LanguageLvl VARCHAR(20) NOT NULL," + "Experience VARCHAR(20) NOT NULL,"
				+ "Physical_Work VARCHAR(20) NOT NULL," + "Married VARCHAR(20) NOT NULL,"
				+ "Availability VARCHAR(20) NOT NULL" + ")";
		try {

			stm = conn.createStatement();
			stm.execute(createEmployeeT);
			stm.close();

		} catch (SQLException e) {
			System.out.println("(WorkOfficeDAO) Problem with created tables Employee");
			JOptionPane.showMessageDialog(null, e.toString());
			printSQLException(e);
		}

	}

	// Insert data to Employee table into Database.

	public void insertDataEmployee(EmployeeModel em) {
		try {

			PreparedStatement prst = conn.prepareStatement(
					"insert into EMPLOYEE(" + "Name,Surname,Birth_Date,Phone,City,Post_Code,Street,HousNr,FlatNr,"
							+ "LanguageLvl,Experience,Physical_Work,Married,Availability) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			prst.setString(1, em.getName());
			prst.setString(2, em.getSurname());
			prst.setString(3, em.getBirthdate());
			prst.setString(4, em.getPhone());
			prst.setString(5, em.getCity());
			prst.setString(6, em.getPostcode());
			prst.setString(7, em.getStreet());
			prst.setString(8, em.getNrhouse());
			prst.setString(9, em.getNrflat());
			prst.setString(10, em.getLanguage());
			prst.setString(11, em.getExperience());
			prst.setString(12, em.getPhysicalwork());
			prst.setString(13, em.getMarried());
			prst.setString(14, em.getAvailability());

			prst.execute();
			prst.close();

			System.out.print("(WorkOfficeDAO) EMPLOYEE data inserted");
			JOptionPane.showMessageDialog(null, "Employee added");

		} catch (SQLException e) {

			System.out.print("(WorkOfficeDAO) Problem with insert data to EMPLOYEE.");
			JOptionPane.showMessageDialog(null, e.toString());
			printSQLException(e);
		}
	}

	// Loading data from Database to Employee Model.

	public ArrayList<EmployeeModel> getEmployeeListList() {

		ArrayList<EmployeeModel> employeeList = new ArrayList<>();
		String sqlList = "select * FROM EMPLOYEE";
		ResultSet res;
		try {

			stm = conn.createStatement();
			res = stm.executeQuery(sqlList);
			EmployeeModel person;

			while (res.next()) {

				person = new EmployeeModel(res.getInt("id"), res.getString("Name"), res.getString("Surname"),
						res.getString("Birth_Date"), res.getString("Phone"), res.getString("City"),
						res.getString("Post_Code"), res.getString("Street"), res.getString("HousNr"),
						res.getString("FlatNr"), res.getString("LanguageLvl"), res.getString("Experience"),
						res.getString("Physical_Work"), res.getString("Married"), res.getString("Availability"));

				employeeList.add(person);
			}

			stm.close();
			conn.close();
			res.close();

			System.out.println("(WorkOfficeDAO) DB loaded to Employee List");
		}

		catch (SQLException e) {

			e.printStackTrace();
			System.out.println("(WorkOfficeDAO) Problem with loaded List employee");
		}
		return employeeList;

	}

	// Update data to DataBase
	public void updateEmployeeData(EmployeeModel emp, int id) {

		try {

			PreparedStatement prst = conn
					.prepareStatement("UPDATE EMPLOYEE SET " + "Name=?,Surname=?,Birth_Date=?,Phone=?,City=?,"
							+ "Post_Code=?,Street=?,HousNr=?,FlatNr=?,LanguageLvl=?,"
							+ "Experience=?,Physical_Work=?,Married=?,Availability=? " + "WHERE id=?");

			prst.setString(1, emp.getName());
			prst.setString(2, emp.getSurname());
			prst.setString(3, emp.getBirthdate());
			prst.setString(4, emp.getPhone());
			prst.setString(5, emp.getCity());
			prst.setString(6, emp.getPostcode());
			prst.setString(7, emp.getStreet());
			prst.setString(8, emp.getNrhouse());
			prst.setString(9, emp.getNrflat());
			prst.setString(10, emp.getLanguage());
			prst.setString(11, emp.getExperience());
			prst.setString(12, emp.getPhysicalwork());
			prst.setString(13, emp.getMarried());
			prst.setString(14, emp.getAvailability());
			prst.setInt(15, id);

			prst.executeUpdate();
			prst.close();

			JOptionPane.showMessageDialog(null, "EMPLOYEE Data updated");

		} catch (SQLException e) {
			System.out.println("(WorkOfficeDAO) Error updateData EMPLOYEE");
			printSQLException(e);
		}
	}

	// Method to print table.

	public void showEmployeeTable() {
		String sqlSelect = "select * from EMPLOYEE";

		try {
			stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sqlSelect);
			ResultSetMetaData rsmd = res.getMetaData();
			int columnCount = rsmd.getColumnCount();
			System.out.println("");
			for (int i = 1; i <= columnCount; i++) {
				System.out.format("%20s", rsmd.getColumnName(i) + "|");
			}
			System.out.println("");

			while (res.next()) {
				for (int i = 1; i <= columnCount; i++) {
					System.out.format("%20s", res.getString(i) + "|");
				}
				System.out.println("");
			}
			res.close();
			conn.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	// Delete Employee from DataBase

	public void deleteEmployeeData(int id) {
		try {

			PreparedStatement prst = conn.prepareStatement("DELETE FROM EMPLOYEE WHERE id=?");
			prst.setInt(1, id);
			prst.executeUpdate();
			prst.close();

			JOptionPane.showMessageDialog(null, "Data deleted");

		} catch (SQLException e) {
			printSQLException(e);
		}

	}

	// =================================================LINK METHODS=========================================================

	// Method to check if Link tables exist;
	public void ifLinkTablesExist() {
		try {

			DatabaseMetaData dbmd = conn.getMetaData();
			ResultSet res = dbmd.getTables(null, null, "LINK", null);

			if (res.next()) {
				System.out.println("(WorkOfficeDAO) LINK tables exists");

			} else {
				createLinkTables();
				System.out.println("(WorkOfficeDAO) LINK Tables has been created");
			}

			res.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
			printSQLException(e);
		}

	}

	// Method to creating Link Table into Database;

	public void createLinkTables() {

		String createFamiliesT = "create table LINK("
				+ "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
				+ "EmpID VARCHAR(20) NOT NULL," + "EmpName VARCHAR(20) NOT NULL," + "EmpSurname VARCHAR(20) NOT NULL,"
				+ "FamID VARCHAR(20) NOT NULL," + "FamName VARCHAR(20) NOT NULL," + "FamSurname VARCHAR(20) NOT NULL,"
				+ "From_Date VARCHAR(20) NOT NULL," + "To_Date VARCHAR(20) NOT NULL" + ")";

		try {

			stm = conn.createStatement();
			stm.execute(createFamiliesT);
			stm.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.toString());
			printSQLException(e);
		}

	}

	// Insert data into LINK Database.

	public boolean insertLinkData(int eId, String eName, String eSurname, int fId, String fName, String fSurname,
			String dataFrom, String dataTo) {

		try {

			PreparedStatement prst = conn.prepareStatement(
					"insert into LINK(" + "EmpID,EmpName,EmpSurname,FamID,FamName,FamSurname,From_Date,To_Date)"
							+ "values(?,?,?,?,?,?,?,?)");

			prst.setInt(1, eId);
			prst.setString(2, eName);
			prst.setString(3, eSurname);
			prst.setInt(4, fId);
			prst.setString(5, fName);
			prst.setString(6, fSurname);
			prst.setString(7, dataFrom);
			prst.setString(8, dataTo);
			prst.execute();
			prst.close();

			System.out.print("(WorkOfficeDAO) Link data inserted");
			return true;
		} catch (SQLException e) {
			System.out.print("(WorkOfficeDAO) Problem with insert data to Link.");
			JOptionPane.showMessageDialog(null, e.toString());
			printSQLException(e);
			return false;
		}
	}

	public void extendDateTo(int id, String date) {
		try {

			PreparedStatement prst = conn.prepareStatement("UPDATE LINK SET To_Date=? WHERE id=?");
			prst.setString(1, date);
			prst.setInt(2, id);
			prst.executeUpdate();
			prst.close();
			System.out.println("(WorkOfficeDAO) Date_To updated.");

		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	// Delete LinkData from DataBase

	public void deleteLinkData(int id) {
		try {

			PreparedStatement prst = conn.prepareStatement("DELETE FROM LINK WHERE id=?");
			prst.setInt(1, id);
			prst.executeUpdate();
			prst.close();
			System.out.println("(WorkOfficeDAO) Data deleted from LINK");

		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	// Loading data from Database to Employee Model.

	public ArrayList<LinkModel> getLinkList() {

		ArrayList<LinkModel> linkList = new ArrayList<>();
		String sqlList = "select * FROM LINK";
		try {

			ResultSet res;
			stm = conn.createStatement();
			res = stm.executeQuery(sqlList);
			LinkModel row;

			while (res.next()) {

				row = new LinkModel(res.getInt("id"), res.getString("EmpID"), res.getString("EmpName"),
						res.getString("EmpSurname"), res.getString("FamID"), res.getString("FamName"),
						res.getString("FamSurname"), res.getString("From_Date"), res.getString("To_Date"));

				linkList.add(row);
			}

			stm.close();
			res.close();

			System.out.println("(WorkOfficeDAO) DB loaded to Link List");
		}

		catch (SQLException e) {

			e.printStackTrace();
			System.out.println("(WorkOfficeDAO) Problem with loaded List Link");
		}
		return linkList;

	}

	// Method to print table.

	public void showLinkTable() {
		String sqlSelect = "select * from LINK";

		try {
			stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sqlSelect);
			ResultSetMetaData rsmd = res.getMetaData();
			int columnCount = rsmd.getColumnCount();
			System.out.println("");
			for (int i = 1; i <= columnCount; i++) {
				System.out.format("%20s", rsmd.getColumnName(i) + "|");
			}
			System.out.println("");

			while (res.next()) {
				for (int i = 1; i <= columnCount; i++) {
					System.out.format("%20s", res.getString(i) + "|");
				}
				System.out.println("");
			}
			res.close();
			conn.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	// =============================================================================================================================================================================
	// Method to close connection
	public void closeConnection() {
		try {
			DriverManager.getConnection("jdbc:derby:;shutdown=true");

		} catch (SQLException e) {
			if (((e.getErrorCode() == 50000) && ("XJ015".equals(e.getSQLState())))) {
				System.out.println("(WorkOfficeDAO) Derby shut down normally");
			} else {
				printSQLException(e);
				System.err.println("(WorkOfficeDAO) Derby did not shut down normally");

			}
		}

	}

	// Print SQL exception
	private static void printSQLException(SQLException e) {

		while (e != null) {
			System.err.println("\n----- SQLException -----");
			System.err.println("  SQL State:  " + e.getSQLState());
			System.err.println("  Error Code: " + e.getErrorCode());
			System.err.println("  Message:    " + e.getMessage());
			e = e.getNextException();
		}
	}

}
