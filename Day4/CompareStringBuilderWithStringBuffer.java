public class CompareStringBuilderWithStringBuffer {
    public static void main(String[] args) {
        // Measure the start time for StringBuffer
        long startTimeBuffer = System.nanoTime();
        // Create a new instance of StringBuffer
        StringBuffer sbf = new StringBuffer();

        for (int i = 0; i < 100000; i++) {
            sbf.append("Hello");
        }
        // Measure the end time for StringBuffer
        long endTimeBuffer = System.nanoTime();
        // Calculate the duration taken by StringBuffer
        long durationBuffer = endTimeBuffer - startTimeBuffer;

        // Measure the start time for StringBuilder
        long startTimeBuilder = System.nanoTime();
        // Create a new instance of StringBuilder
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 100000; i++) {
            sb.append("Hello");
        }
        // Measure the end time for StringBuilder
        long endTimeBuilder = System.nanoTime();
        // Calculate the duration taken by StringBuilder
        long durationBuilder = endTimeBuilder - startTimeBuilder;

        // Print the time taken by StringBuffer in nanoseconds
        System.out.println("Time taken by StringBuffer: " + durationBuffer + " ns");
        // Print the time taken by StringBuilder in nanoseconds
        System.out.println("Time taken by StringBuilder: " + durationBuilder + " ns");
    }
}
