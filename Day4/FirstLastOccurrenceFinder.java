// Program to find the first and last occurrence of an element in a sorted array using Binary Search
public class FirstLastOccurrenceFinder {

    // Method to find the first occurrence of the target element
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int first = -1; // Default to -1 if not found

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate mid index

            if (arr[mid] == target) {
                first = mid; // Store the index
                right = mid - 1; // Search the left half for earlier occurrences
            } else if (arr[mid] < target) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }
        return first;
    }

    // Method to find the last occurrence of the target element
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int last = -1; // Default to -1 if not found

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate mid index

            if (arr[mid] == target) {
                last = mid; // Store the index
                left = mid + 1; // Search the right half for later occurrences
            } else if (arr[mid] < target) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }
        return last;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Example sorted array
        int[] arr = {2, 4, 4, 4, 6, 8, 10};

        // Target value to search for
        int target = 4;

        // Find first and last occurrence
        int firstIndex = findFirstOccurrence(arr, target);
        int lastIndex = findLastOccurrence(arr, target);

        // Print the result
        System.out.println("First occurrence of " + target + " is at index: " + firstIndex);
        System.out.println("Last occurrence of " + target + " is at index: " + lastIndex);
    }
}
