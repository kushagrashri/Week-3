

import java.util.Arrays;

public class ArrayofBookPrices {


        // Function to merge two sorted halves
        private static void merge(double[] prices, int left, int mid, int right) {
            int n1 = mid - left + 1;
            int n2 = right - mid;

            // Create temporary arrays
            double[] leftArray = new double[n1];
            double[] rightArray = new double[n2];

            // Copy data to temporary arrays
            System.arraycopy(prices, left, leftArray, 0, n1);
            System.arraycopy(prices, mid + 1, rightArray, 0, n2);

            // Merge the sorted halves
            int i = 0, j = 0, k = left;
            while (i < n1 && j < n2) {
                if (leftArray[i] <= rightArray[j]) {
                    prices[k++] = leftArray[i++];
                } else {
                    prices[k++] = rightArray[j++];
                }
            }

            // Copy remaining elements of leftArray
            while (i < n1) {
                prices[k++] = leftArray[i++];
            }

            // Copy remaining elements of rightArray
            while (j < n2) {
                prices[k++] = rightArray[j++];
            }
        }

        // Recursive function to perform Merge Sort
        public static void mergeSort(double[] prices, int left, int right) {
            if (left < right) {
                int mid = left + (right - left) / 2;

                // Recursively sort both halves
                mergeSort(prices, left, mid);
                mergeSort(prices, mid + 1, right);

                // Merge the sorted halves
                merge(prices, left, mid, right);
            }
        }

        // Main method to test sorting
        public static void main(String[] args) {
            double[] bookPrices = {399.99, 199.50, 299.75, 499.00, 150.25};

            System.out.println("Original Book Prices: " + Arrays.toString(bookPrices));
            mergeSort(bookPrices, 0, bookPrices.length - 1);
            System.out.println("Sorted Book Prices: " + Arrays.toString(bookPrices));
        }
    }

