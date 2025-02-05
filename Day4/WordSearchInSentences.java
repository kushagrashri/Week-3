// Program to search for a specific word in a list of sentences using Linear Search
public class WordSearchInSentences {

    // Method to find the first sentence containing the specific word
    public static String searchWordInSentences(String[] sentences, String word) {
        // Iterate through each sentence in the array
        for (String sentence : sentences) {
            // Check if the sentence contains the given word
            if (sentence.contains(word)) {
                return sentence; // Return the first matching sentence
            }
        }
        return "Not Found"; // Return "Not Found" if the word is not in any sentence
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Define an array of sentences
        String[] sentences = {
            "My name is kushagra shri sharma.",
            "I study in Technocrats Institute of Technology."
        };

        // Word to search for
        String searchWord = "study";

        // Call the method and store the result
        String result = searchWordInSentences(sentences, searchWord);

        // Print the result
        System.out.println("Result: " + result);
    }
}
