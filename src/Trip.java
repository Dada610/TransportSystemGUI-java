import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Trip implements Serializable {
    private String type;
    private double price;
    private String source;
    private String destination;
    private boolean oneWay;
    private int numStops;
    private int availableSeats;
    private Driver driver;



    public Trip(String type, double price, String source, String destination, boolean oneWay, int numStops, int availableSeats) {
        this.type = type;
        this.price = price;
        this.source = source;
        this.destination = destination;
        this.oneWay = oneWay;
        this.numStops = numStops;
        this.availableSeats = availableSeats;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isOneWay() {
        return oneWay;
    }

    public void setOneWay(boolean oneWay) {
        this.oneWay = oneWay;
    }

    public int getNumStops() {
        return numStops;
    }

    public void setNumStops(int numStops) {
        this.numStops = numStops;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", oneWay=" + oneWay +
                ", numStops=" + numStops +
                ", availableSeats=" + availableSeats +
                '}';
    }

    public static void saveToFile(List<Trip> trips) {
        File file = new File("src/trips.txt");
        try {
            file.delete();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(trips);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static List loadFromFile(List<Trip> trips) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/trips.txt"))) {
            trips = (ArrayList<Trip>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {

        }
        return trips;
    }
}