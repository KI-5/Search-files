package src;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        //path to the directory
        String directoryPath = "data"; 
        //keyword to search
        String keyword = "search";    
        //number of threads
        int threadCount = 4;         

        //initialise the executor service
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        //get the list of files in the directory
        List<File> files = Utils.getFilesInDirectory(directoryPath);

        if (files.isEmpty()) {
            System.out.println("No files found in the directory.");
            return;
        }

        //submit tasks to the executor service
        for (File file : files) {
            executor.submit(new FileSearcher(file, keyword));
        }

        //shutdown the executor service
        executor.shutdown();

        //wait until all tasks are completed
        while (!executor.isTerminated()) {
            // Wait until all tasks are done
        }

        System.out.println("Search completed.");
    }
}
