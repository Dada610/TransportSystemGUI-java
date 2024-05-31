import java.io.Serializable;
import java.util.List;


public abstract class Employee extends User implements Serializable {


    private String type;

    public Employee(String username, String password, String name, String type) {
        super(username, password,name);

        this.type = type;
    }



    public void manageTrip(Trip trip,Trip newTrip, List<Trip> tripList,String option) {
        if (tripList.contains(trip)) {
            System.out.println("Trip details:");
            System.out.println(trip);
            option=option.toLowerCase();
            switch (option) {
                case "edit":
                    // Call a method to edit trip details
                    editTripDetails(trip, newTrip);
                    break;
                case "cancel":
                    // Call a method to cancel the trip
                    cancelTrip(trip, tripList);
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } else {
            System.out.println("Trip not found.");
        }
    }

    private void editTripDetails(Trip trip,Trip newTrip) {
        trip=newTrip;
    }




    public void addVehicle(Vehicle vehicle, List<Vehicle> vehicles) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added: " + vehicle);
    }

    public void addEmployee(Employee employee, List<Employee> employees) {
        employees.add(employee);
        System.out.println("Employee added: " + employee);
    }

    public void generateReport(List<Trip> trips, List<Employee> employees, List<Vehicle> vehicles) {
        System.out.println("Report:");
        System.out.println("Trips:");
        for (Trip trip : trips) {
            System.out.println(trip);
        }

        System.out.println("Employees:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("Vehicles:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }


    }

    private void cancelTrip(Trip trip, List<Trip> tripList) {
        // Remove the trip from the list
        tripList.remove(trip);
        System.out.println("Trip canceled: " + trip);
    }




    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
