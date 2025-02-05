import java.util.Arrays;

public class SearchOperations {

    // Method to find the first missing positive integer using Linear Search
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Mark negative and out-of-bound values
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1; // Assign an out-of-bound value
            }
        }

        // Step 2: Mark numbers as visited using index mapping
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val > 0 && val <= n) {
                nums[val - 1] = -Math.abs(nums[val - 1]); // Mark index as visited
            }
        }

        // Step 3: Find the first unmarked (positive) index
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1; // If all elements are present, return the next number
    }

    // Method to perform binary search on a sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        // Perform Binary Search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }
        return -1; // Target not found
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Example list of numbers
        int[] numbers = {3, 4, -1, 1, 2, 5, 6, 8};
        int target = 5;

        // Find first missing positive integer
        int missingNumber = findFirstMissingPositive(numbers);
        System.out.println("The first missing positive integer is: " + missingNumber);

        // Sort the array for Binary Search
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        // Find target index using Binary Search
        int targetIndex = binarySearch(numbers, target);
        System.out.println("The index of target " + target + " is: " + targetIndex);
    }
}
