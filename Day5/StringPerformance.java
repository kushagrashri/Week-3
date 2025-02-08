import static java.lang.System.out;

public class StringPerformance {

    public static void runBenchmark(int iterations) {
        out.println(" String:ms "+ stringConcatenation(iterations));
        out.println(" StringBuilder:ms "+ stringBuilderConcatenation(iterations));
        out.println(" StringBuffer:ms "+ stringBufferConcatenation(iterations));
    }

    public static double stringConcatenation(int iterations) {
        long startTime = System.nanoTime();
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "a";
        }
        long endTime = System.nanoTime();
        // Convert nanoseconds to seconds
        return (endTime - startTime) / 1000000.0;
    }

    public static double stringBuilderConcatenation(int iterations) {
        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < iterations; i++) {
            stringBuilder.append("a");
        }
        // Ensure the string is materialized
        stringBuilder.toString();
        long endTime = System.nanoTime();
        // Convert nanoseconds to seconds
        return (endTime - startTime) / 1000000.0;
    }

    public static double stringBufferConcatenation(int iterations) {
        long startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append("a");
        }
        // Ensure the string is materialized
        stringBuffer.toString();
        long endTime = System.nanoTime();
        return (double)(endTime - startTime) / 1000000.0; // Convert nanoseconds to seconds
    }
    public static void main(String[] args) {
        int[] iterations = {1000, 10000, 1000000};

        out.println("String Concatenation Performance");


        for (int iterationCount : iterations) {
            out.println("Iterations: " + iterationCount);
            runBenchmark(iterationCount);
        }
    }
}