package de.telekom.jdbcchallenge;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
import java.sql.*;


public class Main {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Class.forName("org.mariadb.jdbc.Driver");
		try {

			Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/seadb","seauser","seapass");

//		   Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/seadb?user=seauser&password=seapass");
		   Statement statement = connection.createStatement();

//		   statement.executeQuery("insert into personen (ID, ANREDE, VORNAME, NACHNAME) VALUE (3,1,'Karl','Napp')");
		   
		   String insertSQL = "insert into personen (ID, ANREDE, VORNAME, NACHNAME) VALUE (?,?,?,?)";
		   PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
		   preparedStatement.setLong(1, 99);
		   preparedStatement.setInt(2, 1);
		   preparedStatement.setString(3, "Joachim");
		   preparedStatement.setString(4, "Hansen");
		   preparedStatement.execute();
		   
//		   statement.executeQuery("UPDATE personen SET Vorname='Hans' WHERE ID='1'");
		   
		   ResultSet resultSet = statement.executeQuery("select * from personen");
  
		   
		   while (resultSet.next()){
		      System.out.println(resultSet.getString(1));
		      System.out.println(resultSet.getString(2));
		      System.out.println(resultSet.getString(3));
		      System.out.println(resultSet.getString(4));		      
		   }
            
		   resultSet.close();
		   statement.close();
		   connection.close();

		}  catch (Exception e) {e.printStackTrace();}
		finally {}
	}

}
