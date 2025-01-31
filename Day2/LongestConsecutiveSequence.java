import java.util.HashSet;

class LongestConsecutiveSequence {
  public static int findLongestConsecutive(int[] nums) {
    if (nums.length == 0)
      return 0;

    HashSet<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num); // Store all numbers in HashSet
    }

    int maxLength = 0;

    for (int num : numSet) {
      // Check if 'num' is the start of a sequence
      if (!numSet.contains(num - 1)) {
        int currentNum = num;
        int currentLength = 1;

        // Expand sequence to the right
        while (numSet.contains(currentNum + 1)) {
          currentNum++;
          currentLength++;
        }

        // Update max length
        maxLength = Math.max(maxLength, currentLength);
      }
    }

    return maxLength;
  }

  public static void main(String[] args) {
    int[] arr = { 100, 4, 200, 1, 3, 2 };
    System.out.println("Longest Consecutive Sequence Length: " + findLongestConsecutive(arr));
  }
}
