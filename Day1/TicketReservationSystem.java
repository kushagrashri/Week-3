import java.text.SimpleDateFormat;
import java.util.Date;

// Node class representing a ticket reservation
class TicketNode {
  int ticketId;
  String customerName;
  String movieName;
  String seatNumber;
  String bookingTime;
  TicketNode next;

  // Constructor to initialize a new ticket node
  TicketNode(int ticketId, String customerName, String movieName, String seatNumber) {
    this.ticketId = ticketId;
    this.customerName = customerName;
    this.movieName = movieName;
    this.seatNumber = seatNumber;
    this.bookingTime = getCurrentTime(); // Get the current booking time
    this.next = null;
  }

  // Method to get the current time in a specific format
  private String getCurrentTime() {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    return formatter.format(date);
  }
}

// CircularLinkedList class to manage the ticket reservations
class CircularTicketList {
  TicketNode head;
  TicketNode tail;

  // Constructor to initialize the circular list
  CircularTicketList() {
    head = null;
    tail = null;
  }

  // Method to add a new ticket reservation at the end of the list
  public void addTicket(int ticketId, String customerName, String movieName, String seatNumber) {
    TicketNode newNode = new TicketNode(ticketId, customerName, movieName, seatNumber);

    if (head == null) {
      head = tail = newNode;
      newNode.next = head; // Circular link
    } else {
      tail.next = newNode;
      newNode.next = head;
      tail = newNode;
    }
  }

  // Method to remove a ticket by Ticket ID
  public void removeTicket(int ticketId) {
    if (head == null) {
      System.out.println("No tickets to remove.");
      return;
    }

    TicketNode current = head;
    TicketNode prev = null;

    // Traverse the list to find the ticket to remove
    do {
      if (current.ticketId == ticketId) {
        if (current == head && current == tail) {
          // Only one ticket in the list
          head = tail = null;
        } else if (current == head) {
          // Remove head
          head = head.next;
          tail.next = head;
        } else if (current == tail) {
          // Remove tail
          prev.next = head;
          tail = prev;
        } else {
          // Remove from middle
          prev.next = current.next;
        }
        System.out.println("Ticket with ID " + ticketId + " removed successfully.");
        return;
      }
      prev = current;
      current = current.next;
    } while (current != head);

    System.out.println("Ticket with ID " + ticketId + " not found.");
  }

  // Method to display all tickets in the list
  public void displayTickets() {
    if (head == null) {
      System.out.println("No tickets available.");
      return;
    }

    TicketNode current = head;
    System.out.println("\nTickets in the reservation system:");
    do {
      System.out.println("Ticket ID: " + current.ticketId + ", Customer Name: " + current.customerName +
          ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
      current = current.next;
    } while (current != head);
  }

  // Method to search for tickets by Customer Name or Movie Name
  public void searchTicket(String searchTerm) {
    if (head == null) {
      System.out.println("No tickets available.");
      return;
    }

    TicketNode current = head;
    boolean found = false;

    do {
      if (current.customerName.equalsIgnoreCase(searchTerm) || current.movieName.equalsIgnoreCase(searchTerm)) {
        System.out.println("Ticket ID: " + current.ticketId + ", Customer Name: " + current.customerName +
            ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: "
            + current.bookingTime);
        found = true;
      }
      current = current.next;
    } while (current != head);

    if (!found) {
      System.out.println("No ticket found for " + searchTerm);
    }
  }

  // Method to count the total number of booked tickets
  public int countTickets() {
    if (head == null) {
      return 0;
    }

    int count = 0;
    TicketNode current = head;

    do {
      count++;
      current = current.next;
    } while (current != head);

    return count;
  }
}

// Main class to test the Online Ticket Reservation System
public class TicketReservationSystem {
  public static void main(String[] args) {
    CircularTicketList ticketList = new CircularTicketList();

    // Add new ticket reservations
    ticketList.addTicket(1, "Alice", "Avatar 2", "A1");
    ticketList.addTicket(2, "Bob", "Spider-Man: No Way Home", "B5");
    ticketList.addTicket(3, "Charlie", "Avatar 2", "C2");
    ticketList.addTicket(4, "David", "The Batman", "D4");

    // Display all tickets
    ticketList.displayTickets();

    // Search for tickets by Customer Name or Movie Name
    System.out.println("\nSearching for tickets by movie 'Avatar 2':");
    ticketList.searchTicket("Avatar 2");

    System.out.println("\nSearching for tickets by customer 'Bob':");
    ticketList.searchTicket("Bob");

    // Count the total number of booked tickets
    int totalTickets = ticketList.countTickets();
    System.out.println("\nTotal number of booked tickets: " + totalTickets);

    // Remove a ticket by Ticket ID
    System.out.println("\nRemoving ticket with ID 2:");
    ticketList.removeTicket(2);

    // Display all tickets after removal
    ticketList.displayTickets();
  }
}
