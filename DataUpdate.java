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
