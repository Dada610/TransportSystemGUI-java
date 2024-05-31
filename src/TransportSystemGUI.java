import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import static java.lang.Integer.parseInt;

public class TransportSystemGUI {
    private final JFrame frame;
    private JPanel loginPanel;
    private JPanel signupPanel;
    private JPanel passengerPanel;
    private JPanel managerPanel;
    private JPanel driverPanel;
    private static java.util.List<Passenger> passengers = new ArrayList<>();
    private static java.util.List<Manager> managers = new ArrayList<>();
    private static List<Driver> drivers = new ArrayList<>();
    private static List<Trip> trips = new ArrayList<>();

    public TransportSystemGUI() {
        frame = new JFrame("Transport System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        createLoginPanel();
        createSignupPanel();
        switchToPanel(loginPanel);

        frame.setVisible(true);
    }

    private void switchToPanel(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.add(panel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private void createLoginPanel() {
        loginPanel = new JPanel(new BorderLayout());

        JLabel nameLabel = new JLabel("Name:");
        JTextField NameField = new JTextField(20);
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);
        JLabel accountTypeLabel = new JLabel("Account Type:");
        String[] accountTypes = {"Passenger", "Manager", "Driver"};
        JComboBox<String> accountTypeComboBox = new JComboBox<>(accountTypes);
        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Sign Up");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String name=usernameField.getText();
                String accountType = (String) accountTypeComboBox.getSelectedItem();

                switch (accountType) {
                    case "Passenger" -> {
                        boolean b=true;
                        passengers=Passenger.loadFromFile(passengers);
                        for (Passenger p:passengers){
                        if (p.getName().equals(name)& p.getUsername().equals(username) &p.getPassword().equals(password)) {
                            int i=passengers.indexOf(p);
                            createPassengerPanel(p,i);
                            switchToPanel(passengerPanel);
                            b=false;
                            break;
                        }
                        }if(b) JOptionPane.showMessageDialog(frame, "Wrong username or password" , "Can`t login", JOptionPane.INFORMATION_MESSAGE);
                    }
                    case "Manager" -> {
                        boolean b=true;
                        managers=Manager.loadFromFile(managers);
                        for (Manager m:managers){
                            if (m.getName().equals(name)& m.getUsername().equals(username) &m.getPassword().equals(password)) {
                                int i=managers.indexOf(m);
                                createManagerPanel();
                                switchToPanel(managerPanel);
                                b=false;
                                break;
                            }
                        }if(b) JOptionPane.showMessageDialog(frame, "Wrong username or password" , "Can`t login", JOptionPane.INFORMATION_MESSAGE);
                    }
                    case "Driver" -> {
                        boolean b=true;
                        drivers=Driver.loadFromFile(drivers);
                        for (Driver d:drivers){
                            if (d.getName().equals(name)& d.getUsername().equals(username) &d.getPassword().equals(password)) {
                                int i=drivers.indexOf(d);
                                createDriverPanel(d,i);
                                switchToPanel(driverPanel);
                                b=false;
                                break;
                            }
                        }if(b) JOptionPane.showMessageDialog(frame, "Wrong username or password" , "Can`t login", JOptionPane.INFORMATION_MESSAGE);
                    }
                    default -> {
                    }
                }


            }
        });
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToPanel(signupPanel);
            }
        });
        JPanel loginComponentsPanel = new JPanel(new GridLayout(5, 2));
        loginComponentsPanel.add(nameLabel);
        loginComponentsPanel.add(NameField);
        loginComponentsPanel.add(usernameLabel);
        loginComponentsPanel.add(usernameField);
        loginComponentsPanel.add(passwordLabel);
        loginComponentsPanel.add(passwordField);
        loginComponentsPanel.add(accountTypeLabel);
        loginComponentsPanel.add(accountTypeComboBox);
        loginComponentsPanel.add(loginButton);
        loginComponentsPanel.add(signupButton);

        loginPanel.add(new JLabel("Login", SwingConstants.CENTER), BorderLayout.NORTH);
        loginPanel.add(loginComponentsPanel, BorderLayout.CENTER);
    }


    private void createSignupPanel() {
        signupPanel = new JPanel(new BorderLayout());

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);
        JLabel accountTypeLabel = new JLabel("Account Type:");
        String[] accountTypes = {"Passenger", "Manager", "Driver"};
        JComboBox<String> accountTypeComboBox = new JComboBox<>(accountTypes);
        JButton signupSubmitButton = new JButton("Sign Up");

        signupSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String accountType = (String) accountTypeComboBox.getSelectedItem();
                switch (accountType) {
                    case "Passenger" -> {
                        Passenger p=new Passenger(username,password,name);
                        passengers.add(p);
                        Passenger.saveToFile(passengers);

                        }
                    case "Manager" -> {
                        Manager m=new Manager(username,password,name);
                        managers.add(m);
                        Manager.saveToFile(managers);

                    }
                    case "Driver" -> {
                        Driver d=new Driver(username,password,name);
                        drivers.add(d);
                        Driver.saveToFile(drivers);
                    }
                    default -> {
                    }
                }
                JOptionPane.showMessageDialog(frame, "Sign Up Successfully", "Sign Up", JOptionPane.INFORMATION_MESSAGE);
                switchToPanel(loginPanel);
            }
        });

        JPanel signupComponentsPanel = new JPanel(new GridLayout(5, 2));
        signupComponentsPanel.add(nameLabel);
        signupComponentsPanel.add(nameField);
        signupComponentsPanel.add(usernameLabel);
        signupComponentsPanel.add(usernameField);
        signupComponentsPanel.add(passwordLabel);
        signupComponentsPanel.add(passwordField);
        signupComponentsPanel.add(accountTypeLabel);
        signupComponentsPanel.add(accountTypeComboBox);
        signupComponentsPanel.add(signupSubmitButton);

        signupPanel.add(new JLabel("Sign Up", SwingConstants.CENTER), BorderLayout.NORTH);
        signupPanel.add(signupComponentsPanel, BorderLayout.CENTER);
    }
    private void createPassengerPanel(Passenger passenger,int i) {
        passengerPanel = new JPanel(new BorderLayout());
        trips=Trip.loadFromFile(trips);
        String[]trip=new String[trips.size()];
        for (int j = 0; j < trips.size(); j++) {
            trip[j]=(j+1)+" from "+trips.get(i).getSource()+" to "+trips.get(j).getDestination();
        }
        JLabel selectTripLabel = new JLabel("Select Trip:");
        JComboBox<String> tripComboBox = new JComboBox<>(trip);
        JButton bookTicketButton = new JButton("Book Ticket");
        JButton reviewTicketButton = new JButton("Review Tickets");
        JButton cancelTicketButton = new JButton("Cancel Ticket");
        JButton displayProfileButton = new JButton("Display Profile");

        bookTicketButton.addActionListener(e -> {
            try {
            Trip selectedTrip =  trips.get(parseInt(tripComboBox.getSelectedItem().toString().charAt(0)+"")-1);
            passenger.bookTicket(selectedTrip);
            passengers.remove(i);
            passengers.add(passenger);
            Passenger.saveToFile(passengers);
            Ticket ticket = passenger.bookTicket(selectedTrip);
            JOptionPane.showMessageDialog(frame, "Ticket booked successfully:\n" + ticket, "Booking Confirmation", JOptionPane.INFORMATION_MESSAGE);}
            catch (Exception  a){
                JOptionPane.showMessageDialog(frame,"Choose ticket first" , "Tickets", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        reviewTicketButton.addActionListener(e -> {
            String s="No tickets to show";
            if(!passenger.getTickets().isEmpty()){
                 s="";
            for (Ticket ticket : passenger.getTickets()) {
                s+=ticket+"\n";
            }
            }JOptionPane.showMessageDialog(frame,s , "Tickets", JOptionPane.INFORMATION_MESSAGE);

        });

        cancelTicketButton.addActionListener(e -> {
            Ticket selectedTicket = (Ticket) JOptionPane.showInputDialog(frame, "Select ticket to cancel:", "Cancel Ticket", JOptionPane.QUESTION_MESSAGE, null, passenger.getTickets().toArray(), null);
            if (selectedTicket != null) {
                passenger.cancelTicket(selectedTicket);
                JOptionPane.showInputDialog(frame, "Select ticket to cancel:", "Cancel Ticket", JOptionPane.QUESTION_MESSAGE, null, passenger.getTickets().toArray(), null);
            }
        });

        displayProfileButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame,passenger.displayProfile() , "Profile", JOptionPane.INFORMATION_MESSAGE);

        });

        JPanel passengerComponentsPanel = new JPanel(new GridLayout(6, 1));
        passengerComponentsPanel.add(selectTripLabel);
        passengerComponentsPanel.add(tripComboBox);
        passengerComponentsPanel.add(bookTicketButton);
        passengerComponentsPanel.add(reviewTicketButton);
        passengerComponentsPanel.add(cancelTicketButton);
        passengerComponentsPanel.add(displayProfileButton);

        passengerPanel.add(new JLabel("Passenger Panel", SwingConstants.CENTER), BorderLayout.NORTH);
        passengerPanel.add(passengerComponentsPanel, BorderLayout.CENTER);
    }




    private void createManagerPanel() {

        managerPanel = new JPanel(new GridLayout(5, 1));

        JPanel reviewTripsPanel = createReviewTripsPanel();
        managerPanel.add(reviewTripsPanel);


        JPanel addTripPanel = createAddTripPanel();
        managerPanel.add(addTripPanel);


        JPanel removeTripPanel = createRemoveTripPanel();
        managerPanel.add(removeTripPanel);


        JPanel assignDriverPanel = createAssignDriverPanel();
        managerPanel.add(assignDriverPanel);

    }

    private JPanel createReviewTripsPanel() {
        JPanel reviewTripsPanel = new JPanel(new BorderLayout());


         trips =Trip.loadFromFile(trips);


                DefaultListModel<String> tripListModel = new DefaultListModel<>();
        JList<String> tripList = new JList<>(tripListModel);


        for (Trip trip : trips) {if(trip!=null)
            tripListModel.addElement(trip.toString());
        }


        JScrollPane scrollPane = new JScrollPane(tripList);
        reviewTripsPanel.add(scrollPane, BorderLayout.CENTER);

        return reviewTripsPanel;
    }


    private JPanel createAddTripPanel() {
        JPanel addTripPanel = new JPanel(new GridLayout(8, 2));


        JTextField typeField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField sourceField = new JTextField();
        JTextField destinationField = new JTextField();
        JCheckBox oneWayCheckbox = new JCheckBox("One Way");
        JTextField numStopsField = new JTextField();
        JTextField availableSeatsField = new JTextField();

        addTripPanel.add(new JLabel("Type:"));
        addTripPanel.add(typeField);
        addTripPanel.add(new JLabel("Price:"));
        addTripPanel.add(priceField);
        addTripPanel.add(new JLabel("Source:"));
        addTripPanel.add(sourceField);
        addTripPanel.add(new JLabel("Destination:"));
        addTripPanel.add(destinationField);

        addTripPanel.add(new JLabel("Number of Stops:"));
        addTripPanel.add(numStopsField);
        addTripPanel.add(new JLabel("Available Seats:"));
        addTripPanel.add(availableSeatsField);
        addTripPanel.add(oneWayCheckbox);

        JButton addButton = new JButton("Add Trip");
        addButton.addActionListener(e -> {

            String type = typeField.getText();
            double price = Double.parseDouble(priceField.getText());
            String source = sourceField.getText();
            String destination = destinationField.getText();
            boolean oneWay = oneWayCheckbox.isSelected();
            int numStops = parseInt(numStopsField.getText());
            int availableSeats = parseInt(availableSeatsField.getText());

            Trip newTrip = new Trip(type, price, source, destination, oneWay, numStops, availableSeats);
            trips.add(newTrip);
            Trip.saveToFile(trips);
            createReviewTripsPanel();
        });
        addTripPanel.add(addButton);

        return addTripPanel;
    }



    private JPanel createRemoveTripPanel() {
        JPanel removeTripPanel = new JPanel(new BorderLayout());


        trips =Trip.loadFromFile(trips);


                DefaultListModel<Trip> tripListModel = new DefaultListModel<>();
        JList<Trip> tripList = new JList<>(tripListModel);

        for (Trip trip : trips) {
            tripListModel.addElement(trip);
        }

        JScrollPane scrollPane = new JScrollPane(tripList);

        removeTripPanel.add(scrollPane, BorderLayout.CENTER);

        JButton removeButton = new JButton("Remove Selected Trip");
        removeButton.addActionListener(e -> {

            ArrayList<Trip> trips1 =new ArrayList<>();
            trips1.add((Trip) tripList.getSelectedValuesList());
            for (Trip trip : trips1) {
                trips1.remove(trip);
            }
        });
        removeTripPanel.add(removeButton, BorderLayout.SOUTH);

        return removeTripPanel;
    }


    private JPanel createAssignDriverPanel() {
        JPanel assignDriverPanel = new JPanel(new GridLayout(3, 1));

        trips=Trip.loadFromFile(trips);
        drivers=Driver.loadFromFile(drivers);

        JComboBox<Trip> tripComboBox = new JComboBox<>(trips.toArray(new Trip[trips.size()]));
        JComboBox<Driver> driverComboBox = new JComboBox<>(drivers.toArray(new Driver[trips.size()]));

        assignDriverPanel.add(new JLabel("Select Trip:"));
        assignDriverPanel.add(tripComboBox);
        assignDriverPanel.add(new JLabel("Select Driver:"));
        assignDriverPanel.add(driverComboBox);

        JButton assignButton = new JButton("Assign Driver");
        assignButton.addActionListener(e -> {

            Trip selectedTrip = (Trip) tripComboBox.getSelectedItem();
            Driver selectedDriver = (Driver) driverComboBox.getSelectedItem();
            int i=drivers.indexOf(selectedDriver);
            selectedDriver.AssignedTrip(selectedTrip);
            drivers.remove(i);
            drivers.add(selectedDriver);
            Driver.saveToFile(drivers);
        });
        assignDriverPanel.add(assignButton);

        return assignDriverPanel;
    }

    private void createDriverPanel(Driver d,int i) {
         driverPanel = new JPanel(new BorderLayout());

        JLabel nameLabel = new JLabel("Name: " + d.getName());
        JButton viewAssignedTripsButton = new JButton("View Assigned Trips");

        viewAssignedTripsButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, d.AssignedTrips , "Trips", JOptionPane.INFORMATION_MESSAGE);
        });

        JPanel driverComponentsPanel = new JPanel(new GridLayout(3, 1));
        driverComponentsPanel.add(nameLabel);
        driverComponentsPanel.add(viewAssignedTripsButton);

        driverPanel.add(new JLabel("Driver Panel", SwingConstants.CENTER), BorderLayout.NORTH);
        driverPanel.add(driverComponentsPanel, BorderLayout.CENTER);
     }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TransportSystemGUI();
            }
        });
    }
}
