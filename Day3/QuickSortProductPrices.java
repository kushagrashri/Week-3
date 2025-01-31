

import java.util.Arrays;

public class QuickSortProductPrices {
    // Function to partition the array
    private static int partition(double[] prices, int low, int high) {
        double pivot = prices[high]; // Choosing the last element as pivot
        int i = low - 1; // Pointer for the smaller element

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                // Swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap pivot with the element at i+1 (correct position for pivot)
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1; // Return the pivot index
    }

    // Recursive Quick Sort function
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);

            // Recursively sort left and right subarrays
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    // Main method to test Quick Sort
    public static void main(String[] args) {
        double[] productPrices = {499.99, 150.75, 299.50, 199.00, 399.25};

        System.out.println("Original Product Prices: " + Arrays.toString(productPrices));
        quickSort(productPrices, 0, productPrices.length - 1);
        System.out.println("Sorted Product Prices: " + Arrays.toString(productPrices));
    }
}
