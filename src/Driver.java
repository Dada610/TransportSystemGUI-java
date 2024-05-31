import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Driver class
public class Driver extends Employee implements Serializable {
    List<Trip> AssignedTrips=new ArrayList<>();
    public Driver(String username, String password, String name) {
        super(username, password, name, "Driver");
    }


    public void viewBasicInfo() {
        System.out.println("Name: " + this.getName());
        System.out.println("Type: " + getType());
    }
    public void AssignedTrip(Trip trip) {
        AssignedTrips.add(trip);
    }
    public void viewAssignedTrips() {
        System.out.println("Assigned trips:");
        for (Trip trip : AssignedTrips) {
            System.out.println(trip);
        }
    }
    public static void saveToFile(List<Driver> drivers) {
        File file = new File("src/drivers.txt");
        try {
            file.delete();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(drivers);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static List loadFromFile(List<Driver> drivers) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/drivers.txt"))) {
            drivers = (ArrayList<Driver>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {

        }
        return drivers;
    }


}
