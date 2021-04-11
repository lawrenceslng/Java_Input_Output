package Java_Input_Output;
/*
 * Read in a CSV file.
 */

import java.io.*;
import java.io.File;

public class CsvReader{

    File csvFile;
    public CsvReader(File csvFile){
        this.csvFile = csvFile;
    }

    public void read() {
        try (BufferedReader in =
                     new BufferedReader(new FileReader(csvFile))) {
            String line;
            while((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle FileNotFoundException, etc. here
        }
    }
}