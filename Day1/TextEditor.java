// Node class representing a state of the text content
class TextNode {
  String text; // Text content at this state
  TextNode prev, next; // Pointers for undo and redo functionality

  // Constructor to initialize a new text node
  TextNode(String text) {
    this.text = text;
    this.prev = this.next = null;
  }
}

// DoublyLinkedList class to manage the text editor's state
class TextEditorHistory {
  TextNode current; // Points to the current state of the text
  int historySize; // Maximum size of the undo/redo history
  int currentSize; // Current size of the history
  TextNode head, tail; // Head and Tail pointers for history

  // Constructor to initialize the history with a max size
  TextEditorHistory(int historySize) {
    this.historySize = historySize;
    this.currentSize = 0;
    this.head = this.tail = this.current = null;
  }

  // Method to add a new text state to the history
  public void addState(String text) {
    TextNode newNode = new TextNode(text);

    // If history size is full, remove the oldest state (head)
    if (currentSize == historySize) {
      head = head.next;
      if (head != null) {
        head.prev = null;
      }
      currentSize--;
    }

    // Add the new state at the end of the list
    if (current == null) {
      head = tail = current = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
      current = tail; // New state is the current one
    }
    currentSize++;
  }

  // Method to undo the last action (revert to the previous state)
  public void undo() {
    if (current == null || current.prev == null) {
      System.out.println("No more undo actions available.");
      return;
    }
    current = current.prev;
    System.out.println("Undo: Current text is: " + current.text);
  }

  // Method to redo the last undone action (revert to the next state)
  public void redo() {
    if (current == null || current.next == null) {
      System.out.println("No more redo actions available.");
      return;
    }
    current = current.next;
    System.out.println("Redo: Current text is: " + current.text);
  }

  // Method to display the current state of the text
  public void displayCurrentState() {
    if (current == null) {
      System.out.println("No text available.");
    } else {
      System.out.println("Current text: " + current.text);
    }
  }

  // Method to display the entire history of text states (for debugging)
  public void displayHistory() {
    if (head == null) {
      System.out.println("No history available.");
      return;
    }
    TextNode temp = head;
    System.out.println("Text History: ");
    while (temp != null) {
      System.out.println(temp.text);
      temp = temp.next;
    }
  }
}

// Main class to test the Undo/Redo functionality in the text editor
public class TextEditor {
  public static void main(String[] args) {
    // Create a TextEditorHistory object with a max history size of 5
    TextEditorHistory editorHistory = new TextEditorHistory(5);

    // Add some initial states to the history
    editorHistory.addState("Hello");
    editorHistory.addState("Hello, world!");
    editorHistory.addState("Hello, world! How are you?");
    editorHistory.addState("Hello, world! How are you? I am fine.");
    editorHistory.addState("Hello, world! How are you? I am fine. Thanks!");

    // Display current text
    editorHistory.displayCurrentState();

    // Perform undo and redo operations
    editorHistory.undo(); // Undo to previous state
    editorHistory.undo(); // Undo again
    editorHistory.redo(); // Redo to next state

    // Add more states to demonstrate the history size limit
    editorHistory.addState("Hello, world!");
    editorHistory.addState("Hello, everyone!");
    editorHistory.addState("Goodbye!");

    // Display history after adding more states
    editorHistory.displayHistory();

    // Display final current state
    editorHistory.displayCurrentState();
  }
}
