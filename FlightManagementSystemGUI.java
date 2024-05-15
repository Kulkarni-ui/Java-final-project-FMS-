import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FlightManagementSystemGUI extends JFrame implements ActionListener {
    private JTextField flightNumberField, departureAirportField, destinationAirportField,
            departureYearField, departureMonthField, departureDayField, departureHourField, departureMinuteField,
            arrivalYearField, arrivalMonthField, arrivalDayField, arrivalHourField, arrivalMinuteField,
            availableSeatsField, passengerNameField, passportNumberField;

    private JButton addBookingButton, cancelButton, exitButton;

    private PassengerManager passengerManager;
    private Connection connection; 
    public FlightManagementSystemGUI() {
        setTitle("Flight Management System");
        setSize(463, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //getContentPane().setLayout(null);
        getContentPane().setLayout(null);
        setDefaultLookAndFeelDecorated(true);
        JLabel flightNumberLabel = new JLabel("Flight Number:");
        flightNumberLabel.setBounds(20, 20, 120, 25);
        getContentPane().add(flightNumberLabel);
        //getContentPane().add(flightNumberLabel);

        flightNumberField = new JTextField();
        flightNumberField.setBounds(150, 20, 200, 25);
        getContentPane().add(flightNumberField);
        //getContentPane().add(flightNumberField);

        JLabel departureAirportLabel = new JLabel("Departure Airport:");
        departureAirportLabel.setBounds(20, 50, 120, 25);
        getContentPane().add(departureAirportLabel);
        //getContentPane().add(departureAirportLabel);

        departureAirportField = new JTextField();
        departureAirportField.setBounds(150, 50, 200, 25);
        getContentPane().add(departureAirportField);
        //getContentPane().add(departureAirportField);

        JLabel destinationAirportLabel = new JLabel("Destination Airport:");
        destinationAirportLabel.setBounds(20, 80, 120, 25);
        getContentPane().add(destinationAirportLabel);
        //getContentPane().add(destinationAirportLabel);

        destinationAirportField = new JTextField();
        destinationAirportField.setBounds(150, 80, 200, 25);
        getContentPane().add(destinationAirportField);
        //getContentPane().add(destinationAirportField);

        JLabel departureTimeLabel = new JLabel("Departure Time:");
        departureTimeLabel.setBounds(20, 110, 120, 25);
        getContentPane().add(departureTimeLabel);
        //getContentPane().add(departureTimeLabel);

        departureYearField = new JTextField();
        departureYearField.setBounds(150, 110, 60, 25);
        getContentPane().add(departureYearField);
        //getContentPane().add(departureYearField);

        departureMonthField = new JTextField();
        departureMonthField.setBounds(220, 110, 40, 25);
        getContentPane().add(departureMonthField);
        //getContentPane().add(departureMonthField);

        departureDayField = new JTextField();
        departureDayField.setBounds(270, 110, 40, 25);
        getContentPane().add(departureDayField);
        //getContentPane().add(departureDayField);

        departureHourField = new JTextField();
        departureHourField.setBounds(320, 110, 40, 25);
        getContentPane().add(departureHourField);
        //getContentPane().add(departureHourField);

        departureMinuteField = new JTextField();
        departureMinuteField.setBounds(370, 110, 40, 25);
        getContentPane().add(departureMinuteField);
        //getContentPane().add(departureMinuteField);

        JLabel arrivalTimeLabel = new JLabel("Arrival Time:");
        arrivalTimeLabel.setBounds(20, 140, 120, 25);
        getContentPane().add(arrivalTimeLabel);
        //getContentPane().add(arrivalTimeLabel);

        arrivalYearField = new JTextField();
        arrivalYearField.setBounds(150, 140, 60, 25);
        getContentPane().add(arrivalYearField);
        //getContentPane().add(arrivalYearField);

        arrivalMonthField = new JTextField();
        arrivalMonthField.setBounds(220, 140, 40, 25);
        getContentPane().add(arrivalMonthField);
        //getContentPane().add(arrivalMonthField);

        arrivalDayField = new JTextField();
        arrivalDayField.setBounds(270, 140, 40, 25);
        getContentPane().add(arrivalDayField);
        //getContentPane().add(arrivalDayField);

        arrivalHourField = new JTextField();
        arrivalHourField.setBounds(320, 140, 40, 25);
        getContentPane().add(arrivalHourField);
        //getContentPane().add(arrivalHourField);

        arrivalMinuteField = new JTextField();
        arrivalMinuteField.setBounds(370, 140, 40, 25);
        getContentPane().add(arrivalMinuteField);
        //getContentPane().add(arrivalMinuteField);

        JLabel availableSeatsLabel = new JLabel("Available Seats:");
        availableSeatsLabel.setBounds(20, 170, 120, 25);
        getContentPane().add(availableSeatsLabel);
        //getContentPane().add(availableSeatsLabel);

        availableSeatsField = new JTextField();
        availableSeatsField.setBounds(150, 170, 200, 25);
        getContentPane().add(availableSeatsField);
        //getContentPane().add(availableSeatsField);

        JLabel passengerNameLabel = new JLabel("Passenger Name:");
        passengerNameLabel.setBounds(20, 200, 120, 25);
        getContentPane().add(passengerNameLabel);
        //getContentPane().add(passengerNameLabel);

        passengerNameField = new JTextField();
        passengerNameField.setBounds(150, 200, 200, 25);
        getContentPane().add(passengerNameField);
        //getContentPane().add(passengerNameField);

        JLabel passportNumberLabel = new JLabel("Passport Number:");
        passportNumberLabel.setBounds(20, 230, 120, 25);
        getContentPane().add(passportNumberLabel);
        //getContentPane().add(passportNumberLabel);

        passportNumberField = new JTextField();
        passportNumberField.setBounds(150, 230, 200, 25);
        getContentPane().add(passportNumberField);
        //getContentPane().add(passportNumberField);

        addBookingButton = new JButton("Add Booking");
        addBookingButton.setBounds(20, 280, 120, 25);
        getContentPane().add(addBookingButton);
        //getContentPane().add(addBookingButton);
        addBookingButton.addActionListener(this);

        cancelButton = new JButton("Cancel Booking");
        cancelButton.setBounds(150, 280, 120, 25);
        getContentPane().add(cancelButton);
        //getContentPane().add(cancelButton);
        cancelButton.addActionListener(this);

        exitButton = new JButton("Exit");
        exitButton.setBounds(280, 280, 80, 25);
        getContentPane().add(exitButton);
        //getContentPane().add(exitButton);
        exitButton.addActionListener(this);

        // Initialize PassengerManager
        passengerManager = new PassengerManager();
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FMS", "root", "Jaya1234!");
            System.out.println("Connected to the database successfully");
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBookingButton) {
            // Retrieve flight details from GUI fields
            Flight flight = new Flight();
            flight.setFlightNumber(flightNumberField.getText());
            flight.setDepartureAirport(departureAirportField.getText());
            flight.setDestinationAirport(destinationAirportField.getText());
            flight.setAvailableSeats(Integer.parseInt(availableSeatsField.getText()));

            // Retrieve departure time from GUI fields
            int departureYear = Integer.parseInt(departureYearField.getText());
            int departureMonth = Integer.parseInt(departureMonthField.getText());
            int departureDay = Integer.parseInt(departureDayField.getText());
            int departureHour = Integer.parseInt(departureHourField.getText());
            int departureMinute = Integer.parseInt(departureMinuteField.getText());
            Date departureTime = createDate(departureYear, departureMonth, departureDay, departureHour, departureMinute);
            flight.setDepartureTime(departureTime);

            // Retrieve arrival time from GUI fields
            int arrivalYear = Integer.parseInt(arrivalYearField.getText());
            int arrivalMonth = Integer.parseInt(arrivalMonthField.getText());
            int arrivalDay = Integer.parseInt(arrivalDayField.getText());
            int arrivalHour = Integer.parseInt(arrivalHourField.getText());
            int arrivalMinute = Integer.parseInt(arrivalMinuteField.getText());
            Date arrivalTime = createDate(arrivalYear, arrivalMonth, arrivalDay, arrivalHour, arrivalMinute);
            flight.setArrivalTime(arrivalTime);

            // Retrieve passenger details from GUI fields
            Passenger passenger = new Passenger();
            passenger.setName(passengerNameField.getText());
            passenger.setPassportNumber(passportNumberField.getText());

            // Create a new Booking object
            Booking booking = new Booking(flight, passenger);
            
            // Call bookFlight method of PassengerManager
            passengerManager.bookFlight(flight, passenger);
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO FlightManagementSystem VALUES(?,?,?,?,?)");
                preparedStatement.setString(1, flightNumberField.getText());
                preparedStatement.setString(2, departureAirportField.getText());
                preparedStatement.setString(3, destinationAirportField.getText());
                preparedStatement.setString(4, availableSeatsField.getText());
                preparedStatement.setString(5, ""); // Assuming you have a column for passenger name
                preparedStatement.executeUpdate();
                System.out.println("Booking added successfully");
            } catch (SQLException ex) {
                System.out.println("Error while adding booking: " + ex.getMessage());
            }
        } else if (e.getSource() == cancelButton) {
            // Retrieve flight and passenger details from GUI fields
            Flight flight = new Flight();
            flight.setFlightNumber(flightNumberField.getText());
            // Set other flight details similarly...

            Passenger passenger = new Passenger();
            passenger.setName(passengerNameField.getText());
            passenger.setPassportNumber(passportNumberField.getText());

            // Call cancelBooking method of PassengerManager
            passengerManager.cancelBooking(flight, passenger);
            try {
                PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM FlightManagementSystem WHERE FlightNumber = ?");
                preparedStatement.setString(1, flightNumberField.getText());
                preparedStatement.executeUpdate();
                System.out.println("Booking cancelled successfully");
            } catch (SQLException ex) {
                System.out.println("Error while cancelling booking: " + ex.getMessage());
            }
        } else if (e.getSource() == exitButton) {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }

    private Date createDate(int year, int month, int day, int hour, int minute) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String dateString = String.format("%04d-%02d-%02d %02d:%02d", year, month, day, hour, minute);
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        new FlightManagementSystemGUI();
    }
}
