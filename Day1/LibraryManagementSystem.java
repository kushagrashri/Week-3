// Node class representing each book in the library
class BookNode {
  String title;
  String author;
  String genre;
  int bookId;
  boolean isAvailable;
  BookNode next;
  BookNode prev;

  // Constructor to initialize a new book node
  BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.bookId = bookId;
    this.isAvailable = isAvailable;
    this.next = null;
    this.prev = null;
  }
}

// DoublyLinkedList1 class to manage the library
class DoublyLinkedList1 {
  BookNode head;
  BookNode tail;

  // Constructor to initialize the doubly linked list
  DoublyLinkedList1() {
    this.head = null;
    this.tail = null;
  }

  // Method to add a book at the beginning
  public void addToFirst(String title, String author, String genre, int bookId, boolean isAvailable) {
    BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);

    if (head == null) {
      head = tail = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode; 
      head = newNode;
    }
  }

  // Method to add a book at the end
  public void addToLast(String title, String author, String genre, int bookId, boolean isAvailable) {
    BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);

    if (head == null) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    }
  }

  // Method to add a book after a specific Book ID
  public void addInBetween(int bookId, String title, String author, String genre, int newBookId, boolean isAvailable) {
    BookNode current = head;
    while (current != null) {
      if (current.bookId == bookId) {
        BookNode newNode = new BookNode(title, author, genre, newBookId, isAvailable);
        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
          current.next.prev = newNode;
        } else {
          tail = newNode; // If inserting at the end
        }

        current.next = newNode;
        return;
      }
      current = current.next;
    }
    System.out.println("\nBook with ID " + bookId + " not found.");
  }

  // Method to remove a book by Book ID
  public void removeByBookId(int bookId) {
    if (head == null) {
      System.out.println("\nNo books to remove.");
      return;
    }

    BookNode current = head;
    while (current != null) {
      if (current.bookId == bookId) {
        if (current == head && current == tail) {
          head = tail = null;
        } else if (current == head) {
          head = head.next;
          head.prev = null;
        } else if (current == tail) {
          tail = tail.prev;
          tail.next = null;
        } else {
          current.prev.next = current.next;
          current.next.prev = current.prev;
        }
        return;
      }
      current = current.next;
    }
    System.out.println("\nBook with ID " + bookId + " not found.");
  }

  // Method to search for a book by Book Title
  public void searchByBookTitle(String title) {
    BookNode current = head;
    while (current != null) {
      if (current.title.equalsIgnoreCase(title)) {
        System.out.println("\nBook Found: " + current.title + " | Author: " + current.author +
            " | Genre: " + current.genre + " | ID: " + current.bookId +
            " | Availability: " + (current.isAvailable ? "Available" : "Checked Out"));
        return;
      }
      current = current.next;
    }
    System.out.println("\nBook with title " + title + " not found.");
  }

  // Method to search for a book by Author
  public void searchByAuthor(String author) {
    BookNode current = head;
    while (current != null) {
      if (current.author.equalsIgnoreCase(author)) {
        System.out.println("\nBook Found: " + current.title + " | Author: " + current.author +
            " | Genre: " + current.genre + " | ID: " + current.bookId +
            " | Availability: " + (current.isAvailable ? "Available" : "Checked Out"));
        return;
      }
      current = current.next;
    }
    System.out.println("\nNo books found by author " + author + ".");
  }

  // Method to update a book's availability status by Book ID
  public void updateAvailabilityByBookId(int bookId, boolean isAvailable) {
    BookNode current = head;
    while (current != null) {
      if (current.bookId == bookId) {
        current.isAvailable = isAvailable;
        return;
      }
      current = current.next;
    }
    System.out.println("\nBook with ID " + bookId + " not found.");
  }

  // Method to display all books in the list (Forward traversal)
  public void displayForward() {
    if (head == null) {
      System.out.println("\nNo books available.");
      return;
    }

    System.out.println("\nLibrary Books (Forward):");
    BookNode current = head;
    while (current != null) {
      System.out.println("Title: " + current.title + " | Author: " + current.author +
          " | Genre: " + current.genre + " | ID: " + current.bookId +
          " | Availability: " + (current.isAvailable ? "Available" : "Checked Out"));
      current = current.next;
    }
  }

  // Method to display all books in the list (Reverse traversal)
  public void displayReverse() {
    if (tail == null) {
      System.out.println("\nNo books available.");
      return;
    }

    System.out.println("\nLibrary Books (Reverse):");
    BookNode current = tail;
    while (current != null) {
      System.out.println("Title: " + current.title + " | Author: " + current.author +
          " | Genre: " + current.genre + " | ID: " + current.bookId +
          " | Availability: " + (current.isAvailable ? "Available" : "Checked Out"));
      current = current.prev;
    }
  }

  // Method to count the total number of books in the library
  public void countTotalBooks() {
    int count = 0;
    BookNode current = head;
    while (current != null) {
      count++;
      current = current.next;
    }
    System.out.println("\nTotal number of books in the library: " + count);
  }
}

// Main class to test the Library Management System
public class LibraryManagementSystem {
  public static void main(String[] args) {
    DoublyLinkedList1 library = new DoublyLinkedList1();

    // Adding Indian books to the library
    library.addToFirst("The God of Small Things", "Arundhati Roy", "Fiction", 1, true);
    library.addToLast("Chetan Bhagat: 2 States", "Chetan Bhagat", "Romance", 2, true);
    library.addToLast("The White Tiger", "Aravind Adiga", "Thriller", 3, false);
    library.addInBetween(2, "Midnight's Children", "Salman Rushdie", "Historical Fiction", 4, true);

    // Displaying library books (Forward and Reverse)
    library.displayForward();
    library.displayReverse();

    // Searching for a book by Title
    library.searchByBookTitle("The White Tiger");

    // Searching for a book by Author
    library.searchByAuthor("Chetan Bhagat");

    // Updating a book's availability status
    library.updateAvailabilityByBookId(3, true);

    // Removing a book by Book ID
    library.removeByBookId(2);

    // Displaying library books after removal
    library.displayForward();

    // Counting total number of books in the library
    library.countTotalBooks();
  }
}
