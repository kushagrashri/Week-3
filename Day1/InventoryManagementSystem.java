// Node class representing each item in the inventory
class ItemNode {
  String itemName;
  int itemId;
  int quantity;
  double price;
  ItemNode next;

  // Constructor to initialize a new item node
  ItemNode(String itemName, int itemId, int quantity, double price) {
    this.itemName = itemName;
    this.itemId = itemId;
    this.quantity = quantity;
    this.price = price;
    this.next = null;
  }
}

// SinglyLinkedList class to manage the inventory
class SinglyLinkedList {
  ItemNode head;

  // Constructor to initialize the singly linked list
  SinglyLinkedList() {
    this.head = null;
  }

  // Method to add an item at the beginning
  public void addToFirst(String itemName, int itemId, int quantity, double price) {
    ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
    newNode.next = head;
    head = newNode;
  }

  // Method to add an item at the end
  public void addToLast(String itemName, int itemId, int quantity, double price) {
    ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);

    if (head == null) {
      head = newNode;
    } else {
      ItemNode current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
    }
  }

  // Method to add an item at a specific position (after a given Item ID)
  public void addInBetween(int itemId, String itemName, int newItemId, int quantity, double price) {
    ItemNode current = head;
    while (current != null) {
      if (current.itemId == itemId) {
        ItemNode newNode = new ItemNode(itemName, newItemId, quantity, price);
        newNode.next = current.next;
        current.next = newNode;
        return;
      }
      current = current.next;
    }
    System.out.println("Item with ID " + itemId + " not found.");
  }

  // Method to remove an item based on Item ID
  public void removeByItemId(int itemId) {
    if (head == null) {
      System.out.println("\nNo items to remove.");
      return;
    }

    if (head.itemId == itemId) {
      head = head.next;
      return;
    }

    ItemNode current = head;
    while (current.next != null && current.next.itemId != itemId) {
      current = current.next;
    }

    if (current.next == null) {
      System.out.println("\nItem with ID " + itemId + " not found.");
    } else {
      current.next = current.next.next;
    }
  }

  // Method to update the quantity of an item by Item ID
  public void updateQuantityByItemId(int itemId, int newQuantity) {
    ItemNode current = head;
    while (current != null) {
      if (current.itemId == itemId) {
        current.quantity = newQuantity;
        return;
      }
      current = current.next;
    }
    System.out.println("\nItem with ID " + itemId + " not found.");
  }

  // Method to search for an item by Item ID
  public void searchByItemId(int itemId) {
    ItemNode current = head;
    while (current != null) {
      if (current.itemId == itemId) {
        System.out.println("\nItem Found: " + current.itemName + " | ID: " + current.itemId + " | Quantity: "
            + current.quantity + " | Price: " + current.price);
        return;
      }
      current = current.next;
    }
    System.out.println("\nItem with ID " + itemId + " not found.");
  }

  // Method to search for an item by Item Name
  public void searchByItemName(String itemName) {
    ItemNode current = head;
    while (current != null) {
      if (current.itemName.equalsIgnoreCase(itemName)) {
        System.out.println("\nItem Found: " + current.itemName + " | ID: " + current.itemId + " | Quantity: "
            + current.quantity + " | Price: " + current.price);
        return;
      }
      current = current.next;
    }
    System.out.println("\nItem with name " + itemName + " not found.");
  }

  // Method to calculate and display the total value of inventory
  public void calculateTotalValue() {
    double totalValue = 0;
    ItemNode current = head;
    while (current != null) {
      totalValue += current.quantity * current.price;
      current = current.next;
    }
    System.out.println("\nTotal Inventory Value: " + totalValue);
  }

  // Method to sort the inventory based on Item Name in ascending order using
  // Merge Sort
  public void sortByNameAscending() {
    head = mergeSortByName(head, true);
  }

  // Method to sort the inventory based on Price in ascending order using Merge
  // Sort
  public void sortByPriceAscending() {
    head = mergeSortByPrice(head, true);
  }

  // Method to merge sort the list based on Item Name
  private ItemNode mergeSortByName(ItemNode head, boolean ascending) {
    if (head == null || head.next == null) {
      return head;
    }

    ItemNode middle = getMiddle(head);
    ItemNode nextToMiddle = middle.next;
    middle.next = null;

    ItemNode left = mergeSortByName(head, ascending);
    ItemNode right = mergeSortByName(nextToMiddle, ascending);

    return mergeByName(left, right, ascending);
  }

  // Method to merge two sorted lists based on Item Name
  private ItemNode mergeByName(ItemNode left, ItemNode right, boolean ascending) {
    if (left == null)
      return right;
    if (right == null)
      return left;

    if (ascending) {
      if (left.itemName.compareTo(right.itemName) <= 0) {
        left.next = mergeByName(left.next, right, ascending);
        return left;
      } else {
        right.next = mergeByName(left, right.next, ascending);
        return right;
      }
    } else {
      if (left.itemName.compareTo(right.itemName) >= 0) {
        left.next = mergeByName(left.next, right, ascending);
        return left;
      } else {
        right.next = mergeByName(left, right.next, ascending);
        return right;
      }
    }
  }

  // Method to merge sort the list based on Price
  private ItemNode mergeSortByPrice(ItemNode head, boolean ascending) {
    if (head == null || head.next == null) {
      return head;
    }

    ItemNode middle = getMiddle(head);
    ItemNode nextToMiddle = middle.next;
    middle.next = null;

    ItemNode left = mergeSortByPrice(head, ascending);
    ItemNode right = mergeSortByPrice(nextToMiddle, ascending);

    return mergeByPrice(left, right, ascending);
  }

  // Method to merge two sorted lists based on Price
  private ItemNode mergeByPrice(ItemNode left, ItemNode right, boolean ascending) {
    if (left == null)
      return right;
    if (right == null)
      return left;

    if (ascending) {
      if (left.price <= right.price) {
        left.next = mergeByPrice(left.next, right, ascending);
        return left;
      } else {
        right.next = mergeByPrice(left, right.next, ascending);
        return right;
      }
    } else {
      if (left.price >= right.price) {
        left.next = mergeByPrice(left.next, right, ascending);
        return left;
      } else {
        right.next = mergeByPrice(left, right.next, ascending);
        return right;
      }
    }
  }

  // Method to find the middle of the linked list
  private ItemNode getMiddle(ItemNode head) {
    if (head == null)
      return null;

    ItemNode slow = head;
    ItemNode fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  // Method to display all items in the inventory
  public void displayInventory() {
    if (head == null) {
      System.out.println("\nNo items available in inventory.");
      return;
    }

    System.out.println("\nInventory List:");
    ItemNode current = head;
    while (current != null) {
      System.out.println("Item Name: " + current.itemName + " | ID: " + current.itemId +
          " | Quantity: " + current.quantity + " | Price: " + current.price);
      current = current.next;
    }
  }
}

// Main class to test the Inventory Management System
public class InventoryManagementSystem {
  public static void main(String[] args) {
    SinglyLinkedList inventory = new SinglyLinkedList();

    // Adding items to the inventory
    inventory.addToFirst("Laptop", 1, 10, 800.00);
    inventory.addToLast("Phone", 2, 20, 500.00);
    inventory.addToLast("Keyboard", 3, 15, 100.00);
    inventory.addToFirst("Monitor", 4, 5, 150.00);

    // Displaying inventory
    inventory.displayInventory();

    // Searching for an item by Item ID
    inventory.searchByItemId(2);

    // Searching for an item by Item Name
    inventory.searchByItemName("Keyboard");

    // Updating the quantity of an item
    inventory.updateQuantityByItemId(3, 20);

    // Removing an item by Item ID
    inventory.removeByItemId(4);

    // Displaying inventory after removal
    inventory.displayInventory();

    // Calculating total inventory value
    inventory.calculateTotalValue();

    // Sorting inventory by Item Name in ascending order
    inventory.sortByNameAscending();
    inventory.displayInventory();

    // Sorting inventory by Price in descending order
    inventory.sortByPriceAscending();
    inventory.displayInventory();
  }
}
