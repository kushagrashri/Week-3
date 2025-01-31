import java.util.*;

class ZeroSumSubarrays {
  public static List<int[]> findZeroSumSubarrays(int[] arr) {
    List<int[]> result = new ArrayList<>();
    Map<Integer, List<Integer>> sumMap = new HashMap<>();
    int prefixSum = 0;

    // Initialize the HashMap with a default sum of 0 at index -1
    sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));

    for (int i = 0; i < arr.length; i++) {
      prefixSum += arr[i]; // Compute prefix sum

      // If prefixSum is already in map, we found a zero-sum subarray
      if (sumMap.containsKey(prefixSum)) {
        List<Integer> indices = sumMap.get(prefixSum);
        for (int start : indices) {
          result.add(new int[] { start + 1, i }); // Store subarray (start+1 to i)
        }
      }

      // Store this prefix sum in the map
      sumMap.putIfAbsent(prefixSum, new ArrayList<>());
      sumMap.get(prefixSum).add(i);
    }

    return result;
  }

  public static void main(String[] args) {
    int[] arr = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
    List<int[]> subarrays = findZeroSumSubarrays(arr);

    System.out.println("Zero-Sum Subarrays:");
    for (int[] subarray : subarrays) {
      System.out.println("Start: " + subarray[0] + ", End: " + subarray[1]);
    }
  }
}
