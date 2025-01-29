// Node class representing each process in the round-robin scheduling
class ProcessNode {
  int processId;
  int burstTime;
  int priority;
  ProcessNode next;

  // Constructor to initialize a new process node
  ProcessNode(int processId, int burstTime, int priority) {
    this.processId = processId;
    this.burstTime = burstTime;
    this.priority = priority;
    this.next = null;
  }
}

// CircularLinkedList class to manage processes in the round-robin scheduling algorithm
class CircularLinkedList1 {
  ProcessNode head;
  ProcessNode tail;

  // Constructor to initialize the circular linked list
  CircularLinkedList1() {
    this.head = null;
    this.tail = null;
  }

  // Method to add a new process at the end of the circular list
  public void addProcess(int processId, int burstTime, int priority) {
    ProcessNode newNode = new ProcessNode(processId, burstTime, priority);

    if (head == null) {
      head = tail = newNode;
      newNode.next = head; // Circular link
    } else {
      tail.next = newNode;
      newNode.next = head;
      tail = newNode;
    }
  }

  // Method to remove a process by Process ID after its execution
  public void removeProcess(int processId) {
    if (head == null) {
      System.out.println("\nNo processes to remove.");
      return;
    }

    ProcessNode current = head;
    ProcessNode prev = null;

    // Traverse the list to find the process to be removed
    do {
      if (current.processId == processId) {
        if (current == head && current == tail) {
          // Only one process in the list
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
    } while (current != head);

    System.out.println("\nProcess with ID " + processId + " not found.");
  }

  // Method to simulate the round-robin scheduling of processes with a fixed time quantum
  public void roundRobinScheduling(int timeQuantum) {
    if (head == null) {
      System.out.println("\nNo processes to schedule.");
      return;
    }

    ProcessNode current = head;
    int totalWaitingTime = 0;
    int totalTurnaroundTime = 0;
    int numProcesses = 0;

    while (head != null) {  // Ensure we loop until all processes are executed and removed
      numProcesses++;
      int initialBurstTime = current.burstTime;

      // Simulate execution of the process
      if (current.burstTime > timeQuantum) {
        current.burstTime -= timeQuantum;
        totalWaitingTime += timeQuantum;
        totalTurnaroundTime += (timeQuantum + (initialBurstTime - current.burstTime));
        current = current.next;
      } else {
        totalWaitingTime += current.burstTime;
        totalTurnaroundTime += (initialBurstTime);
        System.out.println("Process " + current.processId + " executed and removed from the list.");
        removeProcess(current.processId);  // Remove the current process after execution
        // Avoid null reference; update current to the next process or null if the list is empty
        current = head != null ? head : null; // Move to the next process or null if the list is empty
      }

      // Display the current state of the process queue after each round
      displayProcesses();
    }

    System.out.println("\nAverage Waiting Time: " + (double) totalWaitingTime / numProcesses);
    System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / numProcesses);
  }

  // Method to display the processes in the circular list
  public void displayProcesses() {
    if (head == null) {
      System.out.println("\nNo processes available.");
      return;
    }

    ProcessNode current = head;
    System.out.println("\nProcesses in the Round Robin queue:");
    do {
      System.out.println("Process ID: " + current.processId + ", Burst Time: " + current.burstTime +
              ", Priority: " + current.priority);
      current = current.next;
    } while (current != head);
  }
}

// Main class to test the Round Robin Scheduling Algorithm
public class RoundRobinScheduling {
  public static void main(String[] args) {
    CircularLinkedList1 processQueue = new CircularLinkedList1();

    // Add processes to the queue
    processQueue.addProcess(1, 8, 3); // Process 1 with burst time 8
    processQueue.addProcess(2, 4, 2); // Process 2 with burst time 4
    processQueue.addProcess(3, 6, 1); // Process 3 with burst time 6
    processQueue.addProcess(4, 5, 4); // Process 4 with burst time 5

    // Display initial process queue
    processQueue.displayProcesses();

    // Simulate the round-robin scheduling with a time quantum of 4
    processQueue.roundRobinScheduling(4);

    // Display the final state of the process queue
    processQueue.displayProcesses();
  }
}
