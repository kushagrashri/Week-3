

import java.util.Arrays;

public class CountingSortStudentAges {
    // Function to perform Counting Sort
    public static void countingSort(int[] ages, int minAge, int maxAge) {
        int range = maxAge - minAge + 1; // Age range (10 to 18)
        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Step 1: Count the occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 2: Compute cumulative frequencies
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place elements in correct positions
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--; // Reduce count for stability
        }

        // Copy sorted values back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    // Main method to test the sorting
    public static void main(String[] args) {
        int[] studentAges = {12, 14, 11, 10, 18, 13, 16, 14, 17, 12};

        System.out.println("Original Student Ages: " + Arrays.toString(studentAges));
        countingSort(studentAges, 10, 18);
        System.out.println("Sorted Student Ages: " + Arrays.toString(studentAges));
    }
}