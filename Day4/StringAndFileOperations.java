import java.io.*;
import java.util.StringTokenizer;

public class StringAndFileOperations {

    // Method to test StringBuilder performance
    public static void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        String str = "hello";

        long startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            sb.append(str);
        }
        long endTime = System.nanoTime();

        System.out.println("StringBuilder Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    // Method to test StringBuffer performance
    public static void testStringBuffer() {
        StringBuffer sb = new StringBuffer();
        String str = "hello";

        long startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            sb.append(str);
        }
        long endTime = System.nanoTime();

        System.out.println("StringBuffer Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    // Method to count words using FileReader
    public static void countWordsUsingFileReader(String filePath) {
        long startTime = System.currentTimeMillis();
        int wordCount = 0;

        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("FileReader Word Count: " + wordCount);
        System.out.println("FileReader Time: " + (endTime - startTime) + " ms");
    }

    // Method to count words using InputStreamReader
    public static void countWordsUsingInputStreamReader(String filePath) {
        long startTime = System.currentTimeMillis();
        int wordCount = 0;

        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("InputStreamReader Word Count: " + wordCount);
        System.out.println("InputStreamReader Time: " + (endTime - startTime) + " ms");
    }

    // Main method to run the tests
    public static void main(String[] args) {
        // Test StringBuilder and StringBuffer
        testStringBuilder();
        testStringBuffer();

        // Provide the path to a large file (e.g., 100MB text file)
        String filePath = "largefile.txt";  // Change this to the actual file path

        // Test FileReader and InputStreamReader performance
        countWordsUsingFileReader(filePath);
        countWordsUsingInputStreamReader(filePath);
    }
}
