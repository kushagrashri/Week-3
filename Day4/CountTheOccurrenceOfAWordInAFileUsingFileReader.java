import java.io.BufferedReader;
import java.io.FileReader;

public class CountTheOccurrenceOfAWordInAFileUsingFileReader {
    public static void main(String[] args) {

        try{
            String filePath = "Sample.txt";
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            String target = "name";
            int count = 0;
            String regex = "[,\\s\\.]";
            while((line = br.readLine()) != null){
                String[] arr = line.split(regex);
                for(String word : arr){
                    if(word.toLowerCase().equals(target)){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}