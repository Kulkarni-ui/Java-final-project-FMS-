import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class Database {
 
public static void main(String[] args) {
   try {
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FMS", "root", "Jaya1234!");//Establishing connection
System.out.println("Connected With the database successfully");
//Creating PreparedStatement object
PreparedStatement preparedStatement=connection.prepareStatement("insert into FlightManagementSystem values(?,?,?,?,?)");
//Setting values for Each Parameter
preparedStatement.setString(1,"abc001");
       preparedStatement.setString(2,"AIR");
       preparedStatement.setString(3, "BOM");
       preparedStatement.setString(4, "PNQ");
       preparedStatement.setString(5, "3000");
       //Executing Query
       //preparedStatement.executeUpdate();
       //System.out.println("data inserted successfully");
     //Using SQL SELECT Query
       //PreparedStatement preparedStatement=connection.prepareStatement("select * from FlightManagementSystem");
       //Creating Java ResultSet object
       //ResultSet resultSet=preparedStatement.executeQuery();
       //while(resultSet.next()){
            //String RegID=resultSet.getString("RegID");
            //String Airline=resultSet.getString("Airline");
            //String Dep=resultSet.getString("DepAirport");
            //String Des=resultSet.getString("DesAirport");
            //String Dur=resultSet.getString("TimeDur");
            //Printing Results
            //System.out.println(RegID+" "+Airline+" "+Dep+" "+Des+" "+Dur);
//Using SQL UPDATE query to update data in the table
//PreparedStatement preparedStatement=connection.prepareStatement("update FlightManagementSystem set RegID=?");
//preparedStatement.setString(1,"abc002");

//preparedStatement.executeUpdate();
//System.out.println("data updated successfully"); 
 
} catch (SQLException e) {
System.out.println("Error while connecting to the database"+e.getMessage());
}

 
}}
