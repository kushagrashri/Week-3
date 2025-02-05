import java.io.*;

public class ByteToCharacterStream {
    public static void main(String[] args) {
        // Define the file path (change this to your actual file path)
        String filePath = "example.txt";

        try (
            // Step 1: Create a FileInputStream to read the binary data from the file
            FileInputStream fis = new FileInputStream(filePath);

            // Step 2: Wrap FileInputStream in InputStreamReader to convert bytes to characters
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

            // Step 3: Use BufferedReader for efficient character reading
            BufferedReader br = new BufferedReader(isr)
        ) {
            String line;
            // Step 4: Read and print the file line by line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
