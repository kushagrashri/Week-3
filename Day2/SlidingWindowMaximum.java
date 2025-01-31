import java.util.LinkedList;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static int[] getSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        // Array to store the maximums of each sliding window
        int[] result = new int[n - k + 1];
        // Deque to store indices of array elements, the largest element is at the front
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove indices from the front if they are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements from the back of the deque that are smaller than the current element
            // They can't be part of the maximum for the current or future windows
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the deque
            deque.offerLast(i);

            // If the current index is at least k-1, then the window is valid
            // Store the maximum for this window, which is at the front of the deque
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {61, 30, 51, 93, 58, 39, 65, 70};
        int k = 3;

        // Call the function to get the sliding window maximums
        int[] result = getSlidingWindow(arr, k);

        // Print the result
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
