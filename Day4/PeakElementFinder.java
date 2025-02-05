
public class PeakElementFinder {

    // Method to find a peak element index
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        // Perform Binary Search
        while (left < right) {
            int mid = left + (right - left) / 2; // Calculate mid index

            // If the mid element is smaller than the next element,
            // then the peak must be in the right half
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } 
            // Otherwise, the peak must be in the left half (or mid itself)
            else {
                right = mid;
            }
        }
        return left; // The left index will point to a peak element
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Example array
        int[] arr = {1, 3, 7, 8, 6, 4, 10, 2};

        // Find the peak element index
        int peakIndex = findPeakElement(arr);

        // Print the result
        System.out.println("A peak element is at index: " + peakIndex);
        System.out.println("The peak element is: " + arr[peakIndex]);
    }
}
