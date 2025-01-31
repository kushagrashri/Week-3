import java.util.LinkedList;

class MyHashMap {
  private static final int SIZE = 1000; // Size of the array
  private LinkedList<Node>[] map;

  // Node class to represent key-value pairs in the linked list
  private class Node {
    int key, value;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  // Constructor to initialize the map with empty linked lists
  public MyHashMap() {
    map = new LinkedList[SIZE];
    for (int i = 0; i < SIZE; i++) {
      map[i] = new LinkedList<>();
    }
  }

  // Hash function to compute the index from the key
  private int hash(int key) {
    return key % SIZE;
  }

  // Insert or update the key-value pair
  public void put(int key, int value) {
    int index = hash(key);
    LinkedList<Node> bucket = map[index];

    // Check if the key already exists, update if found
    for (Node node : bucket) {
      if (node.key == key) {
        node.value = value;
        return;
      }
    }

    // If key does not exist, add a new node
    bucket.add(new Node(key, value));
  }

  // Retrieve the value for the given key
  public int get(int key) {
    int index = hash(key);
    LinkedList<Node> bucket = map[index];

    for (Node node : bucket) {
      if (node.key == key) {
        return node.value;
      }
    }

    // Return -1 if the key does not exist
    return -1;
  }

  // Remove the key-value pair for the given key
  public void remove(int key) {
    int index = hash(key);
    LinkedList<Node> bucket = map[index];

    for (Node node : bucket) {
      if (node.key == key) {
        bucket.remove(node);
        return;
      }
    }
  }

  // Main method for testing
  public static void main(String[] args) {
    MyHashMap hashMap = new MyHashMap();

    // Inserting key-value pairs
    hashMap.put(1, 100);
    hashMap.put(2, 200);
    hashMap.put(3, 300);

    // Retrieving values
    System.out.println("Value for key 1: " + hashMap.get(1)); // 100
    System.out.println("Value for key 2: " + hashMap.get(2)); // 200
    System.out.println("Value for key 3: " + hashMap.get(3)); // 300

    // Removing key-value pair
    hashMap.remove(2);
    System.out.println("Value for key 2 after removal: " + hashMap.get(2)); // -1
  }
}
