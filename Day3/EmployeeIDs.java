
import java.util.Arrays;
public class EmployeeIDs {



        // Function to perform Insertion Sort
        public static void insertionSort(int[] employeeIDs) {
            int n = employeeIDs.length;

            for (int i = 1; i < n; i++) {
                int key = employeeIDs[i];
                int j = i - 1;

                // Shift elements that are greater than key to the right
                while (j >= 0 && employeeIDs[j] > key) {
                    employeeIDs[j + 1] = employeeIDs[j];
                    j--;
                }

                // Insert key at the correct position
                employeeIDs[j + 1] = key;
            }
        }

        // Main method to test the sorting
        public static void main(String[] args) {
            int[] employeeIDs = {105, 102, 110, 101, 108, 103};

            System.out.println("Original Employee IDs: " + Arrays.toString(employeeIDs));
            insertionSort(employeeIDs);
            System.out.println("Sorted Employee IDs: " + Arrays.toString(employeeIDs));
        }
    }

