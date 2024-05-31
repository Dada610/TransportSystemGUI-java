//import java.util.ArrayList;
//import java.util.List;
//
//public class TicketManager {
//    private List<Ticket> bookedTickets;
//
//    public TicketManager() {
//        this.bookedTickets = new ArrayList<>();
//    }
//
//    public boolean performBooking(String selectedTrip, String selectedTicketType) {
//        // Perform actual booking logic here (e.g., store ticket information)
//        // For demonstration, create a new Ticket object and add it to the list
//
//        // Create a new Ticket object with selected trip and ticket type
//        Ticket ticket = new Ticket(selectedTrip, selectedTicketType);
//
//        // Add the ticket to the list of booked tickets
//        boolean bookingSuccessful = bookedTickets.add(ticket);
//
//        // Return true if booking is successful, false otherwise
//        return bookingSuccessful;
//    }
//
//    // Inner Ticket class representing a booked ticket
//    private class Ticket {
//        private String trip;
//        private String ticketType;
//
//        public Ticket(String trip, String ticketType) {
//            this.trip = trip;
//            this.ticketType = ticketType;
//        }
//
//        // Getter methods for trip and ticket type (you can add more if needed)
//        public String getTrip() {
//            return trip;
//        }
//
//        public String getTicketType() {
//            return ticketType;
//        }
//    }
//}
