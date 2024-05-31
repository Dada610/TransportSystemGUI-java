import java.io.Serializable;


public class Vehicle implements Serializable {
    private String type;
    private int capacity;
    private String licensePlate;

    public Vehicle(String type, int capacity, String licensePlate) {
        this.type = type;
        this.capacity = capacity;
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void displayInfo() {
        System.out.println("Type: " + type);
        System.out.println("Capacity: " + capacity);
        System.out.println("License Plate: " + licensePlate);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", capacity=" + capacity +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
}
