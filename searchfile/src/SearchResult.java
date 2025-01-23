package src;
public class SearchResult {
    //file name
    private final String fileName;
    //line number
    private final int lineNumber;
    //line content
    private final String lineContent;

    /*parameterised constructor
     * @param fileName - file name
     * @param lineNumber - line number
     * @param lineContent - line content
     */
    public SearchResult(String fileName, int lineNumber, String lineContent) {
        this.fileName = fileName;
        this.lineNumber = lineNumber;
        this.lineContent = lineContent;
    }

    @Override
    public String toString() {
        //return the formatted string
        return String.format("File: %s [Line %d]: %s", fileName, lineNumber, lineContent);
    }
}
