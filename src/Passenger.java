import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Passenger extends User implements Serializable {




    private List<Ticket> tickets;

    public Passenger(String username, String password, String name) {
        super(username, password,name);
        tickets=new ArrayList<>();


    }


    public Ticket bookTicket(Trip trip) {
        Ticket ticket = new Ticket( this,trip);
        tickets.add(ticket);
        return ticket;
    }

    public void cancelTicket(Ticket ticket) {
        if (tickets.contains(ticket)) {
            tickets.remove(ticket);
            System.out.println("Ticket canceled: " + ticket);
        } else {
            System.out.println("Ticket not found: " + ticket);
        }
    }

    public String displayProfile() {
        String s="Passenger Profile:\n"
        +"Name: " + getName()
        +"\nNumber of Tickets Booked: " + tickets.size();
        return s;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public static List loadFromFile(List<Passenger> passengers) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/passengers.txt"))) {
            passengers = (ArrayList<Passenger>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {

        }
        return passengers;
    }

    public static void saveToFile(List<Passenger> passengers) {
        File file = new File("src/passengers.txt");
        try {
            file.delete();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(passengers);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + getName() + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}
