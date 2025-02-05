public class RotationPointFinder {

    // Method to find the index of the smallest element in a rotated sorted array
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        // Perform Binary Search
        while (left < right) {
            int mid = left + (right - left) / 2; // Calculate mid index

            // If middle element is greater than the rightmost element,
            // then the rotation point is in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } 
            // Otherwise, the rotation point is in the left half
            else {
                right = mid;
            }
        }
        return left; // The left index will point to the smallest element
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Example rotated sorted array
        int[] rotatedArray = {6, 7, 9, 15, 19, 2, 3};

        // Find the index of the rotation point
        int rotationIndex = findRotationPoint(rotatedArray);

        // Print the result
        System.out.println("The rotation point is at index: " + rotationIndex);
        System.out.println("The smallest element is: " + rotatedArray[rotationIndex]);
    }
}
