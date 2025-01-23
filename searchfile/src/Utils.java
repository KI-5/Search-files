package src;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    /**
     * get the list of files in the directory
     *
     * @param directoryPath - path to the directory
     * @return list of files in the directory
     */
    public static List<File> getFilesInDirectory(String directoryPath) {
        //list to store files
        List<File> fileList = new ArrayList<>();
        //directory
        File directory = new File(directoryPath);

        //check if the directory exists and is a directory
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        fileList.add(file);
                    }
                }
            }
        }

        return fileList;
    }
}
