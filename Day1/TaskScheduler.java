// Node class representing each task in the circular linked list
class TaskNode {
  int taskId;
  String taskName;
  int priority;
  String dueDate;
  TaskNode next;

  // Constructor to initialize a new task node
  TaskNode(int taskId, String taskName, int priority, String dueDate) {
      this.taskId = taskId;
      this.taskName = taskName;
      this.priority = priority;
      this.dueDate = dueDate;
      this.next = null;
  }
}

// CircularLinkedList class to manage tasks
class CircularLinkedList {
  TaskNode head;
  TaskNode tail;
  TaskNode currentTask; // Pointer to track the current task

  // Constructor to initialize the circular linked list
  CircularLinkedList() {
      this.head = null;
      this.tail = null;
      this.currentTask = null;
  }

  // Method to add a task at the beginning
  public void addToFirst(int taskId, String taskName, int priority, String dueDate) {
      TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);

      if (head == null) {
          head = tail = newNode;
          newNode.next = head; // Circular link
      } else {
          newNode.next = head;
          tail.next = newNode; // Maintain circular nature
          head = newNode;
      }
  }

  // Method to add a task at the end
  public void addToLast(int taskId, String taskName, int priority, String dueDate) {
      TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);

      if (head == null) {
          head = tail = newNode;
          newNode.next = head;
      } else {
          tail.next = newNode;
          newNode.next = head;
          tail = newNode;
      }
  }

  // Method to add a task after a specific task ID
  public void addInBetween(int taskId, int newTaskId, String taskName, int priority, String dueDate) {
      if (head == null) {
          System.out.println("\nTask list is empty.");
          return;
      }

      TaskNode current = head;
      while (current != null) {
          if (current.taskId == taskId) {
              TaskNode newNode = new TaskNode(newTaskId, taskName, priority, dueDate);
              newNode.next = current.next;
              current.next = newNode;

              if (current == tail) { // If inserted at the end, update tail
                  tail = newNode;
              }

              return;
          }
          current = current.next;
          if (current == head) break; // Prevent infinite loop in circular list
      }

      System.out.println("\nTask with ID " + taskId + " not found.");
  }

  // Method to remove a task by Task ID
  public void removeByTaskId(int taskId) {
      if (head == null) {
          System.out.println("\nNo tasks to remove.");
          return;
      }

      TaskNode current = head;
      TaskNode prev = null;

      while (current != null) {
          if (current.taskId == taskId) {
              if (current == head && current == tail) {
                  // Only one node in the list
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
              return;
          }
          prev = current;
          current = current.next;
          if (current == head)
          break; // Prevent infinite loop in circular list
      }

      System.out.println("\nTask with ID " + taskId + " not found.");
  }

  // Method to view the current task and move to the next task
  public void viewCurrentTask() {
      if (head == null) {
          System.out.println("\nNo tasks available.");
          return;
      }

      if (currentTask == null) {
          currentTask = head;
      }

      System.out.println("\nCurrent Task:");
      System.out.println("ID: " + currentTask.taskId + ", Name: " + currentTask.taskName +
              ", Priority: " + currentTask.priority + ", Due Date: " + currentTask.dueDate);

      // Move to the next task (circular movement)
      currentTask = currentTask.next;
  }

  // Method to display all tasks in the list
  public void displayForward() {
      if (head == null) {
          System.out.println("\nNo tasks available.");
          return;
      }

      System.out.println("\nTask List:");
      TaskNode current = head;
      while (current != null) {
          System.out.println("ID: " + current.taskId + ", Name: " + current.taskName +
                  ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
          current = current.next;
          if (current == head) break; // Prevent infinite loop in circular list
      }
  }

  // Method to search for tasks by Priority
  public void searchByPriority(int priority) {
      if (head == null) {
          System.out.println("\nNo tasks available.");
          return;
      }

      TaskNode current = head;
      boolean found = false;

      while (current != null) {
          if (current.priority == priority) {
              System.out.println("\nTask Found: ID: " + current.taskId + ", Name: " + current.taskName +
                      ", Due Date: " + current.dueDate);
              found = true;
          }
          current = current.next;
          if (current == head)
          break; // Prevent infinite loop in circular list
      }

      if (!found) {
          System.out.println("\nNo tasks found with priority " + priority + ".");
      }
  }
}

// Main class to test the Task Scheduler
public class TaskScheduler {
  public static void main(String[] args) {
      CircularLinkedList taskList = new CircularLinkedList();

      // Adding tasks
      taskList.addToFirst(1, "Complete Assignment", 3, "2025-02-01");
      taskList.addToLast(2, "Prepare for Interview", 5, "2025-02-10");
      taskList.addInBetween(1, 3, "Submit Project", 4, "2025-02-05");

      // Displaying tasks
      taskList.displayForward();

      // Searching for tasks by priority
      taskList.searchByPriority(3);

      // Viewing current task and moving to the next
      taskList.viewCurrentTask();
      taskList.viewCurrentTask();

      // Removing a task
      taskList.removeByTaskId(2);
      taskList.displayForward();
  }
}