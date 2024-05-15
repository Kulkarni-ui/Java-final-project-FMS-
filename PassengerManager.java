import java.util.ArrayList;
import java.util.List;

public class PassengerManager {
    private List<Booking> bookings;

    public PassengerManager() {
        bookings = new ArrayList<>();
    }

    public void bookFlight(Flight flight, Passenger passenger) {
        if (flight.getAvailableSeats() > 0) {
            flight.setAvailableSeats(flight.getAvailableSeats() - 1);
            Booking booking = new Booking(flight, passenger);
            bookings.add(booking);
            System.out.println("Booking successful!");
        } else {
            System.out.println("No available seats on the flight.");
        }
    }

    public void cancelBooking(Flight flight, Passenger passenger) {
        Booking bookingToRemove = null;
        for (Booking booking : bookings) {
            if (booking.getFlight().equals(flight) && booking.getPassenger().equals(passenger)) {
                bookingToRemove = booking;
                break;
            }
        }
        if (bookingToRemove != null) {
            bookings.remove(bookingToRemove);
            flight.setAvailableSeats(flight.getAvailableSeats() + 1);
            System.out.println("Booking cancelled successfully.");
        } else {
            System.out.println("No booking found for the given flight and passenger.");
        }
    }
}

