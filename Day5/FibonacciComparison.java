public class FibonacciComparison {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] testValues = {10, 30, 50};

        for (int n : testValues) {
            System.out.println(" Fibonacci N: " + n);

            long start = System.nanoTime();

            long end = System.nanoTime();
            System.out.println("Recursive Fibonacci Time: " + (end - start) / 1000000.0 + " ms");

            start = System.nanoTime();
            int iterativeResult = fibonacciIterative(n);
            end = System.nanoTime();
            System.out.println("Iterative Fibonacci Time: " + (end - start) / 1000000.0 + " ms");
        }
    }
}
