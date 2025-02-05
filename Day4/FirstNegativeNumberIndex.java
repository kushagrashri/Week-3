// Class to find the index of the first negative number in an array
public class FirstNegativeNumberIndex {

    // Method to find the index of the first negative number in the given array
    public static int firstNegativeNumber(int[] arr) {
        int n = arr.length; // Get the length of the array

        // Loop through each element in the array
        for (int i = 0; i < n; i++) {
            // Check if the current element is negative
            if (arr[i] < 0) {
                return i; // Return the index of the first negative number
            }
        }
        return -1; // Return -1 if no negative number is found
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Define an array of integers
        int[] numbers = {4, 8, 6, 2, 5, -9, 11};

        // Call the method to find the index of the first negative number
        int index = firstNegativeNumber(numbers);

        // Print the result
        System.out.println("The index of the first negative number is: " + index);
    }
}
