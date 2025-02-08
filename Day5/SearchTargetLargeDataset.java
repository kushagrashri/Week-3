import java.util.Arrays;
import java.util.Random;

public class SearchTargetLargeDataset {

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) { // If target is found, return index
                return i;
            }
        }
        return -1; // Target not found
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2; // Calculate mid index

            if (arr[mid] == target) { // Target found at mid
                return mid;
            }
            if (target > arr[mid]) { // Search in the right half
                start = mid + 1;
            } else { // Search in the left half
                end = mid - 1;
            }
        }
        return -1; // Target not found
    }

    // Generates a dataset with random numbers of the given size
    private static int[] generateDataset(int size, Random r) {
        int[] dataset = new int[size];
        for (int i = 0; i < size; i++) {
            dataset[i] = (int) (Math.random() * size); // Assign random values
        }
        return dataset;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10_000, 1_000_000}; // Different dataset sizes
        Random r = new Random();

        for (int size : sizes) {
            int[] dataset = generateDataset(size, r); // Generate dataset
            int target = (int) (Math.random() * size); // Select a random target

            // Measure time for Linear Search
            long start = System.nanoTime();
            linearSearch(dataset, target);
            long linearTime = System.nanoTime() - start;

            Arrays.sort(dataset); // Sorting is required for Binary Search

            // Measure time for Binary Search
            start = System.nanoTime();
            binarySearch(dataset, target);
            long binaryTime = System.nanoTime() - start;

            // Print results
            System.out.println("Dataset size: " + size);
            System.out.println("Target: " + target);
            System.out.println("Linear search took " + linearTime + " ns");
            System.out.println("Binary search took " + binaryTime + " ns");
            System.out.println();
        }
    }
}
