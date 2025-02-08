import java.util.Arrays;
import java.util.Random;

public class SortingTimeComparison {
    // Generates a random array of integers
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size );
        }
        return array;
    }

    // Bubble Sort (O(N²))
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort (O(N log N))
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    // Helper method to merge two halves in Merge Sort
    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        //copy data to temporary arrays
        for(int i=0;i<n1;i++){
            leftArray[i] = array[left+i];
        }
        for(int j=0;j<n2;j++){
            rightArray[j] = array[mid+1+j];
        }

        //merge both left array and right array
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        //copy any remaining element from left array
        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        //copy any remaining element from right array
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    // Quick Sort (O(N log N))
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // Partition method for Quick Sort
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                //swap
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        //swap the pivot elem
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
    public static void main(String[] args) {
        // Dataset sizes for comparison
        int[] datasetSizes = {1000, 10000, 1000000};
        Random random = new Random();

        for (int size : datasetSizes) {
            System.out.println("Dataset Size: " + size);

            //generate random array
            int[] data = generateRandomArray(size);

            // Bubble Sort (O(N²)) :Case1
            if (size <= 10000) {
                int[] bubbleData = Arrays.copyOf(data, data.length);
                long bubbleStartTime = System.nanoTime();
                bubbleSort(bubbleData);
                long bubbleEndTime = System.nanoTime();
                System.out.println("Bubble Sort Time: " + (bubbleEndTime - bubbleStartTime) / 1000000.0 + " ms");
            } else {
                // Bubble Sort is infeasible for large datasets
                System.out.println("Bubble Sort Time: Unfeasible for large datasets");
            }

            // Merge Sort (O(N log N)):Case2
            int[] mergeData = Arrays.copyOf(data, data.length);
            long mergeStartTime = System.nanoTime();
            mergeSort(mergeData, 0, mergeData.length - 1);
            long mergeEndTime = System.nanoTime();
            System.out.println("Merge Sort Time is: " + (mergeEndTime - mergeStartTime) / 1000000.0 + " ms");

            // Quick Sort (O(N log N)) : Case3
            int[] quickData = Arrays.copyOf(data, data.length);
            long quickStartTime = System.nanoTime();
            quickSort(quickData, 0, quickData.length - 1);
            long quickEndTime = System.nanoTime();
            System.out.println("Quick Sort Time is: " + (quickEndTime - quickStartTime) / 1000000.0 + " ms");
        }
    }


}