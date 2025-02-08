import java.io.*;

public class LargeFileReaderBenchmark {
    private static final String FILE_PATH = "largefile1.txt"; // Replace with actual file path

    public static void main(String[] args) throws IOException {
        System.out.println("FileReader Time: " + measureFileReaderTime() + " ms");
        System.out.println("InputStreamReader Time: " + measureInputStreamReaderTime() + " ms");
    }

    private static long measureFileReaderTime() throws IOException {
        long start = System.currentTimeMillis();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            while (reader.read() != -1) {} // Read character by character
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureInputStreamReaderTime() throws IOException {
        long start = System.currentTimeMillis();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(FILE_PATH))) {
            while (reader.read() != -1) {} // Read character by character
        }
        return System.currentTimeMillis() - start;
    }
}
