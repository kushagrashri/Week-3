// Program to search for a target value in a 2D sorted matrix using Binary Search
public class Search2DMatrix {

    // Method to perform binary search in a 2D matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) return false; // Edge case: Empty matrix
        int cols = matrix[0].length;

        int left = 0, right = (rows * cols) - 1;

        // Perform Binary Search
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate mid index
            int row = mid / cols; // Convert 1D index to row index
            int col = mid % cols; // Convert 1D index to column index
            int midValue = matrix[row][col]; // Get the actual value at mid

            if (midValue == target) {
                return true; // Target found
            } else if (midValue < target) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }

        return false; // Target not found
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Example 2D sorted matrix
        int[][] matrix = {
            {1, 3, 5},
            {7, 10, 12},
            {14, 18, 21}
        };

        // Target value to search for
        int target = 10;

        // Call the search method and store the result
        boolean found = searchMatrix(matrix, target);

        // Print the result
        System.out.println("Target " + target + " found: " + found);
    }
}
