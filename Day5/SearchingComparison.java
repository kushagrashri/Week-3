import java.util.*;

public class SearchingComparison {

    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        Random random = new Random();

        for (int size : sizes) {
            int[] arr = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                int num = random.nextInt(size * 10);
                arr[i] = num;
                hashSet.add(num);
                treeSet.add(num);
            }

            int target = arr[random.nextInt(size)];

            System.out.println("DataSet Size: " + size);

            long start = System.nanoTime();
            linearSearch(arr, target);
            long end = System.nanoTime();
            System.out.println("Array Search Time: " + (end - start) / 1000000.0 + " ms");

            start = System.nanoTime();
            hashSet.contains(target);
            end = System.nanoTime();
            System.out.println("HashSet Search Time: " + (end - start) / 1000000.0 + " ms");

            start = System.nanoTime();
            treeSet.contains(target);
            end = System.nanoTime();
            System.out.println("TreeSet Search Time: " + (end - start) / 1000000.0 + " ms");

        }
    }
}
