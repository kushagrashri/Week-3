// MovieNode class representing each movie in the doubly linked list
class MovieNode {
  String title;
  String director;
  int year;
  double rating;
  MovieNode next;
  MovieNode prev;

  // Constructor to initialize a new movie node
  MovieNode(String title, String director, int year, double rating) {
    this.title = title;
    this.director = director;
    this.year = year;
    this.rating = rating;
    this.next = null;
    this.prev = null;
  }
}

// DoublyLinkedList class to manage movies
class DoublyLinkedList {
  MovieNode head;
  MovieNode tail;

  // Constructor to initialize the linked list
  DoublyLinkedList() {
    this.head = null;
    this.tail = null;
  }

  // Method to add a movie at the beginning
  public void addToFirst(String title, String director, int year, double rating) {
    MovieNode newNode = new MovieNode(title, director, year, rating);
    if (head == null) {
      head = tail = newNode; // If list is empty, new node is both head and tail
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode; // Update head to the new node
    }
  }

  // Method to add a movie at the end
  public void addToLast(String title, String director, int year, double rating) {
    MovieNode newNode = new MovieNode(title, director, year, rating);
    if (tail == null) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode; // Update tail to the new node
    }
  }

  // Method to add a movie after a specific movie title
  public void addInBetween(String title, String director, int year, double rating, String afterTitle) {
    MovieNode newNode = new MovieNode(title, director, year, rating);
    MovieNode current = head;

    while (current != null) {
      if (current.title.equals(afterTitle)) {
        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
          current.next.prev = newNode;
        } else {
          tail = newNode; // If adding at the end, update tail
        }

        current.next = newNode;
        return;
      }
      current = current.next;
    }
    System.out.println("\nMovie with title '" + afterTitle + "' not found.");
  }

  // Method to remove a movie by title
  public void removeByTitle(String title) {
    MovieNode current = head;

    while (current != null) {
      if (current.title.equals(title)) {
        if (current == head) {
          head = head.next; // Remove head
          if (head != null)
            head.prev = null;
        } else if (current == tail) {
          tail = tail.prev; // Remove tail
          if (tail != null)
            tail.next = null;
        } else {
          current.prev.next = current.next;
          current.next.prev = current.prev;
        }
        System.out.println("\nMovie '" + title + "' removed successfully.");
        return;
      }
      current = current.next;
    }
    System.out.println("\nMovie with title '" + title + "' not found.");
  }

  // Method to search for a movie by director
  public void searchByDirector(String director) {
    MovieNode current = head;
    boolean found = false;

    while (current != null) {
      if (current.director.equals(director)) {
        System.out.println("\nMovie Found: " + current.title + " (" + current.year + "), Rating: " + current.rating);
        found = true;
      }
      current = current.next;
    }

    if (!found) {
      System.out.println("\nNo movies found directed by '" + director + "'.");
    }
  }

  // Method to search for a movie by rating
  public void searchByRating(double rating) {
    MovieNode current = head;
    boolean found = false;

    while (current != null) {
      if (current.rating == rating) {
        System.out.println("\nMovie Found: " + current.title + " directed by " + current.director);
        found = true;
      }
      current = current.next;
    }

    if (!found) {
      System.out.println("\nNo movies found with rating " + rating + ".");
    }
  }

  // Method to update a movie's rating by title
  public void updateRating(String title, double newRating) {
    MovieNode current = head;

    while (current != null) {
      if (current.title.equals(title)) {
        current.rating = newRating;
        System.out.println("\nRating updated for movie '" + title + "' to " + newRating);
        return;
      }
      current = current.next;
    }
    System.out.println("\nMovie with title '" + title + "' not found.");
  }

  // Method to display all movies in forward order
  public void displayForward() {
    MovieNode current = head;

    if (current == null) {
      System.out.println("\nNo movies available.");
      return;
    }

    System.out.println("\nMovies List (Forward Order):");
    while (current != null) {
      System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year
          + ", Rating: " + current.rating);
      current = current.next;
    }
  }

  // Method to display all movies in reverse order
  public void displayReverse() {
    MovieNode current = tail;

    if (current == null) {
      System.out.println("\nNo movies available.");
      return;
    }

    System.out.println("\nMovies List (Reverse Order):");
    while (current != null) {
      System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year
          + ", Rating: " + current.rating);
      current = current.prev;
    }
  }
}

// Main class to test the Bollywood Movie Management System
public class MovieManagement {
  public static void main(String[] args) {
    DoublyLinkedList movieList = new DoublyLinkedList();

    // Adding Bollywood movies
    movieList.addToFirst("Sholay", "Ramesh Sippy", 1975, 9.0);
    movieList.addToLast("Dilwale Dulhania Le Jayenge", "Aditya Chopra", 1995, 8.5);
    movieList.addToLast("3 Idiots", "Rajkumar Hirani", 2009, 8.4);
    movieList.addInBetween("Gully Boy", "Zoya Akhtar", 2019, 8.2, "Dilwale Dulhania Le Jayenge");

    // Displaying movies in forward and reverse order
    movieList.displayForward();
    movieList.displayReverse();

    // Searching for movies
    movieList.searchByDirector("Rajkumar Hirani");
    movieList.searchByRating(8.5);

    // Updating movie rating
    movieList.updateRating("Sholay", 9.2);
    movieList.displayForward();

    // Removing movies
    movieList.removeByTitle("3 Idiots");
    movieList.displayForward();
  }
}
