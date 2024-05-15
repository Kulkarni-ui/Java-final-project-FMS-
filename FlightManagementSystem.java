import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FlightManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PassengerManager passengerManager = new PassengerManager();
        Flight flight = null;
        Passenger passenger = null;

        while (true) {
            System.out.println("Flight Management System");
            System.out.println("1. Add Booking");
            System.out.println("2. Cancel Booking");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (flight == null) {
                        flight = enterFlightDetails(scanner);
                    }
                    if (passenger == null) {
                        passenger = enterPassengerDetails(scanner);
                    }
                    passengerManager.bookFlight(flight, passenger);
                    break;
                case 2:
                    if (flight == null || passenger == null) {
                        System.out.println("Please enter flight and passenger details first.");
                    } else {
                        passengerManager.cancelBooking(flight, passenger);
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static Flight enterFlightDetails(Scanner scanner) {
    	Flight flight = new Flight();
        System.out.println("Enter flight details:");
        System.out.print("Flight Number: ");
        flight.setFlightNumber(scanner.next());
        System.out.print("Departure Airport: ");
        flight.setDepartureAirport(scanner.next());
        System.out.print("Destination Airport: ");
        flight.setDestinationAirport(scanner.next());
        System.out.println("Departure Time:");
        int year = readInt(scanner, "Year: ");
        int month = readInt(scanner, "Month (1-12): ", 1, 12);
        int day = readInt(scanner, "Day (1-31): ", 1, 31);
        int hour = readInt(scanner, "Hour (0-23): ", 0, 23);
        int minute = readInt(scanner, "Minute (0-59): ", 0, 59);
        flight.setDepartureTime(createDate(year, month, day, hour, minute));

        System.out.println("Arrival Time:");
        year = readInt(scanner, "Year: ");
        month = readInt(scanner, "Month (1-12): ", 1, 12);
        day = readInt(scanner, "Day (1-31): ", 1, 31);
        hour = readInt(scanner, "Hour (0-23): ", 0, 23);
        minute = readInt(scanner, "Minute (0-59): ", 0, 59);
        flight.setArrivalTime(createDate(year, month, day, hour, minute));
        System.out.print("Available Seats: ");
        flight.setAvailableSeats(scanner.nextInt());
        return flight;
    }
    private static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter an integer: ");
            scanner.next(); // Consume invalid input
        }
        return scanner.nextInt();
    }

    private static int readInt(Scanner scanner, String prompt, int min, int max) {
        int value;
        do {
            value = readInt(scanner, prompt);
            if (value < min || value > max) {
                System.out.println("Invalid input. Please enter a value between " + min + " and " + max + ".");
            }
        } while (value < min || value > max);
        return value;
    }

    private static Date createDate(int year, int month, int day, int hour, int minute) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String dateString = String.format("%04d-%02d-%02d %02d:%02d", year, month, day, hour, minute);
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Error creating date.");
            return null;
        }
    }

    private static Passenger enterPassengerDetails(Scanner scanner) {
    	Passenger passenger = new Passenger();
        System.out.println("Enter passenger details:");
        System.out.print("Passenger Name: ");
        passenger.setName(scanner.next());
        System.out.print("Passport Number: ");
        passenger.setPassportNumber(scanner.next());
        return passenger;
    }
}
