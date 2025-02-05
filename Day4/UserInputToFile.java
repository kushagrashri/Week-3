import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        // Define the file to store user input
        String filePath = "user_input.txt";

        try (
            // Input stream reader to read from the console
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            // FileWriter to write to the file (true for append mode)
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw)
        ) {
            System.out.println("Enter text to write to the file (type 'exit' to stop):");

            String inputLine;
            while (true) {
                inputLine = br.readLine(); // Read user input
                if ("exit".equalsIgnoreCase(inputLine)) { // Stop when "exit" is entered
                    break;
                }
                bw.write(inputLine); // Write input to file
                bw.newLine(); // Add new line
            }

            System.out.println("User input has been saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Error handling file: " + e.getMessage());
        }
    }
}
