

import java.util.Arrays;

public class HeapSortJobApplicants {

    private static void heapify(double[] salaries, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if left child exists and is greater than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // Check if right child exists and is greater than the current largest
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            double temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }

    // Function to perform Heap Sort
    public static void heapSort(double[] salaries) {
        int n = salaries.length;

        // Build a Max Heap (rearrange the array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements one by one from heap
        for (int i = n - 1; i > 0; i--) {
            // Swap current root (max) with the last element
            double temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Call heapify on the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Main method to test Heap Sort
    public static void main(String[] args) {
        double[] salaryDemands = {55000, 75000, 48000, 63000, 72000, 51000};

        System.out.println("Original Salary Demands: " + Arrays.toString(salaryDemands));
        heapSort(salaryDemands);
        System.out.println("Sorted Salary Demands: " + Arrays.toString(salaryDemands));
    }
}
