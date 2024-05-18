import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establishing connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FMS", "root", "Jaya1234!");
            System.out.println("Connected with the database successfully");

            // Inserting data
            String insertQuery = "INSERT INTO FlightManagementSystem (RegID, Airline, DepAirport, DesAirport, TimeDur) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, "abc001");
            preparedStatement.setString(2, "AIR");
            preparedStatement.setString(3, "BOM");
            preparedStatement.setString(4, "PNQ");
            preparedStatement.setString(5, "3000");
            preparedStatement.executeUpdate();
            System.out.println("Data inserted successfully");

            // Selecting data
            String selectQuery = "SELECT * FROM FlightManagementSystem";
            preparedStatement = connection.prepareStatement(selectQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String regID = resultSet.getString("RegID");
                String airline = resultSet.getString("Airline");
                String dep = resultSet.getString("DepAirport");
                String des = resultSet.getString("DesAirport");
                String dur = resultSet.getString("TimeDur");
                System.out.println(regID + " " + airline + " " + dep + " " + des + " " + dur);
            }

            // Updating data
            String updateQuery = "UPDATE FlightManagementSystem SET RegID=? WHERE RegID=?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, "abc002");
            preparedStatement.setString(2, "abc001"); // Update the record where RegID is abc001
            preparedStatement.executeUpdate();
            System.out.println("Data updated successfully");

        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        } finally {
            // Closing resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error while closing resources: " + e.getMessage());
            }
        }
    }
}
