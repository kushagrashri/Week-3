// Node class representing each user in the friend connections list
class UserNode {
  int userId;
  String name;
  int age;
  FriendNode friends; // Linked list of friends (FriendNode)
  UserNode next;

  // Constructor to initialize a new user node
  UserNode(int userId, String name, int age) {
    this.userId = userId;
    this.name = name;
    this.age = age;
    this.friends = null;
    this.next = null;
  }
}

// Node class to represent each friend in the list of a user
class FriendNode {
  int friendId;
  FriendNode next;

  // Constructor to initialize a new friend node
  FriendNode(int friendId) {
    this.friendId = friendId;
    this.next = null;
  }
}

// SinglyLinkedList class to manage the list of users and their friend
// connections
class SinglyLinkedList1 {
  UserNode head;

  // Constructor to initialize the list
  SinglyLinkedList1() {
    this.head = null;
  }

  // Method to add a new user to the list
  public void addUser(int userId, String name, int age) {
    UserNode newUser = new UserNode(userId, name, age);
    if (head == null) {
      head = newUser;
    } else {
      UserNode current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newUser;
    }
  }

  // Method to find a user by their ID
  public UserNode findUserById(int userId) {
    UserNode current = head;
    while (current != null) {
      if (current.userId == userId) {
        return current;
      }
      current = current.next;
    }
    return null; // User not found
  }

  // Method to find a user by their name
  public UserNode findUserByName(String name) {
    UserNode current = head;
    while (current != null) {
      if (current.name.equalsIgnoreCase(name)) {
        return current;
      }
      current = current.next;
    }
    return null; // User not found
  }

  // Method to add a friend connection between two users
  public void addFriend(int userId1, int userId2) {
    UserNode user1 = findUserById(userId1);
    UserNode user2 = findUserById(userId2);

    if (user1 == null || user2 == null) {
      System.out.println("One or both users not found.");
      return;
    }

    // Add user2 to user1's friends list
    FriendNode newFriend1 = new FriendNode(userId2);
    newFriend1.next = user1.friends;
    user1.friends = newFriend1;

    // Add user1 to user2's friends list
    FriendNode newFriend2 = new FriendNode(userId1);
    newFriend2.next = user2.friends;
    user2.friends = newFriend2;
  }

  // Method to remove a friend connection between two users
  public void removeFriend(int userId1, int userId2) {
    UserNode user1 = findUserById(userId1);
    UserNode user2 = findUserById(userId2);

    if (user1 == null || user2 == null) {
      System.out.println("One or both users not found.");
      return;
    }

    // Remove user2 from user1's friends list
    user1.friends = removeFriendFromList(user1.friends, userId2);

    // Remove user1 from user2's friends list
    user2.friends = removeFriendFromList(user2.friends, userId1);
  }

  // Helper method to remove a friend from a user's friends list
  private FriendNode removeFriendFromList(FriendNode head, int friendId) {
    if (head == null) {
      return null;
    }
    if (head.friendId == friendId) {
      return head.next;
    }
    FriendNode current = head;
    while (current.next != null && current.next.friendId != friendId) {
      current = current.next;
    }
    if (current.next != null) {
      current.next = current.next.next;
    }
    return head;
  }

  // Method to find mutual friends between two users
  public void findMutualFriends(int userId1, int userId2) {
    UserNode user1 = findUserById(userId1);
    UserNode user2 = findUserById(userId2);

    if (user1 == null || user2 == null) {
      System.out.println("One or both users not found.");
      return;
    }

    FriendNode friends1 = user1.friends;
    System.out.println("Mutual Friends between " + user1.name + " and " + user2.name + ":");
    boolean foundMutual = false;

    while (friends1 != null) {
      FriendNode friends2 = user2.friends;
      while (friends2 != null) {
        if (friends1.friendId == friends2.friendId) {
          System.out.println("Friend ID: " + friends1.friendId);
          foundMutual = true;
          break;
        }
        friends2 = friends2.next;
      }
      friends1 = friends1.next;
    }
    if (!foundMutual) {
      System.out.println("No mutual friends found.");
    }
  }

  // Method to display all friends of a specific user
  public void displayFriends(int userId) {
    UserNode user = findUserById(userId);
    if (user == null) {
      System.out.println("User not found.");
      return;
    }

    FriendNode currentFriend = user.friends;
    System.out.println("Friends of " + user.name + ":");
    while (currentFriend != null) {
      UserNode friend = findUserById(currentFriend.friendId);
      if (friend != null) {
        System.out.println("Friend ID: " + friend.userId + ", Name: " + friend.name);
      }
      currentFriend = currentFriend.next;
    }
  }

  // Method to count the number of friends for a specific user
  public void countFriends(int userId) {
    UserNode user = findUserById(userId);
    if (user == null) {
      System.out.println("User not found.");
      return;
    }

    int count = 0;
    FriendNode currentFriend = user.friends;
    while (currentFriend != null) {
      count++;
      currentFriend = currentFriend.next;
    }
    System.out.println(user.name + " has " + count + " friends.");
  }

  // Method to display all users
  public void displayAllUsers() {
    UserNode current = head;
    while (current != null) {
      System.out.println("User ID: " + current.userId + ", Name: " + current.name + ", Age: " + current.age);
      current = current.next;
    }
  }
}

// Main class to test the Social Media Friend Connections system
public class SocialMedia {
  public static void main(String[] args) {
    SinglyLinkedList1 userList = new SinglyLinkedList1();

    // Adding users to the system
    userList.addUser(1, "Alice", 25);
    userList.addUser(2, "Bob", 30);
    userList.addUser(3, "Charlie", 22);
    userList.addUser(4, "David", 28);

    // Adding some friend connections
    userList.addFriend(1, 2);
    userList.addFriend(1, 3);
    userList.addFriend(2, 4);

    // Displaying all users
    userList.displayAllUsers();

    // Display friends of Alice
    userList.displayFriends(1);

    // Find mutual friends between Alice and Bob
    userList.findMutualFriends(1, 2);

    // Count friends of Bob
    userList.countFriends(2);

    // Remove a friend connection between Alice and Charlie
    userList.removeFriend(1, 3);

    // Display friends of Alice after removal
    userList.displayFriends(1);
  }
}
