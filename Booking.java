import java.util.Objects;

public class Booking {
    private Flight flight;
    private Passenger passenger;

    public Booking(Flight flight, Passenger passenger) {
        this.flight = flight;
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(flight, booking.flight) &&
                Objects.equals(passenger, booking.passenger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flight, passenger);
    }
}

