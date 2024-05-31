
public class Ticket  {
    private Passenger passenger;
    private Trip trip;
    private double price;


    public Ticket(Passenger passenger, Trip trip) {
        this.passenger = passenger;
        this.trip = trip;
        if(trip.isOneWay()){
            this.price=trip.getPrice();
        }else this.price=trip.getPrice()*2;

    }


    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                ", trip=" + trip +
                ", price=" + price +
                '}';
    }
}