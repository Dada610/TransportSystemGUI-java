import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Manager class
public class Manager extends Employee implements Serializable {
    public Manager(String username, String password, String name) {
        super(username, password, name, "Manager");
    }

    public void reviewTrips(List<Trip> trips) {
        System.out.println("Reviewing trips:");
        for (Trip trip : trips) {
            System.out.println(trip);
        }
    }

    public void addTrip(Trip trip, List<Trip> trips) {
        trips.add(trip);
        System.out.println("Trip added: " + trip);
    }

    public void removeTrip(Trip trip, List<Trip> trips) {
        if (trips.remove(trip)) {
            System.out.println("Trip removed: " + trip);
        } else {
            System.out.println("Trip not found: " + trip);
        }
    }

    public void assignDriver(Driver driver, Trip trip) {
        trip.setDriver(driver);
        System.out.println("Driver assigned to trip: " + driver.getName() + " to " + trip.getSource() + " - " + trip.getDestination());
    }
    public static void saveToFile(List<Manager> managers) {
        File file = new File("src/mangers.txt");
        try {
            file.delete();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(managers);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static List loadFromFile(List<Manager> managers) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/mangers.txt"))) {
            managers = (ArrayList<Manager>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {

        }
        return managers;
    }



}
