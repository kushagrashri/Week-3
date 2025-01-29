// Node class representing each student record in the linked list
class Node {
  int rollNumber;  // Unique identifier for the student
  String name;     // Name of the student
  int age;         // Age of the student
  char grade;      // Grade of the student
  Node next;       // Pointer to the next node in the list

  // Constructor to initialize a new node with student details
  Node(int rollNumber, String name, int age, char grade) {
    this.rollNumber = rollNumber;
    this.name = name;
    this.age = age;
    this.grade = grade;
    this.next = null;
  }
}

// LinkedList class to manage student records
class LinkedList {
  Node head; // Head node of the linked list

  // Constructor to initialize the linked list
  LinkedList() {
    this.head = null;
  }

  // Method to add a node at the beginning of the list
  public Node addToFirst(Node head, int rollNumber, String name, int age, char grade) {
    Node currNode = new Node(rollNumber, name, age, grade); // Create new node
    if (head == null) {
      return currNode; // If the list is empty, return the new node as the head
    }
    currNode.next = head; // New node points to the previous head
    return currNode; // Return new head
  }

  // Method to add a node after a specific roll number in the list
  public Node addInBetween(Node head, int rollNumber, String name, int age, char grade, int afterRollNumber) {
    Node currNode = new Node(rollNumber, name, age, grade); // Create new node
    Node current = head;

    // Traverse the list to find the node with rollNumber == afterRollNumber
    while (current != null) {
      if (current.rollNumber == afterRollNumber) {
        if (current.next != null) {
          // Insert the new node between two existing nodes
          currNode.next = current.next;
          current.next = currNode;
          return head;
        } else {
          // If it's the last node, simply attach the new node at the end
          current.next = currNode;
          return head;
        }
      }
      current = current.next;
    }
    return head; // Return head if the specified node is not found
  }

  // Method to add a node at the end of the list
  public Node addToLast(Node head, int rollNumber, String name, int age, char grade) {
    Node currNode = new Node(rollNumber, name, age, grade); // Create new node
    if (head == null) {
      return currNode; // If the list is empty, return new node as the head
    }
    Node current = head;

    // Traverse to the last node
    while (current.next != null) {
      current = current.next;
    }
    current.next = currNode; // Attach new node at the end
    return head;
  }

  // Method to delete the first node in the list
  public Node deleteFromFirst(Node head) {
    if (head == null) {
      System.out.println("\nList is empty.");
      return head;
    }
    return head.next; // Move head to the next node and return new head
  }

  // Method to delete a node that comes after a specific roll number
  public Node deleteInBetween(Node head, int afterRollNumber) {
    if (head == null) {
      System.out.println("\nList is empty.");
      return head;
    }
    Node current = head;

    if (current.next == null) {
      System.out.println("\nOnly one node is in list.");
      return current;
    }

    // Traverse the list to find the node with rollNumber == afterRollNumber
    while (current != null) {
      if (current.rollNumber == afterRollNumber) {
        if (current.next == null) {
          System.out.println("\nOops, no node is there after this rollNumber.");
          return head;
        }
        current.next = current.next.next; // Remove the node after the found node
        return head;
      }
      current = current.next;
    }
    System.out.println("\nNo node matches with rollNumber " + afterRollNumber + ".");
    return head;
  }

  // Method to delete the last node in the list
  public Node deleteAtEnd(Node head) {
    if (head == null) {
      System.out.println("\nList is empty.");
      return head;
    }
    Node current = head;

    if (current.next == null) {
      // If there's only one node, delete it and return an empty list
      System.out.println("\nTask performed and now list is empty.");
      return null;
    }

    // Traverse to the second-last node
    while (current.next.next != null) {
      current = current.next;
    }
    current.next = null; // Remove the last node
    return head;
  }

  // Method to search for a student by roll number
  public void searchStudent(Node head, int rollNumber) {
    if (head == null) {
      System.out.println("No student in the list.");
      return;
    }
    Node current = head;

    while (current != null) {
      if (current.rollNumber == rollNumber) {
        display(current); // Display student details if found
        return;
      }
      current = current.next;
    }
    System.out.println("\nStudent with this rollNumber not found.");
    return;
  }

  // Method to display student records in the linked list
  public void display(Node node) {
    Node currNode = node;
    while (currNode != null) {
      System.out.println("\nName is       : " + currNode.name);
      System.out.println("RollNumber is : " + currNode.rollNumber);
      System.out.println("Age is        : " + currNode.age);
      System.out.println("Grade is      : " + currNode.grade);
      currNode = currNode.next; // Move to the next node
    }
  }
}

// Main class to test Student Record Management system
class StudentRecordManagement {
  public static void main(String[] args) {
    Node head = null;
    LinkedList list = new LinkedList();

    // Adding nodes to the linked list
    head = list.addToFirst(head, 149, "Sachin", 21, 'A'); // Add at beginning
    head = list.addToLast(head, 77, "Duggu", 23, 'A');   // Add at end
    head = list.addInBetween(head, 120, "Ramu", 25, 'B', 77); // Add in between

    System.out.println("\nAfter adding nodes, list is:");
    list.display(head);

    // Deleting nodes
    head = list.deleteFromFirst(head); // Delete first node
    head = list.deleteAtEnd(head); // Delete last node
    head = list.deleteInBetween(head, 1200); // Attempt to delete a non-existing node

    System.out.println("\nAfter deleting nodes, list is:");
    list.display(head);

    // Searching for a student
    list.searchStudent(head, 149);
  }
}
