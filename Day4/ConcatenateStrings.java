// Program to efficiently concatenate an array of strings using StringBuffer
public class ConcatenateStrings {
    public static void main(String[] args) {
        // Define an array of strings to be concatenated
        String[] str = {"My", " ", "name", " ", "is", " ", "kushagra", "."};

        // Create a StringBuffer object for efficient string manipulation
        StringBuffer sb = new StringBuffer();

        // Iterate through each string in the array
        for (String word : str) {
            sb.append(word); // Append each word to StringBuffer
        }

        // Print the concatenated string
        System.out.println("Concatenated String: " + sb);
    }
}
