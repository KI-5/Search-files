package src;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileSearcher implements Runnable {
    //File to search
    private final File file;
    //Keyword to search for
    private final String keyword;

    /*Parameterised constructor
     * @param file - file to search
     * @param keyword - keyword to search for
     */
    public FileSearcher(File file, String keyword) {
        this.file = file;
        this.keyword = keyword;
    }

    @Override
    public void run() {
        //Search for the keyword in the file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String lineWithKeyword;
            int lineNumber = 0;

            while ((lineWithKeyword = reader.readLine()) != null) {
                lineNumber++;
                //If the line contains the keyword, print the line
                if (lineWithKeyword.contains(keyword)) {
                    System.out.printf("Found in %s [Line %d]: %s%n", file.getName(), lineNumber, lineWithKeyword.trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + file.getName());
        }
    }
}
