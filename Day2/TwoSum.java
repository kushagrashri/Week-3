import java.util.HashMap;

class TwoSum {
  public static int[] twoSum(int[] nums, int target) {
    // HashMap to store number and its corresponding index
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];

      // If complement exists in map, return the indices
      if (map.containsKey(complement)) {
        return new int[] { map.get(complement), i };
      }

      // Store current number with its index
      map.put(nums[i], i);
    }

    // Return empty array if no solution is found
    return new int[] {};
  }

  public static void main(String[] args) {
    int[] nums = { 2, 7, 11, 15 };
    int target = 9;

    int[] result = twoSum(nums, target);
    if (result.length > 0) {
      System.out.println("Indices: " + result[0] + ", " + result[1]);
    } else {
      System.out.println("No solution found");
    }
  }
}
